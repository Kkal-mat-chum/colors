<template>
  <div data-aos-easing="ease" data-aos-duration="1400" data-aos-delay="0" class="body_has_c_gnb">
    <div class="text-center">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12">
            <h3 class="big">
              <span>자신에게 가장 잘 어울리는</span>
              <div>
                <span>색깔을 찾는 </span>
              </div>

              <span>
                <div>
                  <b>"깔 맞 춤"</b>
                </div>
                지금
                <div></div>
                시작하세요!
              </span>
            </h3>
            <img class="emoji" src="" alt="" />
            <p class="msg">
              <span>언제, 어디서든</span>
              <span>운동 종류, 운동 방법, 동작까지</span>
              <span>나에게 맞는 맞춤 운동을 만나보세요.</span>
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="epiBoxWrap">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="epiBox whiteText ebMajorPr aos-init aos-animate" data-aos="fade-up">
              <h6>온라인 PT의 기준, SSAFIT!</h6>
              <h4>
                <span>영상만 따라하면,</span>
                <div>
                  <span>나도 몸짱!</span>
                </div>
              </h4>
              <div class="tBox aos-init aos-animate" data-aos="fade-down">
                <div class="tBox-msg">
                  <div>
                    <span>복근, 하체, 상체 등</span>
                  </div>
                  <div>
                    <span>내가 찾는 운동을 검색해 보세요.</span>
                  </div>
                  <div>
                    <span>언제나, 어디서든</span>
                  </div>
                  <span>쉽게 운동을 배울 수 있습니다.</span>
                </div>
              </div>
              <img class="mockup mc1 aos-init aos-animate" src="http://i.ytimg.com/vi/KTMeuLU3dII/0.jpg" alt="" data-aos="fade-up" data-aos-delay="850" />
              <img class="mockup mc2 aos-init aos-animate" src="http://i.ytimg.com/vi/bvu6SUPFmYM/0.jpg" alt="" data-aos="fade-up-left" data-aos-delay="1000" />
              <img class="mockup mc3 aos-init aos-animate" src="http://i.ytimg.com/vi/VtOqYd01LD8/0.jpg" alt="" data-aos="fade-up-right" data-aos-delay="700" />
              <img class="mockup mc4 aos-init aos-animate" src="http://i.ytimg.com/vi/Vx2yxXQ0Pkk/0.jpg" alt="" data-aos="fade-up-right" data-aos-delay="1150" />
            </div>
          </div>
        </div>
      </div>
      <div class="selectBoxWrap">
        <div class="container">
          <h3>
            <span>당신에게 FIT한</span>
            <span>SSAFIT 프로그램</span>
          </h3>
          <p class="anc">
            온라인 운동,
            <br />
            지금 SSAFIT에서 시작하세요.
            <br />
            <br />
          </p>
          <div class="row">
            <div class="col-sm-6">
              <div class="epiBox h100 selectBox aos-init aos-animate" data-aos="fade-up">
                <h4>
                  <div>
                    <span>SSAFIT</span>
                  </div>
                  <div>
                    <span><b>온라인 운동</b></span>
                  </div>
                  <span>코치없이 혼자!</span>
                </h4>
                <ul data-aos="fade-down" class="aos-init aos-animate">
                  <li>운동 부위 검색</li>
                  <li>장소에 상관없이 운동</li>
                  <li>원하는 부위 운동 가능</li>
                  <li>쉬운 접근성</li>
                </ul>
                <img
                  class="mockup mc7 aos-init aos-animate"
                  src="https://images.unsplash.com/photo-1640622304931-7f9e856f787b?ixlib=rb-1.2.1&raw_url=true&q=80&fm=jpg&crop=entropy&cs=tinysrgb&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687"
                  alt=""
                  data-aos="fade-left"
                />
                <b-button class="cta aos-init aos-animate" :to="{ name: 'search' }" data-aos="fade-up">모든 운동영상 보기</b-button>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="epiBox h100 selectBox plusBox aos-init aos-animate" data-aos="fade-up" data-aos-delay="400">
                <h4>
                  <span
                    >SSAFIT<sup><b-icon icon="plus"></b-icon></sup
                  ></span>
                  <span><b>플러스</b></span>
                </h4>
                <ul data-aos="fade-down" class="aos-init aos-animate">
                  <li>DM을 이용한 의사소통</li>
                  <li>자주보는 영상 찜</li>
                  <li>팔로우, 팔로워</li>
                  <li>내 주위 헬스장 찾기</li>
                </ul>
                <img
                  class="mockup mc8 aos-init aos-animate"
                  src="https://images.unsplash.com/photo-1499711860525-c485eb341d5e?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=60&raw_url=true&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OTE0fHxwbHVzfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500"
                  alt=""
                  data-aos="fade-left"
                />

                <b-button class="cta aos-init aos-animate" :to="{ name: 'gym' }" data-aos="fade-up">헬스장 찾기</b-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NameInfo",
};
</script>

