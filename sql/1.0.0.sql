/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : hezong

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2022-06-23 00:59:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `easyuser`
-- ----------------------------
DROP TABLE IF EXISTS `easyuser`;
CREATE TABLE `easyuser` (
  `id` int(24) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `state` tinyint(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easyuser
-- ----------------------------
INSERT INTO `easyuser` VALUES ('1', 'admin', '12345699', '123@qq.com', '超级管理员', '1');
INSERT INTO `easyuser` VALUES ('2', 'zhangsan', 'aaaaaa', 'zhangsan@qq.com', '普通管理员', '1');
INSERT INTO `easyuser` VALUES ('3', 'admin001', 'popop', 'aaaa@qq.com', '普通用户', '1');
INSERT INTO `easyuser` VALUES ('4', '这是一个用户', '9999912', 'bbbb@163.com', '普通用户', '0');
INSERT INTO `easyuser` VALUES ('7', 'admin003', 'q123456', 'aaabb@qq.com', '普通用户', '1');
INSERT INTO `easyuser` VALUES ('8', 'admin005', '123456', 'asdasd@qq.com', '普通用户', '0');
INSERT INTO `easyuser` VALUES ('9', 'admin007', '123456', 'opopos@qq.com', '普通用户', '0');
INSERT INTO `easyuser` VALUES ('10', 'yuan', 'aaa000', 'yuan@163.com', '超级管理员', '1');

-- ----------------------------
-- Table structure for `mainmenu`
-- ----------------------------
DROP TABLE IF EXISTS `mainmenu`;
CREATE TABLE `mainmenu` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainmenu
-- ----------------------------
INSERT INTO `mainmenu` VALUES ('100', '基本管理', '/admin');
INSERT INTO `mainmenu` VALUES ('200', '科技平台', '/tech');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ID` int(24) NOT NULL AUTO_INCREMENT,
  `PRODNAME` varchar(255) NOT NULL COMMENT '产品名称',
  `AUTOTYPE` varchar(500) DEFAULT NULL COMMENT '车型',
  `OEM` varchar(500) DEFAULT NULL COMMENT '零件号',
  `UPDATETIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATEUSER` varchar(20) DEFAULT NULL COMMENT '添加用户',
  `IMAGEPATH` varchar(255) DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

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
