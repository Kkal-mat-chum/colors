<template>
  <div class="customUpdateUserPage">
    <div class="update1">
      <div class="title">회원 정보 수정</div>
      <hr class="hrStyle" />
    </div>
    <div class="update2">
      <div class="dummyMargin"></div>
      <div class="modifyLabels">
        <label for="nickLabel" class="modifyLabel">닉네임</label><br />
        <label for="nameLabel" class="modifyLabel">이름</label><br />
        <label for="emailLabel" class="modifyLabel">이메일</label><br />
        <label for="pwlabel" class="modifyLabel">비밀번호</label>
      </div>
      <div class="modifyInputs">
        <input type="text" class="modifyInput" id="nickLabel" />
        <input type="text" class="modifyInput" id="nameLabel" />
        <input type="text" class="modifyInput" id="emailLabel" />
        <input type="text" class="modifyInput" id="pwLabel" />
      </div>
      <div class="modifyButtons">확인버튼자리</div>
    </div>
    <div class="update3">버튼들 자리</div>
  </div>
</template>

<script>
export default {};
</script>

<style>
body {
  margin: 0;
}
.customUpdateUserPage {
  position: absolute;
  display: flex;
  flex-direction: column;
  width: 40%;
  height: 70%;
  left: 399px;
  top: 117px;
  border: 10px solid #000000;
  border-radius: 10px;
}
.update1 {
  /* display: grid; */
  position: relative;
  height: 30%;
  /* left: 0px;
  top: 0px; */
  background: white;
  justify-content: left;
}
.update2 {
  display: flex;
  flex-direction: row;
  position: relative;
  height: 55%;
  right: 0px;
  top: 0px;
}
.update3 {
  position: relative;
  height: 25%;
  right: 0px;
  top: 0px;
}
.title {
  margin-top: 8%;
  margin-left: 10%;
  position: absolute;
  top: 10%;
  left: 0;
  color: #6667ab;
  font-weight: 900;
  font-size: 150%;
}
.hrStyle {
  width: 40%;
  position: absolute;
  height: 1px;
  margin: 18% 0 0 10%;
  background-color: #6667ab;
}
.dummyMargin {
  width: 10%;
}
.modifyLabels {
  width: 15%;
  padding-left: 5%;
  text-align: left;
}
.modifyLabel {
  display: inline-block;
  margin: 0.6rem 0rem 2.5rem 0rem;
  color: #000000;
  font-size: 18px;
}
.modifyInputs {
  width: 50%;
}
.modifyInput[type="text"] {
  width: 80%;
  margin-bottom: 2rem;
  padding: 8px 5px;
  border-radius: 5px;
  border-color: #d0d1ff;
  font-size: 16px;
}
.modifyButtons {
  width: 25%;
}
</style>
