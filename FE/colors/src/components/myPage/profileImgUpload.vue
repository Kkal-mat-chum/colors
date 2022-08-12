<template>
  <div>
    <img id="profileimgfileupload" alt="" />
    <input @change="upload" multiple accept="image/*" type="file" id="file" class="inputfile" />
    <custom-button class="submit" btnText="완료" @click="submit">완료</custom-button>
  </div>
</template>

<script>
export default {
  methods: {
    upload(e) {
      var file = e.target.files;
      console.log(file[0]);
      let url = URL.createObjectURL(file[0]);
      console.log(url);
      document.getElementById("profileimgfileupload").src = url;
    },
    submit() {
      console.log("완료!!!");
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
</style>
