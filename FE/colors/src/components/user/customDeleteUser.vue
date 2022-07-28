<template>
  <div>
    <div class="deleteUserPage">
      <div class="delete1">
        <div class="titleDeleteUser">회원 탈퇴</div>
        <hr class="deleteUserhystyle" />
      </div>
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
        <customButton id="deleteSureBtn" btnText="확 인" @click="testClick">testButton</customButton>
        <customButton id="deleteCancleBtn" btnText="취 소" @click="testClick">testButton</customButton>
        <!-- <div class="dummyMarginDelete2"></div> -->
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.deleteUserPage {
  position: absolute;
  display: flex;
  flex-direction: column;
  width: 537.75px;
  height: 350px;
  /* width: 35%;
  height: 75%; */
  left: 399px;
  top: 117px;
  border: 10px solid #000000;
  border-radius: 10px;
}
.titleDeleteUser {
  margin-top: 9%;
  margin-left: 10%;
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
