<template>
  <div>
    <header-nav></header-nav>
    <router-view />
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";

export default {
  name: "HomeView",
  components: {
    HeaderNav,
  },
};
</script>
