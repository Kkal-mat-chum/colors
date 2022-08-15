<template>
  <div class="enterPageView">
    <div class="userInfo">
      {{ userName }}님 환영합니다!
      <i class="material-icons-outlined userIcon">account_circle</i>
    </div>
    <div class="Logo">
      <img src="@/assets/logo_horizental.png" alt="Logo Image" />
    </div>
    <div class="enterenceContainer">
      <ChoiceRoom class="firstDoor" @click="SingleRoom()" roomTitle="개인별 색깔 매칭" />
      <ChoiceRoom class="firstDoor" @click="showGroupModal = true" roomTitle="친구와 색깔 매칭" />
      <ChoiceRoom class="firstDoor" @click="TopicRoom()" roomTitle="토픽별 색깔 매칭" />
    </div>
    <customModal class="groupModal" v-show="showGroupModal" @close-modal="showGroupModal = false" titleText="단체 입장하기 ">
      <content class="groupModalContent">
        <input type="text" name="groupRoomCode" v-model="roomCode" id="roomCodeInput" placeholder="입장코드 입력 (사용자 개인 code)" />
        <div class="gridButtonArea">
          <customButton class="makeRoomButton gridModalButton" @click="TeamRoom()" btnText="방만들기"></customButton>
          <customButton class="enterRoomButton gridModalButton" btnText="입장하기" @click="entranceTeamRoom()"></customButton>
        </div>
        <span class="modalInfoText">방장으로부터 공유 받은 입장 코드를 입력한 뒤 입장하세요.</span>
      </content>
    </customModal>
  </div>
</template>

<script>
import ChoiceRoom from "@/components/EnterancePage/choiceRoom.vue";
import router from "@/router";
export default {
  components: { ChoiceRoom },
  data() {
    return {
      showGroupModal: false,
      id: sessionStorage.getItem("memberId"),
      roomCode: "",
      userName: sessionStorage.getItem("userName"),
    };
  },
  methods: {
    SingleRoom() {
      let singleUser = {
        hostid: this.id,
        roomtype: "single",
      };
      console.log(singleUser);
      this.$store.dispatch("singleMeeting", singleUser);
    },
    entranceTeamRoom() {
      let roomcode = {
        roomcode: this.roomCode,
      };
      sessionStorage.setItem("roomCode", this.roomCode);
      sessionStorage.setItem("groupMeetingName", sessionStorage.getItem("userName"));
      console.log(roomcode);
      this.$store.dispatch("groupMeeting", roomcode);
    },
    TeamRoom() {
      let groupUser = {
        hostid: this.id,
        roomtype: "group",
      };
      sessionStorage.setItem("hostId", this.id);
      sessionStorage.setItem("groupMeetingName", sessionStorage.getItem("userName"));
      this.$store.dispatch("madeGroupMeeting", groupUser);
    },
    TopicRoom() {
      router.push("/toptenTopic");
    },
  },
};
</script>

<style>
.testButton {
  font: 2rem "pretendard ExtraBold";
}
.enterence {
  padding: 0;
}
.Logo {
  margin-left: 120px;
}
.enterenceContainer {
  display: grid;
  margin: 1% 0 1% 120px;
  height: max-content;
  row-gap: 10px;
  padding: 0 10%;
  grid-template-columns: 1fr 1fr 1fr;
  justify-items: center;
  align-items: center;
}
.groupModal #modalMain {
  height: 30%;
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
.enterPageView {
  height: 100%;
}
.groupModalContent {
  display: grid;
  grid-template-areas: "code code button" ". footer footer";
}
#roomCodeInput {
  align-self: center;
  grid-area: code;
  margin: 5px;
  height: 60%;
  box-sizing: border-box;
  border: 2px solid #d0d1ff;
  font-size: 16px;
  border-radius: 10px;
  text-align: center;
}
.gridButtonArea {
  grid-area: button;
  display: flex;
  flex-direction: column;
}
.gridButtonArea .gridModalButton {
  margin: 5px;
  font-size: 24px;
  font-family: "pretendard Bold";
}
.modalInfoText {
  text-align: right;
  color: lightgray;
  grid-area: footer;
  margin-top: 12px;
  margin-right: 5px;
}
</style>
