<template>
  <div>
    <customSidebar />
    <TopicList class="topTenList">
      <content>
        <div class="meal-css-tester-item" style="">1</div>
        <div class="meal-css-tester-item" style="">2</div>
        <div class="meal-css-tester-item" style="">3</div>
        <div class="meal-css-tester-item" style="">4</div>
        <div class="meal-css-tester-item" style="">5</div>
        <div class="meal-css-tester-item" style="">6</div>
        <div class="meal-css-tester-item" style="">7</div>
        <div class="meal-css-tester-item" style="">8</div>
        <div class="meal-css-tester-item" style="">9</div>
        <div class="meal-css-tester-item" style="">10</div>
        <div class="meal-css-tester-item" style="">11</div>
      </content>
    </TopicList>
  </div>
</template>

<script>
import TopicList from "@/components/topic/topicList.vue";
export default {
  components: { TopicList },
};
</script>

<style scoped>
.meal-css-tester-item {
  margin: 3px;
  padding: 2px;
  border: 3px solid currentColor;
  border-radius: 3px;
  font-weight: bold;
  background: #26ab1c;
  transition: 0.4s;
}
.topTenList {
  height: 100%;
}
</style>
