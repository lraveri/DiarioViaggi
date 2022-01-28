<template>
  <div class="home">
    <DateSelector @filterDate="filterDate" />
    <Journeys @showMap="showMap" ref="journeys" />
    <Map ref="map"/>
  </div>
</template>

<script>
import Journeys from "@/components/Journeys.vue";
import DateSelector from "@/components/DateSelector.vue";
import Map from "@/components/Map.vue";

export default {
  name: "Home",
  components: {
    Journeys,
    DateSelector,
    Map,
  },
  methods: {
    addJourney: function (data, mezzo, tappe) {
      console.log(data);
      console.log(mezzo);
      console.log(tappe);
    },

    filterDate: function (inputDate) {
      this.$refs.journeys.filterDate(inputDate);
    },

    showMap: function (inputPath) {
      this.$refs.map.showMap(inputPath);
    },
  },
};
</script>