<style scoped>
.big {
  font-size: 40px;
  font-weight: 400;
  font-family: Cafe24Ohsquare_air;
  letter-spacing: 0;
  word-break: keep-all;
  clear: #123;
  line-height: 1.3;
  margin-bottom: 20px;
  margin-top: 0px;
  box-sizing: border-box;
  display: black;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
.text-center {
  text-align: center !important;
}
.emoji {
  height: 64px;
  display: black;
  margin: 5px auto 30px;
  margin-top: 5px;
  margin-right: auto;
  margin-bottom: 30px;
  margin-left: auto;
}
b {
  font-weight: 800;
}
p {
  font-size: 18px;
  word-break: keep-all;
  color: #fff;
  display: block;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
.msg span {
  display: block;
  color: black;
}
.epiBoxWrap {
  background: #ffffff url(https://img.freepik.com/free-photo/simple-white-background-with-smooth-lines-in-light-colors_476363-1080.jpg?size=626&ext=jpg&ga=GA1.2.1656392432.1636588800) no-repeat center
    top scroll;
  background-size: cover;
  padding: 20px 0;
  padding-top: 20px;
  padding-right: 0px;
  padding-bottom: 20px;
  padding-left: 0px;
}
div {
  display: block;
}
.row {
  display: flex;
  flex-wrap: wrap;
  margin-right: -15px;
  margin-left: -15px;
  justify-content: center;
}
.container {
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}
[data-aos^="fade"][data-aos^="fade"].aos-animate {
  opacity: 1;
  transform: translateZ(0);
}
div[data-aos-easing="ease"] [data-aos] {
  transition-timing-function: ease;
}
div[data-aos-duration="1500"] [data-aos] {
  transition-duration: 1.5s;
}
.epiBox.ebMajorPr {
  height: 520px;
  background: rgba(17, 34, 51, 0.85);
}
[data-aos^="fade"][data-aos^="fade"] {
  transition-property: opacity, transform;
}
.epiBox {
  padding: 30px;
  box-shadow: 0 4px 8px rgb(0 0 0 / 10%), 0 6px 16px rgb(0 0 0 / 10%);
  border-radius: 6px;
  position: relative;
  overflow: hidden;
  margin-bottom: 30px;
  min-height: 400px;
}
.epiBox.whiteText h6 {
  color: #fff;
}
.epiBox h6 {
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 20px;
  line-height: 1.2;
  margin-top: 0;
}
h6 {
  display: block;
  margin-block-start: 2.33em;
  margin-block-end: 2.33em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
.epiBox.whiteText h4 {
  color: #fff;
}
.epiBox h4 {
  font-size: 32px;
  font-family: Cafe24Ohsquare_air;
  line-height: 40px;
  word-break: keep-all;
}
h4 {
  margin-bottom: 0.5rem;
  font-weight: 500;
  margin-top: 0;
  display: block;
  margin-block-start: 1.33em;
  margin-block-end: 1.33em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
* {
  box-sizing: border-box;
}
.epiBox.ebMajorPr p {
  opacity: 0.8;
  word-break: keep-all;
}
.epiBox .tBox {
  position: absolute;
  bottom: 30px;
  left: 30px;
  max-width: 50%;
}
.tBox-msg {
  font-size: 16px;
  line-height: 24px;
  margin: 0;
  color: #fff;
}
[data-aos][data-aos][data-aos-delay="800"].aos-animate {
  transition-delay: 0.8s;
}
.epiBox.ebMajorPr .mc1 {
  width: 240px;
  top: 30px;
  right: 230px;
  z-index: 2;
}
.epiBox .mockup {
  position: absolute;
}
img {
  vertical-align: middle;
  border-style: none;
}
[data-aos][data-aos][data-aos-delay="1200"].aos-animate {
  transition-delay: 1.2s;
}
.epiBox.ebMajorPr .mc2 {
  width: 240px;
  top: 140px;
  right: 90px;
  z-index: 3;
}
[data-aos][data-aos][data-aos-delay="600"].aos-animate {
  transition-delay: 0.6s;
}
.epiBox.ebMajorPr .mc3 {
  width: 240px;
  top: 180px;
  right: 310px;
  z-index: 1;
}
[data-aos][data-aos][data-aos-delay="1400"].aos-animate {
  transition-delay: 1.4s;
}
.epiBox.ebMajorPr .mc4 {
  width: 240px;
  top: 290px;
  right: 120px;
  z-index: 4;
}
.selectBoxWrap {
  padding: 80px 0;
}
h3 {
  color: #123;
  font-size: 32px;
  font-weight: 400;
  line-height: 1.3;
  letter-spacing: -0.5px;
  margin-bottom: 20px;
}
h3 span {
  display: block;
}
.selectBoxWrap p.anc {
  font-size: 16px;
}
.anc {
  margin-top: 0;
  margin-bottom: 1rem;
  color: black;
}
.epiBox.h100 {
  height: calc(100% -30px);
}
.selectBox {
  min-height: 500px;
}
.epiBox {
  background-color: #fff;
  padding: 30px;
  box-shadow: 0 4px 8px rgb(0 0 0 / 10%), 0 6px 16px rgb(0 0 0 / 10%);
  border-radius: 6px;
  position: relative;
  overflow: hidden;
  margin-bottom: 30px;
}
ul {
  margin: 0;
  padding: 0;
  display: block;
  list-style-type: disc;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  padding-inline-start: 40px;
}
li {
  margin-left: -20px;
}
.selectBox .mc7 {
  width: 280px;
  bottom: 80px;
  height: 350px;
  right: 10px;
}
.selectBox .cta {
  height: 40px;
  line-height: 28px;
  width: 180px;
  font-size: 18px;
  position: absolute;
  bottom: 40px;
  left: 30px;
  background-color: #333;
  color: #fff;
}
.col-sm-6 {
  flex: 0 0 50%;
  max-width: 50%;
  position: relative;
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
}
[data-aos][data-aos][data-aos-delay="400"].aos-animate {
  transition-delay: 0.4s;
}
.epiBox.h100 {
  height: calc(100% - 30px);
}
.epiBox.h4 {
  color: #123;
  font-size: 32px;
  font-family: Cafe24Ohsquare_air;
  line-height: 40px;
  word-break: keep-all;
}
.epiBox h4 span {
  display: block;
}
.selectBox .mc8 {
  width: 280px;
  bottom: 80px;
  height: 350px;
  right: 10px;
}
.epiBox .mockup {
  position: absolute;
}
.selectBox.plusBox .cta {
  background: #174c88;
}
.selectBox .cta {
  height: 48px;
  line-height: 35px;
  width: 180px;
  font-size: 18px;
  position: absolute;
  bottom: 30px;
  margin: 0;
}
.cta {
  display: block;
  margin: 20px 0;
  width: 260px;
  height: 52px;
  line-height: 50px;
  font-weight: 600;
  font-size: 14px;
  text-align: center;
  color: #fff;
  box-shadow: 0 8px 16px rgb(0 0 0 / 20%);
  border-radius: 50px;
  text-decoration: none;
  cursor: pointer;
}
.fa-plus:before {
  content: "\f067";
}
.fas {
  font-weight: 900;
  font-family: "Font Awsesome 5 Free";
  display: inline-block;
  font-style: normal;
  font-variant: normal;
  text-rendering: auto;
  line-height: 1;
}
sup {
  font-size: 88%;
}
</style>
