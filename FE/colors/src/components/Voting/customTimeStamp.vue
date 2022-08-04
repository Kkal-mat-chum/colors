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
  // computed: {
  //   timeStr: function () {
  //     return
  //   }
  // },
  //새로고침하면 바로 실행
  mounted() {
    this.start_auto_reload();
  },
  methods: {
    totalTime() {
      this.timeStr = this.$store.state.teamJoinList.length * 30 + 1;
    },
    start_auto_reload() {
      console.log("start!");
      this.totalTime();
      // this.auto_reload = true;
      this.auto_reload_func = setInterval(() => {
        this.getData(true);
      }, this.auto_reload_delay);
      if (this.timeStr <= 0) {
        clearInterval(this.auto_reload_func);
        // 페이지 자동 넘김 필요 ==================================================================
      }
    },
    getData() {
      this.timeStr--;
      this.prettyTime();
      console.log(this.timeShow);
    },
    // stop_auto_reload() {
    //   console.log("stop!");
    //   // this.auto_reload = false;
    //   clearInterval(this.auto_reload_func);
    // },
    prettyTime() {
      let minutes = parseInt(this.timeStr / 60);
      let seconds = Math.round((this.timeStr / 60 - minutes) * 60);
      if (seconds <= 0) {
        seconds = "00";
      }
      this.timeShow = minutes + ":" + seconds;
    },
  },
  // computed: {
  //   timeTotal: function () {
  //     return this.$store.state.teamJoinList.length * 30;
  //   },
  //   // prettyTime: function () {
  //   //   return timeTotal
  //   // },
  // },
  // methods: {

  //   consoleprint() {
  //     this.timeStr = this.prettyTime();
  //     console.log(this.timeStr);
  //   },
  //   timerStart: function () {
  //     this.timeStr = setInterval(this.afterOneSec(), 100);
  //   },
  //   afterOneSec: function () {
  //     this.timeStr--;
  //   },
  //   prettyTime() {
  //     let time = this.timeTotal / 60;
  //     let minutes = parseInt(time);
  //     let secondes = Math.round((time - minutes) * 60);
  //     return minutes.toString().padStart(2, "0") + ":" + secondes.toString().padStart(2, "0");
  //   },
  // },
  //--------------------------------
  // data: function () {
  //   return {
  //     Timer: null,
  //     TimeCounter: 180,
  //     TimerStr: "03:00",
  //   };
  // },
  // mounted: function () {
  //   //문자발송성공시 호출
  //   if (this.Timer != null) {
  //     this.timerStop(this.Timer);
  //     this.Timer = null;
  //   }
  //   this.Timer = this.timerStart();
  // },
  // methods: {
  //   timerStart: function () {
  //     // 1초에 한번씩 start 호출
  //     this.TimeCounter = 180;
  //     var interval = setInterval(() => {
  //       this.TimeCounter--; //1초씩 감소
  //       this.TimerStr = this.prettyTime();
  //       if (this.TimeCounter <= 0) this.timerStop(interval);
  //     }, 1000);
  //     return interval;
  //   },
  //   timerStop: function (Timer) {
  //     clearInterval(Timer);
  //     this.TimeCounter = 0;
  //   },
  //   prettyTime: function () {
  //     // 시간 형식으로 변환 리턴
  //     let time = this.TimeCounter / 60;
  //     let minutes = parseInt(time);
  //     let secondes = Math.round((time - minutes) * 60);
  //     return minutes.toString().padStart(2, "0") + ":" + secondes.toString().padStart(2, "0");
  //   },
  // },
};
</script>

<style>
.timerComponent {
  color: #6667ab;
  font-size: 180%;
  font-weight: 600;
}
</style>
