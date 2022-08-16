<template>
  <div class="bodyColorVot">
    <div class="gridColorVote2">
      <div class="gridLeftBtnColorVote1"></div>
      <div class="gridPicturesColorVote">
        <div class="gridPicturesColorVote1">
          <img :src="imgUrl0" :alt="imgUrl0" class="imageColorVote" :style="customBorder" @click="selectColor0" id="imageColorVote0" />
          <img :src="imgUrl1" :alt="imgUrl1" class="imageColorVote" :style="customBorder" @click="selectColor1" id="imageColorVote1" />
          <img :src="imgUrl2" :alt="imgUrl2" class="imageColorVote" :style="customBorder" @click="selectColor2" id="imageColorVote2" />
          <img :src="imgUrl3" :alt="imgUrl3" class="imageColorVote" :style="customBorder" @click="selectColor3" id="imageColorVote3" />
        </div>
        <div class="gridPicturesColorVote2">
          <img :src="imgUrl4" :alt="imgUrl4" class="imageColorVote" :style="customBorder" @click="selectColor4" id="imageColorVote4" />
          <img :src="imgUrl5" :alt="imgUrl5" class="imageColorVote" :style="customBorder" @click="selectColor5" id="imageColorVote5" />
          <img :src="imgUrl6" :alt="imgUrl6" class="imageColorVote" :style="customBorder" @click="selectColor6" id="imageColorVote6" />
          <img :src="imgUrl7" :alt="imgUrl7" class="imageColorVote" :style="customBorder" @click="selectColor7" id="imageColorVote7" />
        </div>
      </div>
      <div class="gridRightBtnColorVote"></div>
    </div>
    <div class="gridColorVote3">
      <customButton class="completeBtnColorVote" id="completeBtnColorVote" v-if="nextBtnShow" btnText="선택 완료" @click="finishRound">선택 완료</customButton>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      nowSelected: "", //개별 화면에서 실시간으로 선택하고 있는 색상코드
      //아직 밑에 리스트는 색상 코드만 있어요. 결과 저장할 때 어떤 형식으로 만들어야하는지 판단하고 조정할 예정
      selectedLst: [], //선택한 색상코드 리스트. key(고유id), value 갖는 형식 ex) [{"321432":"#112233"}, {"623474":"#223344"}]
      customBorderColor0: "#d0d1ff",
      customBorderColor1: "#d0d1ff",
      customBorderColor2: "#d0d1ff",
      customBorderColor3: "#d0d1ff",
      customBorderColor4: "#d0d1ff",
      customBorderColor5: "#d0d1ff",
      customBorderColor6: "#d0d1ff",
      customBorderColor7: "#d0d1ff",
      // addData: "",
    };
  },
  computed: {
    //개인인지 단체인지 판단하여 "다음으로" 버튼 표시 결정하기 위함.
    nextBtnShow() {
      // if (this.$store.state.resultStore.data.length > 1) {
      if (this.$store.state.resultStore.cnt > 1) {
        return false;
      } else {
        return true;
      }
    },
    imgUrl0() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[0];
    },
    imgUrl1() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[1];
    },
    imgUrl2() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[2];
    },
    imgUrl3() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[3];
    },
    imgUrl4() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[4];
    },
    imgUrl5() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[5];
    },
    imgUrl6() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[6];
    },
    imgUrl7() {
      return this.$store.state.resultStore.data[this.$store.state.resultStore.voteRound - 1].urls[7];
    },
    cnt() {
      return this.$store.state.resultStore.cnt;
    },
    //실시간으로 투표의 순서 - 인덱스로 쓰입니다
    now_idx() {
      return this.$store.state.resultStore.voteRound - 1;
    },
    rest_time() {
      return this.$store.state.resultStore.restTime;
    },
    //각 사람들의 id, 이름 닉넴, 이미지url, 팔레트가 들어있음.
    member_choice_data() {
      return this.$store.state.resultStore;
    },
    customBorder() {
      return {
        "--border-selected0": this.customBorderColor0,
        "--border-selected1": this.customBorderColor1,
        "--border-selected2": this.customBorderColor2,
        "--border-selected3": this.customBorderColor3,
        "--border-selected4": this.customBorderColor4,
        "--border-selected5": this.customBorderColor5,
        "--border-selected6": this.customBorderColor6,
        "--border-selected7": this.customBorderColor7,
      };
    },
  },
  watch: {
    rest_time(value) {
      console.log("watch", value);
      this.nextRound();
    },
  },
  mounted() {
    this.getResult(); //미팅 결과 가져오기
  },
  methods: {
    //미팅 결과 가져오기, store에 저장
    getResult() {
      console.log(sessionStorage.getItem("roomId"));
      axios
        .post(this.$store.state.baseurl + "room/getresult", {
          roomid: sessionStorage.getItem("roomId"),
        })
        .then((response) => {
          console.log(response.data.message); //성공여부 확인 로그
          this.$store.commit("groupInit");
          this.$store.commit("setGroupData", response.data);
          console.log("참여자 수");
          console.log(this.$store.state.resultStore.cnt);
        });
    },
    //다음 라운드로 넘어가기
    nextRound() {
      if (this.rest_time == 0) {
        //현재 선택한거 리스트에 추가
        var addData = new Object();
        addData.targetid = this.$store.state.resultStore.data[this.now_idx].id;
        addData.code = this.nowSelected;
        addData = JSON.stringify(addData);
        this.selectedLst.push(JSON.parse(addData));
        this.$store.state.resultStore.voteContent = this.selctedLst;
        // this.addData = { targetid: this.$store.state.data[this.now_idx].id, code: this.nowSelected };
        // this.selectedLst.push(JSON.parse(JSON.stringify(this.addData)));
        // this.selectedLst.push(this.nowSelected);
        this.$store.state.resultStore.voteRound++;
        this.nowSelected = ""; //선택한거 초기화
        this.customBorderColor0 = "#d0d1ff";
        this.customBorderColor1 = "#d0d1ff";
        this.customBorderColor2 = "#d0d1ff";
        this.customBorderColor3 = "#d0d1ff";
        this.customBorderColor4 = "#d0d1ff";
        this.customBorderColor5 = "#d0d1ff";
        this.customBorderColor6 = "#d0d1ff";
        this.customBorderColor7 = "#d0d1ff";
      }
      // if (this.now_idx >= this.cnt) {
      //   // @@@@@@@@@@@여기서 1초마다 백으로 요청 보내서 해당 미팅 방에서
      //   // 들어온 결과를 받을 겁니다. 결과 값이 사람수(cnt)만큼 되면
      //   // 결과 화면으로 넘어가도록 해야합니다.@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
      //   this.$router.push("/nameresult");
      // }
    },
    //완료 버튼은 개인투표일때만 보임: 개인투표 끝나는 메소드
    finishRound() {
      this.saveVoteResult(); //투표 결과 저장(개인)
      this.$router.push("/nameresult"); //결과화면으로 화면이동
    },
    //투표 결과 저장(개인)
    saveVoteResult() {
      console.log(sessionStorage.getItem("memberId"));
      console.log(this.nowSelected);
      axios
        .put(this.$store.state.baseurl + "room/vote", {
          roomid: sessionStorage.getItem("roomId"),
          userid: sessionStorage.getItem("memberId"),
          code: this.nowSelected,
        })
        .then((response) => {
          console.log(response);
          if (response.data.message == "fail") {
            alert("전송 실패");
          } else if (response.data.message == "success") {
            this.bringTotalResult();
          }
        });
    },
    //각 투표 합산put -> 투표 결과 가져오기
    bringTotalResult() {
      axios
        .put(this.$store.state.baseurl + "room/votesum", {
          roomid: sessionStorage.getItem("roomCode"),
        })
        .then((response) => {
          if (response.data.message == "success") {
            axios
              .post(this.$store.state.baseurl + "room/vote/result", {
                roomid: sessionStorage.getItem("roomCode"),
                userid: sessionStorage.getItem("userId"),
              })
              .then((response) => {
                if (response.data.message == "success") {
                  this.$store.state.resultStore.totalResultData = response.data.data;
                  this.$store.state.resultStore.aloneResult.data = response.data.data;
                } else {
                  alert("투표결과가져오기 실패");
                }
              });
          }
        });
    },
    mouseover0() {
      this.customBorderColor0 = "#4a4d74";
    },
    mouseleave0() {
      this.customBorderColor0 = "#d0d1ff";
    },
    mouseover1() {
      this.customBorderColor1 = "#4a4d74";
    },
    mouseleave1() {
      this.customBorderColor1 = "#d0d1ff";
    },
    mouseover2() {
      this.customBorderColor2 = "#4a4d74";
    },
    mouseleave2() {
      this.customBorderColor2 = "#d0d1ff";
    },
    mouseover3() {
      this.customBorderColor3 = "#4a4d74";
    },
    mouseleave3() {
      this.customBorderColor3 = "#d0d1ff";
    },
    mouseover4() {
      this.customBorderColor4 = "#4a4d74";
    },
    mouseleave4() {
      this.customBorderColor4 = "#d0d1ff";
    },
    mouseover5() {
      this.customBorderColor5 = "#4a4d74";
    },
    mouseleave5() {
      this.customBorderColor5 = "#d0d1ff";
    },
    mouseover6() {
      this.customBorderColor6 = "#4a4d74";
    },
    mouseleave6() {
      this.customBorderColor6 = "#d0d1ff";
    },
    mouseover7() {
      this.customBorderColor7 = "#4a4d74";
    },
    mouseleave7() {
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor0() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[0];
      this.customBorderColor0 = "#4a4d74";
      this.customBorderColor1 = "#d0d1ff";
      this.customBorderColor2 = "#d0d1ff";
      this.customBorderColor3 = "#d0d1ff";
      this.customBorderColor4 = "#d0d1ff";
      this.customBorderColor5 = "#d0d1ff";
      this.customBorderColor6 = "#d0d1ff";
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor1() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[1];
      this.customBorderColor0 = "#d0d1ff";
      this.customBorderColor1 = "#4a4d74";
      this.customBorderColor2 = "#d0d1ff";
      this.customBorderColor3 = "#d0d1ff";
      this.customBorderColor4 = "#d0d1ff";
      this.customBorderColor5 = "#d0d1ff";
      this.customBorderColor6 = "#d0d1ff";
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor2() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[2];
      this.customBorderColor0 = "#d0d1ff";
      this.customBorderColor1 = "#d0d1ff";
      this.customBorderColor2 = "#4a4d74";
      this.customBorderColor3 = "#d0d1ff";
      this.customBorderColor4 = "#d0d1ff";
      this.customBorderColor5 = "#d0d1ff";
      this.customBorderColor6 = "#d0d1ff";
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor3() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[3];
      this.customBorderColor0 = "#d0d1ff";
      this.customBorderColor1 = "#d0d1ff";
      this.customBorderColor2 = "#d0d1ff";
      this.customBorderColor3 = "#4a4d74";
      this.customBorderColor4 = "#d0d1ff";
      this.customBorderColor5 = "#d0d1ff";
      this.customBorderColor6 = "#d0d1ff";
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor4() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[4];
      this.customBorderColor0 = "#d0d1ff";
      this.customBorderColor1 = "#d0d1ff";
      this.customBorderColor2 = "#d0d1ff";
      this.customBorderColor3 = "#d0d1ff";
      this.customBorderColor4 = "#4a4d74";
      this.customBorderColor5 = "#d0d1ff";
      this.customBorderColor6 = "#d0d1ff";
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor5() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[5];
      this.customBorderColor0 = "#d0d1ff";
      this.customBorderColor1 = "#d0d1ff";
      this.customBorderColor2 = "#d0d1ff";
      this.customBorderColor3 = "#d0d1ff";
      this.customBorderColor4 = "#d0d1ff";
      this.customBorderColor5 = "#4a4d74";
      this.customBorderColor6 = "#d0d1ff";
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor6() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[6];
      this.customBorderColor0 = "#d0d1ff";
      this.customBorderColor1 = "#d0d1ff";
      this.customBorderColor2 = "#d0d1ff";
      this.customBorderColor3 = "#d0d1ff";
      this.customBorderColor4 = "#d0d1ff";
      this.customBorderColor5 = "#d0d1ff";
      this.customBorderColor6 = "#4a4d74";
      this.customBorderColor7 = "#d0d1ff";
    },
    selectColor7() {
      this.nowSelected = this.member_choice_data.data[this.now_idx].colors[7];
      this.customBorderColor0 = "#d0d1ff";
      this.customBorderColor1 = "#d0d1ff";
      this.customBorderColor2 = "#d0d1ff";
      this.customBorderColor3 = "#d0d1ff";
      this.customBorderColor4 = "#d0d1ff";
      this.customBorderColor5 = "#d0d1ff";
      this.customBorderColor6 = "#d0d1ff";
      this.customBorderColor7 = "#4a4d74";
    },
  },
};
</script>

