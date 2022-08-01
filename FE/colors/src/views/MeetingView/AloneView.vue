<template>
  <div class="aloneMeeting">
    <sidebar></sidebar>
    <div class="contents">
      <div class="camera">
        <webcam class="webcam"></webcam>
        <div class="buttons">
          <customButton class="mute" btnText="음소거"></customButton>
          <customButton class="videostop" btnText="비디오 중지"></customButton>
        </div>
      </div>
      <div class="rightSidebar">
        <div class="title">
          <h2>나만의 색상 팔레트</h2>
          <hr />
        </div>
        <colorpallete class="pallete"></colorpallete>
        <div class="selectColor"></div>
        <customButton class="selectColorbtn" btnText="색상 팔레트에 담기"></customButton>
        <customButton class="votebtn" btnText="투표하기"></customButton>
        <customButton class="exitbtn" btnText="종료"></customButton>
      </div>
    </div>
  </div>
</template>

<script>
import sidebar from "@/components/common/customSidebar.vue";
import webcam from "@/components/videoChat/webcamStream.vue";
import colorpallete from "@/components/myPage/colorPallete.vue";
import "../../components/videoChat/colorChoice.js";

export default {
  name: "aloneMeeting",
  components: {
    sidebar,
    webcam,
    colorpallete,
  },
};

colorpicker.show(
  {
    left: pos.left,
    top: pos.bottom,
    hideDelay: 2000, // 컬러피커가 열렸다가 숨겨질 타이밍을 지정합니다. 기본값은 2000 (2초)
  },
  color,
  function (newColor) {
    console.log(newColor);
  }
);
</script>

<style scoped>
html,
body {
  height: 100vh;
  overflow: hidden;
}
.contents {
  display: flex;
  margin-left: 120px;
  height: 100%;
}
.camera {
  width: 75%;
  text-align: center;
}
.webcam {
  display: inline-block;
  width: 500px;
  height: 300px;
  margin-top: 150px;
  border: 2px solid #d0d1ff;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
.buttons {
  margin-top: 50px;
}
.mute {
  width: 150px;
  margin-right: 20px;
}
.videostop {
  width: 150px;
}
.rightSidebar {
  width: 25%;
  height: 100vh;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
  text-align: center;
}
.title {
  margin-left: 50px;
}
.title h2 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 30px 0 10px 0;
}

.title > hr {
  display: flex;
  width: 200px;
  margin: 0;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}

.pallete {
  display: inline-block;
  margin-top: 20px;
}

.selectColor {
  display: inline-block;
  width: 200px;
  height: 200px;
  background-color: #d0d1ff;
  margin-top: 25px;
}

.selectColorbtn {
  width: 200px;
  margin-top: 8px;
}

.votebtn {
  margin-top: 120px;
  width: 200px;
}
.exitbtn {
  width: 200px;
  margin-top: 10px;
}
</style>
