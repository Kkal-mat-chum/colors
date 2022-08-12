import Vue from "vue";
import Vuex from "vuex";
import { createApi } from "@/api";
//import router from "@/router";
import meetingStore from "@/store/modules/meetingStore";
import memberStore from "@/store/modules/memberStore";
import topicStore from "@/store/modules/topicStore";

Vue.use(Vuex);

export const api = createApi();

export default new Vuex.Store({
  state: {
    r: 0,
    g: 0,
    b: 0,
    a: 1,

    isLogin: false,
    storeselectedColor: "#ffffff",
    //토너먼트 투표 시 선택되어(selectedColorLst) 결과창까지(tournamentResultLst) 보이는 색상입니다. 백에서 데이터를 받게되면 이 코드 지우고 스토어에 저장해주세요.
    selectedColorLst: ["#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff"],
    tournamentResultLst: [],
    //마이페이지에 보일 팔레트 색상입니다. 백에서 데이터를 받게되면 이 코드 지우고 스토어에 저장해주세요.
    aloneColorLst: ["#111fff", "#222222", "#333333", "#444444", "#555555", "#666666", "#777777", "#fff999"],
    teamColorLst: ["#888000", "#777777", "#666666", "#555555", "#444444", "#333333", "#222222", "#000888"],
    randomColorLst: ["#89a89a", "#222222", "#333333", "#444444", "#555555", "#666666", "#777777", "#879869"],
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
  },
});
