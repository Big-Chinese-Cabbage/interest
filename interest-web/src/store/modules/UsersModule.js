import axios from "axios";
import iView from "iview";

export default {
  namespaced: true,
  state: {
    currentUser: {
      get UserName() {
        return localStorage.getItem("currentUser_name");
      },
      get UserToken() {
        return localStorage.getItem("currentUser_token");
      },
      get RefreshToken() {
        return localStorage.getItem("currentUser_refresh_token");
      }
    }
  },
  mutations: {
    setUser(state, { user_name, user_token, refresh_token }) {
      // 在这里把用户名和token保存起来
      localStorage.setItem("currentUser_name", user_name);
      localStorage.setItem("currentUser_token", user_token);
      localStorage.setItem("currentUser_refresh_token", refresh_token);
    },
    clearUser(state) {
      localStorage.clear();
    }
  },
  actions: {
    userLogin(context, { user_name, user_password, router }) {
      axios({
        method: "post",
        url: "/oauth/token",
        params: {
          username: user_name,
          password: user_password,
          grant_type: "password",
          scope: "all"
        },
        auth: {
          username: "client",
          password: "secret"
        }
      })
        .then(function(response) {
          /*console.log(response.data);*/
          context.commit("setUser", {
            user_name: user_name,
            user_token: response.data.access_token,
            refresh_token: response.data.refresh_token
          });
          /*router.push({path:"base"});*/
          axios.defaults.headers.common["Authorization"] =
            "bearer " + localStorage.getItem("currentUser_token");
          router.push({ path: "/page/home" });
          context.commit("setSignFalse", null, { root: true });
          /*this.$route.router.push({ path: '/base' });*/
        })
        .catch(function(error) {
          /*iView.Message.error('用户名或密码错误！');*/
          context.commit("setSignTrue", null, { root: true });
        });
    },
    loginOUt(context, { router }) {
      router.push({ path: "/" });
      location.reload();
      context.commit("clearUser");
    }
  }
};
