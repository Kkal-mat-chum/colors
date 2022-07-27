<template>
  <div class="about">
    <customSidebarVue></customSidebarVue>
    <h1>This is an about page</h1>
    <customButtonVue class="testButton">testButton</customButtonVue>
  </div>
</template>

<script>
import customSidebarVue from "@/components/common/customSidebar.vue";
import customButtonVue from "@/components/common/customButton.vue";
export default {
  components: {
    customSidebarVue,
    customButtonVue,
  },
};
</script>

<style>
.testButton {
  font: 2rem "pretendard Bold";
}
</style>
