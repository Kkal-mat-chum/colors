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
          <label for="nameColorVote" class="labelColorVote" id="nameColorVote">name</label>
          <label for="colorVoteTitle" class="labelColorVote">과(와) 가장 어울리는 색을 선택하세요.</label>
        </div>
        <div class="sidelabelColorVote">3/5</div>
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
}
#nameColorVote {
  color: #f34d75;
}
</style>
