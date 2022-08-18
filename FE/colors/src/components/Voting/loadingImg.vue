<template>
  <div class="loadingBody">
    <!-- https://icons8.com/preloaders/en/search/circle 의 12 segments -->
    <div class="mainSqure">
      <img src="@/assets/imagedefault/loadingimg.gif" alt="로딩 중" class="loadingImg" />
      <label for="" class="loadinglabel">{{ loadingText }}</label>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    loadingText: String,
  },
};
</script>

<style scoped>
.loadingBody {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(211, 211, 211, 0.4);
  display: flex;
  justify-content: center;
}
.mainSqure {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: white;
  width: 400px;
  height: 300px;
  border-radius: 20px;
  margin-top: 100px;
  border: 3px solid #d0d1ff;
}
.loadingImg {
  width: 90px;
  margin: 60px 45px 35px 45px;
}
.loadinglabel {
  display: block;
  margin-bottom: 60px;
  font-size: 140%;
  font-weight: 700;
  color: #6667ab;
}
</style>
