<template>
  <div class="logInPage">
    <img class="mainPicture" src="../../assets/logo_horizental.png" alt="깔맞춤" @click="goHome" style="cursor: pointer" />
    <div class="logInInfo">
      <div class="logInBox">
        <div v-show="loginAlram" class="logInAlarm">아이디 또는 비밀번호를 확인하세요.</div>
        <div class="title">
          <h2>로그인</h2>
          <hr />
        </div>
        <div class="logInLabel">아이디</div>
        <div class="logInInput">
          <input type="text" placeholder="아이디를 입력하세요." id="logInInput" class="logInIdInput" />
        </div>
        <div class="logInLabelPw">비밀번호</div>
        <div class="logInInput">
          <input type="password" id="logInpageInput" @keyup.enter="loginMember()" placeholder="비밀번호를 입력하세요." class="logInPwInput" />
        </div>
        <customButton btnText="로그인" class="idPwSearch" @click="loginMember()"></customButton>
        <customButton btnText="아이디/비밀번호 찾기" class="idPwSearch" @click="findIdpwShowModal = true"></customButton>
        <customButton btnText="회원가입" class="signUp" @click="gotosignup()"></customButton>
        <custom-modal class="findIdpwModal" id="findIdpwModal" v-show="findIdpwShowModal" @close-modal="findIdpwShowModal = false">
          <content><find-idpw></find-idpw></content>
        </custom-modal>
      </div>
    </div>
  </div>
</template>

<script>
import FindIdpw from "@/components/user/idPwFind.vue";
import axios from "axios";
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
    goHome() {
      this.$router.push("/");
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
        .post(this.$store.state.baseurl + "auth/login", {
          userId: login_id,
          password: login_pw,
        })
        // 토큰을 세션스토리지에 저장해놓기
        .then((response) => {
          if (response.data.message == "fail") {
            this.loginWarningShow = true;
            this.loginAlram = true;
          } else if (response.data.message == "success") {
            console.log(response.data.member);
            sessionStorage.setItem("access-token", response.data["access-token"]);
            sessionStorage.setItem("memberData", response.data.member);
            sessionStorage.setItem("userName", response.data.member.name);
            sessionStorage.setItem("memberId", response.data.member.id);
            sessionStorage.setItem("userId", response.data.member.userId);
            sessionStorage.setItem("userNick", response.data.member.nickname);
            sessionStorage.setItem("isLogin", true);
            sessionStorage.setItem("auth", false);
            this.$store.state.memberStore.isLogin = true;
            console.log(sessionStorage.getItem("isLogin"));
            if (response.data.member.userId == "admin") {
              sessionStorage.setItem("auth", true);
              console.log(response.data.member.userId);
            }
            //겟으로 사용자 정보 받아서 세션스토리지에 저장해놓기
            axios.get(this.$store.state.baseurl + "member/" + login_id).then((response) => {
              if (response.data.message == "success") {
                //https://granya.tistory.com/4 참조 배열을 저장하는 방법
                sessionStorage.setItem("memberData", JSON.stringify(response.data));
                this.$router.push("/enterPage");
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
.title {
  margin-bottom: 30px;
  margin-left: 50px;
}
.title h2 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 30px 0 10px 0;
}

.title > hr {
  display: flex;
  width: 150px;
  margin: 0;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}
.mainPicture {
  margin-top: 40px;
}
.logInPage .logInInfo {
  display: flex;
  justify-content: center;
  margin-top: 3%;
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
  margin: 1% 0 8% 15%;
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
  margin: 2% 0 3% 15%;
  width: 72%;
  justify-content: center;
}
.signUp {
  display: flex;
  margin: 2% 0 8% 15%;
  width: 72%;
  justify-content: center;
}
#findIdpwModal {
  /* height: 50%; */
  width: 120%;
  margin-left: -150px;
}
</style>
