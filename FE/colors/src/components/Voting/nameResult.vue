<template>
  <div class="resultBody">
    <custom-sidebar></custom-sidebar>
    <h1 class="title">{{ userName }} 님과 가장 잘 어울리는 색상은?</h1>
    <div class="mainResult">
      <img :src="top1url" :alt="top1url" class="picture1" />
      <div class="colorMatchName">
        <div class="codeNum" :style="customFontColorMypickTop1" id="top1color">{{ top1color }}</div>
        <div :style="customFontColorMypickTop1" id="top1color">색상 이름</div>
      </div>
    </div>
    <div class="myPick">
      <img :src="mypickurl" :alt="mypickurl" class="picture2" />
      <div class="myColorPick">
        <div class="myPickName">{{ userName }}님의 픽</div>
        <div class="myPickCode" :style="customFontColorMypickTop1" id="mypickColor">{{ mypickcolor }}</div>
      </div>
    </div>
    <div class="otherPickTitle">
      <div class="otherTitle">참여자들이 추천한 색상</div>
    </div>
    <div class="otherPick">
      <div v-if="showResult[0]">
        <img :src="voteLst[0].url" :alt="voteLst[0].url" class="picture3" />
        <div class="otherName">{{ voteLst[0].vote }}</div>
        <div class="otherCode" :style="customVoterCodeColor" id="customeVoterCode1">{{ voteLst[0].code }}</div>
      </div>
      <div v-if="showResult[1]">
        <img :src="voteLst[1].url" :alt="voteLst[1].url" class="picture3" />
        <div class="otherName">{{ voteLst[1].vote }}</div>
        <div class="otherCode" :style="customVoterCodeColor" id="customeVoterCode1">{{ voteLst[1].code }}</div>
      </div>
      <div v-if="showResult[2]">
        <img :src="voteLst[2].url" :alt="voteLst[2].url" class="picture3" />
        <div class="otherName">{{ voteLst[2].vote }}</div>
        <div class="otherCode" :style="customVoterCodeColor" id="customeVoterCode1">{{ voteLst[2].code }}</div>
      </div>
      <div v-if="showResult[3]">
        <img :src="voteLst[3].url" :alt="voteLst[3].url" class="picture3" />
        <div class="otherName">{{ voteLst[3].vote }}</div>
        <div class="otherCode" :style="customVoterCodeColor" id="customeVoterCode1">{{ voteLst[3].code }}</div>
      </div>
      <div v-if="showResult[4]">
        <img :src="voteLst[4].url" :alt="voteLst[4].url" class="picture3" />
        <div class="otherName">{{ voteLst[4].vote }}</div>
        <div class="otherCode" :style="customVoterCodeColor" id="customeVoterCode1">{{ voteLst[4].code }}</div>
      </div>
      <!-- <div class="otherPick">
      <div v-for="(voteData, index) in voteLst" :key="index" :voteName="voteData.voter" :voteImgUrl="voteData.url" :voteColor="voteData.code">
        <img :src="voteImgUrl" :alt="voteImgUrl" class="picture3" />
        <div class="otherName">{{ voteName }}</div>
        <div class="otherCode">{{ voteColor }}</div>
      </div> -->
      <!-- <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" /> -->
    </div>
    <div class="cancelButton">
      <custom-button id="buttonStyle" @click="gotoEnterPage" btnText="닫 기"></custom-button>
    </div>
    <div class="ment">최근 색상 정보는 마이페이지에서 확인하실 수 있습니다.</div>
  </div>
</template>

<script>
import axios from "axios";
import customButton from "../common/customButton.vue";

