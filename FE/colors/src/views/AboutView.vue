<template>
  <div class="about">
    <customSidebarVue></customSidebarVue>
    <h1>This is an about page</h1>
    <customButton class="testButton" btnText="BUTTON" @click="testClick">testButton</customButton>
  </div>
</template>

<script>
import customSidebarVue from "@/components/common/customSidebar.vue";
export default {
  components: {
    customSidebarVue,
  },
  methods: {
    testClick() {
      console.log("clicked");
    },
  },
};
</script>

<style>
.testButton {
  font: 2rem "pretendard ExtraBold";
}
</style>
