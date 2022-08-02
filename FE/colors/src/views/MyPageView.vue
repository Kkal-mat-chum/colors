<template>
  <div>
    <customSidebar />
    <div class="mypage">
      <div class="title">
        <h1>마이페이지</h1>
        <hr />
      </div>
      <div class="contents">
        <div class="personInfo">
          <div class="profileImg">
            <img class="profileimgfile" src="@/assets/mypage/img.png" alt="" />
            <img class="grade" src="@/assets/mypage/Group 65.svg" alt="" />
          </div>
          <div class="myInfo">
            <myinfo></myinfo>
          </div>
          <div class="updateInfo">
            <custom-button class="updateUserInfo" btnText="회원정보수정" @click="showModal = true">회원정보수정</custom-button>
            <custom-modal class="updateUserInfoModal" id="updateUserInfoModal" v-show="showModal" @close-modal="showModal = false" titleText="회원정보수정">
              <cotent><modify-user></modify-user></cotent>
            </custom-modal>
          </div>
        </div>
        <div class="colorpallete">
          <div class="colorpalleteTitle">
            <h2>컬러 팔레트 내역</h2>
            <div class="nowColor">
              <div class="colorName">
                <p>#E3D3FF</p>
                <p>Pale Lime Yellow</p>
              </div>
            </div>
          </div>
          <div class="palleteBorder">
            <div class="PalleteTitle">
              <p>개인</p>
              <div class="colormark">
                <div class="firstcolor">
                  <div class="top1"><p>1위</p></div>
                  <div class="color" style="background-color: #ffdeec"></div>
                </div>
                <colorpallete class="pallete"></colorpallete>
              </div>
            </div>
            <div class="PalleteTitle">
              <p>단체</p>
              <div class="colormark">
                <div class="firstcolor">
                  <div class="top1"><p>1위</p></div>
                  <div class="color" style="background-color: #c1c4ff"></div>
                </div>
                <colorpallete class="pallete"></colorpallete>
              </div>
            </div>
            <div class="PalleteTitle">
              <div class="info">
                <p>랜덤</p>
                <div>
                  <p class="randomInfo">면접 복장으로 어느 색이 잘 어울릴까요?</p>
                </div>
              </div>
              <div class="colormark">
                <div class="firstcolor">
                  <div class="top1"><p>1위</p></div>
                  <div class="color" style="background-color: #ffd2d2"></div>
                </div>
                <colorpallete class="pallete"></colorpallete>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import colorpallete from "@/components/myPage/colorPallete.vue";
import myinfo from "@/components/myPage/myInfo.vue";
import ModifyUser from "@/components/user/customUpdateUser.vue";
export default {
  name: "MyPage",
  components: {
    colorpallete,
    myinfo,
    ModifyUser,
  },
  data() {
    return {
      showModal: false,
    };
  },
  methods: {
    testClick() {
      console.lot("이게맞음?");
    },
  },
};
</script>
<style scoped>
/* 마이페이지 전체 틀 */
.mypage {
  justify-content: center;
  margin-left: 120px;
}

/* 마이페이지 title */
.title {
  margin-left: 25%;
}
.title h1 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 30px 0 10px 0;
}

.title > hr {
  display: flex;
  width: 180px;
  margin: 0;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}

/* contents */
.contents {
  justify-content: center;
  display: flex;
  width: 60%;
  margin-left: 20%;
  margin-top: 15px;
  text-align: center;
}

/* 사용자 정보 (프로필 사진, 내 정보, 회원정보 수정) */
.personInfo {
  width: 200px;
  height: 100%;
  margin: 10px;
}
/* 프로필 사진 */
.profileImg {
  display: flex;
  width: 200px;
  height: 200px;
  border: 2px solid #d0d1ff;
  margin-bottom: 10px;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.profileimgfile {
  width: 170px;
  height: 170px;
  margin-top: 8px;
  margin-left: 7px;
  border-radius: 50%;
  border: 8px solid #c1c4ff;
}
.grade {
  width: 50px;
  height: 50px;
  margin-top: 140px;
  margin-left: -50px;
}
/* 내 정보 */
.myInfo {
  display: flex;
  width: 200px;
  height: 320px;
  border: 2px solid #d0d1ff;
  margin-bottom: 10px;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  margin-right: 0;
}
/* 회원정보 수정 */
.updateInfo {
  width: 200px;
  height: 35px;
  border: 2px solid #d0d1ff;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  margin-right: 0;
  text-align: left;
}
.updateInfo a {
  margin: 0;
  line-height: 35px;
  font-size: 13px;
  font-weight: bold;
  margin-left: 15px;
}

/* 컬러팔레트 내역 */
.firstcolor {
  width: 70px;
  height: 80px;
  margin: 10px 20px 0 20px;
  border: 1px solid #d0d1ff;
  border-radius: 5px;
  background-color: white;
  text-align: center;
}
.top1 p {
  margin: 5px 5px;
}
.colormark {
  display: flex;
  margin-left: 10px;
}
.color {
  float: left;
  border: 1px solid #d0d1ff;
  width: 40px;
  padding-bottom: 40px;
  border-radius: 50%;
  margin-left: 15px;
}
.colorpallete {
  border: 2px solid #d0d1ff;
  width: 500px;
  height: 585px;
  margin-top: 10px;
  margin-left: 5px;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.colorpalleteTitle {
  margin-top: 10px;
  margin-left: 10px;
  margin-bottom: 10px;
  display: flex;
}
.colorpalleteTitle h2 {
  text-align: left;
  margin: 20px;
}
.nowColor {
  width: 160px;
  height: 60px;
  margin: 8px 0 0 70px;
  border: 2px solid #d0d1ff;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.colorName {
  height: 40px;
  margin: 5px;
  border: 5px solid #e3d3ff;
}
.colorName p {
  margin-top: 3px;
  margin-bottom: 1px;
  font-size: 13px;
}

.palleteBorder {
  height: 80%;
}

.PalleteTitle {
  background-color: #f6f6f6;
  height: 150px;
  width: 400px;
  margin: 5px 0 5px 30px;
  float: left;
}

.info {
  display: flex;
}

.PalleteTitle > p,
.info > p {
  margin: 3px;
  width: 120px;
  margin-top: 20px;
  font-size: 18px;
  font-weight: bold;
}
.randomInfo {
  font-size: 13px;
  margin-left: 35px;
}
.pallete {
  float: left;
  margin-top: -10px;
}
/*모달 스타일 */
#updateUserInfoModal {
  width: 100%;
  height: 120%;
  display: flex;
  justify-content: center;
  margin-top: -4%;
}
</style>
