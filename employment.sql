-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: employment
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '课程名',
  `description` varchar(1000) DEFAULT NULL COMMENT '课程描述',
  `url` varchar(1000) DEFAULT NULL COMMENT '课程资料',
  `type` varchar(45) DEFAULT NULL COMMENT '资料类型',
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  `size` varchar(1000) DEFAULT NULL,
  `filetype` varchar(45) DEFAULT NULL,
  `caption` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='课程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'java基础视频','适用于初学者','1.MP4',NULL,0,NULL,NULL,NULL),(2,'java历史','java历史发展',NULL,'mp4',1,NULL,NULL,NULL),(3,'二级','','a891167b4e6b4e9eae39ed2912966b3b.mp4','video',4,'10926602','video/mp4','1.mp4'),(4,'语文','适用于有一定java经验的人',NULL,NULL,0,NULL,NULL,NULL),(5,'java高级视频','适用于高级开发人员',NULL,NULL,0,NULL,NULL,NULL),(26,'一级','2323','23e83dc6e08a470ea5910e45a2816a7a.mp4','video',4,'10926602','video/mp4','1.mp4'),(28,'三级','fsefes','e76215fecfe74764ad2ca25bc31fdf25.mp4','video',4,'10926602','video/mp4','1.mp4');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) DEFAULT NULL COMMENT '问题',
  `option_a` varchar(45) DEFAULT NULL COMMENT '选项',
  `option_b` varchar(45) DEFAULT NULL COMMENT '选项',
  `option_c` varchar(45) DEFAULT NULL COMMENT '选项',
  `option_d` varchar(45) DEFAULT NULL COMMENT '选项',
  `answer` varchar(45) DEFAULT NULL COMMENT '答案',
  `type` int(1) DEFAULT NULL COMMENT '类型 1.水平测试 2.课后测试 3.阶段测试 4.最终测试',
  `bus_id` int(11) DEFAULT NULL COMMENT '关联的岗位，或者课程id',
  `bus_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='题库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'今天周几','周二','周三','周四','周五','A',1,10,'2'),(2,'问题','a','b','c','d','C',1,8,'111'),(3,'问题1','1','2','3','4','D',2,2,'java历史');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruit`
--

DROP TABLE IF EXISTS `recruit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL COMMENT '位置',
  `year` varchar(45) DEFAULT NULL COMMENT '工作年限',
  `education` varchar(45) DEFAULT NULL COMMENT '学历',
  `detail` varchar(1000) DEFAULT NULL COMMENT '招聘详情',
  `pid` int(11) DEFAULT NULL COMMENT '岗位id',
  `salary` varchar(45) DEFAULT NULL COMMENT '薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='招聘信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruit`
--

