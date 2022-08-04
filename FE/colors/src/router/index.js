import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import MyPageView from "../views/MyPageView.vue";
import enterPageView from "../views/EnterView.vue";
import topicBoard from "@/views/TopicSuggesView.vue";
import timer from "@/components/Voting/customTimeStamp.vue";
import aloneTournament from "../views/VotingView/AloneTournament.vue";
import aloneVoting from "../views/VotingView/AloneVoting.vue";
import teamVoting from "../views/VotingView/TeamVoting.vue";
import colorVote from "../components/Voting/colorVote.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
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
  },
  {
    path: "/topicBoard",
    name: "topicBoard",
    component: topicBoard,
  },
  {
    path: "/mypage",
    name: "mypage",
    component: MyPageView,
  },
  {
    path: "/alone",
    name: "alone",
    component: () => import("@/views/MeetingView/AloneView.vue"),
  },
  {
    path: "/team",
    name: "team",
    component: () => import("@/views/MeetingView/TeamView.vue"),
  },
  {
    path: "/signup",
    name: "signUp",
    component: () => import("@/components/user/customSignUp.vue"),
  },
  {
    path: "/login",
    name: "logIn",
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
    path: "/timer",
    name: "timer",
    component: timer,
    // component: () => import("@/views/VotingView/AloneTournament.vue"),
  },
  {
    path: "/colorVote",
    name: "colorVote",
    component: colorVote,
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
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
