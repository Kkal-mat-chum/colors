<template>
  <div class="customUpdateUserPage">
    <div class="update1">
      <div class="title">회원 정보 수정</div>
      <hr class="hrStyle" />
    </div>
    <div class="update2">
      <div class="dummyMargin1"></div>
      <div class="modifyLabels">
        <label for="nickLabel" class="modifyLabel">닉네임</label><br />
        <label for="nameLabel" class="modifyLabel">이름</label><br />
        <label for="emailLabel" class="modifyLabel">이메일</label><br />
        <label for="pwlabel" class="modifyLabel">비밀번호</label>
      </div>
      <div class="modifyInputs">
        <input type="text" class="modifyInput" id="nickLabel" placeholder="닉네임을 입력해주세요." />
        <input type="text" class="modifyInput" id="nameLabel" placeholder="이름을 입력해주세요." />
        <input type="text" class="modifyInput" id="emailLabel" placeholder="이메일을 입력해주세요." />
        <input type="text" class="modifyInput" id="pwLabel" placeholder="비밀번호를 입력해주세요." />
      </div>
      <div class="modifyButtons">
        <customButton class="nickCheckBtn" id="nickCheckBtn" btnText="중복 확인" @click="testClick">testButton</customButton>
      </div>
      <div class="dummyMargin2"></div>
    </div>
    <div class="update3">
      <div class="dummyMargin3"></div>
      <div class="modifyBottomBtns">
        <customButton class="nickCheckBtn" id="infoChangeBtn" btnText="정보 수정" @click="testClick">testButton</customButton>
        <div class="update3_row2">
          <customButton class="nickCheckBtn" id="pwChangeBtn" btnText="비밀번호 변경" @click="testClick">testButton</customButton>
          <customButton class="nickCheckBtn" id="byeBtn" btnText="회원 탈퇴" @click="testClick">testButton</customButton>
        </div>
      </div>
      <div class="dummyMargin3"></div>
    </div>
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
  width: 537.75px;
  height: 558px;
  /* width: 35%;
  height: 75%; */
  left: 399px;
  top: 117px;
  border: 10px solid #000000;
  border-radius: 10px;
}
.update1 {
  /* display: grid; */
  position: relative;
  height: 25%;
  /* left: 0px;
  top: 0px; */
  background: white;
  justify-content: left;
}
.update2 {
  display: flex;
  flex-direction: row;
  position: relative;
  height: 53%;
  right: 0px;
  top: 0px;
}
.update3 {
  position: relative;
  display: flex;
  flex-direction: row;
  height: 32%;
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
  background-color: #d0d1ff;
}
.dummyMargin1 {
  width: 10%;
}
.dummyMargin2 {
  width: 5%;
}
.dummyMargin3 {
  width: 20%;
}
.modifyLabels {
  /* display: flex;
  flex-direction: column;
  justify-content: space-evenly; */
  width: 15%;
  padding-left: 3%;
  text-align: left;
}
.modifyLabel {
  display: inline-block;
  margin: 0.6rem 0rem 2.5rem 0rem;
  margin-top: 15%;
  margin-bottom: 45%;
  color: #6667ab;
  font-size: 17px;
}
.modifyInputs {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 50%;
}
.modifyInput[type="text"] {
  width: 80%;
  margin-bottom: 8%;
  margin-top: 2%;
  /* margin-left: 2%; */
  padding: 8px;
  border: 2px solid #d0d1ff;
  border-radius: 5px;
  border-color: #d0d1ff;
  font-size: 16px;
}
.modifyButtons {
  width: 20%;
  display: flex;
  flex-direction: row;
}
.nickCheckBtn {
  padding: 0;
}
.update3_row2 {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.modifyBottomBtns {
  width: 60%;
  display: flex;
  flex-direction: column;
  /* margin-bottom: 1rem; */
}
#nickCheckBtn {
  margin-top: 5%;
  height: 15%;
}
#infoChangeBtn {
  margin-bottom: 5%;
}
#pwChangeBtn {
  width: 48%;
}
#byeBtn {
  width: 48%;
  color: red;
}
</style>
