import Vue from "vue";
import VueRouter from "vue-router";
// import HomeView from "../views/HomeView.vue";
import MyPageView from "../views/MyPageView.vue";
import enterPageView from "../views/EnterView.vue";
import topicBoard from "@/views/TopicSuggesView.vue";
import aloneTournament from "../views/VotingView/AloneTournament.vue";
import aloneVoting from "../views/VotingView/AloneVoting.vue";
import teamVoting from "../views/VotingView/TeamVoting.vue";
import randomVoting from "../views/VotingView/RandomVoting.vue";
import loadingwin from "@/components/Voting/loadingImg.vue";
import swal from "sweetalert";
Vue.use(VueRouter);

const routes = [
  // {
  //   path: "/",
  //   name: "home",
  //   component: HomeView,
  // },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/enterPage",
    name: "enterPage",
    component: enterPageView,
    meta: {
      reload: true,
    },
  },
  {
    path: "/topicBoard",
    name: "topicBoard",
    component: topicBoard,
    meta: {
      reload: true,
    },
  },
  {
    path: "/mypage",
    name: "mypage",
    component: MyPageView,
    meta: {
      reload: true,
    },
  },
  {
    path: "/alone/:id",
    name: "alone",
    component: () => import("@/views/MeetingView/AloneView.vue"),
  },
  {
    path: "/team/:id",
    name: "team",
    component: () => import("@/views/MeetingView/TeamView.vue"),
  },
  {
    path: "/signup",
    name: "signUp",
    meta: { authRequired: true },
    component: () => import("@/components/user/customSignUp.vue"),
  },
  {
    path: "/",
    name: "logIn",
    meta: { authRequired: true },
    component: () => import("@/components/user/customLogIn.vue"),
  },
  {
    path: "/modifyuser",
    name: "modifyUser",
    component: () => import("@/components/user/customUpdateUser.vue"),
  },
  {
    path: "/deleteuser",
    name: "deleteUser",
    component: () => import("@/components/user/customDeleteUser.vue"),
  },
  {
    path: "/modifypw",
    name: "modifyPW",
    component: () => import("@/components/user/customUpdatePW.vue"),
  },
  {
    path: "/nameresult",
    name: "nameResult",
    component: () => import("@/components/Voting/nameResult.vue"),
  },
  {
    path: "/nickresult",
    name: "nickResult",
    component: () => import("@/components/Voting/nickResult.vue"),
  },
  {
    path: "/tournamentnameresult",
    name: "tournamentNameResult",
    component: () => import("@/components/Voting/tournamentNameResult.vue"),
  },
  {
    path: "/findidpw",
    name: "findidpw",
    component: () => import("@/components/user/customDeleteUser.vue"),
  },
  {
    path: "/colorvote",
    name: "colorVote",
    component: () => import("@/components/Voting/colorVote.vue"),
  },
  {
    path: "/colortournament",
    name: "colorTournament",
    component: () => import("@/components/Voting/colorTournament.vue"),
  },
  {
    path: "/topTenTopic",
    name: "topTenTopic",
    component: () => import("@/views/top10ListView.vue"),
  },
  {
    path: "/aloneTournament",
    name: "aloneTournament",
    component: aloneTournament,
  },
  {
    path: "/aloneVoting",
    name: "aloneVoting",
    component: aloneVoting,
  },
  {
    path: "/teamVoting",
    name: "teamVoting",
    component: teamVoting,
  },
  {
    path: "/randomVoting",
    name: "randomVoting",
    component: randomVoting,
  },
  {
    path: "/loadingwin",
    name: "loadingwin",
    component: loadingwin,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach(function (to, from, next) {
  if (
    to.matched.some(function (routeInfo) {
      return routeInfo.meta.authRequired;
    })
  ) {
    next();
  } else {
    if (sessionStorage.getItem("access-token") != null) {
      next();
    } else {
      swal("로그인", "로그인이 필요한 서비스입니다.", "error");
      next({ path: "/" });
    }
  }
});

export default router;
