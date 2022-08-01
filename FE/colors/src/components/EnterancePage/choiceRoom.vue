<template>
  <div class="choiceBox">
    <img src="@/assets/logo_vertical.png" />
    <customButton class="enterButton" v-on="$listeners" :btnText="roomTitle"></customButton>
  </div>
</template>

<script>
export default {
  props: {
    roomTitle: String,
  },
};
</script>

<style scoped>
.choiceBox {
  width: 336px;
  height: 553px;
  background: #ffffff;
  border: 3px solid #d0d1ff;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 30px;
  display: inline-grid;
  justify-items: center;
  align-items: center;
}
.enterButton {
  width: fit-content;
  height: fit-content;
  padding: 5px 15px;
  font: 30px "pretendard Bold";
  justify-self: center;
}
</style>
