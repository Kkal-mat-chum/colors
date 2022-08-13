<template>
  <!-- 타이머 시간 조정 방법 (원하는 시간을 t라고 함)
  customTimeStamp.vue에서 data의 timeShow, seconds, fix_seconds를 t로 변경
  store - resultStore.js state의 restTime를 t로 변경 -->
  <div class="timerComponent">
    <div class="timeLabel">남은 시간</div>
    <div class="timer" @click="startTimer">{{ seconds }}</div>
  </div>
</template>

<script>
export default {
  //https://minu0807.tistory.com/95 참조
  // https://webisfree.com/2014-04-08/[javascript]-%EC%8B%9C%EA%B0%84-%EC%A7%80%EC%97%B0-%ED%95%A8%EC%88%98-%EC%9D%BC%EC%A0%95-%EC%8B%9C%EA%B0%84-%EB%92%A4-%EC%8B%A4%ED%96%89%EC%8B%9C%ED%82%A4%EA%B8%B0-settimeout()-%7B%7D
  data() {
    return {
      auto_reload: false, //인터벌 사용 여부
      auto_reload_delay: 1000, //인터벌 시간
      auto_reload_func: null, //인터벌 함수 담을 곳
      timeStr: 10,
      fix_seconds: 15,
      seconds: 15,
      timeShow: "15",
      minutes: 0,
    };
  },
  //새로고침하면 바로 실행
  created() {
    this.startTimer();
  },
  methods: {
    startTimer() {
      this.auto_reload_func = setInterval(() => {
        if (this.$store.state.resultStore.voteRound <= this.$store.state.resultStore.cnt) {
          this.seconds--;
          this.$store.state.resultStore.restTime = this.seconds;
          if (this.seconds <= 0) {
            this.seconds = this.fix_seconds;
            console.log(this.$store.state.resultStore.voteRound);
          }
        }
        //사람 수만큼 라운드가 진행되면 타이머를 끕니다.
        if (this.$store.state.resultStore.voteRound > this.$store.state.resultStore.cnt) {
          this.stopTimer();
        }
      }, 1000);
    },
    stopTimer() {
      clearInterval(this.auto_reload_func);
    },
  },
  destroyed() {
    clearInterval(this.auto_reload_func);
  },
};
</script>

<style>
.timerComponent {
  color: #494a8d;
  /* font-size: 100%; */
  font-weight: 600;
  width: 100px;
}
.timer {
  font-size: 110%;
}
.timeLabel {
  font-size: 85%;
}
</style>
