-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 123.206.215.203    Database: interest_test
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `info` text NOT NULL COMMENT '简介',
  `content` longtext NOT NULL COMMENT '内容',
  `click_rate` int(11) DEFAULT '0' COMMENT '点击量',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论量',
  `top` int(1) DEFAULT '0' COMMENT '置顶（0:不置顶，1:置顶）',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `reply_time` varchar(255) DEFAULT NULL COMMENT '最新回复时间',
  `userid` int(11) NOT NULL COMMENT '创建人id',
  `del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除（0:启用，1:删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'123456787654231345677654333543232543123123eqwdasdqwe1312','123456787654231345677654333543232543123123eqwdasdqwe1312123456787654231345677654333543232543123123eqwdasdqwe1312123456787654231345677654333543232543123123eqwdasdqwe1312qwewdasdas','<p>123456787654231345677654333543232543123123eqwdasdqwe1312123456787654231345677654333543232543123123eqwdasdqwe1312123456787654231345677654333543232543123123eqwdasdqwe1312<img src=\"http://127.0.0.1:8080/interest/interest/20190213/730f121c-e1a5-4e9b-bc23-e5fafb7d6dbd.png\"></p><p>qwewdasdas</p><p><img src=\"http://127.0.0.1:8080/interest/interest/20190213/47eeea43-47bc-4140-927a-66748086f270.png\"></p>',254,34,1,'1550047563194','1550047563194',1,0),(2,'this is test20190227-001','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(3,'124','123','<p>123</p>',1,0,0,'1550071607008','1550071607008',1,0),(4,'123','123123','<p>123</p><p><img src=\"http://127.0.0.1:8080/interest/interest/20190227/d085e739-5a26-4ea0-88e7-f692171f68cf.png\"></p><p>123</p>',8,0,0,'1550073274316','1550073274316',1,0),(5,'123','123','<h2 class=\"ql-align-center\">123</h2><p><img src=\"http://127.0.0.1:8080/interest/interest/20190227/a70929ab-2923-48be-ab59-cca0ceeb96ea.png\" width=\"596\" style=\"display: block; margin: auto;\"></p>',52,17,0,'1550074630191','1550074630191',1,1),(6,'20190222测试','20190222测试20190222测试20190222测试20190222测试20190222测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190222/444e06bb-1912-4f91-8219-e415bf00ee5b.png\">20190222测试20190222测试20190222测试20190222测试20190222测试<img src=\"http://127.0.0.1:8080/interest/interest/20190222/2341636a-be5f-4582-a3fb-561767a76484.png\" width=\"1280\" style=\"display: block; margin: auto;\"></p><h2>这是测试这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2><br></h2>',32,13,0,'1550800259508','1550800259508',12,0),(7,'20190222测试1','20190222测试20190222测试20190222测试20190222测试20190222测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190222/444e06bb-1912-4f91-8219-e415bf00ee5b.png\">20190222测试20190222测试20190222测试20190222测试20190222测试<img src=\"http://127.0.0.1:8080/interest/interest/20190222/2341636a-be5f-4582-a3fb-561767a76484.png\" width=\"1280\" style=\"display: block; margin: auto;\"></p><h2>这是测试这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2><br></h2>',24,13,0,'1550800259508','1550800259508',12,0),(8,'20190222测试2','20190222测试20190222测试20190222测试20190222测试20190222测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190222/444e06bb-1912-4f91-8219-e415bf00ee5b.png\">20190222测试20190222测试20190222测试20190222测试20190222测试<img src=\"http://127.0.0.1:8080/interest/interest/20190222/2341636a-be5f-4582-a3fb-561767a76484.png\" width=\"1280\" style=\"display: block; margin: auto;\"></p><h2>这是测试这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2><br></h2>',24,13,0,'1550800259508','1550800259508',12,0),(9,'20190222测试3','20190222测试20190222测试20190222测试20190222测试20190222测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190222/444e06bb-1912-4f91-8219-e415bf00ee5b.png\">20190222测试20190222测试20190222测试20190222测试20190222测试<img src=\"http://127.0.0.1:8080/interest/interest/20190222/2341636a-be5f-4582-a3fb-561767a76484.png\" width=\"1280\" style=\"display: block; margin: auto;\"></p><h2>这是测试这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2><br></h2>',24,13,0,'1550800259508','1550800259508',12,0),(10,'20190222测试4','20190222测试20190222测试20190222测试20190222测试20190222测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190222/444e06bb-1912-4f91-8219-e415bf00ee5b.png\">20190222测试20190222测试20190222测试20190222测试20190222测试<img src=\"http://127.0.0.1:8080/interest/interest/20190222/2341636a-be5f-4582-a3fb-561767a76484.png\" width=\"1280\" style=\"display: block; margin: auto;\"></p><h2>这是测试这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2><br></h2>',26,13,0,'1550800259508','1550800259508',12,0),(11,'20190222测试5','20190222测试20190222测试20190222测试20190222测试20190222测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190222/444e06bb-1912-4f91-8219-e415bf00ee5b.png\">20190222测试20190222测试20190222测试20190222测试20190222测试<img src=\"http://127.0.0.1:8080/interest/interest/20190222/2341636a-be5f-4582-a3fb-561767a76484.png\" width=\"1280\" style=\"display: block; margin: auto;\"></p><h2>这是测试这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2><br></h2>',28,13,0,'1550800259508','1550800259508',12,0),(12,'20190222测试6','20190222测试20190222测试20190222测试20190222测试20190222测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试这是测试','<p><img src=\"http://127.0.0.1:8080/interest/interest/20190222/444e06bb-1912-4f91-8219-e415bf00ee5b.png\">20190222测试20190222测试20190222测试20190222测试20190222测试<img src=\"http://127.0.0.1:8080/interest/interest/20190222/2341636a-be5f-4582-a3fb-561767a76484.png\" width=\"1280\" style=\"display: block; margin: auto;\"></p><h2>这是测试这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2>这是测试</h2><h2><br></h2>',27,13,0,'1550800259508','1550800259508',12,0),(13,'12345','qewr','<p>qewr</p>',6,1,0,'1551282924734','1551282924734',1,0),(14,'this is test20190227-002','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(15,'this is test20190227-003','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(16,'this is test20190227-004','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(17,'this is test20190227-005','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(18,'this is test20190227-006','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(19,'this is test20190227-007','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(20,'this is test20190227-008','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(21,'this is test20190227-009','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(22,'this is test20190227-010','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(23,'this is test20190227-011','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',20,2,0,'1550050417080','1550050417080',1,0),(24,'this is test20190227-012','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(25,'this is test20190227-013','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(26,'this is test20190227-014','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(27,'this is test20190227-015','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(28,'this is test20190227-016','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(29,'this is test20190227-017','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(30,'this is test20190227-018','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0),(31,'this is test20190227-019','你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你','<p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀<img src=\"http://127.0.0.1:8080/interest/interest/20190213/b06f3265-51bd-4c2b-95f0-882d5dbe1580.png\"></p><p>你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀你好呀</p>',19,2,0,'1550050417080','1550050417080',1,0);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment`
