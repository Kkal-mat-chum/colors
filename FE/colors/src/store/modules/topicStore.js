import router from "@/router";
import { api } from "@/store";
import swal from "sweetalert";

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
          swal("Topic 관리", "성공적으로 삭제 되었습니다.", "success");
        }
      });
    },
  },
};
export default topicStore;
