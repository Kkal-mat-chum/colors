<template>
  <div>
    <div class="progress" id="loader">
      <div class="indeterminate"></div>
    </div>
    <div style="position: relative" class="margin">
      <video @loadedmetadata="onPlay(this)" id="inputVideo" autoplay muted playsinline></video>
      <canvas id="overlay" style="width: 600px"></canvas>
    </div>
  </div>
</template>

<script>
import * as faceapi from "face-api.js";
import tinyModel from "@/assets/models/tiny_face_detector_model-weights_manifest.json";

let forwardTimes = [];
const SSD_MOBILENETV1 = "ssd_mobilenetv1";
const TINY_FACE_DETECTOR = "tiny_face_detector";

let selectedFaceDetector = TINY_FACE_DETECTOR;

// ssd_mobilenetv1 options
let minConfidence = 0.7;

// tiny_face_detector options
let inputSize = 512;
let scoreThreshold = 0.1;

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
        const dims = faceapi.matchDimensions(canvas, videoEl, true);
        console.log(dims);
        // faceapi.draw.drawDetections(canvas, faceapi.resizeResults(result, dims));
        console.log(result);
        if (canvas.getContext) {
          var ctx = canvas.getContext("2d");
          var box = result._box;
          var center_y = parseInt(box.y + box.height / 2);
          var center_x = parseInt(box.x + box.width / 2);
          // console.log(box);
          var circle = new Path2D();
          circle.moveTo(parseInt(box.x), center_y);
          circle.arc(center_x, center_y, parseInt(box.height / 2), 0, 2 * Math.PI);
          ctx.fill(circle);
        }
      }

      setTimeout(() => this.onPlay());
    },

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
    async changeFaceDetector(detector) {
      selectedFaceDetector = detector;
      if (!this.isFaceDetectionModelLoaded()) {
        // console.log(this.getCurrentFaceDetectionNet());
        // await this.getCurrentFaceDetectionNet().loadFromUri("../../assets/models");
        // 파일을 로컬에서 불러올 수 없어서 로컬 http 서버에서 해당 파일을 읽어올 수 있도록 만듬
<<<<<<< HEAD
        const Model_URL = "http://192.168.31.87:8081/";
=======
        const Model_URL = "http://127.0.0.1:8081/";
>>>>>>> 898e94dce6d38bffaf4e62ccc6a29e470130d0e5
        await faceapi.loadTinyFaceDetectorModel(Model_URL);
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
</style>
