import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login.vue'
import Admin from './views/admin.vue'

Vue.use(Router)

export default new Router({
    mode: 'history', // 两种值, history , hash
    base: process.env.BASE_URL, // 内置变量
    routes: [{
        path: '*',
        redirect: '/login'
    }, {
        path: '/login',
        component: Login
    },{
        path: '/admin',
        component: Admin
    }]
})