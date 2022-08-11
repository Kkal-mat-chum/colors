<template>
  <div class="pallete">
    <div class="up">
      <div class="color" :style="customColor" id="zeroCircle"></div>
      <div class="color" :style="customColor" id="firstCircle"></div>
      <div class="color" :style="customColor" id="secondCircle"></div>
      <div class="color" :style="customColor" id="thirdCircle"></div>
    </div>
    <div class="down">
      <div class="color" :style="customColor" id="fourthCircle"></div>
      <div class="color" :style="customColor" id="fifthCircle"></div>
      <div class="color" :style="customColor" id="sixthCircle"></div>
      <div class="color" :style="customColor" id="sevthCircle"></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedColor: "#aaaabc",
      count: 0,
    };
  },
  computed: {
    customColor() {
      return {
        "--background-color-circle0": this.$store.state.selectedColorLst[0],
        "--background-color-circle1": this.$store.state.selectedColorLst[1],
        "--background-color-circle2": this.$store.state.selectedColorLst[2],
        "--background-color-circle3": this.$store.state.selectedColorLst[3],
        "--background-color-circle4": this.$store.state.selectedColorLst[4],
        "--background-color-circle5": this.$store.state.selectedColorLst[5],
        "--background-color-circle6": this.$store.state.selectedColorLst[6],
        "--background-color-circle7": this.$store.state.selectedColorLst[7],
      };
    },
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
  border: 1px solid #d0d1ff;
  width: 35px;
  padding-bottom: 35px;
  border-radius: 50%;
  margin: 5px;
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
