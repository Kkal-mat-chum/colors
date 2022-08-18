<template>
  <div class="TeamMeeting">
    <div class="contents">
      <div class="camera">
        <div id="main-video" class="col-md-6">
          <userVideo class="webcam" id="webcam" :stream-manager="mainStreamManager" @changeStreamTrack="changeStream"></userVideo>
        </div>
        <div class="name">{{ myUserName }}</div>
        <div class="buttons">
          <customButton class="mute" :class="{ muteActive: publishAudio }" btnText="음소거" @click="muteAudio"></customButton>
          <customButton class="videostop" :class="{ muteActive: publishVideo }" btnText="비디오 중지" @click="muteVideo"></customButton>
        </div>

        <div class="anotherPerson">
          <div class="p_sub" v-for="sub in subscribers" :key="sub.stream.connection.connectionId">
            <UserVideo_sub class="webcam_sub" :key="sub.stream.connection.connectionId" :stream-manager="sub" @click.native="updateMainVideoStreamManager(sub)"></UserVideo_sub>
          </div>
        </div>
      </div>
      <div class="rightPannelArea">
        <div class="chatPanelArea" v-if="isChatPanel">
          <Chatpanel @sendMessage="sendMessage" />
        </div>
        <div class="rightSidebar" v-if="!isChatPanel">
          <div class="title">
            <h3>나만의 색상 팔레트</h3>
            <hr />
          </div>
          <colorpallete class="pallete"></colorpallete>
          <div class="selectColor">
            <colorchoice @changeColor="changeColor"></colorchoice>
          </div>
          <customButton class="selectColorbtn" btnText="색상 팔레트에 담기" ref="colorchoice" @click="showOneSelectedColor"></customButton>
          <div class="title">
            <h3>{{ roomHeaderTitle }}</h3>
            <hr />
          </div>
          <h2 class="code">{{ roomHeaderData }}</h2>
          <customButton class="btn" btnText="채팅" @click="toggleChatPanel"></customButton>
          <!-- <customButton class="btn" btnText="투표하기" @click="goVote"></customButton> -->
          <customButton class="btn" :class="{ muteActive: !ready }" btnText="투표하기" @click="sendVote"></customButton>
          <customButton class="btn" btnText="투표 시작" v-if="ishostCopy & readyAll" @click="startSaving"></customButton>
          <customButton class="btn" btnText="시작" v-if="ishost" @click="start"></customButton>
          <customButton class="btn" btnText="종료" v-if="!ishost" @click="leaveMeeting"></customButton>
          <custom-modal class="startInfoModal" id="startInfoModal" v-show="showstartModal" @close-modal="showstartModal = false" titleText="호스트 공지사항">
            <cotent>
              <div class="content">
                <p class="notice">참여자들의 입장이 완료되면 반드시 <strong style="font-size: 24px" id="notice">시작</strong> 버튼을 눌러주세요.</p>
                <p class="notice">시작을 눌러야 미팅 중 다른 참여자들의 입장을 막을 수 있습니다.</p>
              </div>
              <customButton class="btn" btnText="확인" @click="showstartModal = false"></customButton>
            </cotent>
          </custom-modal>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapActions } from "vuex";
import { OpenVidu } from "openvidu-browser";
import html2canvas from "html2canvas";
import AWS from "aws-sdk";
import mixin from "@/components/videochat/colorPallete/mixin";
import colorpallete from "@/components/myPage/colorPallete.vue";
import colorchoice from "@/components/videochat/colorPallete/colorChoice.vue";
import UserVideo from "@/components/videochat/UserVideo.vue";
import UserVideo_sub from "@/components/videochat/UserVideo_sub.vue";
import Chatpanel from "@/components/videochat/chatPanel.vue";
import swal from "sweetalert";

axios.defaults.headers.post["Content-Type"] = "application/json";

// const OPENVIDU_SERVER_URL = "https://" + "i7b208.p.ssafy.io";
// const OPENVIDU_SERVER_SECRET = "i7b208";

const OPENVIDU_SERVER_URL = "https://" + location.hostname + ":4443";
const OPENVIDU_SERVER_SECRET = "MY_SECRET";

