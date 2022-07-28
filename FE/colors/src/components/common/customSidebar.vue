<template>
  <div class="sidebar">
    <ul class="sidebar__nav">
      <li class="logo"><img class="logo_sidebar" src="../../assets/logo_vertical_croped.png" /></li>
      <div class="icons">
        <router-link tag="li" class-active="Active" to="/about">
          <img class="sideBarIcon" src="../../assets/home_icon.png" />
        </router-link>
        <router-link tag="li" class-active="Active" to="/signup">
          <img class="sideBarIcon" src="../../assets/topic_icon.png" />
        </router-link>
        <router-link tag="li" class-active="Active" to="/mypage">
          <img class="sideBarIcon" src="../../assets/myPage_icon.png" />
        </router-link>
      </div>
    </ul>
    <p>{{ activeIcon }}</p>
    <div>
      <img class="sideBarIcon logOutIcon" src="../../assets/logOut_icon.png" />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
/* Rectangle 1 */
.sidebar {
  height: 100%;
  width: 120px;
  position: fixed;
  display: block;
  top: 0;
  left: 0;
  overflow-x: hidden;
  padding-top: 0;
  background: #ffffff;
  box-shadow: 5px 1px 40px 10px rgba(238, 238, 238, 0.4);
}

.logo::after {
  content: "";
  width: 40%;
  display: inline-flex;
  border-radius: 3px;
  margin-bottom: 10px;
  border-bottom: 5px solid #d0d1ff;
  text-align: center;
  justify-content: center;
}

.logo_sidebar {
  width: 130px;
  margin-bottom: 2rem;
}

li.router-link-active {
  filter: opacity(1) drop-shadow(0 0 0 #393ba7);
}

.sideBarIcon {
  filter: opacity(0.4) drop-shadow(0 0 0 #8c95d1);
}

.icons img:hover {
  filter: opacity(0.3) drop-shadow(0 0 0 #ffffff);
}

.logOutIcon:hover {
  filter: opacity(0.4) drop-shadow(0 0 0 #ffffff);
}

ul.sidebar__nav {
  display: flex;
  flex-direction: column;
  list-style: none;
  padding-left: 0;
  margin-left: 0;
  height: 85%;
}

.icons {
  display: flex;
  flex-direction: column;
  height: 400px;
  justify-content: space-around;
}

.icons li img {
  margin: 1rem auto;
}

li {
  list-style: none;
  margin-left: 0;
  padding-left: 0;
}
</style>
