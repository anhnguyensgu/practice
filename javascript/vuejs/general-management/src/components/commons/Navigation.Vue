<template>
  <v-toolbar>
    <v-toolbar-side-icon></v-toolbar-side-icon>
    <v-toolbar-title>{{title}}</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <v-btn flat v-for="item in items" :key="item.name" :to="item.link">{{item.name}}</v-btn>
    </v-toolbar-items>
  </v-toolbar>
</template>

<script scoped>
export default {
  props: ["items", "test", "title"],
  name: "Navigation",
  methods: {
    clickTest: function(params) {
      this.test();
    }
  }
};
</script>

<style scoped lang="scss">
// ul {
//   list-style-type: none;
//   padding: 0;
//   margin: 0;
//   li {
//     display: inline-block;
//     a {
//       color: #42b983;
//       text-decoration: none;
//       padding: 8px 16px;
//       display: block;
//     }
//   }
// }
// a {
//   color: #42b983;
//   text-decoration: none;
//   padding: 8px 16px;
//   display: block;
// }
</style>
