import { api } from "@/store";

const memberStore = {
  state: {
    isLogin: false,
    // isLogin: JSON.parse(localStorage.getItem("isLogin")),
    members: [],
    member: {},
    baseurl: "http://localhost:8080", // baseurl 바꾸기...
  },
  getters: {
    isLogin(state) {
      console.log(state.isLogin);
      return JSON.parse(localStorage.getItem("isLogin"));
    },
  },
  mutations: {
    MEMBER_LOGOUT(state) {
      console.log(localStorage.getItem("isLogin"));
      localStorage.setItem("isLogin", false);
      state.isLogin = false;
      sessionStorage.removeItem("access-token");
      api.defaults.headers["access-token"] = "";
    },
    MEMBER_EMAIL_CHECK(state, payload) {
      if (payload == 1) {
        sessionStorage.setItem("checkEmail", true);
        state.members.push(payload);
        alert("이메일 인증이 완료됐습니다.");
      } else {
        sessionStorage.setItem("checkEmail", false);
        alert("이메일 인증코드를 다시 확인하세요.");
      }
    },
  },
  actions: {
    memberEmailCheck({ commit }, memberEmail) {
      api({
        method: "POST",
        data: memberEmail,
      })
        .then((res) => {
          if (res.authcode == memberEmail) {
            commit("MEMBER_EMAIL_CHECK", 1);
          }
        })
        .catch((err) => {
          console.log(err);
          alert("올바른 인증코드가 아닙니다.");
        });
    },
  },
};
export default memberStore;
