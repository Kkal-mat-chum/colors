<template>
  <div class="colorTournPage">
    <!-- <carousel v-model=index:per-page="1" class="banner_list"></carousel>
    </carousel> -->
    <customSidebar />
    <div class="dummyMarginColorTourn1"></div>
    <div class="bodyColorTourn1">
      <label for="titleColorTourn" class="titleColorTourn">자신과 더 어울리는 색을 선택하세요.</label>
      <label for="processColorTourn" class="subtitleColorTourn">4강 1 Round [1/2]</label>
    </div>
    <div class="bodyColorTourn2">
      <div class="dummyMarginColorTourn2"></div>
      <div class="imageColorTourn" id="imageColorTourn1"></div>
      <label for="vs" class="vsLabel">vs</label>
      <div class="imageColorTourn" id="imageColorTourn2"></div>
      <div class="dummyMarginColorTourn2"></div>
    </div>
    <div class="bodyColorTourn3">
      <label for="prosExplanation" class="prosExplanation">한 가지 색을 클릭하면 다음 라운드로 넘어갑니다.</label>
    </div>
  </div>
</template>

<script></script>

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
  border: 2px solid #d0d1ff;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
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
</style>
