<template>
  <div class="tournamentResultBody">
    <custom-sidebar></custom-sidebar>
    <div class="mainPicture">
      <!-- <div class="picture1" :style="resultTournColor" id="tournResult10" @click="test"></div> -->
      <img :src="top1" class="picture1" />
      <div class="titleColor">
        {{ finalWinColor }}
        <!-- <div>컬러네임</div> -->
      </div>
    </div>
    <div class="lineFlex">
      <hr class="line1" />
    </div>
    <hr class="line2" />
    <div class="lineFlex2">
      <hr class="line1" />
      <hr class="line1" />
    </div>
    <div class="secondPictures">
      <div class="picture2" :style="resultTournColor" id="tournResult20"></div>
      <div class="picture2" :style="resultTournColor" id="tournResult21"></div>
      <!-- <img src="@/assets/join_img1.png" alt="예시사진" class="picture2" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture2" /> -->
    </div>
    <div class="lineFlex3">
      <hr class="line1" />
      <hr class="line1" />
    </div>
    <div class="lineFlex3">
      <hr class="line4" />
      <hr class="line4" />
    </div>
    <div class="lineFlex3">
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
    </div>
    <div class="thirdPictures">
      <div class="picture3" :style="resultTournColor" id="tournResult40"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult41"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult42"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult43"></div>
      <!-- <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" /> -->
    </div>
    <div class="lineFlex4">
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
      <hr class="line5" />
    </div>
    <div class="lineFlex3">
      <hr class="line6" />
      <hr class="line6" />
      <hr class="line6" />
      <hr class="line6" />
    </div>
    <div class="lineFlex4">
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
      <hr class="line7" />
    </div>
    <div class="firthPictures">
      <div class="picture3" :style="resultTournColor" id="tournResult80"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult81"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult82"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult83"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult84"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult85"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult86"></div>
      <div class="picture3" :style="resultTournColor" id="tournResult87"></div>
      <!-- <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" />
      <img src="@/assets/join_img1.png" alt="예시사진" class="picture3" /> -->
    </div>
    <div class="button">
      <custom-button btnText="닫 기" class="buttonStyle" @click="go"></custom-button>
    </div>
    <div class="ment">최근 색상 정보는 마이페이지에서 확인하실 수 있습니다.</div>
  </div>
</template>

<script>
// import axios from "axios";
import customSidebar from "../common/customSidebar.vue";

export default {
  components: { customSidebar },
  //토너먼트 끝났을 때 결과 저장하기로 했어요. 안되면 이걸로 시도하기
  //시작할 때 axios put으로 결과 저장하는 법
  mounted() {
    // this.saveVoteResult();
  },
  methods: {
    go() {
      this.$router.push("/enterPage");
      this.$router.go();
    },
    // saveVoteResult() {
    //   console.log("결과 전송");
    //   console.log(this.$store.state.tournamentResultLst[14]);
    //   axios
    //     .put(this.$store.state.memberStore.baseurl + "/api/room/vote", {
    //       roomid: sessionStorage.getItem("roomId"),
    //       userid: sessionStorage.getItem("memberId"),
    //       code: this.$store.state.tournamentResultLst[14],
    //     })
    //     .then((response) => {
    //       console.log(response);
    //       if (response.data.message == "fail") {
    //         alert("전송 실패");
    //       }
    //       //fail이면 alert 해야하나요..?
    //     });
    // },
  },
  computed: {
    resultTournColor() {
      return {
        "--background-color-8-0": this.$store.state.tournamentResultLst[0],
        "--background-color-8-1": this.$store.state.tournamentResultLst[1],
        "--background-color-8-2": this.$store.state.tournamentResultLst[2],
        "--background-color-8-3": this.$store.state.tournamentResultLst[3],
        "--background-color-8-4": this.$store.state.tournamentResultLst[4],
        "--background-color-8-5": this.$store.state.tournamentResultLst[5],
        "--background-color-8-6": this.$store.state.tournamentResultLst[6],
        "--background-color-8-7": this.$store.state.tournamentResultLst[7],
        "--background-color-4-0": this.$store.state.tournamentResultLst[8],
        "--background-color-4-1": this.$store.state.tournamentResultLst[9],
        "--background-color-4-2": this.$store.state.tournamentResultLst[10],
        "--background-color-4-3": this.$store.state.tournamentResultLst[11],
        "--background-color-2-0": this.$store.state.tournamentResultLst[12],
        "--background-color-2-1": this.$store.state.tournamentResultLst[13],
        "--background-color-1-0": this.$store.state.tournamentResultLst[14],
      };
    },
    finalWinColor() {
      return this.$store.state.tournamentResultLst[14];
    },
    top1() {
      console.log(this.$store.state.resultStore.totalResultTop1.url);
      return this.$store.state.resultStore.totalResultTop1.url;
    },
  },
};
</script>

