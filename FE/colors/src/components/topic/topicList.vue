<template>
  <div class="topicListMaster">
    <div class="topicHeader">
      <span class="headerTitle">주제</span>
      <span class="headerDelete">삭제</span>
      <span class="headerLike">좋아요</span>
    </div>
    <div class="gridTopicList">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.topicListMaster {
  min-height: fit-content;
  height: 80vh;
}
.gridTopicList {
  display: grid;
  grid-template-rows: repeat(10, minmax(36px, auto));
  /* margin-left: 130px; */
}
.topicHeader {
  font: 24px "Pretendard Bold";
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-around;
  color: #6667ab;
  background: #d0d1ff;
  border-bottom: 2px solid #919aa9;
}
.headerTitle {
  flex-basis: 60%;
  text-align: left;
}
.headerDelte {
  flex-basis: 5%;
}
.headerLike {
  flex-basis: 5%;
}
</style>
