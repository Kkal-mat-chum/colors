<template>
  <div class="topicAritcleItem">
    <span class="topicTitle">the title</span>
    <span class="material-symbols-rounded topicDelete">delete</span>
    <span class="material-symbols-rounded topicLike">favorite</span>
  </div>
</template>

<script>
export default {};
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
}
.topicDelte {
  flex-basis: 5%;
}
.topicLike {
  flex-basis: 5%;
}
</style>
