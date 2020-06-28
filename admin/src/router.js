import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login.vue'
import Admin from './views/admin.vue'
import Welcome from './views/admin/welcome.vue'
import Chapter from './views/admin/chapter.vue'
import Test from './views/test.vue'

Vue.use(Router)

export default new Router({
  mode: 'history', // 两种值, history , hash
  base: process.env.BASE_URL, // 内置变量
  routes: [
    {
      path: '/test',
      component: Test
    },
    {
      path: '*',
      redirect: '/login'
    }, {
      path: '/login',
      component: Login
    }, {
      path: '/',
      name: 'admin',
      component: Admin,
      children: [{
        path: 'welcome',
        name: 'welcome',
        component: Welcome,
      }, {
        path: 'business/chapter',
        name: 'business/chapter',
        component: Chapter,
      }]
    }]
})