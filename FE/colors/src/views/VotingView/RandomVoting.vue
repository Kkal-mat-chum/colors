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
          <label for="nameColorVote" class="labelColorVote" id="nameColorVote">{{ sub_nickname }}</label>
          <label for="colorVoteTitle" class="labelColorVote"> 과(와) 가장 어울리는 색을 선택하세요.</label>
        </div>
        <div class="sidelabelColorVote">{{ vote_round }}/{{ cnt }}</div>
      </div>
      <color-vote></color-vote>
    </div>
  </div>
</template>

<script>
import ColorVote from "../../components/Voting/colorVote.vue";
import TimeStamp from "../../components/Voting/customTimeStamp.vue";

export default {
  components: {
    ColorVote,
    TimeStamp,
  },
  data() {
    return {
      selectedLst: [],
    };
  },
  computed: {
    cnt() {
      return this.$store.state.memberStore.cnt;
    },
    vote_round() {
      return this.$store.state.memberStore.voteRound;
    },
    sub_nickname() {
      return this.$store.state.memberStore.data[this.vote_round - 1].nickname;
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
