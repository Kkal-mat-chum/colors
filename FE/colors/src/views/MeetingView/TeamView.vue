<template>
  <div class="TeamMeeting">
    <sidebar></sidebar>
    <div class="contents">
      <div class="camera">
        <div id="main-video" class="col-md-6">
          <userVideo class="webcam" :stream-manager="mainStreamManager" @changeStreamTrack="changeStream"></userVideo>
        </div>
        <div class="name">송 다 경</div>
        <div class="buttons">
          <customButton class="mute" btnText="음소거" @click="muteAudio"></customButton>
          <customButton class="videostop" btnText="비디오 중지" @click="muteVideo"></customButton>
        </div>

        <div class="anotherPerson">
          <!-- <userVideo_sub :stream-manager="publisher" @click.native="updateMainVideoStreamManager(publisher)" /> -->
          <div class="p_sub" v-for="sub in subscribers" :key="sub.stream.connection.connectionId">
            <UserVideo_sub class="webcam_sub" :key="sub.stream.connection.connectionId" :stream-manager="sub" @click.native="updateMainVideoStreamManager(sub)"></UserVideo_sub>
            <div class="name">{{ sub.id }}</div>
          </div>
        </div>
      </div>
      <div class="rightSidebar">
        <div class="title">
          <h3>나만의 색상 팔레트</h3>
          <hr />
        </div>
        <colorpallete class="pallete"></colorpallete>
        <div class="selectColor">
          <colorchoice></colorchoice>
        </div>
        <customButton class="selectColorbtn" btnText="색상 팔레트에 담기"></customButton>
        <div class="title">
          <h3>미팅 코드</h3>
          <hr />
        </div>
        <h2 class="code">A1ABEF13</h2>
        <customButton class="btn" btnText="채팅"></customButton>
        <customButton class="btn" btnText="투표하기"></customButton>
        <customButton class="btn" btnText="종료"></customButton>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { OpenVidu } from "openvidu-browser";

import sidebar from "@/components/common/customSidebar.vue";
import colorpallete from "@/components/myPage/colorPallete.vue";
import colorchoice from "@/components/videochat/colorPallete/colorChoice.vue";
import UserVideo from "@/components/videochat/UserVideo.vue";
import UserVideo_sub from "@/components/videochat/UserVideo_sub.vue";

axios.defaults.headers.post["Content-Type"] = "application/json";

// const OPENVIDU_SERVER_URL = "https://" + "i7b208.p.ssafy.io";
// const OPENVIDU_SERVER_SECRET = "i7b208";

const OPENVIDU_SERVER_URL = "https://" + location.hostname + ":4443";
const OPENVIDU_SERVER_SECRET = "MY_SECRET";

