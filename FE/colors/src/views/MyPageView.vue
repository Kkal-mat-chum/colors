<template>
  <div class="mypage">
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
          <p>회원정보 수정</p>
        </div>
      </div>
      <div class="colorpallete">
        <colorpallete class="pallete"></colorpallete>
        <colorpallete class="pallete"></colorpallete>
        <colorpallete class="pallete"></colorpallete>
      </div>
    </div>
  </div>
</template>

<script>
import colorpallete from "@/components/myPage/colorPallete.vue";
import myinfo from "@/components/myPage/myInfo.vue";

export default {
  name: "MyPage",
  components: {
    colorpallete,
    myinfo,
  },
};
</script>

<style>
/* 마이페이지 전체 틀 */
.mypage {
  margin-left: 29%;
  margin-right: 20%;
  width: 800px;
}

/* 마이페이지 title */
.title {
  margin-top: 30px;
  text-align: left;
  color: #6667ab;
}
.title > h1 {
  margin-bottom: 8px;
}
.under {
  width: 200px;
  margin: 0;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}

/* 마이페이지 contents */
.contents {
  margin-top: 28px;
  display: flex;
  width: 100%;
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
  height: 300px;
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
}
.updateInfo p {
  margin: 0;
  line-height: 35px;
  font-size: 13px;
  font-weight: bold;
  text-align: left;
  margin-left: 20px;
}

/* 컬러팔레트 내역 */
.colorpallete {
  float: left;
  border: 2px solid #d0d1ff;
  width: 550px;
  height: 565px;
  margin-top: 3.5px;
  margin-left: 5px;
  border-radius: 5px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}

.pallete {
  margin: 3px;
}
</style>
