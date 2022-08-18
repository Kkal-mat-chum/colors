<template>
  <div class="bodyColorVote">
    <div class="bodyColorVote11">
      <div class="dummyMarginColorVote1"></div>
      <div class="gridColorVote1">
        <div class="sidelabelColorVote">
          <time-stamp></time-stamp>
        </div>
        <div class="titleColorVote">
          <label for="nameColorVote" class="labelColorVote" id="nameColorVote">{{ sub_name }}</label>
          <label for="colorVoteTitle" class="labelColorVote"> 과(와) 가장 어울리는 색을 선택하세요.</label>
        </div>
        <div class="sidelabelColorVote">{{ vote_round }}/{{ cnt }}</div>
      </div>
      <color-vote :loadVoteData="false" @startTime="timeStampOn"></color-vote>
    </div>
    <loadingImg v-if="show_loadingimg" :loadingText="loadingText" />
  </div>
</template>

<script>
import axios from "axios";
import { OpenVidu } from "openvidu-browser";
import ColorVote from "../../components/Voting/colorVote.vue";
import TimeStamp from "../../components/Voting/customTimeStamp.vue";
import loadingImg from "../../components/Voting/loadingImg.vue";
import swal from "sweetalert";

const OPENVIDU_SERVER_URL = "https://" + location.hostname + ":4443";
const OPENVIDU_SERVER_SECRET = "MY_SECRET";

