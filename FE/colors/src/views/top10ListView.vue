<template>
  <div>
    <customSidebar />
    <div class="contentWindow">
      <div class="userInfo">
        {{ userName }}님 환영합니다!
        <i class="material-icons-outlined userIcon">account_circle</i>
      </div>
      <h2 class="topicTenTitle">이번주 토픽 TOP 10</h2>
      <TopicList class="topTenList" :isEnter="true">
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
        <TopicArticle class="topicArticle" :isEnter="true" />
      </TopicList>
      <div class="topTenBottomLine">
        <customButton btnText="돌아가기 " />
        <customButton btnText="토픽 제안하기" />
      </div>
    </div>
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
.contentWindow {
  margin-left: 130px;
  min-height: 90vh;
}
.topTenList {
  padding: 0 3%;
}
.topicArticle {
  display: flex;
  justify-content: space-around;
  align-items: center;
  border-bottom: 1px solid #919aa9;
}
.userInfo {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  margin-right: 30px;
  margin-top: 20px;
  font: 20px "Pretendard Bold";
  color: #6667ab;
}
.userIcon {
  margin-left: 12px;
  font-size: 24px;
  font-weight: bold;
}
.topicTenTitle {
  font-family: "Pretendard ExtraBold";
  font-size: 36px;
  color: #6667ab;
  text-align: left;
  width: fit-content;
  margin-left: 60px;
  position: relative;
}
.topicTenTitle:after {
  content: "";
  width: 140%;
  display: block;
  position: absolute;
  /* margin-top: 50px; */
  border-bottom: 5px solid #d0d1ff;
}
.topTenBottomLine {
  display: flex;
  justify-content: space-between;
  margin: auto 5%;
  margin-top: 15px;
}
.topTenBottomLine button {
  font-family: "Pretendard ExtraBold";
  flex-basis: 15%;
}
</style>
