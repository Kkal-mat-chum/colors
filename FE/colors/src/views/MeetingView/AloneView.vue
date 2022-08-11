<template>
  <div class="aloneMeeting">
    <sidebar></sidebar>
    <div class="contents">
      <div class="camera">
        <webcam class="webcam"></webcam>
        <div class="buttons">
          <customButton class="mute" btnText="음소거"></customButton>
          <customButton class="videostop" btnText="비디오 중지"></customButton>
        </div>
      </div>
      <div class="rightSidebar">
        <div class="title">
          <h2>나만의 색상 팔레트</h2>
          <hr />
        </div>
        <colorpallete class="pallete"></colorpallete>
        <div class="selectColor">
          <colorchoice @changeColor="changeColor"></colorchoice>
        </div>
        <customButton class="selectColorbtn" btnText="색상 팔레트에 담기" ref="colorchoice" @click="showOneSelectedColor"></customButton>
        <customButton class="votebtn" btnText="투표하기"></customButton>
        <customButton class="exitbtn" btnText="종료"></customButton>
      </div>
    </div>
  </div>
</template>

<script>
import mixin from "@/components/videochat/colorPallete/mixin";
import sidebar from "@/components/common/customSidebar.vue";
import webcam from "@/components/videochat/webcamStream.vue";
import colorpallete from "@/components/myPage/colorPallete.vue";
import colorchoice from "@/components/videochat/colorPallete/colorChoice.vue";
// import selectedcolor from '@/store/modules/memberStore.js'

export default {
  name: "aloneMeeting",
  components: {
    sidebar,
    webcam,
    colorpallete,
    colorchoice,
  },
  mixins: [mixin],
  data() {
    return {
      modelRgba: "",
      modelHex: "",
      r: 0,
      g: 0,
      b: 0,
      a: 1,
      h: 0,
      s: 0,
      v: 0,
      count: 0,
      selectedColorLst: ["#000000", "#000000", "#000000", "#000000", "#000000", "#000000"],
    };
  },
  computed: {
    rgba() {
      return {
        r: this.r,
        g: this.g,
        b: this.b,
        a: this.a,
      };
    },
    hsv() {
      return {
        h: this.h,
        s: this.s,
        v: this.v,
      };
    },
  },
  created() {
    Object.assign(this, this.setColorValue(this.color));
    this.setText();

    this.$watch("rgba", () => {
      this.$emit("changeColor", {
        rgba: this.rgba,
        hsv: this.hsv,
        hex: this.modelHex,
      });
    });
  },
  methods: {
    // 선택한 색의 컬러코드를 store에 저장
    showOneSelectedColor() {
      if (this.count < 8) {
        this.modelHex = this.rgb2hex(this.rgba, true);
        console.log(this.modelHex);
        this.$store.commit("NEW_COLOR", { color: this.modelHex });
        this.selectedColorLst = this.$store.state.selectedColorLst;
        this.selectedColorLst.splice(this.count, 1, this.$store.state.storeselectedColor.color);
        this.$store.state.selectedColorLst = this.selectedColorLst;
        this.count++;
      }
    },
    setText() {
      this.modelHex = this.rgb2hex(this.rgba, true);
      this.modelRgba = `${this.r}, ${this.g}, ${this.b}, ${this.a}`;
    },
    changeColor(color) {
      const { r, g, b, a, h, s, v } = this.setColorValue(color.rgba);
      Object.assign(this, { r, g, b, a, h, s, v });
      this.modelHex = color.hex;

      this.$store.state.r = this.r;
      this.$store.state.g = this.g;
      this.$store.state.b = this.b;
    },
  },
};
</script>

<style scoped>
html,
body {
  height: 100vh;
  overflow: hidden;
}
.contents {
  display: flex;
  margin-left: 120px;
  height: 100vh;
}
.camera {
  width: 157vh;
  text-align: center;
}
.webcam {
  display: inline-block;
  width: 600px;
  height: 300px;
  margin-top: 150px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
.buttons {
  margin-top: 50px;
}
.mute {
  width: 150px;
  margin-right: 20px;
}
.videostop {
  width: 150px;
}
.rightSidebar {
  width: 40vh;
  height: 100vh;
  box-shadow: 5px 1px 40px rgba(168, 168, 168, 0.4);
  text-align: center;
}
.title {
  margin-left: 50px;
}
.title h2 {
  display: flex;
  text-align: left;
  color: #6667ab;
  margin: 30px 0 10px 0;
}

.title > hr {
  display: flex;
  width: 200px;
  margin: 0;
  border: 0;
  height: 3px;
  background: #d0d1ff;
}

.pallete {
  display: inline-block;
  margin-top: 20px;
}

.selectColor {
  display: inline-block;
  background-color: #d0d1ff;
  margin-top: 25px;
}

.selectColorbtn {
  width: 200px;
  margin-top: 20px;
}

.votebtn {
  margin-top: 100px;
  width: 200px;
}
.exitbtn {
  width: 200px;
  margin-top: 10px;
}
</style>
