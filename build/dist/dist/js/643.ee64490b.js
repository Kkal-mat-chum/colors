"use strict";(self["webpackChunkcolors"]=self["webpackChunkcolors"]||[]).push([[643],{35643:function(t,s,i){i.r(s),i.d(s,{default:function(){return g}});var e=function(){var t=this,s=t._self._c;return s("div",{staticClass:"logInPage"},[s("img",{staticClass:"mainPicture",staticStyle:{cursor:"pointer"},attrs:{src:i(31242),alt:"깔맞춤"},on:{click:t.goHome}}),s("div",{staticClass:"logInInfo"},[s("div",{staticClass:"logInBox"},[s("div",{directives:[{name:"show",rawName:"v-show",value:t.loginAlram,expression:"loginAlram"}],staticClass:"logInAlarm"},[t._v("아이디 또는 비밀번호를 확인하세요.")]),t._m(0),s("div",{staticClass:"logInLabel"},[t._v("아이디")]),t._m(1),s("div",{staticClass:"logInLabelPw"},[t._v("비밀번호")]),s("div",{staticClass:"logInInput"},[s("input",{staticClass:"logInPwInput",attrs:{type:"password",id:"logInpageInput",placeholder:"비밀번호를 입력하세요."},on:{keyup:function(s){return!s.type.indexOf("key")&&t._k(s.keyCode,"enter",13,s.key,"Enter")?null:t.loginMember()}}})]),s("customButton",{staticClass:"idPwSearch",attrs:{btnText:"로그인"},on:{click:function(s){return t.loginMember()}}}),s("customButton",{staticClass:"idPwSearch",attrs:{btnText:"아이디/비밀번호 찾기"},on:{click:function(s){t.findIdpwShowModal=!0}}}),s("customButton",{staticClass:"signUp",attrs:{btnText:"회원가입"},on:{click:function(s){return t.gotosignup()}}}),s("custom-modal",{directives:[{name:"show",rawName:"v-show",value:t.findIdpwShowModal,expression:"findIdpwShowModal"}],staticClass:"findIdpwModal",attrs:{id:"findIdpwModal"},on:{"close-modal":function(s){t.findIdpwShowModal=!1}}},[s("content",[s("find-idpw")],1)])],1)])])},n=[function(){var t=this,s=t._self._c;return s("div",{staticClass:"title"},[s("h2",[t._v("로그인")]),s("hr")])},function(){var t=this,s=t._self._c;return s("div",{staticClass:"logInInput"},[s("input",{staticClass:"logInIdInput",attrs:{type:"text",placeholder:"아이디를 입력하세요.",id:"logInInput"}})])}],a=function(){var t=this,s=t._self._c;return s("div",{staticClass:"idPwFindPage"},[s("div",{staticClass:"bodyIdpwFind"},[s("div",{staticClass:"dummyMarginIdpwFind3"}),s("div",{staticClass:"idFindInIdpwfind"},[s("div",{staticClass:"idFindInIdpwfind1"},[t._m(0),t.idFindWarningShow?s("label",{attrs:{for:"idFindstate",id:"labelWarningInIdpwFind"}},[t._v("이름와 이메일을 확인해주세요.")]):t._e()]),s("input",{staticClass:"inPwFindInput",attrs:{type:"text",id:"idFindNameInputInIdpwFind",placeholder:"이름을 입력해주세요."}}),s("input",{staticClass:"inPwFindInput",attrs:{type:"text",id:"idFindEmailInputInIdpwFind",placeholder:"이메일을 입력해주세요."}}),s("customButton",{staticClass:"idFindInIdpwFindBtn",attrs:{id:"idFindInIdpwFindBtn",btnText:"확 인"},on:{click:t.findID}},[t._v("아이디 찾기 버튼")]),s("div",{staticClass:"height"})],1),s("div",{staticClass:"dummyMarginIdpwFind5"}),s("hr",{staticClass:"hrstyleInIdpwfind2"}),s("div",{staticClass:"dummyMarginIdpwFind5"}),s("div",{staticClass:"pwFindInIdpwfind"},[s("div",{staticClass:"idFindInIdpwfind1"},[t._m(1),t.pwFindWarningShow?s("label",{attrs:{for:"idFindstate",id:"labelWarningInIdpwFind"}},[t._v("아이디와 이메일을 확인해주세요.")]):t._e()]),s("input",{staticClass:"inPwFindInput",attrs:{type:"text",id:"pwFindIdInputInIdpwFind",placeholder:"아이디를 입력해주세요."}}),s("input",{staticClass:"inPwFindInput",attrs:{type:"text",id:"pwFindEmailInputInIdpwFind",placeholder:"이메일을 입력해주세요."}}),s("customButton",{staticClass:"idFindInIdpwFindBtn",attrs:{id:"pwFindInIdpwFindBtn",btnText:"임시 비밀번호 보내기"},on:{click:t.findPassword}},[t._v("임시비번보내기 버튼")]),s("div",{staticClass:"height"})],1),s("div",{staticClass:"dummyMarginIdpwFind4"})]),s("div",{staticClass:"dummyMarginIdpwFind2"}),t.idResultShow?s("label",{staticClass:"labelInIdpwFind",attrs:{for:"idFindstate"}},[t._v("아이디는 "),s("div",{attrs:{id:"showID"}},[t._v(t._s(t.userid))]),t._v(" 입니다.")]):t._e(),t.pwResultShow?s("label",{staticClass:"labelInIdpwFind",attrs:{for:"pwFindstate"}},[t._v("임시 비밀번호를 메일로 전송했습니다.")]):t._e()])},d=[function(){var t=this,s=t._self._c;return s("div",{staticClass:"title"},[s("h2",[t._v("아이디 찾기")]),s("hr")])},function(){var t=this,s=t._self._c;return s("div",{staticClass:"title"},[s("h2",[t._v("비밀번호 찾기")]),s("hr")])}],o=i(56265),l=i.n(o),r={data(){return{userid:"userid",idFindWarningShow:!1,pwFindWarningShow:!1,idResultShow:!1,pwResultShow:!1}},methods:{findID(){let t=document.getElementById("idFindNameInputInIdpwFind").value,s=document.getElementById("idFindEmailInputInIdpwFind").value;l().post(this.$store.state.baseurl+"member/findid",{name:t,email:s}).then((t=>{"success"==t.data.message?(this.idResultShow=!0,this.idFindWarningShow=!1,this.pwResultShow=!1,this.userid=t.data.userid):(this.idFindWarningShow=!0,this.idResultShow=!1,console.log("이름과 이메일을 다시 확인해주세요."))}))},findPassword(){let t=document.getElementById("pwFindIdInputInIdpwFind").value,s=document.getElementById("pwFindEmailInputInIdpwFind").value;l().post(this.$store.state.baseurl+"member/findpwd",{userid:t,email:s}).then((t=>{"success"==t.data.message?(this.pwResultShow=!0,this.pwFindWarningShow=!1,console.log("비밀번호를 메일로 전송"),this.idResultShow=!1):(this.pwFindWarningShow=!0,this.pwResultShow=!1,console.log("아이디와 이메일을 다시 확인해주세요."))}))}}},u=r,c=i(1001),I=(0,c.Z)(u,a,d,!1,null,"2d1e6e5f",null),p=I.exports,m={components:{FindIdpw:p},data(){return{findIdpwShowModal:!1,loginAlram:!1}},methods:{goHome(){this.$router.push("/")},gotosignup(){this.$router.push("/signup")},loginMember(){let t=document.getElementById("logInInput").value,s=document.getElementById("logInpageInput").value;l().post(this.$store.state.baseurl+"auth/login",{userId:t,password:s}).then((s=>{"fail"==s.data.message?(this.loginWarningShow=!0,this.loginAlram=!0):"success"==s.data.message&&(console.log(s.data.member),sessionStorage.setItem("access-token",s.data["access-token"]),sessionStorage.setItem("memberData",s.data.member),sessionStorage.setItem("userName",s.data.member.name),sessionStorage.setItem("memberId",s.data.member.id),sessionStorage.setItem("userId",s.data.member.userId),sessionStorage.setItem("userNick",s.data.member.nickname),sessionStorage.setItem("isLogin",!0),sessionStorage.setItem("auth",!1),this.$store.state.memberStore.isLogin=!0,console.log(sessionStorage.getItem("isLogin")),"admin"==s.data.member.userId&&(sessionStorage.setItem("auth",!0),console.log(s.data.member.userId)),l().get(this.$store.state.baseurl+"member/"+t).then((t=>{"success"==t.data.message&&(sessionStorage.setItem("memberData",JSON.stringify(t.data)),this.$router.push("/enterPage"))})))}))}}},w=m,h=(0,c.Z)(w,e,n,!1,null,"0b0b90fa",null),g=h.exports}}]);
//# sourceMappingURL=643.ee64490b.js.map