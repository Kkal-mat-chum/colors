<template>
  <div class="about">
    <h1>This is an about page</h1>
    <customButton class="testButton" btnText="BUTTON" @click="showModal = true">testButton</customButton>
    <customModal class="testModal" v-show="showModal" @close-modal="showModal = false" titleText="testmodal">
      <content>
        <customButton class="modalClose" btnText="CLOSE" @click="showModal = false"></customButton>
      </content>
    </customModal>
  </div>
</template>

<script>
export default {
  data() {
    return {
      showModal: false,
    };
  },
  methods: {
    testClick() {
      console.log("clicked");
    },
  },
};
</script>

<style scoped>
.testButton {
  font: 2rem "pretendard ExtraBold";
}
.testModal .modal {
  width: 90%;
  height: 40%;
}
content .modalClose {
  font: 40px "pretendard Bold";
  width: 90%;
}
</style>
