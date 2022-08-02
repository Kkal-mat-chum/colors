<template>
  <div>
    <customSidebar />
    <TopicList class="topTenList">
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
      <TopicArticle class="topicArticle" />
    </TopicList>
  </div>
</template>

<script>
import TopicList from "@/components/topic/topicList.vue";
import TopicArticle from "@/components/topic/topicArticle.vue";
export default {
  components: { TopicList, TopicArticle },
};
</script>

<style scoped>
.topTenList {
  margin-left: 130px;
  padding: 0 3%;
}
.topicArticle {
  display: flex;
  justify-content: space-around;
  align-items: center;
  border-bottom: 1px solid #919aa9;
}
</style>
