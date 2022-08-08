<template>
  <div>
    <div class="deleteUserPage">
      <div class="delete2">
        <div class="dummyMarginDelete1"></div>
        <div class="deleteNotice">
          <label for="deleteNotice1" class="deleteNotice">※ 탈퇴를 진행할 경우, 아이디 및 데이터를 복구할 수 없습니다.</label>
          <label for="deleteNotice2" class="deleteNotice">※ 개인정보는 탈퇴시 삭제됩니다.</label>
        </div>
        <div class="dummyMarginDelete1"></div>
      </div>
      <div class="delete3">
        <!-- dd -->
        <div class="dummyMarginDelete2"></div>
        <customButton id="deleteSureBtn" btnText="확 인" @click="[goLogin(), deleteMember()]">testButton</customButton>
        <customButton id="deleteCancleBtn" btnText="취 소" @click="goMypage">testButton</customButton>
        <!-- <div class="dummyMarginDelete2"></div> -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
// const HOST = "";

export default {
  methods: {
    goMypage() {
      this.$router.go(0);
    },
    goLogin() {
      this.$router.push("/login");
    },
    deleteMember1: function () {
      axios
        .delete("/api/member/" + "id")
        .then((response) => (this.contacts = response.contacts))
        .catch(function (error) {
          console.log(error);
        });
    },
    deleteMember() {
      this.$axios.delete("/api/member/" + "id");
      console.log("삭제??");
      // let deleteId = "123";
      // this.$axios
      //   .delete(HOST + "/api/member/" + deleteId)
      //   .then((res) => {
      //     console.log(res.staus);
      //     console.log(res.data);
      //   })
      //   .catch((error) => {
      //     console.log(error);
      //   })
      //   .finally(() => {
      //     console.log("항상 마지막에 실행");
      //   });
    },
  },
};
// export function deleteMember(user_seqs) {
//   return request({
//     url: "/api/member/" + id, //"base url을 제외한 리소스명(URI)"
//     method: "delete",
//     params: {
//       user_seqs: user_seqs,
//     },
//   });
// }
</script>

<style>
.deleteUserPage {
  display: flex;
  flex-direction: column;
  width: 537.75px;
  height: 350px;
  /* width: 35%;
  height: 75%; */
  top: 117px;
  margin-left: 15%;
}
.titleDeleteUser {
  margin-top: 9%;
  margin-left: 40%;
  font-size: 150%;
  font-weight: 900;
  color: #6667ab;
}
.deleteUserhystyle {
  width: 35%;
  height: 1px;
  background-color: #d0d1ff;
  position: absolute;
  margin-top: 15%;
  margin-left: 10%;
}
.delete1 {
  height: 30%;
  display: flex;
  flex-direction: column;
  /* justify-content: flex-start; */
  align-items: flex-start;
}
.delete2 {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  height: 40%;
}
.deleteNotice {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  width: 70%;
  text-align: left;
}
.delete3 {
  height: 50%;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: center;
}
.dummyMarginDelete1 {
  width: 15%;
}
.dummyMarginDelete2 {
  height: 8%;
}
.deleteNotice {
  width: 100%;
  font-size: 17px;
}
#deleteSureBtn {
  color: red;
  width: 60%;
}
#deleteCancleBtn {
  width: 60%;
  margin-top: 2%;
}
</style>
