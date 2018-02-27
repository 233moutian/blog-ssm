/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : gw

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2016-06-07 13:55:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gw_admin
-- ----------------------------
DROP TABLE IF EXISTS `gw_admin`;
CREATE TABLE `gw_admin` (
  `a_id` bigint(20) NOT NULL auto_increment,
  `account` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `phone_number` varchar(11) default NULL,
  PRIMARY KEY  (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gw_admin
-- ----------------------------
INSERT INTO `gw_admin` VALUES ('1', 'hhbbz', 'e10adc3949ba59abbe56e057f20f883e', null, null, null);
INSERT INTO `gw_admin` VALUES ('2', 'hhbbzz', 'e10adc3949ba59abbe56e057f20f883e', null, null, null);
