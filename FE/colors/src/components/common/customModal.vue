<template>
  <div class="modal-overlay" @click="$emit('close-modal')">
    <div class="modal" @click.stop>
      <div class="close" @click="$emit('close-modal')">X</div>
      <p class="title">{{ titleText }}</p>
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  props: {
    titleText: String,
  },
};
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
  background-color: rgba(211, 211, 211, 0.4);
}

.modal {
  text-align: center;
  height: 50%;
  width: 50%;
  margin-top: 10%;
  padding: 60px 0;
  background: #ffffff;
  border: 3px solid #d0d1ff;
  border-radius: 10px;
}
.close {
  text-align: right;
  margin-right: 1rem;
  margin-top: -10%;
  font: 20px "prtendard ExtraBold";
  color: #6667ab;
  cursor: pointer;
}

.title {
  font-family: "Pretendard ExtraBold";
  font-size: 35px;
  color: #6667ab;
  text-align: left;
  width: fit-content;
  margin-left: 2rem;
  position: relative;
}

.title:after {
  content: "";
  width: 140%;
  display: block;
  position: absolute;
  margin-top: 50px;
  border-bottom: 5px solid #d0d1ff;
}
</style>
