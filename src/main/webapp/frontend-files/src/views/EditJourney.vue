<template>
  <div>
    <form id="editForm" class="m-3 border rounded p-5">
      <h1 class="mb-3" style="text-align: center">Modifica viaggio</h1>
      <select
        class="form-select mb-3"
        @change="setJourney($event.target.value)"
      >
        <option disabled selected value>-- Seleziona viaggio --</option>
        <option v-for="(viaggio, index) in viaggi" :key="index" :value="index">
          {{ viaggio.data }} - {{ viaggio.mezzo }} - {{ viaggio.tappe }}
        </option>
        <!-- <option
          v-for="viaggio in viaggi"
          :key="viaggio._id"
          :value="viaggio._id.randomValue1"
        >
          {{ viaggio.data }} - {{ viaggio.mezzo }} - {{ viaggio.tappe }}
        </option> -->
      </select>
      <div class="mb-3">
        <label class="form-label">Data</label>
        <input type="date" class="form-control" v-model="selectedData" />
      </div>
      <div class="mb-3">
        <label class="form-label">Mezzo</label>
        <input type="text" class="form-control" v-model="selectedMezzo" />
      </div>
      <div class="mb-3">
        <label class="form-label">Tappe principali</label>
        <input type="text" class="form-control" v-model="selectedTappe" />
      </div>
      <div class="mb-3">
        <label class="form-label">Percorso (in formato GeoJSON)</label>
        <input type="text" class="form-control" v-model="selectedPercorso" />
      </div>
      <button
        type="submit"
        class="btn btn-primary"
        @click.prevent="editJourney"
        style="width: 100%"
      >
        Inserisci
      </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {

  name: "EditJourney",

  data() {
    return {
      viaggi: [],
      selectedId: "",
      selectedData: "",
      selectedMezzo: "",
      selectedTappe: "",
      selectedPercorso: "",
    };
  },

  created() {
    axios
      .get(`${process.env.VUE_APP_APIROOT}`)
      .then(response => (this.viaggi = response.data))
      .catch(error => console.error(error));
  },
  methods: {
    setJourney: function (index) {
      const selectedJourney = this.viaggi[index];
      this.selectedId = selectedJourney.id;
      this.selectedData = selectedJourney.data;
      this.selectedMezzo = selectedJourney.mezzo;
      this.selectedTappe = selectedJourney.tappe;
      this.selectedPercorso = selectedJourney.percorso;
    },

    editJourney: function () {
      const id = this.selectedId;
      const data = this.selectedData;
      const mezzo = this.selectedMezzo;
      const tappe = this.selectedTappe;
      const percorso = this.selectedPercorso;
      //var uname = "MarcoRaveri";
      //var pass = "Marco";
      axios
        .put(`${process.env.VUE_APP_APIROOT}`, {
          id: id,
          data: data,
          mezzo: mezzo,
          tappe: tappe,
          percorso: percorso,
        })
        .then(() => {
          this.resetVariables();
          axios
            .get(`${process.env.VUE_APP_APIROOT}`)
            .then(response => (this.viaggi = response.data))
            .catch(error => console.error(error));
          document.getElementById("editForm").reset();
        })
        .catch(error => console.error(error));
    },

    resetVariables: function () {
      this.selectedId = "";
      this.selectedData = "";
      this.selectedMezzo = "";
      this.selectedTappe = "";
      this.selectedPercorso = "";
    },

    // setJourney: function (journeyId) {
    //   console.log(journeyId);
    //   const selectedJourney = this.viaggi.find(
    //     viaggio => viaggio._id.randomValue1 === journeyId
    //   );
    //   console.log(selectedJourney);
    //   this.selectedData = selectedJourney.data;
    //   this.selectedMezzo = selectedJourney.mezzo;
    //   this.selectedTappe = selectedJourney.tappe;
    // },
  },
};
</script>

<style></style>
