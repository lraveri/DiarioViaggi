<template>
<div class="container-fluid m-3 border rounded p-5" style="width:97%">
  <form>
    <h1 class="mb-3" style="text-align: center">Seleziona una data</h1>
    <div class="mb-3">
      <input
        type="date"
        class="form-control"
        placeholder="aaaa/mm/dd"
        v-model="data"
      />
    </div>
    <button
      type="submit"
      class="btn btn-primary"
      style="width: 100%"
      @click.prevent="filterDate"
    >
      Ricerca viaggi
    </button>
  </form>
  </div>
</template>

<script>
export default {

  data() {
    return {
      data: new Date(),
    }
  },

  methods: {
    filterDate: function() {
      this.$emit("filterDate", this.data);
    }
  },

};
</script>

<style></style>
