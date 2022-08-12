<template>
  <div class="pallete">
    <div class="up">
      <div class="color" @mouseover="mouseOver0" :style="customColorAlone" id="zeroCircle"></div>
      <div class="color" @mouseover="mouseOver1" :style="customColorAlone" id="firstCircle"></div>
      <div class="color" @mouseover="mouseOver2" :style="customColorAlone" id="secondCircle"></div>
      <div class="color" @mouseover="mouseOver3" :style="customColorAlone" id="thirdCircle"></div>
    </div>
    <div class="down">
      <div class="color" @mouseover="mouseOver4" :style="customColorAlone" id="fourthCircle"></div>
      <div class="color" @mouseover="mouseOver5" :style="customColorAlone" id="fifthCircle"></div>
      <div class="color" @mouseover="mouseOver6" :style="customColorAlone" id="sixthCircle"></div>
      <div class="color" @mouseover="mouseOver7" :style="customColorAlone" id="sevthCircle"></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // aloneColor: "#aaaabc",
      // count: 0,
    };
  },
  computed: {
    customColorAlone() {
      //https://jh-7.tistory.com/26 참조
      return {
        "--background-color-circle0": this.$store.state.aloneColorLst[0],
        "--background-color-circle1": this.$store.state.aloneColorLst[1],
        "--background-color-circle2": this.$store.state.aloneColorLst[2],
        "--background-color-circle3": this.$store.state.aloneColorLst[3],
        "--background-color-circle4": this.$store.state.aloneColorLst[4],
        "--background-color-circle5": this.$store.state.aloneColorLst[5],
        "--background-color-circle6": this.$store.state.aloneColorLst[6],
        "--background-color-circle7": this.$store.state.aloneColorLst[7],
      };
    },
  },
  methods: {
    mouseOver0: function () {
      // this.$store.state.hoveringColor =
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[0]);
    },
    mouseOver1: function () {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[1]);
    },
    mouseOver2: function () {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[2]);
    },
    mouseOver3: function () {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[3]);
    },
    mouseOver4: function () {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[4]);
    },
    mouseOver5: function () {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[5]);
    },
    mouseOver6: function () {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[6]);
    },
    mouseOver7: function () {
      this.$store.commit("changeHoveringColor", this.$store.state.aloneColorLst[7]);
    },
  },
};
</script>

<style scoped>
.pallete {
  width: 200px;
  height: auto;
  border: 1px solid #d0d1ff;
  border-radius: 10px;
  background-color: white;
}
.up {
  display: flex;
  justify-content: center;
}
.down {
  display: flex;
  justify-content: center;
}
.color {
  float: left;
  border: 2px solid #d0d1ff;
  width: 35px;
  padding-bottom: 35px;
  border-radius: 50%;
  margin: 5px;
}
.color:hover {
  border: 2px solid #666666;
}
#zeroCircle {
  background-color: var(--background-color-circle0);
}
#firstCircle {
  background-color: var(--background-color-circle1);
}
#secondCircle {
  background-color: var(--background-color-circle2);
}
#thirdCircle {
  background-color: var(--background-color-circle3);
}
#fourthCircle {
  background-color: var(--background-color-circle4);
}
#fifthCircle {
  background-color: var(--background-color-circle5);
}
#sixthCircle {
  background-color: var(--background-color-circle6);
}
#sevthCircle {
  background-color: var(--background-color-circle7);
}
</style>
