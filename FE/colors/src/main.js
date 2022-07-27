import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import customButton from "@/components/common/customButton";

Vue.config.productionTip = false;
Vue.component("customButton", customButton);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
