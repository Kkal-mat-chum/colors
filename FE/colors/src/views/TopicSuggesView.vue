<template>
  <div>
    <div class="contentWindow">
      <div class="userInfo">
        {{ userName }}님 환영합니다!
        <i class="material-icons-outlined userIcon">account_circle</i>
      </div>
      <h2 class="topicTenTitle">토픽 제안 게시판</h2>
      <TopicList class="topTenList" :isTopic="true">
        <TopicArticle
          class="topicArticle"
          :isTopic="true"
          v-for="topic in topics"
          :key="topic.id"
          :topicId="topic.id"
          :topicArticleTitle="topic.title"
          :recommend="topic.recommend"
          :cnt="topic.cnt"
          @clickLike="
            (cnt) => {
              topic.cnt = cnt;
              topic.recomend = !topic.recomend;
            }
          "
        />
      </TopicList>
      <div class="topTenBottomLine">
        <customButton btnText="돌아가기" />
        <TopicPagenation :pageNumber="maxPageNum" :currentPage="currentPageNum"></TopicPagenation>
        <customButton btnText="토픽 제안하기" @click="showModal = true" />
        <custom-modal class="suggestTopicModal" id="suggestTopicModal" v-show="showModal" @close-modal="showModal = false" titleText="Topic 제안">
          <cotent><topic-suggest></topic-suggest></cotent>
        </custom-modal>
      </div>
    </div>
  </div>
</template>

<script>
import TopicList from "@/components/topic/topicList.vue";
import TopicArticle from "@/components/topic/topicArticle.vue";
import TopicPagenation from "@/components/topic/topicPagenation.vue";
import TopicSuggest from "@/components/topic/topicSuggest.vue";
import axios from "axios";

export default {
  components: { TopicList, TopicArticle, TopicPagenation, TopicSuggest },
  data() {
    return {
      topics: null,
      currentPageNum: 0,
      sorting: "desc",
      maxPageNum: 0,

      showModal: false,
      userName: sessionStorage.getItem("userName"),
    };
  },
  mounted() {
    let memberData = JSON.parse(sessionStorage.getItem("memberData"));
    var userId = memberData.data.id;

    console.log(userId);
    axios
      .post(this.$store.state.baseurl + "api/topic/list?page=" + this.currentPageNum + "&sort=" + this.sorting, {
        userId: userId,
        keyword: "",
      })
      .then((response) => {
        if (!(response.data.message == "fail")) {
          console.log(response.data);
          this.maxPageNum = response.data.maxpage;
          this.topics = response.data.topics;
        }
      });
  },
  methods: {
    clikeLike(topic) {
      topic.cnt = topic.cnt + 1;
      topic.recommnd = !topic.recommnd;
    },
    clikeUnLike(topic) {
      topic.cnt = topic.cnt - 1;
      topic.recommnd = !topic.recommnd;
    },
  },
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
