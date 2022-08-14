import Vue from "vue";
import Vuex from "vuex";
import { createApi } from "@/api";
//import router from "@/router";
import meetingStore from "@/store/modules/meetingStore";
import memberStore from "@/store/modules/memberStore";
import topicStore from "@/store/modules/topicStore";
import resultStore from "@/store/modules/resultStore";
Vue.use(Vuex);

export const api = createApi();

export default new Vuex.Store({
  state: {
    r: 0,
    g: 0,
    b: 0,
    a: 1,
    storeselectedColor: "#ffffff",
    //팔레트에서 선택되어(selectedColorLst) 토너먼트 결과창까지(tournamentResultLst) 보이는 색상입니다. 이거 사용해서 토너먼트, 개인투표 합니다. 이미지 url필요해요
    selectedColorLst: ["#111111", "#121212", "#323232", "#434343", "#525252", "#123456", "#666632", "#125552"],
    aloneImageUrlLst: ["url0", "url1", "url2", "url3", "url4", "url5", "url6", "url7"],
    // selectedColorLst: ["#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff"],
    tournamentResultLst: [],

    baseurl: process.env.VUE_APP_API_SERVER,
    //마이페이지에 보일 팔레트 색상입니다. 백에서 데이터를 받게되면 이 코드 지우고 스토어에 저장해주세요.
    aloneColorLst: ["#111111", "#222222", "#333333", "#444444", "#555555", "#666666", "#777777", "#fff999"],
    teamColorLst: ["#000000", "#777777", "#666666", "#555555", "#444444", "#333333", "#222222", "#000888"],
    randomColorLst: ["#89a89a", "#222222", "#333333", "#444444", "#555555", "#666666", "#777777", "#879869"],
    aloneTop1: "#123123",
    teamTop1: "#432423",
    randomTop1: "#543523",
    hoveringColor: "색상 코드", //마이페이지에서 마우스오버할때 우측상단 표시할 색상입니다. 건들ㄴ
  },
  getters: {},
  mutations: {
    NEW_COLOR(state, new_color) {
      state.storeselectedColor = new_color;
    },
    changeHoveringColor(state, hover_color) {
      state.hoveringColor = hover_color;
    },
  },
  actions: {},
  modules: {
    meetingStore,
    memberStore,
    topicStore,
    resultStore,
  },
});
