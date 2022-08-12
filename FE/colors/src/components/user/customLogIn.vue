<template>
  <div class="logInPage">
    <img class="mainPicture" src="../../assets/logo_horizental.png" alt="깔맞춤" />
    <div class="logInInfo">
      <div class="logInBox">
        <div v-show="loginAlram" class="logInAlarm">아이디 또는 비밀번호를 확인하세요.</div>
        <div class="logInTitle">로그인</div>
        <hr class="logInHrStyle" />
        <div class="logInLabel">아이디</div>
        <div class="logInInput">
          <input type="text" placeholder="아이디를 입력하세요." id="logInInput" class="logInIdInput" />
        </div>
        <div class="logInLabelPw">비밀번호</div>
        <div class="logInInput">
          <input type="password" id="logInpageInput" placeholder="비밀번호를 입력하세요." class="logInPwInput" />
        </div>
        <customButton btnText="로그인" class="idPwSearch" @click="loginMember()"></customButton>
        <customButton btnText="아이디/비밀번호 찾기" class="idPwSearch" @click="findIdpwShowModal = true"></customButton>
        <customButton btnText="회원가입" class="signUp" @click="gotosignup()"></customButton>
        <custom-modal class="findIdpwModal" id="findIdpwModal" v-show="findIdpwShowModal" @close-modal="findIdpwShowModal = false" titleText="아이디 / 비밀번호 찾기">
          <content><find-idpw></find-idpw></content>
        </custom-modal>
      </div>
    </div>
  </div>
</template>

<script>
import FindIdpw from "@/components/user/idPwFind.vue";
import axios from "axios";
import router from "@/router";
export default {
  components: {
    FindIdpw,
  },
  data() {
    return {
      findIdpwShowModal: false,
      loginAlram: false,
    };
  },
  methods: {
    testClick() {
      console.lot("?");
    },
    //회원가입 창으로 가기
    gotosignup() {
      this.$router.push("/signup");
    },
    //로그인
    loginMember() {
      let login_id = document.getElementById("logInInput").value;
      let login_pw = document.getElementById("logInpageInput").value;
      axios
        .post(this.$store.state.baseurl + "/api/auth/login", {
          userid: login_id,
          password: login_pw,
        })
        // 토큰을 세션스토리지에 저장해놓기
        .then((response) => {
          if (response.message == "fail") {
            this.loginWarningShow = true;
            this.loginAlram = true;
          } else if (response.message == "success") {
            sessionStorage.setItem("access-token", response["access-token"]);
            //겟으로 사용자 정보 받아서 세션스토리지에 저장해놓기
            axios.get(this.$store.state.baseurl + "/api/member/" + login_id).then((response) => {
              if (response.message == "success") {
                //https://granya.tistory.com/4 참조 배열을 저장하는 방법
                sessionStorage.setItem("memberData", JSON.stringify(response.data));
                router.push("/enterPage");
              }
            });
          }
        });
      // console.log(login_id, login_pw);
    },
  },
};
</script>

<style scoped>
.mainPicture {
  margin-top: 0;
}
.logInPage .logInInfo {
  display: flex;
  justify-content: center;
  margin-top: 2%;
}
.logInBox {
  box-sizing: border-box;
  position: relative;
  width: 30%;
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
  display: flex;
  width: 40%;
  height: 1px;
  border-radius: 5px;
  margin: 3px 0 0 5%;
  background-color: #d0d1ff;
  margin-left: 13%;
}
.logInIdInput[type="text"] {
  display: flex;
  margin: 1% 0 3% 15%;
  width: 70%;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
  height: 30px;
}
.logInPwInput[type="password"] {
  display: flex;
  margin: 1% 0 3% 15%;
  width: 70%;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
  height: 30px;
}
.logInLabel {
  display: flex;
  margin: 5% 0 0 15%;
  color: #d0d1ff;
  font-size: 13px;
  font-weight: 600;
}
.logInLabelPw {
  display: flex;
  margin: 5% 0 0 15%;
  color: #d0d1ff;
  font-size: 13px;
  font-weight: 600;
}
input::placeholder {
  color: #d0d1ff;
}
.idPwSearch {
  display: flex;
  margin: 2% 0 2% 15%;
  width: 72%;
  justify-content: center;
}
.signUp {
  display: flex;
  margin: 2% 0 8% 15%;
  width: 72%;
  justify-content: center;
}
/* #findIdpwModal {
  height: 50%;
} */
</style>
