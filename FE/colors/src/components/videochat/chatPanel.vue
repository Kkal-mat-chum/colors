<template>
  <div class="chat-panel">
    <div class="chat-box">
      <div class="header">
        <span class="title"> 채팅 </span>
        <button class="btn close-btn" @click="toggleChatPanel">
          <i class="fas fa-times"></i>
        </button>
      </div>
      <!-- 채팅 내역 -->
      <div id="chat-area">
        <div class="message" v-for="(message, i) of messages" :key="i">
          <div class="message-title">
            <span class="message-header">{{ message.sender }} :</span>
          </div>
          <div class="messgeText">
            {{ message.message }}
          </div>
        </div>
      </div>
      <div class="footer">
        <!-- display flex에 col값 할당해주기 -->
        <div class="messageInputBox">
          <input class="text-box" v-model="message" @keyup.enter="clickSendMessage" />
        </div>
        <div class="messageSendButton">
          <button class="send-btn" @click="clickSendMessage">
            <i class="fas fa-paper-plane"></i>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "ChatPanel",
  data() {
    return {
      message: "",
      chatHeight: "100vh",
    };
  },
  watch: {
    messages() {
      setTimeout(() => {
        var chatDiv = document.getElementById("chatpanelArea");
        chatDiv.scrollTo({
          top: chatDiv.scrollHeight - chatDiv.clientHeight,
          behavior: "smooth",
        });
      }, 50);
    },
  },
  computed: {
    messages() {
      return this.$store.getters.messages;
    },
  },
  methods: {
    ...mapActions(["toggleChatPanel"]),
    clickSendMessage() {
      if (this.message.trim()) {
        this.$emit("sendMessage", this.message);
        this.message = "";
      }
    },
  },
};
</script>

<style scoped>
.chat-box {
  height: 100%;
  /* padding: 2px; */
  display: flex;
  flex-direction: column;
  height: 100vh;
  justify-content: space-around;
  font: 18px "pretendard";
}

.header {
  position: relative;
  text-align: left;
}

.close-btn {
  position: absolute;
  color: #d0d1ff;
  top: 3px;
  right: 10px;
}

.text-box {
  background-color: #ffffff;
  width: 100%;
  border: 1px solid #d0d1ff;
  border-radius: 10px;
  color: #4a4d74;
  font: 20px "Pretendard Bold";
}

.text-box:focus {
  outline: none;
}

.title {
  padding-left: 5%;
  font: 24px "Pretendard ExtraBold";
  color: #6667ab;
}
.title:after {
  content: "";
  width: 100%;
  display: block;
  position: absolute;
  /* margin-top: 50px; */
  border-bottom: 5px solid #d0d1ff;
}

.header {
  width: 100%;
  height: 4vh;
  text-align: left;
  margin-top: 10px;
  color: #6667ab;
}

.message-header {
  font: 15px "pretendard";
  margin-right: 8px;
  flex-wrap: nowrap;
  flex-grow: 3;
}

.messageText {
  margin-left: 3px;
  flex-wrap: wrap;
  flex-grow: 8;
}

.message {
  margin-top: 3%;
  text-align: left;
  color: #6667ab;
  display: flex;
  margin-left: 5px;
}

.send-btn {
  color: #d0d1ff;
}

.footer {
  display: flex;
  margin-top: auto;
  align-items: center;
  margin-bottom: 2%;
  font: 18px "pretendard";
}

.messageInputBox {
  flex-grow: 10;
  padding: 1% 0;
  height: 50px;
}
.messageSendButton {
  flex-grow: 2;
  padding: 0;
  height: 50px;
}

#chat-area {
  overflow-y: auto;
  height: 85%;
}

#chat-area::-webkit-scrollbar {
  width: 8px;
  height: 8px;
}

#chat-area::-webkit-scrollbar-track {
  background: #37474f;
}

#chat-area::-webkit-scrollbar-corner {
  background: #37474f;
}

#chat-area::-webkit-scrollbar-thumb {
  background: #b0a2c8;
}

#chat-area::-webkit-scrollbar-button {
  background-color: #37474f;
  height: 0;
}
</style>
