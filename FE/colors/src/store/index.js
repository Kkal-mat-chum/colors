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
    selectedColorLst: ["#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff", "#ffffff"],
    tournamentResultLst: [],
  },
  getters: {},
  mutations: {
    NEW_COLOR(state, new_color) {
      state.storeselectedColor = new_color;
    },
  },
  actions: {},
  modules: {
    meetingStore,
    memberStore,
    topicStore,
  },
});
