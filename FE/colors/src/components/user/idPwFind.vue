<template>
  <div class="idPwFindPage">
    <div class="dummyMarginIdpwFind1"></div>
    <div class="bodyIdpwFind">
      <div class="dummyMarginIdpwFind3"></div>
      <div class="idFindInIdpwfind">
        <label class="titleInIdpwfind">아이디 찾기</label>
        <hr class="hrstyleInIdpwfind1" />
        <input type="text" class="inPwFindInput" id="idFindNameInputInIdpwFind" placeholder="이름을 입력해주세요." />
        <input type="text" class="inPwFindInput" id="idFindEmailInputInIdpwFind" placeholder="이메일을 입력해주세요." />
        <customButton class="idFindInIdpwFindBtn" id="idFindInIdpwFindBtn" btnText="확 인" @click="testClick">testButton</customButton>
        <label for="idFindstate">아이디는 min4849 입니다.</label>
      </div>
      <div class="dummyMarginIdpwFind5"></div>
      <hr class="hrstyleInIdpwfind2" />
      <div class="dummyMarginIdpwFind5"></div>
      <div class="pwFindInIdpwfind">
        <label class="titleInIdpwfind">비밀번호 찾기</label>
        <hr class="hrstyleInIdpwfind1" />
        <input type="text" class="inPwFindInput" id="pwFindEmailInputInIdpwFind" placeholder="아이디를 입력해주세요." />
        <input type="text" class="inPwFindInput" id="pwFindNameInputInIdpwFind" placeholder="이메일을 입력해주세요." />
        <customButton class="idFindInIdpwFindBtn" id="pwFindInIdpwFindBtn" btnText="임시 비밀번호 보내기" @click="testClick">testButton</customButton>
        <label for="pwFindstate">임시 비밀번호를 메일로 전송했습니다.</label>
      </div>
      <div class="dummyMarginIdpwFind4"></div>
    </div>
    <div class="dummyMarginIdpwFind2"></div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.idPwFindPage {
  position: absolute;
  width: 40%;
  height: 40%;
  left: 30%;
  top: 30%;
  border: 3px solid aqua;
  display: flex;
  flex-direction: column;
}
.dummyMarginIdpwFind1 {
  height: 10%;
}
.dummyMarginIdpwFind2 {
  height: 15%;
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
  margin-bottom: 5%;
}
.inPwFindInput[type="input"] {
  width: 100%;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
  padding: 10px 5px;
}
#idFindInIdpwFindBtn {
  width: 100%;
}
#pwFindInIdpwFindBtn {
  width: 100%;
}
</style>
