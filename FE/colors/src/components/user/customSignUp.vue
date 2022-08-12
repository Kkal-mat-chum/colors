<template>
  <div class="signUpPage">
    <div class="signUp1">
      <div class="signUpWord">
        <div class="signUptitle">회원 가입</div>
        <div class="signUpWarning" id="signUpWarning">{{ state_message }}</div>
        <hr class="signUphrStyle" />
      </div>
      <div id="userInfo">
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
            <input type="password" class="logInPwInput" id="pwLabel" placeholder="영문 숫자 포함 8자리 이상" /><br />
            <input type="password" class="logInPwInput" id="pwcheckLabel" placeholder="다시 입력해주세요." /><br />
            <input type="text" class="userInput" id="nameLabel" placeholder="이름을 입력해주세요." /><br />
            <input type="text" class="userInput" id="nickLabel" placeholder="닉네임을 입력해주세요." /><br />
            <input type="text" class="userInput" id="emailLabel" placeholder="이메일을 입력해주세요" /><br />
            <input type="text" class="userInput" id="emailcheckLabel" v-model="emailCode" placeholder="전송된 인증 번호를 입력하세요." />
          </div>
          <div class="inputCheckBoxs">
            <customButton class="signUpIDCheckBtn" id="signUpIDCheckBtn" btnText="중복 확인" @click="checkDuplicateID">아이디 중복확인</customButton>
            <div class="dummyMarginSignUp1"></div>
            <customButton class="signUpnickCheckBtn" id="signUpnickCheckBtn" btnText="중복 확인" @click="checkDuplicateNickname">testButton</customButton>
            <customButton class="signUpEmailCheckBtn" id="signUpEmailCheckBtn" btnText="이메일 인증" @click="testClick">testButton</customButton>
            <customButton class="signUpEmailCheckBtn" id="signUpEmailCheckBtn" btnText="이메일 확인" @click="emailCheck">testButton</customButton>
          </div>
        </div>
        <div class="signUpFinalCheck">
          <!-- <div class="signUpWarning" id="signUpWarning1">{{ state_message }}</div> -->
          <div class="dummyMarginSignUp3"></div>
          <customButton class="signUpFinalCheckBtn" id="signUpFinalCheckBtn" btnText="회원 가입" @click="registMember">회원 가입</customButton>
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
import axios from "axios";
//이메일 인증 번호 보내는거 필요
export default {
  data() {
    return {
      //각 항목 유효성 검사 완료시 true로 바꾸기
      id_validation: false, //중복 확인 누를 때 검사
      pw_validation: false, //회원가입버튼 누를 때 검사
      nick_validation: false, //중복 확인 누를 때 검사
      email_validation: false, //회원가입버튼 누를 때 검사
      state_message: "",
      emailCode: "",
      storeBaseurl: this.$store.state.memberStore.baseurl,
    };
  },
  computed: {
    //비밀번호 두번 입력값 같은지 검사
    pw_doubleCheck: function () {
      if (document.getElementById("pwLabel").value == document.getElementById("pwcheckLabel").value) {
        return true;
      } else {
        return false;
      }
    },
  },
  methods: {
    // 아이디 중복 검사
    checkDuplicateID() {
      let new_id = document.getElementById("idLabel").value;
      this.validID(new_id);
      //유효성검사 성공시
      if (this.id_validation) {
        console.log("유효한 아이디입니다.");
        console.log(this.id_validation);
        console.log(this.storeBaseurl + "/api/member/chkid");
        axios
          .post(this.$store.state.baseurl + "/api/member/chkid", {
            input_id: new_id,
          })
          .then((response) => {
            if (response.message == "not-duplicated") {
              console.log("아이디 사용 가능");
            } else {
              console.log("중복된 아이디");
            }
          });
      } else {
        this.state_message = "입력한 정보를 다시 확인해주세요.";
        console.log("유효하지 않은 아이디");
      }
      // this.validID(new_id);
      // console.log(new_id);
    },
    //아이디 유효성 검사
    validID(inputID) {
      const reg = /^(?=.*[a-zA-Z0-9]).{6,15}$/;
      if (inputID.match(reg)) {
        // console.log("유효한 아이디");
        this.id_validation = true;
        return true;
      }
      // console.log("유효하지 않은 아이디");
      this.id_validation = false;
      return false;
    },
    //비밀번호 유효성 검사
    validPW(inputPW) {
      const reg = /^(?=.*[a-zA-Z0-9]).{8,30}$/;
      if (inputPW.match(reg)) {
        // console.log("유효한 비밀번호");
        this.pw_validation = true;
        return true;
      }
      // console.log("유효하지 않은 비밀번호");
      this.pw_validation = false;
      return false;
    },
    // 닉네임 중복 검사
    checkDuplicateNickname() {
      let new_nickname = document.getElementById("nickLabel").value;
      console.log(new_nickname);
      axios
        .post(this.$store.state.baseurl + "/api/member/chknic", {
          input_nickname: new_nickname,
        })
        .then((response) => {
          if (response.message == "not-duplicated") {
            console.log("닉네임 사용 가능");
            this.nick_validation = true;
          } else {
            this.nick_validation = false;
            console.log("중복된 닉네임");
          }
        });
    },
    // 이메일 인증 버튼 클릭 시 @@@@@ authNumber auth_number?
    checkEmail() {
      let new_email = document.getElementById("emailLabel").value;
      let email_checknum = document.getElementById("emailcheckLabel").value;
      axios
        .post(this.$store.state.baseurl + "/api/auth/emailAuth", {
          email: new_email,
        })
        .then((response) => {
          if (response.authNumber == email_checknum) {
            this.email_validation = true;
          } else if (response.message == "fail") {
            this.email_validation = false;
          }
        });
    },
    // 회원 가입: 아이디,비번,
    registMember() {
      let new_nickname = document.getElementById("nickLabel").value;
      let new_userid = document.getElementById("idLabel").value;
      let new_password = document.getElementById("pwLabel").value;
      let new_name = document.getElementById("nameLabel").value;
      let new_email = document.getElementById("emailLabel").value;
      this.validPW(new_password); //비밀번호 유효성 검사 함수 실행
      //아이디, 비번, 닉네임, 이메일 유효하고,
      //이름이 있는지
      if (this.id_validation && this.pw_validation && this.nick_validation && !!document.getElementById("nameLabel").value) {
        console.log("유효");
      } else if (!this.id_validation && this.pw_validation) {
        console.log("아이디 중복 확인 해주세용");
      } else if (this.id_validation && !this.pw_validation) {
        console.log("비밀번호 다시 확인해주세용");
      } else {
        console.log("아이디, 비밀번호 둘 다 다시 확인해주세용");
      }
      if (sessionStorage.getItem("checkEmail") == true && this.id_validation && this.pw_validation && this.nick_validation && !!document.getElementById("nameLabel").value) {
        axios
          .post(this.$store.state.baseurl + "/api/member/chknic/", {
            nickname: new_nickname,
            userid: new_userid,
            password: new_password,
            name: new_name,
            email: new_email,
          })
          .then((response) => {
            if (response.message == "success") {
              console.log("로그인 완료");
            } else {
              console.log("로그인 실패");
            }
          });
      } else {
        alert("회원정보를 다시 확인하세요.");
      }
    },
    emailCheck() {
      let memberEmail = {
        emailCheck: this.emailCode,
      };
      this.$store.dispatch("memberEmailCheck", memberEmail);
    },
  },
};
</script>

