/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.25 : Database - course
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`course` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `course`;

/*Table structure for table `addusercase` */

DROP TABLE IF EXISTS `addusercase`;

CREATE TABLE `addusercase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `sex` tinyint DEFAULT NULL,
  `age` int DEFAULT NULL,
  `permission` tinyint DEFAULT NULL COMMENT '权限 0管理员1普通用户',
  `isDelete` tinyint DEFAULT NULL COMMENT '是否删除',
  `expected` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '期望结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `addusercase` */

insert  into `addusercase`(`id`,`userName`,`password`,`sex`,`age`,`permission`,`isDelete`,`expected`) values (1,'zhao9','zhaozhao',0,35,1,0,'true');

/*Table structure for table `getuserinfocase` */

DROP TABLE IF EXISTS `getuserinfocase`;

CREATE TABLE `getuserinfocase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `expected` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `getuserinfocase` */

insert  into `getuserinfocase`(`id`,`userId`,`expected`) values (1,1,'getUserInfo');

/*Table structure for table `getuserlistcase` */

DROP TABLE IF EXISTS `getuserlistcase`;

CREATE TABLE `getuserlistcase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` tinyint DEFAULT NULL,
  `expected` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `getuserlistcase` */

insert  into `getuserlistcase`(`id`,`userName`,`age`,`sex`,`expected`) values (1,NULL,NULL,0,'getUserList');

/*Table structure for table `logincase` */

DROP TABLE IF EXISTS `logincase`;

CREATE TABLE `logincase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `expected` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '期望结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `logincase` */

insert  into `logincase`(`id`,`userName`,`password`,`expected`) values (1,'zhangsan','123456','true'),(2,'zhangsanerror','123','false');

/*Table structure for table `updateuserinfocase` */

DROP TABLE IF EXISTS `updateuserinfocase`;

CREATE TABLE `updateuserinfocase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `userName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `sex` tinyint DEFAULT NULL,
  `age` int DEFAULT NULL,
  `permission` tinyint DEFAULT NULL,
  `isDelete` tinyint DEFAULT NULL,
  `expected` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `updateuserinfocase` */

insert  into `updateuserinfocase`(`id`,`userId`,`userName`,`sex`,`age`,`permission`,`isDelete`,`expected`) values (1,2,'hahahaha',NULL,NULL,NULL,NULL,'getUpdateUserInfo'),(2,8,NULL,NULL,NULL,NULL,1,'getUpdateUserInfo');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `age` int DEFAULT NULL COMMENT '年龄',
  `sex` int DEFAULT NULL COMMENT '0男1女',
  `permission` int DEFAULT NULL COMMENT '0管理员1普通用户',
  `isDelete` int DEFAULT NULL COMMENT '是否被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`password`,`age`,`sex`,`permission`,`isDelete`) values (1,'zhangsan','123456',20,0,0,0),(2,'lisi','123456',25,1,1,0),(3,'wangwu','123456',30,0,1,0),(4,'zhaoliu','123456',40,1,1,0),(5,'zhang1','123',20,0,0,0),(6,'zhao2','wqer',30,1,1,0),(7,'li3','sdffa',50,1,0,0),(8,'wu5','qazedx',40,1,0,0);

/*Table structure for table `user2` */

DROP TABLE IF EXISTS `user2`;

CREATE TABLE `user2` (
  `id` int DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `user2` */

insert  into `user2`(`id`,`name`,`age`,`sex`) values (1,'zhangsan',18,'男'),(2,'lisi',20,'女'),(3,'王五',25,'男');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
