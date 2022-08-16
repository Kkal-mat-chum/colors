<template>
  <div>
    <div class="jb-box">
      <video muted autoplay loop>
        <source src="@/assets/videos/main-video-01.mp4" type="video/mp4" />
        <strong>Your browser does not support the video tag.</strong>
      </video>
      <div class="jb-text">
        <p>깔 맞 춤</p>
      </div>
    </div>
    <main-info></main-info>
  </div>
</template>

<script>
import MainInfo from "@/components/main/MainInfo.vue";
export default {
  name: "mainView",
  components: {
    MainInfo,
  },
  data() {
    return {};
  },
  created() {
    this.$store.commit("CLEAN_VIDEOS");
  },
};
</script>

<style scoped>
.jb-box {
  width: 100%;
  height: 92.2vh;
  overflow: hidden;
  margin: 0px auto;
  position: relative;
}
video {
  width: 100%;
}
.jb-text {
  font-family: "Pretendard";
  position: absolute;
  top: 50%;
  width: 100%;
}
.jb-text p {
  font-family: "Pretendard";
  margin-top: -24px;
  text-align: center;
  font-size: 48px;
  color: #ffffff;
}
</style>
