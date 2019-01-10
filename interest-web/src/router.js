import Vue from "vue";
import VueRouter from "vue-router";
import iView from "iview";

Vue.use(VueRouter);

const routers = [
  {
    path: "*",
    component: resolve => require(["./views/error404.vue"], resolve)
  },
  {
    path: "/",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/template/index.vue"], resolve),
    children: [
      {
        path: "",
        name: "home",
        component: resolve => require(["./views/template/home.vue"], resolve),
        meta: {
          title: "home"
        }
      }
    ]
  },
  {
    path: "/qq",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/template/index.vue"], resolve),
    children: [
      {
        path: "",
        name: "qq-home",
        component: resolve => require(["./views/template/home.vue"], resolve),
        meta: {
          title: "home"
        }
      }
    ]
  },
  {
    path: "/login",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/login.vue"], resolve)
  },
  {
    path: "/page",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/template/index.vue"], resolve),
    children: [
      {
        path: "home",
        name: "page-home",
        component: resolve => require(["./views/template/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "home/:title",
        name: "page-home-title",
        component: resolve => require(["./views/template/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "detail/:id",
        name: "page-detail-id",
        component: resolve => require(["./views/template/detail.vue"], resolve),
        meta: {
          title: "detail"
        }
      },
      {
        path: "card/:id",
        name: "page-card-id",
        component: resolve => require(["./views/template/card.vue"], resolve),
        meta: {
          title: "card"
        }
      },

      {
        path: "messages",
        name: "page-messages",
        component: resolve =>
          require(["./views/template/messages.vue"], resolve),
        meta: {
          title: "messages"
        }
      }
    ]
  },
  {
    path: "/mlogin",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/mlogin.vue"], resolve)
  },
  {
    path: "/mobile",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/mobile/index.vue"], resolve),
    children: [
      {
        path: "",
        name: "mobile-home",
        component: resolve => require(["./views/mobile/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "home/:title",
        name: "mobile-home-title",
        component: resolve => require(["./views/mobile/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "detail/:id",
        name: "mobile-detail-id",
        component: resolve => require(["./views/mobile/detail.vue"], resolve),
        meta: {
          title: "detail"
        }
      },
      {
        path: "card/:id",
        name: "mobile-card-id",
        component: resolve => require(["./views/mobile/card.vue"], resolve),
        meta: {
          title: "card"
        }
      },

      {
        path: "messages",
        name: "mobile-messages",
        component: resolve => require(["./views/mobile/messages.vue"], resolve),
        meta: {
          title: "messages"
        }
      }
    ]
  },
  {
    path: "/base",
    meta: {
      title: "base",
      requiresAuth: true
    },
    component: resolve => require(["./views/sys/base.vue"], resolve),
    children: [
      {
        path: "",
        name: "welcome",
        component: resolve => require(["./views/sys/welcome.vue"], resolve),
        meta: {
          title: "welcome"
        }
      },
      {
        path: "menu",
        name: "menu",
        component: resolve => require(["./views/sys/menu.vue"], resolve),
        meta: {
          title: "menu"
        }
      },
      {
        path: "role",
        name: "role",
        component: resolve => require(["./views/sys/role.vue"], resolve),
        meta: {
          title: "role"
        }
      },
      {
        path: "user",
        name: "user",
        component: resolve => require(["./views/sys/user.vue"], resolve),
        meta: {
          title: "user"
        }
      },
      {
        path: "email",
        name: "email",
        component: resolve => require(["./views/sys/email.vue"], resolve),
        meta: {
          title: "email"
        }
      },
      {
        path: "card",
        name: "cardmanage",
        component: resolve => require(["./views/sys/card.vue"], resolve),
        meta: {
          title: "card"
        }
      },
      {
        path: "i-edit",
        name: "interest-edit",
        component: resolve =>
          require(["./views/sys/interest/interest-edit.vue"], resolve),
        meta: {
          title: "interest"
        }
      },
      {
        path: "i-create",
        name: "interest-create",
        component: resolve =>
          require(["./views/sys/interest/interest-create.vue"], resolve),
        meta: {
          title: "interest"
        }
      },
      {
        path: "i-delete",
        name: "interest-delete",
        component: resolve =>
          require(["./views/sys/interest/interest-delete.vue"], resolve),
        meta: {
          title: "interest"
        }
      },
      {
        path: "banner",
        name: "banner",
        component: resolve => require(["./views/sys/banner.vue"], resolve),
        meta: {
          title: "banner"
        }
      }
    ]
  }
];

// 路由配置
const RouterConfig = {
  mode: "history",
  routes: routers
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
  let token = window.localStorage.getItem("currentUser_token");
  if (
    to.matched.some(record => record.meta.requiresAuth) &&
    (!token || token === null)
  ) {
    next({
      path: "/",
      query: { redirect: to.fullPath }
    });
  }
  iView.LoadingBar.start();
  next();
});

router.afterEach(() => {
  iView.LoadingBar.finish();
  window.scrollTo(0, 0);
});

export default router;
