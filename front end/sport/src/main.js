import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'

// 引入全局global.css
import './assets/css/global.css'
//引入iconfont
import './assets/font/iconfont.css'

//引入axios
import axios from 'axios'

//全局中挂载axios
Vue.prototype.$http = axios
//设置请求初始信息,也就是设置访问的后端路径
axios.defaults.baseURL= process.env.NODE_ENV === "production" ?  'http://42.192.227.140:8888/api': 'http://localhost:8888/'
Vue.config.productionTip = false

new Vue({
  router,
  render: (h) => h(App),
}).$mount('#app')
