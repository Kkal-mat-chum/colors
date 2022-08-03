<template>
  <div class="resultBody">
    <custom-sidebar></custom-sidebar>
    <h1 class="title">이름 님과 가장 잘 어울리는 색상은?</h1>
    <div class="mainResult">
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture1" />
      <div class="colorMatchName">
        <div class="codeNum">#000000</div>
        <div>색상 이름</div>
      </div>
    </div>
    <div class="myPick">
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture2" />
      <div class="myColorPick">
        <div class="myPickName">이름 님의 픽</div>
        <div class="myPickCode">#b8991</div>
      </div>
    </div>
    <div class="otherPickTitle">
      <div class="otherTitle">참여자들이 추천한 색상</div>
    </div>
    <div class="otherPick">
      <div>
        <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
        <div class="otherName">이름</div>
        <div class="otherCode">#BBBBBB</div>
      </div>
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
    </div>
    <div class="cancelButton">
      <custom-button id="buttonStyle" btnText="닫 기"></custom-button>
    </div>
    <div class="ment">최근 색상 정보는 마이페이지에서 확인하실 수 있습니다.</div>
  </div>
</template>

<script>
import customButton from "../common/customButton.vue";
export default {
  components: {
    customButton,
  },
};
</script>

<style scoped>
.title {
  font-family: "Pretendard";
  font-style: normal;
  font-size: 36px;
  color: #4a4d74;
}
.resultBody {
  display: block;
  justify-content: center;
  margin: 0 15% 0 15%;
}
.mainResult {
  display: flex;
  flex-direction: row;
  margin-top: 4%;
  margin-left: 20%;
  width: 884px;
  height: 220px;
}
.otherPick {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  flex-direction: row;
  margin-top: 2%;
}
.otherPickTitle {
  display: flex;
  justify-content: center;
  margin-top: 3%;
}
.picture1 {
  width: 250px;
  height: 150px;
}
.colorMatchName {
  width: 35%;
  margin-top: 2%;
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 700;
  font-size: 50px;
  line-height: 50px;
  color: #ffd5d1;
}
.myPickName {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
  font-size: 36px;
  color: #4a4d74;
}
.myPick {
  display: flex;
  flex-direction: row;
  margin-left: 30%;
  margin-top: -4%;
}
.picture2 {
  width: 200px;
  height: 100px;
}
.picture3 {
  width: 150px;
  height: 80px;
}
.myColorPick {
  margin-left: 5%;
}
.myPickCode {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
  font-size: 36px;
  color: #ffd5d1;
  margin-left: 5%;
}
.otherTitle {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 600;
  font-size: 32px;
  color: #aaaabc;
}
.otherName {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
  font-size: 36px;
  color: #4a4d74;
}
.otherCode {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
  font-size: 30px;
  color: #b7b1ff;
}
.cancelButton {
  display: flex;
  flex-direction: row-reverse;
  margin-right: 10%;
}
#buttonStyle {
  font-size: 15px;
  width: 15%;
  color: #ff0000;
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
}
.ment {
  display: flex;
  justify-content: right;
  font-family: "Pretendard";
  font-style: normal;
  margin-right: 10%;
  margin-top: 1%;
  font-weight: 400;
  font-size: 15px;
  color: #aaaabc;
}
</style>
