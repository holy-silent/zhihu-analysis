/*
SQLyog v10.2 
MySQL - 5.6.31 : Database - zhihu
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zhihu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zhihu`;

/*Table structure for table `zhihu_user` */

DROP TABLE IF EXISTS `zhihu_user`;

CREATE TABLE `zhihu_user` (
  `id` varchar(64) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL COMMENT '用户名',
  `user_sex` char(1) DEFAULT NULL COMMENT '性别 0女  1男',
  `home_page` varchar(256) DEFAULT NULL COMMENT '个人主页',
  `self_introduction` varchar(100) DEFAULT NULL COMMENT '一句话介绍自己',
  `home` varchar(256) DEFAULT NULL COMMENT '居住地,可多个',
  `industry` varchar(256) DEFAULT NULL COMMENT '所在行业',
  `career_experience` varchar(256) DEFAULT NULL COMMENT '职业经历',
  `educational_experience` varchar(256) DEFAULT NULL COMMENT '教育经历',
  `personal_profile` varchar(512) DEFAULT NULL COMMENT '个人简介',
  `user_image` varchar(1024) DEFAULT NULL COMMENT '用户头像URL地址',
  `following` int(16) DEFAULT NULL COMMENT '关注人数',
  `followers` int(16) DEFAULT NULL COMMENT '粉丝人数',
  `following_topics` int(16) DEFAULT NULL COMMENT '关注的话题数',
  `following_column` int(16) DEFAULT NULL COMMENT '关注的专栏数',
  `following_questions` int(16) DEFAULT NULL COMMENT '关注的问题数',
  `following_collections` int(16) DEFAULT NULL COMMENT '关注的收藏夹数',
  `get_approval` int(16) DEFAULT NULL COMMENT '获得的认同数',
  `get_thanks` int(16) DEFAULT NULL COMMENT '获得的感谢数',
  `get_collections` int(16) DEFAULT NULL COMMENT '获得的收藏数',
  `lives` int(16) DEFAULT NULL COMMENT '举办过的LIVE',
  `certification_info` varchar(256) DEFAULT NULL COMMENT '认证信息',
  `zhihu_collection` int(16) DEFAULT NULL COMMENT '知乎收录个数',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(256) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `zhihu_url_result` (
  `id` varchar(64) NOT NULL,
  `url` varchar(256) DEFAULT NULL,
  `success` char(1) DEFAULT NULL COMMENT '0 成功  1失败',
  `remarks` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
