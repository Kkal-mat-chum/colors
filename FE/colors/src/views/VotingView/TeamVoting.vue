<template>
  <div class="bodyColorVote">
    <customSidebar />
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
      <color-vote></color-vote>
    </div>
    <loadingImg v-if="show_loadingimg" />
  </div>
</template>

<script>
import axios from "axios";
import ColorVote from "../../components/Voting/colorVote.vue";
import TimeStamp from "../../components/Voting/customTimeStamp.vue";
import loadingImg from "../../components/Voting/loadingImg.vue";
import swal from "sweetalert";

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
      return this.$store.state.resultStore.data[this.vote_round - 1].name;
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
  methods: {
    loading3sec() {
      this.onLoadingImg();
      //투표 결과 저장
      this.saveTeamVoteResult();
      console.log("로딩창 켬");
      setTimeout(() => {
        this.offLoadingImg();
        console.log("로딩창 끔");
        // 데이터 요청 보내고 받기@@@@@@@@@@@@@@@@@@@@@@
        this.bringTotalResult();
        this.$router.push("/nameresult");
        this.$router.go();
      }, 3000);
    },
    onLoadingImg() {
      this.show_loadingimg = true;
    },
    offLoadingImg() {
      this.show_loadingimg = false;
    },
    //단체 투표 결과 저장
    saveTeamVoteResult() {
      axios
        .post(this.$store.state.baseurl + "room/vote", {
          roomid: sessionStorage.getItem("roomId"),
          voterid: sessionStorage.getItem("memberId"),
          content: this.$store.state.resultStore.voteContent,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.message == "fail") {
            console.log("단체 미팅 결과 저장 실패");
          }
        });
    },
    //각 투표 합산put -> 투표 결과 가져오기get
    bringTotalResult() {
      axios
        .put(this.$store.state.baseurl + "room/votesum", {
          roomid: sessionStorage.getItem("roomId"),
        })
        .then((response) => {
          if (response.data.message == "success") {
            console.log("투표결과 합산 완료!!!!!!!!!!!!!!!!!!!!!!!!!!");
          }
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
