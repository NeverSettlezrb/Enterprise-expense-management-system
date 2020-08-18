/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.62 : Database - sju
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sju` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sju`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL AUTO_INCREMENT,
  `deptname` varchar(20) DEFAULT NULL,
  `isnull` int(11) DEFAULT NULL,
  PRIMARY KEY (`deptno`),
  UNIQUE KEY `deptname` (`deptname`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`deptno`,`deptname`,`isnull`) values (1,'财务部',0),(2,'开发部',0),(3,'销售部',0),(4,'外联部',0),(5,'系统管理部',0),(6,'测试部',0),(7,'文艺部',1),(8,'测试3',1);

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(20) DEFAULT NULL,
  `murl` varchar(20) DEFAULT NULL,
  `fathername` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`mid`,`mname`,`murl`,`fathername`) values (6,'系统管理',NULL,NULL),(7,'报销管理',NULL,NULL),(8,'工资管理',NULL,NULL),(9,'报表管理',NULL,NULL),(10,'查看工资','jsp/listsal.jsp',8),(11,'发放工资','jsp/setsal.jsp',8),(12,'查看所有人工资','jsp/listallsal.jsp',8),(13,'个人信息管理','jsp/icount.jsp',24),(14,'用户管理','jsp/usercontrol.jsp',6),(15,'角色管理','jsp/rolecontrol.jsp',6),(16,'菜单管理','jsp/menucontrol.jsp',6),(17,'部门管理','jsp/deptcontrol.jsp',6),(18,'报销单','jsp/cost.jsp',7),(19,'个人报销查询','jsp/listmycost.jsp',7),(20,'查询所有报销单','jsp/listallcost.jsp',7),(21,'审批','jsp/jinglicost.jsp',7),(22,'复审','jsp/caiwucost.jsp',7),(23,'报销统计','jsp/costcount.jsp',9),(24,'账户管理',NULL,NULL);

/*Table structure for table `menu_copy` */

DROP TABLE IF EXISTS `menu_copy`;

CREATE TABLE `menu_copy` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(20) DEFAULT NULL,
  `murl` varchar(20) DEFAULT NULL,
  `fathername` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `menu_copy` */

insert  into `menu_copy`(`mid`,`mname`,`murl`,`fathername`) values (6,'系统管理',NULL,NULL),(7,'报销管理',NULL,NULL),(8,'工资管理',NULL,NULL),(9,'报表管理',NULL,NULL),(10,'查看工资','jsp/listsal.jsp',8),(11,'发放工资','jsp/setsal.jsp',8),(12,'查看所有人工资','jsp/listallsal.jsp',8),(13,'个人信息管理','jsp/icount.jsp',24),(14,'用户管理','jsp/usercontrol.jsp',6),(15,'角色管理','jsp/rolecontrol.jsp',6),(16,'菜单管理','jsp/menucontrol.jsp',6),(17,'部门管理','jsp/deptcontrol.jsp',6),(18,'报销单','jsp/cost.jsp',7),(19,'个人报销查询','jsp/listmycost.jsp',7),(20,'查询所有报销单','jsp/listallcost.jsp',7),(21,'审批','jsp/jinglicost.jsp',7),(22,'复审','jsp/caiwucost.jsp',7),(23,'报销统计','jsp/costcount.jsp',9),(24,'账户管理',NULL,NULL);

/*Table structure for table `msg` */

DROP TABLE IF EXISTS `msg`;

