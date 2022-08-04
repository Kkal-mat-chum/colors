<template>
  <div class="aloneTournament">
    <sidebar></sidebar>
    <color-tornament></color-tornament>
  </div>
</template>

<script>
import sidebar from "@/components/common/customSidebar.vue";
import ColorTornament from "@/components/Voting/colorTournament.vue";

export default {
  name: "aloneTournament",
  components: {
    sidebar,
    ColorTornament,
  },
};
</script>

<style scoped></style>
