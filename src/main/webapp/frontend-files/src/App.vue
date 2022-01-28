<template>
  <div id="app">
    <Header ref = "header"/>
    <router-view @addJourney="handleEvent" />
  </div>
</template>

<script>
import Header from "@/components/Header";

export default {
  name: "App",
  components: {
    Header,
  },
  methods: {
    handleEvent: function (data, mezzo, tappe) {
      console.log("data: ", data);
      console.log("mezzo: ", mezzo);
      console.log("tappe: ", tappe);
      this.$refs.header.addJourney(data, mezzo, tappe); 
    },
  },
};
</script>

<style></style>
