<template>
  <div v-if="streamManager">
    <ov-video :stream-manager="streamManager" @changeStreamTrack="() => this.$emit('changeStreamTrack')" />
  </div>
</template>

<script>
import OvVideo from "./OnVideo.vue";

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
