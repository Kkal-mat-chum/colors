<template>
  <div id="app">
    <CustomSidebar v-if="isLogin"></CustomSidebar>
    <router-view :key="$route.fullPath" />
  </div>
</template>

<script>
import CustomSidebar from "./components/common/customSidebar.vue";
export default {
  name: "app",
  components: { CustomSidebar },
  computed: {
    isLogin() {
      console.log("FE updated 220819 08:30");
      return this.$store.getters.isLogin;
    },
  },
};
</script>

<style>
#app {
  font-family: "Pretendard";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
@font-face {
  font-family: "Cafe24Dongdong";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Dongdong.woff") format("woff");
  font-weight: normal;
  font-style: normal;
}

@font-face {
  font-family: "Pretendard Black";
  src: url("@/assets/font/Pretendard-Black.otf");
}

@font-face {
  font-family: "Pretendard Bold";
  src: url("@/assets/font/Pretendard-Bold.otf");
  font-weight: 700;
}

@font-face {
  font-family: "Pretendard ExtraBold";
  src: url("@/assets/font/Pretendard-ExtraBold.otf");
  font-weight: 900;
}

@font-face {
  font-family: "Pretendard ExtraLight";
  src: url("@/assets/font/Pretendard-ExtraLight.otf");
  font-weight: 100;
}

@font-face {
  font-family: "Pretendard Light";
  src: url("@/assets/font/Pretendard-Light.otf");
  font-weight: 300;
}

@font-face {
  font-family: "Pretendard Medium";
  src: url("@/assets/font/Pretendard-Medium.otf");
  font-weight: 400;
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-Regular.otf");
  font-weight: 500;
}

@font-face {
  font-family: "Pretendard semiBold";
  src: url("@/assets/font/Pretendard-SemiBold.otf");
  font-weight: 600;
}

@font-face {
  font-family: "Pretendard thin";
  src: url("@/assets/font/Pretendard-Thin.otf");
  font-weight: 200;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
