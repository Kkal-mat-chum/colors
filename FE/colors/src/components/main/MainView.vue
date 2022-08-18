<template>
  <div>
    <header>
      <a href="#top"><img src="../../assets/mainLogo.png" class="navImg" alt="" /></a>
      <b class="navName" data-text="깔맞춤">깔맞춤</b>
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
  height: 50px;
  padding: 1rem;
  z-index: 100;
  /* color: #9292a33f; */
  font-weight: bold;
  display: flex;
  /* justify-content: space-between; */
  align-items: center;
  font-family: "Pretendard";
  flex-direction: row;
  background: linear-gradient(to bottom, #646491dc, #ffffff00);
  /* background-color: #8e8ec22e; */
}
.jb-box {
  width: 97.35%;
  height: 100vh;
  overflow: hidden;
  margin: 0px 0px 0px 0px;
  position: relative;
  border-width: 20px;
  /* border-color: #8484a13d; */
  background-color: #444444;
  border-image: linear-gradient(to right, #fdff8b, #ff99e7, #9ae2ff);
  border-image-slice: 1;
  border-style: solid;
  border-radius: 5px;
  box-shadow: 5px 1px 40px 10px;
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
  /* font-size: large; */
  font-weight: 600;
  font-size: 14px;
  font-display: center;
  border-color: #ffffff00;
}
.navName {
  font-size: larger;
  height: 17px;
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
  /* text-shadow: 0px 0px 20px rgba(255, 255, 255, 0.066); */
  /* text-shadow: 0px 0px 30px rgba(255, 255, 255, 1), 0px 0px 15px rgba(255, 255, 255, 1), 0px 0px 5px rgba(255, 255, 255, 1); */
  background: linear-gradient(to right bottom, #ff59d8 20%, #6667ab, #6ed4ff);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  /* filter: drop-shadow(0px 3px rgba(255, 255, 255, 0.484)); */
}
.navName:after {
  /* width: 1000px; */
  background: none;
  content: attr(data-text);
  left: 0;
  position: absolute;
  text-shadow: 0px 0px 10px rgb(255, 255, 255), 0px 0px 5px rgb(255, 255, 255);
  top: 0;
  z-index: -1;
  /* margin-left: 72px;
  margin-top: 18px; */
  margin-left: 68.8px;
  margin-top: 17px;
  font-size: 33.8px;
  /* height: 38px; */
}
</style>
