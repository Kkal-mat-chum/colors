<template>
  <div class="bodyColorVote">
    <div class="bodyColorVote11">
      <div class="dummyMarginColorVote1"></div>
      <div class="gridColorVote1">
        <div class="sidelabelColorVote">
          <time-stamp></time-stamp>
        </div>
        <div class="titleColorVote">
          <label for="nameColorVote" class="labelColorVote" id="nameColorVote">{{ sub_nickname }}</label>
          <label for="colorVoteTitle" class="labelColorVote"> 과(와) 가장 어울리는 색을 선택하세요.</label>
        </div>
        <div class="sidelabelColorVote">{{ vote_round }}/{{ cnt }}</div>
      </div>
      <color-vote></color-vote>
    </div>
    <loadingImg v-if="show_loadingimg" :loadingText="loadingText" />
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
      selectedLst: [],
      show_loadingimg: false,
      loadingText: "결과를 불러오는 중 입니다",
    };
  },
  computed: {
    cnt() {
      return this.$store.state.resultStore.cnt;
    },
    vote_round() {
      return this.$store.state.resultStore.voteRound;
    },
    sub_nickname() {
      if (this.vote_round > this.cnt) {
        return this.$store.state.resultStore.data[this.cnt - 1].nickname;
      } else {
        console.log(this.vote_round);
        if (this.$store.state.resultStore.data[this.vote_round - 1].nickname) {
          return this.$store.state.resultStore.data[this.vote_round - 1].nickname;
        } else {
          return "nothing";
        }
      }
    },
  },
  watch: {
    vote_round(value) {
      if (value > this.cnt) {
        this.loading3sec();
      }
    },
  },
  beforeCreate() {
    console.log(sessionStorage.getItem("roomId"));
    axios
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
    setTimeout(() => {
      console.log("RandomVoting Page Created");
    }, 2000);
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
    loading3sec() {
      this.vote_Round = this.cnt;
      this.onLoadingImg();
      //투표 결과 저장
      this.saveTeamVoteResult();
      console.log("로딩창 켬");
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
          if (response.data.message == "fail") {
            swal("투표 결과", "투표 결과를 저장하는데 실패하였습니다.", "error");
          } else {
            this.startSumVoteResult();
          }
        });
    },
    //각 투표 합산put -> 투표 결과 가져오기get
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
          this.move2Result();
        });
    },
    move2Result() {
      setTimeout(() => {
        this.offLoadingImg();
        console.log("로딩창 끔");
        // 데이터 요청 보내고 받기@@@@@@@@@@@@@@@@@@@@@@
        this.$router.push("/nickresult");
      }, 4000);
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
