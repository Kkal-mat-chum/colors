<template>
  <div class="mypage">
    <sidebar></sidebar>
    <div class="mypageStyle">
      <div class="title">
        <h1>마이페이지</h1>
        <hr class="under" />
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
            <a>회원정보 수정</a>
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
              <colorpallete class="pallete"></colorpallete>
            </div>
            <div class="PalleteTitle">
              <p>단체</p>
              <colorpallete class="pallete"></colorpallete>
            </div>
            <div class="PalleteTitle">
              <div class="random">
                <div><p>랜덤</p></div>
                <div class="con"><p>면접 복장으로 어느 색이 잘 어울릴까요?</p></div>
              </div>
              <colorpallete class="pallete"></colorpallete>
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
import sidebar from "@/components/common/customSidebar.vue";

export default {
  name: "MyPage",
  components: {
    colorpallete,
    myinfo,
    sidebar,
  },
};
</script>

<style scoped>
/* 마이페이지 전체 틀 */
.mypage {
  margin-left: 180px;
  width: 1350px;
}
.mypageStyle {
  display: flex;
}

/* 마이페이지 title */
.title {
  display: inline;
  color: #6667ab;
  width: 60% !important;
  margin-top: -90px;
  margin-left: 113px !important;
}
.title > h1 {
  margin-bottom: 2px;
  margin-left: -3%;
}
.under {
  width: 200px;
  margin: 0 0 3px 345px;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}

/* 마이페이지 contents */
.contents {
  margin-top: 90px;
  display: flex;
  width: 60%;
  margin-left: 20%;
  text-align: center;
}

/* 사용자 정보 (프로필 사진, 내 정보, 회원정보 수정) */
.personInfo {
  float: left;
  width: 25%;
  height: 100%;
  margin: 4px;
}
/* 프로필 사진 */
.profileImg {
  width: 200px;
  height: 200px;
  border: 2px solid #d0d1ff;
  margin-bottom: 10px;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.profileimgfile {
  width: 160px;
  height: 160px;
  margin-top: 12px;
  border-radius: 50%;
  border: 8px solid #9bc86e;
}
.grade {
  width: 50px;
  height: 50px;
  position: absolute;
  margin-top: 140px;
  margin-left: -48px;
}
/* 내 정보 */
.myInfo {
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
.colorpallete {
  float: left;
  border: 2px solid #d0d1ff;
  width: 550px;
  height: 585px;
  margin-top: 3.5px;
  margin-left: 5px;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.colorpalleteTitle {
  display: flex;
  margin-top: 10px;
  margin-left: 10px;
  margin-bottom: 10px;
}
.colorpalleteTitle h2 {
  text-align: left;
  margin: 30px;
  display: flex;
}
.nowColor {
  width: 180px;
  height: 70px;
  margin-top: 8px;
  margin-left: 100px;
  border: 2px solid #d0d1ff;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.colorName {
  height: 40px;
  margin: 10px;
  border: 5px solid #e3d3ff;
}
.colorName p {
  margin: 0;
}

.PalleteTitle {
  background-color: #f6f6f6;
  width: 450px;
  height: 145px;
  margin-left: 50px;
  margin-bottom: 10px;
}
.PalleteTitle p {
  margin: 3px;
  width: 120px;
  margin-top: 10px;
  font-size: 18px;
}
.random p {
  margin: 3px;
  width: 120px;
  margin-top: 10px;
  font-size: 18px;
  float: left;
}
.con > p {
  float: left;
  width: 310px;
}
.pallete {
  margin-left: 100px;
  float: left;
}
</style>
