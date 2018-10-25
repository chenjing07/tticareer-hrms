-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: tti
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `archives`
--

DROP TABLE IF EXISTS `archives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `archives` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工id',
  `in_time` datetime DEFAULT NULL COMMENT '转入时间',
  `out_time` datetime DEFAULT NULL COMMENT '转出时间',
  `archives_source` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '档案来处',
  `archives_destination` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '档案去处',
  `archives_change` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '档案变更说明',
  `state` int(11) NOT NULL COMMENT '状态 0以往1现在',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_Reference_4` (`employee_id`) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archives`
--

LOCK TABLES `archives` WRITE;
/*!40000 ALTER TABLE `archives` DISABLE KEYS */;
INSERT INTO `archives` VALUES (1,4,'2018-10-08 00:00:00',NULL,'来源','去处','',1,'2018-10-08 00:00:00',1,'n'),(2,2,NULL,NULL,NULL,NULL,NULL,1,'2018-10-10 09:17:41',1,'testPage'),(3,3,NULL,NULL,NULL,NULL,NULL,0,'2018-10-10 09:18:00',1,'testPage'),(4,4,NULL,NULL,NULL,NULL,NULL,1,'2018-10-10 09:18:10',1,'testPage'),(5,5,NULL,NULL,NULL,NULL,NULL,1,'2018-10-10 09:18:21',1,'testPage'),(6,6,NULL,NULL,NULL,NULL,NULL,1,'2018-10-10 09:18:29',1,'testPage'),(7,3,NULL,NULL,NULL,NULL,NULL,0,'2018-10-10 09:18:38',0,'testPage'),(8,5,NULL,NULL,NULL,NULL,NULL,1,'2018-10-10 09:18:46',0,'testPage'),(9,1,NULL,NULL,NULL,NULL,NULL,1,'2018-10-10 09:19:09',0,'testPage'),(10,1,NULL,NULL,NULL,NULL,NULL,0,'2018-10-10 09:19:18',0,'testPage'),(11,6,NULL,NULL,NULL,NULL,NULL,1,'2018-10-10 09:19:26',0,'testPage'),(12,2,'2018-10-23 09:33:59',NULL,NULL,NULL,NULL,1,'2018-10-23 09:34:10',1,NULL),(13,2,NULL,NULL,'','','',1,'2018-10-23 00:00:00',0,''),(14,2,NULL,NULL,'qwe','','',1,'2018-10-23 00:00:00',0,''),(15,1,'2018-10-16 09:58:54',NULL,'15','15',NULL,1,'2018-10-23 09:59:12',1,'15'),(16,1,NULL,NULL,'16','16','16',1,'2018-10-23 00:00:00',0,'16');
/*!40000 ALTER TABLE `archives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_standard`
--

DROP TABLE IF EXISTS `assessment_standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assessment_standard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `position_id` bigint(20) NOT NULL COMMENT '岗位id',
  `work_result` varchar(255) NOT NULL COMMENT '工作业绩说明',
  `attitude` varchar(255) NOT NULL COMMENT '工作态度说明',
  `quality` varchar(255) NOT NULL COMMENT '工作质量说明',
  `skill` varchar(255) NOT NULL COMMENT '工作技能说明',
  `calculation_way` varchar(255) NOT NULL COMMENT '考核计算方法说明',
  `assessment_type` varchar(255) NOT NULL COMMENT '考核分类说明',
  `result_level` varchar(255) NOT NULL COMMENT '结果级别划分说明',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_34` (`position_id`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_standard`
--

