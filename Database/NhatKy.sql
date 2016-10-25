/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbh

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-10-26 02:29:43
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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhatky
-- ----------------------------
INSERT INTO `nhatky` VALUES ('38', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 02:08:29', '');
INSERT INTO `nhatky` VALUES ('39', 'ND0002 - ntttue', 'Bộ phận công ty', 'Xóa', '2016-10-26 02:08:37', '');
INSERT INTO `nhatky` VALUES ('40', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 02:11:05', '');
INSERT INTO `nhatky` VALUES ('41', 'ND0002 - ntttue', 'Đơn vị tính', 'Thêm', '2016-10-26 02:11:24', '');
INSERT INTO `nhatky` VALUES ('42', 'ND0002 - ntttue', 'Đơn vị tính', 'Cập nhật', '2016-10-26 02:11:45', '');
INSERT INTO `nhatky` VALUES ('43', 'ND0002 - ntttue', 'Đơn vị tính', 'Xóa', '2016-10-26 02:12:12', '');
