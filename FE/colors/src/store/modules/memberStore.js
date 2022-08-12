import { api } from "@/store";

const memberStore = {
  state: {
    teamNameList: ["송다경", "김찬일", "이한기", "오정환", "강민성", "김민영"], //팀미팅 참여자 이름
    randomNickLst: ["nick1", "nick2", "nick3", "nick4", "nick5", "nick6"], //랜덤미팅 참여자 닉네임
    voteRound: 1, //부모 컴포넌트에 표시할 현재 투표 순서
    cnt: 6, //팀,랜덤 미팅 참여자 수
    nowSelectColor: "", //자식 컴포넌트에서 실시간으로 선택중인색깔코드
    restTime: 15,
    data: [
      {
        userid: "ssafy0",
        name: "kim",
        nickname: "nick0",
        urls: ["url11", "url12", "url13", "url14", "url15", "url16", "url17", "url18"],
        colors: ["a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"],
      },
      {
        userid: "ssafy1",
        name: "lee",
        nickname: "nick1",
        urls: ["url21", "url22", "url23", "url24", "url25", "url26", "url27", "url28"],
        colors: ["b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8"],
      },
      {
        userid: "ssafy2",
        name: "lee3",
        nickname: "nick2",
        urls: ["url31", "url32", "url33", "url34", "url35", "url36", "url37", "url38"],
        colors: ["c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"],
      },
      {
        userid: "ssafy3",
        name: "lee4",
        nickname: "nick3",
        urls: ["url41", "url42", "url43", "url44", "url45", "url46", "url47", "url48"],
        colors: ["d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8"],
      },
      {
        userid: "ssafy4",
        name: "lee5",
        nickname: "nick4",
        urls: ["url51", "url52", "url53", "url54", "url55", "url56", "url57", "url58"],
        colors: ["e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8"],
      },
      {
        userid: "ssafy5",
        name: "lee6",
        nickname: "nick5",
        urls: ["url61", "url62", "url63", "url64", "url65", "url66", "url67", "url68"],
        colors: ["f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8"],
      },
    ],
    isLogin: false,
    members: [],
    member: {},
    baseurl: "http://loaclhost:8080",
  },
  getters: {},
  mutations: {
    MEMBER_LOGOUT(state) {
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
