<template>
  <div class="colorTournPage">
    <div class="dummyMarginColorTourn1"></div>
    <div class="bodyColorTourn1">
      <label for="titleColorTourn" class="titleColorTourn">자신과 더 어울리는 색을 선택하세요.</label>
      <label for="processColorTourn" class="subtitleColorTourn">{{ processed }} {{ round }} {{ nowAndTotal }}</label>
    </div>
    <div class="bodyColorTourn2">
      <div class="dummyMarginColorTourn2"></div>
      <!-- <div class="imageColorTourn" id="imageColorTourn1" @click="[selectFirstImage(), selectImage()]">
        <img :src="require(`@/${firstImageUrl}`)" alt="sample1" class="imageColorTourn"  />
      </div> -->
      <img :src="tournImgUrls1" class="imageColorTourn" id="imageColorTourn1" @click="[selectFirstImage(), selectImage()]" />
      <label for="vs" class="vsLabel">vs</label>
      <!-- <div class="imageColorTourn" id="imageColorTourn2" @click="[selectSecondImage(), selectImage()]">
        <img :src="require(`@/${secondImageUrl}`)" alt="sample2" class="imageTourn" />
      </div> -->
      <img :src="tournImgUrls2" class="imageColorTourn" id="imageColorTourn2" @click="[selectSecondImage(), selectImage()]" />
      <div class="dummyMarginColorTourn2"></div>
    </div>
    <div class="bodyColorTourn3">
      <label for="prosExplanation" class="prosExplanation">한 가지 색을 클릭하면 다음 라운드로 넘어갑니다.</label>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "aloneTournament",
  data() {
    return {
      process: 8,
      round: 1,
      processed: "8강",
      tournOrder: [0, 1, 2, 3, 4, 5, 6, 7],
      initFirstImageIdx: 0,
      initSecondImageIdx: 1,
      // firstImageUrl: this.$store.state.imgUrlList[this.firstImageIdx],
      tournamentResultLst: [],
    };
  },
  computed: {
    tournImgUrls1: function () {
      return this.$store.state.resultStore.aloneResult.data[0].urls[this.firstImageIdx];
    },
    tournImgUrls2: function () {
      return this.$store.state.resultStore.aloneResult.data[0].urls[this.secondImageIdx];
    },
    // tournOrder: function () {
    //   return this.$store.state.selectedColorLst;
    // },
    firstImageIdx: function () {
      return this.tournOrder[this.initFirstImageIdx];
    },
    secondImageIdx: function () {
      return this.tournOrder[this.initSecondImageIdx];
    },
    nowAndTotal: function () {
      if (this.process >= 4) {
        return "Round [" + this.round + "/" + this.process / 2 + "]";
      } else {
        return "Final Round";
      }
    },
  },
  mounted() {
    var room = sessionStorage.getItem("roomId");
    console.log(room);
    axios
      .post(this.$store.state.baseurl + "room/getresult", {
        roomid: room,
      })
      .then((response) => {
        console.log(response);
        this.$store.state.resultStore.aloneResult = response.data;
        this.$store.state.resultStore.data = response.data;
        this.$store.state.resultStore.cnt = response.data.cnt;
        this.$store.state.selectedColorLst = response.data.data[0].colors;
        this.$store.state.aloneImageUrlLst = response.data.data[0].urls;
      });
  },
  methods: {
    //미팅 결과 가져오기, store에 저장(memberStore, store(팔레트용))
    getResult() {},
    selectFirstImage() {
      this.tournOrder.push(this.firstImageIdx);
      this.tournamentResultLst.push(this.$store.state.selectedColorLst[this.firstImageIdx]);
    },
    selectSecondImage() {
      this.tournOrder.push(this.secondImageIdx);
      this.tournamentResultLst.push(this.$store.state.selectedColorLst[this.secondImageIdx]);
    },
    selectImage() {
      console.log(this.process);
      // 양쪽 img idx 2씩 증가
      this.initFirstImageIdx = this.initFirstImageIdx + 2;
      this.initSecondImageIdx = this.initSecondImageIdx + 2;
      //라운드 1 증가
      this.round = this.round + 1;
      //8강이면 4라운드까지만 진행. 5라운드 되면 4강으로 바꿈
      if (this.process < this.round * 2) {
        this.process = this.process / 2;
        this.round = 1;
        this.processed = String(this.process) + "강";
      }
      //2강은 결승 출력
      if (this.process == 2) {
        this.processed = "결승";
        this.round = "";
        this.process = this.process / 2;
      } else if (this.process < 2) {
        this.processed = "";
        this.round = "";
        this.$store.state.tournamentResultLst = this.$store.state.selectedColorLst.concat(this.tournamentResultLst);
        // console.log(this.$store.state.tournamentResultLst);
        // 토너먼트 결과 저장 put
        this.saveVoteResult();
        this.bringTotalResult();

        var index = this.tournOrder[14];
        this.$store.state.resultStore.totalResultTop1.url = this.$store.state.aloneImageUrlLst[index];
        this.$store.state.resultStore.totalResultTop1.code = this.$store.state.selectedColorLst[index];
        this.$router.push("/tournamentnameresult");
        // this.processed = "끗";
      }
    },
    saveVoteResult() {
      console.log("결과 전송");
      console.log(this.$store.state.tournamentResultLst[14]);
      axios
        .put(this.$store.state.baseurl + "room/vote", {
          roomid: sessionStorage.getItem("roomId"),
          userid: sessionStorage.getItem("memberId"),
          code: this.$store.state.tournamentResultLst[14],
        })
        .then((response) => {
          this.bringTotalResult();
          if (response.data.message == "fail") {
            alert("전송 실패");
          }
        });
    },
    //각 투표 합산put -> 투표 결과 가져오기get
    bringTotalResult() {
      axios
        .post(this.$store.state.baseurl + "room/vote/result", {
          roomid: sessionStorage.getItem("roomId"),
          userid: sessionStorage.getItem("memberId"),
        })
        .then((response) => {
          if (response.data.message == "success") {
            console.log(response.data);
            this.$store.state.resultStore.totalResultTop1 = response.data.data;
          } else {
            axios
              .post(this.$store.state.baseurl + "room/vote/result", {
                roomid: sessionStorage.getItem("roomId"),
                userid: sessionStorage.getItem("memberId"),
              })
              .then((response) => {
                if (response.data.message == "success") {
                  console.log(response.data);
                  this.$store.state.resultStore.totalResultTop1 = response.data.data;

                  this.$router.push("/tournamentnameresult");
                } else {
                  alert("투표결과가져오기 실패");
                }
              });
          }
        });
    },
  },
};
</script>

