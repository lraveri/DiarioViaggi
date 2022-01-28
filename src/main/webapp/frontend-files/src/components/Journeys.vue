<template>

  <div class="container-fluid m-3 border rounded p-5" style="width:97%" v-if="filteredViaggi.length !== 0">
  <table class="table table-striped" >
    <thead>
      <tr>
        <th>Data</th>
        <th>Mezzo utilizzato</th>
        <th>Tappe principali</th>
        <th>Mappa</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="viaggio in filteredViaggi" :key="viaggio.id">
        <td>{{ viaggio.data }}</td>
        <td>{{ viaggio.mezzo }}</td>
        <td>{{ viaggio.tappe }}</td>
        <!-- <td>
          <button class="btn btn-primary">
            <a href="http://localhost:8081/#/createJourney" style="color: white">Edit</a>
          </button>
        </td> -->
        <td>
          <button @click="showMap(viaggio.percorso)" class="btn btn-primary">
            Visualizza
          </button>
        </td>
      </tr>
    </tbody>
  </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      viaggi: [],
      filteredViaggi: [],
      selectedPath: "",
    };
  },
  methods: {
    // addJourney: function (data, mezzo, tappe) {
    //   const journey = {
    //     data,
    //     mezzo,
    //     tappe,
    //   };
    //   this.viaggi.push(journey);
    // },

    filterDate: function(inputDate) {
      this.filteredViaggi = this.viaggi.filter(viaggio => viaggio.data === inputDate);
    },

    showMap: function(selectedPath) {
      this.selectedPath = selectedPath;
      this.$emit("showMap", this.selectedPath);
    }

  },
  created() {
    // var uname = "MarcoRaveri";
    // var pass = "Marco";
    //const token = Buffer.from(`${uname}:${pass}`, "utf8").toString("base64");

    // axios
    //   .get(
    //     'http://localhost:8080/Pweb00/api/mongojourneys',
    //     {},
    //     {
    //       headers: {
    //         'Authorization': `Basic ${token}`,
    //       },
    //     }
    //   )
    //   .then(response => (this.viaggi = response.data))
    //   .catch(error => console.error(error));

    // axios({
    //   method: "get",
    //   url: "http://localhost:8080/Pweb00/api/mongojourneys",
    //   withCredentials: true,
    //   auth: {
    //     username: "MarcoRaveri",
    //     password: "Marco",
    //   },
    // })
    //   .then(response => (this.viaggi = response.data))
    //   .catch(error => console.error(error));

    axios
      .get(
        //"http://localhost:8080/Pweb00/api/mongojourneys"
        `${process.env.VUE_APP_APIROOT}`
      )
      .then(response => (this.viaggi = response.data))
      .catch(error => console.error(error));
  },
};
</script>

<style></style>
