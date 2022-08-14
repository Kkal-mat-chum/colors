<template>
  <div>
    <div class="topicInput">
      <input type="text" id="topicInput" placeholder="제안할 주제를 입력하세요. (20자 이내)" />
    </div>
    <customButton id="suggest" btnText="완 료" @click="send"></customButton>
    <div class="txt">
      <p>다양한 주제 제안을 원하신다면 여러 미팅 참여를 하면서 포인트를 쌓아보세요!</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "TopicSuggest",

  data() {
    return {};
  },

  mounted() {},

  methods: {
    send() {
      let memberData = JSON.parse(sessionStorage.getItem("memberData"));
      console.log(memberData);
      let userid = memberData.data.userId;
      let title = document.getElementById("topicInput").value;
      axios
        .post(this.$store.state.baseurl + "topic", {
          writer: userid,
          title: title,
        })
        .then((response) => {
          console.log(response);
          if (response.data.message == "success") {
            alert("토픽 제안 성공");
          } else {
            alert("토픽 제안 실패");
          }
        });
      this.$router.go(0);
    },
  },
};
</script>

<style scoped>
#topicInput[type="text"] {
  display: flex;
  margin: 6% 0 3% 15%;
  width: 70%;
  border-radius: 5px;
  border: 2px solid #d0d1ff;
  height: 200px;
}
#topicInput {
  text-align: center;
}
#suggest {
  width: 70%;
  margin-top: 5px;
}
.txt {
  color: rgb(139, 139, 139);
  text-align: right;
  margin-right: 30px;
  margin-top: 5%;
}
</style>