<style scoped>
.colorTournPage {
  /* border: 3px solid aqua; */
  margin-left: 120px;
  height: 730px;
  width: 1400px;
}
.bodyColorTourn1 {
  display: flex;
  flex-direction: column;
}
.dummyMarginColorTourn1 {
  height: 10%;
  width: 100%;
}
.titleColorTourn {
  color: #4a4d74;
  font-size: 180%;
  font-weight: 600;
  margin-bottom: 30px;
}
.subtitleColorTourn {
  color: #6667ab;
  font-size: 230%;
  font-weight: 500;
}
.bodyColorTourn2 {
  display: flex;
  flex-direction: row;
  padding: 15px 0;
  justify-content: space-evenly;
  align-items: center;
}
.dummyMarginColorTourn2 {
  width: 10%;
}
.imageColorTourn {
  display: inline-block;
  width: 528px;
  height: 380px;
  margin: 3px 10px;
  border: 3px solid #d0d1ff;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
.imageColorTourn:hover {
  border: 3px solid #4a4d74;
}
.vsLabel {
  font-size: 35px;
  color: #aaaabc;
  margin: 0 5px;
}
.bodyColorTourn3 {
  display: flex;
  flex-direction: row;
  justify-content: right;
}
.prosExplanation {
  margin-right: 150px;
  margin-top: 10px;
  color: #aaaabc;
}
.imageTourn {
  width: 100%;
  height: 100%;
}
</style>