export default {
  components: {
    ColorVote,
    TimeStamp,
    loadingImg,
  },
  data() {
    return {
      // cnt: this.$store.state.resultStore.cnt,
      // voteRound: this.$store.state.resultStore.voteRound,
      selectedLst: [],
      show_loadingimg: false,
      loadingText: "결과를 불러오는 중 입니다",
      startTimeStamp: false,
      mySessionId: sessionStorage.getItem("roomCode"),
      myUserName: JSON.parse(sessionStorage.getItem("memberData")).data.nickname,
      OV: undefined,
      session: true,
      mainStreamManager: undefined,
      publisher: undefined,
      subscribers: [],
      ishost: false,
      ready: true,
      readyAll: false,
      readys: {},
      numberOFparti: this.participantUpdate(this.mySessionId),
    };
  },
  computed: {
    cnt() {
      return this.$store.state.resultStore.cnt;
    },
    vote_round() {
      return this.$store.state.resultStore.voteRound;
    },
    sub_name() {
      if (this.vote_round > this.cnt) {
        return "nothing";
      } else {
        console.log(this.vote_round);
        console.log(this.$store.state.resultStore);
        if (this.$store.state.resultStore.data[this.vote_round - 1].name) {
          return this.$store.state.resultStore.data[this.vote_round - 1].name;
        } else {
          return "nothing";
        }
      }
    },
    // show_loadingimg() {
    //   if (this.cnt < this.vote_round) {
    //     return true;
    //   } else {
    //     return false;
    //   }
    // },
  },
  watch: {
    vote_round(value) {
      if (value > this.cnt) {
        this.loading3sec();
      }
    },
  },
  async beforeCreate() {
    console.log(sessionStorage.getItem("roomId"));
    await axios
      .post(this.$store.state.baseurl + "room/getresult", {
        roomid: sessionStorage.getItem("roomId"),
      })
      .then((response) => {
        console.log(response);
        this.$store.state.resultStore.aloneResult = response.data;
        this.$store.state.resultStore.data = response.data.data;
        this.$store.state.resultStore.cnt = response.data.data.length;
        this.$store.state.selectedColorLst = response.data.data[0].colors;
        this.$store.state.aloneImageUrlLst = response.data.data[0].urls;
      });
    setTimeout(() => {}, 500);
  },
  mounted() {
    this.mySessionId = this.mySessionId + "vote";
    // this.joinSession();
    if (sessionStorage.getItem("hostId") == sessionStorage.getItem("memberId")) {
      this.ishost = true;
    }
    console.log(this.mySessionId);
  },
  beforeRouteLeave(to, from, next) {
    // this.leaveSession();
    sessionStorage.setItem("hostId", -1);
    setTimeout(() => {
      next();
      // this.$router.go();
    }, 100);
  },
  methods: {
    timeStampOn() {
      this.startTimeStamp = true;
    },
    loading3sec() {
      this.vote_Round = this.cnt;
      this.onLoadingImg();
      //투표 결과 저장
      this.saveTeamVoteResult();
      console.log("로딩창 켬");
      console.log(this.show_loadingimg);
    },
    onLoadingImg() {
      this.show_loadingimg = true;
    },
    offLoadingImg() {
      this.show_loadingimg = false;
    },
    //단체 투표 결과 저장
    async saveTeamVoteResult() {
      console.log(this.$store.state.resultStore.voteContent);
      await axios
        .post(this.$store.state.baseurl + "room/vote", {
          roomid: sessionStorage.getItem("roomId"),
          voterid: sessionStorage.getItem("memberId"),
          content: this.$store.state.resultStore.voteContent,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.message == "fail") {
            console.log(this.$store.state.resultStore.voteContent);
            swal("투표 결과", "투표 결과를 저장하는데 실패하였습니다.", "error");
          } else {
            this.startSumVoteResult();
          }
        });
    },
    //각 투표 합산put -> 투표 결과 가져오기post
    startSumVoteResult() {
      axios
        .put(this.$store.state.baseurl + "room/votesum", {
          roomid: sessionStorage.getItem("roomId"),
        })
        .then((response) => {
          if (response.data.message == "success") {
            console.log("투표결과 합산 완료!!!!!!!!!!!!!!!!!!!!!!!!!!");
          } else {
            swal("투표 결과", "투표 결과를 합산하는데 실패하였습니다.", "error");
          }
          // this.doneVote();
          this.move2Result();
        });
    },
    doneVote() {
      var vote = this.ready;
      this.session.signal({
        type: "vote",
        data: JSON.stringify(vote),
        to: [],
      });
      this.ready = !vote;
    },
    finishVote() {
      this.session.signal({
        type: "finish",
        to: [],
      });
    },
    move2Result() {
      setTimeout(() => {
        this.offLoadingImg();
        console.log("로딩창 끔");
        // 데이터 요청 보내고 받기@@@@@@@@@@@@@@@@@@@@@@
        this.$router.push("/nameresult");
      }, 6000);
    },
    joinSession() {
      // --- Get an OpenVidu object ---
      this.OV = new OpenVidu();

      // --- Init a session ---
      this.session = this.OV.initSession();

      // --- Specify the actions when events take place in the session ---

      // On every new Stream received...
      this.session.on("streamCreated", ({ stream }) => {
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
      });

      // On every Stream destroyed...
      this.session.on("streamDestroyed", ({ stream }) => {
        const index = this.subscribers.indexOf(stream.streamManager, 0);
        if (index >= 0) {
          this.subscribers.splice(index, 1);
        }
      });
      // get signal for ready to vote(on/off)(true/false)
      this.session.on("signal:vote", (event) => {
        var voteData = JSON.parse(event.data);
        var voteName = event.from.connectionId; // Connection object of the sender
        this.readys[voteName] = voteData;
        var readyNumber = Object.values(this.readys).filter((readyCheck) => true == readyCheck).length;
        if (readyNumber == this.numberOFparti) {
          console.log("Every People done to Vote");
          console.log("Every People done to Vote");
          if (this.ishostCopy) {
            this.finishVote();
          }
        }
      });

      // get signal for move to votePage
      this.session.on("signal:finish", () => {
        console.log("done Vote move to Result");
        this.move2Result();
      });

      // --- Connect to the session with a valid user token ---

      // 'getToken' method is simulating what your server-side should do.
      // 'token' parameter should be retrieved and returned by your own backend
      this.getToken(this.mySessionId).then((token) => {
        this.session
          .connect(token, { clientData: this.myUserName })
          .then(() => {
            // --- Get your own camera stream with the desired properties ---

            let publisher = this.OV.initPublisher(undefined, {
              audioSource: undefined, // The source of audio. If undefined default microphone
              videoSource: false, // The source of video. If undefined default webcam
              publishAudio: false, // Whether you want to start publishing with your audio unmuted or not
              publishVideo: false, // Whether you want to start publishing with your video enabled or not
              resolution: "600x315", // The resolution of your video
              frameRate: 10, // The frame rate of your video
              insertMode: "APPEND", // How the video is inserted in the target element 'video-container'
            });

            this.mainStreamManager = publisher;
            this.publisher = publisher;
            this.session.publish(this.publisher);
          })
          .catch((error) => {
            console.log("There was an error connecting to the session:", error.code, error.message);
          });
      });

      window.addEventListener("beforeunload", this.leaveSession);
    },
    participantUpdate(sessionId) {
      axios
        .get(`${OPENVIDU_SERVER_URL}/openvidu/api/sessions/${sessionId}`, {
          auth: {
            username: "OPENVIDUAPP",
            password: OPENVIDU_SERVER_SECRET,
          },
        })
        .then((response) => {
          this.numberOFparti = response.data.connections.numberOfElements;
          console.log(response);
          console.log(response.data.connections.numberOfElements);
          console.log("값확인이전");
        });
      return this.numberOFparti;
    },
    leaveSession() {
      // --- Leave the session by calling 'disconnect' method over the Session object --->
      if (this.session) {
        this.participantUpdate(this.mySessionId);
        this.session.disconnect();
        this.session = undefined;
        this.mainStreamManager = undefined;
        this.publisher = undefined;
        this.subscribers = [];
        this.OV = undefined;
      }
      window.removeEventListener("beforeunload", this.leaveSession);
    },
    getToken(mySessionId) {
      return this.createSession(mySessionId).then((sessionId) => this.createToken(sessionId));
    },

    // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-session
    createSession(sessionId) {
      return new Promise((resolve, reject) => {
        axios
          .post(
            `${OPENVIDU_SERVER_URL}/openvidu/api/sessions`,
            JSON.stringify({
              customSessionId: sessionId,
            }),
            {
              auth: {
                username: "OPENVIDUAPP",
                password: OPENVIDU_SERVER_SECRET,
              },
            }
          )
          .then((response) => response.data)
          .then((data) => resolve(data.id))
          .catch((error) => {
            if (error.response.status === 409) {
              resolve(sessionId);
            } else {
              console.warn(`No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}`);
              if (
                window.confirm(
                  `No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}\n\nClick OK to navigate and accept it. If no certificate warning is shown, then check that your OpenVidu Server is up and running at "${OPENVIDU_SERVER_URL}"`
                )
              ) {
                location.assign(`${OPENVIDU_SERVER_URL}/accept-certificate`);
              }
              reject(error.response);
            }
          });
      });
    },

    // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-connection
    createToken(sessionId) {
      return new Promise((resolve, reject) => {
        axios
          .post(
            `${OPENVIDU_SERVER_URL}/openvidu/api/sessions/${sessionId}/connection`,
            {},
            {
              auth: {
                username: "OPENVIDUAPP",
                password: OPENVIDU_SERVER_SECRET,
              },
            }
          )
          .then((response) => response.data)
          .then((data) => resolve(data.token))
          .catch((error) => reject(error.response));
      });
    },
  },
};
</script>

<style scoped>
.bodyColorVote11 {
  margin-left: 120px;
  height: 700px;
  width: 1400px;
}
.dummyMarginColorVote1 {
  height: 10%;
  width: 100%;
}
.gridColorVote1 {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.labelColorVote {
  color: #4a4d74;
  font-size: 180%;
  font-weight: 600;
}
.sidelabelColorVote {
  color: #6667ab;
  font-size: 180%;
  font-weight: 600;
  margin-right: 50px;
}
#nameColorVote {
  color: #f34d75;
}
.titleColorVote {
  margin-right: 50px;
  display: block;
}
</style>
