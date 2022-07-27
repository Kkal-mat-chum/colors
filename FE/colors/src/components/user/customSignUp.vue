<template>
  <div class="sighUpPage">
    <div class="sighUp1">
      <div class="sighUpWord">
        <div class="title">회원관리</div>
        <hr class="hrStyle" />
      </div>
      <div class="userInfo">
        <div class="textBox">
          <label for="nickLabel">닉네임</label>
          <input type="text" class="nickInput" />
          <div>121313</div>
        </div>
      </div>
    </div>
    <div class="sighUp2">123</div>
  </div>
</template>

<script>
export default {};
</script>

<style>
body {
  margin: 0;
}
.title {
  position: relative;
  width: 100%;
}
.sighUpPage {
  position: absolute;
  width: 80%;
  height: 100%;
  display: block;
  box-sizing: inherit;
  -webkit-text-size-adjust: 100%;
  margin: 0 10% 0 10%;
}
.sighUp1 {
  display: grid;
  position: relative;
  width: 50%;
  height: 100%;
  left: 0px;
  top: 0px;
  background: white;
  justify-content: left;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
}
.sighUp2 {
  position: absolute;
  width: 50%;
  height: 100%;
  right: 0px;
  top: 0px;
}
.sighUpWord {
  margin-left: 5%;
  position: absolute;
  top: 10%;
  left: 0;
  color: #6667ab;
  font-weight: 900;
  font-size: 150%;
  width: 95%;
}
.hrStyle {
  width: 100%;
  position: relative;
  height: 0.4%;
  margin-top: 2%;
  background-color: #6667ab;
}
.userInfo {
  position: absolute;
  top: 25%;
  left: 10%;
  width: 90%;
}
label {
  color: #6667ab;
  font-size: 1rem;
  font-weight: 600;
}
.inputBox[type="text"] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
.nickLabel {
  position: relative;
  top: 1px;
  left: 1px;
  padding: 0.8em 0.5em;
  color: #6667ab;
  cursor: text;
}
.textBox {
  width: 100%;
}
.nickInput[type="text"] {
  width: 70%;
  margin-left: 20px;
  border-radius: 5px;
  border-color: #6667ab;
}
</style>
