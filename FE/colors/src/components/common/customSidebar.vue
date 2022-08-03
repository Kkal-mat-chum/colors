<template>
  <div class="sidebar">
    <ul class="sidebar__nav">
      <li class="logo"><img class="logo_sidebar" src="../../assets/logo_vertical_croped.png" /></li>
      <div class="icons">
        <router-link tag="li" class-active="Active" to="/enterPage">
          <!-- <img class="sideBarIcon" src="../../assets/home_icon.png" /> -->
          <i class="material-symbols-rounded loadedIcon">home</i>
          <!-- <i class="fa-solid fa-house loadedIcon" style="font-size: 60px"></i> -->
        </router-link>
        <router-link tag="li" class-active="Active" to="/topicBoard">
          <i class="material-icons-outlined loadedIcon">forum</i>
          <!-- <i class="fa-message fa-regular loadedIcon" style="font-size: 60px"></i> -->
          <!-- <img class="sideBarIcon" src="../../assets/topic_icon.png" /> -->
        </router-link>
        <router-link tag="li" class-active="Active" to="/mypage">
          <i class="material-icons-outlined loadedIcon">account_circle</i>
          <!-- <i class="fa-circle-user fa-regular loadedIcon" style="font-size: 60px"></i> -->
          <!-- <img class="sideBarIcon" src="../../assets/myPage_icon.png" /> -->
        </router-link>
      </div>
    </ul>
    <div>
      <i class="material-icons-outlined loadedIcon">logout</i>
      <!-- <i class="fa-solid fa-right-from-bracket loadedIcon" style="font-size: 60px"></i> -->
      <!-- <img class="sideBarIcon logOutIcon" src="../../assets/logOut_icon.png" /> -->
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

.router-link-active .loadedIcon {
  color: #6667ab !important;
}

.loadedIcon {
  text-align: center;
  font-size: 60px;
  color: #d0d1ff;
}

.loadedIcon:hover {
  color: #b9b9e8;
  cursor: pointer;
}

ul.sidebar__nav {
  display: flex;
  flex-direction: column;
  list-style: none;
  padding-left: 0;
  margin-left: 0;
  height: 80%;
}
.icons {
  display: flex;
  flex-direction: column;
  height: 280px;
  justify-content: space-around;
}
li {
  list-style: none;
  margin-left: 0;
  padding-left: 0;
}
</style>
