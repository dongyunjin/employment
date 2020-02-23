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
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '课程名',
  `description` varchar(45) DEFAULT NULL COMMENT '课程描述',
  `url` varchar(45) DEFAULT NULL COMMENT '课程资料',
  `type` varchar(45) DEFAULT NULL COMMENT '资料类型',
  `pid` int(11) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'java基础视频','适用于初学者',NULL,NULL,0),(2,'java历史','java历史发展',NULL,'mp4',1),(3,'java基本数据类型',NULL,NULL,'txt',4),(4,'java中级视频','适用于有一定java经验的人',NULL,NULL,0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questioin`
--

DROP TABLE IF EXISTS `questioin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questioin` (
  `id` int(11) NOT NULL,
  `question` varchar(45) DEFAULT NULL COMMENT '问题',
  `option_a` varchar(45) DEFAULT NULL COMMENT '选项',
  `option_b` varchar(45) DEFAULT NULL COMMENT '选项',
  `option_c` varchar(45) DEFAULT NULL COMMENT '选项',
  `option_d` varchar(45) DEFAULT NULL COMMENT '选项',
  `answer` varchar(45) DEFAULT NULL COMMENT '答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questioin`
--

LOCK TABLES `questioin` WRITE;
/*!40000 ALTER TABLE `questioin` DISABLE KEYS */;
/*!40000 ALTER TABLE `questioin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `age` varchar(45) DEFAULT NULL COMMENT '年龄',
  `education` varchar(45) DEFAULT NULL COMMENT '学历',
  `school` varchar(45) DEFAULT NULL COMMENT '毕业院校',
  `advantage` varchar(45) DEFAULT NULL COMMENT '个人优势',
  `place` varchar(45) DEFAULT NULL COMMENT '求职地点',
  `money` varchar(45) DEFAULT NULL COMMENT '期望薪资',
  `work` varchar(45) DEFAULT NULL COMMENT '工作经历',
  `poject` varchar(45) DEFAULT NULL COMMENT '项目经理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
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
  `id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `description` varchar(45) DEFAULT NULL COMMENT '岗位描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,0,'根节点'),(2,1,'IT互联网'),(3,1,'金融'),(4,1,'教育培训'),(5,2,'java工程师'),(6,2,'web前端工程师');
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_style`
--

DROP TABLE IF EXISTS `study_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_style` (
  `id` int(11) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'','admin','1',NULL,NULL,NULL,NULL);
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
INSERT INTO `users_role` VALUES (1,1,1),(NULL,2,3),(36,2,4),(39,2,5),(41,2,6),(42,2,7),(44,2,8),(53,2,9);
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

-- Dump completed on 2020-02-23 21:16:31
