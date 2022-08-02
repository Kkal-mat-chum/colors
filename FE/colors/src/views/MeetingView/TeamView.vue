<template>
  <div class="aloneMeeting">
    <sidebar></sidebar>
    <div class="contents">
      <div class="camera">
        <webcam class="webcam"></webcam>
        <div class="name">송 다 경</div>
        <div class="buttons">
          <customButton class="mute" btnText="음소거"></customButton>
          <customButton class="videostop" btnText="비디오 중지"></customButton>
        </div>

        <div class="anotherPerson">
          <div class="p1">
            <webcam class="webcam1"></webcam>
            <div class="name">이 한 기</div>
          </div>
          <div class="p2">
            <webcam class="webcam2"></webcam>
            <div class="name">김 찬 일</div>
          </div>
          <div class="p3">
            <webcam class="webcam3"></webcam>
            <div class="name">김 민 영</div>
          </div>
          <div class="p4">
            <webcam class="webcam4"></webcam>
            <div class="name">오 정 환</div>
          </div>
          <div class="p5">
            <webcam class="webcam5"></webcam>
            <div class="name">강 민 성</div>
          </div>
        </div>
      </div>
      <div class="rightSidebar">
        <div class="title">
          <h2>나만의 색상 팔레트</h2>
          <hr />
        </div>
        <colorpallete class="pallete"></colorpallete>
        <div class="selectColor">
          <colorchoice></colorchoice>
        </div>
        <customButton class="selectColorbtn" btnText="색상 팔레트에 담기"></customButton>
        <div class="title">
          <h2>미팅 코드</h2>
          <hr />
        </div>
        <h2 class="code">A1ABEF13</h2>
        <customButton class="btn" btnText="채팅"></customButton>
        <customButton class="btn" btnText="투표하기"></customButton>
        <customButton class="btn" btnText="종료"></customButton>
      </div>
    </div>
  </div>
</template>

<script>
import sidebar from "@/components/common/customSidebar.vue";
import webcam from "@/components/videochat/webcamStream.vue";
import colorpallete from "@/components/myPage/colorPallete.vue";
import colorchoice from "@/components/videochat/colorPallete/colorChoice.vue";

export default {
  name: "aloneMeeting",
  components: {
    sidebar,
    webcam,
    colorpallete,
    colorchoice,
  },
};
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
  height: 100vh;
}
.camera {
  width: 155vh;
  text-align: center;
}
.webcam {
  display: inline-block;
  width: 400px;
  height: 250px;
  margin-top: 30px;
  border: 2px solid #d0d1ff;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
.name {
  margin-top: 5px;
}
.buttons {
  margin-top: 8px;
}
.mute {
  width: 150px;
  margin-right: 20px;
}
.videostop {
  width: 150px;
}

/* 참여자들 캠 */
.anotherPerson {
  margin-top: 20px;
}
.p1,
.p2,
.p3,
.p4,
.p5 {
  display: inline-block;
}
.webcam1,
.webcam2,
.webcam3,
.webcam4,
.webcam5 {
  width: 250px;
  height: 160px;
  margin: 10px 20px 10px 20px;
  border: 2px solid #d0d1ff;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}

/* 우측 사이드 바 */
.rightSidebar {
  width: 40vh;
  height: 100vh;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
  text-align: center;
}
.title {
  margin-left: 5vh;
}
.title h2 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 23px 0 10px 0;
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
  background-color: #d0d1ff;
  margin-top: 25px;
}

.selectColorbtn {
  width: 200px;
  margin-top: 20px;
}

.code {
  margin: 10px;
}

.btn {
  width: 200px;
  margin-top: 15px;
}
</style>
