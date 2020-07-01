import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login'
import Admin from './views/admin'
import Welcome from './views/admin/welcome'
import Chapter from './views/admin/chapter'
import Section from './views/admin/section'

Vue.use(Router)

export default new Router({
  mode: 'history', // 两种值, history , hash
  base: process.env.BASE_URL, // 内置变量
  routes: [
    {
      path: '*',
      redirect: '/login'
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/',
      name: 'admin',
      component: Admin,
      children: [
        {
          path: 'welcome',
          name: 'welcome',
          component: Welcome,
        },
        {
          path: 'business/chapter',
          name: 'business/chapter',
          component: Chapter,
        },
        {
          path: 'business/section',
          name: 'business/section',
          component: Section,
        }
      ]
    }
  ]
})