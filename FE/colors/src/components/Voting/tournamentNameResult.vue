<template>
  <div class="tournamentResultBody">
    <custom-sidebar></custom-sidebar>
    <div class="mainPicture">
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture1" />
      <div class="titleColor">
        #DDDDDD
        <div>컬러네임</div>
      </div>
    </div>
    <div class="lineFlex">
      <hr class="line1" />
    </div>
    <hr class="line2" />
    <div class="lineFlex2">
      <hr class="line1" />
      <hr class="line1" />
    </div>
    <div class="secondPictures">
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture2" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture2" />
    </div>
    <div class="lineFlex3">
      <hr class="line1" />
      <hr class="line1" />
    </div>
    <div class="lineFlex3">
      <hr class="line4" />
      <hr class="line4" />
    </div>
    <div class="lineFlex3">
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
    </div>
    <div class="thirdPictures">
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
    </div>
    <div class="lineFlex4">
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
    </div>
    <div class="lineFlex3">
      <hr class="line6" />
      <hr class="line6" />
      <hr class="line6" />
      <hr class="line6" />
    </div>
    <div class="lineFlex4">
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
    </div>
    <div class="firthPictures">
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
    </div>
    <div class="button">
      <custom-button btnText="닫 기" class="buttonStyle"></custom-button>
    </div>
    <div class="ment">최근 색상 정보는 마이페이지에서 확인하실 수 있습니다.</div>
  </div>
</template>

<script>
import customSidebar from "../common/customSidebar.vue";

export default {
  components: { customSidebar },
};
</script>

<style scoped>
.tournamentResultBody {
  display: block;
  justify-content: center;
  margin: 0 15% 0 15%;
}
.mainPicture {
  margin-top: 4%;
}
.picture1 {
  width: 250px;
  height: 100px;
}
.titleColor {
  font-weight: 400;
  font-size: 30px;
  color: #4a4c74;
}
.line1 {
  display: flex;
  width: 18px;
  height: 5px;
  background-color: #aaaabc;
  transform: rotate(90deg);
}
.lineFlex {
  display: flex;
  justify-content: center;
}
.line2 {
  width: 540px;
  height: 5px;
  background-color: #aaaabc;
  margin-top: -1px;
}
.line4 {
  width: 270px;
  height: 5px;
  background-color: #aaaabc;
  margin-top: -2px;
}
.line6 {
  width: 141px;
  height: 5px;
  background-color: #aaaabc;
  margin-top: -2px;
}
.lineFlex2 {
  display: flex;
  flex-direction: row;
  margin-top: -16px;
}
.lineFlex3 {
  display: flex;
  flex-direction: row;
  margin-top: 0px;
}
.lineFlex4 {
  display: flex;
  flex-direction: row;
  margin-top: 15px;
}
.secondPictures {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.thirdPictures {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.firthPictures {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-top: -8px;
}
.picture2 {
  width: 120px;
  height: 88px;
  border-radius: 20px;
}
.line5 {
  display: flex;
  width: 18px;
  height: 5px;
  background-color: #aaaabc;
  transform: rotate(90deg);
  margin-top: -8px;
}
.line7 {
  width: 18px;
  height: 5px;
  background-color: #aaaabc;
  transform: rotate(90deg);
  margin-top: -22px;
}
.picture3 {
  width: 120px;
  height: 88px;
  border-radius: 20px;
}
.button {
  display: flex;
  justify-content: right;
  margin-top: 2%;
  margin-right: 4%;
}
.buttonStyle {
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
  margin-right: 37px;
  margin-top: 1%;
  font-weight: 400;
  font-size: 15px;
  color: #aaaabc;
}
div.clickEffect {
  position: fixed;
  box-sizing: border-box;
  border-style: solid;
  border-color: #000000;
  border-radius: 50%;
  animation: clickEffect 0.4s ease-out;
  z-index: 99999;
}
div.clickEffect {
  position: fixed;
  box-sizing: border-box;
  border-style: solid;
  border-color: #aaaabc;
  border-radius: 50%;
  animation: clickEffect 0.4s ease-out;
  z-index: 999999;
}
</style>
