<template>
  <div>
    <header>
      <a href="#top"><img src="../../assets/mainLogo.png" class="navImg" alt="" /></a>
      <b class="navName">깔맞춤</b>
      <customButton id="btnStyle" @click="login" btnText="시작하기"></customButton>
    </header>
    <div class="jb-box">
      <video muted autoplay loop>
        <source src="@/assets/videos/main-video-01.mp4" type="video/mp4" />
        <strong>Your browser does not support the video tag.</strong>
      </video>
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
  methods: {
    login() {
      this.$router.push("/login");
    },
    reload() {
      this.$router.go();
    },
  },
};
</script>

<style scoped>
.navImg {
  width: 50px;
}
header {
  position: fixed;
  top: 0px;
  left: 0px;
  right: 0;
  height: 10px;
  padding: 1rem;
  z-index: 100;
  color: #a8a8bf68;
  font-weight: bold;
  display: flex;
  /* justify-content: space-between; */
  align-items: center;
  font-family: "Pretendard";
  flex-direction: row;
  background-color: #d0d1ffcc;
}
.jb-box {
  width: 99.3%;
  height: 100vh;
  overflow: hidden;
  margin: 0px 0px 0px 0px;
  position: relative;
  border-width: 5px;
  border-color: #6667ab;
  border-style: solid;
  border-radius: 5px;
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
#btnStyle {
  display: flex;
  justify-content: right;
  margin-left: 83%;
}
.navName {
  font-size: larger;
  height: 10px;
  padding: 1rem;
  font-weight: bold;
  display: flex;
  font-size: 32px;
  margin-top: -30px;
  margin-left: -10px;
  color: #6667ab;
  /* text-shadow: -1px 0px white 0px 1px white 1px 0px white 0px 1px white; */
  /* -webkit-text-stroke: 0.5px white; */
  /* text-stroke: 1px white; */
  /* text-shadow: 2px 0px #eeeeee, 0px 2px #eeeeee, 0px -2px #eeeeee, -2px 0px #eeeeee; */
  text-shadow: 0px 0px 30px rgba(255, 255, 255, 1), 0px 0px 15px rgba(255, 255, 255, 1);
}
</style>
