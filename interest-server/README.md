# interest-server

## 项目版本升级

1. spring boot 2.0.0.M5 --> spring boot 2.0.0.M7
2. spring security 4 --> spring security 5
3. 用户token信息，从内存存储变为redis存储
4. 客户的详细资料由手动在MyAuthorizationServerConfigurerAdapter中配置的，改为使用数据库配置（添加了oauth_client_details表）
5. 用户密码加密由md5加密改为BCrypt加密
6. 打包方式jar

## 项目介绍

spring boot项目,与我的另外一个前端项目[interest-web](https://github.com/smallsnail-wh/interest/tree/master/interest-web)搭配（前后端分离）。

## 项目展示

地址：http://www.lovemtt.com/
可使用github登录
（第一次打开可能会有点慢）

项目目录结构
--
```shell
.
└── src
    ├── main  
    │	├── java  
    │	│   └── com.interest 
    │	│	├── controller  controller类
    │	│	├── dao  dao类
    │	│	├── model  entity类
    │	│	├── oauth2  spring security oauth2配置类
    │	│	├── properties  项目配置类
    │	│	├── security  spring security配置类
    │	│	├── service  service类
    │	│	└── utils  工具类
    │	└── resource  
    │	    ├── createTable 表数结构及表数据
    │	    ├── mybatis.mapper mybatis的mapper.xml
    │	    └── application.yml 项目配置文件
    └── test  测试
```

## 技术栈

 - spring boot
 - mybatis
 - Spring Security
 - Spring Security OAuth2
 - Redis

## 接口设计：

	RESTful

## 认证与授权：

	使用了Spring Security OAuth2

## 数据库：

使用mysql。（表与表数据在interest-server\src\main\resources\createTable中,用户密码为BCrypt加密，用户admin的密码为admin）

**设计思路** 

 1. 用户表sys_user：存储用户基本信息。
 2. 角色表sys_role：存储不同的角色。
 3. 菜单表sys_menu：存储菜单信息。
 4. 用户和角色关系表r_user_role：存储用户和角色的关系。 
逻辑是sys_user表通过id关联r_user_role表得到对应的角色ids，再通过得到的角色ids关联sys_role表得到对应的菜单ids，然后通过菜单ids关联sys_menu表得到前端需要显示的菜单数据。

## 项目搭建

**运行环境：**

  jdk1.8+maven。
  
 **数据库配置：**
 
 数据库mysql（表与表数据在interest-server\src\main\resources\createTable中,用户密码为BCrypt加密，用户admin的密码为admin） 
 
 **缓存配置：** 
 
  配置redis，且redis服务必须开启。
 
## 注：

 1. 此后端是授权服务和资源服务在一个项目中，建议将授权服务和资源服务分离成2个项目。
 2. 如果你想采用上述建议，但是无从下手，请在我的github中留言。
 
 ## 如果你项目启动有错误：
 
 1. 检查数据库是否配置好。（表与表数据在wh-server\src\main\resources\createTable中,用户密码为BCrypt加密，用户admin的密码为admin）
 2. 检查redis是否配置好，redis服务必须开启（检查防火墙是否打开）
 		
