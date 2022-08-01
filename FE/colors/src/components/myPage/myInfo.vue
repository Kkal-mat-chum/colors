<template>
  <div>
    <div class="infoTitle">
      <h4>내 정보</h4>
    </div>
    <div>
      <p class="info">이름</p>
      <p class="personalInfo">김민영</p>
    </div>
    <div>
      <p class="info">별명</p>
      <p class="personalInfo">미뇽</p>
    </div>
    <div>
      <p class="info">등급</p>
      <p class="personalInfo">색깔 초보</p>
    </div>
    <div>
      <p class="info">포인트</p>
      <p class="personalInfo">100p</p>
    </div>
    <div>
      <p class="info">이메일</p>
      <p class="personalInfo">1004home3@gmail.com</p>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.infoTitle {
  text-align: left;
  margin-left: 15px;
}
.infoTitle h4 {
  margin-top: 20px;
  margin-bottom: 20px;
}
.info {
  text-align: left;
  font-size: 13px;
  margin: 0;
  margin-left: 15px;
  margin-top: 10px;
  font-weight: bold;
}
.personalInfo {
  margin-top: 4px;
  margin-bottom: 4px;
  margin-left: 8px;
  font-size: 15px;
  text-align: left;
  margin-left: 20px;
  color: #6667ab;
}
</style>
