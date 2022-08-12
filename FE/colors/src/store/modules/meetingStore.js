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
      sessionStorage.setItem("sessionCode", data.roomcode);
    },
    GOURP_MEETING(state, data) {
      state.groupUsers.push(data);
      sessionStorage.setItem("sessionCode", data.roomcode);
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
        router.push("/alone/"+ data.roomcode);
      });
    },
    groupMeeting({ commit }, params) {
      api({
        url: `/group`,
        method: "GET",
        data: params,
      }).then(({ data }) => {
        commit("GOURP_MEETING", data);
        router.push("/group/"+ data.roomcode);
      });
    },
  },
};
export default meetingStore;