--

DROP TABLE IF EXISTS `article_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `articleid` int(11) NOT NULL COMMENT '文章id',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `parentid` int(11) DEFAULT NULL COMMENT '父级id',
  `comment` text COMMENT '评论',
  `replier_id` int(11) DEFAULT NULL COMMENT '回复评论人id',
  `replier_name` varchar(255) DEFAULT NULL COMMENT '回复评论人的姓名',
  `create_time` varchar(255) DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='文章评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment`
--

LOCK TABLES `article_comment` WRITE;
/*!40000 ALTER TABLE `article_comment` DISABLE KEYS */;
INSERT INTO `article_comment` VALUES (1,1,1,NULL,'这是测试1',NULL,NULL,'1550245192386'),(2,1,1,1,'这是测试2',1,'管理员','1550245263327'),(3,2,12,NULL,'这是测试3',NULL,NULL,'1550245192386'),(4,1,12,NULL,'这是测试4',NULL,NULL,'1550245192386'),(5,1,12,1,'这是测试5',1,'管理员','1550245192386'),(6,1,1,1,'这是测试6',1,'管理员','1550248899264'),(7,1,1,1,'这是测试7',1,'管理员','1550248991887'),(8,1,1,1,'这是测试9',1,'管理员','1550248997769'),(9,1,1,NULL,'qwe',NULL,NULL,'1550752687507'),(10,1,1,NULL,'q',NULL,NULL,'1550752724236'),(11,1,1,NULL,'w',NULL,NULL,'1550752773227'),(12,1,1,NULL,'e',NULL,NULL,'1550752810355'),(13,1,1,NULL,'er',NULL,NULL,'1550752814128'),(14,1,1,NULL,'ert',NULL,NULL,'1550752816098'),(15,1,1,NULL,'erty',NULL,NULL,'1550752827585'),(16,1,1,NULL,'ertyu',NULL,NULL,'1550752831096'),(17,1,1,NULL,'ertyui',NULL,NULL,'1550752832845'),(18,1,1,NULL,'ertyuio',NULL,NULL,'1550752834517'),(19,1,1,18,NULL,1,'管理员','1550755754962'),(20,1,1,4,NULL,12,'smallsnail-wh','1550755772374'),(21,1,1,4,NULL,1,'管理员','1550755781596'),(22,1,1,NULL,'[reply]管理员[]/reply]\nqw',NULL,NULL,'1550755798078'),(23,1,1,22,NULL,1,'管理员','1550755811897'),(24,1,1,22,NULL,1,'管理员','1550755814981'),(25,1,1,22,NULL,1,'管理员','1550755816981'),(26,1,1,22,']\nqwe',1,'管理员','1550756168240'),(27,1,1,22,']\nqwegfg',1,'管理员','1550756192944'),(28,1,1,1,']\nda',12,'smallsnail-wh','1550756260315'),(29,1,1,NULL,'[reply]smallsnail-wh[/reply\nda',NULL,NULL,'1550756296740'),(30,1,1,NULL,'[reply]smallsnail-wh[/reply\ndaasdasd',NULL,NULL,'1550756310687'),(31,1,1,NULL,'[reply]管理员[/reply\ndasd',NULL,NULL,'1550756328237'),(32,1,12,31,']\neqweq',1,'管理员','1550756365781'),(33,1,12,31,'\nasfasdfasfasfsa',1,'管理员','1550756398026'),(34,1,12,NULL,'afsd',NULL,NULL,'1550756462115'),(35,1,12,NULL,'[reply]smallsnail-wh[/reply\nasdasd',NULL,NULL,'1550756471053'),(36,1,12,35,'\nxczvsdafa',12,'smallsnail-wh','1550756477465'),(37,1,12,35,'你好',12,'smallsnail-wh','1550756491585'),(38,6,12,NULL,'第1个评论',NULL,NULL,'1550800283926'),(39,6,1,NULL,'第2个评论',NULL,NULL,'1550800313358'),(40,6,1,38,'\n你好',12,'smallsnail-wh','1550800334410'),(41,6,1,NULL,'第3个评论',NULL,NULL,'1550800355883'),(42,6,1,NULL,'第4个评论',NULL,NULL,'1550800361537'),(43,6,1,NULL,'第5个评论',NULL,NULL,'1550800369294'),(44,6,1,NULL,'第6个评论',NULL,NULL,'1550800373280'),(45,6,1,NULL,'第7个评论',NULL,NULL,'1550800377563'),(46,6,1,NULL,'第8个评论',NULL,NULL,'1550800381678'),(47,6,1,NULL,'第9个评论',NULL,NULL,'1550800387683'),(48,6,1,NULL,'第10个评论',NULL,NULL,'1550800392581'),(49,6,1,NULL,'第11个评论',NULL,NULL,'1550800396595'),(50,2,1,NULL,'q w',NULL,NULL,'1551020450567'),(51,2,1,50,'\nw q',1,'管理员','1551020454871'),(52,6,1,49,'\nsafsd',1,'管理员','1551057950433'),(53,5,1,NULL,'fasdf',NULL,NULL,'1551058273958'),(54,5,12,NULL,'测试6',NULL,NULL,'1551148522420'),(55,5,12,NULL,'测试7',NULL,NULL,'1551148530357'),(56,5,12,NULL,'测试8',NULL,NULL,'1551148649201'),(57,5,12,NULL,'测试9',NULL,NULL,'1551148698584'),(58,5,12,NULL,'测试9',NULL,NULL,'1551148706804'),(59,5,12,NULL,'测试10',NULL,NULL,'1551148711639'),(60,5,12,NULL,'测试11',NULL,NULL,'1551149099676'),(61,5,12,NULL,'测试12',NULL,NULL,'1551149104644'),(62,5,12,61,'\n测试13',12,'smallsnail-wh','1551149126022'),(63,5,12,61,'\n测试14',12,'smallsnail-wh','1551149130440'),(64,5,12,60,'\n测试15',12,'smallsnail-wh','1551149134541'),(65,5,12,NULL,'测试13',NULL,NULL,'1551159683118'),(66,5,12,65,'\n测试14',12,'smallsnail-wh','1551159691355'),(67,5,12,65,'\n测试15',12,'smallsnail-wh','1551159699833'),(68,5,12,NULL,'qwe',NULL,NULL,'1551160197584'),(69,5,12,68,'\n测试14',12,'smallsnail-wh','1551160208500'),(70,13,1,NULL,'qwe',NULL,NULL,'1551282935448');
/*!40000 ALTER TABLE `article_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `content` text NOT NULL COMMENT '内容',
  `createtime` varchar(255) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_name` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='email';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (1,'123','213@qq.com','123','123','1531102263781',1);
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interest`
--

DROP TABLE IF EXISTS `interest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interest` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `info` text NOT NULL COMMENT '简介',
  `content` text NOT NULL COMMENT '内容',
  `image` varchar(255) DEFAULT NULL COMMENT '图片url',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `banner` int(1) DEFAULT '0' COMMENT '是否加入轮播（0:不加入，1:加入）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='兴趣表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interest`
--

LOCK TABLES `interest` WRITE;
/*!40000 ALTER TABLE `interest` DISABLE KEYS */;
INSERT INTO `interest` VALUES (1,'动漫','一起畅游二次元世界。','<p>&nbsp;&nbsp;&nbsp;<img src=\"http://photo.16pic.com/00/52/03/16pic_5203018_b.jpg\" style=\"display: block; margin: auto;\"></p><p><br></p><h2 class=\"ql-indent-1\"><span class=\"ql-size-large\"> </span>			<span class=\"ql-size-large ql-font-serif\">日本动漫,是日本动画和日本漫画的合称。日本动漫基本上不如美国动画特效那么炫目, 但是凭着剧情的创新和趣味性在全球都有很重要的地位,拥有了广大的收看人群。日本是世界第一大动漫强国。其动画发展的模式具有鲜明的民族特色。比如漫画里近乎逼真的亚洲人的美和各种鲜明特色的文化影子。这些都是其他国家动漫忘尘莫及的</span><span class=\"ql-size-large\">。</span></h2>','http://photo.16pic.com/00/52/03/16pic_5203018_b.jpg',1,1),(2,'汉服','正礼仪于中华 存衣冠于华夏','<p><em>&nbsp;&nbsp;&nbsp;汉服，全称是“汉民族传统服饰”，又称汉衣冠、汉装、华服，是从黄帝即位到公元17世纪中叶（明末清初），在汉族的主要居住区，以“华夏－汉”文化为背景和主导思想，以华夏礼仪文化为中心，通过自然演化而形成的具有独特汉民族风貌性格，明显区别于其他民族的传统服装和配饰体系，是中国“衣冠上国”、“礼仪之邦”、“锦绣中华”、赛里斯国的体现，承载了汉族的染织绣等杰出工艺和美学，传承了30多项中国非物质文化遗产以及受保护的中国工艺美术。</em></p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531238674678&di=ac3fc5c5d880c23ef3f8a1219d08fb67&imgtype=0&src=http%3A%2F%2Fatt.bbs.duowan.com%2Fforum%2F201707%2F23%2F190138pwzurpp0uzieuu0r.jpg',2,1),(3,'滑板','有胆你就来 这是和生命的较量','<p><strong>&nbsp;&nbsp;&nbsp;滑板Skateboard项目可谓是极限运动历史的鼻祖，许多的极限运动项目均由滑板项目延伸而来。20世纪50年代末60年代初由冲浪运动演变而成的滑板运动，在而今已成为地球上最“酷”的运动。滑板运动以滑行为特色，崇尚自由的运动方式，体验与创造超重力的感受，给滑者带来成功和创造的喜悦。滑板运动不同于传统运动项目，不拘泥于固定的模式，需要滑手自由发挥想象力，在运动过程中创造，以创造力来运动，强调身心的自由，推崇与自然互相融合的运动理念。</strong></p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531238779845&di=2c92621c209c107d5d999dddf38a62be&imgtype=0&src=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20150903%2Ftooopen_sy_141167247975.jpg',3,1),(4,'吉他','不如学一学吉他 它懂你的孤独','<p>&nbsp;&nbsp;&nbsp;新的一天。阳光温暖。我的心也应该是温暖的。如若可以。在午后，约上几个志同道合的人，一起带着吉他，到一个安静的田野中弹起吉他唱起歌。或者，一个人背着吉他去不远处的山坡上弹个小曲唱个小调，也是一件幸福的事情。大自然会给你愈伤的力量。有时候真有抛却现实的繁杂，背上一把吉他，浪迹天涯的冲动。也许每一个弹吉他爱摇滚的孩子都有这样一种理想主义的悲壮情怀。</p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531238896141&di=880a3bc620e4ce4eb362903473b67a87&imgtype=0&src=http%3A%2F%2Fimg.gsxservice.com%2F1645166_x83xnzjf.jpeg',4,1),(7,'舞蹈','每个不曾起舞的日子都是对生命的辜负','<p>&nbsp;&nbsp;&nbsp;<span style=\"background-color: white;\">舞人从容而舞，形舒意广。她的心遨游在无垠的太空，自由地远思长想。开始的动作，像是俯身，又像是仰望；像是来、又像是往。是那样的雍容不迫，又是那么不已的惆怅，实难用语言来形象。接着舞下去，像是飞翔，又像步行；像是辣立，又像斜倾。不经意的动作也决不失法度，手眼身法都应着鼓声。纤细的罗衣从风飘舞，缭绕的长袖左右交横。络绎不绝的姿态飞舞散开，曲折的身段手脚合并。</span></p>','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531834053&di=0f3964dd5bf8e3a701e72a85bb799441&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F81%2F88%2F565541a818c65_1024.jpg',7,1);
/*!40000 ALTER TABLE `interest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_records`
--

DROP TABLE IF EXISTS `msg_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ownerid` int(11) NOT NULL COMMENT '帖子所有者id',
  `form` int(1) DEFAULT NULL COMMENT '消息类型（0：兴趣回帖，1：文章评论/回复）',
  `reply_card_id` int(10) DEFAULT NULL COMMENT '帖子回复id（form=0有效）',
  `comment_id` int(11) DEFAULT NULL COMMENT '文章评论id（form=1有效）',
  `replytime` varchar(255) DEFAULT NULL COMMENT '回复时间',
  `isread` int(1) DEFAULT '0' COMMENT '是否已读(0:未读，1:已读)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='消息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_records`
--

LOCK TABLES `msg_records` WRITE;
/*!40000 ALTER TABLE `msg_records` DISABLE KEYS */;
INSERT INTO `msg_records` VALUES (49,1,0,55,NULL,'1551148276278',1),(50,1,0,56,NULL,'1551148282467',1),(51,12,0,57,NULL,'1551148302655',1),(52,12,0,58,NULL,'1551148305904',1),(56,1,1,NULL,60,'1551149099676',1),(57,1,1,NULL,61,'1551149104644',1),(58,12,1,NULL,62,'1551149126022',1),(59,12,1,NULL,62,'1551149126022',1),(60,12,1,NULL,63,'1551149130440',1),(61,12,1,NULL,63,'1551149130440',1),(62,12,1,NULL,64,'1551149134541',1),(63,12,1,NULL,64,'1551149134541',1),(64,1,1,NULL,65,'1551159683118',1),(65,1,1,NULL,66,'1551159691355',1),(66,12,1,NULL,66,'1551159691355',1),(67,1,1,NULL,67,'1551159699833',1),(68,12,1,NULL,67,'1551159699833',1),(69,1,1,NULL,68,'1551160197584',1),(70,1,1,NULL,69,'1551160208500',1),(71,12,1,NULL,69,'1551160208500',1),(72,1,0,59,NULL,'1551160244503',1),(73,1,1,NULL,70,'1551282935448',1);
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
  `authorities` varchar(255) DEFAULT NULL,
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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `interestid` int(11) DEFAULT NULL COMMENT '兴趣id',
  `createtime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `replytime` varchar(255) DEFAULT NULL COMMENT '最新回复时间',
  `userid` int(11) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='帖子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_card`
