import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import axios from "axios";

//引入Elmessage和Elloading的css样式文件 elmessage无法现实的问题
import 'element-plus/theme-chalk/el-loading.css';
import 'element-plus/theme-chalk/el-message.css';

const app = createApp(App)

axios.defaults.baseURL = 'http://localhost:8080'

app.use(createPinia())
app.use(router)

app.mount('#app')
