"use strict";(self["webpackChunkcolors"]=self["webpackChunkcolors"]||[]).push([[258],{13494:function(t,e,s){s.d(e,{Z:function(){return d}});var o=function(){var t=this,e=t._self._c;return e("div",{staticClass:"timerComponent"},[e("div",{staticClass:"timeLabel"},[t._v("남은 시간")]),e("div",{staticClass:"timer",on:{click:t.startTimer}},[t._v(t._s(t.seconds))])])},a=[],r={data(){return{auto_reload:!1,auto_reload_delay:1e3,auto_reload_func:null,timeStr:10,fix_seconds:10,seconds:10,timeShow:"10",minutes:0}},created(){this.startTimer()},methods:{startTimer(){this.auto_reload_func=setInterval((()=>{this.$store.state.resultStore.voteRound<=this.$store.state.resultStore.cnt&&(this.seconds--,this.$store.state.resultStore.restTime=this.seconds,this.seconds<=0&&(this.seconds=this.fix_seconds,console.log(this.$store.state.resultStore.voteRound))),this.$store.state.resultStore.voteRound>this.$store.state.resultStore.cnt&&this.stopTimer()}),1e3)},stopTimer(){clearInterval(this.auto_reload_func)}},destroyed(){clearInterval(this.auto_reload_func)}},i=r,l=s(1001),n=(0,l.Z)(i,o,a,!1,null,null,null),d=n.exports},88591:function(t,e,s){s.r(e),s.d(e,{default:function(){return _}});var o=function(){var t=this,e=t._self._c;return e("div",{staticClass:"bodyColorVote"},[e("div",{staticClass:"bodyColorVote11"},[e("div",{staticClass:"dummyMarginColorVote1"}),e("div",{staticClass:"gridColorVote1"},[e("div",{staticClass:"sidelabelColorVote"},[e("time-stamp")],1),e("div",{staticClass:"titleColorVote"},[e("label",{staticClass:"labelColorVote",attrs:{for:"nameColorVote",id:"nameColorVote"}},[t._v(t._s(t.sub_name))]),e("label",{staticClass:"labelColorVote",attrs:{for:"colorVoteTitle"}},[t._v(" 과(와) 가장 어울리는 색을 선택하세요.")])]),e("div",{staticClass:"sidelabelColorVote"},[t._v(t._s(t.vote_round)+"/"+t._s(t.cnt))])]),e("color-vote",{attrs:{loadVoteData:!1},on:{startTime:t.timeStampOn}})],1),t.show_loadingimg?e("loadingImg",{attrs:{loadingText:t.loadingText}}):t._e()],1)},a=[],r=s(56265),i=s.n(r),l=s(73699),n=s(13494),d=s(39585),u=s(93495),m=s.n(u),h={components:{ColorVote:l["default"],TimeStamp:n.Z,loadingImg:d.Z},data(){return{selectedLst:[],show_loadingimg:!1,loadingText:"결과를 불러오는 중 입니다",startTimeStamp:!1}},computed:{cnt(){return this.$store.state.resultStore.cnt},vote_round(){return this.$store.state.resultStore.voteRound},sub_name(){return this.vote_round>this.cnt?this.$store.state.resultStore.data[this.cnt-1].name:(console.log(this.vote_round),console.log(this.$store.state.resultStore),this.$store.state.resultStore.data[this.vote_round-1].name?this.$store.state.resultStore.data[this.vote_round-1].name:"nothing")}},watch:{vote_round(t){t>this.cnt&&this.loading3sec()}},beforeCreate(){console.log(sessionStorage.getItem("roomId")),i().post(this.$store.state.baseurl+"room/getresult",{roomid:sessionStorage.getItem("roomId")}).then((t=>{console.log(t),this.$store.state.resultStore.aloneResult=t.data,this.$store.state.resultStore.data=t.data.data,this.$store.state.resultStore.cnt=t.data.data.length,this.$store.state.selectedColorLst=t.data.data[0].colors,this.$store.state.aloneImageUrlLst=t.data.data[0].urls})),setTimeout((()=>{console.log("TeamVoting Page Created")}),500)},mounted(){this.mySessionId=this.mySessionId+"vote",sessionStorage.getItem("hostId")==sessionStorage.getItem("memberId")&&(this.ishost=!0),console.log(this.mySessionId)},beforeRouteLeave(t,e,s){sessionStorage.setItem("hostId",-1),setTimeout((()=>{s()}),100)},methods:{timeStampOn(){this.startTimeStamp=!0},loading3sec(){this.vote_Round=this.cnt,this.onLoadingImg(),this.saveTeamVoteResult(),console.log("로딩창 켬"),console.log(this.show_loadingimg)},onLoadingImg(){this.show_loadingimg=!0},offLoadingImg(){this.show_loadingimg=!1},saveTeamVoteResult(){console.log(this.$store.state.resultStore.voteContent),i().post(this.$store.state.baseurl+"room/vote",{roomid:sessionStorage.getItem("roomId"),voterid:sessionStorage.getItem("memberId"),content:this.$store.state.resultStore.voteContent}).then((t=>{console.log(t.data),"fail"==t.data.message?(console.log(this.$store.state.resultStore.voteContent),m()("투표 결과","투표 결과를 저장하는데 실패하였습니다.","error")):this.startSumVoteResult()}))},startSumVoteResult(){i().put(this.$store.state.baseurl+"room/votesum",{roomid:sessionStorage.getItem("roomId")}).then((t=>{"success"==t.data.message?console.log("투표결과 합산 완료!!!!!!!!!!!!!!!!!!!!!!!!!!"):m()("투표 결과","투표 결과를 합산하는데 실패하였습니다.","error"),this.move2Result()}))},move2Result(){setTimeout((()=>{this.offLoadingImg(),console.log("로딩창 끔"),this.$router.push("/nameresult")}),4e3)}}},c=h,g=s(1001),v=(0,g.Z)(c,o,a,!1,null,"09dbfab2",null),_=v.exports}}]);
//# sourceMappingURL=258.c1720a9e.js.map