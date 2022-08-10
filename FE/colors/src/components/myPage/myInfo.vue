<template>
  <div>
    <div class="infoTitle">
      <h4>내 정보</h4>
    </div>
    <div>
      <p class="info">이름</p>
      <p class="personalInfo" id="namePersonalInfo">{{ namePersonalInfo }}</p>
    </div>
    <div>
      <p class="info">별명</p>
      <p class="personalInfo" id="nicknamePersonalInfo">{{ nicknamePersonalInfo }}</p>
    </div>
    <div>
      <p class="info">등급</p>
      <p class="personalInfo" id="gradePersonalInfo">{{ gradePersonalInfo }}</p>
    </div>
    <div>
      <p class="info">포인트</p>
      <p class="personalInfo" id="pointPersonalInfo">{{ pointPersonalInfo }} p</p>
    </div>
    <div>
      <p class="info">이메일</p>
      <p class="personalInfo" id="emailPersonalInfo">{{ emailPersonalInfo }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      namePersonalInfo: "김민영",
      nicknamePersonalInfo: "미뇽",
      pointPersonalInfo: 1000,
      emailPersonalInfo: "1004home3@gmail.com",
    };
  },
  //포인트별 등급 정하기
  computed: {
    gradePersonalInfo() {
      if (this.pointPersonalInfo < 0) {
        return "bs";
      } else if (this.pointPersonalInfo < 100) {
        return "0급수";
      } else {
        return "고인물";
      }
    },
  },
  methods: {
    //기본 회원정보 출력
    showMemberInfo() {
      axios.get(this.$store.state.baseurl + "/api/member/changeinfo").then((response) => {
        this.namePersonalInfo = response.data.id;
        this.nicknamePersonalInfo = response.data.nickname;
        this.pointPersonalInfo = response.data.point;
        this.emailPersonalInfo = response.data.email;
      });
    },
  },
  mounted() {
    this.showMemberInfo();
  },
};
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
