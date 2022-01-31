<template>
  <div>
    <form class="m-3 border rounded p-5">
      <h1 style="text-align: center">Inserisci un nuovo viaggio</h1>
      <div class="mb-3">
        <label class="form-label">Data</label>
        <input
          type="date"
          class="form-control"
          placeholder="aaaa/mm/dd"
          v-model="data"
        />
      </div>
      <div class="mb-3">
        <label class="form-label">Mezzo</label>
        <select class="form-select" name="" id="" v-model="mezzo">
          <option disabled selected value>--Seleziona un opzione--</option>
          <option value="Auto">Auto</option>
          <option value="Treno">Treno</option>
          <option value="Aereo">Aereo</option>
          <option value="Bici">Bici</option>
          <option value="Corsa">Corsa</option>
          <option value="Camminata">Camminata</option>
        </select>
      </div>
      <div class="mb-3">
        <label class="form-label">Tappe principali</label>
        <input type="text" class="form-control" v-model="tappe" />
      </div>
      <div class="mb-3">
        <label class="form-label">Percorso (in formato GeoJSON)</label>
        <input type="text" class="form-control" v-model="percorso" />
      </div>
      <button
        type="submit"
        class="btn btn-primary"
        @click.prevent="addJourney"
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

  name: "CreateJourney",

  methods: {
    addJourney: function () {
      let data = this.data;
      let mezzo = this.mezzo;
      let tappe = this.tappe;
      let percorso = this.percorso;
      //var uname = "MarcoRaveri";
      //var pass = "Marco";
      axios
        .post(`${process.env.VUE_APP_APIROOT}`, {
          data,
          mezzo,
          tappe,
          percorso
        })
        .then(() => this.resetVariables())
        .catch(error => console.error(error));
    },

    resetVariables: function() {
          this.data = "";
          this.mezzo = "";
          this.tappe = "";
          this.percorso = "";
    }
  },

  data() {
    return {
      data: "",
      mezzo: "",
      tappe: "",
      percorso: ""
    };
  },
};
</script>

<style></style>
