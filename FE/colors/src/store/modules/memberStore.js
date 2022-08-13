import { api } from "@/store";

const memberStore = {
  state: {
    isLogin: localStorage.getItem("isLogin"),
    teamNameList: ["송다경", "김찬일", "이한기", "오정환", "강민성", "김민영"], //팀미팅 참여자 이름
    randomNickLst: ["nick1", "nick2", "nick3", "nick4", "nick5", "nick6"], //랜덤미팅 참여자 닉네임
    cnt: 6, //팀,랜덤 미팅 참여자 수
    data: [
      {
        userid: "ssafy0",
        name: "kim",
        nickname: "nick0",
        urls: ["url1", "url2", "url3"],
        colors: ["c1", "c2", "c3"],
      },
      {
        userid: "ssafy1",
        name: "lee",
        nickname: "nick1",
        urls: ["url1", "url2", "url3"],
        colors: ["c1", "c2", "c3"],
      },
      {
        userid: "ssafy2",
        name: "lee",
        nickname: "nick2",
        urls: ["url1", "url2", "url3"],
        colors: ["c1", "c2", "c3"],
      },
      {
        userid: "ssafy3",
        name: "lee",
        nickname: "nick3",
        urls: ["url1", "url2", "url3"],
        colors: ["c1", "c2", "c3"],
      },
      {
        userid: "ssafy4",
        name: "lee",
        nickname: "nick4",
        urls: ["url1", "url2", "url3"],
        colors: ["c1", "c2", "c3"],
      },
      {
        userid: "ssafy5",
        name: "lee",
        nickname: "nick5",
        urls: ["url1", "url2", "url3"],
        colors: ["c1", "c2", "c3"],
      },
    ],
    members: [],
    member: {},
    baseurl: "http://localhost:8080", // baseurl 바꾸기...
  },
  getters: {
    isLogin(state) {
      console.log(state.isLogin);
      return localStorage.getItem("isLogin");
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