export default {
  components: {
    customButton,
  },
  data() {
    return {
      voteLst: [],
      // voteLst: this.$store.state.resultStore.totalResultData, //다른사람들이 투표한 결과
      top1url: "",
      top1color: "",
      mypickurl: "",
      mypickcolor: "",
      userName: sessionStorage.getItem("userName"),
    };
  },
  computed: {
    customFontColorMypickTop1() {
      return {
        "--fontcolor-mypick": this.mypickcolor,
        "--fontcolor-top1": this.top1color,
      };
    },
    customVoterCodeColor() {
      if (this.$store.state.resultStore.cnt == 2) {
        return {
          "--fontcolor-voter0": this.voteLst[0].code,
        };
      } else if (this.$store.state.resultStore.cnt == 3) {
        return {
          "--fontcolor-voter0": this.voteLst[0].code,
          "--fontcolor-voter1": this.voteLst[1].code,
        };
      } else if (this.$store.state.resultStore.cnt == 4) {
        return {
          "--fontcolor-voter0": this.voteLst[0].code,
          "--fontcolor-voter1": this.voteLst[1].code,
          "--fontcolor-voter2": this.voteLst[2].code,
        };
      } else if (this.$store.state.resultStore.cnt == 5) {
        return {
          "--fontcolor-voter0": this.voteLst[0].code,
          "--fontcolor-voter1": this.voteLst[1].code,
          "--fontcolor-voter2": this.voteLst[2].code,
          "--fontcolor-voter3": this.voteLst[3].code,
        };
      } else if (this.$store.state.resultStore.cnt == 6) {
        return {
          "--fontcolor-voter0": this.voteLst[0].code,
          "--fontcolor-voter1": this.voteLst[1].code,
          "--fontcolor-voter2": this.voteLst[2].code,
          "--fontcolor-voter3": this.voteLst[3].code,
          "--fontcolor-voter4": this.voteLst[4].code,
        };
      } else {
        return "";
      }
    },
    showResult() {
      if (this.$store.state.resultStore.cnt == 1) {
        return [false, false, false, false, false];
      } else if (this.$store.state.resultStore.cnt == 2) {
        return [true, false, false, false, false];
      } else if (this.$store.state.resultStore.cnt == 3) {
        return [true, true, false, false, false];
      } else if (this.$store.state.resultStore.cnt == 4) {
        return [true, true, true, false, false];
      } else if (this.$store.state.resultStore.cnt == 5) {
        return [true, true, true, true, false];
      } else if (this.$store.state.resultStore.cnt == 6) {
        return [true, true, true, true, true];
      } else {
        return [false, false, false, false, false];
      }
    },
  },
  mounted() {
    this.saveVoteResult();
  },
  methods: {
    gotoEnterPage() {
      this.$router.push("/enterPage");
    },
    //투표 결과 가져오기
    saveVoteResult() {
      // //개인 투표의 경우
      // if (this.$store.state.resultStore.cnt == 1) {
      axios
        .get(this.$store.state.memberStore.baseurl + "/api/room/vote", {
          roomid: sessionStorage.getItem("roomId"),
          userid: sessionStorage.getItem("memberId"),
        })
        .then((response) => {
          console.log(response);
          if (response.message == "fail") {
            alert("전송 실패");
          } else {
            if (this.$store.state.resultStore.cnt > 1) {
              //여러명 미팅일 때, 본인이 선택한 것만 따로 저장
              for (var idx = 0; idx < this.$store.state.resultStore.cnt; idx++) {
                if (response.data[idx].voter != sessionStorage.getItem("userName")) {
                  this.voteLst.push(response.data[idx]);
                } else {
                  //본인이 선택한 내용
                  this.mypickurl = response.data[idx].url;
                  this.mypickcolor = response.data[idx].code;
                }
              }
            } else {
              //개인일때, top1에 data내용 저장
              this.mypickurl = response.data.url;
              this.mypickcolor = response.data.coed;
            }
          }
        });
      //   } else if (this.$store.state.resultStore.cnt > 1) {
      //     //단체, 랜덤 투표의 경우
      //     axios
      //       .post(this.$store.state.memberStore.baseurl + "/api/room/vote", {
      //         roomid: sessionStorage.getItem("roomId"),
      //         userid: sessionStorage.getItem("memberId"),
      //         content: 1, //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
      //       })
      //       .then((response) => {
      //         console.log(response);
      //         if (response.message == "fail") {
      //           alert("전송 실패");
      //         }
      //       });
      //   }
      // },
      // gotoEnterPage() {
      //   this.$router.push("/enterPage");
    },
  },
};
</script>

<style scoped>
.title {
  font-family: "Pretendard";
  font-style: normal;
  font-size: 36px;
  color: #4a4d74;
}
.resultBody {
  display: block;
  justify-content: center;
  margin: 0 15% 0 15%;
}
.mainResult {
  display: flex;
  flex-direction: row;
  margin-top: 4%;
  margin-left: 20%;
  width: 884px;
  height: 220px;
}
.otherPick {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  flex-direction: row;
  margin-top: 2%;
}
.otherPickTitle {
  display: flex;
  justify-content: center;
  margin-top: 3%;
}
.picture1 {
  width: 250px;
  height: 150px;
}
.colorMatchName {
  width: 35%;
  margin-top: 2%;
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 700;
  font-size: 50px;
  line-height: 50px;
  color: #ffd5d1;
}
.myPickName {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 700;
  font-size: 30px;
  color: #4a4d74;
}
.myPick {
  display: flex;
  flex-direction: row;
  margin-left: 30%;
  margin-top: -4%;
}
.picture2 {
  width: 200px;
  height: 100px;
}
.picture3 {
  width: 150px;
  height: 80px;
}
.myColorPick {
  margin-left: 5%;
}
.myPickCode {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
  font-size: 36px;
  color: #ffd5d1;
  margin-left: 5%;
}
.otherTitle {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 600;
  font-size: 32px;
  color: #aaaabc;
}
.otherName {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
  font-size: 36px;
  color: #4a4d74;
}
.otherCode {
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
  font-size: 30px;
  color: #b7b1ff;
}
.cancelButton {
  display: flex;
  flex-direction: row-reverse;
  margin-right: 10%;
}
#buttonStyle {
  font-size: 15px;
  width: 15%;
  color: #ff0000;
  font-family: "Pretendard";
  font-style: normal;
  font-weight: 400;
}
.ment {
  display: flex;
  justify-content: right;
  font-family: "Pretendard";
  font-style: normal;
  margin-right: 10%;
  margin-top: 1%;
  font-weight: 400;
  font-size: 15px;
  color: #aaaabc;
}
#customeVoterCode1 {
  color: var(--fontcolor-voter0);
}
#customeVoterCode2 {
  color: var(--fontcolor-voter1);
}
#customeVoterCode3 {
  color: var(--fontcolor-voter2);
}
#customeVoterCode4 {
  color: var(--fontcolor-voter3);
}
#customeVoterCode5 {
  color: var(--fontcolor-voter4);
}
#top1color {
  color: var(--fontcolor-top1);
}
#mypickColor {
  color: var(--fontcolor-mypick);
}
</style>
