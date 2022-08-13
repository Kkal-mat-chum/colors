// import router from "@/router";
// import { api } from "@/store";

const resultStore = {
  state: {
    //개인 토너먼트에 필요한 개인미팅. 데이터 투표,토너먼트(colorTournament) 시작할 때 받아옵니다.
    aloneResult: {
      data: [
        {
          userid: "ssafy0",
          name: "kim",
          nickname: "asf33",
          urls: ["url1", "url2", "url3", "url4", "url5", "url6", "url7", "url8"],
          colors: ["c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"],
        },
      ],
      cnt: 1,
      message: "success",
    },
    voteContent: [], //투표 최종 결과 request content 담을 곳
    voteRound: 1, //부모 컴포넌트에 표시할 현재 투표 순서
    cnt: 2, //팀,랜덤 미팅 참여자 수
    nowSelectColor: "", //자식 컴포넌트에서 실시간으로 선택중인색깔코드
    restTime: 15, //타이머 남은 시간
    data: [
      {
        id: 11,
        userid: "ssafy0",
        name: "kim",
        nickname: "nick0",
        urls: ["url11", "url12", "url13", "url14", "url15", "url16", "url17", "url18"],
        colors: ["a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"],
      },
      {
        id: 22,
        userid: "ssafy1",
        name: "lee",
        nickname: "nick1",
        urls: ["url21", "url22", "url23", "url24", "url25", "url26", "url27", "url28"],
        colors: ["b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8"],
      },
      {
        id: 33,
        userid: "ssafy2",
        name: "lee3",
        nickname: "nick2",
        urls: ["url31", "url32", "url33", "url34", "url35", "url36", "url37", "url38"],
        colors: ["c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"],
      },
      {
        id: 44,
        userid: "ssafy3",
        name: "lee4",
        nickname: "nick3",
        urls: ["url41", "url42", "url43", "url44", "url45", "url46", "url47", "url48"],
        colors: ["d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8"],
      },
      {
        id: 55,
        userid: "ssafy4",
        name: "lee5",
        nickname: "nick4",
        urls: ["url51", "url52", "url53", "url54", "url55", "url56", "url57", "url58"],
        colors: ["e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8"],
      },
      {
        id: 66,
        userid: "ssafy5",
        name: "lee6",
        nickname: "nick5",
        urls: ["url61", "url62", "url63", "url64", "url65", "url66", "url67", "url68"],
        colors: ["f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8"],
      },
    ],
    totalResultData: [
      {
        code: "#1111111",
        voter: "nick1",
        url: "url1",
      },
      {
        code: "#333333",
        voter: "nick2",
        url: "url3",
      },
      {
        code: "#333333",
        voter: "nick3",
        url: "url3",
      },
    ], //투표결과 불러오기 내용 담길 곳
    totalResultTop1: {
      url: "url3",
      code: "#333333",
    }, //투표 결과 탑텐 내용 담길 곳
  },
  getters: {},
  mutations: {},
  actions: {},
};
export default resultStore;
