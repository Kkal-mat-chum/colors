<template>
  <div class="bodyColorVot">
    <div class="gridColorVote2">
      <div class="gridLeftBtnColorVote1">
        <!-- <i class="fa-solid fa-circle-chevron-right fa-flip-horizontal fa-3x leftBtnColorVote"></i> -->
      </div>
      <div class="gridPicturesColorVote">
        <div class="gridPicturesColorVote1">
          <img src="" alt="zero_img" class="imageColorVote" id="imageColorVote0" />
          <img src="" alt="first_img" class="imageColorVote" id="imageColorVote1" />
          <img src="" alt="second_img" class="imageColorVote" id="imageColorVote2" />
          <img src="" alt="third_img" class="imageColorVote" id="imageColorVote3" />
        </div>
        <div class="gridPicturesColorVote2">
          <img src="" alt="fourth_img" class="imageColorVote" id="imageColorVote4" />
          <img src="" alt="fifth_img" class="imageColorVote" id="imageColorVote5" />
          <img src="" alt="sixth_img" class="imageColorVote" id="imageColorVote6" />
          <img src="" alt="seventh_img" class="imageColorVote" id="imageColorVote7" />
          <!-- <div class="imageColorVote" id="imageColorVote8"></div> -->
        </div>
      </div>
      <div class="gridRightBtnColorVote">
        <!-- <i class="fa-solid fa-circle-chevron-right fa-3x rightBtnColorVote"></i> -->
      </div>
    </div>
    <div class="gridColorVote3">
      <customButton class="completeBtnColorVote" id="completeBtnColorVote" btnText="선택 완료" @click="testClick">선택 완료</customButton>
    </div>
  </div>
</template>

<script></script>

<style scoped>
.gridColorVote2 {
  width: 100%;
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
.imageColorVote {
  display: inline-block;
  width: 280px;
  height: 200px;
  margin: 3px 10px;
  border: 2px solid #d0d1ff;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
.imageColorVote:hover {
  border-color: #4a4d74;
}
.leftBtnColorVote {
  color: #6667ab;
  margin: 0px 5px 0px 30px;
}
.rightBtnColorVote {
  color: #6667ab;
  margin: 0px 30px 0px 5px;
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
</style>