<style scoped>
.tournamentResultBody {
  display: block;
  justify-content: center;
  margin: 0 15% 0 15%;
}
.mainPicture {
  margin-top: 4%;
}
.picture1 {
  width: 250px;
  height: 100px;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
}
.titleColor {
  font-weight: 400;
  font-size: 30px;
  color: #4a4c74;
}
.line1 {
  display: flex;
  width: 18px;
  height: 5px;
  background-color: #aaaabc;
  transform: rotate(90deg);
}
.lineFlex {
  display: flex;
  justify-content: center;
}
.line2 {
  width: 540px;
  height: 5px;
  background-color: #aaaabc;
  margin-top: -1px;
}
.line4 {
  width: 270px;
  height: 5px;
  background-color: #aaaabc;
  margin-top: -2px;
}
.line6 {
  width: 141px;
  height: 5px;
  background-color: #aaaabc;
  margin-top: -2px;
}
.lineFlex2 {
  display: flex;
  flex-direction: row;
  margin-top: -16px;
}
.lineFlex3 {
  display: flex;
  flex-direction: row;
  margin-top: 0px;
}
.lineFlex4 {
  display: flex;
  flex-direction: row;
  margin-top: 15px;
}
.secondPictures {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.thirdPictures {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.firthPictures {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-top: -8px;
}
.picture2 {
  width: 120px;
  height: 88px;
  border-radius: 20px;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
}
.line5 {
  display: flex;
  width: 18px;
  height: 5px;
  background-color: #aaaabc;
  transform: rotate(90deg);
  margin-top: -8px;
}
.line7 {
  width: 18px;
  height: 5px;
  background-color: #aaaabc;
  transform: rotate(90deg);
  margin-top: -22px;
}
.picture3 {
  width: 120px;
  height: 88px;
  border-radius: 20px;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
}
.button {
  display: flex;
  justify-content: right;
  margin-top: 2%;
  margin-right: 4%;
}
.buttonStyle {
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
  margin-right: 37px;
  margin-top: 1%;
  font-weight: 400;
  font-size: 15px;
  color: #aaaabc;
}
div.clickEffect {
  position: fixed;
  box-sizing: border-box;
  border-style: solid;
  border-color: #000000;
  border-radius: 50%;
  animation: clickEffect 0.4s ease-out;
  z-index: 99999;
}
div.clickEffect {
  position: fixed;
  box-sizing: border-box;
  border-style: solid;
  border-color: #aaaabc;
  border-radius: 50%;
  animation: clickEffect 0.4s ease-out;
  z-index: 999999;
}
#tournResult80 {
  background-color: var(--background-color-8-0);
}
#tournResult81 {
  background-color: var(--background-color-8-1);
}
#tournResult82 {
  background-color: var(--background-color-8-2);
}
#tournResult83 {
  background-color: var(--background-color-8-3);
}
#tournResult84 {
  background-color: var(--background-color-8-4);
}
#tournResult85 {
  background-color: var(--background-color-8-5);
}
#tournResult86 {
  background-color: var(--background-color-8-6);
}
#tournResult87 {
  background-color: var(--background-color-8-7);
}
#tournResult40 {
  background-color: var(--background-color-4-0);
}
#tournResult41 {
  background-color: var(--background-color-4-1);
}
#tournResult42 {
  background-color: var(--background-color-4-2);
}
#tournResult43 {
  background-color: var(--background-color-4-3);
}
#tournResult20 {
  background-color: var(--background-color-2-0);
}
#tournResult21 {
  background-color: var(--background-color-2-1);
}
#tournResult10 {
  background-color: var(--background-color-1-0);
}
</style>
