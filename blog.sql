/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : gw

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2017-08-20 23:57:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gw_admin`
-- ----------------------------
DROP TABLE IF EXISTS `blog_admin`;
CREATE TABLE `blog_admin` (
  `a_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_admin
-- ----------------------------
INSERT INTO `blog_admin` VALUES ('10', 'llssz', '56a0281fd65d73f05cedd7d94bb561ee', 'lz', '', '');

-- ----------------------------
-- Table structure for `gw_user`
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `u_id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_user
-- ----------------------------

DROP TABLE IF EXISTS `blog_blog`;
CREATE TABLE `blog_blog` (
  `b_id` varchar(255) NOT NULL DEFAULT '',
  `a_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `release_date` datetime DEFAULT NULL,
  `click_hit` int(11) DEFAULT NULL,
  `reply_hit` int(11) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_blog
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_comment`
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `c_id` varchar(255) NOT NULL DEFAULT '',
  `b_id` varchar(255) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `parents_id` varchar(255) DEFAULT NULL,
  `commenter` varchar(20) DEFAULT NULL,
  `comment` varchar(2555) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------
INSERT INTO `blog_blog` VALUES ('1414141', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('2', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('3', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('14', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('15', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('16', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('17', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('18', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('19', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('10', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('21', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('31', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('41', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('51', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('61', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('71', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('81', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('91', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('111', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('121', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('1131', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('141', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('151', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('161', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('711', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('181', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('381', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('481', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('4851', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('681', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('791', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('4431', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('12231', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('42341', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('243331', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('3333321', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('11231312111', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
INSERT INTO `blog_blog` VALUES ('25252222242421', '1', '1', '1', '2018-03-13 15:57:33', '1', '1', '1', '2018-03-30 15:57:39', '2018-03-15 15:57:43');
