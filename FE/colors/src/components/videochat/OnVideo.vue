<template>
  <div>
    <div class="progress" id="loader">
      <div class="indeterminate"></div>
    </div>
    <div style="position: relative" class="margin">
      <video @loadedmetadata="onPlay(this)" id="inputVideo" autoplay muted playsinline></video>
      <canvas id="overlay"></canvas>
      <canvas id="dummy"></canvas>
      <!-- <canvas id="transp" style="width: 600px"></canvas> -->
    </div>
  </div>
</template>

<script>
import * as faceapi from "face-api.js";
import tinyModel from "@/assets/models/tiny_face_detector_model-weights_manifest.json";
// import { Canvas2Video } from "canvas2video";

let forwardTimes = [];
const SSD_MOBILENETV1 = "ssd_mobilenetv1";
const TINY_FACE_DETECTOR = "tiny_face_detector";

let selectedFaceDetector = TINY_FACE_DETECTOR;

// ssd_mobilenetv1 options
let minConfidence = 0.7;

// tiny_face_detector options
let inputSize = 512;
let scoreThreshold = 0.0;

export default {
  name: "OvVideo",

  props: {
    streamManager: Object,
  },
  data() {
    return {
      tinyFaceModel: tinyModel,
    };
  },

  mounted() {
    this.run();
    this.streamManager.addVideoElement(document.getElementById("inputVideo"));

    // console.log(faceapi.nets);
  },

  methods: {
    updateTimeStats(timeInMs) {
      forwardTimes = [timeInMs].concat(forwardTimes).slice(0, 30);
    },

    async onPlay() {
      const videoEl = document.getElementById("inputVideo");

      // console.log(!this.isFaceDetectionModelLoaded());

      if (videoEl.paused || videoEl.ended || !this.isFaceDetectionModelLoaded()) return setTimeout(() => this.onPlay());

      const options = this.getFaceDetectorOptions();

      const ts = Date.now();

      const result = await faceapi.detectSingleFace(videoEl, options);

      this.updateTimeStats(Date.now() - ts);

      if (result) {
        const canvas = document.getElementById("overlay");
        faceapi.matchDimensions(canvas, videoEl, true);
        // faceapi.draw.drawDetections(canvas, faceapi.resizeResults(result, dims));
        // console.log(result);
        if (canvas.getContext) {
          var ctx = canvas.getContext("2d");
          var box = result._box;
          var center_y = parseInt(box.y + box.height / 2);
          var center_x = parseInt(box.x + box.width / 2);
          // console.log(box);
          var circle = new Path2D();
          var radious = parseInt(box.width / 2);
          circle.moveTo(parseInt(box.x), center_y);
          circle.arc(center_x, center_y, radious, 0, 2 * Math.PI);
          ctx.fillStyle = "#F30";
          ctx.fill(circle);
          // ctx.fillStyle = "#FFF";

          ctx.globalAlpha = 0.2;
          for (var i = 0; i < 20; i++) {
            ctx.beginPath();
            ctx.arc(center_x, center_y, radious + radious * 0.01 * i, 0, Math.PI * 2, true);
            ctx.fill();
          }
          // console.log(canvas);
          // const img = document.getElementById("transp");
          // faceapi.matchDimensions(img, videoEl, true);
          const dummy = document.getElementById("dummy");
          faceapi.matchDimensions(dummy, videoEl, true);
          // var ctx_img = img.getContext("2d");
          // ctx_img.clearRect(0, 0, videoEl.width, videoEl.height);
          let dummy_ctx = dummy.getContext("2d");
          dummy_ctx.drawImage(canvas, 0, 0);
          // Draw the mask
          // ctx_img.drawImage(canvas, 0, 0);

          // Add the original video back in only overwriting the masked pixels
          dummy_ctx.globalCompositeOperation = "source-in";
          dummy_ctx.drawImage(videoEl, 0, 0);
          const frame = dummy_ctx.getImageData(0, 0, canvas.width, canvas.height);
          const length = frame.data.length;
          const data = frame.data;
          for (let i = 0; i < length; i += 4) {
            if (data[i + 3] < 150) {
              data[i] = this.$store.state.r;
              data[i + 1] = this.$store.state.g;
              data[i + 2] = this.$store.state.b;
              if (data[i + 3] < 100) data[i + 3] = 255;
            }
          }
          ctx.putImageData(frame, 0, 0);

          // var video = document.createElement("video");
          // video.addEventListener("play", () => {
          //   var loop = () => {
          //     ctx.putImageData(frame, 0, 0);
          //   };
          //   loop();
          // });
          // video.play();

          // this.streamManager.addVideoElement(video);

          // 지금 안됨..... 이유는 모르겠음
          // Hacker 홈페이지에서 백그라운드 컬러를 주는 방식
          // 그냥 css로 background-color를 주는 방식으로 사용?
          // // Fill green on everything but the mask
          // html canvas tag에서 가지는 globalCompositeOperation 사용
          // ctx_img.globalCompositeOperation = "source-out";
          // ctx_img.fillStyle = "#6667ab";
          // // ctx_img.fill();
          // ctx_img.fillRect(0, 600, videoEl.width, videoEl.height);

          // // Add the original video back in (in image) , but only overwrite missing pixels.
          // ctx_img.globalCompositeOperation = "destination-atop";
          // // ctx_img.drawImage(dummy, 0, 0);
          // videoEl.hidden = true;
          // canvas.hidden = true;
          //   dummy.hidden = "hidden";

          //   this.startCapture();

          //   const cavas_video = document.getElementById("canvas_video");

          //   cavas_video.srcObject = dummy.captureStream();

          //   const mediaStream = await navigator.mediaDevices.getUserMedia({ video: true });
          //   const video = document.createElement("cavas_video");
          //   video.srcObject = mediaStream;

          //   const mediaSource = new MediaSource();
          //   const video = document.createElement("cavas_video");
          //   video.srcObject = mediaSource;
        }
      }
      //   this.streamManager.createVideoElement(document.getElementById("dummy"), "PREPEND");

      //   const video = this.streamManager.createVideoElement(document.getElementById("dummy"));
      //   console.log(video);
      //   this.streamManager.addVideoElement(video);
      setTimeout(() => this.onPlay());

      //   this.streamManager.addVideoElement(document.getElementById("inputVideo"));
    },

    // async startCapture() {
    //   const videoEl = document.getElementById("inputVideo");
    //   try {
    //     HTMLCanvasElement.captureStream = await navigator.mediaDevices.getDisplayMedia({
    //       video: true,
    //       audio: true,
    //     });
    //     console.log(HTMLCanvasElement.captureStream.getVideoTracks()[0].getSettings());
    //     videoEl.srcObject = HTMLCanvasElement.captureStream;
    //   } catch (err) {
    //     console.error(err);
    //   }
    //   return HTMLCanvasElement.captureStream;
    // },

    async run() {
      await this.changeFaceDetector(TINY_FACE_DETECTOR);
      // try to access users webcam and stream the images
      // to the video element
      const stream = await navigator.mediaDevices.getUserMedia({ video: {} });
      const videoEl = document.getElementById("inputVideo");
      videoEl.srcObject = stream;
    },

    getFaceDetectorOptions() {
      return selectedFaceDetector === SSD_MOBILENETV1 ? new faceapi.SsdMobilenetv1Options({ minConfidence }) : new faceapi.TinyFaceDetectorOptions({ inputSize, scoreThreshold });
    },

    getCurrentFaceDetectionNet() {
      if (selectedFaceDetector === SSD_MOBILENETV1) {
        return faceapi.nets.ssdMobilenetv1;
      }
      if (selectedFaceDetector === TINY_FACE_DETECTOR) {
        return faceapi.nets.tinyFaceDetector;
      }
    },

    isFaceDetectionModelLoaded() {
      return !!this.getCurrentFaceDetectionNet().params;
    },

    async requestExternalImage(imageUrl) {
      const res = await fetch("fetch_external_image", {
        method: "post",
        headers: {
          "content-type": "application/json",
        },
        body: JSON.stringify({ imageUrl }),
      });
      if (!(res.status < 400)) {
        console.error(res.status + " : " + (await res.text()));
        throw new Error("failed to fetch image from url: " + imageUrl);
      }

      let blob;
      try {
        blob = await res.blob();
        return await faceapi.bufferToImage(blob);
      } catch (e) {
        console.error("received blob:", blob);
        console.error("error:", e);
        throw new Error("failed to load image from url: " + imageUrl);
      }
    },

    addAlpha(imageData, gFloor = 105, rbCeiling = 80) {
      const { data } = imageData;

      for (let r = 0, g = 1, b = 2, a = 3; a < data.length; r += 4, g += 4, b += 4, a += 4) {
        if (data[r] <= rbCeiling && data[b] <= rbCeiling && data[g] >= gFloor) data[a] = 0;
      }
      return imageData;
    },
    async changeFaceDetector(detector) {
      selectedFaceDetector = detector;
      if (!this.isFaceDetectionModelLoaded()) {
        // console.log(this.getCurrentFaceDetectionNet());
        // await this.getCurrentFaceDetectionNet().loadFromUri("../../assets/models");
        // 파일을 로컬에서 불러올 수 없어서 로컬 http 서버에서 해당 파일을 읽어올 수 있도록 만듬
        const Model_URL = "http://127.0.0.1:8080/";
        await faceapi.loadTinyFaceDetectorModel(Model_URL);
      }
    },
  },
};
</script>

<style scoped>
#overlay,
.overlay,
#dummy {
  position: absolute;
  top: 0;
  left: 0;
  text-align: center;
  width: 100%;
}

/* our */
#inputVideo {
  width: 100%;
  border-radius: 10px;
}
</style>
