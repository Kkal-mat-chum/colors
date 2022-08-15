<template>
  <div>
    <div class="progress" id="loader">
      <div class="indeterminate"></div>
    </div>
    <div style="position: relative" class="margin">
      <video @loadedmetadata="onPlay(this)" id="inputVideo" autoplay muted playsinline></video>
      <canvas id="overlay"></canvas>
      <canvas id="dummy"></canvas>
      <canvas id="filter"></canvas>
    </div>
  </div>
</template>

<script>
import * as faceapi from "face-api.js";

let forwardTimes = [];
const SSD_MOBILENETV1 = "ssd_mobilenetv1";
const TINY_FACE_DETECTOR = "tiny_face_detector";

let selectedFaceDetector = TINY_FACE_DETECTOR;

// ssd_mobilenetv1 options
let minConfidence = 0.6;

// tiny_face_detector options
let inputSize = 512;
let scoreThreshold = 0.00001;

export default {
  name: "OvVideo",

  props: {
    streamManager: Object,
    color: Object,
  },
  data() {
    return {};
  },
  created() {
    const videoEl = document.getElementById("inputVideo");
    const overlay = document.getElementById("overlay");
    const filter = document.getElementById("filter");
    const dummy = document.getElementById("dummy");
    console.log(videoEl, overlay, filter, dummy);
    // faceapi.matchDimensions(overlay, videoEl, true);
    // faceapi.matchDimensions(filter, videoEl, true);
    // faceapi.matchDimensions(dummy, videoEl, true);
    // dummy.hidden = "hidden";
  },
  mounted() {
    this.run();
    this.streamManager.addVideoElement(document.getElementById("inputVideo"));
    // console.log(faceapi.nets);

    this.$emit("changeStreamTrack");
  },

  methods: {
    updateTimeStats(timeInMs) {
      forwardTimes = [timeInMs].concat(forwardTimes).slice(0, 30);
    },
    changeFilter(ctx, box) {
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
      this.$emit("changeStreamTrack");
    },
    applyBGColor(frame) {
      const length = frame.data.length;
      const data = frame.data;
      for (let i = 0; i < length; i += 4) {
        if (data[i + 3] < 150) {
          data[i] = this.$store.state.r;
          data[i + 1] = this.$store.state.g;
          data[i + 2] = this.$store.state.b;
          if (data[i + 3] < 130) data[i + 3] = 255;
        }
      }
    },
    applyFilter() {},

    async onPlay() {
      const videoEl = document.getElementById("inputVideo");
      const overlay = document.getElementById("overlay");
      const filter = document.getElementById("filter");
      const dummy = document.getElementById("dummy");
      dummy.hidden = "hidden";
      filter.hidden = "hidden";
      // overlay.hidden = "hidden";
      // console.log(!this.isFaceDetectionModelLoaded());

      if (videoEl.paused || videoEl.ended || !this.isFaceDetectionModelLoaded()) return setTimeout(() => this.onPlay());

      const options = this.getFaceDetectorOptions();

      const ts = Date.now();

      const result = await faceapi.detectSingleFace(videoEl, options);
      // console.log(selectedFaceDetector);

      this.updateTimeStats(Date.now() - ts);

      if (result) {
        if (result.score > 0.3) {
          faceapi.matchDimensions(filter, videoEl, true);
          if (filter.getContext) {
            var ctx_filter = filter.getContext("2d");
            this.changeFilter(ctx_filter, result.box);
          }
        } else {
          // console.log(result.score);
        }
        faceapi.matchDimensions(overlay, videoEl, true);
        faceapi.matchDimensions(dummy, videoEl, true);
      }
      if (overlay.getContext) {
        var ctx_overlay = overlay.getContext("2d");
        let dummy_ctx = dummy.getContext("2d");
        dummy_ctx.drawImage(filter, 0, 0);
        dummy_ctx.globalCompositeOperation = "source-in";
        dummy_ctx.drawImage(videoEl, 0, 0);
        const frame = dummy_ctx.getImageData(0, 0, overlay.width, overlay.height);
        this.applyBGColor(frame);
        ctx_overlay.putImageData(frame, 0, 0);
      }

      setTimeout(() => this.onPlay());
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
        const Model_URL = "https://ssafy7color.s3.ap-northeast-2.amazonaws.com/weights/";
        await this.getCurrentFaceDetectionNet().load(Model_URL);
      }
    },
  },
};
</script>

<style scoped>
#overlay,
.overlay {
  position: absolute;
  top: 0;
  left: 0;
  text-align: center;
}
/* our */
#inputVideo {
  width: 100%;
  border-radius: 10px;
}
#overlay {
  width: 100%;
  border-radius: 10px;
}
</style>
