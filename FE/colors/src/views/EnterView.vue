<template>
  <div>
    <customSidebar />
    <div class="userInfo"></div>
    <div class="Logo"></div>
    <div class="enterenceContainer">
      <ChoiceRoom class="firstDoor" @click="SingleRoom()" roomTitle="개인별 색깔 매칭" />
      <ChoiceRoom class="firstDoor" @click="TeamRoom()" roomTitle="친구와 색깔 매칭" />
      <ChoiceRoom class="firstDoor" roomTitle="토픽별 색깔 매칭" />
    </div>
    <customModal class="groupModal" v-show="showGroupModal" @close-modal="showGroupModal = false" titleText="단체 입장하기 ">
      <content>
        <customButton class="modalClose" btnText="CLOSE" @click="showGroupModal = false"></customButton>
      </content>
    </customModal>
  </div>
</template>

<script>
import ChoiceRoom from "@/components/EnterancePage/choiceRoom.vue";
export default {
  components: { ChoiceRoom },
  data() {
    return {
      showGroupModal: false,
    };
  },
  methods: {
    SingleRoom() {
      this.$router.push("alone");
    },
    TeamRoom() {
      this.$router.push("team");
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
.enterenceContainer {
  display: grid;
  margin: 10% 0 10% 120px;
  row-gap: 10px;
  padding: 0 60px;
  grid-template-columns: 1fr 1fr 1fr;
  justify-items: center;
  align-items: center;
}
.groupModal #modalMain {
  height: 30%;
}
</style>
