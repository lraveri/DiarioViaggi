<template>
  <div id="nav">
    <!-- <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <!-- <a class="navbar-brand" href="#">Pweb00</a> -->
        <!-- <router-link class="navbar-brand" aria-current="page" to="/">MyTravels</router-link> -->
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
              <!-- <a class="nav-link active" aria-current="page" href="#">Home</a> -->
              <router-link ref = "home" class="nav-link " aria-current="page" to="/">I Tuoi Viaggi</router-link>
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Features</a> -->
              <router-link class="nav-link" to="/createJourney">Nuovo Viaggio</router-link>
            </li>
            <li class="nav-item">
              <!-- <a class="nav-link" href="#">Features</a> -->
              <router-link class="nav-link" to="/editJourney">Modifica Viaggio</router-link>
            </li>
            <!-- <li class="nav-item float-right">
              <router-link class="nav-link" to="/login">Sign in</router-link>
          </li> -->
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
