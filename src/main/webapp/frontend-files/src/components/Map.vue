<template>
<div class="container-fluid m-3 border rounded p-3" style="width:97%" >
  <l-map style="height: 350px" :zoom="zoom" :center="center">
    <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
    <l-geo-json :geojson="geojson"></l-geo-json>
  </l-map>
  </div>
</template>

<script>
import { LMap, LTileLayer, LGeoJson } from "vue2-leaflet";

export default {
  components: {
    LMap,
    LTileLayer,
    LGeoJson,
  },
  data() {
    return {
      url: "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
      attribution:
        '&copy; <a target="_blank" href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      zoom: 3,
      center: [47.31322, -1.319482],
      geojson: null,
    };
  },

  methods: {
    showMap: function (inputPath) {
      this.geojson = JSON.parse(inputPath);
    },
  },

  // crea il percorso

  // async created() {
  //   const response = await fetch(
  //     "https://rawgit.com/gregoiredavid/france-geojson/master/regions/pays-de-la-loire/communes-pays-de-la-loire.geojson"
  //   );
  //   this.geojson = await response.json();
  // },
};
</script>
