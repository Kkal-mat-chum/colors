<template>
  <div class="sidebar">
    <ul class="sidebar__nav">
      <li><img class="logo_sidebar" src="../../assets/logo_vertical.png" /></li>
      <hr />
      <div class="icons">
        <li><img class="Active" src="../../assets/home_icon.png" /></li>
        <li><img class="sideBarIcon" src="../../assets/topic_icon.png" /></li>
        <li><img class="sideBarIcon" src="../../assets/myPage_icon.png" /></li>
      </div>
      <li><img class="sideBarIcon logOutIcon" src="../../assets/logOut_icon.png" /></li>
    </ul>
  </div>
</template>

<script>
export default {};
</script>

<style>
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

.logo_sidebar {
  width: 130px;
  margin-bottom: 2rem;
}

.Active {
  filter: opacity(0.8) drop-shadow(0 0 0 #4a4d74);
}

li img:hover {
  filter: opacity(0.4) drop-shadow(0 0 0 #ffffff);
}

.sideBarIcon {
  filter: opacity(0.4) drop-shadow(0 0 0 #8c95d1);
}

.logOutIcon {
  position: absolute;
  top: 90%;
  left: 30%;
}

ul.sidebar__nav {
  display: flex;
  flex-direction: column;
  list-style: none;
  padding-left: 0;
  margin-left: 0;
}

.icons {
  display: flex;
  flex-direction: column;
  height: max-content;
  justify-content: space-between;
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

<!-- <style lang="scss" scoped>
ul.sidebar__nav {
  width: 100%;
  position: relative;
  li {
    margin-bottom: 10px;
    padding: 10px 0;
    font-size: 0.9em;
    color: #d2dae2;
    cursor: pointer;
    &.selected {
      color: #4bcffa;
    }
    i {
      width: 40px;
      color: inherit;
    }
  }
}
</style> -->
