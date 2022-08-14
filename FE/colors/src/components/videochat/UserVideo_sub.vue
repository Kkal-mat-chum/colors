<template>
  <div v-if="streamManager">
    <ov-video :stream-manager="streamManager" />
    <div class="name">{{ clientData }}</div>
  </div>
</template>

<script>
import OvVideo from "./OnVideo_sub.vue";

export default {
  name: "UserVideo",

  components: {
    OvVideo,
  },

  props: {
    streamManager: Object,
  },

  computed: {
    clientData() {
      const { clientData } = this.getConnectionData();
      return clientData;
    },
  },

  methods: {
    getConnectionData() {
      const { connection } = this.streamManager.stream;
      return JSON.parse(connection.data);
    },
  },
};
</script>

<style scoped>
.name {
  margin-top: 3px;
  color: #434485;
}
</style>
