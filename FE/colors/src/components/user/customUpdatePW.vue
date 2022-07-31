<template>
  <div class="customUpdatePWPage">
    <div class="updatePW1">
      <div class="titleUpdatePW">비밀번호 변경</div>
      <hr class="updatePWhystyle" />
    </div>
    <div class="updatePW2">
      <div class="dummyMarginUpdatePW1"></div>
      <div class="updatePWLabels">
        <label for="updatePWInputFirst" class="updatePWLabel">비밀번호</label>
        <label for="updatePWInputSecond" class="updatePWLabel">비밀번호 확인</label>
      </div>
      <div class="updatePWInputs">
        <input type="password" class="updatePWinput" id="updatePWInputFirst" placeholder="영문, 숫자 포함 8자리 이상입니다." />
        <input type="password" class="updatePWinput" id="updatePWInputSecond" placeholder="비밀번호를 다시 한 번 입력해주세요." />
      </div>
      <div class="dummyMarginUpdatePW2"></div>
    </div>
    <div class="updatePW3">
      <div class="dummyMarginUpdatePW3"></div>
      <customButton class="updatePWCheckBtn" id="updatePWCheckBtn" btnText="확 인" @click="testClick">testButton</customButton>
      <customButton class="updatePWCancleBtn" id="updatePWCancleBtn" btnText="취 소" @click="testClick">testButton</customButton>
    </div>
  </div>
</template>

<script>
export default {
  // data() {
  //   return {
  //     showModal: false,
  //   };
  // },
  // methods: {
  //   testClick() {
  //     console.log("clicked");
  //   },
  // },
};
</script>

<style>
body {
  margin: 0;
}
.customUpdatePWPage {
  position: absolute;
  display: flex;
  flex-direction: column;
  width: 537.75px;
  height: 450px;
  /* width: 35%;
  height: 75%; */
  left: 399px;
  top: 117px;
  border: 10px solid #000000;
  border-radius: 10px;
}
.titleUpdatePW {
  margin-top: 13%;
  margin-left: 10%;
  font-size: 150%;
  font-weight: 900;
  color: #6667ab;
}
.updatePWhystyle {
  width: 35%;
  height: 1px;
  background-color: #d0d1ff;
  position: absolute;
  /* margin-top: 15%; */
  margin-left: 10%;
}
.updatePW1 {
  height: 30%;
  text-align: left;
}
.updatePW2 {
  height: 30%;
  display: flex;
  flex-direction: row;
}
.updatePW3 {
  height: 40%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.updatePWLabels {
  width: 22%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  text-align: left;
}
.updatePWLabel {
  width: 100%;
  display: inline-block;
  font-size: 17px;
}
.updatePWInputs {
  width: 43%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  font-size: 17px;
}
.updatePWinput[type="password"] {
  width: 100%;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
  padding: 10px 5px;
}
.dummyMarginUpdatePW1 {
  width: 15%;
}
.dummyMarginUpdatePW2 {
  width: 20%;
}
.dummyMarginUpdatePW3 {
  height: 10%;
}
#updatePWCheckBtn {
  margin-top: 1%;
  width: 70%;
  color: red;
}
#updatePWCancleBtn {
  margin-top: 2%;
  width: 70%;
}
</style>