LOCK TABLES `recruit` WRITE;
/*!40000 ALTER TABLE `recruit` DISABLE KEYS */;
INSERT INTO `recruit` VALUES (2,'幼儿园','老师','北京','不限','本科及以上','rw3r3r',2,'10k'),(3,'1','1','1','1','大专及以上','111222',NULL,'1'),(4,'','','','','不限','',2,''),(5,'','语文老师','','','不限','',NULL,'');
/*!40000 ALTER TABLE `recruit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `age` varchar(45) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL COMMENT '学历',
  `school` varchar(45) DEFAULT NULL COMMENT '毕业院校',
  `major` varchar(45) DEFAULT NULL COMMENT '专业',
  `advantage` varchar(45) DEFAULT NULL COMMENT '个人优势',
  `place` varchar(45) DEFAULT NULL COMMENT '求职地点',
  `money` varchar(45) DEFAULT NULL COMMENT '期望薪资',
  `work` varchar(45) DEFAULT NULL COMMENT '工作经历',
  `project` varchar(45) DEFAULT NULL COMMENT '项目经历',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='简历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (1,1,'fesfse','',NULL,'31231231','13131312',NULL,'','131231321','fesfse3131','fsefs','fesfse');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名',
  `roleDesc` varchar(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'超级管理员',NULL),(2,'普通用户',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '课程名',
  `description` varchar(1000) DEFAULT NULL COMMENT '课程描述',
  `url` varchar(1000) DEFAULT NULL COMMENT '课程资料',
  `type` varchar(45) DEFAULT NULL COMMENT '资料类型',
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  `size` varchar(1000) DEFAULT NULL,
  `filetype` varchar(45) DEFAULT NULL,
  `caption` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='岗位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'IT 互联网','',NULL,NULL,NULL,NULL,NULL,NULL),(8,'111','111',NULL,NULL,0,NULL,NULL,NULL),(9,'22','22',NULL,NULL,0,NULL,NULL,NULL),(10,'2','22',NULL,NULL,9,NULL,NULL,NULL);
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_course`
--

DROP TABLE IF EXISTS `station_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL COMMENT '岗位id',
  `cid` int(11) DEFAULT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_course`
--

LOCK TABLES `station_course` WRITE;
/*!40000 ALTER TABLE `station_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `station_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_style`
--

DROP TABLE IF EXISTS `study_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `type1` int(11) DEFAULT NULL COMMENT '活跃型/沉思型 0:活跃 1：沉思',
  `type2` int(11) DEFAULT NULL COMMENT '感悟型/直觉型  0:活跃 1：沉思',
  `type3` int(11) DEFAULT NULL COMMENT '视觉型/言语型 0:活跃 1：沉思',
  `type4` int(11) DEFAULT NULL COMMENT '序列型/综合型  0:活跃 1：沉思',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学习风格';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_style`
--

LOCK TABLES `study_style` WRITE;
/*!40000 ALTER TABLE `study_style` DISABLE KEYS */;
/*!40000 ALTER TABLE `study_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operation_log`
--

DROP TABLE IF EXISTS `sys_operation_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_operation_log` (
  `id` bigint(20) NOT NULL,
  `log_type` varchar(255) DEFAULT NULL,
  `log_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `succeed` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operation_log`
--

LOCK TABLES `sys_operation_log` WRITE;
/*!40000 ALTER TABLE `sys_operation_log` DISABLE KEYS */;
INSERT INTO `sys_operation_log` VALUES (1243846163286654978,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>',NULL),(1243847276790480897,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>',NULL),(1243847500300746753,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>',NULL),(1243847910944079873,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>','2020-03-28 18:30:26.202063'),(1243848303224750082,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>','2020-03-28 18:31:59.728220'),(1243850278079229953,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>','2020-03-28 18:39:50.552127'),(1243850440969220098,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>','2020-03-28 18:40:29.408525'),(1243850693285965825,'业务日志','登录',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>','2020-03-28 18:41:29.561914'),(1243856100238712834,'业务日志','登录',NULL,'com.cn.employment.login.controller.LoginController','login','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:login <br>[参数]: <br/>','2020-03-28 19:02:58.640859'),(1243856117926092801,'业务日志','登录成功跳转到主页',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>','2020-03-28 19:03:02.899863'),(1243856120019050497,'业务日志','后台索引页',1,'com.cn.employment.login.controller.LoginController','index','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:index <br>[参数]:null <br/>','2020-03-28 19:03:03.398528'),(1243856802730188802,'业务日志','登录',NULL,'com.cn.employment.login.controller.LoginController','login','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:login <br>[参数]: <br/>','2020-03-28 19:05:46.131000'),(1243856811903131649,'业务日志','登录成功跳转到主页',1,'com.cn.employment.login.controller.LoginController','main','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:main <br>[参数]:null <br/>','2020-03-28 19:05:48.369000'),(1243856813777985538,'业务日志','后台索引页',1,'com.cn.employment.login.controller.LoginController','index','成功','[类名]:com.cn.employment.login.controller.LoginController <br/>[方法]:index <br>[参数]:null <br/>','2020-03-28 19:05:48.803000');
/*!40000 ALTER TABLE `sys_operation_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `phonenum` varchar(20) DEFAULT NULL COMMENT '手机号',
  `state` int(11) DEFAULT NULL COMMENT '状态 0表示启用 1表示该用户停用',
  `join_time` datetime DEFAULT NULL COMMENT '加入时间',
  `last_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'','admin','1',NULL,NULL,NULL,NULL),(55,'1','test','1','1',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_role`
--

DROP TABLE IF EXISTS `users_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_role` (
  `userId` int(11) DEFAULT NULL COMMENT '用户id外键',
  `roleId` int(11) DEFAULT NULL COMMENT '角色id外键',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_role`
--

LOCK TABLES `users_role` WRITE;
/*!40000 ALTER TABLE `users_role` DISABLE KEYS */;
INSERT INTO `users_role` VALUES (36,2,4),(39,2,5),(41,2,6),(42,2,7),(44,2,8),(53,2,9);
/*!40000 ALTER TABLE `users_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-28 19:06:55
