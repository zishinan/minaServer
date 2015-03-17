/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : schooldata

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2015-03-17 22:04:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dir`
-- ----------------------------
DROP TABLE IF EXISTS `dir`;
CREATE TABLE `dir` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dir
-- ----------------------------

-- ----------------------------
-- Table structure for `orderform`
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `products` text,
  `price` int(11) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `dir_id` bigint(255) DEFAULT NULL,
  `smalldir_id` bigint(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `disPrice` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `saleCount` int(11) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '肥皂', '1', '2', '12', '6', null, '0', '0');
INSERT INTO `product` VALUES ('2', '香皂', '1', '2', '15', '6', null, '0', '0');

-- ----------------------------
-- Table structure for `smalldir`
-- ----------------------------
DROP TABLE IF EXISTS `smalldir`;
CREATE TABLE `smalldir` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `dir_id` bigint(20) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smalldir
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `schNum` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1:学生;2:老师;3:管理员',
  `password` varchar(255) DEFAULT NULL,
  `clazz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王五', '2011211090', '1', '2011211090', '11地信2班');
INSERT INTO `user` VALUES ('2', '张三丰', '2011211380', '1', '2011211380', '11新闻1班');
INSERT INTO `user` VALUES ('3', '大侠', '2012211190', '1', '2012211190', '计科1班');
INSERT INTO `user` VALUES ('4', '李武', '2011211012', '1', '2011211012', '机电1班');
INSERT INTO `user` VALUES ('5', 'admin', '0000000000', '3', '0000000000', '管理员');
