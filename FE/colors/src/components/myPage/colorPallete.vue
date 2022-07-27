<template>
  <div class="pallete">
    <div class="up">
      <div class="color"></div>
      <div class="color"></div>
      <div class="color"></div>
      <div class="color"></div>
    </div>
    <div class="down">
      <div class="color"></div>
      <div class="color"></div>
      <div class="color"></div>
      <div class="color"></div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.pallete {
  width: 70%;
  border: 1px solid #d0d1ff;
  border-radius: 10px;
}
.up {
  display: flex;
}
.down {
  display: flex;
}
.color {
  float: left;
  border: 2px solid #d0d1ff;
  width: 30px;
  padding-bottom: 30px;
  border-radius: 50%;
  margin: 5px;
}
</style>
