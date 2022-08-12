<template>
  <div class="loadingBody">
    <!-- https://icons8.com/preloaders/en/search/circle 의 12 segments -->
    <div class="mainSqure">
      <img src="@/assets/imagedefault/loadingimg.gif" alt="로딩 중" class="loadingImg" />
      <label for="" class="loadinglabel">결과를 기다리는 중...</label>
    </div>
  </div>
</template>

<script></script>

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
  width: 500px;
  height: 400px;
  border-radius: 20px;
  margin-top: 100px;
  border: 3px solid #d0d1ff;
}
.loadingImg {
  width: 150px;
  margin: 55px;
}
.loadinglabel {
  display: block;
  margin-bottom: 60px;
  font-size: 170%;
  font-weight: 700;
  color: #6667ab;
}
</style>
