/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : hezong

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2022-06-23 00:54:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `submenu`
-- ----------------------------
DROP TABLE IF EXISTS `submenu`;
CREATE TABLE `submenu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `mid` int(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  CONSTRAINT `submenu_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `mainmenu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submenu
-- ----------------------------
INSERT INTO `submenu` VALUES ('101', '用户列表', '/user', '100');
INSERT INTO `submenu` VALUES ('102', '修改权限', '/rights', '100');
INSERT INTO `submenu` VALUES ('103', '公司主页管理', '/management', '100');
INSERT INTO `submenu` VALUES ('104', '产品模块', '/product', '100');
INSERT INTO `submenu` VALUES ('201', '公司主页管理', '/Introduction', '200');
INSERT INTO `submenu` VALUES ('202', '用户列表', '/calories', '200');
INSERT INTO `submenu` VALUES ('203', '产品模块', '/food', '200');