export default {
  name: "TeamMeeting",
  components: {
    colorpallete,
    colorchoice,
    UserVideo,
    UserVideo_sub,
    Chatpanel,
  },
  mixins: [mixin],
  computed: {
    rgba() {
      return {
        r: this.r,
        g: this.g,
        b: this.b,
        a: this.a,
      };
    },
    hsv() {
      return {
        h: this.h,
        s: this.s,
        v: this.v,
      };
    },
    isChatPanel() {
      return this.$store.getters.isChatPanel;
    },
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
      ishost: false,
      mySessionId: sessionStorage.getItem("roomCode"),
      myUserName: JSON.parse(sessionStorage.getItem("memberData")).data.nickname,
      modelRgba: "",
      modelHex: "",
      r: 0,
      g: 0,
      b: 0,
      a: 1,
      h: 0,
      s: 0,
      v: 0,
      count_pallete: 0,
      selectedColorLst: ["#000000", "#000000", "#000000", "#000000", "#000000", "#000000"],
      awsid: process.env.VUE_APP_AWS_IDENTITYPOOLID,
      memberData: JSON.parse(sessionStorage.getItem("memberData")).data,
      roomHeaderTitle: "",
      roomHeaderData: "",
      ready: true,
      readyAll: false,
      readys: {},
      numberOFparti: this.participantUpdate(this.mySessionId),
      ishostCopy: false,
      isTrackChanged: false,
      isSave: true,
      savings: {},
    };
  },
  created() {
    Object.assign(this, this.setColorValue(this.color));
    this.setText();
    if (this.$store.state.meetingStore.roomType == "group") {
      this.roomHeaderTitle = "미팅 코드";
      this.roomHeaderData = sessionStorage.getItem("roomCode");
      this.myUserName = this.memberData.name;
    } else if (this.$store.state.meetingStore.roomType == "random") {
      this.roomHeaderTitle = "미팅 주제";
      this.roomHeaderData = sessionStorage.getItem("toppicTitle");
      this.myUserName = this.memberData.nickname;
    }
  },
  beforeMount() {
    if (this.publishAudio) {
      this.$store.commit("changePublishAudio");
    }
    if (this.publishVideo) {
      this.$store.commit("changePublishVideo");
    }
    this.joinSession();
  },
  mounted() {
    console.log(sessionStorage.getItem("roomCode"));
    console.log(sessionStorage.getItem("roomId"));
    console.log(this.subscribers);
    if (sessionStorage.getItem("hostId") == sessionStorage.getItem("memberId")) {
      this.ishost = true;
      swal("호스트 공지사항", '참여자 입장이 완료되면 반드시 "시작" 버튼을 눌려주세요. \n 미팅 진행 중 다른 참여자들의 입장을 막을 수 있습니다.', "info");
    }
  },
  beforeRouteLeave(to, from, next) {
    this.leaveSession();
    sessionStorage.setItem("hostId", -1);
    setTimeout(() => {
      next();
      this.$router.go();
    }, 100);
  },
  methods: {
    ...mapActions(["toggleChatPanel"]),
    leaveMeeting() {
      this.leaveSession();
      this.$router.push("/enterPage");
    },
    start() {
      this.ishost = false;
      this.ishostCopy = true;
      let memberData = JSON.parse(sessionStorage.getItem("memberData"));
      let userid = memberData.data.id;
      let roomnum = sessionStorage.getItem("roomId");
      console.log(roomnum);
      axios
        .put(this.$store.state.baseurl + "room/status", {
          roomid: roomnum,
          hostid: userid,
        })
        .then((response) => {
          console.log(response);
        });
    },
    // 선택한 색의 컬러코드를 store에 저장
    showOneSelectedColor() {
      if (this.count_pallete < 8) {
        this.modelHex = this.rgb2hex(this.rgba, true);
        console.log(this.modelHex);
        var duplicated = 0;
        console.log(this.$store.state.selectedColorLst);
        for (var i = 0; i < this.count_pallete; i++) {
          if (this.$store.state.selectedColorLst[i] == this.modelHex) {
            swal("색상 담기", "중복된 색이 있습니다.", "error");
            duplicated = 1;
          }
        }
        if (duplicated == 1) {
          return;
        }
        this.$store.commit("NEW_COLOR", { color: this.modelHex });
        this.selectedColorLst = this.$store.state.selectedColorLst;
        this.selectedColorLst.splice(this.count_pallete, 1, this.$store.state.storeselectedColor.color);
        this.$store.state.selectedColorLst = this.selectedColorLst;

        var name = this.modelHex.substr(1);
        console.log(name);
        var awsid = this.awsid;
        var userid = sessionStorage.getItem("userId");
        var count = this.count_pallete;
        html2canvas(document.getElementById("webcam")).then(function (canvas) {
          // document.getElementById("webcam").appendChild(canvas);
          var img = canvas.toDataURL("image/jpeg");
          console.log(img);

          // base64 -> image file
          var arr = img.split(","),
            mime = arr[0].match(/:(.*?);/)[1],
            bstr = atob(arr[1]),
            n = bstr.length,
            u8arr = new Uint8Array(n);

          while (n--) {
            u8arr[n] = bstr.charCodeAt(n);
          }

          var file = new File([u8arr], name, { type: mime });

          console.log(file);

          // s3 upload
          AWS.config.update({
            region: "ap-northeast-2",
            credentials: new AWS.CognitoIdentityCredentials({
              IdentityPoolId: awsid,
            }),
          });

          var s3 = new AWS.S3({
            apiVersion: "2012-10-17",
            params: {
              Bucket: "ssafy7color",
            },
          });

          var date = new Date();
          var yyyymmdd = date.getFullYear() + "" + (date.getMonth() + 1) + date.getDate();
          var roomcode = sessionStorage.getItem("roomCode");

          let photoKey = yyyymmdd + "/" + userid + "/" + roomcode + "/" + name + count + ".jpg";

          s3.upload(
            {
              Key: photoKey,
              Body: file,
              ACL: "public-read",
            },
            (err, data) => {
              if (err) {
                console.log(err);
              }
              console.log("Successfully uploaded photo.");
              console.log(data);
            }
          );
        });
        // this.count++;
        this.count_pallete++;
      } else {
        swal("색상 담기", "컬러 팔레트가 꽉찼습니다.", "error");
      }
      setTimeout(() => {}, 500);
    },

    gosaving() {
      this.$store.state.resultStore.cnt = this.numberOFparti;
      var awsid = this.awsid;
      var userid = sessionStorage.getItem("userId");
      // file 가져오기
      AWS.config.update({
        region: "ap-northeast-2",
        credentials: new AWS.CognitoIdentityCredentials({
          IdentityPoolId: awsid,
        }),
      });

      var s3 = new AWS.S3({
        apiVersion: "2012-10-17",
        params: {
          Bucket: "ssafy7color",
        },
      });

      var date = new Date();
      var yyyymmdd = date.getFullYear() + "" + (date.getMonth() + 1) + date.getDate();
      var roomcode = sessionStorage.getItem("roomCode");

      let photoKey = yyyymmdd + "/" + userid + "/" + roomcode + "/";

      console.log(photoKey);

      s3.listObjects(
        {
          Delimiter: "/",
          Prefix: photoKey,
        },
        (err, data) => {
          if (err) {
            return swal("투표하기", "There was an error : " + err.message, "error");
          } else {
            var colorsets = [];
            var colorset = { url: "", code: "" };
            this.lists = data.Contents;
            this.lists.forEach((list) => {
              var imgurl = "https://ssafy7color.s3.ap-northeast-2.amazonaws.com/" + list.Key;
              var colorcode = "#" + imgurl.slice(imgurl.length - 11, imgurl.length - 5);
              // console.log(code);
              colorset = { url: imgurl, code: colorcode };
              colorsets.push(colorset);
            });
            console.log(colorsets);
            // 미팅 정보 db 저장
            let roomnum = sessionStorage.getItem("roomId");
            let memberData = JSON.parse(sessionStorage.getItem("memberData"));
            let userid = memberData.data.id;
            const colorsetResult = {
              roomid: roomnum,
              userid: userid,
              colorset: colorsets,
            };
            console.log(colorsetResult);
            axios.post(this.$store.state.baseurl + "room/result", colorsetResult).then((response) => {
              console.log(response);
              this.doneSaving();
            });
          }
        }
      );
    },

    goVote() {
      setTimeout(() => {
        this.$router.push("/teamVoting");
      }, 6000);
    },
    dataURLtoFile(dataurl, fileName) {
      var arr = dataurl.split(","),
        mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]),
        n = bstr.length,
        u8arr = new Uint8Array(n);

      while (n--) {
        u8arr[n] = bstr.charCodeAt(n);
      }

      return new File([u8arr], fileName, { type: mime });
    },

    setText() {
      this.modelHex = this.rgb2hex(this.rgba, true);
      this.modelRgba = `${this.r}, ${this.g}, ${this.b}, ${this.a}`;
    },
    changeColor(color) {
      const { r, g, b, a, h, s, v } = this.setColorValue(color.rgba);
      Object.assign(this, { r, g, b, a, h, s, v });
      this.modelHex = color.hex;

      this.$store.state.r = this.r;
      this.$store.state.g = this.g;
      this.$store.state.b = this.b;
    },
    sendMessage(message) {
      var messageData = {
        content: message,
        secretName: this.myUserName,
        // secretName: this.$storestate.userName,
      };
      this.session.signal({
        type: "chat",
        data: JSON.stringify(messageData),
        to: [],
      });
    },
    sendReconnect(connectionId) {
      this.session.signal({
        type: "reconnect",
        to: [connectionId],
      });
    },
    sendVote() {
      var vote = this.ready;
      // var name = this.myUserName;
      // this.readys[name] = vote;
      this.session.signal({
        type: "vote",
        data: JSON.stringify(vote),
        to: [],
      });
      this.ready = !vote;
    },
    doneSaving() {
      var saving = this.isSave;
      this.session.signal({
        type: "saving",
        data: JSON.stringify(saving),
        to: [],
      });
      this.isSave = !saving;
    },
    startVote() {
      this.session.signal({
        type: "goVote",
        to: [],
      });
    },
    startSaving() {
      this.session.signal({
        type: "goSaving",
        to: [],
      });
    },
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
      if (!this.isTrackChanged) {
        const canvas = document.getElementById("overlay");
        const canvas_stream = canvas.captureStream();
        var myTrack = canvas_stream.getVideoTracks()[0];
        // Replacing video track
        this.publisher
          .replaceTrack(myTrack)
          .then(() => {
            console.log("New track has been published");
            this.isTrackChanged = true;
          })
          .catch((error) => console.error("Error replacing track", error));
      } else {
        console.log("Already track has been changed");
      }
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
        setTimeout(() => {
          this.participantUpdate(this.mySessionId);
        }, 100);
      });

      // On every Stream destroyed...
      this.session.on("streamDestroyed", ({ stream }) => {
        const index = this.subscribers.indexOf(stream.streamManager, 0);
        if (index >= 0) {
          this.subscribers.splice(index, 1);
        }
      });

      // get signal for chat from everyone
      this.session.on("signal:chat", (event) => {
        let eventData = JSON.parse(event.data);
        let data = new Object();
        data.message = eventData.content;
        data.sender = event.from.data.slice(15, -2);
        this.$store.commit("SET_MESSAGES", data);
      });

      // get signal for ready to vote(on/off)(true/false)
      this.session.on("signal:vote", (event) => {
        var voteData = JSON.parse(event.data);
        var voteName = event.from.connectionId; // Connection object of the sender
        this.readys[voteName] = voteData;
        var readyNumber = Object.values(this.readys).filter((readyCheck) => true == readyCheck).length;
        if (readyNumber == this.numberOFparti) {
          console.log("Every People Ready to Vote");
          console.log("asfdjjsjfslkjflkjsflkjalkjslkjasfd");
          if (this.ishostCopy) {
            this.readyAll = true;
          }
        } else {
          this.readyAll = false;
        }
      });

      this.session.on("signal:saving", (event) => {
        var savingData = JSON.parse(event.data);
        var savingName = event.from.connectionId; // Connection object of the sender
        console.log(event);
        this.savings[savingName] = savingData;
        var readyNumber = Object.values(this.savings).filter((readyCheck) => true == readyCheck).length;
        if (readyNumber == this.numberOFparti) {
          console.log("Every People Ready to saving");
          console.log("asfdjjsjfslkjflkjsflkjalkjslkjasfd");
          if (this.ishostCopy) {
            this.startVote();
          }
        }
      });

      // get signal for move to votePage
      this.session.on("signal:goVote", () => {
        console.log("Start Vote");
        this.goVote();
      });
      this.session.on("signal:goSaving", () => {
        console.log("Start Saving");
        this.gosaving();
      });

      // get signal that my video is not palyed on subscriber's page
      this.session.on("signal:reconnect", () => {
        console.log(this.publisher);
        console.log(this.mainStreamManager);
        this.publisher.stream.reconnect();
      });

      // openvidu recommend for reconnecting video
      this.session.on("reconnecting", () => console.warn("Oops! Trying to reconnect to the session"));
      this.session.on("reconnected", () => console.log("Hurray! You successfully reconnected to the session"));
      this.session.on("sessionDisconnected", (event) => {
        if (event.reason === "networkDisconnect") {
          console.warn("Dang-it... You lost your connection to the session");
        }
      });

      // On every asynchronous exception...
      this.session.on("exception", (event) => {
        if (event.name === "ICE_CONNECTION_FAILED") {
          var stream = event.origin;
          console.warn("Stream " + stream.streamId + " broke!");
          console.warn("Reconnection process automatically started");
        }
        // if (event.name === "ICE_CONNECTION_DISCONNECTED") {
        //   var stream_dis = event.origin;
        //   console.warn("Stream " + stream_dis.streamId + " disconnected!");
        //   console.warn("Giving it some time to be restored. If not possible, reconnection process will start");
        // }
        if (event.name == "NO_STREAM_PLAYING_EVENT") {
          this.sendReconnect(event.origin.stream.connection.connectionId);
        }
        console.warn(event);
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
              resolution: "600x315", // The resolution of your video
              frameRate: 60, // The frame rate of your video
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
        console.log(this.getSession(this.mySessionId));
      });

      window.addEventListener("beforeunload", this.leaveSession);
    },
    getSession(sessionId) {
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
          if (response.data.connections.numberOfElements > 6) {
            console.log("값확인");
            let roomid = {
              roomid: sessionStorage.getItem("roomId"),
            };
            console.log(roomid);
            this.leaveSession();
            this.$store.dispatch("pullRoom", roomid);
          }
        });
      return this.numberOFparti;
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
        if (this.numberOFparti == 6) {
          this.$store.dispatch("leaveSession", this.mySessionId);
        } else if (this.numberOFparti == 1) {
          this.start();
        }
        this.session.disconnect();
        this.session = undefined;
        this.mainStreamManager = undefined;
        this.publisher = undefined;
        this.subscribers = [];
        this.OV = undefined;
        this.$store.commit("SET_CLEARMESSAGES");
      }
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
    exit() {
      this.$router.push("/enterPage");
      // this.$router.go();
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
  color: #434485;
}
.mute {
  width: 150px;
  height: 35px;
  margin-right: 20px;
}
.muteActive {
  background-color: #bcbdfc;
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
  width: 300px;
  margin: 10px 20px 0px 20px;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}

/* 우측 사이드 바 */
.rightPannelArea {
  height: 100vh;
}
.rightSidebar {
  height: 96%;
  padding-bottom: 25px;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
  text-align: center;
  width: 40vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}
.chatPanelArea {
  width: 37vh;
  /* height: 99%; */
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
}
.title h3 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 0 0 10px 0;
  padding-top: 15px;
}

.title > hr {
  display: flex;
  width: 24vh;
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
  width: 180px;
  margin-top: 10px;
}

.code {
  margin: 8px;
}

.btn {
  width: 190px;
  margin-top: 7px;
}
/* our */
#local-video-undefined {
  width: 20vh;
}
.notice {
  font-size: 20px;
  margin: 20px 10px 20px 10px;
  color: #6667ab;
}
#notice {
  color: #f34d75;
}
.content {
  margin: 80px 0px 70px 0px;
}
.br {
  margin: 10px;
}
</style>