--

LOCK TABLES `post_card` WRITE;
/*!40000 ALTER TABLE `post_card` DISABLE KEYS */;
INSERT INTO `post_card` VALUES (33,'你喜欢看什么动漫？','你喜欢看什么动漫？',1,'1527145330752','1551148305904',12),(34,'你觉得火影忍者这部动漫怎么样？','你觉得火影忍者这部动漫怎么样？',1,'1527145682685','1527210959322',NULL),(38,'汉服怎么样？','汉服怎么样？',2,'1527150545468','1527150554251',NULL),(39,'123','eqwsadsad',1,'1542350790861','1542350790861',12),(40,'123','eqwsadsad',1,'1542350799902','1542350799902',12),(41,'qweqw','eqwsadsad',1,'1542351639169','1542351639169',12),(42,'qweqw','eqwsadsad',1,'1542351661315','1542351661315',12),(43,'qeq','qweq',1,'1542595552839','1542619140350',1),(44,'qwe','qweqweqwe',1,'1542766755374','1551160244503',1),(46,'qw','qwe',9,'1546958289758','1546958289758',1),(47,'niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho','niahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniahoniaho',8,'1547019958239','1547019958239',1);
/*!40000 ALTER TABLE `post_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_user_role`
--

DROP TABLE IF EXISTS `r_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` text NOT NULL COMMENT '内容',
  `postcardid` int(11) DEFAULT NULL COMMENT '帖子id',
  `createtime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `userid` int(11) NOT NULL COMMENT '回复用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='回帖表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply_card`
--

LOCK TABLES `reply_card` WRITE;
/*!40000 ALTER TABLE `reply_card` DISABLE KEYS */;
INSERT INTO `reply_card` VALUES (32,'我喜欢看海贼王。',33,'1527145732382',1),(40,'很好看',38,'1527150554251',12),(41,'我喜欢漩涡鸣人。',34,'1527210804774',12),(42,'喜欢佐助，佐助太帅了。',34,'1527210846847',12),(43,'火影忍者打斗场面好看',34,'1527210893468',12),(44,'喜欢这个结局，大圆满。',34,'1527210959322',12),(45,' 死神',33,'1527211842627',12),(46,'一拳超人',33,'1527217127806',12),(47,'qweqwfasf',33,'1542353287205',12),(48,'qweqweqwfqw',43,'1542595559454',1),(49,'123123',43,'1542619140350',1),(50,'qweqwe',33,'1542766744184',1),(51,'hello',44,'1542766809112',1),(52,'123',44,'1546916527786',1),(53,'sadasd',44,'1551079835982',1),(54,'asd\n',44,'1551080485207',1),(55,'测试1',44,'1551148276278',12),(56,'测试2',44,'1551148282467',12),(57,'测试3',33,'1551148302655',12),(58,'测试4',33,'1551148305904',12),(59,'测试15',44,'1551160244503',12);
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
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类id',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `remark` text COMMENT '描述',
  `icon` varchar(30) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',' ',0,1,NULL,'md-settings'),(2,'轮播管理',' ',0,2,NULL,'logo-snapchat'),(3,'兴趣管理',' ',0,3,NULL,'logo-reddit'),(4,'发帖管理',' ',0,4,NULL,'md-chatboxes'),(5,'邮件管理',' ',0,5,NULL,'ios-mail'),(6,'用户管理','/base/user',1,1,NULL,'ios-person'),(7,'菜单管理','/base/menu',1,2,NULL,'md-list-box'),(8,'角色管理','/base/role',1,3,NULL,'ios-people'),(9,'轮播','/base/banner',2,1,NULL,'logo-snapchat'),(10,'新建','/base/i-create',3,1,NULL,'md-checkmark-circle'),(11,'修改','/base/i-edit',3,2,NULL,'md-create'),(12,'删除','/base/i-delete',3,3,NULL,'md-remove-circle'),(13,'发帖管理','/base/card',4,1,NULL,'ios-create-outline'),(14,'邮件','/base/email',5,1,NULL,'ios-mail'),(15,'文章管理',NULL,0,6,NULL,'md-paper'),(16,'文章','/base/article',15,1,NULL,'md-paper');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
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
INSERT INTO `sys_role` VALUES (1,'ROLE_ADMIN','超级管理员','4;5;6;7;8;9;10;11;14;1;12;13;16;','超级管理员，拥有全部权限。');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `usertype` int(1) NOT NULL DEFAULT '0' COMMENT '用户类型（0:普通用户，1:管理员）',
  `headimg` varchar(255) DEFAULT NULL COMMENT '头像url',
  `url` varchar(255) DEFAULT NULL COMMENT 'GitHub主页',
  `create_time` varchar(255) DEFAULT NULL COMMENT '注册时间',
  `githubid` varchar(255) DEFAULT NULL COMMENT 'github的login',
  `qqid` varchar(255) DEFAULT NULL COMMENT 'qq的openid',
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
INSERT INTO `sys_user` VALUES (1,'管理员','admin','{bcrypt}$2a$10$D8E4cuanLviCCe/ASqBC7OZ84JYOH8IT4/y4JLAV/Pm/AdhzPcy2.','123456@qq.com',1,'http://thirdqq.qlogo.cn/qqapp/101512648/1C47A2C639D3A89E573AC2BF46FBEF63/40','http://www.lovemtt.com','1531704654140',NULL,NULL),(12,'smallsnail-wh','qwe','{bcrypt}$2a$10$D8E4cuanLviCCe/ASqBC7OZ84JYOH8IT4/y4JLAV/Pm/AdhzPcy2.','null',0,'https://avatars2.githubusercontent.com/u/30545965?v=4','https://github.com/smallsnail-wh','1542463692126','smallsnail-wh',NULL),(13,'树根',NULL,NULL,NULL,0,'http://thirdqq.qlogo.cn/qqapp/101512648/1C47A2C639D3A89E573AC2BF46FBEF63/40',NULL,'1542463259014',NULL,'1C47A2C639D3A89E573AC2BF46FBEF63');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_detail`
--

DROP TABLE IF EXISTS `sys_user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `article_sign` int(1) DEFAULT '0' COMMENT '文章标志为（0:可发布文章，1:不可发布文章）',
  `info` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `location` varchar(255) DEFAULT NULL COMMENT '所在位置',
  `skill` varchar(255) DEFAULT NULL COMMENT '技能',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_detail`
--

LOCK TABLES `sys_user_detail` WRITE;
/*!40000 ALTER TABLE `sys_user_detail` DISABLE KEYS */;
INSERT INTO `sys_user_detail` VALUES (3,1,0,'my name is smallsnail.。','shanghai','java'),(4,12,0,NULL,NULL,NULL),(5,13,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_user_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_github`
--

DROP TABLE IF EXISTS `user_github`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_github` (
  `login` varchar(255) NOT NULL COMMENT 'github用户名',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像url',
  `html_url` varchar(255) DEFAULT NULL COMMENT 'github主页',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
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
  `openid` varchar(255) NOT NULL COMMENT 'openid',
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户名',
  `figureurl_qq_1` varchar(255) DEFAULT NULL COMMENT '头像url',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
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

-- Dump completed on 2019-03-01 10:34:41
