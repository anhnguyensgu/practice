import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Vuetify from 'vuetify'
import Home from './components/home/Home'
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.use(VueRouter);
Vue.use(Vuetify);

const router = new VueRouter({
  routes: [
    { path: '/', component: Home },
    { path: '/about', component: Home },
  ]
});

new Vue({
  el: '#app',
  render: h => h(App),
  router
})
