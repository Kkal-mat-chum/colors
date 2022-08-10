import { api } from "@/store";

const memberStore = {
  state: {
    isLogin: false,
  },
  getters: {},
  mutations: {
    MEMBER_LOGOUT(state) {
      state.isLogin = false;
      sessionStorage.removeItem("access-token");
      api.defaults.headers["access-token"] = "";
    },
  },
  actions: {},
};
export default memberStore;
