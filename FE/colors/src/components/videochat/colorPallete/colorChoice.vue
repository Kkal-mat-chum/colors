<template>
  <div class="hu-color-picker" :class="{ light: isLightTheme }" :style="{ width: totalWidth + 'px' }">
    <div class="color-set">
      <Saturation ref="saturation" :color="rgbString" :hsv="hsv" :size="hueHeight" @selectSaturation="selectSaturation" />
      <Hue ref="hue" :hsv="hsv" :width="hueWidth" :height="hueHeight" @selectHue="selectHue" />
      <!-- <Alpha ref="alpha" :color="rgbString" :rgba="rgba" :width="hueWidth" :height="hueHeight" @selectAlpha="selectAlpha" /> -->
    </div>
    <Sucker v-if="!suckerHide" :sucker-canvas="suckerCanvas" :sucker-area="suckerArea" @openSucker="openSucker" @selectSucker="selectSucker" />
    <Box name="HEX" :color="modelHex" @inputColor="inputHex" />
    <Box name="RGBA" :color="modelRgba" @inputColor="inputRgba" />
    <Box name="colorName" :color="modelColor" class="colorname" />
  </div>
</template>

<script>
import mixin from "./mixin";
import Saturation from "./saturation.vue";
import Hue from "./hue.vue";
import Sucker from "./sucker.vue";
import Box from "./box.vue";
import namedColors from "color-name-list";
import nearestColor from "nearest-color";
export default {
  components: {
    Saturation,
    Hue,
    Sucker,
    Box,
  },
  mixins: [mixin],
  props: {
    color: {
      type: String,
      default: "#000000",
    },
    theme: {
      type: String,
      default: "light",
    },
    suckerHide: {
      type: Boolean,
      default: true,
    },
    suckerCanvas: {
      type: null, // HTMLCanvasElement
      default: null,
    },
    suckerArea: {
      type: Array,
      default: () => [],
    },
  },
  data() {
    return {
      hueWidth: 15,
      hueHeight: 115,
      modelRgba: "",
      modelHex: "",
      modelColor: "",
      r: 0,
      g: 0,
      b: 0,
      a: 1,
      h: 0,
      s: 0,
      v: 0,
    };
  },
  computed: {
    isLightTheme() {
      return this.theme === "light";
    },
    totalWidth() {
      return this.hueHeight + (this.hueWidth + 8) * 2;
    },
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
    rgbString() {
      return `rgb(${this.r}, ${this.g}, ${this.b})`;
    },
    rgbaStringShort() {
      return `${this.r}, ${this.g}, ${this.b}, ${this.a}`;
    },
    rgbaString() {
      return `rgba(${this.rgbaStringShort})`;
    },
    hexString() {
      return this.rgb2hex(this.rgba, true);
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
    selectSaturation(color) {
      const { r, g, b, h, s, v } = this.setColorValue(color);
      Object.assign(this, { r, g, b, h, s, v });
      this.setText();
    },
    selectHue(color) {
      const { r, g, b, h, s, v } = this.setColorValue(color);
      Object.assign(this, { r, g, b, h, s, v });
      this.setText();
      this.$nextTick(() => {
        this.$refs.saturation.renderColor();
        this.$refs.saturation.renderSlide();
      });
    },
    selectAlpha(a) {
      this.a = a;
      this.setText();
    },
    inputHex(color) {
      const { r, g, b, a, h, s, v } = this.setColorValue(color);
      Object.assign(this, { r, g, b, a, h, s, v });
      this.modelHex = color;
      this.modelRgba = this.rgbaStringShort;
      var colorname = this.$store.state.hoveringColor.toLowerCase();
      console.log(colorname);
      let colors = namedColors.reduce((o, { name, hex }) => Object.assign(o, { [name]: hex }), {});
      const nearest = nearestColor.from(colors);
      // get closest named color
      this.modelColor = nearest(colorname).name;
      this.$nextTick(() => {
        this.$refs.saturation.renderColor();
        this.$refs.saturation.renderSlide();
        this.$refs.hue.renderSlide();
      });
    },
    inputRgba(color) {
      const { r, g, b, a, h, s, v } = this.setColorValue(color);
      Object.assign(this, { r, g, b, a, h, s, v });
      this.modelHex = this.hexString;
      this.modelRgba = color;
      var colorname = this.modelHex.toLowerCase();
      console.log(colorname);
      let colors = namedColors.reduce((o, { name, hex }) => Object.assign(o, { [name]: hex }), {});
      const nearest = nearestColor.from(colors);
      // get closest named color
      this.modelColor = nearest(colorname).name;
      this.$nextTick(() => {
        this.$refs.saturation.renderColor();
        this.$refs.saturation.renderSlide();
        this.$refs.hue.renderSlide();
      });
    },
    setText() {
      this.modelHex = this.hexString;
      this.modelRgba = this.rgbaStringShort;
      var colorname = this.modelHex.toLowerCase();
      console.log(colorname);
      let colors = namedColors.reduce((o, { name, hex }) => Object.assign(o, { [name]: hex }), {});
      const nearest = nearestColor.from(colors);
      // get closest named color
      this.modelColor = nearest(colorname).name;
    },
    openSucker(isOpen) {
      this.$emit("openSucker", isOpen);
    },
    selectSucker(color) {
      const { r, g, b, a, h, s, v } = this.setColorValue(color);
      Object.assign(this, { r, g, b, a, h, s, v });
      this.setText();
      this.$nextTick(() => {
        this.$refs.saturation.renderColor();
        this.$refs.saturation.renderSlide();
        this.$refs.hue.renderSlide();
      });
    },
    selectColor(color) {
      const { r, g, b, a, h, s, v } = this.setColorValue(color);
      Object.assign(this, { r, g, b, a, h, s, v });
      this.setText();
      this.$nextTick(() => {
        this.$refs.saturation.renderColor();
        this.$refs.saturation.renderSlide();
        this.$refs.hue.renderSlide();
      });
    },
  },
};
</script>

<style lang="scss">
.hu-color-picker {
  padding: 10px;
  background: #1d2024;
  border-radius: 4px;
  box-shadow: 0 0 16px 0 rgba(0, 0, 0, 0.16);
  z-index: 1;
  &.light {
    background: #f7f8f9;
    .color-show {
      .sucker {
        background: #eceef0;
      }
    }
    .color-type {
      .name {
        background: #e7e8e9;
      }
      .value {
        color: #666;
        background: #eceef0;
      }
    }
  }
  canvas {
    vertical-align: top;
  }
  .color-set {
    display: flex;
    text-align: center;
  }
  .color-show {
    margin-top: 8px;
    display: flex;
  }
}
</style>
