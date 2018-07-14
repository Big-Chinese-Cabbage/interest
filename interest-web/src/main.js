import Vue from 'vue';
import iView from 'iview';
import VueRouter from 'vue-router';
import router from './router';
import App from './app.vue';
import axios from './axios';
import VueAxios from 'vue-axios';
import store from './store/store';
import VueQuillEditor from 'vue-quill-editor';
//dev--------------------------------
// import 'iview/dist/styles/iview.css';
// import 'quill/dist/quill.core.css';
// import 'quill/dist/quill.snow.css';
// import 'quill/dist/quill.bubble.css';

import './styles/common.css';

Vue.use(VueAxios,axios);

Vue.use(iView);
Vue.use(VueQuillEditor);

new Vue({
    el: '#app',
    router: router,
    store: store,
    render: h => h(App)
});