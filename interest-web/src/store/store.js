import Vuex from "vuex";
import Vue from "vue";
import UsersModule from "./modules/UsersModule";

Vue.use(Vuex);
export default new Vuex.Store({
  modules: {
    users: UsersModule
  },
  state: {
    todos: [
      { id: 1, text: "...", done: true },
      { id: 2, text: "...", done: false }
    ],
    /*域名*/
    // domainName: 'http://127.0.0.1:8088',
    domainName: "http://www.lovemtt.com",
    count: 0,
    /*登录界面判断是否显示错误提示*/
    ifSign: false
  },
  getters: {
    doneTodos: state => {
      return state;
    },
    doneTodosCount: (state, getters) => {
      return getters;
    },
    getTodoById: state => id => {
      return state.todos.find(todo => todo.id === id);
    },
    getSign: state => {
      return state.ifSign;
    },
    _isMobile() {
      let flag = navigator.userAgent.match(
        /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
      );
      return flag;
    }
  },
  mutations: {
    add(state) {
      state.count++;
    },
    increment(state, number) {
      state.count += number;
    },
    setSignTrue(state) {
      state.ifSign = true;
    },
    setSignFalse(state) {
      state.ifSign = false;
    }
  },
  actions: {
    increment(context) {
      context.commit("add");
    }
  }
});
