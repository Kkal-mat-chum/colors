<template>
  <div id="app">
    <router-link to="/about">Go to About</router-link>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "app",
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
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-Black.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-Bold.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-ExtraBold.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-ExtraLight.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-Light.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-Medium.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-Regular.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-SemiBold.otf");
}

@font-face {
  font-family: "Pretendard";
  src: url("@/assets/font/Pretendard-Thin.otf");
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
