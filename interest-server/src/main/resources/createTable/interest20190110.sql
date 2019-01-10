-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: interest
-- ------------------------------------------------------
-- Server version	5.6.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `email` varchar(225) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `content` text NOT NULL COMMENT '内容',
  `createtime` varchar(225) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_name` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='email';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (1,'123','213@qq.com','123','123','1531102263781',1),(2,'123','123@qq.com','123','123','1542349945304',12);
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interest`
--

DROP TABLE IF EXISTS `interest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interest` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `info` text NOT NULL COMMENT '简介',
  `content` text NOT NULL COMMENT '内容',
  `image` varchar(225) DEFAULT NULL COMMENT '图片url',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `banner` int(1) DEFAULT '0' COMMENT '是否加入轮播（0:不加入，1:加入）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='兴趣表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interest`
--

LOCK TABLES `interest` WRITE;
/*!40000 ALTER TABLE `interest` DISABLE KEYS */;
INSERT INTO `interest` VALUES (1,'动漫','一起畅游二次元世界。','<p>&nbsp;&nbsp;&nbsp;<img src=\"http://photo.16pic.com/00/52/03/16pic_5203018_b.jpg\" style=\"display: block; margin: auto;\"></p><p><br></p><h2 class=\"ql-indent-1\"><span class=\"ql-size-large\"> </span>			<span class=\"ql-size-large ql-font-serif\">日本动漫,是日本动画和日本漫画的合称。日本动漫基本上不如美国动画特效那么炫目, 但是凭着剧情的创新和趣味性在全球都有很重要的地位,拥有了广大的收看人群。日本是世界第一大动漫强国。其动画发展的模式具有鲜明的民族特色。比如漫画里近乎逼真的亚洲人的美和各种鲜明特色的文化影子。这些都是其他国家动漫忘尘莫及的</span><span class=\"ql-size-large\">。</span></h2>','http://photo.16pic.com/00/52/03/16pic_5203018_b.jpg',1,1),(2,'汉服','正礼仪于中华 存衣冠于华夏','<p><em>&nbsp;&nbsp;&nbsp;汉服，全称是“汉民族传统服饰”，又称汉衣冠、汉装、华服，是从黄帝即位到公元17世纪中叶（明末清初），在汉族的主要居住区，以“华夏－汉”文化为背景和主导思想，以华夏礼仪文化为中心，通过自然演化而形成的具有独特汉民族风貌性格，明显区别于其他民族的传统服装和配饰体系，是中国“衣冠上国”、“礼仪之邦”、“锦绣中华”、赛里斯国的体现，承载了汉族的染织绣等杰出工艺和美学，传承了30多项中国非物质文化遗产以及受保护的中国工艺美术。</em></p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531238674678&di=ac3fc5c5d880c23ef3f8a1219d08fb67&imgtype=0&src=http%3A%2F%2Fatt.bbs.duowan.com%2Fforum%2F201707%2F23%2F190138pwzurpp0uzieuu0r.jpg',2,1),(3,'滑板','有胆你就来 这是和生命的较量','<p><strong>&nbsp;&nbsp;&nbsp;滑板Skateboard项目可谓是极限运动历史的鼻祖，许多的极限运动项目均由滑板项目延伸而来。20世纪50年代末60年代初由冲浪运动演变而成的滑板运动，在而今已成为地球上最“酷”的运动。滑板运动以滑行为特色，崇尚自由的运动方式，体验与创造超重力的感受，给滑者带来成功和创造的喜悦。滑板运动不同于传统运动项目，不拘泥于固定的模式，需要滑手自由发挥想象力，在运动过程中创造，以创造力来运动，强调身心的自由，推崇与自然互相融合的运动理念。</strong></p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531238779845&di=2c92621c209c107d5d999dddf38a62be&imgtype=0&src=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20150903%2Ftooopen_sy_141167247975.jpg',3,1),(4,'吉他','不如学一学吉他 它懂你的孤独','<p>&nbsp;&nbsp;&nbsp;新的一天。阳光温暖。我的心也应该是温暖的。如若可以。在午后，约上几个志同道合的人，一起带着吉他，到一个安静的田野中弹起吉他唱起歌。或者，一个人背着吉他去不远处的山坡上弹个小曲唱个小调，也是一件幸福的事情。大自然会给你愈伤的力量。有时候真有抛却现实的繁杂，背上一把吉他，浪迹天涯的冲动。也许每一个弹吉他爱摇滚的孩子都有这样一种理想主义的悲壮情怀。</p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531238896141&di=880a3bc620e4ce4eb362903473b67a87&imgtype=0&src=http%3A%2F%2Fimg.gsxservice.com%2F1645166_x83xnzjf.jpeg',4,1),(7,'舞蹈','每个不曾起舞的日子都是对生命的辜负','<p>&nbsp;&nbsp;&nbsp;<span style=\"background-color: white;\">舞人从容而舞，形舒意广。她的心遨游在无垠的太空，自由地远思长想。开始的动作，像是俯身，又像是仰望；像是来、又像是往。是那样的雍容不迫，又是那么不已的惆怅，实难用语言来形象。接着舞下去，像是飞翔，又像步行；像是辣立，又像斜倾。不经意的动作也决不失法度，手眼身法都应着鼓声。纤细的罗衣从风飘舞，缭绕的长袖左右交横。络绎不绝的姿态飞舞散开，曲折的身段手脚合并。</span></p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531834053&di=0f3964dd5bf8e3a701e72a85bb799441&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F81%2F88%2F565541a818c65_1024.jpg',7,1),(8,'test','test','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190108/58dd0742-65fd-4fc4-8e30-0e8825f62b83.jpg\" width=\"344\" style=\"display: block; margin: auto; cursor: nesw-resize;\"><span class=\"ql-size-huge\" style=\"color: rgb(230, 0, 0);\">﻿this is test!a12dasdqaaw</span></p>','http://127.0.0.1:8080/interest/interest/20190108/93b58b7d-ea60-4e3a-a710-afcecef08ff2.jpg',0,0),(9,'test2','123123123','<p>123123eqrwwe</p><p><img src=\"http://127.0.0.1:8080/interest/interest/20190108/c4d067e3-8a98-4421-b394-7823f4cd4241.jpg\" width=\"105\" style=\"cursor: nwse-resize;\"></p>','http://127.0.0.1:8080/interest/interest/20190108/f9436a71-4c1e-4262-9c90-d86250c4ffe8.jpg',0,0);
/*!40000 ALTER TABLE `interest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_records`
--

DROP TABLE IF EXISTS `msg_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg_records` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ownerid` int(10) NOT NULL COMMENT '帖子所有者id',
  `replyid` int(10) NOT NULL COMMENT '帖子回复者id',
  `cardid` int(10) NOT NULL COMMENT '帖子id',
  `replytime` varchar(225) DEFAULT NULL COMMENT '回复时间',
  `isread` int(1) DEFAULT '0' COMMENT '是否已读(0:未读，1:已读)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='消息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_records`
--

LOCK TABLES `msg_records` WRITE;
/*!40000 ALTER TABLE `msg_records` DISABLE KEYS */;
INSERT INTO `msg_records` VALUES (39,1,40,38,'1542351639169',1),(40,1,49,43,'1542619140358',1),(41,12,50,33,'1542766744191',0),(42,1,51,44,'1542766809118',1),(43,1,52,44,'1546916527792',0),(44,1,53,48,'1547020444285',0),(45,1,54,48,'1547020446913',0),(46,1,55,48,'1547023603054',0);
/*!40000 ALTER TABLE `msg_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(255) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_details`
--

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` VALUES ('client',NULL,'{noop}secret','all','password,authorization_code,refresh_token,implicit,client_credentials',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_card`
--

DROP TABLE IF EXISTS `post_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_card` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `interestid` int(10) DEFAULT NULL COMMENT '兴趣id',
  `createtime` varchar(225) DEFAULT NULL COMMENT '创建时间',
  `replytime` varchar(225) DEFAULT NULL COMMENT '最新回复时间',
  `userid` int(10) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='帖子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_card`
--

LOCK TABLES `post_card` WRITE;
/*!40000 ALTER TABLE `post_card` DISABLE KEYS */;
INSERT INTO `post_card` VALUES (33,'你喜欢看什么动漫？','你喜欢看什么动漫？',1,'1527145330752','1542766744184',12),(34,'你觉得火影忍者这部动漫怎么样？','你觉得火影忍者这部动漫怎么样？',1,'1527145682685','1527210959322',NULL),(38,'汉服怎么样？','汉服怎么样？',2,'1527150545468','1527150554251',NULL),(39,'123','eqwsadsad',1,'1542350790861','1542350790861',12),(40,'123','eqwsadsad',1,'1542350799902','1542350799902',12),(41,'qweqw','eqwsadsad',1,'1542351639169','1542351639169',12),(42,'qweqw','eqwsadsad',1,'1542351661315','1542351661315',12),(43,'qeq','qweq',1,'1542595552839','1542619140350',1),(44,'qwe','qweqweqwe',1,'1542766755374','1546916527786',1),(46,'qw','qwe',9,'1546958289758','1546958289758',1),(47,'niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho','niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho',8,'1547019958239','1547019958239',1),(48,'niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho','niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho',8,'1547019969114','1547023603048',1);
/*!40000 ALTER TABLE `post_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_user_role`
--

DROP TABLE IF EXISTS `r_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_user_role` (
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `role_id` int(10) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_user_role`
--

LOCK TABLES `r_user_role` WRITE;
/*!40000 ALTER TABLE `r_user_role` DISABLE KEYS */;
INSERT INTO `r_user_role` VALUES (1,1);
/*!40000 ALTER TABLE `r_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply_card`
--

DROP TABLE IF EXISTS `reply_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply_card` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` text NOT NULL COMMENT '内容',
  `postcardid` int(10) DEFAULT NULL COMMENT '帖子id',
  `createtime` varchar(225) DEFAULT NULL COMMENT '创建时间',
  `userid` int(10) NOT NULL COMMENT '回复用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='回帖表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply_card`
--

LOCK TABLES `reply_card` WRITE;
/*!40000 ALTER TABLE `reply_card` DISABLE KEYS */;
INSERT INTO `reply_card` VALUES (32,'我喜欢看海贼王。',33,'1527145732382',1),(40,'很好看',38,'1527150554251',12),(41,'我喜欢漩涡鸣人。',34,'1527210804774',12),(42,'喜欢佐助，佐助太帅了。',34,'1527210846847',12),(43,'火影忍者打斗场面好看',34,'1527210893468',12),(44,'喜欢这个结局，大圆满。',34,'1527210959322',12),(45,' 死神',33,'1527211842627',12),(46,'一拳超人',33,'1527217127806',12),(47,'qweqwfasf',33,'1542353287205',12),(48,'qweqweqwfqw',43,'1542595559454',1),(49,'123123',43,'1542619140350',1),(50,'qweqwe',33,'1542766744184',1),(51,'hello',44,'1542766809112',1),(52,'123',44,'1546916527786',1),(53,'niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho',48,'1547020444275',12),(54,'niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho',48,'1547020446905',1),(55,'qwe',48,'1547023603048',1);
/*!40000 ALTER TABLE `reply_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名',
  `url` varchar(200) DEFAULT NULL COMMENT 'url',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类id',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `remark` text COMMENT '描述',
  `icon` varchar(30) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='系统菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',' ',0,1,NULL,'md-settings'),(2,'轮播管理',' ',0,2,NULL,'logo-snapchat'),(3,'兴趣管理',' ',0,3,NULL,'logo-reddit'),(4,'发帖管理',' ',0,4,NULL,'md-chatboxes'),(5,'邮件管理',' ',0,5,NULL,'ios-mail'),(6,'用户管理','/base/user',1,1,NULL,'ios-person'),(7,'菜单管理','/base/menu',1,2,NULL,'md-list-box'),(8,'角色管理','/base/role',1,3,NULL,'ios-people'),(9,'轮播','/base/banner',2,1,NULL,'logo-snapchat'),(10,'新建','/base/i-create',3,1,NULL,'md-checkmark-circle'),(11,'修改','/base/i-edit',3,2,NULL,'md-create'),(12,'删除','/base/i-delete',3,3,NULL,'md-remove-circle'),(13,'发帖管理','/base/card',4,1,NULL,'ios-create-outline'),(14,'邮件','/base/email',5,1,NULL,'ios-mail');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role` varchar(50) NOT NULL COMMENT '角色',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `modules` text COMMENT '权限',
  `describe` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'ROLE_ADMIN','超级管理员','4;5;6;7;8;9;10;11;14;1;12;13;','超级管理员，拥有全部权限。');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(225) DEFAULT NULL COMMENT '密码',
  `email` varchar(225) DEFAULT NULL COMMENT '邮箱',
  `usertype` int(1) NOT NULL DEFAULT '0' COMMENT '用户类型（0:普通用户，1:管理员）',
  `headimg` varchar(225) DEFAULT NULL COMMENT '头像url',
  `url` varchar(225) DEFAULT NULL COMMENT 'GitHub主页',
  `create_time` varchar(225) DEFAULT NULL COMMENT '注册时间',
  `githubid` varchar(225) DEFAULT NULL COMMENT 'github的login',
  `qqid` varchar(225) DEFAULT NULL COMMENT 'qq的openid',
  PRIMARY KEY (`id`),
  UNIQUE KEY `githubid_UNIQUE` (`githubid`),
  UNIQUE KEY `login_name_UNIQUE` (`login_name`),
  UNIQUE KEY `qqid_UNIQUE` (`qqid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'管理员管理员管理员','admin','{bcrypt}$2a$10$D8E4cuanLviCCe/ASqBC7OZ84JYOH8IT4/y4JLAV/Pm/AdhzPcy2.','123456@qq.com',1,'http://thirdqq.qlogo.cn/qqapp/101512648/1C47A2C639D3A89E573AC2BF46FBEF63/40','http://www.lovemtt.com','1531704654140',NULL,NULL),(12,'smallsnail-wh',NULL,NULL,'null',0,'https://avatars2.githubusercontent.com/u/30545965?v=4','https://github.com/smallsnail-wh','1542463692126','smallsnail-wh',NULL),(13,'树根',NULL,NULL,NULL,0,'http://thirdqq.qlogo.cn/qqapp/101512648/1C47A2C639D3A89E573AC2BF46FBEF63/40',NULL,'1542463259014',NULL,'1C47A2C639D3A89E573AC2BF46FBEF63');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_github`
--

DROP TABLE IF EXISTS `user_github`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_github` (
  `login` varchar(225) NOT NULL COMMENT 'github用户名',
  `avatar_url` varchar(225) DEFAULT NULL COMMENT '头像url',
  `html_url` varchar(225) DEFAULT NULL COMMENT 'github主页',
  `email` varchar(225) DEFAULT NULL COMMENT '邮箱',
  `userid` int(10) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='github用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_github`
--

LOCK TABLES `user_github` WRITE;
/*!40000 ALTER TABLE `user_github` DISABLE KEYS */;
INSERT INTO `user_github` VALUES ('smallsnail-wh','https://avatars2.githubusercontent.com/u/30545965?v=4','https://github.com/smallsnail-wh','null',12);
/*!40000 ALTER TABLE `user_github` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_qq`
--

DROP TABLE IF EXISTS `user_qq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_qq` (
  `openid` varchar(225) NOT NULL COMMENT 'openid',
  `nickname` varchar(225) DEFAULT NULL COMMENT '用户名',
  `figureurl_qq_1` varchar(225) DEFAULT NULL COMMENT '头像url',
  `gender` varchar(225) DEFAULT NULL COMMENT '性别',
  `userid` int(10) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='qq用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_qq`
--

LOCK TABLES `user_qq` WRITE;
/*!40000 ALTER TABLE `user_qq` DISABLE KEYS */;
INSERT INTO `user_qq` VALUES ('1C47A2C639D3A89E573AC2BF46FBEF63','树根','http://thirdqq.qlogo.cn/qqapp/101512648/1C47A2C639D3A89E573AC2BF46FBEF63/40','男',13);
/*!40000 ALTER TABLE `user_qq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-10 14:49:43
