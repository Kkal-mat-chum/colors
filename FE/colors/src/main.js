import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import customButton from "@/components/common/customButton";
import customModal from "@/components/common/customModal";
import customSidebar from "@/components/common/customSidebar";

Vue.config.productionTip = false;
Vue.component("customButton", customButton);
Vue.component("customModal", customModal);
Vue.component("customSidebar", customSidebar);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
