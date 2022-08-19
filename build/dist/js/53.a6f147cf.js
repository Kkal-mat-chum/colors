"use strict";(self["webpackChunkcolors"]=self["webpackChunkcolors"]||[]).push([[53],{97178:function(e,t,s){s.r(t),s.d(t,{default:function(){return J}});var o=function(){var e=this,t=e._self._c;return t("div",{staticClass:"TeamMeeting"},[t("div",{staticClass:"contents"},[t("div",{staticClass:"camera"},[t("div",{staticClass:"col-md-6",attrs:{id:"main-video"}},[t("userVideo",{staticClass:"webcam",attrs:{id:"webcam","stream-manager":e.mainStreamManager},on:{changeStreamTrack:e.changeStream}})],1),t("div",{staticClass:"name"},[e._v(e._s(e.myUserName))]),t("div",{staticClass:"buttons"},[t("customButton",{staticClass:"mute",class:{muteActive:e.publishAudio},attrs:{btnText:"음소거"},on:{click:e.muteAudio}}),t("customButton",{staticClass:"videostop",class:{muteActive:e.publishVideo},attrs:{btnText:"비디오 중지"},on:{click:e.muteVideo}})],1),t("div",{staticClass:"anotherPerson"},e._l(e.subscribers,(function(s){return t("div",{key:s.stream.connection.connectionId,staticClass:"p_sub"},[t("UserVideo_sub",{key:s.stream.connection.connectionId,staticClass:"webcam_sub",attrs:{"stream-manager":s},nativeOn:{click:function(t){return e.updateMainVideoStreamManager(s)}}})],1)})),0)]),t("div",{staticClass:"rightPannelArea"},[e.isChatPanel?t("div",{staticClass:"chatPanelArea"},[t("Chatpanel",{on:{sendMessage:e.sendMessage}})],1):e._e(),e.isChatPanel?e._e():t("div",{staticClass:"rightSidebar"},[e._m(0),t("colorpallete",{staticClass:"pallete"}),t("div",{staticClass:"selectColor"},[t("colorchoice",{on:{changeColor:e.changeColor}})],1),t("customButton",{ref:"colorchoice",staticClass:"selectColorbtn",attrs:{btnText:"색상 팔레트에 담기"},on:{click:e.showOneSelectedColor}}),t("div",{staticClass:"title"},[t("h3",[e._v(e._s(e.roomHeaderTitle))]),t("hr")]),t("h2",{staticClass:"code"},[e._v(e._s(e.roomHeaderData))]),t("customButton",{staticClass:"btn",attrs:{btnText:"채팅"},on:{click:e.toggleChatPanel}}),t("customButton",{staticClass:"btn",class:{muteActive:!e.ready},attrs:{btnText:"투표하기"},on:{click:e.sendVote}}),e.ishostCopy&e.readyAll?t("customButton",{staticClass:"btn",attrs:{btnText:"투표 시작"},on:{click:e.startSaving}}):e._e(),e.ishost?t("customButton",{staticClass:"btn",attrs:{btnText:"시작"},on:{click:e.start}}):e._e(),e.ishost?e._e():t("customButton",{staticClass:"btn",attrs:{btnText:"종료"},on:{click:e.leaveMeeting}}),t("custom-modal",{directives:[{name:"show",rawName:"v-show",value:e.showstartModal,expression:"showstartModal"}],staticClass:"startInfoModal",attrs:{id:"startInfoModal",titleText:"호스트 공지사항"},on:{"close-modal":function(t){e.showstartModal=!1}}},[t("content",[t("div",{staticClass:"content"},[t("p",{staticClass:"notice"},[e._v("참여자들의 입장이 완료되면 반드시 "),t("strong",{staticStyle:{"font-size":"24px"},attrs:{id:"notice"}},[e._v("시작")]),e._v(" 버튼을 눌러주세요.")]),t("p",{staticClass:"notice"},[e._v("시작을 눌러야 미팅 중 다른 참여자들의 입장을 막을 수 있습니다.")])]),t("customButton",{staticClass:"btn",attrs:{btnText:"확인"},on:{click:function(t){e.showstartModal=!1}}})],1)])],1)])]),e.show_loadingimg?t("loadingImg",{attrs:{loadingText:e.loadingText}}):e._e()],1)},i=[function(){var e=this,t=e._self._c;return t("div",{staticClass:"title"},[t("h3",[e._v("나만의 색상 팔레트")]),t("hr")])}],a=(s(82801),s(48675),s(3462),s(37380),s(1118),s(56265)),n=s.n(a),r=s(63822),l=s(9801),c=s(92269),h=s.n(c),d=s(24840),m=s.n(d),g=s(66970),u=s(23334),p=s(14636),v=s(18496),b=function(){var e=this,t=e._self._c;return e.streamManager?t("div",[t("ov-video",{attrs:{"stream-manager":e.streamManager}}),t("div",{staticClass:"name"},[e._v(e._s(e.clientData))])],1):e._e()},C=[],S=function(){var e=this,t=e._self._c;return t("video",{attrs:{autoplay:""}})},f=[],y={name:"OvVideo",props:{streamManager:Object},mounted(){this.streamManager.addVideoElement(this.$el)}},I=y,w=s(1001),_=(0,w.Z)(I,S,f,!1,null,"36c39b90",null),O=_.exports,k={name:"UserVideo",components:{OvVideo:O},props:{streamManager:Object},computed:{clientData(){const{clientData:e}=this.getConnectionData();return e}},methods:{getConnectionData(){const{connection:e}=this.streamManager.stream;return JSON.parse(e.data)}}},T=k,$=(0,w.Z)(T,b,C,!1,null,"bc1f144c",null),V=$.exports,P=function(){var e=this,t=e._self._c;return t("div",{staticClass:"chat-panel"},[t("div",{staticClass:"chat-box"},[t("div",{staticClass:"header"},[t("span",{staticClass:"title"},[e._v(" 채팅 ")]),t("button",{staticClass:"btn close-btn",on:{click:e.toggleChatPanel}},[t("i",{staticClass:"fas fa-times"})])]),t("div",{attrs:{id:"chat-area"}},e._l(e.messages,(function(s,o){return t("div",{key:o,staticClass:"message"},[t("div",{staticClass:"message-title"},[t("span",{staticClass:"message-header"},[e._v(e._s(s.sender)+" :")])]),t("div",{staticClass:"messgeText"},[e._v(" "+e._s(s.message)+" ")])])})),0),t("div",{staticClass:"footer"},[t("div",{staticClass:"messageInputBox"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.message,expression:"message"}],staticClass:"text-box",domProps:{value:e.message},on:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.clickSendMessage.apply(null,arguments)},input:function(t){t.target.composing||(e.message=t.target.value)}}})]),t("div",{staticClass:"messageSendButton"},[t("button",{staticClass:"send-btn",on:{click:e.clickSendMessage}},[t("i",{staticClass:"fas fa-paper-plane airPlaneIcon"})])])])])])},x=[],M={name:"ChatPanel",data(){return{message:"",chatHeight:"100vh"}},watch:{messages(){setTimeout((()=>{var e=document.getElementById("chatpanelArea");e.scrollTo({top:e.scrollHeight-e.clientHeight,behavior:"smooth"})}),50)}},computed:{messages(){return this.$store.getters.messages}},methods:{...(0,r.nv)(["toggleChatPanel"]),clickSendMessage(){this.message.trim()&&(this.$emit("sendMessage",this.message),this.message="")}}},A=M,E=(0,w.Z)(A,P,x,!1,null,"77a7c251",null),N=E.exports,D=s(39585),j=s(93495),L=s.n(j);n().defaults.headers.post["Content-Type"]="application/json";const U="https://"+location.hostname+":40001",H="i7b208";var B={name:"TeamMeeting",components:{colorpallete:u.Z,colorchoice:p.Z,UserVideo:v.Z,UserVideo_sub:V,Chatpanel:N,loadingImg:D.Z},mixins:[g.Z],computed:{rgba(){return{r:this.r,g:this.g,b:this.b,a:this.a}},hsv(){return{h:this.h,s:this.s,v:this.v}},isChatPanel(){return this.$store.getters.isChatPanel},publishAudio(){return this.$store.getters.getPublishAudio},publishVideo(){return this.$store.getters.getPublishVideo}},data(){return{OV:void 0,session:!0,mainStreamManager:void 0,publisher:void 0,subscribers:[],ishost:!1,mySessionId:sessionStorage.getItem("roomCode"),myUserName:JSON.parse(sessionStorage.getItem("memberData")).data.nickname,modelRgba:"",modelHex:"",r:0,g:0,b:0,a:1,h:0,s:0,v:0,count_pallete:0,selectedColorLst:["#000000","#000000","#000000","#000000","#000000","#000000"],awsid:"ap-northeast-2:ec08827e-a81a-4cad-813c-fe0d18e8d3d6",memberData:JSON.parse(sessionStorage.getItem("memberData")).data,roomHeaderTitle:"",roomHeaderData:"",ready:!0,readyAll:!1,readys:{},numberOFparti:this.participantUpdate(this.mySessionId),ishostCopy:!1,isTrackChanged:!1,isSave:!0,savings:{},show_loadingimg:!1,loadingText:"투표를 불러오는 중 입니다"}},created(){Object.assign(this,this.setColorValue(this.color)),this.setText(),"group"==this.$store.state.meetingStore.roomType?(this.roomHeaderTitle="미팅 코드",this.roomHeaderData=sessionStorage.getItem("roomCode"),this.myUserName=this.memberData.name):"random"==this.$store.state.meetingStore.roomType&&(this.roomHeaderTitle="미팅 주제",this.roomHeaderData=sessionStorage.getItem("toppicTitle"),this.myUserName=this.memberData.nickname)},beforeMount(){this.publishAudio&&this.$store.commit("changePublishAudio"),this.publishVideo&&this.$store.commit("changePublishVideo"),this.$store.commit("CLEAN_PALLETE"),this.joinSession()},mounted(){this.$store.state.resultStore.voteRound=1,console.log(sessionStorage.getItem("roomCode")),console.log(sessionStorage.getItem("roomId")),console.log(this.subscribers),sessionStorage.getItem("hostId")==sessionStorage.getItem("memberId")&&(this.ishost=!0,L()("호스트 공지사항",'참여자 입장이 완료되면 반드시 "시작" 버튼을 눌려주세요. \n 미팅 진행 중 다른 참여자들의 입장을 막을 수 있습니다.',"info"))},beforeRouteLeave(e,t,s){this.leaveSession(),sessionStorage.setItem("hostId",-1),setTimeout((()=>{s().then((()=>this.$router.go()))}),100)},methods:{...(0,r.nv)(["toggleChatPanel"]),onLoadingImg(){this.show_loadingimg=!0},offLoadingImg(){this.show_loadingimg=!1},leaveMeeting(){this.leaveSession(),this.$router.push("/enterPage")},start(){this.ishost=!1,this.ishostCopy=!0;let e=JSON.parse(sessionStorage.getItem("memberData")),t=e.data.id,s=sessionStorage.getItem("roomId");console.log(s),n().put(this.$store.state.baseurl+"room/status",{roomid:s,hostid:t}).then((e=>{console.log(e)}))},showOneSelectedColor(){if(this.count_pallete<8){this.modelHex=this.rgb2hex(this.rgba,!0),console.log(this.modelHex);var e=0;console.log(this.$store.state.selectedColorLst);for(var t=0;t<this.count_pallete;t++)this.$store.state.selectedColorLst[t]==this.modelHex&&(L()("색상 담기","중복된 색이 있습니다.","error"),e=1);if(1==e)return;this.$store.commit("NEW_COLOR",{color:this.modelHex}),this.selectedColorLst=this.$store.state.selectedColorLst,this.selectedColorLst.splice(this.count_pallete,1,this.$store.state.storeselectedColor.color),this.$store.state.selectedColorLst=this.selectedColorLst;var s=this.modelHex.substr(1);console.log(s);var o=this.awsid,i=sessionStorage.getItem("userId"),a=this.count_pallete;h()(document.getElementById("webcam")).then((function(e){var t=e.toDataURL("image/jpeg");console.log(t);var n=t.split(","),r=n[0].match(/:(.*?);/)[1],l=atob(n[1]),c=l.length,h=new Uint8Array(c);while(c--)h[c]=l.charCodeAt(c);var d=new File([h],s,{type:r});console.log(d),m().config.update({region:"ap-northeast-2",credentials:new(m().CognitoIdentityCredentials)({IdentityPoolId:o})});var g=new(m().S3)({apiVersion:"2012-10-17",params:{Bucket:"ssafy7color"}}),u=new Date,p=u.getFullYear()+""+(u.getMonth()+1)+u.getDate(),v=sessionStorage.getItem("roomCode");let b=p+"/"+i+"/"+v+"/"+s+a+".jpg";g.upload({Key:b,Body:d,ACL:"public-read"},((e,t)=>{e&&console.log(e),console.log("Successfully uploaded photo."),console.log(t)}))})),this.count_pallete++}else L()("색상 담기","컬러 팔레트가 꽉찼습니다.","error");setTimeout((()=>{}),500)},gosaving(){this.$store.state.resultStore.cnt=this.numberOFparti;var e=this.awsid,t=sessionStorage.getItem("userId");m().config.update({region:"ap-northeast-2",credentials:new(m().CognitoIdentityCredentials)({IdentityPoolId:e})});var s=new(m().S3)({apiVersion:"2012-10-17",params:{Bucket:"ssafy7color"}}),o=new Date,i=o.getFullYear()+""+(o.getMonth()+1)+o.getDate(),a=sessionStorage.getItem("roomCode");let r=i+"/"+t+"/"+a+"/";console.log(r),s.listObjects({Delimiter:"/",Prefix:r},((e,t)=>{if(e)return L()("투표하기","There was an error : "+e.message,"error");{var s=[],o={url:"",code:""};this.lists=t.Contents,this.lists.forEach((e=>{var t="https://ssafy7color.s3.ap-northeast-2.amazonaws.com/"+e.Key,i="#"+t.slice(t.length-11,t.length-5);o={url:t,code:i},s.push(o)})),console.log(s);let e=sessionStorage.getItem("roomId"),i=JSON.parse(sessionStorage.getItem("memberData")),a=i.data.id;const r={roomid:e,userid:a,colorset:s};console.log(r),n().post(this.$store.state.baseurl+"room/result",r).then((e=>{console.log(e),this.doneSaving()}))}}))},goVote(){setTimeout((()=>{this.offLoadingImg(),"group"==this.$store.state.meetingStore.roomType?this.$router.push("/teamVoting"):"random"==this.$store.state.meetingStore.roomType&&this.$router.push("/randomVoting")}),4e3)},dataURLtoFile(e,t){var s=e.split(","),o=s[0].match(/:(.*?);/)[1],i=atob(s[1]),a=i.length,n=new Uint8Array(a);while(a--)n[a]=i.charCodeAt(a);return new File([n],t,{type:o})},setText(){this.modelHex=this.rgb2hex(this.rgba,!0),this.modelRgba=`${this.r}, ${this.g}, ${this.b}, ${this.a}`},changeColor(e){const{r:t,g:s,b:o,a:i,h:a,s:n,v:r}=this.setColorValue(e.rgba);Object.assign(this,{r:t,g:s,b:o,a:i,h:a,s:n,v:r}),this.modelHex=e.hex,this.$store.state.r=this.r,this.$store.state.g=this.g,this.$store.state.b=this.b},sendMessage(e){var t={content:e,secretName:this.myUserName};this.session.signal({type:"chat",data:JSON.stringify(t),to:[]})},sendReconnect(e){this.session.signal({type:"reconnect",to:[e]})},sendVote(){var e=this.ready;this.session.signal({type:"vote",data:JSON.stringify(e),to:[]}),this.ready=!e},doneSaving(){var e=this.isSave;this.session.signal({type:"saving",data:JSON.stringify(e),to:[]}),this.isSave=!e},startVote(){this.session.signal({type:"goVote",to:[]})},startSaving(){this.session.signal({type:"goSaving",to:[]})},muteAudio(){this.publisher.publishAudio(this.publishAudio),console.log(this.publishAudio),this.$store.commit("changePublishAudio")},muteVideo(){this.publisher.publishVideo(this.publishVideo),this.$store.commit("changePublishVideo")},changeStream(){if(this.isTrackChanged)console.log("Already track has been changed");else{const t=document.getElementById("overlay"),s=t.captureStream();var e=s.getVideoTracks()[0];this.publisher.replaceTrack(e).then((()=>{console.log("New track has been published"),this.isTrackChanged=!0})).catch((e=>console.error("Error replacing track",e)))}},joinSession(){this.OV=new l.Dn,this.session=this.OV.initSession(),this.session.on("streamCreated",(({stream:e})=>{const t=this.session.subscribe(e);this.subscribers.push(t),setTimeout((()=>{this.participantUpdate(this.mySessionId)}),100)})),this.session.on("streamDestroyed",(({stream:e})=>{const t=this.subscribers.indexOf(e.streamManager,0);t>=0&&this.subscribers.splice(t,1)})),this.session.on("signal:chat",(e=>{let t=JSON.parse(e.data),s=new Object;s.message=t.content,s.sender=e.from.data.slice(15,-2),this.$store.commit("SET_MESSAGES",s)})),this.session.on("signal:vote",(e=>{var t=JSON.parse(e.data),s=e.from.connectionId;this.readys[s]=t;var o=Object.values(this.readys).filter((e=>1==e)).length;o==this.numberOFparti?(console.log("Every People Ready to Vote"),console.log("asfdjjsjfslkjflkjsflkjalkjslkjasfd"),this.ishostCopy&&(this.readyAll=!0)):this.readyAll=!1})),this.session.on("signal:saving",(e=>{var t=JSON.parse(e.data),s=e.from.connectionId;console.log(e),this.savings[s]=t;var o=Object.values(this.savings).filter((e=>1==e)).length;o==this.numberOFparti&&(console.log("Every People Ready to saving"),console.log("asfdjjsjfslkjflkjsflkjalkjslkjasfd"),this.ishostCopy&&setTimeout((()=>{this.startVote()}),1e3))})),this.session.on("signal:goVote",(()=>{console.log("Start Vote"),this.goVote()})),this.session.on("signal:goSaving",(()=>{this.onLoadingImg(),console.log("Start Saving"),this.gosaving()})),this.session.on("signal:reconnect",(()=>{console.log(this.publisher),console.log(this.mainStreamManager),this.publisher.stream.reconnect()})),this.session.on("reconnecting",(()=>console.warn("Oops! Trying to reconnect to the session"))),this.session.on("reconnected",(()=>console.log("Hurray! You successfully reconnected to the session"))),this.session.on("sessionDisconnected",(e=>{"networkDisconnect"===e.reason&&console.warn("Dang-it... You lost your connection to the session")})),this.session.on("exception",(e=>{if("ICE_CONNECTION_FAILED"===e.name){var t=e.origin;console.warn("Stream "+t.streamId+" broke!"),console.warn("Reconnection process automatically started")}"NO_STREAM_PLAYING_EVENT"==e.name&&this.sendReconnect(e.origin.stream.connection.connectionId),console.warn(e)})),this.getToken(this.mySessionId).then((e=>{this.session.connect(e,{clientData:this.myUserName}).then((()=>{let e=this.OV.initPublisher(void 0,{audioSource:void 0,videoSource:void 0,publishAudio:!0,publishVideo:!0,resolution:"600x315",frameRate:60,insertMode:"APPEND",mirror:!1});this.mainStreamManager=e,this.publisher=e,this.session.publish(this.publisher)})).catch((e=>{console.log("There was an error connecting to the session:",e.code,e.message)})),console.log(this.getSession(this.mySessionId))})),window.addEventListener("beforeunload",this.leaveSession)},getSession(e){return n().get(`${U}/openvidu/api/sessions/${e}`,{auth:{username:"OPENVIDUAPP",password:H}}).then((e=>{if(this.numberOFparti=e.data.connections.numberOfElements,console.log(e),console.log(e.data.connections.numberOfElements),console.log("값확인이전"),e.data.connections.numberOfElements>6){console.log("값확인");let e={roomid:sessionStorage.getItem("roomId")};console.log(e),this.leaveSession(),this.$store.dispatch("pullRoom",e)}})),this.numberOFparti},participantUpdate(e){return n().get(`${U}/openvidu/api/sessions/${e}`,{auth:{username:"OPENVIDUAPP",password:H}}).then((e=>{this.numberOFparti=e.data.connections.numberOfElements,console.log(e),console.log(e.data.connections.numberOfElements),console.log("값확인이전")})),this.numberOFparti},leaveSession(){this.session&&(this.participantUpdate(this.mySessionId),6==this.numberOFparti?this.$store.dispatch("leaveSession",this.mySessionId):1==this.numberOFparti&&this.start(),this.session.disconnect(),this.session=void 0,this.mainStreamManager=void 0,this.publisher=void 0,this.subscribers=[],this.OV=void 0,this.$store.commit("SET_CLEARMESSAGES")),window.removeEventListener("beforeunload",this.leaveSession)},updateMainVideoStreamManager(e){this.mainStreamManager!==e&&(this.mainStreamManager=e)},getToken(e){return this.createSession(e).then((e=>this.createToken(e)))},createSession(e){return new Promise(((t,s)=>{n().post(`${U}/openvidu/api/sessions`,JSON.stringify({customSessionId:e}),{auth:{username:"OPENVIDUAPP",password:H}}).then((e=>e.data)).then((e=>t(e.id))).catch((o=>{409===o.response.status?t(e):(console.warn(`No connection to OpenVidu Server. This may be a certificate error at ${U}`),window.confirm(`No connection to OpenVidu Server. This may be a certificate error at ${U}\n\nClick OK to navigate and accept it. If no certificate warning is shown, then check that your OpenVidu Server is up and running at "${U}"`)&&location.assign(`${U}/accept-certificate`),s(o.response))}))}))},createToken(e){return new Promise(((t,s)=>{n().post(`${U}/openvidu/api/sessions/${e}/connection`,{},{auth:{username:"OPENVIDUAPP",password:H}}).then((e=>e.data)).then((e=>t(e.token))).catch((e=>s(e.response)))}))},exit(){this.$router.push("/enterPage")}}},F=B,R=(0,w.Z)(F,o,i,!1,null,"46c58410",null),J=R.exports}}]);
//# sourceMappingURL=53.a6f147cf.js.map