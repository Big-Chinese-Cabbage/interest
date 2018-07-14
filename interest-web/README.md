# interest-web

项目介绍
--
vue.js+node.js+webpack构建的前端项目，后端用的是项目[interest-server](https://github.com/smallsnail-wh/interest/tree/master/interest-server)（前后端分离）。

项目展示
--
地址：http://www.lovemtt.com/ 
可使用github登录
（第一次打开可能会有点慢）

技术栈
--
 - vue2
 - vuex
 - vue-router
 - axios
 - [iview](https://www.iviewui.com/)
 - [vue-quill-editor](https://github.com/surmon-china/vue-quill-editor)
 - webpack

前后端通信：
------
	使用的是axios库。

UI 组件库：
-------
	使用了iview组件库。

安全协议：
-----
	oauth2

前端界面开发
--
注：需要安装nodejs
	

 - 启动：
	 1. 命令行进入项目文件夹
	 2. 运行npm install
	 3. 运行npm run init初始化项目
	 4. 运行npm run dev启动前端工程
- 打包命令：
	运行npm run build
	
Http状态码
--
	在axios.js中拦截异常，并进行处理。
	目前以写的异常处理有：
		1. 401 清除token信息并跳转到登录页面
		2. 403 无权限，跳转到首页
如果你项目启动有错误：
--
1. 项目启动报错，请试一下用管理员权限输入命令。
