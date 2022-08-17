import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import customButton from "@/components/common/customButton";
import customModal from "@/components/common/customModal";
import AOS from "aos";
import "aos/dist/aos.css";
Vue.config.productionTip = false;
Vue.component("customButton", customButton);
Vue.component("customModal", customModal);
Vue.use(AOS);
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
  mounted() {
    AOS.init({
      easing: "my-easing",
      duration: 500,
      delay: 50,
    });
  },
}).$mount("#app");
