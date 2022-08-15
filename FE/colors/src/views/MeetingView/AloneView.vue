<template>
  <div class="aloneMeeting">
    <div class="contents">
      <div class="camera">
        <webcam id="webcam" ref="camStream"></webcam>
        <div class="buttons">
          <customButton class="mute" :class="{ muteActive: publishAudio }" btnText="음소거" @click="muteAudio"></customButton>
          <customButton class="videostop" :class="{ muteActive: publishVideo }" btnText="비디오 중지" @click="muteVideo"></customButton>
        </div>
      </div>
      <div class="rightSidebar">
        <div class="title">
          <h2>나만의 색상 팔레트</h2>
          <hr />
        </div>
        <colorpallete class="pallete"></colorpallete>
        <div class="selectColor">
          <colorchoice @changeColor="changeColor"></colorchoice>
        </div>
        <customButton class="selectColorbtn" btnText="색상 팔레트에 담기" ref="colorchoice" @click="showOneSelectedColor"></customButton>
        <customButton class="votebtn" btnText="투표하기" @click="goVote"></customButton>
        <customButton class="exitbtn" btnText="종료" @click="exit"></customButton>
        <custom-modal class="updateUserProfileModal" id="updateUserProfileModal" v-show="showModal" @close-modal="showModal = false" titleText="투표 방식 선택">
          <cotent>
            <div class="vote">
              <div>
                <customButton class="selectVotebtn" btnText="토너먼트 형식으로 투표하기" @click="goton"></customButton>
              </div>
              <div>
                <customButton class="selectVotebtn" btnText="베스트 원픽 투표하기" @click="gobest"></customButton>
              </div>
              <div class="coment">토너먼트 형식 : 8강전부터 베스트 컬러 선택 <br />베스트 원픽 : 8개의 컬러 중 베스트 컬러 선택</div>
            </div>
          </cotent>
        </custom-modal>
      </div>
    </div>
  </div>
</template>

<script>
import mixin from "@/components/videochat/colorPallete/mixin";
import webcam from "@/components/videochat/webcamStream.vue";
import colorpallete from "@/components/myPage/colorPallete.vue";
import colorchoice from "@/components/videochat/colorPallete/colorChoice.vue";
import html2canvas from "html2canvas";
import AWS from "aws-sdk";
import axios from "axios";
import router from "@/router";

export default {
  name: "aloneMeeting",
  components: {
    webcam,
    colorpallete,
    colorchoice,
  },
  mixins: [mixin],
  data() {
    return {
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
      showModal: false,
    };
  },
  mounted() {
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.a = 1;

    let memberData = JSON.parse(sessionStorage.getItem("memberData"));
    let userid = memberData.data.id;
    let roomnum = sessionStorage.getItem("roomNum");
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
    publishAudio() {
      return this.$store.getters.getPublishAudio;
    },
    publishVideo() {
      return this.$store.getters.getPublishVideo;
    },
  },
  created() {
    Object.assign(this, this.setColorValue(this.color));
    this.setText();

    this.$watch("rgba", () => {
      this.$emit("changeColor", {
        rgba: this.rgba,
        hsv: this.hsv,
        hex: this.modelHex,
      });
    });
  },
  beforeRouteLeave(to, from, next) {
    this.$refs.camStream.leaveSession();
    setTimeout(() => {
      next();
      this.$router.go();
    }, 100);
  },
  methods: {
    goton() {
      router.push("/aloneTournament");
    },
    gobest() {
      router.push("/aloneVoting");
    },
    muteAudio() {
      console.log(this.publishAudio);
      this.$refs.camStream.muteAudio();
    },
    muteVideo() {
      this.$refs.camStream.muteVideo();
    },
    // 선택한 색의 컬러코드를 store에 저장
    showOneSelectedColor() {
      if (this.count_pallete < 8) {
        this.modelHex = this.rgb2hex(this.rgba, true);
        var duplicated = 0;
        console.log(this.$store.state.selectedColorLst);
        for (var i = 0; i < this.count_pallete; i++) {
          if (this.$store.state.selectedColorLst[i] == this.modelHex) {
            alert("중복된 색이 있습니다.");
            duplicated = 1;
          }
        }
        if (duplicated == 1) {
          return;
        }
        console.log(this.modelHex);
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
              Bucket: "ssafy7colors",
            },
          });

          var date = new Date();
          var yyyymmdd = date.getFullYear() + "" + (date.getMonth() + 1) + date.getDate();
          var roomcode = sessionStorage.getItem("roomId");

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
        alert("컬러 팔레트가 꽉찼습니다.");
      }
    },

    goVote() {
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
          Bucket: "ssafy7colors",
        },
      });

      var date = new Date();
      var yyyymmdd = date.getFullYear() + "" + (date.getMonth() + 1) + date.getDate();
      var roomcode = sessionStorage.getItem("roomId");

      let photoKey = yyyymmdd + "/" + userid + "/" + roomcode + "/";

      console.log(photoKey);

      s3.listObjects(
        {
          Delimiter: "/",
          Prefix: photoKey,
        },
        (err, data) => {
          if (err) {
            return alert("There was an error : " + err.message);
          } else {
            var colorsets = [];
            var colorset = { url: "", code: "" };
            this.lists = data.Contents;
            this.lists.forEach((list) => {
              var imgurl = "https://ssafy7colors.s3.ap-northeast-2.amazonaws.com/" + list.Key;
              var colorcode = "#" + imgurl.slice(imgurl.length - 11, imgurl.length - 5);
              // console.log(code);
              colorset = { url: imgurl, code: colorcode };
              colorsets.push(colorset);
            });
            console.log(colorsets);
            // 미팅 정보 db 저장
            let roomnum = sessionStorage.getItem("roomNum");
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
            });
          }
        }
      );
      this.showModal = true;
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
.vote {
  margin-top: 60px;
}
.selectVotebtn {
  height: 50px;
  width: 70%;
  margin-top: 20px;
}
.coment {
  text-align: right;
  margin-top: 10%;
  margin-right: 20px;
  color: darkgray;
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
#webcam {
  display: inline-block;
  width: 600px;
  height: 300px;
  margin-top: 150px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
.buttons {
  margin-top: 50px;
}
.muteActive {
  background-color: #bcbdfc;
}
.mute {
  width: 150px;
  margin-right: 20px;
}
.videostop {
  width: 150px;
}
.rightSidebar {
  width: 40vh;
  height: 100vh;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
  text-align: center;
}
.title {
  margin-left: 50px;
}
.title h2 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 30px 0 10px 0;
}

.title > hr {
  display: flex;
  width: 200px;
  margin: 0;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}

.pallete {
  display: inline-block;
  margin-top: 20px;
}

.selectColor {
  display: inline-block;
  background-color: #d0d1ff;
  margin-top: 25px;
}

.selectColorbtn {
  width: 200px;
  margin-top: 20px;
}

.votebtn {
  margin-top: 100px;
  width: 200px;
}
.exitbtn {
  width: 200px;
  margin-top: 10px;
}
</style>
