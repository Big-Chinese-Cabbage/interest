--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS email;

CREATE TABLE email (
  id integer IDENTITY primary key NOT NULL ,
  title varchar(100) ,
  email varchar(225) ,
  name varchar(50) ,
  content varchar(65536) NOT NULL ,
  createtime varchar(225) ,
  userid integer 
  ) ;

--
-- 兴趣表
--
DROP TABLE IF EXISTS interest;

CREATE TABLE interest (
                            id integer IDENTITY PRIMARY KEY NOT NULL,
                            title varchar(50) ,       --  标题
                            info varchar(1024) NOT NULL ,                  --  简介
                            content varchar(65536) NOT NULL,                --  内容
                            image varchar(225) ,      --  图片URL
                            sort integer ,               --  排序,
                            banner integer 
) ;

--
-- 消息记录表
--

DROP TABLE IF EXISTS msg_records;
CREATE TABLE msg_records (
                               id integer IDENTITY PRIMARY KEY NOT NULL ,
                               ownerid integer NOT NULL,             --  '帖子所有者id'
                               replyid integer NOT NULL,             --  '帖子回复者id
                               cardid integer NOT NULL,              --  '帖子id
                               replytime varchar(225)  , --  '回复时间'
                               isread integer               --  '是否已读(0:未读，1:已读)'
);

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details (
                                        client_id varchar(255) PRIMARY KEY NOT NULL,
                                        resource_ids varchar(255) ,
                                        client_secret varchar(255) ,
                                        scope varchar(255) ,
                                        authorized_grant_types varchar(255) ,
                                        web_server_redirect_uri varchar(255) ,
                                        authorities varchar(256) ,
                                        access_token_validity integer ,
                                        refresh_token_validity integer ,
                                        additional_information varchar(255) ,
                                        autoapprove varchar(255) 
);

--
-- 帖子表
--

DROP TABLE IF EXISTS post_card;
CREATE TABLE post_card (
                             id integer IDENTITY NOT NULL PRIMARY KEY,
                             title varchar(100)  ,         --   '标题'
                             content varchar(65536) NOT NULL,                    --  '内容'
                             interestid integer ,          --  '兴趣id'
                             createtime varchar(225) ,     --   '创建时间'
                             replytime varchar(225)  ,     --  '最新回复时间'
                             userid integer                --  '用户名'
) ;

--
-- '用户-角色关系表'
--

DROP TABLE IF EXISTS r_user_role;
CREATE TABLE r_user_role (
                           user_id integer NOT NULL ,            --'用户ID'
                           role_id integer NOT NULL ,            --  '角色ID'
                           PRIMARY KEY (user_id,role_id)
) ;

--
-- 回帖表
--

DROP TABLE IF EXISTS reply_card;
CREATE TABLE reply_card (
                              id integer IDENTITY PRIMARY KEY NOT NULL ,
                              content varchar(65536) NOT NULL ,               -- '内容'
                              postcardid integer ,      --  '帖子id'
                              createtime varchar(225) , --  '创建时间'
                              userid integer NOT NULL               --  '回复用户id'
);

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu (
                            id integer IDENTITY PRIMARY KEY NOT NULL ,
                            name varchar(50) ,      -- '菜单名',
                            url varchar(200) ,      -- 'url',
                            parent_id integer ,     -- '父类id',
                            sort integer ,          --  '排序',
                            remark varchar(1024),                        -- '描述',
                            icon varchar(30)        -- '图标'
);

--
-- 角色表
--

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
                            id integer IDENTITY PRIMARY KEY NOT NULL ,
                            role varchar(50) NOT NULL ,       -- '角色',
                            name varchar(50)  ,   -- '角色名',
                            modules varchar(1024) ,            -- '权限',
                            describe varchar(1024)             -- '描述'
);



--
-- 用户
--

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
                            id integer IDENTITY PRIMARY KEY NOT NULL ,
                            name varchar(50)  ,                 -- '姓名',
                            login_name varchar(50)  ,           -- '登录名',
                            password varchar(225)  ,            -- '密码',
                            email varchar(225)  ,               -- '邮箱',
                            usertype integer NOT NULL ,          -- '用户类型（0:普通用户，1:管理员）',
                            headimg varchar(225)  ,             -- '头像url',
                            url varchar(225)  ,                 -- 'GitHub主页',
                            create_time varchar(225)  ,         -- '注册时间',
                            githubid varchar(225)  ,            -- 'github的login',
                            qqid varchar(225)                  -- 'qq的openid',
  --  UNIQUE KEY `githubid_UNIQUE` (`githubid`),
  --  UNIQUE KEY `login_name_UNIQUE` (`login_name`),
  --  UNIQUE KEY `qqid_UNIQUE` (`qqid`)
);

--
-- github用户
--

DROP TABLE IF EXISTS user_github;
CREATE TABLE user_github (
                               login varchar(225) PRIMARY KEY NOT NULL ,        -- 'github用户名',
                               avatar_url varchar(225)  ,           -- '头像url',
                               html_url varchar(225)  ,             -- 'github主页',
                               email varchar(225)  ,                -- '邮箱',
                               userid integer                      -- '用户id'
);


--
-- qq用户
--

DROP TABLE IF EXISTS user_qq;
CREATE TABLE user_qq (
                           openid varchar(225) PRIMARY KEY NOT NULL ,            -- 'openid',
                           nickname varchar(225)  ,                  -- '用户名',
                           figureurl_qq_1 varchar(225)  ,            -- '头像url',
                           gender varchar(225)  ,                    -- '性别',
                           userid integer                           -- '用户id',
) ;



