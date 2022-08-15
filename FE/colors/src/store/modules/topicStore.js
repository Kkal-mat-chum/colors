import router from "@/router";
import { api } from "@/store";

const topicStore = {
  state: {},
  getters: {},
  mutations: {},
  actions: {
    deleteTopic(data) {
      api({
        url: `/topic/${sessionStorage.getItem("topicData")}`,
        method: "DELETE",
        data: data,
      }).then(({ data }) => {
        if (data.message == "access") {
          router.go(0);
          alert("성공적으로 삭제 되었습니다.");
        }
      });
    },
  },
};
export default topicStore;
