import Vue from 'vue';
import VueRouter from 'vue-router';
import iView from 'iview';
import Util from './libs/util';

Vue.use(VueRouter);

const routers = [
	
	{
	    path: '/',
	    meta: {
	        title: 'smallsnail-wh'
	    },
	    component: (resolve) => require(['./views/index.vue'], resolve)
	},
	{
	    path: '/register',
	    meta: {
	        title: 'smallsnail-wh'
	    },
	    component: (resolve) => require(['./views/template/register.vue'], resolve)
	},
	{
	    path: '/page',
	    meta: {
	        title: 'smallsnail-wh'
	    },
	    component: (resolve) => require(['./views/template/index.vue'], resolve),
	    children: [
	    	{
	    		path: 'home',
                name: 'home',
                component: (resolve) => require(['./views/template/home.vue'], resolve),
                meta: {
                    title:"home"
                }
	    	},
	    	{
	    		path: 'home/:title',
                name: 'home2',
                component: (resolve) => require(['./views/template/home.vue'], resolve),
                meta: {
                    title:"home"
                }
	    	},
	    	{
	    		path: 'detail/:id',
                name: 'detail',
                component: (resolve) => require(['./views/template/detail.vue'], resolve),
                meta: {
                    title:"detail"
                }
	    	},
	    	{
	    		path: 'card/:id',
                name: 'card',
                component: (resolve) => require(['./views/template/card.vue'], resolve),
                meta: {
                    title:"card"
                }
	    	}
	    ]
	},
	{
	    path: '/base',
	    meta: {
	        title: 'base',
	        requiresAuth: true
	    },
	    component: (resolve) => require(['./views/base/base.vue'], resolve),
	    children: [
	    	{
	    		path: 'welcome',
                name: 'welcome',
                component: (resolve) => require(['./views/sys/welcome.vue'], resolve),
                meta: {
                    title:"welcome"
                }
	    	},
	    	{
	    		path: 'user',
                name: 'user',
                component: (resolve) => require(['./views/sys/user.vue'], resolve),
                meta: {
                    title:"user"
                }
	    	},
	    	{
	    		path: 'email',
                name: 'email',
                component: (resolve) => require(['./views/sys/email.vue'], resolve),
                meta: {
                    title:"email"
                }
	    	},
	    	{
	    		path: 'card',
                name: 'cardmanage',
                component: (resolve) => require(['./views/sys/card.vue'], resolve),
                meta: {
                    title:"card"
                }
	    	}
	    ]
	}
];
/*const routers = [
	{ 
		path: '*', 
		component: (resolve) => require(['./views/error404.vue'], resolve) 
	},
	{
	    path: '/',
	    meta: {
	        title: 'smallsnail-wh'
	    },
	    component: (resolve) => require(['./views/index.vue'], resolve)
	},
	{
	    path: '/index',
	    meta: {
	        title: 'smallsnail-wh'
	    },
	    component: (resolve) => require(['./views/index.vue'], resolve)
	},
	{
	    path: '/test',
	    meta: {
	        title: 'test'
	    },
	    component: (resolve) => require(['./views/test.vue'], resolve)
	},
	{
	    path: '/base',
	    meta: {
	        title: 'base',
	        requiresAuth: true
	    },
	    component: (resolve) => require(['./views/base/base.vue'], resolve),
	    children: [
	    	{
	    		path: 'welcome',
                name: 'welcome',
                component: (resolve) => require(['./views/sys/welcome.vue'], resolve),
                meta: {
                    title:"welcome"
                }
	    	},
	    	{
	    		path: 'user',
                name: 'user',
                component: (resolve) => require(['./views/sys/user.vue'], resolve),
                meta: {
                    title:"user"
                }
	    	},
	    	{
	    		path: 'menu',
                name: 'menu',
                component: (resolve) => require(['./views/sys/menu.vue'], resolve),
                meta: {
                    title:"menu"
                }
	    	},
	    	{
	    		path: 'role',
                name: 'role',
                component: (resolve) => require(['./views/sys/role.vue'], resolve),
                meta: {
                    title:"role"
                }
	    	},
	    	{
	    		path: 'test4',
                name: 'test4',
                component: (resolve) => require(['./views/test/test4.vue'], resolve),
                meta: {
                    title:"test4"
                }
	    	},
	    	{
	    		path: 'test5',
                name: 'test5',
                component: (resolve) => require(['./views/test/test5.vue'], resolve),
                meta: {
                    title:"test5"
                }
	    	},
	    	{
	    		path: 'test6',
                name: 'test6',
                component: (resolve) => require(['./views/test/test6.vue'], resolve),
                meta: {
                    title:"test6"
                }
	    	},
	    ]
	}
];*/

// 路由配置
const RouterConfig = {
    mode: 'history',
    routes: routers
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    let token = window.localStorage.getItem('currentUser_token')
    if (to.matched.some(record => record.meta.requiresAuth) && (!token || token === null)) {
        next({
          path: '/',
          query: { redirect: to.fullPath }
        })
    }/* else {
        next()
        console.log("next");
    }*/
    iView.LoadingBar.start();
    Util.title(to.meta.title);
    next();
});

router.afterEach(() => {
    iView.LoadingBar.finish();
    window.scrollTo(0, 0);
});

export default router;