<template>
  <div class="signUpPage">
    <div class="signUp1">
      <div class="signUpWord">
        <div class="signUptitle">회원 가입</div>
        <hr class="signUphrStyle" />
      </div>
      <div class="userInfo">
        <div class="textBox">
          <div class="labelBoxs">
            <label for="idLabel" class="userlabel">아이디</label><br />
            <label for="pwLabel" class="userlabel">비밀번호</label><br />
            <label for="pwcheckLabel" class="userlabel">비밀번호 확인</label><br />
            <label for="nameLabel" class="userlabel">이름</label><br />
            <label for="nickLabel" class="userlabel">닉네임</label><br />
            <label for="emailLabel" class="userlabel">이메일</label><br />
            <label for="emailcheckLabel" class="userlabel">이메일 확인</label>
          </div>
          <div class="inputBoxs">
            <input type="text" class="userInput" id="idLabel" placeholder="영문 숫자 포함 6자리 이상" /><br />
            <input type="text" class="userInput" id="pwLabel" placeholder="영문 숫자 포함 8자리 이상" /><br />
            <input type="text" class="userInput" id="pwcheckLabel" placeholder="다시 입력해주세요." /><br />
            <input type="text" class="userInput" id="nameLabel" placeholder="이름을 입력해주세요." /><br />
            <input type="text" class="userInput" id="nickLabel" placeholder="닉네임을 입력해주세요." /><br />
            <input type="text" class="userInput" id="emailLabel" placeholder="이메일을 입력해주세요" /><br />
            <input type="text" class="userInput" id="emailcheckLabel" placeholder="전송된 인증 번호를 입력하세요." />
          </div>
          <div class="inputCheckBoxs">
            <customButton class="signUpIDCheckBtn" id="signUpIDCheckBtn" btnText="중복 확인" @click="testClick">testButton</customButton>
            <div class="dummyMarginSignUp1"></div>
            <customButton class="signUpnickCheckBtn" id="signUpnickCheckBtn" btnText="중복 확인" @click="testClick">testButton</customButton>
            <customButton class="signUpEmailCheckBtn" id="signUpEmailCheckBtn" btnText="이메일 인증" @click="testClick">testButton</customButton>
            <div class="dummyMarginSignUp2"></div>
          </div>
        </div>
        <div class="signUpFinalCheck">
          <div class="dummyMarginSignUp3"></div>
          <customButton class="signUpFinalCheckBtn" id="signUpFinalCheckBtn" btnText="회원 가입" @click="testClick">testButton</customButton>
          <div class="dummyMarginSignUp4"></div>
        </div>
      </div>
    </div>
    <div class="signUp2">
      <img src="../../assets/join_img1.png" alt="join_img" class="join_img" />
      <img src="../../assets/logo_with_slogan.png" alt="logo & slogan" class="logoSlogan" />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
body {
  margin: 0;
}
.signUptitle {
  position: absolute;
  width: 100%;
  display: grid;
  justify-content: left;
  margin-left: 5%;
}
.signUpPage {
  position: absolute;
  width: 80%;
  height: 100%;
  display: block;
  box-sizing: inherit;
  -webkit-text-size-adjust: 100%;
  margin: 0 10% 0 10%;
}
.signUp1 {
  display: grid;
  position: relative;
  width: 50%;
  height: 100%;
  left: 0px;
  top: 0px;
  background: white;
  justify-content: left;
  box-shadow: 10px 1px 10px rgba(168, 168, 168, 0.4);
}
.signUp2 {
  position: absolute;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: 100%;
  right: 0px;
  top: 0px;
}
.signUpWord {
  margin-left: 5%;
  position: absolute;
  top: 15%;
  left: 0;
  color: #6667ab;
  font-weight: 900;
  font-size: 150%;
  width: 100%;
}
.signUphrStyle {
  width: 40%;
  position: absolute;
  height: 1px;
  margin: 33px 0 0 5%;
  background-color: #d0d1ff;
}
.userInfo {
  position: absolute;
  top: 25%;
  left: 10%;
  width: 90%;
}
label {
  color: #6667ab;
  font-size: 0.95rem;
  font-weight: 600;
  /* padding-bottom: 50px; */
  /* margin-bottom: 100px; */
}
.inputBox[type="text"] {
  width: 70%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
.textBox {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: left;
}
.labelBoxs {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  text-align: left;
  width: 20%;
}
.inputBoxs {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  width: 50%;
}
.inputCheckBoxs {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
button {
  width: 100%;
  /* margin-left: 20px; */
  margin-bottom: 1em;
  margin-left: 10px;
  padding: 5px 0px;
  border-radius: 5px;
  border-color: #d0d1ff;
  background-color: white;
  color: #6667ab;
}
/* inputBox class */
.userInput[type="text"] {
  width: 90%;
  /* margin-left: 20px; */
  /* margin-bottom: 14px; */
  padding: 10px 5px;
  border-radius: 5px;
  /* border-color: #d0d1ff; */
  border: 2px solid #d0d1ff;
}
::placeholder {
  color: #dfdfcd;
}
/* label class */
.userlabel {
  display: inline-block;
  position: relative;
  /* margin: 5px 2px 29px 0px; */
  /* top: 1px; */
  /* left: 1px; */
  /* padding: 0.8em 0.5em; */
  color: #6667ab;
  cursor: text;
}
.signUpFinalCheck {
  display: flex;
  flex-direction: row;
  justify-content: start;
}
#signUpFinalCheckBtn {
  margin-top: 10%;
  width: 60%;
}
.dummyMarginSignUp3 {
  width: 10%;
}
.dummyMarginSignUp4 {
  width: 25%;
}
.join_img {
  margin: 25px 0px 0px 0px;
  width: 65%;
}
.logoSlogan {
  margin-top: 10px;
  width: 80%;
}
.dummyMarginSignUp1 {
  width: 80%;
  height: 40%;
}
.dummyMarginSignUp2 {
  width: 80%;
  height: 10%;
}
</style>
