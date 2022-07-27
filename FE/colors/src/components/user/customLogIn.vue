<template>
  <div class="logInPage">
    <img class="mainPicture" src="../../assets/logo_horizental.png" alt="깔맞춤" />
    <div class="logInInfo">
      <div class="logInBox">
        <div class="logInAlarm">아이디 또는 비밀번호를 확인하세요.</div>
        <div class="logInTitle">로그인</div>
        <hr class="logInHrStyle" />
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.mainPicture {
  margin-top: 5%;
}
.logInPage .logInInfo {
  display: flex;
  justify-content: center;
  margin-top: 5%;
}
.logInBox {
  box-sizing: border-box;
  position: relative;
  width: 40%;
  height: 50%;
  opacity: 0.8;
  top: 0;
  border-radius: 20px;
  border: 1px solid #e7e8ff;
  box-shadow: 8px 4px 8px rgba(0, 0, 0, 0.25);
}
.logInTitle {
  display: flex;
  font-size: 150%;
  padding-left: 14%;
  font-weight: 600;
  color: #6667ab;
}
.logInAlarm {
  display: flex;
  justify-content: right;
  color: #ff6c6c;
  font-size: 10%;
  margin: 4% 2% 0 0;
}
.logInHrStyle {
  width: 40%;
  height: 1px;
  margin: 3px 0 0 5%;
  background-color: #6667ab;
}
</style>
