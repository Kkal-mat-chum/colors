<template>
  <div>
    <div class="progress" id="loader">
      <div class="indeterminate"></div>
    </div>
    <div style="position: relative" class="margin">
      <video @loadedmetadata="onPlay(this)" id="inputVideo" autoplay muted playsinline style="width: 500px"></video>
      <canvas id="overlay" style="width: 500px"></canvas>
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
let scoreThreshold = 0.5;

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

      if (videoEl.paused || videoEl.ended || !this.isFaceDetectionModelLoaded()) return setTimeout(() => this.onPlay());

      const options = this.getFaceDetectorOptions();

      const ts = Date.now();

      // console.log(ts);

      const result = await faceapi.detectSingleFace(videoEl, options);

      this.updateTimeStats(Date.now() - ts);

      if (result) {
        const canvas = document.getElementById("overlay");
        const dims = faceapi.matchDimensions(canvas, videoEl, true);
        faceapi.draw.drawDetections(canvas, faceapi.resizeResults(result, dims));
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
        console.log(faceapi.nets);
        return faceapi.nets.ssdMobilenetv1;
      }
      if (selectedFaceDetector === TINY_FACE_DETECTOR) {
        // console.log(faceapi.nets);
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
        // await this.getCurrentFaceDetectionNet().loadFromUri("assets/models");
        const Model_URL = "http://192.168.25.7:8081/models/";
        await faceapi.loadTinyFaceDetectorModel(Model_URL);
      }
    },
  },
};
</script>

<style scoped>
.page-container {
  left: 0;
  right: 0;
  margin: auto;
  margin-top: 20px;
  padding-left: 280px;
  display: inline-flex !important;
}

@media only screen and (max-width: 992px) {
  .page-container {
    padding-left: 0;
    display: flex !important;
  }
}

#navbar {
  position: absolute;
  top: 20px;
  left: 20px;
}

.center-content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

.side-by-side {
  display: flex;
  justify-content: center;
  align-items: center;
}
.side-by-side > * {
  margin: 0 5px;
}

.bold {
  font-weight: bold;
}

.margin-sm {
  margin: 5px;
}

.margin {
  margin: 20px;
}

.button-sm {
  padding: 0 10px !important;
}

.pad-sides-sm {
  padding: 0 8px !important;
}

#github-link {
  display: flex !important;
  justify-content: center;
  align-items: center;
  border-bottom: 1px solid;
  margin-bottom: 10px;
}

#overlay,
.overlay {
  position: absolute;
  top: 0;
  left: 0;
}

#facesContainer canvas {
  margin: 10px;
}

input[type="file"]::-webkit-file-upload-button {
  background: #26a69a;
  border: 1px solid gray;
  cursor: pointer;
  color: #fff;
  border-radius: 0.2em;
}

/* our */
#inputVideo {
  width: 100%;
  border-radius: 10px;
}
</style>
