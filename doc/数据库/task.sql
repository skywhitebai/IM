/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.3-m13 : Database - task
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`task` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `task`;

/*Table structure for table `common_user` */

DROP TABLE IF EXISTS `common_user`;

CREATE TABLE `common_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `gender` int(2) DEFAULT NULL COMMENT '性别1男2女3秘密',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) DEFAULT NULL COMMENT '状态0停用 1 启用',
  `login_times` int(11) DEFAULT NULL COMMENT '登陆次数',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `common_user` */

insert  into `common_user`(`user_id`,`user_name`,`password`,`mobile`,`real_name`,`gender`,`email`,`status`,`login_times`,`last_login_time`,`remark`,`create_time`,`create_by`,`update_time`,`update_by`) values (1,'admin','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'123','123','13925100150','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'123','123','13925100150','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'123','123','13925100150','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'123','123','13925100150','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'123','123','13925100150','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `begin_time_plan` datetime DEFAULT NULL COMMENT '计划开始时间',
  `end_time_plan` datetime DEFAULT NULL COMMENT '计划结束时间',
  `begin_time_actual` datetime DEFAULT NULL COMMENT '实际开始时间',
  `end_time_actual` datetime DEFAULT NULL COMMENT '实际结束时间',
  `status` int(11) DEFAULT NULL COMMENT '1未开始，2进行中，3，已完成，4超时未完成',
  `progress` decimal(10,0) DEFAULT NULL COMMENT '进度',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `task` */

/*Table structure for table `task_deal` */

DROP TABLE IF EXISTS `task_deal`;

CREATE TABLE `task_deal` (
  `id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务id',
  `deal_user_id` bigint(20) DEFAULT NULL COMMENT '处理人',
  `content` varchar(500) DEFAULT NULL COMMENT '处理内容',
  `progress` decimal(10,0) DEFAULT NULL COMMENT '进度',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `deal_time` datetime DEFAULT NULL COMMENT '处理时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `task_deal` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
