import router from "@/router";
import { api } from "@/store";

const meetingStore = {
  state: {
    singleUsers: [],
    singleUser: {},
    groupUsers: [],
    groupUser: {},
    randomUsers: [],
    randomUser: {},
    publishAudio: {
      type: Boolean,
      default: false,
    },
    publishVideo: {
      type: Boolean,
      default: false,
    },
  },
  getters: {
    getPublishAudio(state) {
      return state.publishAudio;
    },
    getPublishVideo(state) {
      return state.publishVideo;
    },
  },
  mutations: {
    SINGLE_MEETING(state, data) {
      state.singleUsers.push(data);
      sessionStorage.setItem("sessionCode", data.roomcode);
    },
    GOURP_MEETING(state, data) {
      state.groupUsers.push(data);
      sessionStorage.setItem("sessionCode", data.roomcode);
    },
    changePublishAudio(state) {
      state.publishAudio = !state.publishAudio;
    },
    changePublishVideo(state) {
      state.publishVideo = !state.publishVideo;
    },
  },
  actions: {
    singleMeeting({ commit }, params) {
      api({
        url: `/alone`,
        method: "GET",
        data: params,
      }).then(({ data }) => {
        commit("SINGLE_MEETING", data);
        router.push("/alone/roomcode");
      });
    },
    groupMeeting({ commit }, params) {
      api({
        url: `/group`,
        method: "GET",
        data: params,
      }).then(({ data }) => {
        commit("GOURP_MEETING", data);
        router.push("/group");
      });
    },
  },
};
export default meetingStore;
