<template>
  <v-app id="app">
    <!-- <navigation v-bind:items="navItems" v-bind:test="test" title="General-Management"/> -->
    <navigation-drawer></navigation-drawer>
    <h1>{{ msg }}</h1>
    <router-view/>
  </v-app>
</template>

<script>
import Navigation from "./components/commons/Navigation";
import NavigationDrawer from './components/drawer/NavigationDrawer';

export default {
  components: { Navigation, NavigationDrawer },
  name: "app",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      navItems: [{ link: "/", name: "Home" }, { link: "/about", name: "About" }]
    };
  },
  methods: {
    test: function() {
      console.log('update state');
    }
  }
};
</script>

<style lang="scss">
// @import '~vuetify/src/stylus/main';
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  h1,
  h2 {
    font-weight: normal;
  }
}
</style>
