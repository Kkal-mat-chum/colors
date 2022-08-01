<template>
  <div class="idPwFindPage">
    <!-- <div class="semiTitleInIdpwFind">
      <div>아이디 찾기</div>
      <div>비밀번호 찾기</div>
    </div> -->
    <div class="bodyIdpwFind">
      <div class="dummyMarginIdpwFind3"></div>
      <div class="idFindInIdpwfind">
        <div class="idFindInIdpwfind1">
          <label class="titleInIdpwfind">아이디 찾기</label>
          <!-- <hr class="hrstyleInIdpwfind1" /> -->
          <!-- <div class="dummyMargin11"></div> -->
          <label for="idFindstate" id="labelWarningInIdpwFind">아이디와 이메일을 확인해주세요.</label>
        </div>
        <!-- <div class="dummyMarginIdpwFind1"></div> -->
        <input type="text" class="inPwFindInput" id="idFindNameInputInIdpwFind" placeholder="이름을 입력해주세요." />
        <input type="text" class="inPwFindInput" id="idFindEmailInputInIdpwFind" placeholder="이메일을 입력해주세요." />
        <customButton class="idFindInIdpwFindBtn" id="idFindInIdpwFindBtn" btnText="확 인" @click="testClick">testButton</customButton>
        <label for="idFindstate" class="labelInIdpwFind">아이디는 min4849 입니다.</label>
      </div>
      <div class="dummyMarginIdpwFind5"></div>
      <hr class="hrstyleInIdpwfind2" />
      <div class="dummyMarginIdpwFind5"></div>
      <div class="pwFindInIdpwfind">
        <div class="idFindInIdpwfind1">
          <label class="titleInIdpwfind">비밀번호 찾기</label>
          <!-- <hr class="hrstyleInIdpwfind1" /> -->
          <label for="idFindstate" id="labelWarningInIdpwFind">아이디와 이메일을 확인해주세요.</label>
        </div>
        <!-- <div class="dummyMarginIdpwFind1"></div> -->
        <input type="text" class="inPwFindInput" id="pwFindEmailInputInIdpwFind" placeholder="아이디를 입력해주세요." />
        <input type="text" class="inPwFindInput" id="pwFindNameInputInIdpwFind" placeholder="이메일을 입력해주세요." />
        <customButton class="idFindInIdpwFindBtn" id="pwFindInIdpwFindBtn" btnText="임시 비밀번호 보내기" @click="testClick">testButton</customButton>
        <label for="pwFindstate" class="labelInIdpwFind">임시 비밀번호를 메일로 전송했습니다.</label>
      </div>
      <div class="dummyMarginIdpwFind4"></div>
    </div>
    <div class="dummyMarginIdpwFind2"></div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.idPwFindPage {
  position: absolute;
  width: 50%;
  height: 50%;
  left: 25%;
  top: 33%;
  /* border: 3px solid aqua; */
  display: flex;
  flex-direction: column;
}
.dummyMarginIdpwFind1 {
  height: 0;
}
.dummyMarginIdpwFind2 {
  height: 10%;
}
.bodyIdpwFind {
  height: 80%;
  display: flex;
  flex-direction: row;
  text-align: left;
}
.titleInIdpwfind {
  /* color: #6667ab; */
  font-size: 150%;
  margin-bottom: 5%;
  font-weight: 900;
}
.idFindInIdpwfind {
  width: 40%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
.pwFindInIdpwfind {
  width: 40%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
.dummyMarginIdpwFind3 {
  width: 5%;
}
.dummyMarginIdpwFind4 {
  width: 5%;
}
.dummyMarginIdpwFind5 {
  width: 5%;
}
.hrstyleInIdpwfind1 {
  width: 50%;
  border: 0;
  height: 3px;
  margin-bottom: 5%;
  /* text-align: left; */
  margin-left: 0;
  margin-top: 3%;
  background: #d0d1ff;
}
.hrstyleInIdpwfind2 {
  width: 2px;
  border: 0;
  /* height: 0%; */
  /* margin-bottom: 5%; */
  margin: 0;
  /* text-align: left; */
  margin-left: 0;
  margin-top: 3%;
  background: #6667ab;
}
.inPwFindInput[type="text"] {
  width: 93%;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
  padding: 10px 5px;
}
#idFindInIdpwFindBtn {
  width: 100%;
  /* margin-top: 5%; */
}
#pwFindInIdpwFindBtn {
  width: 100%;
}
.labelInIdpwFind {
  margin-top: 10%;
  text-align: center;
}
#labelWarningInIdpwFind {
  color: red;
  text-align: left;
  font-weight: 50;
}
.dummyMargin11 {
  height: 100%;
}
.semiTitleInIdpwFind {
  display: flex;
  flex-direction: row;
}
.titleInIdpwfind {
  display: block;
  width: 100%;
  size: 300;
}
</style>
