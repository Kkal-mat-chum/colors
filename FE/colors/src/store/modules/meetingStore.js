import router from "@/router";
import { api } from "@/store";

const meetingStore = {
  state: {
    userName: "",
    roomType: "",
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
    isChatPanel(state) {
      return state.isChatPanel;
    },
    messages(state) {
      return state.messages;
    },
  },
  mutations: {
    SINGLE_MEETING(state, data) {
      state.singleUsers.push(data);
      state.roomType = "single";
      sessionStorage.setItem("roomId", data.data.roomcode);
    },
    GOURP_MEETING(state, data) {
      state.groupUsers.push(data);
      state.roomType = "group";
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
        url: `/room`,
        method: "POST",
        data: params,
      }).then(({ data }) => {
        if (data.message == "success") {
          commit("SINGLE_MEETING", data);
          console.log(data.data);
          sessionStorage.setItem("roomId", data.data.roomcode);
          sessionStorage.setItem("roomNum", data.data.roomid);
          router.push("/alone/" + data.data.roomcode);
        } else {
          alert("에러 발생 개발자 잘못입니다.. 죄송요 ㅠㅠ");
        }
      });
    },
    groupMeeting({ commit }, params) {
      api({
        url: `/room/join/group`,
        method: "POST",
        data: params,
      })
        .then(({ data }) => {
          console.log(data);
          console.log(data.message);
          commit("GOURP_MEETING", data);
          if (data.message === "success") {
            router.push("/team/" + sessionStorage.getItem("roomId"));
          } else {
            alert("입장코드를 다시 확인하세요.");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    madeGroupMeeting({ commit }, params) {
      api({
        url: `/room`,
        method: "POST",
        data: params,
      }).then(({ data }) => {
        commit("GOURP_MEETING", data);
        sessionStorage.setItem("roomId", data.data.roomcode);
        router.push("/team/" + data.data.roomcode);
      });
    },
    toggleChatPanel({ state, commit }) {
      commit("SET_IS_CHATPANEL", !state.isChatPanel);
      console.log(state.isChatPanel);
      if (state.isChatPanel === true) {
        setTimeout(() => {
          var chatDiv = document.getElementById("chat-area");
          console.log(chatDiv);
          chatDiv.scrollTo({
            top: chatDiv.scrollHeight - chatDiv.clientHeight,
            behavior: "smooth",
          });
        }, 500);
      }
    },
    sendMessage({ state }, message) {
      var messageData = {
        content: message,
        secretName: state.userName,
      };
      this.session.signal({
        type: "chat",
        data: JSON.stringify(messageData),
        to: [],
      });
    },
    topicMeetingRoom({ commit }, data) {
      api({
        url: `/room/join/random`,
        method: "POST",
        params: data,
      }).then(({ data }) => {
        if (data.message == "success") {
          commit("TOPIC_MEETING", data);
          console.log(data);
          router.push("/team/" + sessionStorage.getItem("roomId"));
        } else {
          alert("방인원이 가득찼습니다.");
        }
      });
    },
    pullRoom(data) {
      api({
        url: `/room/capacity`,
        method: "PUT",
        params: data,
      }).then(({ data }) => {
        console.log(data);
      });
    },
    leaveSession(data) {
      api({
        url: `/room/capacity`,
        method: "PUT",
        params: data,
      }).then(({ data }) => {
        console.log(data);
      });
    },
  },
};
export default meetingStore;
