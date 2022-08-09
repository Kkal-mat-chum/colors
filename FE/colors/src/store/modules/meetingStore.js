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
  },
  getters: {},
  mutations: {
    SINGLE_MEETING(state, data) {
      state.singleUsers.push(data);
    },
    GOURP_MEETING(state, data) {
      state.groupUsers.push(data);
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
        console.log("dd");
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
