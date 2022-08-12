import router from "@/router";
import { api } from "@/store";

const meetingStore = {
  state: {
    userName: "",
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
    isChatPanel: false,
    messages: [],
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
    SET_IS_CHATPANEL(state, value) {
      state.isChatPanel = value;
    },
    SET_MESSAGES(state, data) {
      state.messages.push(data);
    },
    SET_CLEARMESSAGES(state) {
      state.messages = [];
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
        router.push("/alone/" + data.roomcode);
      });
    },
    groupMeeting({ commit }, params) {
      api({
        url: `/group`,
        method: "GET",
        data: params,
      }).then(({ data }) => {
        commit("GOURP_MEETING", data);
        router.push("/group/" + data.roomcode);
      });
    },
    toggleChatPanel({ state, commit }) {
      commit("SET_IS_CHATPANEL", !state.isChatPanel);
      console.log(state.isChatPanel);
      if (state.isChatPanel === true) {
        setTimeout(() => {
          var chatDiv = document.getElementById("chat-area");
          chatDiv.scrollTo({
            top: chatDiv.scrollHeight - chatDiv.clientHeight,
            behavior: "smooth",
          });
        }, 50);
      }
    },
    sendMessage({ state }, message) {
      var messageData = {
        content: message,
        secretName: state.userName,
      };
      state.session.signal({
        type: "chat",
        data: JSON.stringify(messageData),
        to: [],
      });
    },
  },
};
export default meetingStore;
