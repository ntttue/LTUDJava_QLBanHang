/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbh

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-10-25 18:53:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for nhatky
-- ----------------------------
DROP TABLE IF EXISTS `nhatky`;
CREATE TABLE `nhatky` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nguoidung` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bang` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hanhdong` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay` datetime DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhatky
-- ----------------------------
INSERT INTO `nhatky` VALUES ('1', 'admin', 'NhanVien', 'Them', '2016-10-25 15:09:04', '');
INSERT INTO `nhatky` VALUES ('2', 'admin', 'NhanVien', 'Them', '2016-10-25 15:09:04', '');
INSERT INTO `nhatky` VALUES ('5', 'abc', 'abc', 'abc', '2016-10-25 18:26:12', '');
INSERT INTO `nhatky` VALUES ('6', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-25 18:32:27', '');
INSERT INTO `nhatky` VALUES ('7', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-25 18:43:38', '');
INSERT INTO `nhatky` VALUES ('8', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-25 18:43:58', '');
INSERT INTO `nhatky` VALUES ('9', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-25 18:44:50', '');
INSERT INTO `nhatky` VALUES ('10', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-25 18:51:28', '');
INSERT INTO `nhatky` VALUES ('11', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-25 18:51:58', '');
