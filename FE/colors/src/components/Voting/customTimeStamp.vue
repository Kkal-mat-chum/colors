<template>
  <div class="timerComponent">
    <div class="timer">{{ timeShow }}</div>
    <!-- <label for="fd" @click="stop_auto_reload" v-if="auto_reload === true">정지</label>
    <label for="dsf" @click="start_auto_reload" v-else>시작</label> -->
  </div>
</template>

<script>
export default {
  //https://minu0807.tistory.com/95 참조
  data() {
    return {
      auto_reload: false,
      auto_reload_delay: 1000,
      auto_reload_func: null,
      timeStr: 0,
      timeShow: "0:00",
      minutes: 0,
      seconds: 0,
    };
  },
  //새로고침하면 바로 실행
  mounted() {
    this.start_auto_reload();
  },
  methods: {
    totalTime() {
      this.timeStr = this.$store.memberStore.state.teamJoinList.length * 30 + 1;
    },
    start_auto_reload() {
      console.log("start!");
      this.totalTime();
      // this.auto_reload = true;
      this.auto_reload_func = setInterval(() => {
        this.getData(true);
      }, this.auto_reload_delay);
      if (this.timeStr <= 0) {
        this.stop_auto_reload();
        // clearInterval(this.auto_reload_func);
        // 페이지 자동 넘김 필요 ==================================================================
      }
    },
    getData() {
      this.timeStr--;
      this.prettyTime();
      console.log(this.timeShow);
    },
    stop_auto_reload() {
      console.log("stop!");
      // this.auto_reload = false;
      clearInterval(this.auto_reload_func);
    },
    prettyTime() {
      let minutes = parseInt(this.timeStr / 60);
      let seconds = Math.round((this.timeStr / 60 - minutes) * 60);
      if (seconds <= 0) {
        seconds = "00";
      }
      this.timeShow = minutes + ":" + seconds;
    },
  },
};
</script>

<style>
.timerComponent {
  color: #494a8d;
  font-size: 100%;
  font-weight: 600;
  width: 50px;
}
</style>