CREATE TABLE `msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `os` varchar(20) DEFAULT NULL,
  `ueslun` varchar(20) DEFAULT NULL,
  `advice` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `msg` */

insert  into `msg`(`id`,`name`,`email`,`age`,`time`,`os`,`ueslun`,`advice`) values (3,'翟雨欣','1069924987@qq.com',18,'小于6个月','Win_2000','java','妙');

/*Table structure for table `report` */

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `reid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `tips` varchar(1000) DEFAULT NULL,
  `redate` date DEFAULT NULL,
  `caiwu` int(11) DEFAULT NULL,
  `jingli` int(11) DEFAULT NULL,
  `reisexit` int(11) DEFAULT NULL,
  PRIMARY KEY (`reid`),
  KEY `FK_Reference_6` (`uid`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `report` */

insert  into `report`(`reid`,`uid`,`money`,`tips`,`redate`,`caiwu`,`jingli`,`reisexit`) values (1,1,123,'吃饭','2020-05-23',2,1,0),(2,1,124234,'外出出差','2020-05-23',1,1,0),(3,2,123,'出差','2020-05-23',3,2,0),(4,1,324,'测试','2020-05-23',2,1,0),(5,1,24,'吃饭报销','2020-05-23',2,1,0),(6,2,213,'住宿','2020-05-23',2,1,0),(7,2,231,'车费','2020-05-23',2,1,0),(8,2,23,'车费','2020-05-23',1,1,0),(9,2,23234,'出差车费睡觉','2020-05-23',1,1,0),(10,1,666,'测试','2020-05-27',3,2,0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(20) DEFAULT NULL,
  `isexitrole` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `rname` (`rname`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`rid`,`rname`,`isexitrole`) values (1,'系统管理员',0),(2,'财务',0),(3,'经理',0),(4,'普通员工',0),(5,'技术总监',1);

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `rm_num` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `MID` int(11) DEFAULT NULL,
  PRIMARY KEY (`rm_num`),
  KEY `FK_Reference_3` (`rid`),
  KEY `FK_Reference_4` (`MID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`MID`) REFERENCES `menu` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

insert  into `role_menu`(`rm_num`,`rid`,`MID`) values (48,1,7),(49,1,8),(50,1,10),(51,1,12),(52,1,9),(53,1,13),(54,1,6),(55,1,15),(56,1,14),(57,1,17),(63,1,18),(85,1,19),(110,1,20),(143,1,23),(144,1,24),(145,2,7),(146,2,8),(147,2,9),(148,2,24),(149,2,13),(150,2,18),(151,2,19),(152,2,20),(153,2,22),(154,2,10),(155,2,11),(156,2,12),(157,3,7),(158,3,8),(159,3,9),(160,3,24),(161,3,18),(162,3,19),(163,3,20),(164,3,10),(165,3,12),(166,3,13),(167,3,21),(168,4,7),(169,4,8),(170,4,9),(171,4,24),(172,4,18),(173,4,19),(174,4,13),(175,4,10);

/*Table structure for table `salary` */

DROP TABLE IF EXISTS `salary`;

CREATE TABLE `salary` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `sdata` date DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `FK_Reference_9` (`uid`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=219 DEFAULT CHARSET=utf8;

/*Data for the table `salary` */

insert  into `salary`(`sid`,`uid`,`sal`,`sdata`) values (148,1,0,'2000-00-00'),(149,2,0,'2000-00-00'),(159,3,0,'2000-00-00'),(160,4,0,'2000-00-00'),(161,5,0,'2000-00-00'),(162,6,0,'2000-00-00'),(163,2,213,'2020-06-17'),(164,3,123,'2020-06-17'),(165,6,123,'2020-06-17'),(166,4,2123,'2020-06-17'),(167,5,14,'2020-06-17'),(168,7,0,'2000-00-00'),(169,8,0,'2000-00-00'),(170,11,0,'2000-00-00'),(171,12,0,'2000-00-00'),(172,13,0,'2000-00-00'),(173,14,0,'2000-00-00'),(174,15,0,'2000-00-00'),(175,16,0,'2000-00-00'),(176,18,0,'2000-00-00'),(177,26,0,'2000-00-00'),(178,28,0,'2000-00-00'),(179,33,0,'2000-00-00'),(180,34,0,'2000-00-00'),(181,36,0,'2000-00-00'),(182,37,0,'2000-00-00'),(183,38,0,'2000-00-00'),(201,2,213,'2020-06-18'),(202,7,123,'2020-06-18'),(203,16,2123,'2020-06-18'),(205,3,123,'2020-06-18'),(206,6,123,'2020-06-18'),(207,39,0,'2000-00-00'),(208,13,213,'2020-06-18'),(209,40,0,'2000-00-00'),(210,42,0,'2000-00-00'),(211,43,0,'2000-00-00'),(212,44,0,'2000-00-00'),(213,45,0,'2000-00-00'),(214,46,0,'2000-00-00'),(215,50,0,'2000-00-00'),(216,51,0,'2000-00-00'),(217,1,23,'2020-06-27'),(218,6,666,'2020-06-27');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `ur_num` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ur_num`),
  KEY `FK_Reference_1` (`uid`),
  KEY `FK_Reference_2` (`rid`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`ur_num`,`uid`,`rid`) values (6,5,4),(19,7,1),(20,8,3),(21,11,1),(22,12,3),(23,13,2),(25,15,2),(26,16,1),(29,28,4),(31,34,4),(39,39,2),(40,39,3),(43,42,4),(52,38,2),(60,43,4),(61,43,3),(64,40,2),(65,33,1),(68,36,1),(69,37,3),(74,18,2),(76,26,3),(77,14,1),(86,2,2),(88,44,4),(92,45,3),(94,3,4),(96,46,2),(97,46,1),(103,6,4),(116,50,4),(117,51,4),(118,1,1),(119,1,2),(120,4,4),(121,4,3),(122,52,4);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `hire` date DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `userid` varchar(20) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  `isexit` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_Reference_10` (`deptno`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`uid`,`username`,`password`,`name`,`phone`,`hire`,`gender`,`age`,`email`,`userid`,`deptno`,`isexit`) values (1,'12017151010','e10adc3949ba59abbe56e057f20f883e','张荣波','15152326018','2020-05-01','男',23,'1366734774@qq.com','12017151010',5,0),(2,'12017151011','e10adc3949ba59abbe56e057f20f883e','翟雨欣','15152326018','2020-04-01','女',21,'1366734774@qq.com','12017151011',1,0),(3,'12017151012','e10adc3949ba59abbe56e057f20f883e','林晓刚','12152326013','2003-04-01','男',23,'727213123@qq.com','12017151012',3,0),(4,'12017151014','e10adc3949ba59abbe56e057f20f883e','吴东阳','52152225923','2003-04-12','男',23,'1366734774@qq.com','12017151013',4,0),(5,'12017151015','e10adc3949ba59abbe56e057f20f883e','方健','12552326113','2013-02-01','男',22,'214683@qq.com','12017151014',2,0),(6,'12017151013','e10adc3949ba59abbe56e057f20f883e','潘王辉','12122526013','2009-05-02','男',23,'2138841@qq.com','12017151015',4,0),(7,'12004002','e10adc3949ba59abbe56e057f20f883e','测试','12345678912','2020-05-18','男',23,'2138841@qq.com','12004002',4,1),(8,'12002002','e10adc3949ba59abbe56e057f20f883e','测试2','12345678912','2020-05-18','男',23,'','12002002',3,1),(11,'12002003','e10adc3949ba59abbe56e057f20f883e','测试3','12345678992','2020-05-18','男',23,NULL,'12002003',2,1),(12,'12003002','e10adc3949ba59abbe56e057f20f883e','测试4','12345678901','2020-05-18','男',23,'','12003002',3,1),(13,'12001003','e10adc3949ba59abbe56e057f20f883e','','12345678901','2020-05-18','男',22,NULL,'12001003',1,1),(14,'12002004','e10adc3949ba59abbe56e057f20f883e','','','2020-05-18','男',243,'','12002004',2,1),(15,'12003003','e10adc3949ba59abbe56e057f20f883e','','','2020-05-18','男',0,NULL,'12003003',3,1),(16,'12005002','e10adc3949ba59abbe56e057f20f883e','张荣波2','18094221350','2020-05-18','男',23,NULL,'12005002',5,1),(18,'12002005',NULL,'','','2020-05-18','女',0,'','12002005',2,1),(26,'12002006','e10adc3949ba59abbe56e057f20f883e','','','2020-05-18','男',0,'','12002006',2,1),(28,'12003004','e10adc3949ba59abbe56e057f20f883e','','','2020-05-18','男',0,NULL,'12003004',3,1),(33,'12001004','e10adc3949ba59abbe56e057f20f883e','','','2020-05-18','女',0,'','12001004',1,1),(34,'12002007','e10adc3949ba59abbe56e057f20f883e','','','2020-05-18','男',0,NULL,'12002007',2,1),(36,'12002008','e10adc3949ba59abbe56e057f20f883e','','','2020-05-18','男',0,'','12002008',2,1),(37,'12003005','e10adc3949ba59abbe56e057f20f883e','test','','2020-05-18','男',0,'','12003005',3,1),(38,'12003006','e10adc3949ba59abbe56e057f20f883e','test2','','2020-05-18','男',0,'','12003006',3,1),(39,'12002009','e10adc3949ba59abbe56e057f20f883e','test2','','2020-05-18','男',0,NULL,'12002009',2,1),(40,'120020010','e10adc3949ba59abbe56e057f20f883e','testtttt','','2020-05-19','女',0,'','120020010',1,1),(42,'12002011','e10adc3949ba59abbe56e057f20f883e','1111111','','2020-05-19','男',0,NULL,'12002011',2,1),(43,'12002012','e10adc3949ba59abbe56e057f20f883e','张66','12344556464','2020-05-19','男',23,'123456@qq.com','12002012',1,1),(44,'12004004','e10adc3949ba59abbe56e057f20f883e','','','2020-05-20','男',0,'','12004004',4,1),(45,'12004005','e10adc3949ba59abbe56e057f20f883e','','','2020-05-20','男',0,'','12004005',4,1),(46,'12005003','e10adc3949ba59abbe56e057f20f883e','','','2020-05-20','男',0,'','12005003',5,1),(50,'12004006','e10adc3949ba59abbe56e057f20f883e','','','2020-05-27','男',0,'','12004006',4,1),(51,'12004007','e10adc3949ba59abbe56e057f20f883e','','','2020-05-27','男',0,'','12004007',4,1),(52,'12004008','e10adc3949ba59abbe56e057f20f883e','','','2020-05-27','男',0,'','12004008',4,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
