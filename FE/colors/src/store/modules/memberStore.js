import { api } from "@/store";
import swal from "sweetalert";

const memberStore = {
  state: {
    isLogin: false,
    // isLogin: JSON.parse(sessionStorage.getItem("isLogin")),
    members: [],
    member: {},
  },
  getters: {
    isLogin(state) {
      console.log(state.isLogin);
      return JSON.parse(sessionStorage.getItem("isLogin"));
    },
  },
  mutations: {
    MEMBER_LOGOUT(state) {
      console.log(sessionStorage.getItem("isLogin"));
      sessionStorage.setItem("isLogin", false);
      state.isLogin = false;
      sessionStorage.removeItem("access-token");
      api.defaults.headers["access-token"] = "";
    },
    MEMBER_EMAIL_CHECK(state, payload) {
      if (payload == 1) {
        sessionStorage.setItem("checkEmail", true);
        state.members.push(payload);
        swal("이메일 인증", "이메일 인증에 성공하였습니다.", "success");
      } else {
        sessionStorage.setItem("checkEmail", false);
        swal("이메일 인증", "이메일 인증코드를 다시 확인하세요.", "error");
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
          swal("이메일 인증", "이메일 인증코드를 다시 확인하세요.", "error");
        });
    },
  },
};
export default memberStore;
