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

<style>
.pallete {
  width: 250px;
  border: 1px solid #d0d1ff;
  border-radius: 10px;
  background-color: white;
}
.up {
  display: flex;
  margin-left: 15px;
}
.down {
  display: flex;
  margin-left: 15px;
}
.color {
  float: left;
  border: 1px solid #d0d1ff;
  width: 43px;
  padding-bottom: 43px;
  border-radius: 50%;
  margin: 5px;
}
</style>
