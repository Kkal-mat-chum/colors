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
        <input type="text" class="modifyInput" id="updateUserNickLabel" v-model="userNickname" placeholder="닉네임을 입력해주세요." />
        <input type="text" class="modifyInput" id="updateUserNameLabel" v-model="userName" placeholder="이름을 입력해주세요." />
        <input type="text" class="modifyInput" id="updateUserEmailLabel" v-model="userEmail" placeholder="현재 이메일" readonly />
        <input type="password" class="modifyPwInput" id="updateUserPwLabel" placeholder="비밀번호를 입력해주세요." />
      </div>
      <div class="modifyButtons">
        <customButton class="nickCheckBtn" id="nickCheckBtn" btnText="중복 확인" @click="checkDuplicateNickname">testButton</customButton>
      </div>
      <div class="UpdateUserdummyMargin2"></div>
    </div>
    <div class="update3">
      <div class="UpdateUserdummyMargin3"></div>
      <div class="modifyBottomBtns">
        <customButton class="nickCheckBtn" id="infoChangeBtn" btnText="정보 수정" @click="updateMemberInfo">testButton</customButton>
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
import axios from "axios";
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
      memberData: null,
      userNickname: "",
      userName: "",
      userEmail: "",
    };
  },
  mounted() {
    let memberData = JSON.parse(sessionStorage.getItem("memberData"));
    this.userNickname = memberData.data.nickname;
    this.userName = memberData.data.name;
    this.userEmail = memberData.data.email;
    document.getElementById("updateUserPwLabel").value = "";
  },
  methods: {
    //회원정보 수정
    updateMemberInfo() {
      let memberData = JSON.parse(sessionStorage.getItem("memberData"));
      let userid = memberData.data.userId;
      let newNickName = document.getElementById("updateUserNickLabel").value;
      let newName = document.getElementById("updateUserNameLabel").value;
      let userPassword = document.getElementById("updateUserPwLabel").value;

      console.log(userid, newNickName, newName, userPassword);
      if (this.nick_validation) {
        axios
          .put(this.$store.state.baseurl + "member/changeinfo", {
            userid: userid,
            password: userPassword,
            nickname: newNickName,
            name: newName,
          })
          .then((response) => {
            console.log(response);
            if (response.data.message == "success") {
              alert("정보 수정이 완료되었습니다.");
            } else {
              alert("수정에 실패하였습니다.");
            }
          });
      } else {
        alert("닉네임 중복 검사가 필요합니다.");
      }
    },
    checkDuplicateNickname() {
      let memberData = JSON.parse(sessionStorage.getItem("memberData"));
      let new_nickname = document.getElementById("updateUserNickLabel").value;
      var userNickname = memberData.data.nickname;
      axios
        .post(this.$store.state.baseurl + "member/chknic", {
          input_nickname: new_nickname,
        })
        .then((response) => {
          console.log(userNickname, ":", new_nickname);
          console.log(response.data.message);
          if (userNickname == new_nickname || response.data.message == "not-duplicated") {
            alert("닉네임 사용 가능");
            this.nick_validation = true;
          } else if (!(this.userNickname == new_nickname) || response.data.message == "duplicated") {
            this.nick_validation = false;
            alert("중복된 닉네임");
          }
        });
    },
  },
};
</script>

<style scoped>
body {
  margin: 0;
}
.customUpdateUserPage {
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin: -60px 0 0px 80px;
  width: 75%;
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
  width: 100px;
}
#updateUserEmailLabel {
  background-color: #ececec;
  color: #000000;
}
#infoChangeBtn {
  margin-top: 12%;
  margin-bottom: 5%;
  height: 38.4px;
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
#updateUserPwModal {
  height: 110%;
}
</style>
