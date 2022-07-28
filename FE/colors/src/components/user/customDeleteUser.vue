<template>
  <div>
    <div class="deleteUserPage">
      <div class="delete1">
        <div class="title">회원 탈퇴</div>
      </div>
      <div class="delete2">
        <div class="dummyMargin1"></div>
        <div class="delteNotice">
          <label for="deleteNotice1">※ 탈퇴를 진행할 경우, 아이디 및 데이터를 복구할 수 없습니다</label>
          <label for="deleteNotice2">※ 개인정보는 탈퇴시 삭제됩니다.</label>
        </div>
        <div class="dummyMargin1"></div>
      </div>
      <div class="delete3">버튼들</div>
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
.delete1 {
  height: 40%;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}
.delete2 {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  height: 40%;
}
.delteNotice {
  display: flex;
  flex-direction: column;
  width: 70%;
  text-align: left;
}
.delete3 {
  height: 40%;
}
.dummyMargin1 {
  width: 15%;
}
</style>
