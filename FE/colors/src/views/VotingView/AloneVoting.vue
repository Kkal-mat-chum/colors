<template>
  <div class="bodyColorVote">
    <customSidebar />
    <div class="bodyColorVote11">
      <div class="dummyMarginColorVote1"></div>
      <div class="gridColorVote1">
        <div class="titleColorVote">
          <label for="colorVoteTitle" class="labelColorVote">자신에게 가장 어울리는 색을 선택하세요.</label>
        </div>
      </div>
      <color-vote></color-vote>
    </div>
  </div>
</template>

<script>
import ColorVote from "../../components/Voting/colorVote.vue";

export default {
  components: {
    ColorVote,
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
.gridPicturesColorVote {
  display: flex;
  flex-direction: column;
  padding: 50px 0;
}
.gridColorVote1 {
  /* margin-left: 120px; */
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.labelColorVote {
  color: #4a4d74;
  font-size: 180%;
  font-weight: 600;
}
</style>
