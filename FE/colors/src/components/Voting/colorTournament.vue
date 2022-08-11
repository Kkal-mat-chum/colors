<template>
  <div class="colorTournPage">
    <div class="dummyMarginColorTourn1"></div>
    <div class="bodyColorTourn1">
      <label for="titleColorTourn" class="titleColorTourn">자신과 더 어울리는 색을 선택하세요.</label>
      <label for="processColorTourn" class="subtitleColorTourn">{{ processed }} {{ round }} Round [{{ round }}/{{ process / 2 }}]</label>
    </div>
    <div class="bodyColorTourn2">
      <div class="dummyMarginColorTourn2"></div>
      <!-- <div class="imageColorTourn" id="imageColorTourn1" @click="[selectFirstImage(), selectImage()]">
        <img :src="require(`@/${firstImageUrl}`)" alt="sample1" class="imageColorTourn"  />
      </div> -->
      <img src="" alt="sample1" class="imageColorTourn" id="imageColorTourn1" @click="[selectFirstImage(), selectImage()]" />
      <label for="                                                                                                                   vs" class="vsLabel">vs</label>
      <!-- <div class="imageColorTourn" id="imageColorTourn2" @click="[selectSecondImage(), selectImage()]">
        <img :src="require(`@/${secondImageUrl}`)" alt="sample2" class="imageTourn" />
      </div> -->
      <img src="" alt="sample2" class="imageColorTourn" id="imageColorTourn2" @click="[selectSecondImage(), selectImage()]" />
      <div class="dummyMarginColorTourn2"></div>
    </div>
    <div class="bodyColorTourn3">
      <label for="prosExplanation" class="prosExplanation">한 가지 색을 클릭하면 다음 라운드로 넘어갑니다.</label>
    </div>
  </div>
</template>

<script>
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
    };
  },
  // computed: {
  //   firstImageUrl: function () {
  //     return this.$store.state.imgUrlList[this.firstImageIdx];
  //   },
  //   secondImageUrl: function () {
  //     return this.$store.state.imgUrlList[this.secondImageIdx];
  //   },
  //   firstImageIdx: function () {
  //     return this.tournOrder[this.initFirstImageIdx];
  //   },
  //   secondImageIdx: function () {
  //     return this.tournOrder[this.initSecondImageIdx];
  //   },
  // },
  methods: {
    selectFirstImage() {
      this.tournOrder.push(this.firstImageIdx);
    },
    selectSecondImage() {
      this.tournOrder.push(this.secondImageIdx);
    },
    selectImage() {
      // console.log("이게맞나????");
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
        this.imageName = "sampleimage3";
      }
      //2강은 결승 출력
      if (this.process === 2) {
        this.processed = "결승";
        this.round = "Final";
      } else if (this.process < 2) {
        this.processed = "끗";
      }
      console.log(this.tournOrder);
      // console.log(this.$store.state.imgUrlList[0]);
    },
    // domouseover() {

    //   console.log(this.tournOrder);
    // },
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
