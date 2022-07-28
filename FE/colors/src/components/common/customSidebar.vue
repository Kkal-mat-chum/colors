<template>
  <div class="sidebar">
    <ul class="sidebar__nav">
      <li class="logo"><img class="logo_sidebar" src="../../assets/logo_vertical_croped.png" /></li>
      <div class="icons">
        <li><img class="Active" src="../../assets/home_icon.png" /></li>
        <li><img class="sideBarIcon" src="../../assets/topic_icon.png" /></li>
        <li><img class="sideBarIcon" src="../../assets/myPage_icon.png" /></li>
      </div>
    </ul>
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

.sidebar a {
  display: block;
  text-align: center;
  transition: all 0.3s ease;
  color: white;
}

.sidebar a:hover {
  background-color: #6667ab;
}

.active {
  background: #d0d1ff;
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

.Active {
  filter: opacity(0.8) drop-shadow(0 0 0 #4a4d74);
}

.icons img:hover {
  filter: opacity(0.4) drop-shadow(0 0 0 #ffffff);
}

.sideBarIcon {
  filter: opacity(0.4) drop-shadow(0 0 0 #8c95d1);
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
