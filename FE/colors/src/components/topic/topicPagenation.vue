<template>
  <div class="pagenationContainer">
    <i class="material-symbols-rounded">keyboard_double_arrow_left</i>
    <i class="fa-solid fa-caret-left"></i>
    <customButton v-for="page in pages" :key="page" :btnText="page"></customButton>
    <i class="fa-solid fa-caret-right"></i>
    <i class="material-symbols-rounded">keyboard_double_arrow_right</i>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pages: Array,
    };
  },
  props: {
    pageNumber: Number,
    currentPage: Number,
  },
  mounted() {
    var pageDecimical = parseInt(this.currentPage / 10);
    if (this.currentPage > 10) {
      // eslint-disable-next-line vue/no-mutating-props
      this.pageNumber = this.pageNumber % 10;
      console.log(pageDecimical);
      this.pages = Array.from({ length: this.pageNumber }, (item, index) => index + 1 + pageDecimical * 10);
    } else {
      this.pages = Array.from({ length: this.pageNumber }, (item, index) => index + 1);
    }
    console.log(this.pages);
  },
};
</script>

<style scoped>
.pagenationContainer {
  display: flex;
  align-items: center;
  gap: 3px;
}
.pagenationContainer i {
  font-size: 36px;
  color: #d0d1ff;
}
.pagenationContainer i:hover {
  color: #6667ab;
}
</style>
