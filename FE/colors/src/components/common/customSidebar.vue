<template>
  <div class="sidebar">
    <ul class="sidebar__nav">
      <li class="logo"><img class="logo_sidebar" src="../../assets/logo_vertical_croped.png" /></li>
      <div class="icons">
        <i class="material-symbols-rounded loadedIcon" @click="clickHomeIcon">home</i>
        <i class="material-icons-outlined loadedIcon" @click="clickForumIcon">forum</i>
        <i class="material-icons-outlined loadedIcon" @click="clickMyPageIcon">account_circle</i>
      </div>
    </ul>
    <div>
      <i class="material-icons-outlined loadedIcon" @click="doLogout">logout</i>
    </div>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
export default {
  computed: {},
  methods: {
    ...mapMutations(["MEMBER_LOGOUT"]),
    doLogout() {
      this.MEMBER_LOGOUT();
      this.$router.push("/");
    },
    clickHomeIcon() {
      console.log("clicked");
      this.$router.push({ path: "/enterPage" }).catch(() => {});
    },
    clickForumIcon() {
      console.log("clicked");
      this.$router.push({ path: "/topicBoard" }).catch(() => {});
    },
    clickMyPageIcon() {
      console.log("clicked");
      this.$router.push({ path: "/mypage" }).catch(() => {});
    },
  },
};
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

.loadedIcon:hover {
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
