<template>
  <div class="topicAritcleItem" v-bind="$attrs">
    <span class="topicTitle">{{ topicArticleTitle }}</span>
    <span class="material-symbols-rounded topicDelete" v-if="isAdmin & isTopic" @click="deleteTopic">delete</span>
    <span class="fa-solid fa-heart topicLike" v-if="isTopic & recommend" @click="clickUnLike">
      <span class="topicScore">{{ cnt }}</span>
    </span>
    <span class="fa-regular fa-heart topicLike" v-if="isTopic & !recommend" @click="clickLike">
      <span class="topicScore">{{ cnt }}</span>
    </span>
    <customButton class="topicEnterButton" btnText="입장하기" @click="topicRoom" v-if="isEnter"></customButton>
  </div>
</template>

<script>
import axios from "axios";

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
    topicArticleTitle: String,
    recommend: {
      type: Boolean,
      default: false,
    },
    cnt: {
      type: Number,
      default: 0,
    },
    topicId: Number,
  },
  methods: {
    async clickLike() {
      console.log("clicked like");
      const response = await axios.post(this.$store.state.baseurl + "vote", {
        topicId: this.topicId,
        userId: sessionStorage.getItem("memberId"),
      });
      if (response.data.message == "access") {
        console.log(this.topicId);
        console.log(response.data);
        this.$emit("clicklike", this.cnt + 1);
      }
    },
    async clickUnLike() {
      console.log("clicked unlike");
      const response = await axios.delete(this.$store.state.baseurl + "vote/" + this.topicId + "/" + sessionStorage.getItem("memberId"));
      if (response.message == "access") {
        console.log(response.data);
        this.$emit("clicklike", this.cnt - 1);
      }
    },
    topicRoom() {
      let topicId = {
        topicid: this.topicId,
      };
      sessionStorage.setItem("toppicTitle", this.topicArticleTitle);
      console.log(topicId);
      console.log(1231321);
      sessionStorage.setItem("groupMeetingName", sessionStorage.getItem("userNick"));
      sessionStorage.setItem("topicId", this.topicId);
      console.log(2132131);
      console.log(sessionStorage.getItem("topicId"));
      this.$store.dispatch("topicMeetingRoom", topicId);
    },
    deleteTopic() {
      let topicid = this.topicId;
      console.log(topicid);
      sessionStorage.setItem("topicData", topicid);
      this.$store.dispatch("deleteTopic", topicid);
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
.topicScore {
  text-align: center;
}
</style>
