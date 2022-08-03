<template>
  <div class="topicListMaster" v-bind="$attrs">
    <div class="topicHeader">
      <span class="headerTitle">주제</span>
      <span class="headerDelete" v-if="isAdmin & isTopic">삭제</span>
      <span class="headerLike" v-if="isTopic">좋아요</span>
      <span class="headerEnter" v-if="isEnter"></span>
    </div>
    <div class="gridTopicList">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    isAdmin: {
      type: Boolean,
      default: false,
    },
    isTopic: {
      type: Boolean,
      default: false,
    },
    isEnter: {
      type: Boolean,
      default: false,
    },
  },
};
</script>

<style>
.topicListMaster {
  min-height: fit-content;
  /* height: 80vh; */
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
  align-items: center;
  color: #6667ab;
  background: #d0d1ff;
  border-bottom: 2px solid #919aa9;
}
.headerTitle {
  flex-basis: 60%;
  text-align: left;
  flex-grow: 3;
  margin: 5px auto;
  margin-left: 20px;
}
.headerDelte {
  flex-basis: 5%;
  flex-grow: 1;
}
.headerLike {
  flex-basis: 5%;
  flex-grow: 1;
}
.headerEnter {
  flex-basis: 5%;
  flex-grow: 2;
  margin: 5px 10px;
}
</style>
