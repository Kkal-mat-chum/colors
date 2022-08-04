<template>
  <div class="bodyColorVote">
    <div class="dummyMarginColorVote1"></div>
    <div class="gridColorVote1">
      <div class="sidelabelColorVote">11:11</div>
      <div class="titleColorVote">
        <label for="nameColorVote" class="labelColorVote" id="nameColorVote">name</label>
        <label for="colorVoteTitle" class="labelColorVote">과(와) 가장 어울리는 색을 선택하세요.</label>
      </div>
      <div class="sidelabelColorVote">3/5</div>
    </div>
    <div class="gridColorVote2">
      <div class="gridLeftBtnColorVote1">
        <i class="fa-solid fa-circle-chevron-right fa-flip-horizontal fa-3x leftBtnColorVote"></i>
      </div>
      <div class="gridPicturesColorVote">
        <div class="gridPicturesColorVote1">
          <div class="imageColorVote" id="imageColorVote1"></div>
          <div class="imageColorVote" id="imageColorVote2"></div>
          <div class="imageColorVote" id="imageColorVote3"></div>
          <div class="imageColorVote" id="imageColorVote4"></div>
        </div>
        <div class="gridPicturesColorVote2">
          <div class="imageColorVote" id="imageColorVote5"></div>
          <div class="imageColorVote" id="imageColorVote6"></div>
          <div class="imageColorVote" id="imageColorVote7"></div>
          <div class="imageColorVote" id="imageColorVote8"></div>
        </div>
      </div>
      <div class="gridRightBtnColorVote">
        <i class="fa-solid fa-circle-chevron-right fa-3x rightBtnColorVote"></i>
      </div>
    </div>
    <div class="gridColorVote3">
      <customButton class="completeBtnColorVote" id="completeBtnColorVote" btnText="선택 완료" @click="testClick">선택 완료</customButton>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.bodyColorVote {
  /* border: 3px solid aqua; */
  margin-left: 120px;
  height: 730px;
  width: 1400px;
  /* display: flex;
  flex-direction: column;
  justify-content: center; */
}
.dummyMarginColorVote1 {
  height: 10%;
  width: 100%;
  /* display: block;
  display: flex;
  flex-direction: column;
  justify-content: space-between; */
  /* background: #000; */
}
.gridColorVote2 {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.gridPicturesColorVote {
  display: flex;
  flex-direction: column;
  padding: 50px 0;
}
.gridPicturesColorVote1 {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
.gridPicturesColorVote2 {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
.gridColorVote1 {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.imageColorVote {
  display: inline-block;
  width: 280px;
  height: 200px;
  /* width: 200px;
  height: 100px; */
  /* margin-top: 150px; */
  /* margin: 50px 10px; */
  margin: 3px 10px;
  border: 2px solid #d0d1ff;
  border-radius: 15px;
  /* margin: 5% 0% 0% 5%; */
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
  /* width: 100px;
  height: 80px;
  background: gray; */
}
.leftBtnColorVote {
  color: #6667ab;
  margin: 0px 5px 0px 30px;
}
.rightBtnColorVote {
  color: #6667ab;
  margin: 0px 30px 0px 5px;
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
.gridColorVote3 {
  display: flex;
  flex-direction: row;
  justify-content: right;
}
#completeBtnColorVote {
  width: 20%;
  margin-right: 100px;
}
#nameColorVote {
  color: #f34d75;
}
</style>