export default {
  name: "TeamMeeting",
  components: {
    sidebar,
    colorpallete,
    colorchoice,
    UserVideo,
    UserVideo_sub,
  },
  computed: {
    publishAudio() {
      return this.$store.getters.getPublishAudio;
    },
    publishVideo() {
      return this.$store.getters.getPublishVideo;
    },
  },
  data() {
    return {
      OV: undefined,
      session: true,
      mainStreamManager: undefined,
      publisher: undefined,
      subscribers: [],

      mySessionId: "SessionA",
      myUserName: "Participant" + Math.floor(Math.random() * 100),
    };
  },
  beforeMount() {
    this.joinSession();
  },
  mounted() {
    console.log("subscribers of the session");
    console.log("subscribers of the session");
    console.log("subscribers of the session");
    console.log("subscribers of the session");
    console.log("subscribers of the session");
    console.log("subscribers of the session");
    console.log("subscribers of the session");
    console.log(this.subscribers);
  },

  methods: {
    muteAudio() {
      this.publisher.publishAudio(this.publishAudio);
      console.log(this.publishAudio);
      this.$store.commit("changePublishAudio");
    },
    muteVideo() {
      this.publisher.publishVideo(this.publishVideo);
      this.$store.commit("changePublishVideo");
    },
    changeStream() {
      const canvas = document.getElementById("overlay");
      // console.log("get images");
      // console.log(canvas);

      const canvas_stream = canvas.captureStream();

      var myTrack = canvas_stream.getVideoTracks()[0];

      // Replacing video track
      this.publisher
        .replaceTrack(myTrack)
        .then(() => console.log("New track has been published"))
        .catch((error) => console.error("Error replacing track", error));
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

      // On every asynchronous exception...
      this.session.on("exception", ({ exception }) => {
        console.warn(exception);
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
              videoSource: undefined, // The source of video. If undefined default webcam
              publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
              publishVideo: true, // Whether you want to start publishing with your video enabled or not
              resolution: "800x420", // The resolution of your video
              frameRate: 30, // The frame rate of your video
              insertMode: "APPEND", // How the video is inserted in the target element 'video-container'
              mirror: false, // Whether to mirror your local video or not
            });

            this.mainStreamManager = publisher;
            this.publisher = publisher;

            // --- Publish your stream ---

            this.session.publish(this.publisher);
          })
          .catch((error) => {
            console.log("There was an error connecting to the session:", error.code, error.message);
          });
      });

      window.addEventListener("beforeunload", this.leaveSession);
    },

    leaveSession() {
      // --- Leave the session by calling 'disconnect' method over the Session object ---
      if (this.session) this.session.disconnect();

      this.session = undefined;
      this.mainStreamManager = undefined;
      this.publisher = undefined;
      this.subscribers = [];
      this.OV = undefined;

      window.removeEventListener("beforeunload", this.leaveSession);
    },

    updateMainVideoStreamManager(stream) {
      if (this.mainStreamManager === stream) return;
      this.mainStreamManager = stream;
    },

    /**
     * --------------------------
     * SERVER-SIDE RESPONSIBILITY
     * --------------------------
     * These methods retrieve the mandatory user token from OpenVidu Server.
     * This behavior MUST BE IN YOUR SERVER-SIDE IN PRODUCTION (by using
     * the API REST, openvidu-java-client or openvidu-node-client):
     *   1) Initialize a Session in OpenVidu Server	(POST /openvidu/api/sessions)
     *   2) Create a Connection in OpenVidu Server (POST /openvidu/api/sessions/<SESSION_ID>/connection)
     *   3) The Connection.token must be consumed in Session.connect() method
     */

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
html,
body {
  height: 100vh;
  overflow: hidden;
}
.contents {
  display: flex;
  margin-left: 120px;
  height: 100vh;
}
.camera {
  width: 157vh;
  text-align: center;
}
.webcam {
  display: inline-block;
  width: 400px;
  margin-top: 20px;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
.name {
  margin-top: 3px;
}
.mute {
  width: 150px;
  height: 35px;
  margin-right: 20px;
}
.videostop {
  width: 150px;
  height: 35px;
  margin-top: 3px;
}

/* 참여자들 캠 */
.anotherPerson {
  margin-top: 15px;
}
.p_sub {
  display: inline-block;
}
.webcam_sub {
  width: 250px;
  margin: 10px 20px 0px 20px;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}

/* 우측 사이드 바 */
.rightSidebar {
  width: 40vh;
  height: 100vh;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
  text-align: center;
}
.title {
  margin-left: 5vh;
}
.title h3 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 15px 0 10px 0;
}

.title > hr {
  display: flex;
  width: 28vh;
  margin: 0;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}

.pallete {
  display: inline-block;
  margin-top: 10px;
}

.selectColor {
  display: inline-block;
  margin-top: 15px;
}

.selectColorbtn {
  width: 200px;
  margin-top: 10px;
}

.code {
  margin: 8px;
}

.btn {
  width: 200px;
  margin-top: 7px;
}
/* our */
#local-video-undefined {
  width: 20vh;
}
</style>
