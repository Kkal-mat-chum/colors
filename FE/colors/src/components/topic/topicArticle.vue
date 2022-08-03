<template>
  <div class="topicAritcleItem" v-bind="$attrs">
    <span class="topicTitle">the title</span>
    <span class="material-symbols-rounded topicDelete" v-if="isAdmin & isTopic">delete</span>
    <span class="material-symbols-rounded topicLike" v-if="isTopic">favorite</span>
    <customButton class="topicEnterButton" btnText="입장하기" v-if="isEnter"></customButton>
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

<style scoped>
.topicArticleItem {
  font-size: 12px;
  display: flex;
  justify-content: space-around;
  align-content: center;
  border-bottom: 1px solid #919aa9;
}
.topicTitle {
  flex-basis: 60%;
  text-align: left;
  flex-grow: 3;
  margin: 5px auto;
  margin-left: 20px;
}
.topicDelte {
  flex-basis: 5%;
  flex-grow: 1;
}
.topicLike {
  flex-basis: 5%;
  flex-grow: 1;
  color: red;
}
.topicEnterButton {
  flex-basis: 5%;
  flex-grow: 0.4;
  margin: 5px 10px;
  font-family: "Pretendard Bold";
}
</style>
