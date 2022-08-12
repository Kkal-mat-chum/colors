//import { api } from "@/store";
//import router from "@/router";

const memberStore = {
  state: {
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
  },
  getters: {},
  mutations: {},
  actions: {},
};
export default memberStore;
