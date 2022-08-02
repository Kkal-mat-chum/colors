<template>
  <div class="gridTopicList">
    <slot></slot>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.gridTopicList {
  display: grid;
  grid-template-rows: repeat(11, 1fr);
  margin-left: 130px;
}
</style>
