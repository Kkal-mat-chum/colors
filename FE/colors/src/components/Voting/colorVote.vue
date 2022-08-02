<template>
  <div class="bodyColorVote">
    <customSidebar />
    <div class="dummyMarginColorVote1"></div>
    <div class="gridColorVote1">
      <div class="timeInColorVote">11:11</div>
      <label for="colorVoteTitle">자신과(와) 가장 어울리는 색을 선택해주세요.</label>
      <div class="procedureInColorVote">3/5</div>
    </div>
    <div class="gridColorVote2">
      <div class="imageColorVote" id="imageColorVote1"></div>
      <div class="imageColorVote" id="imageColorVote2"></div>
      <div class="imageColorVote" id="imageColorVote3"></div>
      <div class="imageColorVote" id="imageColorVote4"></div>
      <div class="imageColorVote" id="imageColorVote5"></div>
      <div class="imageColorVote" id="imageColorVote6"></div>
      <div class="imageColorVote" id="imageColorVote7"></div>
      <div class="imageColorVote" id="imageColorVote8"></div>
    </div>
    <div class="gridColorVote3">선택완료</div>
    <i class="fa-solid fa-circle-chevron-right"></i>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.bodyColorVote {
  border: 3px solid aqua;
  margin-left: 120px;
  height: 100%;
  width: 100%;
  /* display: flex;
  flex-direction: column;
  justify-content: center; */
}
.dummyMarginColorVote1 {
  height: 100%;
  width: 100%;
  background: #000;
}
.gridColorVote2 {
  display: flex;
  flex-direction: row;
}
.gridColorVote1 {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}
.imageColorVote {
  width: 100px;
  height: 80px;
  background: gray;
}
</style>
