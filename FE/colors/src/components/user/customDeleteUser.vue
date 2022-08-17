<template>
  <div class="body">
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
        <customButton id="deleteSureBtn" btnText="탈 퇴" @click="[goLogin(), deleteMember()]">탈퇴 확인 버튼</customButton>
        <customButton id="deleteCancleBtn" btnText="취 소" @click="goMypage">탈퇴 안함 버튼</customButton>
        <!-- <div class="dummyMarginDelete2"></div> -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  methods: {
    goMypage() {
      this.$router.go(0);
    },
    goLogin() {
      this.$router.push("/login");
    },
    deleteMember() {
      let memberData = JSON.parse(sessionStorage.getItem("memberData"));
      let userid = memberData.data.userId;
      console.log(userid);
      axios.delete(this.$store.state.baseurl + "member/" + userid);
      //localstorage 토큰 & 유저정보 제거
      window.localStorage.removeItem("access-token");
      sessionStorage.setItem("isLogin", false);
      router.go();
    },
  },
};
</script>

<style scoped>
.body {
  margin: 0;
}
.deleteUserPage {
  display: flex;
  flex-direction: column;
  width: 540px;
  height: 350px;
  /* width: 35%;
  height: 75%; */
  top: 80px;
  margin-left: 8%;
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
  color: #6667ab;
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
#deleteUserModal {
  margin-top: 10%;
}
</style>
