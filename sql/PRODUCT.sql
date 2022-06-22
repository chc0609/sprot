/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : hezong

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2022-06-23 00:54:34
*/

SET FOREIGN_KEY_CHECKS=0;

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