<style scoped>
.gridColorVote2 {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.gridPicturesColorVote {
  display: flex;
  flex-direction: column;
  padding: 35px 0;
}
.gridPicturesColorVote1 {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
.gridPicturesColorVote2 {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
.imageColorVote {
  display: inline-block;
  width: 280px;
  height: 200px;
  margin: 3px 10px;
  border: 2px solid #d0d1ff;
  border-radius: 15px;
  filter: drop-shadow(6px 6px 4px rgba(0, 0, 0, 0.25));
}
/* .imageColorVote:hover {
  border-color: #4a4d74;
} */
.leftBtnColorVote {
  color: #6667ab;
  margin: 0px 5px 0px 30px;
}
.rightBtnColorVote {
  color: #6667ab;
  margin: 0px 30px 0px 5px;
}
.gridColorVote3 {
  display: flex;
  flex-direction: row;
  justify-content: right;
}
#completeBtnColorVote {
  width: 20%;
  margin-right: 100px;
}
#imageColorVote0 {
  border-color: var(--border-selected0);
}
#imageColorVote0:hover {
  border-color: #4a4d74;
}
#imageColorVote1 {
  border-color: var(--border-selected1);
}
#imageColorVote1:hover {
  border-color: #4a4d74;
}
#imageColorVote2 {
  border-color: var(--border-selected2);
}
#imageColorVote2:hover {
  border-color: #4a4d74;
}
#imageColorVote3 {
  border-color: var(--border-selected3);
}
#imageColorVote3:hover {
  border-color: #4a4d74;
}
#imageColorVote4 {
  border-color: var(--border-selected4);
}
#imageColorVote4:hover {
  border-color: #4a4d74;
}
#imageColorVote5 {
  border-color: var(--border-selected5);
}
#imageColorVote5:hover {
  border-color: #4a4d74;
}
#imageColorVote6 {
  border-color: var(--border-selected6);
}
#imageColorVote6:hover {
  border-color: #4a4d74;
}
#imageColorVote7 {
  border-color: var(--border-selected7);
}
#imageColorVote7:hover {
  border-color: #4a4d74;
}
</style>