<style scoped>
body {
  margin: 0;
}
.signUptitle {
  position: absolute;
  width: 50%;
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
  display: flex;
  flex-direction: row;
  justify-content: start;
}
.signUphrStyle {
  width: 20%;
  position: absolute;
  height: 1px;
  margin: 33px 0 0 5%;
  background-color: #d0d1ff;
}
#userInfo {
  position: absolute;
  top: 25%;
  left: 10%;
  width: 90%;
  display: flex;
  flex-direction: column;
}
label {
  color: #6667ab;
  font-size: 0.95rem;
  font-weight: 600;
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
  margin-bottom: -10px;
}
button {
  width: 100%;
  margin-bottom: 1em;
  margin-left: 10px;
  padding: 5px 0px;
  border-radius: 5px;
  border-color: #d0d1ff;
  background-color: white;
  color: #6667ab;
}
.userInput[type="text"] {
  width: 90%;
  padding: 10px 5px;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
}
::placeholder {
  color: #dfdfcd;
}
.userlabel {
  display: inline-block;
  position: relative;
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
#signUpWarning {
  margin-top: 80%;
  margin-left: 28%;
  margin-right: 30%;
  font-size: 15px;
  color: #f34d75;
}
#signUpWarning1 {
  font-size: 15px;
  color: #f34d75;
}
.logInPwInput[type="password"] {
  width: 90%;
  padding: 10px 5px;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
}
</style>
