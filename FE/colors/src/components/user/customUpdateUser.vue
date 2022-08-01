<template>
  <div class="customUpdateUserPage">
    <div class="update2">
      <div class="UpdateUserdummyMargin1"></div>
      <div class="modifyLabels">
        <label for="updateUserNickLabel" class="modifyLabel">닉네임</label><br />
        <label for="updateUserNameLabel" class="modifyLabel">이름</label><br />
        <label for="updateUserEmailLabel" class="modifyLabel">이메일</label><br />
        <label for="updateUserPwlabel" class="modifyLabel">비밀번호</label>
      </div>
      <div class="modifyInputs">
        <input type="text" class="modifyInput" id="updateUserNickLabel" placeholder="닉네임을 입력해주세요." />
        <input type="text" class="modifyInput" id="updateUserNameLabel" placeholder="이름을 입력해주세요." />
        <input type="text" class="modifyInput" id="updateUserEmailLabel" placeholder="현재 이메일" />
        <input type="password" class="modifyPwInput" id="updateUserPwLabel" placeholder="비밀번호를 입력해주세요." />
      </div>
      <div class="modifyButtons">
        <customButton class="nickCheckBtn" id="nickCheckBtn" btnText="중복 확인" @click="testClick">testButton</customButton>
      </div>
      <div class="UpdateUserdummyMargin2"></div>
    </div>
    <div class="update3">
      <div class="UpdateUserdummyMargin3"></div>
      <div class="modifyBottomBtns">
        <customButton class="nickCheckBtn" id="infoChangeBtn" btnText="정보 수정" @click="testClick">testButton</customButton>
        <div class="a">
          <div class="removeUser"></div>
          <div class="update3_row2">
            <custom-button class="updateUserPw" id="pwChangeBtn" btnText="비밀번호 변경" @click="updatePwShowModal = true"></custom-button>
            <custom-button class="nickCheckBtn" id="byeBtn" btnText="회원 탈퇴" @click="deleteShowModal = true">testButton</custom-button>
            <custom-modal class="updateUserPwModal" id="updateUserPwModal" v-show="updatePwShowModal" @close-modal="updatePwShowModal = false" titleText="비밀번호 변경">
              <content><custom-updatepw></custom-updatepw></content>
            </custom-modal>
            <custom-modal class="removeUserModal" id="deleteUserModal" v-show="deleteShowModal" @close-modal="deleteShowModal = false" titleText="회원 탈퇴">
              <content><custome-delete-user></custome-delete-user></content>
            </custom-modal>
          </div>
        </div>
      </div>
      <div class="UpdateUserdummyMargin3"></div>
    </div>
  </div>
</template>

<script>
import CustomUpdatepw from "@/components/user/customUpdatePW.vue";
import CustomeDeleteUser from "./customDeleteUser.vue";
export default {
  components: {
    CustomUpdatepw,
    CustomeDeleteUser,
  },
  data() {
    return {
      updatePwShowModal: false,
      deleteShowModal: false,
    };
  },
  methods: {
    testClick() {
      console.log("123");
    },
  },
};
</script>

<style>
body {
  margin: 0;
}
.customUpdateUserPage {
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin: -70px 0 0 100px;
  width: 537.75px;
  height: 558px;
  /* width: 35%;
  height: 75%; */
  border-radius: 10px;
}
.update1 {
  display: flex;
  justify-content: center;
  position: relative;
  height: 27%;
  /* left: 0px;
  top: 0px; */
  background: white;
  justify-content: left;
}
.update2 {
  display: flex;
  flex-direction: row;
  position: relative;
  height: 40%;
  right: 0px;
  top: 0px;
}
.update3 {
  position: relative;
  display: flex;
  flex-direction: row;
  height: 32%;
  right: 0px;
  top: 0px;
}
.titleCustomUpdateUser {
  margin-top: 13%;
  margin-left: 15%;
  font-size: 150%;
  font-weight: 900;
  color: #6667ab;
  /* margin-left: 10% !important;
  position: absolute;
  top: 10%;
  left: 0;
  text-align: left;
  display: grid;
  justify-content: left;
  width: 60% !important; */
}
.updateUserhrStyle {
  width: 30%;
  position: absolute;
  height: 1px;
  margin: 20% 0 0 15%;
  background-color: #d0d1ff;
}
.UpdateUserdummyMargin1 {
  width: 17%;
}
.UpdateUserdummyMargin2 {
  width: 5%;
}
.UpdateUserdummyMargin3 {
  width: 20%;
}
.modifyLabels {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  width: 13%;
  /* padding-left: 3%; */
  /* margin-left: 5%; */
  text-align: left;
}
.modifyLabel {
  display: inline-block;
  /* margin: 0.6rem 0rem 2.5rem 0rem; */
  /* margin-top: 15%; */
  /* margin-bottom: 45%; */
  color: #6667ab;
  font-size: 17px;
}
.modifyInputs {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  width: 45%;
}
.modifyInput[type="text"] {
  width: 85%;
  /* margin-bottom: 8%; */
  /* margin-top: 2%; */
  /* margin-left: 2%; */
  padding: 8px;
  border: 2px solid #d0d1ff;
  border-radius: 5px;
  border-color: #d0d1ff;
  font-size: 16px;
}
.modifyPwInput[type="password"] {
  width: 85%;
  /* margin-bottom: 8%; */
  /* margin-top: 2%; */
  /* margin-left: 2%; */
  padding: 8px;
  border: 2px solid #d0d1ff;
  border-radius: 5px;
  border-color: #d0d1ff;
  font-size: 16px;
}
.modifyButtons {
  width: 20%;
  display: flex;
}
.nickCheckBtn {
  padding: 0;
}
.modifyBottomBtns {
  width: 60%;
  display: flex;
  flex-direction: column;
  /* margin-bottom: 1rem; */
}
#nickCheckBtn {
  /* margin-top: 5%; */
  height: 18%;
}
#updateUserEmailLabel {
  background-color: #ececec;
  color: #000000;
}
#infoChangeBtn {
  margin-top: 12%;
  margin-bottom: 5%;
}
#pwChangeBtn {
  width: 48%;
}
#byeBtn {
  width: 48%;
  color: red;
}
.removeUser {
  display: flex;
  justify-content: right;
}
.update3_row2 {
  display: flex;
  justify-content: space-between;
}
</style>