LOCK TABLES `assessment_standard` WRITE;
/*!40000 ALTER TABLE `assessment_standard` DISABLE KEYS */;
INSERT INTO `assessment_standard` VALUES (2,7,'工作业绩说明1','工作态度说明1','工作质量说明1','工作技能说明1','考核计算方法说明1','考核分类说明1','结果级别划分说明1',1,'2018-10-26 00:59:56',1,''),(3,2,'工作业绩说明3','工作态度说明3','工作质量说明3','工作技能说明3','考核计算方法说明3','考核分类说明3','结果级别划分说明3',1,'2018-10-12 00:59:56',0,''),(4,3,'工作业绩说明4','工作态度说明4','工作质量说明4','工作技能说明4','考核计算方法说明4','考核分类说明4','结果级别划分说明4',1,'2018-10-16 00:59:56',0,''),(5,4,'工作业绩说明5','工作态度说明5','工作质量说明5','工作技能说明5','考核计算方法说明5','考核分类说明5','结果级别划分说明5',1,'2018-10-15 00:59:56',1,''),(6,1,'工作业绩说明2','工作态度说明2','工作质量说明2','工作技能说明2','考核计算方法说明2','考核分类说明2','结果级别划分说明2',1,'2018-10-14 00:59:56',1,'');
/*!40000 ALTER TABLE `assessment_standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clock_detail`
--

DROP TABLE IF EXISTS `clock_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clock_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `clock_in` datetime DEFAULT NULL COMMENT '上班打卡时间',
  `clock_out` datetime DEFAULT NULL COMMENT '下班打卡时间',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0异常 1按例\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_32` (`employee_id`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clock_detail`
--

LOCK TABLES `clock_detail` WRITE;
/*!40000 ALTER TABLE `clock_detail` DISABLE KEYS */;
INSERT INTO `clock_detail` VALUES (1,1,'2018-10-26 00:57:05',NULL,1,'2018-10-26 00:57:05','已签到'),(2,9,'2018-10-26 01:03:47','2018-10-26 01:23:28',1,'2018-10-26 01:03:47','已签退'),(3,2,'2018-10-26 00:57:05',NULL,1,'2018-10-26 01:03:47','已签到'),(4,3,'2018-10-26 00:57:05',NULL,1,'2018-10-26 01:03:47','已签到'),(5,4,'2018-10-26 00:57:05',NULL,1,'2018-10-26 01:03:47','已签到'),(6,5,'2018-10-26 00:57:05',NULL,1,'2018-10-26 01:03:47','已签到'),(7,6,'2018-10-26 00:57:05',NULL,1,'2018-10-26 01:03:47','已签到'),(8,7,'2018-10-26 00:57:05',NULL,1,'2018-10-26 01:03:47','已签到'),(9,8,'2018-10-26 00:57:05',NULL,1,'2018-10-26 01:03:47','已签到');
/*!40000 ALTER TABLE `clock_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一id，主键自增',
  `superior_department_id` bigint(20) DEFAULT NULL COMMENT '上级部门id',
  `department_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编号',
  `department_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `department_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门简介',
  `state` int(11) NOT NULL COMMENT '状态 0冻结1激活',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_Reference_38` (`superior_department_id`) USING BTREE,
  CONSTRAINT `FK_Reference_38` FOREIGN KEY (`superior_department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,NULL,'9999','董事长办公室','董事长办公室',1,'2018-09-25 16:22:35',1,'董事长办公室'),(2,1,'1000','人力资源部门','人力资源部门',1,'2018-09-25 16:23:16',1,'人力资源部门'),(3,1,'1001','信息管理中心','信息管理中心',1,'2018-10-22 19:42:00',0,'信息管理中心'),(4,1,'8888','技术研发部','技术研发',1,'2018-10-26 00:00:00',1,'');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工号  部门编号+岗位编号+员工id   录账号\r\n            ',
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `real_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工真实姓名',
  `id_card_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工身份证号',
  `id_card_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证图片存放地址',
  `birthday` datetime NOT NULL COMMENT '出生年月',
  `gender` int(11) NOT NULL COMMENT '性别1男0女',
  `nation` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '民族',
  `native_place` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `registered_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '户口地址',
  `house_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `education` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学历',
  `academic_degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学位',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业',
  `tie` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系别',
  `graduated_school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '毕业院校',
  `graduated_time` datetime DEFAULT NULL COMMENT '毕业时间',
  `political_status` int(11) NOT NULL COMMENT '政治面貌\r\n            {\r\n            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士\r\n            }',
  `marital_status` int(11) NOT NULL COMMENT '婚姻状况 0未婚1已婚',
  `recruitment_source` int(11) NOT NULL COMMENT '招聘来源\r\n            {\r\n            	1简历应聘2招聘网站3其它途径\r\n            }',
  `account_bank` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开户银行',
  `account_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工资账户',
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `qq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'qq号码',
  `wechat` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号',
  `msn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'MSN',
  `emergency_contact_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '紧急联系人姓名',
  `emergency_contact_relationship` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '紧急联系人姓名',
  `emergency_contact_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '紧急联系人电话',
  `work_start` datetime DEFAULT NULL COMMENT '入职时间',
  `work_end` datetime DEFAULT NULL COMMENT '离职时间',
  `practice_start` datetime DEFAULT NULL COMMENT '实习开始时间',
  `practice_end` datetime DEFAULT NULL COMMENT '实习结束时间',
  `iswork` int(11) NOT NULL COMMENT '是否在职0离职1正式2实习',
  `state` int(11) NOT NULL COMMENT '状态\r\n            {\r\n            	0为冻结，1为其他员工，2为人事部普通员工，3为人事部经理\r\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_satus` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','admin','超级管理员',NULL,NULL,'2018-09-25 16:29:06',1,'admin','admin','admin','admin',NULL,NULL,NULL,'',NULL,NULL,0,0,0,'admin','admin','admin','admin',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,3,'2018-09-25 16:31:19',3,'admin'),(2,'rlb-cfy','rlb-cfy','陈发颖','440582',NULL,'1999-09-25 16:32:20',1,'汉','广东','广东','广东','本科','本科','软件工程',NULL,NULL,NULL,0,0,0,'中国工商银行','6212262010','136316136','9768@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'2018-09-25 16:34:03',1,'人力资源-陈发颖'),(3,'rlb-cyf','cyf','cyf','440582',NULL,'1993-09-25 17:23:21',1,'汉','广东','广东','广东','本科','本科',NULL,NULL,NULL,NULL,0,0,0,'工商','6212263202','135135315','135@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'2018-09-04 17:24:42',0,'wu'),(4,'test',NULL,'测试',NULL,NULL,'2018-10-01 17:00:00',1,'中国','广东','东莞','松山湖',NULL,NULL,NULL,NULL,NULL,NULL,1,1,1,'工商','621226','135','9768@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'2018-10-01 17:00:00',0,NULL),(5,'test2222222',NULL,'测试',NULL,NULL,'2018-10-01 17:00:00',1,'中国','广东','东莞','松山湖',NULL,NULL,NULL,NULL,NULL,NULL,1,1,1,'工商','621226','135','9768@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'2018-10-01 17:00:00',0,NULL),(6,'test233334',NULL,'测试ces',NULL,NULL,'2018-10-01 17:00:00',1,'中国','广东','东莞','松山湖',NULL,NULL,NULL,NULL,NULL,NULL,1,1,1,'工商','621226','135','9768@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'2018-10-01 17:00:00',0,NULL),(7,'JSB-ChenFy','password','技术部陈发颖','4440528256','','2018-10-08 00:00:00',1,'汉','广东','广东','广东','大学','学士','软件工程','计算机学院','东莞理工学院','2019-06-18 00:00:00',3,0,0,'中国工商','621226201020','13631789266','842612@qq.com','842612','842612','','','','','2018-10-23 00:00:00',NULL,'2018-10-23 00:00:00',NULL,2,1,'2018-10-23 00:00:00',0,'note'),(8,'JSB-ChenYf','password','技术部陈','4407896','','2018-10-01 00:00:00',1,'汉','广东','广东','广东','大学','学士','软件工程','计算机','dgut','2018-10-27 00:00:00',0,0,0,'工商','621226201','135135135','9768@qq.com','9768','9768','','','','','2018-10-23 00:00:00',NULL,'2018-10-23 00:00:00',NULL,2,1,'2018-10-23 00:00:00',0,'Note'),(9,'dong123456','dong123456','东','123456789','','2018-10-31 00:00:00',1,'汉族','广东','广东东莞','广东东莞东莞理工学院','本科','学士','软件工程','计算机系','东莞理工学院','2018-10-31 00:00:00',3,0,1,'工商银行','123456789','123456789','123456789@qq.com','123456789','123456789','123456789','dong','父子','123456789','2018-10-26 00:00:00',NULL,'2018-10-26 00:00:00','2018-10-27 00:00:00',1,1,'2018-10-26 00:00:00',3,'还行');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_assessment`
--

DROP TABLE IF EXISTS `employee_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_assessment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `assessment_type` int(11) NOT NULL COMMENT '考核分类\n            {\n            	1日常考核 2定期考核 3长期考核 4不定期考核。\n            }',
  `work_result` int(11) NOT NULL COMMENT '工作业绩\n            {\n            	1优秀 2良好 3及格 0不及格\n            }',
  `attitude` int(11) NOT NULL COMMENT '{\n            	1优秀 2良好 3及格 0不及格\n            }',
  `quality` int(11) NOT NULL COMMENT '{\n            	1优秀 2良好 3及格 0不及格\n            }',
  `skill` int(11) NOT NULL COMMENT '{\n            	1优秀 2良好 3及格 0不及格\n            }',
  `assessment_result` int(11) NOT NULL COMMENT '{\n            	1优秀 2良好 3及格 0不及格\n            }',
  `evaluate` varchar(255) NOT NULL COMMENT '评价',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_31` (`employee_id`),
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_assessment`
--

LOCK TABLES `employee_assessment` WRITE;
/*!40000 ALTER TABLE `employee_assessment` DISABLE KEYS */;
INSERT INTO `employee_assessment` VALUES (1,9,1,1,1,1,1,1,'该员工真棒',1,'2018-10-26 01:00:19',1,''),(2,9,2,1,1,1,1,1,'真的很不错',1,'2018-10-26 01:00:33',1,''),(3,9,3,2,1,2,1,1,'还行，总体来说是优秀的',1,'2018-10-26 01:00:59',1,''),(4,9,4,2,2,2,2,2,'还行吧',1,'2018-10-26 01:01:17',1,'');
/*!40000 ALTER TABLE `employee_assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_position_info`
--

DROP TABLE IF EXISTS `employee_position_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_position_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `position_id` bigint(20) NOT NULL COMMENT '岗位id',
  `arrive_post` datetime NOT NULL COMMENT '到岗时间',
  `leave_post` datetime DEFAULT NULL COMMENT '调岗时间',
  `transfer_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调岗原因',
  `leave_opinion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调出部门意见',
  `arrive_opinion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '调入部门意见',
  `state` int(11) NOT NULL COMMENT '状态 0以往1现在',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_Reference_2` (`employee_id`) USING BTREE,
  KEY `FK_Reference_22` (`position_id`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_position_info`
--

LOCK TABLES `employee_position_info` WRITE;
/*!40000 ALTER TABLE `employee_position_info` DISABLE KEYS */;
INSERT INTO `employee_position_info` VALUES (1,2,2,'2018-10-01 17:00:00',NULL,NULL,NULL,NULL,1,'2018-09-25 23:00:00',0,NULL),(2,3,3,'2018-09-25 17:25:12',NULL,NULL,NULL,NULL,1,'2018-09-25 17:25:18',0,NULL),(3,2,2,'2018-10-08 00:00:00','2018-10-09 00:00:00','test','同意','同意',1,'2018-10-08 00:00:00',0,'none'),(4,2,2,'2018-10-08 00:00:00','2018-10-09 00:00:00','test','同意','同意',1,'2018-10-08 00:00:00',0,'none'),(5,4,3,'2018-10-08 00:00:00','2018-10-09 00:00:00','tst','同意','同意',1,'2018-10-08 00:00:00',0,'no'),(6,3,3,'2018-10-09 00:00:00','2018-10-10 00:00:00','111','11','111',1,'2018-10-08 00:00:00',0,'11'),(7,2,2,'2018-10-23 16:22:28',NULL,NULL,NULL,NULL,0,'2018-10-23 16:22:15',1,NULL),(8,9,2,'2018-10-26 00:00:00',NULL,'','','',0,'2018-10-26 00:00:00',0,''),(9,9,7,'2018-10-26 00:00:00',NULL,'','','',1,'2018-10-26 00:00:00',0,'');
/*!40000 ALTER TABLE `employee_position_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination_questions`
--

DROP TABLE IF EXISTS `examination_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `examination_questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `question` varchar(255) NOT NULL COMMENT '题目',
  `answer` varchar(255) NOT NULL COMMENT '答案',
  `score` decimal(10,0) NOT NULL COMMENT '分数',
  `difficulty_level` int(11) NOT NULL COMMENT '难度等级\n            {\n            	0易 1中 2难\n            }	',
  `category` int(11) NOT NULL COMMENT '分类\n   		{\n   			1选择题 2填空题 3问答题 4计算题\n   		}',
  `explanation` varchar(255) NOT NULL COMMENT '讲解',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1未使用 2使用 -1有错误\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination_questions`
--

LOCK TABLES `examination_questions` WRITE;
/*!40000 ALTER TABLE `examination_questions` DISABLE KEYS */;
INSERT INTO `examination_questions` VALUES (1,'question1','answer1',51,0,1,'explanation1',2,'2018-10-22 11:36:54','note1'),(2,'question2','answer2',52,0,1,'explanation2',2,'2018-10-22 11:36:55','note2'),(3,'question3','answer3',53,0,1,'explanation3',2,'2018-10-22 11:36:55','note3'),(4,'question4','answer4',54,0,1,'explanation4',2,'2018-10-22 11:36:55','note4'),(5,'question5','answer5',55,0,1,'explanation5',2,'2018-10-22 11:36:55','note5'),(6,'question6','answer6',56,0,1,'explanation6',2,'2018-10-22 11:36:55','note6'),(7,'question7','answer7',57,0,1,'explanation7',2,'2018-10-22 11:36:56','note7'),(8,'question8','answer8',58,0,1,'explanation8',2,'2018-10-22 11:36:56','note8'),(9,'question9','answer9',59,0,1,'explanation9',2,'2018-10-22 11:36:56','note9'),(10,'question10','answer10',60,0,1,'explanation10',2,'2018-10-22 11:36:56','note10'),(11,'question11','answer11',61,0,1,'explanation11',2,'2018-10-22 11:36:56','note11'),(12,'question12','answer12',62,0,1,'explanation12',2,'2018-10-22 11:36:56','note12'),(13,'question13','answer13',63,0,1,'explanation13',2,'2018-10-22 11:36:56','note13'),(14,'question14','answer14',64,0,1,'explanation14',2,'2018-10-22 11:36:56','note14'),(15,'question15','answer15',65,0,1,'explanation15',2,'2018-10-22 11:36:56','note15'),(16,'question16','answer16',66,0,1,'explanation16',2,'2018-10-22 11:36:56','note16'),(17,'question17','answer17',67,0,1,'explanation17',2,'2018-10-22 11:36:56','note17'),(18,'question18','answer18',68,0,1,'explanation18',2,'2018-10-22 11:36:56','note18'),(19,'question19','answer19',69,0,1,'explanation19',2,'2018-10-22 11:36:56','note19'),(20,'question20','answer20',70,0,1,'explanation20',2,'2018-10-22 11:36:56','note20'),(21,'question21','answer21',71,0,2,'explanation21',2,'2018-10-22 11:54:58','note21'),(22,'question22','answer22',72,0,2,'explanation22',2,'2018-10-22 11:54:58','note22'),(23,'question23','answer23',73,0,2,'explanation23',2,'2018-10-22 11:54:58','note23'),(24,'question24','answer24',74,0,2,'explanation24',2,'2018-10-22 11:54:58','note24'),(25,'question25','answer25',75,0,2,'explanation25',2,'2018-10-22 11:54:58','note25'),(26,'question26','answer26',76,0,2,'explanation26',2,'2018-10-22 11:54:58','note26'),(27,'question27','answer27',77,0,2,'explanation27',2,'2018-10-22 11:54:58','note27'),(28,'question28','answer28',78,0,2,'explanation28',2,'2018-10-22 11:54:58','note28'),(29,'question29','answer29',79,0,2,'explanation29',2,'2018-10-22 11:54:58','note29'),(30,'question30','answer30',80,0,2,'explanation30',2,'2018-10-22 11:54:58','note30'),(31,'question31','answer31',81,0,2,'explanation31',2,'2018-10-22 11:54:58','note31'),(32,'question32','answer32',82,0,2,'explanation32',2,'2018-10-22 11:54:58','note32'),(33,'question33','answer33',83,0,2,'explanation33',2,'2018-10-22 11:54:58','note33'),(34,'question34','answer34',84,0,2,'explanation34',2,'2018-10-22 11:54:58','note34'),(35,'question35','answer35',85,0,2,'explanation35',2,'2018-10-22 11:54:58','note35'),(36,'question36','answer36',86,0,2,'explanation36',2,'2018-10-22 11:54:58','note36'),(37,'question37','answer37',87,0,2,'explanation37',2,'2018-10-22 11:54:58','note37'),(38,'question38','answer38',88,0,2,'explanation38',2,'2018-10-22 11:54:58','note38'),(39,'question39','answer39',89,0,2,'explanation39',2,'2018-10-22 11:54:58','note39'),(40,'question40','answer40',90,0,2,'explanation40',2,'2018-10-22 11:54:59','note40'),(41,'question41','answer41',91,0,3,'explanation41',2,'2018-10-22 11:57:31','note41'),(42,'question42','answer42',92,0,3,'explanation42',2,'2018-10-22 11:57:31','note42'),(43,'question43','answer43',93,0,3,'explanation43',2,'2018-10-22 11:57:31','note43'),(44,'question44','answer44',94,0,3,'explanation44',2,'2018-10-22 11:57:31','note44'),(45,'question45','answer45',95,0,3,'explanation45',2,'2018-10-22 11:57:32','note45'),(46,'question46','answer46',96,0,3,'explanation46',2,'2018-10-22 11:57:32','note46'),(47,'question47','answer47',97,0,3,'explanation47',2,'2018-10-22 11:57:32','note47'),(48,'question48','answer48',98,0,3,'explanation48',2,'2018-10-22 11:57:32','note48'),(49,'question49','answer49',99,0,3,'explanation49',2,'2018-10-22 11:57:32','note49'),(50,'question50','answer50',100,0,3,'explanation50',2,'2018-10-22 11:57:32','note50'),(51,'question41','answer41',91,2,4,'explanation41',2,'2018-10-22 11:58:45','note41'),(52,'question42','answer42',92,2,4,'explanation42',2,'2018-10-22 11:58:46','note42'),(53,'question43','answer43',93,2,4,'explanation43',2,'2018-10-22 11:58:46','note43'),(54,'question44','answer44',94,2,4,'explanation44',2,'2018-10-22 11:58:46','note44'),(55,'question45','answer45',95,2,4,'explanation45',2,'2018-10-22 11:58:46','note45'),(56,'question46','answer46',96,2,4,'explanation46',2,'2018-10-22 11:58:46','note46'),(57,'question47','answer47',97,2,4,'explanation47',2,'2018-10-22 11:58:46','note47'),(58,'question48','answer48',98,2,4,'explanation48',2,'2018-10-22 11:58:46','note48'),(59,'question49','answer49',99,2,4,'explanation49',2,'2018-10-22 11:58:46','note49'),(60,'question50','answer50',100,2,4,'explanation50',2,'2018-10-22 11:58:46','note50');
/*!40000 ALTER TABLE `examination_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_account`
--

DROP TABLE IF EXISTS `expense_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `expense_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `time` datetime NOT NULL COMMENT '报销日期',
  `content` varchar(255) NOT NULL COMMENT '报销内容',
  `reason` varchar(255) NOT NULL COMMENT '报销原因',
  `amount` decimal(10,0) NOT NULL COMMENT '报销金额',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_26` (`employee_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_account`
--

LOCK TABLES `expense_account` WRITE;
/*!40000 ALTER TABLE `expense_account` DISABLE KEYS */;
INSERT INTO `expense_account` VALUES (1,1,'2018-10-02 00:00:00','出差衣食住行','出差',1110,0,'2018-10-22 16:13:34',0,'还行'),(2,1,'2018-10-11 00:00:00','五星级酒店吃饭','吃饭',1200,0,'2018-10-22 16:41:04',0,''),(3,1,'2018-10-04 00:00:00','从广东到广西','滴滴打车',110,0,'2018-10-22 16:41:56',0,''),(4,1,'2018-10-01 00:00:00','sss','谁啊',1520,1,'2018-10-23 20:22:45',0,''),(5,1,'2018-10-02 00:00:00','是色','升水',1523,0,'2018-10-23 20:22:58',0,''),(6,1,'2018-10-03 00:00:00','色分','色粉',15123,0,'2018-10-23 20:23:11',0,'');
/*!40000 ALTER TABLE `expense_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `great_team`
--

DROP TABLE IF EXISTS `great_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `great_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `department_id` bigint(20) NOT NULL COMMENT '部门id',
  `commend` varchar(255) NOT NULL COMMENT '表彰内容',
  `reward` varchar(255) NOT NULL COMMENT '奖励内容',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_33` (`department_id`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `great_team`
--

LOCK TABLES `great_team` WRITE;
/*!40000 ALTER TABLE `great_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `great_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday_statistics`
--

DROP TABLE IF EXISTS `holiday_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `holiday_statistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `total_holidays` int(11) NOT NULL COMMENT '假期总天数',
  `total_leave_days` int(11) NOT NULL COMMENT '已请假天数',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_35` (`employee_id`),
  CONSTRAINT `FK_Reference_35` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday_statistics`
--

LOCK TABLES `holiday_statistics` WRITE;
/*!40000 ALTER TABLE `holiday_statistics` DISABLE KEYS */;
INSERT INTO `holiday_statistics` VALUES (1,1,50,10,1,'2018-10-26 00:58:37',1,NULL),(2,2,50,10,1,'2018-10-26 00:58:37',1,NULL),(3,3,50,10,1,'2018-10-26 00:58:37',1,NULL),(4,4,50,1,1,'2018-10-26 00:58:37',1,NULL),(5,5,50,1,1,'2018-10-26 00:58:37',1,NULL),(6,6,50,1,1,'2018-10-26 00:58:37',1,NULL),(7,7,50,2,1,'2018-10-26 00:58:37',1,NULL),(8,8,50,2,1,'2018-10-26 00:58:37',1,NULL),(9,9,45,7,1,'2018-10-26 00:58:37',1,NULL);
/*!40000 ALTER TABLE `holiday_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interview` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `resume_id` bigint(20) NOT NULL COMMENT '简历id',
  `one_content` varchar(255) NOT NULL COMMENT '初面内容',
  `one_start` datetime NOT NULL COMMENT '初面开始时间',
  `one_end` datetime NOT NULL COMMENT '初面结束时间',
  `one_feedback` varchar(255) NOT NULL COMMENT '初面反馈总结',
  `two_content` varchar(255) NOT NULL COMMENT '复面内容',
  `two_start` datetime NOT NULL COMMENT '复面开始时间',
  `two_end` datetime NOT NULL COMMENT '复面结束时间',
  `two_feedback` varchar(255) NOT NULL COMMENT '复面反馈总结',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0落选 1进入二面2录用\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_21` (`resume_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES (1,2,'oneContent1','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback1','twoContent1','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback1',1,'2018-10-22 16:08:54','note1'),(2,3,'oneContent2','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback2','twoContent2','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback2',1,'2018-10-22 16:08:54','note2'),(3,4,'oneContent3','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback3','twoContent3','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback3',1,'2018-10-22 16:08:54','note3'),(4,5,'oneContent4','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback4','twoContent4','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback4',1,'2018-10-22 16:08:54','note4'),(5,6,'oneContent5','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback5','twoContent5','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback5',1,'2018-10-22 16:08:54','note5'),(6,7,'oneContent6','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback6','twoContent6','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback6',1,'2018-10-22 16:08:54','note6'),(7,8,'oneContent7','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback7','twoContent7','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback7',1,'2018-10-22 16:08:54','note7'),(8,9,'oneContent8','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback8','twoContent8','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback8',1,'2018-10-22 16:08:54','note8'),(9,10,'oneContent9','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback9','twoContent9','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback9',1,'2018-10-22 16:08:54','note9'),(10,11,'oneContent10','2018-10-22 16:08:54','2018-10-22 16:08:54','oneFeedback10','twoContent10','2018-10-22 16:08:54','2018-10-22 16:08:54','twoFeedback10',1,'2018-10-22 16:08:54','note10'),(11,12,'oneContent11','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback11','twoContent11','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback11',1,'2018-10-22 16:08:55','note11'),(12,13,'oneContent12','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback12','twoContent12','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback12',1,'2018-10-22 16:08:55','note12'),(13,14,'oneContent13','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback13','twoContent13','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback13',1,'2018-10-22 16:08:55','note13'),(14,15,'oneContent14','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback14','twoContent14','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback14',1,'2018-10-22 16:08:55','note14'),(15,16,'oneContent15','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback15','twoContent15','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback15',1,'2018-10-22 16:08:55','note15'),(16,17,'oneContent16','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback16','twoContent16','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback16',1,'2018-10-22 16:08:55','note16'),(17,18,'oneContent17','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback17','twoContent17','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback17',1,'2018-10-22 16:08:55','note17'),(18,19,'oneContent18','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback18','twoContent18','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback18',1,'2018-10-22 16:08:55','note18'),(19,20,'oneContent19','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback19','twoContent19','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback19',1,'2018-10-22 16:08:55','note19'),(20,21,'oneContent20','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback20','twoContent20','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback20',1,'2018-10-22 16:08:55','note20'),(21,22,'oneContent21','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback21','twoContent21','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback21',1,'2018-10-22 16:08:55','note21'),(22,23,'oneContent22','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback22','twoContent22','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback22',1,'2018-10-22 16:08:55','note22'),(23,24,'oneContent23','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback23','twoContent23','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback23',1,'2018-10-22 16:08:55','note23'),(24,25,'oneContent24','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback24','twoContent24','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback24',1,'2018-10-22 16:08:55','note24'),(25,26,'oneContent25','2018-10-22 16:08:55','2018-10-22 16:08:55','oneFeedback25','twoContent25','2018-10-22 16:08:55','2018-10-22 16:08:55','twoFeedback25',1,'2018-10-22 16:08:55','note25'),(26,27,'oneContent26','2018-10-22 16:14:23','2018-10-22 16:14:23','oneFeedback26','twoContent26','2018-10-22 16:14:23','2018-10-22 16:14:23','twoFeedback26',2,'2018-10-22 16:14:23','note26'),(27,28,'oneContent27','2018-10-22 16:14:23','2018-10-22 16:14:23','oneFeedback27','twoContent27','2018-10-22 16:14:23','2018-10-22 16:14:23','twoFeedback27',2,'2018-10-22 16:14:23','note27'),(28,29,'oneContent28','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback28','twoContent28','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback28',2,'2018-10-22 16:14:24','note28'),(29,30,'oneContent29','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback29','twoContent29','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback29',2,'2018-10-22 16:14:24','note29'),(30,31,'oneContent30','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback30','twoContent30','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback30',2,'2018-10-22 16:14:24','note30'),(31,32,'oneContent31','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback31','twoContent31','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback31',2,'2018-10-22 16:14:24','note31'),(32,33,'oneContent32','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback32','twoContent32','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback32',2,'2018-10-22 16:14:24','note32'),(33,34,'oneContent33','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback33','twoContent33','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback33',2,'2018-10-22 16:14:24','note33'),(34,35,'oneContent34','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback34','twoContent34','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback34',2,'2018-10-22 16:14:24','note34'),(35,36,'oneContent35','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback35','twoContent35','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback35',2,'2018-10-22 16:14:24','note35'),(36,37,'oneContent36','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback36','twoContent36','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback36',2,'2018-10-22 16:14:24','note36'),(37,38,'oneContent37','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback37','twoContent37','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback37',2,'2018-10-22 16:14:24','note37'),(38,39,'oneContent38','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback38','twoContent38','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback38',2,'2018-10-22 16:14:24','note38'),(39,40,'oneContent39','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback39','twoContent39','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback39',2,'2018-10-22 16:14:24','note39'),(40,41,'oneContent40','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback40','twoContent40','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback40',2,'2018-10-22 16:14:24','note40'),(41,42,'oneContent41','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback41','twoContent41','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback41',2,'2018-10-22 16:14:24','note41'),(42,43,'oneContent42','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback42','twoContent42','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback42',2,'2018-10-22 16:14:24','note42'),(43,44,'oneContent43','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback43','twoContent43','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback43',2,'2018-10-22 16:14:24','note43'),(44,45,'oneContent44','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback44','twoContent44','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback44',2,'2018-10-22 16:14:24','note44'),(45,46,'oneContent45','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback45','twoContent45','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback45',2,'2018-10-22 16:14:24','note45'),(46,47,'oneContent46','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback46','twoContent46','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback46',2,'2018-10-22 16:14:24','note46'),(47,48,'oneContent47','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback47','twoContent47','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback47',2,'2018-10-22 16:14:24','note47'),(48,49,'oneContent48','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback48','twoContent48','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback48',2,'2018-10-22 16:14:24','note48'),(49,50,'oneContent49','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback49','twoContent49','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback49',2,'2018-10-22 16:14:24','note49'),(50,51,'oneContent50','2018-10-22 16:14:24','2018-10-22 16:14:24','oneFeedback50','twoContent50','2018-10-22 16:14:24','2018-10-22 16:14:24','twoFeedback50',2,'2018-10-22 16:14:24','note50');
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labor_contract`
--

DROP TABLE IF EXISTS `labor_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `labor_contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employer_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '甲方名称，用人单位',
  `employee_id` bigint(20) NOT NULL COMMENT '乙方名称 员工id',
  `contract_time_limit` int(11) NOT NULL COMMENT '合同期限',
  `contract_start` datetime NOT NULL COMMENT '开始时间',
  `contract_end` datetime NOT NULL COMMENT '结束时间',
  `work_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作内容',
  `work_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作地点',
  `labor_protection` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '劳动保护',
  `labor_conditions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '劳动条件',
  `labor_reward` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '劳动报酬',
  `default_responsibility` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '违约责任',
  `social_insurance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '社会保险',
  `contract_change` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '合同变更',
  `state` int(11) NOT NULL COMMENT '状态 0以往1现在',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_Reference_3` (`employee_id`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labor_contract`
--

LOCK TABLES `labor_contract` WRITE;
/*!40000 ALTER TABLE `labor_contract` DISABLE KEYS */;
INSERT INTO `labor_contract` VALUES (1,'甲方',3,30,'2018-09-28 05:00:00','2018-10-25 23:00:00','合同内容','工作地点','劳动保护','劳动条件','劳动报酬','违约责任','社会保险',NULL,1,'2018-09-28 08:00:00',1,'备注'),(2,'甲方',2,30,'2018-09-28 05:00:00','2018-10-25 23:00:00','合同内容','工作地点','劳动保护','劳动条件','劳动报酬','违约责任','社会保险',NULL,1,'2018-10-08 08:00:00',1,'备注22222'),(3,'tti',4,4,'2018-10-10 00:00:00','2022-10-10 00:00:00','内容','地点','保护','con','10000','招惹','保险','',1,'2018-10-08 00:00:00',0,'n');
/*!40000 ALTER TABLE `labor_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `late_early`
--

DROP TABLE IF EXISTS `late_early`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `late_early` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `late_early_time` datetime NOT NULL COMMENT '迟到早退时间',
  `late_early_reason` varchar(255) NOT NULL COMMENT '迟到早退原因',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1迟到 2早退\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_25` (`employee_id`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `late_early`
--

LOCK TABLES `late_early` WRITE;
/*!40000 ALTER TABLE `late_early` DISABLE KEYS */;
INSERT INTO `late_early` VALUES (1,9,'2018-10-26 00:00:00','塞车11',1,'2018-10-26 00:57:24',''),(2,9,'2018-10-16 00:00:00','家里急事',2,'2018-10-26 00:57:40',''),(3,2,'2018-10-16 00:00:00','塞车',1,'2018-10-26 00:57:25',NULL),(4,2,'2018-10-17 00:00:00','家里急事',2,'2018-10-26 00:57:25',NULL),(5,3,'2018-10-18 00:00:00','塞车',1,'2018-10-26 00:57:25',NULL),(6,3,'2018-10-19 00:00:00','家里急事',2,'2018-10-26 00:57:25',NULL),(7,4,'2018-10-20 00:00:00','塞车',1,'2018-10-26 00:57:25',NULL),(8,4,'2018-10-21 00:00:00','家里急事',2,'2018-10-26 00:57:25',NULL),(9,5,'2018-10-22 00:00:00','塞车',1,'2018-10-26 00:57:25',NULL),(10,5,'2018-10-23 00:00:00','家里急事',2,'2018-10-26 00:57:25',NULL),(11,6,'2018-10-24 00:00:00','塞车',1,'2018-10-26 00:57:25',NULL);
/*!40000 ALTER TABLE `late_early` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_detail`
--

DROP TABLE IF EXISTS `leave_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leave_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `leave_start` datetime NOT NULL COMMENT '请假开始时间',
  `leave_end` datetime NOT NULL COMMENT '请假结束时间',
  `leave_days` int(11) NOT NULL COMMENT '请假天数',
  `reason` varchar(255) NOT NULL COMMENT '请假原因',
  `real_start` datetime DEFAULT NULL COMMENT '审核后假期开始时间',
  `real_end` datetime DEFAULT NULL COMMENT '审核后假期结束时间（销假）',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活 2销假成功\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_27` (`employee_id`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_detail`
--

LOCK TABLES `leave_detail` WRITE;
/*!40000 ALTER TABLE `leave_detail` DISABLE KEYS */;
INSERT INTO `leave_detail` VALUES (1,9,'2018-10-26 00:00:00','2018-10-31 00:00:00',5,'家里急事','2018-10-26 00:00:00','2018-10-31 00:00:00',3,'2018-10-26 00:58:37',1,''),(2,1,'2018-10-26 00:00:00','2018-10-26 00:00:00',1,'生病','2018-10-26 00:00:00',NULL,1,'2018-10-26 00:58:37',1,NULL),(3,2,'2018-10-26 00:00:00','2018-10-26 00:00:00',1,'生病',NULL,NULL,1,'2018-10-26 00:58:37',0,NULL),(4,3,'2018-10-26 00:00:00','2018-10-31 00:00:00',4,'家里急事','2018-10-26 00:00:00',NULL,1,'2018-10-26 00:58:37',1,NULL),(5,4,'2018-10-26 00:00:00','2018-10-26 00:00:00',1,'生病',NULL,NULL,1,'2018-10-26 00:58:37',0,NULL),(6,5,'2018-10-26 00:00:00','2018-10-31 00:00:00',3,'家里急事','2018-10-26 00:00:00',NULL,1,'2018-10-26 00:58:37',1,NULL),(7,6,'2018-10-26 00:00:00','2018-10-26 00:00:00',1,'生病',NULL,NULL,1,'2018-10-26 00:58:37',0,NULL),(8,7,'2018-10-26 00:00:00','2018-10-31 00:00:00',6,'家里急事','2018-10-26 00:00:00',NULL,1,'2018-10-26 00:58:37',1,NULL),(9,8,'2018-10-26 00:00:00','2018-10-26 00:00:00',1,'生病',NULL,NULL,1,'2018-10-26 00:58:37',0,NULL);
/*!40000 ALTER TABLE `leave_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `over_work`
--

DROP TABLE IF EXISTS `over_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `over_work` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `time` datetime NOT NULL COMMENT '加班日期',
  `duration` varchar(50) NOT NULL COMMENT '加班时长',
  `content` varchar(255) NOT NULL COMMENT '加班内容',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0异常 1正常\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_29` (`employee_id`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `over_work`
--

LOCK TABLES `over_work` WRITE;
/*!40000 ALTER TABLE `over_work` DISABLE KEYS */;
INSERT INTO `over_work` VALUES (1,9,'2018-10-25 00:00:00','5','修人力资源管理系统bug',1,'2018-10-26 00:58:06',''),(2,9,'2018-10-26 00:00:00','4','java bug 11',1,'2018-10-26 00:00:00',''),(3,2,'2018-10-15 00:00:00','5','c++ bug',1,'2018-10-15 00:00:00',NULL),(4,2,'2018-10-23 00:00:00','3','Android bug',1,'2018-10-23 00:00:00',NULL),(5,3,'2018-10-22 00:00:00','2','修改逻辑',1,'2018-10-26 00:58:06',NULL),(6,3,'2018-10-21 00:00:00','1','修改逻辑',1,'2018-10-26 00:58:06',NULL),(7,4,'2018-10-20 00:00:00','3','修改逻辑',1,'2018-10-26 00:58:06',NULL),(8,4,'2018-10-13 00:00:00','5','修改逻辑',1,'2018-10-26 00:58:06',NULL),(9,5,'2018-10-12 00:00:00','4','修改逻辑',1,'2018-10-26 00:58:06',NULL),(10,5,'2018-10-15 00:00:00','2','修改逻辑',1,'2018-10-26 00:58:06',NULL);
/*!40000 ALTER TABLE `over_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `position_number` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位编号',
  `position_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `superior_positionId` bigint(20) DEFAULT NULL COMMENT '上级岗位id',
  `position_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位简介',
  `state` int(11) NOT NULL COMMENT '状态 0冻结1激活',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_Reference_36` (`department_id`) USING BTREE,
  KEY `FK_Reference_7` (`superior_positionId`) USING BTREE,
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`superior_positionId`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,1,'9999','超级管理员',NULL,'超级管理员',1,'2018-09-25 16:25:14',1,'超级管理员'),(2,2,'1001','人事部经理',1,'人事部经理',1,'2018-09-25 16:27:10',1,'人事部经理'),(3,2,'1002','人事部副经理',2,'人事部副经理',1,'2018-09-25 16:28:07',1,'人事部副经理'),(4,3,'1003','信息中心主管',2,'信息中心主管',1,'2018-10-22 20:01:06',1,'信息中心主管'),(7,4,'1004','技术总监',1,'技术总监',1,'2018-10-31 00:00:00',1,'');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment_demand`
--

DROP TABLE IF EXISTS `recruitment_demand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recruitment_demand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `position_id` bigint(20) NOT NULL COMMENT '岗位id',
  `plan_number` int(11) NOT NULL COMMENT '计划人数',
  `salary` decimal(10,0) NOT NULL COMMENT '薪资待遇',
  `supplemental_number` int(11) DEFAULT NULL COMMENT '增补人数',
  `supplement_reason` varchar(255) DEFAULT NULL COMMENT '增补原因',
  `arrival_date` datetime NOT NULL COMMENT '到岗日期',
  `language_requirements` varchar(255) NOT NULL COMMENT '外语要求',
  `professional_requirements` varchar(255) NOT NULL COMMENT '专业要求',
  `educational_requirements` varchar(255) NOT NULL COMMENT '学历要求',
  `computer_requirements` varchar(255) NOT NULL COMMENT '电脑要求',
  `experience_requirements` varchar(255) NOT NULL COMMENT '经验要求',
  `age_requirements` varchar(255) NOT NULL COMMENT '年龄要求',
  `post_duties` varchar(255) NOT NULL COMMENT '岗位职责',
  `post_requirements` varchar(255) NOT NULL COMMENT '岗位要求',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_37` (`position_id`),
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment_demand`
--

LOCK TABLES `recruitment_demand` WRITE;
/*!40000 ALTER TABLE `recruitment_demand` DISABLE KEYS */;
INSERT INTO `recruitment_demand` VALUES (1,2,11,1001,21,'原因1','2018-10-21 21:25:55','语言1','专业1','学历1','电脑1','经验1','年龄1','岗位职责1','岗位要求1',1,'2018-10-21 21:25:55','备注1'),(2,3,12,1002,22,'原因2','2018-10-21 21:25:55','语言2','专业2','学历2','电脑2','经验2','年龄2','岗位职责2','岗位要求2',1,'2018-10-21 21:25:55','备注2'),(3,4,13,1003,23,'原因3','2018-10-21 21:25:55','语言3','专业3','学历3','电脑3','经验3','年龄3','岗位职责3','岗位要求3',1,'2018-10-21 21:25:55','备注3');
/*!40000 ALTER TABLE `recruitment_demand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `application_name` varchar(50) NOT NULL COMMENT '应聘人姓名',
  `expected_position` varchar(50) NOT NULL COMMENT '期望的职位',
  `id_card_number` varchar(30) NOT NULL COMMENT '身份证号',
  `id_card_picture` varchar(100) NOT NULL COMMENT '身份证图片存放地址',
  `birthday` datetime NOT NULL COMMENT '出生年月',
  `gender` int(11) NOT NULL COMMENT '性别1男0女',
  `nation` varchar(30) NOT NULL COMMENT '民族',
  `native_place` varchar(30) NOT NULL COMMENT '籍贯',
  `registered_address` varchar(255) NOT NULL COMMENT '户口地址',
  `house_address` varchar(255) NOT NULL COMMENT '家庭住址',
  `political_status` int(11) NOT NULL COMMENT '政治面貌\n            {\n            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士\n            }',
  `marital_status` int(11) NOT NULL COMMENT '婚姻状况 0未婚1已婚',
  `phone_number` varchar(20) NOT NULL COMMENT '手机号码',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `qq` varchar(20) DEFAULT NULL COMMENT 'qq号码',
  `education` varchar(50) DEFAULT NULL COMMENT '学历',
  `academic_degree` varchar(50) DEFAULT NULL COMMENT '学位',
  `major` varchar(50) DEFAULT NULL COMMENT '专业',
  `tie` varchar(50) DEFAULT NULL COMMENT '系别',
  `graduated_school` varchar(255) DEFAULT NULL COMMENT '毕业院校',
  `graduated_time` datetime DEFAULT NULL COMMENT '毕业时间',
  `awards_received` varchar(255) DEFAULT NULL COMMENT '获得的奖项',
  `language_level` varchar(255) NOT NULL COMMENT '语言水平',
  `work_experience` varchar(255) NOT NULL COMMENT '工作经验',
  `hobbies` varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
  `self_evaluation` varchar(255) NOT NULL COMMENT '自我评价',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0待处理 1进入笔试 2落选\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (1,'name1','posi1','idcard1','D://...','2018-10-21 21:21:52',1,'nation1','native1','rAddress1','hAddress1',2,0,'phone1','email1','qq1','education1','aDegree1','major1','tie1','gSchool1','2018-10-21 21:21:52','awards1','language1','Experience1','hobbies1','self1',0,'2018-10-21 21:21:52','note1'),(2,'name2','posi2','idcard2','D://...','2018-10-21 21:21:53',1,'nation2','native2','rAddress2','hAddress2',2,0,'phone2','email2','qq2','education2','aDegree2','major2','tie2','gSchool2','2018-10-21 21:21:53','awards2','language2','Experience2','hobbies2','self2',0,'2018-10-21 21:21:53','note2'),(3,'name3','posi3','idcard3','D://...','2018-10-21 21:21:53',1,'nation3','native3','rAddress3','hAddress3',2,0,'phone3','email3','qq3','education3','aDegree3','major3','tie3','gSchool3','2018-10-21 21:21:53','awards3','language3','Experience3','hobbies3','self3',0,'2018-10-21 21:21:53','note3'),(4,'name4','posi4','idcard4','D://...','2018-10-21 21:21:53',1,'nation4','native4','rAddress4','hAddress4',2,0,'phone4','email4','qq4','education4','aDegree4','major4','tie4','gSchool4','2018-10-21 21:21:53','awards4','language4','Experience4','hobbies4','self4',0,'2018-10-21 21:21:53','note4'),(5,'name5','posi5','idcard5','D://...','2018-10-21 21:21:53',1,'nation5','native5','rAddress5','hAddress5',2,0,'phone5','email5','qq5','education5','aDegree5','major5','tie5','gSchool5','2018-10-21 21:21:53','awards5','language5','Experience5','hobbies5','self5',0,'2018-10-21 21:21:53','note5'),(6,'name6','posi6','idcard6','D://...','2018-10-21 21:25:21',1,'nation6','native6','rAddress6','hAddress6',2,0,'phone6','email6','qq6','education6','aDegree6','major6','tie6','gSchool6','2018-10-21 21:25:21','awards6','language6','Experience6','hobbies6','self6',0,'2018-10-21 21:25:21','note6'),(7,'name7','posi7','idcard7','D://...','2018-10-21 21:25:21',1,'nation7','native7','rAddress7','hAddress7',2,0,'phone7','email7','qq7','education7','aDegree7','major7','tie7','gSchool7','2018-10-21 21:25:21','awards7','language7','Experience7','hobbies7','self7',0,'2018-10-21 21:25:21','note7'),(8,'name8','posi8','idcard8','D://...','2018-10-21 21:25:21',1,'nation8','native8','rAddress8','hAddress8',2,0,'phone8','email8','qq8','education8','aDegree8','major8','tie8','gSchool8','2018-10-21 21:25:21','awards8','language8','Experience8','hobbies8','self8',0,'2018-10-21 21:25:21','note8'),(9,'name9','posi9','idcard9','D://...','2018-10-21 21:25:21',1,'nation9','native9','rAddress9','hAddress9',2,0,'phone9','email9','qq9','education9','aDegree9','major9','tie9','gSchool9','2018-10-21 21:25:21','awards9','language9','Experience9','hobbies9','self9',0,'2018-10-21 21:25:21','note9'),(10,'name10','posi10','idcard10','D://...','2018-10-21 21:25:21',1,'nation10','native10','rAddress10','hAddress10',2,0,'phone10','email10','qq10','education10','aDegree10','major10','tie10','gSchool10','2018-10-21 21:25:21','awards10','language10','Experience10','hobbies10','self10',0,'2018-10-21 21:25:21','note10'),(11,'name11','posi11','idcard11','D://...','2018-10-21 21:25:21',1,'nation11','native11','rAddress11','hAddress11',2,0,'phone11','email11','qq11','education11','aDegree11','major11','tie11','gSchool11','2018-10-21 21:25:21','awards11','language11','Experience11','hobbies11','self11',0,'2018-10-21 21:25:21','note11'),(12,'name12','posi12','idcard12','D://...','2018-10-21 21:25:21',1,'nation12','native12','rAddress12','hAddress12',2,0,'phone12','email12','qq12','education12','aDegree12','major12','tie12','gSchool12','2018-10-21 21:25:21','awards12','language12','Experience12','hobbies12','self12',0,'2018-10-21 21:25:21','note12'),(13,'name13','posi13','idcard13','D://...','2018-10-21 21:25:21',1,'nation13','native13','rAddress13','hAddress13',2,0,'phone13','email13','qq13','education13','aDegree13','major13','tie13','gSchool13','2018-10-21 21:25:21','awards13','language13','Experience13','hobbies13','self13',0,'2018-10-21 21:25:21','note13'),(14,'name14','posi14','idcard14','D://...','2018-10-21 21:25:21',1,'nation14','native14','rAddress14','hAddress14',2,0,'phone14','email14','qq14','education14','aDegree14','major14','tie14','gSchool14','2018-10-21 21:25:21','awards14','language14','Experience14','hobbies14','self14',0,'2018-10-21 21:25:21','note14'),(15,'name15','posi15','idcard15','D://...','2018-10-21 21:25:21',1,'nation15','native15','rAddress15','hAddress15',2,0,'phone15','email15','qq15','education15','aDegree15','major15','tie15','gSchool15','2018-10-21 21:25:21','awards15','language15','Experience15','hobbies15','self15',0,'2018-10-21 21:25:21','note15'),(16,'name16','posi16','idcard16','D://...','2018-10-21 21:25:22',1,'nation16','native16','rAddress16','hAddress16',2,0,'phone16','email16','qq16','education16','aDegree16','major16','tie16','gSchool16','2018-10-21 21:25:22','awards16','language16','Experience16','hobbies16','self16',0,'2018-10-21 21:25:22','note16'),(17,'name17','posi17','idcard17','D://...','2018-10-21 21:25:22',1,'nation17','native17','rAddress17','hAddress17',2,0,'phone17','email17','qq17','education17','aDegree17','major17','tie17','gSchool17','2018-10-21 21:25:22','awards17','language17','Experience17','hobbies17','self17',0,'2018-10-21 21:25:22','note17'),(18,'name18','posi18','idcard18','D://...','2018-10-21 21:25:22',1,'nation18','native18','rAddress18','hAddress18',2,0,'phone18','email18','qq18','education18','aDegree18','major18','tie18','gSchool18','2018-10-21 21:25:22','awards18','language18','Experience18','hobbies18','self18',0,'2018-10-21 21:25:22','note18'),(19,'name19','posi19','idcard19','D://...','2018-10-21 21:25:22',1,'nation19','native19','rAddress19','hAddress19',2,0,'phone19','email19','qq19','education19','aDegree19','major19','tie19','gSchool19','2018-10-21 21:25:22','awards19','language19','Experience19','hobbies19','self19',0,'2018-10-21 21:25:22','note19'),(20,'name20','posi20','idcard20','D://...','2018-10-21 21:25:22',1,'nation20','native20','rAddress20','hAddress20',2,0,'phone20','email20','qq20','education20','aDegree20','major20','tie20','gSchool20','2018-10-21 21:25:22','awards20','language20','Experience20','hobbies20','self20',0,'2018-10-21 21:25:22','note20'),(21,'name21','posi21','idcard21','D://...','2018-10-21 21:25:22',1,'nation21','native21','rAddress21','hAddress21',2,0,'phone21','email21','qq21','education21','aDegree21','major21','tie21','gSchool21','2018-10-21 21:25:22','awards21','language21','Experience21','hobbies21','self21',0,'2018-10-21 21:25:22','note21'),(22,'name22','posi22','idcard22','D://...','2018-10-21 21:25:22',1,'nation22','native22','rAddress22','hAddress22',2,0,'phone22','email22','qq22','education22','aDegree22','major22','tie22','gSchool22','2018-10-21 21:25:22','awards22','language22','Experience22','hobbies22','self22',0,'2018-10-21 21:25:22','note22'),(23,'name23','posi23','idcard23','D://...','2018-10-21 21:25:22',1,'nation23','native23','rAddress23','hAddress23',2,0,'phone23','email23','qq23','education23','aDegree23','major23','tie23','gSchool23','2018-10-21 21:25:22','awards23','language23','Experience23','hobbies23','self23',0,'2018-10-21 21:25:22','note23'),(24,'name24','posi24','idcard24','D://...','2018-10-21 21:25:22',1,'nation24','native24','rAddress24','hAddress24',2,0,'phone24','email24','qq24','education24','aDegree24','major24','tie24','gSchool24','2018-10-21 21:25:22','awards24','language24','Experience24','hobbies24','self24',0,'2018-10-21 21:25:22','note24'),(25,'name25','posi25','idcard25','D://...','2018-10-21 21:25:22',1,'nation25','native25','rAddress25','hAddress25',2,0,'phone25','email25','qq25','education25','aDegree25','major25','tie25','gSchool25','2018-10-21 21:25:22','awards25','language25','Experience25','hobbies25','self25',0,'2018-10-21 21:25:22','note25'),(26,'name26','posi26','idcard26','D://...','2018-10-21 21:25:22',1,'nation26','native26','rAddress26','hAddress26',2,0,'phone26','email26','qq26','education26','aDegree26','major26','tie26','gSchool26','2018-10-21 21:25:22','awards26','language26','Experience26','hobbies26','self26',0,'2018-10-21 21:25:22','note26'),(27,'name27','posi27','idcard27','D://...','2018-10-21 21:25:22',1,'nation27','native27','rAddress27','hAddress27',2,0,'phone27','email27','qq27','education27','aDegree27','major27','tie27','gSchool27','2018-10-21 21:25:22','awards27','language27','Experience27','hobbies27','self27',0,'2018-10-21 21:25:22','note27'),(28,'name28','posi28','idcard28','D://...','2018-10-21 21:25:22',1,'nation28','native28','rAddress28','hAddress28',2,0,'phone28','email28','qq28','education28','aDegree28','major28','tie28','gSchool28','2018-10-21 21:25:22','awards28','language28','Experience28','hobbies28','self28',0,'2018-10-21 21:25:22','note28'),(29,'name29','posi29','idcard29','D://...','2018-10-21 21:25:22',1,'nation29','native29','rAddress29','hAddress29',2,0,'phone29','email29','qq29','education29','aDegree29','major29','tie29','gSchool29','2018-10-21 21:25:22','awards29','language29','Experience29','hobbies29','self29',0,'2018-10-21 21:25:22','note29'),(30,'name30','posi30','idcard30','D://...','2018-10-21 21:25:22',1,'nation30','native30','rAddress30','hAddress30',2,0,'phone30','email30','qq30','education30','aDegree30','major30','tie30','gSchool30','2018-10-21 21:25:22','awards30','language30','Experience30','hobbies30','self30',0,'2018-10-21 21:25:22','note30'),(31,'name31','posi31','idcard31','D://...','2018-10-21 21:25:22',1,'nation31','native31','rAddress31','hAddress31',2,0,'phone31','email31','qq31','education31','aDegree31','major31','tie31','gSchool31','2018-10-21 21:25:22','awards31','language31','Experience31','hobbies31','self31',0,'2018-10-21 21:25:22','note31'),(32,'name32','posi32','idcard32','D://...','2018-10-21 21:25:22',1,'nation32','native32','rAddress32','hAddress32',2,0,'phone32','email32','qq32','education32','aDegree32','major32','tie32','gSchool32','2018-10-21 21:25:22','awards32','language32','Experience32','hobbies32','self32',0,'2018-10-21 21:25:22','note32'),(33,'name33','posi33','idcard33','D://...','2018-10-21 21:25:22',1,'nation33','native33','rAddress33','hAddress33',2,0,'phone33','email33','qq33','education33','aDegree33','major33','tie33','gSchool33','2018-10-21 21:25:22','awards33','language33','Experience33','hobbies33','self33',0,'2018-10-21 21:25:22','note33'),(34,'name34','posi34','idcard34','D://...','2018-10-21 21:25:22',1,'nation34','native34','rAddress34','hAddress34',2,0,'phone34','email34','qq34','education34','aDegree34','major34','tie34','gSchool34','2018-10-21 21:25:22','awards34','language34','Experience34','hobbies34','self34',0,'2018-10-21 21:25:22','note34'),(35,'name35','posi35','idcard35','D://...','2018-10-21 21:25:22',1,'nation35','native35','rAddress35','hAddress35',2,0,'phone35','email35','qq35','education35','aDegree35','major35','tie35','gSchool35','2018-10-21 21:25:22','awards35','language35','Experience35','hobbies35','self35',0,'2018-10-21 21:25:22','note35'),(36,'name36','posi36','idcard36','D://...','2018-10-21 21:25:22',1,'nation36','native36','rAddress36','hAddress36',2,0,'phone36','email36','qq36','education36','aDegree36','major36','tie36','gSchool36','2018-10-21 21:25:22','awards36','language36','Experience36','hobbies36','self36',0,'2018-10-21 21:25:22','note36'),(37,'name37','posi37','idcard37','D://...','2018-10-21 21:25:23',1,'nation37','native37','rAddress37','hAddress37',2,0,'phone37','email37','qq37','education37','aDegree37','major37','tie37','gSchool37','2018-10-21 21:25:23','awards37','language37','Experience37','hobbies37','self37',0,'2018-10-21 21:25:23','note37'),(38,'name38','posi38','idcard38','D://...','2018-10-21 21:25:23',1,'nation38','native38','rAddress38','hAddress38',2,0,'phone38','email38','qq38','education38','aDegree38','major38','tie38','gSchool38','2018-10-21 21:25:23','awards38','language38','Experience38','hobbies38','self38',0,'2018-10-21 21:25:23','note38'),(39,'name39','posi39','idcard39','D://...','2018-10-21 21:25:23',1,'nation39','native39','rAddress39','hAddress39',2,0,'phone39','email39','qq39','education39','aDegree39','major39','tie39','gSchool39','2018-10-21 21:25:23','awards39','language39','Experience39','hobbies39','self39',0,'2018-10-21 21:25:23','note39'),(40,'name40','posi40','idcard40','D://...','2018-10-21 21:25:23',1,'nation40','native40','rAddress40','hAddress40',2,0,'phone40','email40','qq40','education40','aDegree40','major40','tie40','gSchool40','2018-10-21 21:25:23','awards40','language40','Experience40','hobbies40','self40',0,'2018-10-21 21:25:23','note40'),(41,'name41','posi41','idcard41','D://...','2018-10-21 21:25:23',1,'nation41','native41','rAddress41','hAddress41',2,0,'phone41','email41','qq41','education41','aDegree41','major41','tie41','gSchool41','2018-10-21 21:25:23','awards41','language41','Experience41','hobbies41','self41',0,'2018-10-21 21:25:23','note41'),(42,'name42','posi42','idcard42','D://...','2018-10-21 21:25:23',1,'nation42','native42','rAddress42','hAddress42',2,0,'phone42','email42','qq42','education42','aDegree42','major42','tie42','gSchool42','2018-10-21 21:25:23','awards42','language42','Experience42','hobbies42','self42',0,'2018-10-21 21:25:23','note42'),(43,'name43','posi43','idcard43','D://...','2018-10-21 21:25:23',1,'nation43','native43','rAddress43','hAddress43',2,0,'phone43','email43','qq43','education43','aDegree43','major43','tie43','gSchool43','2018-10-21 21:25:23','awards43','language43','Experience43','hobbies43','self43',0,'2018-10-21 21:25:23','note43'),(44,'name44','posi44','idcard44','D://...','2018-10-21 21:25:23',1,'nation44','native44','rAddress44','hAddress44',2,0,'phone44','email44','qq44','education44','aDegree44','major44','tie44','gSchool44','2018-10-21 21:25:23','awards44','language44','Experience44','hobbies44','self44',0,'2018-10-21 21:25:23','note44'),(45,'name45','posi45','idcard45','D://...','2018-10-21 21:25:23',1,'nation45','native45','rAddress45','hAddress45',2,0,'phone45','email45','qq45','education45','aDegree45','major45','tie45','gSchool45','2018-10-21 21:25:23','awards45','language45','Experience45','hobbies45','self45',0,'2018-10-21 21:25:23','note45'),(46,'name46','posi46','idcard46','D://...','2018-10-21 21:25:23',1,'nation46','native46','rAddress46','hAddress46',2,0,'phone46','email46','qq46','education46','aDegree46','major46','tie46','gSchool46','2018-10-21 21:25:23','awards46','language46','Experience46','hobbies46','self46',0,'2018-10-21 21:25:23','note46'),(47,'name47','posi47','idcard47','D://...','2018-10-21 21:25:23',1,'nation47','native47','rAddress47','hAddress47',2,0,'phone47','email47','qq47','education47','aDegree47','major47','tie47','gSchool47','2018-10-21 21:25:23','awards47','language47','Experience47','hobbies47','self47',0,'2018-10-21 21:25:23','note47'),(48,'name48','posi48','idcard48','D://...','2018-10-21 21:25:23',1,'nation48','native48','rAddress48','hAddress48',2,0,'phone48','email48','qq48','education48','aDegree48','major48','tie48','gSchool48','2018-10-21 21:25:23','awards48','language48','Experience48','hobbies48','self48',0,'2018-10-21 21:25:23','note48'),(49,'name49','posi49','idcard49','D://...','2018-10-21 21:25:23',1,'nation49','native49','rAddress49','hAddress49',2,0,'phone49','email49','qq49','education49','aDegree49','major49','tie49','gSchool49','2018-10-21 21:25:23','awards49','language49','Experience49','hobbies49','self49',0,'2018-10-21 21:25:23','note49'),(50,'name50','posi50','idcard50','D://...','2018-10-21 21:25:23',1,'nation50','native50','rAddress50','hAddress50',2,0,'phone50','email50','qq50','education50','aDegree50','major50','tie50','gSchool50','2018-10-21 21:25:23','awards50','language50','Experience50','hobbies50','self50',0,'2018-10-21 21:25:23','note50'),(51,'cj','position','1234567890','D://...','2018-10-22 00:00:00',0,'naton','cj','cj','cj',3,0,'13564334567','qq.com','233','cj','cj','cj','cj','cj','2018-10-26 00:00:00','cj','cj','cj','cj','cj',1,'2018-10-22 00:00:00','ccj');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward_punishment`
--

DROP TABLE IF EXISTS `reward_punishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reward_punishment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `reward_and_punishment` int(11) NOT NULL COMMENT '奖惩1奖0惩',
  `content` varchar(255) NOT NULL COMMENT '奖惩内容',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_28` (`employee_id`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward_punishment`
--

LOCK TABLES `reward_punishment` WRITE;
/*!40000 ALTER TABLE `reward_punishment` DISABLE KEYS */;
INSERT INTO `reward_punishment` VALUES (1,1,1,'太帅了',0,'2018-10-08 00:00:00',0,'null'),(2,1,1,'太傻',1,'2018-10-21 20:30:35',0,'null'),(3,1,0,'太丑了',1,'2018-10-22 08:52:35',0,'null'),(4,1,1,'我是是b',1,'2018-10-22 08:56:53',0,'null'),(5,1,0,'11111',1,'2018-10-22 09:32:59',0,'null'),(6,1,1,'太酷了',1,'2018-10-24 19:58:35',0,'');
/*!40000 ALTER TABLE `reward_punishment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_detail`
--

DROP TABLE IF EXISTS `salary_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salary_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) NOT NULL COMMENT '员工id',
  `basic_salary` decimal(10,0) NOT NULL COMMENT '基本工资',
  `bonus` decimal(10,0) DEFAULT NULL COMMENT '奖金',
  `subsidy` decimal(10,0) DEFAULT NULL COMMENT '补贴',
  `over_work_salary` decimal(10,0) DEFAULT NULL COMMENT '加班工资',
  `attendance_deduction` decimal(10,0) DEFAULT NULL COMMENT '考勤应扣',
  `salary_total` decimal(10,0) NOT NULL COMMENT '薪资总和',
  `now_year_month` datetime NOT NULL COMMENT '年月',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `check_status` int(11) NOT NULL COMMENT '审核 0待审核1已审核',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_30` (`employee_id`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_detail`
--

LOCK TABLES `salary_detail` WRITE;
/*!40000 ALTER TABLE `salary_detail` DISABLE KEYS */;
INSERT INTO `salary_detail` VALUES (3,1,2100,100,100,100,0,2300,'2018-10-01 00:00:00',0,'2018-10-29 00:00:00',0,'null'),(4,1,2000,100,100,100,0,2300,'2018-09-01 00:00:00',0,'2018-09-29 00:00:00',0,'null'),(5,1,2500,100,100,100,0,2300,'2018-11-01 00:00:00',0,'2018-11-29 00:00:00',1,'null'),(6,1,2200,110,200,200,100,2610,'2018-08-01 00:08:00',0,'2018-10-15 10:49:19',0,'null'),(7,1,2100,300,100,100,100,2500,'2018-08-01 00:08:00',0,'2018-10-15 11:05:45',0,''),(8,1,2100,220,0,200,200,2320,'2018-07-01 00:00:00',0,'2018-10-15 11:12:58',0,''),(9,1,2200,200,200,200,0,2800,'2018-01-01 00:00:00',0,'2018-10-16 09:51:01',0,''),(10,1,2200,100,100,100,100,2400,'2017-01-01 00:00:00',0,'2018-10-17 17:26:31',0,''),(11,1,2200,200,110,110,200,2420,'2018-02-01 00:02:00',0,'2018-10-17 17:27:10',0,''),(12,1,21000,100,120,120,100,21240,'2017-03-01 00:03:03',0,'2018-10-17 17:27:42',0,''),(13,1,1000,200,110,110,110,1310,'2017-04-01 00:04:00',0,'2018-10-17 17:29:01',0,''),(14,1,1000,100,120,100,0,1320,'2017-05-01 00:00:00',1,'2018-10-17 17:29:32',0,''),(15,1,1100,110,110,110,0,1430,'2017-06-01 00:00:00',1,'2018-10-17 17:30:07',0,''),(16,1,1200,110,110,110,110,1420,'2017-07-01 00:00:00',1,'2018-10-17 17:30:32',0,''),(17,1,2000,100,100,100,100,2200,'2017-08-01 00:08:08',0,'2018-10-17 17:31:51',0,''),(18,1,3000,100,100,1000,100,4100,'2017-09-01 00:00:00',0,'2018-10-17 17:32:12',0,''),(19,1,2000,200,200,200,200,2400,'2017-10-01 00:00:00',0,'2018-10-17 17:32:31',0,''),(20,1,1100,110,110,110,110,1320,'2017-11-01 00:00:00',1,'2018-10-17 17:32:56',0,''),(21,1,6000,123,132,123,123,6255,'2017-12-01 00:00:00',1,'2018-10-17 17:33:19',0,''),(22,1,1000,100,100,100,100,1200,'2016-01-01 00:00:00',1,'2018-10-17 17:33:36',0,''),(23,1,1200,120,120,120,120,1440,'2016-02-01 00:00:00',1,'2018-10-17 17:35:29',0,''),(24,1,2000,100,100,1000,200,3000,'2015-01-01 00:00:00',1,'2018-10-17 20:04:40',0,''),(25,1,2000,100,100,100,100,2200,'2015-02-01 00:00:00',1,'2018-10-17 20:05:11',0,''),(26,1,2200,200,100,100,100,2500,'2014-01-01 00:01:00',0,'2018-10-22 19:56:14',0,''),(27,1,2000,100,100,100,100,2200,'2014-02-01 00:00:00',0,'2018-10-22 20:06:31',0,''),(28,1,2000,100,125,100,24,2301,'2014-03-01 00:00:00',1,'2018-10-22 20:08:39',0,''),(29,1,2000,100,125,100,23,2302,'2014-04-01 00:00:00',0,'2018-10-22 20:12:25',0,''),(30,1,2000,145,25,15,35,2150,'2014-05-01 00:00:00',0,'2018-10-22 20:12:52',0,''),(31,1,2000,210,524,153,154,2733,'2018-02-01 00:00:00',0,'2018-10-24 09:52:02',0,''),(32,1,1215,153,153,52,48,1525,'2014-05-01 00:00:00',1,'2018-10-24 10:43:20',0,''),(33,1,1520,151,153,535,81,2278,'2013-02-01 00:00:00',1,'2018-10-24 10:43:38',0,''),(34,1,1,1,1,1,1,3,'2018-02-01 00:00:00',1,'2018-10-24 15:46:25',0,''),(35,1,1,1,1,1,1,3,'2018-03-01 00:00:00',1,'2018-10-24 16:56:31',0,''),(36,1,1000,120,35,15,50,1120,'2013-05-01 00:00:00',1,'2018-10-24 19:08:52',0,''),(37,1,1000,121,35,15,156,1015,'2013-06-01 00:00:00',1,'2018-10-24 19:09:59',0,''),(38,1,1200,110,235,11,245,1311,'2013-09-01 00:00:00',1,'2018-10-24 19:51:01',0,''),(39,1,1200,100,100,100,100,1400,'2019-01-01 00:00:00',1,'2018-10-24 23:37:10',0,''),(40,1,1200,100,100,100,100,1400,'2019-02-01 00:00:00',1,'2018-10-24 23:39:36',0,''),(41,1,1200,110,100,100,100,1410,'2019-03-01 00:00:00',1,'2018-10-24 23:43:31',0,'');
/*!40000 ALTER TABLE `salary_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_feedback`
--

DROP TABLE IF EXISTS `training_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `training_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工信息表ID',
  `training_info_id` bigint(20) DEFAULT NULL COMMENT '培训信息表ID',
  `training_feedback` varchar(255) DEFAULT NULL COMMENT '反馈内容',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1激活\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_23` (`training_info_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`training_info_id`) REFERENCES `training_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_feedback`
--

LOCK TABLES `training_feedback` WRITE;
/*!40000 ALTER TABLE `training_feedback` DISABLE KEYS */;
INSERT INTO `training_feedback` VALUES (1,9,2,'还行',1,'2018-10-18 00:56:32',''),(2,4,1,'还行',0,'2018-10-16 00:56:32',NULL),(3,4,3,'还行',1,'2018-10-12 00:56:32',''),(4,4,9,'还行111',1,'2018-10-20 00:56:32',''),(5,4,10,'还行',1,'2018-10-22 00:56:32',NULL),(6,4,11,'还行',1,'2018-10-21 00:56:32',NULL),(7,4,12,'还行',1,'2018-10-29 00:56:32',NULL),(8,4,13,'还行',1,'2018-10-28 00:56:32',NULL),(9,9,4,'还行',1,'2018-10-26 00:56:32',NULL),(10,9,5,'还行',1,'2018-10-27 00:56:32',NULL),(11,9,6,'还行',1,'2018-10-25 00:56:32',NULL),(12,9,7,'还行',1,'2018-10-24 00:56:32',NULL),(13,9,8,'还行',1,'2018-10-23 00:56:32',NULL);
/*!40000 ALTER TABLE `training_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_info`
--

DROP TABLE IF EXISTS `training_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `training_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工id',
  `lecturer` varchar(30) NOT NULL COMMENT '讲师',
  `time` datetime NOT NULL COMMENT '培训开始时间',
  `duration` varchar(30) NOT NULL COMMENT '培训计划时长',
  `purpose` varchar(255) NOT NULL COMMENT '培训目的',
  `number` int(11) DEFAULT NULL COMMENT '计划人数',
  `cost` decimal(10,0) NOT NULL COMMENT '计划费用',
  `place` varchar(255) NOT NULL COMMENT '培训地点',
  `content` varchar(255) NOT NULL COMMENT '培训内容',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0冻结 1未进行 2在进行\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_info`
--

LOCK TABLES `training_info` WRITE;
/*!40000 ALTER TABLE `training_info` DISABLE KEYS */;
INSERT INTO `training_info` VALUES (1,4,NULL,'卢老师','2018-10-26 00:45:52','5','培养后台框架技术',50,3000,'华为小机房','spring+springMVC+mybatis',1,'2018-10-26 00:45:52',''),(2,NULL,9,'坤老师','2018-10-24 00:00:00','5','培养员工个人技能',NULL,1000,'更衣间','deep dark fantasy111',1,'2018-10-26 00:47:31',''),(3,4,NULL,'卢老师','2018-10-24 00:00:00','4','培养后台框架技术',50,3000,'华为小机房11','spring+springMVC+mybatis',2,'2018-10-26 00:47:31',''),(4,NULL,9,'坤老师','2018-10-24 00:00:00','4','培养员工个人技能',NULL,1000,'更衣间','deep dark fantasy',2,'2018-10-26 00:47:31',NULL),(5,NULL,9,'坤老师','2018-10-26 00:45:52','3','培养员工个人技能',NULL,1000,'更衣间','deep dark fantasy',1,'2018-10-26 00:47:31',NULL),(6,NULL,9,'坤老师','2018-10-26 00:45:52','3','培养员工个人技能',NULL,1000,'更衣间','deep dark fantasy',1,'2018-10-26 00:47:31',NULL),(7,NULL,9,'坤老师','2018-10-24 00:00:00','5','培养员工个人技能',NULL,1000,'更衣间','deep dark fantasy',1,'2018-10-26 00:47:31',NULL),(8,NULL,9,'坤老师','2018-10-26 00:45:52','5','培养员工个人技能',NULL,1000,'更衣间','deep dark fantasy',1,'2018-10-26 00:47:31',NULL),(9,4,NULL,'卢老师','2018-10-26 00:45:52','4','培养后台框架技术',50,3000,'华为小机房','spring+springMVC+mybatis',1,'2018-10-26 00:47:31',NULL),(10,4,NULL,'卢老师','2018-10-26 00:45:52','4','培养后台框架技术',50,3000,'华为小机房','spring+springMVC+mybatis',1,'2018-10-26 00:47:31',NULL),(11,4,NULL,'卢老师','2018-10-26 00:45:52','3','培养后台框架技术',50,3000,'华为小机房','spring+springMVC+mybatis',1,'2018-10-26 00:47:31',NULL),(12,4,NULL,'卢老师','2018-10-24 00:00:00','3','培养后台框架技术',50,3000,'华为小机房','spring+springMVC+mybatis',1,'2018-10-26 00:47:31',NULL),(13,4,NULL,'卢老师','2018-10-26 00:45:52','6','培养后台框架技术',50,3000,'华为小机房','spring+springMVC+mybatis',1,'2018-10-26 00:47:31',NULL);
/*!40000 ALTER TABLE `training_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `written_examination`
--

DROP TABLE IF EXISTS `written_examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `written_examination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `resume_id` bigint(20) NOT NULL COMMENT '简历id',
  `exam_content_id` bigint(20) NOT NULL COMMENT '笔试内容id',
  `exam_start` datetime NOT NULL COMMENT '笔试时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `exam_score` decimal(10,0) NOT NULL COMMENT '笔试成绩',
  `exam_result` int(11) NOT NULL COMMENT '笔试结果\n            {\n            	1一面 0落选\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `exam_end` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_19` (`exam_content_id`),
  KEY `FK_Reference_20` (`resume_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`exam_content_id`) REFERENCES `written_examination_content` (`id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `written_examination`
--

LOCK TABLES `written_examination` WRITE;
/*!40000 ALTER TABLE `written_examination` DISABLE KEYS */;
INSERT INTO `written_examination` VALUES (1,2,2,'2018-10-22 14:37:43','note1',41,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(2,3,3,'2018-10-22 14:37:43','note2',42,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(3,4,4,'2018-10-22 14:37:43','note3',43,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(4,5,5,'2018-10-22 14:37:43','note4',44,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(5,6,6,'2018-10-22 14:37:43','note5',45,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(6,7,7,'2018-10-22 14:37:43','note6',46,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(7,8,8,'2018-10-22 14:37:43','note7',47,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(8,9,9,'2018-10-22 14:37:43','note8',48,1,'2018-10-22 14:37:43','2018-10-22 14:37:43'),(9,10,10,'2018-10-22 14:37:44','note9',49,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(10,11,11,'2018-10-22 14:37:44','note10',50,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(11,12,12,'2018-10-22 14:37:44','note11',51,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(12,13,13,'2018-10-22 14:37:44','note12',52,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(13,14,14,'2018-10-22 14:37:44','note13',53,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(14,15,15,'2018-10-22 14:37:44','note14',54,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(15,16,16,'2018-10-22 14:37:44','note15',55,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(16,17,17,'2018-10-22 14:37:44','note16',56,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(17,18,18,'2018-10-22 14:37:44','note17',57,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(18,19,19,'2018-10-22 14:37:44','note18',58,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(19,20,20,'2018-10-22 14:37:44','note19',59,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(20,21,21,'2018-10-22 14:37:44','note20',60,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(21,22,22,'2018-10-22 14:37:44','note21',61,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(22,23,23,'2018-10-22 14:37:44','note22',62,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(23,24,24,'2018-10-22 14:37:44','note23',63,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(24,25,25,'2018-10-22 14:37:44','note24',64,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(25,26,26,'2018-10-22 14:37:44','note25',65,1,'2018-10-22 14:37:44','2018-10-22 14:37:44'),(26,27,27,'2018-10-22 14:37:45','note26',66,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(27,28,28,'2018-10-22 14:37:45','note27',67,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(28,29,29,'2018-10-22 14:37:45','note28',68,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(29,30,30,'2018-10-22 14:37:45','note29',69,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(30,31,31,'2018-10-22 14:37:45','note30',70,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(31,32,32,'2018-10-22 14:37:45','note31',71,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(32,33,33,'2018-10-22 14:37:45','note32',72,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(33,34,34,'2018-10-22 14:37:45','note33',73,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(34,35,35,'2018-10-22 14:37:45','note34',74,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(35,36,36,'2018-10-22 14:37:45','note35',75,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(36,37,37,'2018-10-22 14:37:45','note36',76,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(37,38,38,'2018-10-22 14:37:45','note37',77,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(38,39,39,'2018-10-22 14:37:45','note38',78,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(39,40,40,'2018-10-22 14:37:45','note39',79,1,'2018-10-22 14:37:45','2018-10-22 14:37:45'),(40,41,41,'2018-10-22 14:37:45','note40',80,1,'2018-10-22 14:37:45','2018-10-22 14:37:45');
/*!40000 ALTER TABLE `written_examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `written_examination_content`
--

DROP TABLE IF EXISTS `written_examination_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `written_examination_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，主键自增',
  `one_id` bigint(20) NOT NULL COMMENT '题目1id',
  `two_id` bigint(20) NOT NULL COMMENT '题目2id',
  `three_id` bigint(20) NOT NULL COMMENT '题目3id',
  `four_id` bigint(20) NOT NULL COMMENT '题目4id',
  `five_id` bigint(20) NOT NULL COMMENT '题目5id',
  `six_id` bigint(20) NOT NULL COMMENT '题目6id',
  `seven_id` bigint(20) NOT NULL COMMENT '题目7id',
  `eight_id` bigint(20) NOT NULL COMMENT '题目8id',
  `nine_id` bigint(20) NOT NULL COMMENT '题目9id',
  `ten_id` bigint(20) NOT NULL COMMENT '题目10id',
  `state` int(11) NOT NULL COMMENT '状态\n            {\n            	0异常 1正常\n            }',
  `create_time` datetime NOT NULL COMMENT '录入时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_10` (`two_id`),
  KEY `FK_Reference_11` (`three_id`),
  KEY `FK_Reference_12` (`four_id`),
  KEY `FK_Reference_13` (`five_id`),
  KEY `FK_Reference_14` (`six_id`),
  KEY `FK_Reference_15` (`seven_id`),
  KEY `FK_Reference_16` (`eight_id`),
  KEY `FK_Reference_17` (`nine_id`),
  KEY `FK_Reference_18` (`ten_id`),
  KEY `FK_Reference_9` (`one_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`two_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`three_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`four_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`five_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`six_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`seven_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`eight_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`nine_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`ten_id`) REFERENCES `examination_questions` (`id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`one_id`) REFERENCES `examination_questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `written_examination_content`
--

LOCK TABLES `written_examination_content` WRITE;
/*!40000 ALTER TABLE `written_examination_content` DISABLE KEYS */;
INSERT INTO `written_examination_content` VALUES (1,11,12,13,14,15,16,17,18,19,20,1,'2018-10-22 02:02:49','note1'),(2,12,13,14,15,16,17,18,19,20,21,1,'2018-10-22 02:02:49','note2'),(3,13,14,15,16,17,18,19,20,21,22,1,'2018-10-22 02:02:49','note3'),(4,14,15,16,17,18,19,20,21,22,23,1,'2018-10-22 02:02:50','note4'),(5,15,16,17,18,19,20,21,22,23,24,1,'2018-10-22 02:02:50','note5'),(6,16,17,18,19,20,21,22,23,24,25,1,'2018-10-22 02:02:50','note6'),(7,17,18,19,20,21,22,23,24,25,26,1,'2018-10-22 02:02:50','note7'),(8,18,19,20,21,22,23,24,25,26,27,1,'2018-10-22 02:02:50','note8'),(9,19,20,21,22,23,24,25,26,27,28,1,'2018-10-22 02:02:50','note9'),(10,20,21,22,23,24,25,26,27,28,29,1,'2018-10-22 02:02:50','note10'),(11,21,22,23,24,25,26,27,28,29,30,1,'2018-10-22 02:02:50','note11'),(12,22,23,24,25,26,27,28,29,30,31,1,'2018-10-22 02:02:50','note12'),(13,23,24,25,26,27,28,29,30,31,32,1,'2018-10-22 02:02:50','note13'),(14,24,25,26,27,28,29,30,31,32,33,1,'2018-10-22 02:02:50','note14'),(15,25,26,27,28,29,30,31,32,33,34,1,'2018-10-22 02:02:50','note15'),(16,26,27,28,29,30,31,32,33,34,35,1,'2018-10-22 02:02:50','note16'),(17,27,28,29,30,31,32,33,34,35,36,1,'2018-10-22 02:02:50','note17'),(18,28,29,30,31,32,33,34,35,36,37,1,'2018-10-22 02:02:50','note18'),(19,29,30,31,32,33,34,35,36,37,38,1,'2018-10-22 02:02:50','note19'),(20,30,31,32,33,34,35,36,37,38,39,1,'2018-10-22 02:02:50','note20'),(21,31,32,33,34,35,36,37,38,39,40,1,'2018-10-22 02:02:50','note21'),(22,32,33,34,35,36,37,38,39,40,41,1,'2018-10-22 02:02:50','note22'),(23,33,34,35,36,37,38,39,40,41,42,1,'2018-10-22 02:02:50','note23'),(24,34,35,36,37,38,39,40,41,42,43,1,'2018-10-22 02:02:50','note24'),(25,35,36,37,38,39,40,41,42,43,44,1,'2018-10-22 02:02:50','note25'),(26,36,37,38,39,40,41,42,43,44,45,1,'2018-10-22 02:02:51','note26'),(27,37,38,39,40,41,42,43,44,45,46,1,'2018-10-22 02:02:51','note27'),(28,38,39,40,41,42,43,44,45,46,47,1,'2018-10-22 02:02:51','note28'),(29,39,40,41,42,43,44,45,46,47,48,1,'2018-10-22 02:02:51','note29'),(30,40,41,42,43,44,45,46,47,48,49,1,'2018-10-22 02:02:51','note30'),(31,41,42,43,44,45,46,47,48,49,50,1,'2018-10-22 02:02:51','note31'),(32,42,43,44,45,46,47,48,49,50,51,1,'2018-10-22 02:02:51','note32'),(33,43,44,45,46,47,48,49,50,51,52,1,'2018-10-22 02:02:51','note33'),(34,44,45,46,47,48,49,50,51,52,53,1,'2018-10-22 02:02:51','note34'),(35,45,46,47,48,49,50,51,52,53,54,1,'2018-10-22 02:02:51','note35'),(36,46,47,48,49,50,51,52,53,54,55,1,'2018-10-22 02:02:51','note36'),(37,47,48,49,50,51,52,53,54,55,56,1,'2018-10-22 02:02:51','note37'),(38,48,49,50,51,52,53,54,55,56,57,1,'2018-10-22 02:02:51','note38'),(39,49,50,51,52,53,54,55,56,57,58,1,'2018-10-22 02:02:51','note39'),(40,50,51,52,53,54,55,56,57,58,59,1,'2018-10-22 02:02:51','note40'),(41,51,52,53,54,55,56,57,58,59,60,1,'2018-10-22 02:02:51','note41');
/*!40000 ALTER TABLE `written_examination_content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-26  1:34:49
