/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbh

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-10-25 15:49:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for nhatky
-- ----------------------------
DROP TABLE IF EXISTS `nhatky`;
CREATE TABLE `nhatky` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NguoiDung` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Table` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HanhDong` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Ngay` datetime DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhatky
-- ----------------------------
INSERT INTO `nhatky` VALUES ('1', 'admin', 'NhanVien', 'Them', '2016-10-25 15:09:04', '');
