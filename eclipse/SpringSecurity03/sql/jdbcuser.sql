/*
Navicat MySQL Data Transfer

Source Server         : huangdaye
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : ensong

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-06-28 12:08:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(64) NOT NULL,
  `authority` varchar(64) NOT NULL,
  PRIMARY KEY (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('lisi', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('wangwu', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('wangwu', 'ROLE_USER');
INSERT INTO `authorities` VALUES ('zhangsan', 'ROLE_USER');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('lisi', '123', '1');
INSERT INTO `users` VALUES ('wangwu', '123', '1');
INSERT INTO `users` VALUES ('zhangsan', '123', '1');
