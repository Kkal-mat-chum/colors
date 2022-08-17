<template>
  <div>
    <div class="con">
      <img id="profileimgfileupload" alt="" />
      <input @change="upload" multiple accept="image/*" type="file" id="file" class="inputfile" />
    </div>
    <div class="btn">
      <custom-button class="submit" btnText="완료" @click="submit">완료</custom-button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import AWS from "aws-sdk";
import router from "@/router";
import swal from "sweetalert";

export default {
  data() {
    return {
      awsid: process.env.VUE_APP_AWS_IDENTITYPOOLID,
      imgfile: null,
    };
  },
  methods: {
    upload(e) {
      var file = e.target.files;
      console.log(file[0]);
      this.imgfile = file[0];
      let url = URL.createObjectURL(file[0]);
      console.log(url);
      document.getElementById("profileimgfileupload").src = url;
    },
    submit() {
      let memberData = JSON.parse(sessionStorage.getItem("memberData"));
      let userid = memberData.data.userId;
      // s3 upload
      AWS.config.update({
        region: "ap-northeast-2",
        credentials: new AWS.CognitoIdentityCredentials({
          IdentityPoolId: this.awsid,
        }),
      });

      var s3 = new AWS.S3({
        apiVersion: "2012-10-17",
        params: {
          Bucket: "ssafy7color",
        },
      });
      let today = new Date();
      today = today.getFullYear() + "" + (today.getMonth() + 1) + today.getDate();
      let photoKey = "profile/" + userid + "/" + today + ".jpg";

      s3.upload(
        {
          Key: photoKey,
          Body: this.imgfile,
          ACL: "public-read",
        },
        (err, data) => {
          if (err) {
            console.log(err);
          }
          router.go(router.currentRoute);
          console.log(data);
        }
      );

      var url = "https://ssafy7color.s3.ap-northeast-2.amazonaws.com/" + photoKey;

      console.log(url);

      // db 저장

      axios
        .put(this.$store.state.baseurl + "member/changeimg", {
          userid: userid,
          image_url: url,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.message == "success") {
            swal("프로필 이미지 등록", "등록이 완료되었습니다.", "success");
            sessionStorage.setItem("memberData", sessionStorage.getItem("memberData"));
          } else {
            swal("프로필 이미지 등록", "등록에 실패하였습니다.", "error");
          }
        });
    },
  },
};
</script>

<style scoped>
#profileimgfileupload {
  width: 170px;
  height: 170px;
  margin-top: 8px;
  margin-left: 7px;
  border-radius: 50%;
  border: 8px solid #c1c4ff;
}
.con {
  margin-top: 50px;
}
.btn {
  margin-top: 50px;
}
.submit {
  width: 100px;
}
</style>
