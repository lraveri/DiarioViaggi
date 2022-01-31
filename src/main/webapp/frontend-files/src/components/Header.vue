<template>
  <div id="nav">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <router-link ref = "home" class="nav-link " aria-current="page" to="/">I Tuoi Viaggi</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/createJourney">Nuovo Viaggio</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/editJourney">Modifica Viaggio</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {

    methods: {
        addJourney: function(data, mezzo, tappe) {
            this.$refs.home.addJourney(data, mezzo, tappe);
        }
    }
};
</script>

<style></style>
