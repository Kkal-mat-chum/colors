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
            <img class="profileimgfile" id="profileimgfile" src="@/assets/logo_vertical.png" alt="" />
            <div class="setting_bg">
              <img class="setting" src="@/assets/mypage/user.png" alt="" @click="showImgModal = true" style="cursor: pointer" />
              <custom-modal class="updateUserProfileModal" id="updateUserProfileModal" v-show="showImgModal" @close-modal="showImgModal = false" titleText="프로필 사진 변경">
                <cotent>
                  <modify-profile></modify-profile>
                </cotent>
              </custom-modal>
            </div>
          </div>
          <div class="myInfo">
            <myinfo></myinfo>
          </div>
          <div class="updateInfo">
            <a class="updateUserInfo" @click="showModal = true">회원정보수정</a>
            <custom-modal class="updateUserInfoModal" id="updateUserInfoModal" v-show="showModal" @close-modal="showModal = false" titleText="회원정보수정">
              <cotent><modify-user></modify-user></cotent>
            </custom-modal>
          </div>
        </div>
        <div class="colorpallete">
          <div class="colorpalleteTitle">
            <h2>컬러 팔레트 내역</h2>
            <div class="nowColor">
              <div class="colorName" id="hoveringBorder" :style="hoveringBorder">
                <p>{{ hoveringColor }}</p>
                <p>{{ hoveringColorName }}</p>
              </div>
            </div>
          </div>
          <div class="palleteBorder">
            <div class="PalleteTitle">
              <p>개인</p>
              <div class="colormark">
                <div class="firstcolor">
                  <div class="top1"><p>1위</p></div>
                  <div class="color" @mouseover="mouseOver01" :style="customColorTop" id="aloneTop1"></div>
                </div>
                <colorpalleteAlone class="pallete"></colorpalleteAlone>
              </div>
            </div>
            <div class="PalleteTitle">
              <p>단체</p>
              <div class="colormark">
                <div class="firstcolor">
                  <div class="top1"><p>1위</p></div>
                  <div class="color" @mouseover="mouseOver02" :style="customColorTop" id="teamTop1"></div>
                </div>
                <colorpalleteTeam class="pallete"></colorpalleteTeam>
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
                  <div class="color" @mouseover="mouseOver03" :style="customColorTop" id="randomTop1"></div>
                </div>
                <colorpalleteRandom class="pallete"></colorpalleteRandom>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
// import colorpallete from "@/components/myPage/colorPallete.vue";
import colorpalleteAlone from "@/components/myPage/colorPalleteAlone.vue";
import colorpalleteTeam from "@/components/myPage/colorPalleteTeam.vue";
import colorpalleteRandom from "@/components/myPage/colorPalleteRandom.vue";
import myinfo from "@/components/myPage/myInfo.vue";
import ModifyUser from "@/components/user/customUpdateUser.vue";
import ModifyProfile from "@/components/myPage/profileImgUpload.vue";
import namedColors from "color-name-list";
import nearestColor from "nearest-color";
export default {
  name: "MyPage",
  components: {
    // colorpallete,
    colorpalleteAlone,
    colorpalleteTeam,
    colorpalleteRandom,
    myinfo,
    ModifyUser,
    ModifyProfile,
  },
  data() {
    return {
      showModal: false,
      showImgModal: false,
      // hoveringColor: this.$store.state.hoveringColor,
    };
  },
  mounted() {
    console.log("?????????");
    console.log(this.$store.state.aloneColorLst[0]);
    // 결과 api받고, store에 저장해놓기
    this.getMyPageData();
    // this.$store.state.aloneColorLst = ["#6666ac", "#777743", "#8888sf", "#222299", "#000033", "#389425", "#363636", "#fff999"];
    let memberData = JSON.parse(sessionStorage.getItem("memberData"));
    let profile = memberData.data.profileUrl;
    if (profile == null) {
      profile = document.getElementById("profileimgfile").src;
    }
    console.log(profile);
    document.getElementById("profileimgfile").src = profile;
  },
  computed: {
    customColorTop() {
      return {
        "--background-color-alonetop1": this.$store.state.aloneTop1,
        "--background-color-teamtop1": this.$store.state.teamTop1,
        "--background-color-randomtop1": this.$store.state.randomTop1,
      };
    },
    hoveringColor: function () {
      return this.$store.state.hoveringColor;
    },
    hoveringBorder() {
      return {
        "--hovering-border": this.$store.state.hoveringColor,
      };
    },
    hoveringColorName: function () {
      try {
        var colorname = this.$store.state.hoveringColor.toLowerCase();
        console.log(colorname);
        let colors = namedColors.reduce((o, { name, hex }) => Object.assign(o, { [name]: hex }), {});
        const nearest = nearestColor.from(colors);
        // get closest named color

        return nearest(colorname).name;
      } catch (error) {
        console.log(error);
        return "";
      }
    },
  },
  methods: {
    getMyPageData() {
      axios
        .post(this.$store.state.baseurl + "room/mypage", {
          userid: sessionStorage.getItem("memberId"),
        })
        .then((response) => {
          //roomtype에 맞게 store에 정보 저장
          var i = 0;
          for (i = 0; i < 4; i++) {
            if (response.data.data[i].roomtype == "single") {
              this.$store.state.aloneColorLst = response.data.data[i].code;
              this.$store.state.aloneTop1 = response.data.data[i].top1.code;
            } else if (response.data.data[i].roomtype == "group") {
              this.$store.state.teamColorLst = response.data.data[i].code;
              this.$store.state.teamTop1 = response.data.data[i].top1.code;
            } else if (response.data.data[i].roomtype == "random") {
              this.$store.state.randomColorLst = response.data.data[i].code;
              this.$store.state.randomTop1 = response.data.data[i].top1.code;
            } else {
              break;
            }
          }
        });
    },
    mouseOver01() {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneTop1);
    },
    mouseOver02() {
      this.$store.commit("changeHoveringColor", this.$store.state.teamTop1);
    },
    mouseOver03() {
      this.$store.commit("changeHoveringColor", this.$store.state.randomTop1);
    },
    // getMyPageData() {
    //   axios
    //     .get(this.$store.state.baseurl + "api/room/mypage", {
    //       userid: sessionStorage.getItem("uniq_id"),
    //     })
    //     .then((response) => {
    //       let idx = 0;
    //       if (response.data[idx].roomtype == "single") {
    //         this.$store.state.
    //       }
    //     });
    // }.
    // updateColorPallet() {
    //   this.$store.state.aloneColorLst = ["#6666ac", "#777743", "#8888sf", "#222299", "#000033", "#389425", "#363636", "#fff999"];
    // },
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

.setting {
  width: 50px;
  height: 50px;
  margin-top: 140px;
  margin-left: -60px;
}
.updateUserProfileModal {
  z-index: 999;
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
.updateUserInfo {
  color: #6667ab;
  cursor: pointer;
}
/*모달 스타일 */
#updateUserInfoModal {
  width: 100%;
  height: 150%;
  display: flex;
  justify-content: center;
  margin-top: -4%;
}
#hoveringBorder {
  border-color: var(--hovering-border);
}

.color:hover {
  border: 2px solid #666666;
}
#aloneTop1 {
  background-color: var(--background-color-alonetop1);
}
#teamTop1 {
  background-color: var(--background-color-teamtop1);
}
#randomTop1 {
  background-color: var(--background-color-randomtop1);
}
</style>
