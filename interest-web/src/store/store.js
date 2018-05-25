import Vuex from 'vuex'
import Vue from 'vue'
import UsersModule from './modules/UsersModule';

Vue.use(Vuex);
export default new Vuex.Store({
    modules: {
        users:UsersModule
    },
    state: {
        todos: [
          { id: 1, text: '...', done: true },
          { id: 2, text: '...', done: false }
        ],
        count: 0,
        /*登录界面判断是否显示错误提示*/
        ifSign: false
    },
    getters: {
        doneTodos: state =>{
            return state;
        },
        doneTodosCount: (state, getters) => {
            return getters;
        },
        getTodoById: (state) => (id) => {
            return state.todos.find(todo => todo.id === id)
        },
        getSign:state =>{
            return state.ifSign;
        }
    },
    mutations: {
        add(state){
            state.count++;
        },
        increment(state,number){
            state.count+=number;
        },
        setSignTrue(state){
            state.ifSign = true;
        },
        setSignFalse(state){
            state.ifSign = false;
        }
    },
    actions: {
        increment(context){
            context.commit('add');
        }
    }
})