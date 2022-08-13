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
      sessionStorage.setItem("roomId", data.data.roomcode);
    },
    GOURP_MEETING(state, data) {
      state.groupUsers.push(data);
      sessionStorage.setItem("roomId", data.data.roomcode);
    },
  },
  actions: {
    singleMeeting({ commit }, params) {
      api({
        url: `/room`,
        method: "POST",
        data: params,
      }).then(({ data }) => {
        commit("SINGLE_MEETING", data);
        console.log(data.data.roomcode);
        router.push("/alone/" + data.data.roomcode);
      });
    },
    groupMeeting({ commit }, params) {
      api({
        url: `/room/join/group`,
        method: "POST",
        data: params,
      }).then(({ data }) => {
        commit("GOURP_MEETING", data);
        if (data.data.message === "success") {
          router.push("/group/" + sessionStorage.getItem("roomId"));
        } else {
          alert("입장코드를 다시 확인하세요.");
        }
      });
    },
    madeGroupMeeting({ commit }, params) {
      api({
        url: `/room`,
        method: "POST",
        data: params,
      }).then(({ data }) => {
        commit("GOURP_MEETING", data);
        router.push("/team/" + data.data.roomcode);
      });
    },
  },
};
export default meetingStore;
