<template>
  <div class="pallete">
    <div class="up">
      <div class="color" style="background-color: #ffd2d2"></div>
      <div class="color" style="background-color: #e4d3ff"></div>
      <div class="color" style="background-color: #bdccff"></div>
      <div class="color" style="background-color: #c1c4ff"></div>
    </div>
    <div class="down">
      <div class="color" style="background-color: #bfbfbf"></div>
      <div class="color" style="background-color: #000000"></div>
      <div class="color" style="background-color: #ffffff"></div>
      <div class="color" style="background-color: #ffdeec"></div>
    </div>
  </div>
</template>

<script>
export default {};
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
</style>
