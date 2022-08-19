"use strict";(self["webpackChunkcolors"]=self["webpackChunkcolors"]||[]).push([[790],{27790:function(t,e,a){a.r(e),a.d(e,{default:function(){return v}});var s=function(){var t=this,e=t._self._c;return e("div",{staticClass:"signUpPage"},[e("div",{staticClass:"signUp1"},[e("div",{staticClass:"signUpWord"},[t._m(0),e("div",{staticClass:"signUpWarning",attrs:{id:"signUpWarning"}},[t._v(t._s(t.state_message))])]),e("div",{attrs:{id:"userInfo"}},[e("div",{staticClass:"textBox"},[e("div",{staticClass:"labelBoxs"},[e("label",{staticClass:"userlabel",class:{on:t.idHasError},attrs:{for:"idLabel"}},[t._v("아이디")]),e("br"),e("label",{staticClass:"userlabel",class:{onPw:t.pwHasError},attrs:{for:"pwLabel"}},[t._v("비밀번호")]),e("br"),e("label",{staticClass:"userlabel",attrs:{for:"pwcheckLabel"}},[t._v("비밀번호 확인")]),e("br"),e("label",{staticClass:"userlabel",attrs:{for:"nameLabel"}},[t._v("이름")]),e("br"),e("label",{staticClass:"userlabel",attrs:{for:"nickLabel"}},[t._v("닉네임")]),e("br"),e("label",{staticClass:"userlabel",attrs:{for:"emailLabel"}},[t._v("이메일")]),e("br"),e("label",{staticClass:"userlabel",attrs:{for:"emailcheckLabel"}},[t._v("이메일 확인")])]),e("div",{staticClass:"inputBoxs"},[e("input",{directives:[{name:"model",rawName:"v-model",value:t.validateId,expression:"validateId"}],staticClass:"userInput",class:{active:t.idHasError},attrs:{type:"text",id:"idLabel",placeholder:"영문 숫자 포함 6자리 이상"},domProps:{value:t.validateId},on:{input:function(e){e.target.composing||(t.validateId=e.target.value)}}}),e("br"),e("input",{directives:[{name:"model",rawName:"v-model",value:t.validatePw,expression:"validatePw"}],staticClass:"logInPwInput",class:{activePw:t.pwHasError},attrs:{type:"password",id:"pwLabel",placeholder:"영문 숫자 포함 8자리 이상"},domProps:{value:t.validatePw},on:{input:function(e){e.target.composing||(t.validatePw=e.target.value)}}}),e("br"),e("input",{staticClass:"logInPwInput",attrs:{type:"password",id:"pwcheckLabel",placeholder:"다시 입력해주세요."}}),e("br"),e("input",{staticClass:"userInput",attrs:{type:"text",id:"nameLabel",placeholder:"이름을 입력해주세요."}}),e("br"),e("input",{staticClass:"userInput",attrs:{type:"text",id:"nickLabel",placeholder:"닉네임을 입력해주세요."}}),e("br"),e("input",{staticClass:"userInput",attrs:{type:"text",id:"emailLabel",placeholder:"이메일을 입력해주세요"}}),e("br"),e("input",{directives:[{name:"model",rawName:"v-model",value:t.emailCode,expression:"emailCode"}],staticClass:"userInput",attrs:{type:"text",id:"emailcheckLabel",placeholder:"전송된 인증 번호를 입력하세요."},domProps:{value:t.emailCode},on:{input:function(e){e.target.composing||(t.emailCode=e.target.value)}}})]),e("div",{staticClass:"inputCheckBoxs"},[e("customButton",{staticClass:"signUpIDCheckBtn",attrs:{id:"signUpIDCheckBtn",btnText:"중복 확인"},on:{click:t.checkDuplicateID}},[t._v("아이디 중복확인")]),e("div",{staticClass:"dummyMarginSignUp1"}),e("customButton",{staticClass:"signUpnickCheckBtn",attrs:{id:"signUpnickCheckBtn",btnText:"중복 확인"},on:{click:t.checkDuplicateNickname}},[t._v("testButton")]),e("customButton",{staticClass:"signUpEmailCheckBtn",attrs:{id:"signUpEmailCheckBtn",btnText:"이메일 인증"},on:{click:t.checkEmail}},[t._v("testButton")]),e("customButton",{staticClass:"signUpEmailCheckBtn",attrs:{id:"signUpEmailCheckBtn",btnText:"이메일 확인"},on:{click:t.emailCheck}},[t._v("testButton")])],1)]),e("div",{staticClass:"signUpFinalCheck"},[e("div",{staticClass:"dummyMarginSignUp3"}),e("customButton",{staticClass:"signUpFinalCheckBtn",attrs:{id:"signUpFinalCheckBtn",btnText:"회원 가입"},on:{click:t.registMember}},[t._v("회원 가입")]),e("div",{staticClass:"dummyMarginSignUp4"})],1)])]),t._m(1)])},i=[function(){var t=this,e=t._self._c;return e("div",{staticClass:"title"},[e("h3",[t._v("회원가입")]),e("hr")])},function(){var t=this,e=t._self._c;return e("div",{staticClass:"signUp2"},[e("img",{staticClass:"join_img",attrs:{src:a(14082),alt:"join_img"}}),e("img",{staticClass:"logoSlogan",attrs:{src:a(34202),alt:"logo & slogan"}})])}],l=a(56265),n=a.n(l),o=a(41952),c=a(93495),d=a.n(c),r={data(){return{id_validation:!1,id_duplicated:!1,pw_validation:!1,nick_validation:!1,email_validation:!1,state_message:"",emailCode:"",authEmailCode:"",validateId:"",validatePw:"",storeBaseurl:this.$store.state.baseurl,valid:{id:!1,pw:!1},idHasError:!1,pwHasError:!1}},computed:{pw_doubleCheck:function(){return document.getElementById("pwLabel").value==document.getElementById("pwcheckLabel").value}},watch:{validateId:function(){this.validID(this.validateId)},validatePw:function(){this.validPW(this.validatePw)}},methods:{checkDuplicateID(){let t=document.getElementById("idLabel").value;this.validID(t),this.id_validation?(console.log("유효한 아이디입니다."),console.log(this.id_validation),console.log(this.$store.state.baseurl+"member/chkid"),n().post(this.$store.state.baseurl+"member/chkid",{input_id:t}).then((e=>{console.log(t),console.log(e),"not-duplicated"==e.data.message?d()("아이디 중복 확인","해당 아이디 사용 가능합니다.","success"):(this.id_duplicated=!0,d()("아이디 중복 확인","중복된 아이디입니다.","error"))}))):(this.state_message="아이디는 영문 숫자 포함 6자리 이상입니다.",console.log("유효하지 않은 아이디"))},validID(t){const e=/(?=.*\d)(?=.[a-z]).{5,14}/g;if(e.test(t)||!this.validateId)return this.id_validation=!0,this.valid.id=!0,void(this.idHasError=!1);this.id_validation=!1,this.valid.id=!1,this.idHasError=!0},validPW(t){const e=/(?=.*\d)(?=.[a-zA-Z]).{8,30}/g;if(e.test(t)||!this.validatePw)return this.pw_validation=!0,this.valid.pw=!0,void(this.pwHasError=!1);this.pw_validation=!1,this.valid.pw=!1,this.pwHasError=!0},checkDuplicateNickname(){let t=document.getElementById("nickLabel").value;console.log(t),n().post(this.$store.state.baseurl+"member/chknic",{input_nickname:t}).then((t=>{"not-duplicated"==t.data.message?(d()("닉네임 중복 확인","해당 닉네임 사용 가능합니다.","success"),this.nick_validation=!0):(this.nick_validation=!1,d()("닉네임 중복 확인","중복된 닉네임입니다.","error"))}))},checkEmail(){let t=document.getElementById("emailLabel").value;n().post(this.$store.state.baseurl+"auth/email",{email:t}).then((t=>{console.log(t),this.authEmailCode=t.data.authcode,d()("이메일 인증","이메일 인증번호가 전송되었습니다.","success")}))},emailCheck(){let t=document.getElementById("emailcheckLabel").value;this.authEmailCode==t?(this.email_validation=!0,d()("이메일 인증","이메일 인증이 완료되었습니다.","success")):(this.email_validation=!1,d()("이메일 인증","올바르지 않은 인증번호 입니다.","error"))},registMember(){let t=document.getElementById("nickLabel").value,e=document.getElementById("idLabel").value,a=document.getElementById("pwLabel").value,s=document.getElementById("nameLabel").value,i=document.getElementById("emailLabel").value;this.validPW(a),this.email_validation&&this.id_validation&&this.pw_validation&&this.nick_validation&&document.getElementById("nameLabel").value?n().post(this.$store.state.baseurl+"member/",{nickname:t,userid:e,password:a,name:s,email:i}).then((t=>{"success"==t.data.message?(console.log("로그인 완료"),o.Z.push("/login")):console.log("로그인 실패")})):d()("회원가입","입력한 회원정보를 다시 확인하세요.","error")}}},u=r,m=a(1001),p=(0,m.Z)(u,s,i,!1,null,"34cdaf14",null),v=p.exports},14082:function(t,e,a){t.exports=a.p+"img/join_img1.16818e07.png"},34202:function(t,e,a){t.exports=a.p+"img/logo_with_slogan.48fe80a2.png"}}]);
//# sourceMappingURL=790.2abdb051.js.map