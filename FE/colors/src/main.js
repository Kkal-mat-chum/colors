import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import customButton from "@/components/common/customButton";
import customModal from "@/components/common/customModal";

Vue.config.productionTip = false;
Vue.component("customButton", customButton);
Vue.component("customModal", customModal);

new Vue({
  router,
  store,
  render: (h) => h(App),
  watch: {
    $route(to) {
      if (to.currentRoute.meta.reload == true) {
        window.location.reload();
      }
    },
  },
}).$mount("#app");
