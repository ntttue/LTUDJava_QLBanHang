/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbh

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-09-21 14:22:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bophan
-- ----------------------------
DROP TABLE IF EXISTS `bophan`;
CREATE TABLE `bophan` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bophan
-- ----------------------------

-- ----------------------------
-- Table structure for chitietphieunhap
-- ----------------------------
DROP TABLE IF EXISTS `chitietphieunhap`;
CREATE TABLE `chitietphieunhap` (
  `mahanghoa` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` double DEFAULT NULL,
  `thanhtien` double DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `maphieunhap` int(11) DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  `ma` int(11) NOT NULL,
  PRIMARY KEY (`ma`),
  KEY `chitietphieunhap_maphieunhap_fkey` (`maphieunhap`),
  KEY `chitietphieunhap_mahanghoa_fkey` (`mahanghoa`),
  CONSTRAINT `chitietphieunhap_mahanghoa_fkey` FOREIGN KEY (`mahanghoa`) REFERENCES `hanghoa` (`ma`),
  CONSTRAINT `chitietphieunhap_maphieunhap_fkey` FOREIGN KEY (`maphieunhap`) REFERENCES `phieunhap` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietphieunhap
-- ----------------------------

-- ----------------------------
-- Table structure for chitietphieuxuat
-- ----------------------------
DROP TABLE IF EXISTS `chitietphieuxuat`;
CREATE TABLE `chitietphieuxuat` (
  `ma` int(11) NOT NULL,
  `mahanghoa` int(11) DEFAULT NULL,
  `maphieuxuat` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` double DEFAULT NULL,
  `thanhtien` double DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `chitietphieuxuat_mahanghoa_fkey` (`mahanghoa`),
  KEY `chitietphieuxuat_maphieuxuat_fkey` (`maphieuxuat`),
  CONSTRAINT `chitietphieuxuat_mahanghoa_fkey` FOREIGN KEY (`mahanghoa`) REFERENCES `hanghoa` (`ma`),
  CONSTRAINT `chitietphieuxuat_maphieuxuat_fkey` FOREIGN KEY (`maphieuxuat`) REFERENCES `phieuxuat` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietphieuxuat
-- ----------------------------

-- ----------------------------
-- Table structure for congty
-- ----------------------------
DROP TABLE IF EXISTS `congty`;
CREATE TABLE `congty` (
  `ma` smallint(6) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `masothue` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `logo` longblob,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of congty
-- ----------------------------

-- ----------------------------
-- Table structure for donvitinh
-- ----------------------------
DROP TABLE IF EXISTS `donvitinh`;
CREATE TABLE `donvitinh` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of donvitinh
-- ----------------------------

-- ----------------------------
-- Table structure for hanghoa
-- ----------------------------
DROP TABLE IF EXISTS `hanghoa`;
CREATE TABLE `hanghoa` (
  `ma` int(11) NOT NULL,
  `makhohang` int(11) DEFAULT NULL,
  `manhomhang` int(11) DEFAULT NULL,
  `maloaihang` int(11) DEFAULT NULL,
  `manhacc` int(11) DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `donvi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `xuatxu` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `giamua` double DEFAULT NULL,
  `giabanle` double DEFAULT NULL,
  `giabansi` double DEFAULT NULL,
  `tonkho` int(11) DEFAULT NULL,
  `anh` longblob,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `hanghoa_manhomhang_fkey` (`manhomhang`),
  KEY `hanghoa_makhohang_fkey` (`makhohang`),
  KEY `hanghoa_manhacc_fkey` (`manhacc`),
  KEY `hanghoa_maloaihang_fkey` (`maloaihang`),
  CONSTRAINT `hanghoa_makhohang_fkey` FOREIGN KEY (`makhohang`) REFERENCES `khohang` (`ma`),
  CONSTRAINT `hanghoa_maloaihang_fkey` FOREIGN KEY (`maloaihang`) REFERENCES `loaihang` (`ma`),
  CONSTRAINT `hanghoa_manhacc_fkey` FOREIGN KEY (`manhacc`) REFERENCES `nhacungcap` (`ma`),
  CONSTRAINT `hanghoa_manhomhang_fkey` FOREIGN KEY (`manhomhang`) REFERENCES `nhomhanghoa` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hanghoa
-- ----------------------------

-- ----------------------------
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang` (
  `ma` int(11) NOT NULL,
  `makh` varchar(255) CHARACTER SET utf8 NOT NULL,
  `maloaikh` int(11) DEFAULT NULL,
  `makhuvuc` smallint(6) DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` longtext COLLATE utf8_unicode_ci,
  `masothue` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `dienthoai` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `taikhoan` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nganhang` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `gioihanno` decimal(30,10) DEFAULT NULL,
  `nohientai` decimal(30,10) DEFAULT NULL,
  `yahoo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `skype` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nguoilienhe` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `khachhang_maloaikh_fkey` (`maloaikh`),
  CONSTRAINT `khachhang_maloaikh_fkey` FOREIGN KEY (`maloaikh`) REFERENCES `loaikhachhang` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khachhang
-- ----------------------------

-- ----------------------------
-- Table structure for khohang
-- ----------------------------
DROP TABLE IF EXISTS `khohang`;
CREATE TABLE `khohang` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `manguoiql` int(11) DEFAULT NULL,
  `nguoilienhe` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `dienthoai` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diengiai` longtext COLLATE utf8_unicode_ci,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khohang
-- ----------------------------

-- ----------------------------
-- Table structure for khuvuc
-- ----------------------------
DROP TABLE IF EXISTS `khuvuc`;
CREATE TABLE `khuvuc` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khuvuc
-- ----------------------------

-- ----------------------------
-- Table structure for loaihang
-- ----------------------------
DROP TABLE IF EXISTS `loaihang`;
CREATE TABLE `loaihang` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of loaihang
-- ----------------------------

-- ----------------------------
-- Table structure for loaikhachhang
-- ----------------------------
DROP TABLE IF EXISTS `loaikhachhang`;
CREATE TABLE `loaikhachhang` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `mota` longtext COLLATE utf8_unicode_ci,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of loaikhachhang
-- ----------------------------

-- ----------------------------
-- Table structure for nguoidung
-- ----------------------------
DROP TABLE IF EXISTS `nguoidung`;
CREATE TABLE `nguoidung` (
  `tennd` varchar(255) CHARACTER SET utf8 NOT NULL,
  `matkhau` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `mavaitro` int(11) DEFAULT NULL,
  `manhanvien` smallint(6) DEFAULT NULL,
  `diengiai` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`tennd`),
  KEY `nguoidung_mavaitro_fkey` (`mavaitro`),
  CONSTRAINT `nguoidung_mavaitro_fkey` FOREIGN KEY (`mavaitro`) REFERENCES `vaitro` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nguoidung
-- ----------------------------

-- ----------------------------
-- Table structure for nhacungcap
-- ----------------------------
DROP TABLE IF EXISTS `nhacungcap`;
CREATE TABLE `nhacungcap` (
  `ma` int(11) NOT NULL,
  `makhuvuc` int(11) DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `masothue` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `taikhoan` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nganhang` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `manguoilienhe` int(11) DEFAULT NULL,
  `chucvu` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `nhacungcap_makhuvuc_fkey` (`makhuvuc`),
  CONSTRAINT `nhacungcap_makhuvuc_fkey` FOREIGN KEY (`makhuvuc`) REFERENCES `khuvuc` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhacungcap
-- ----------------------------

-- ----------------------------
-- Table structure for nhomhanghoa
-- ----------------------------
DROP TABLE IF EXISTS `nhomhanghoa`;
CREATE TABLE `nhomhanghoa` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhomhanghoa
-- ----------------------------

-- ----------------------------
-- Table structure for phieunhap
-- ----------------------------
DROP TABLE IF EXISTS `phieunhap`;
CREATE TABLE `phieunhap` (
  `ma` int(11) NOT NULL,
  `manhacc` int(11) DEFAULT NULL,
  `manvn` int(11) DEFAULT NULL,
  `makho` int(11) DEFAULT NULL,
  `ngaynhap` date DEFAULT NULL,
  `tongtien` double DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `phieunhap_manhacc_fkey` (`manhacc`),
  KEY `phieunhap_makho_fkey` (`makho`),
  CONSTRAINT `phieunhap_makho_fkey` FOREIGN KEY (`makho`) REFERENCES `khohang` (`ma`),
  CONSTRAINT `phieunhap_manhacc_fkey` FOREIGN KEY (`manhacc`) REFERENCES `nhacungcap` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of phieunhap
-- ----------------------------

-- ----------------------------
-- Table structure for phieuxuat
-- ----------------------------
DROP TABLE IF EXISTS `phieuxuat`;
CREATE TABLE `phieuxuat` (
  `ma` int(11) NOT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `makho` int(11) DEFAULT NULL,
  `ngaygiao` date DEFAULT NULL,
  `manvbh` int(11) DEFAULT NULL,
  `ngaylap` date DEFAULT NULL,
  `makhachhang` int(11) DEFAULT NULL,
  `tongtien` double DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `phieuxuat_makho_fkey` (`makho`),
  KEY `phieuxuat_makhachhang_fkey` (`makhachhang`),
  CONSTRAINT `phieuxuat_makhachhang_fkey` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`ma`),
  CONSTRAINT `phieuxuat_makho_fkey` FOREIGN KEY (`makho`) REFERENCES `khohang` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of phieuxuat
-- ----------------------------

-- ----------------------------
-- Table structure for tygia
-- ----------------------------
DROP TABLE IF EXISTS `tygia`;
CREATE TABLE `tygia` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tygiaquydoi` float(4,0) DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tygia
-- ----------------------------

-- ----------------------------
-- Table structure for vaitro
-- ----------------------------
DROP TABLE IF EXISTS `vaitro`;
CREATE TABLE `vaitro` (
  `ma` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diengiai` longtext COLLATE utf8_unicode_ci,
  `mavaitrocha` int(11) DEFAULT NULL,
  `truycap` tinyint(4) DEFAULT NULL,
  `them` tinyint(4) DEFAULT NULL,
  `xem` tinyint(4) DEFAULT NULL,
  `xoa` tinyint(4) DEFAULT NULL,
  `sua` tinyint(4) DEFAULT NULL,
  `in` tinyint(4) DEFAULT NULL,
  `nhap` tinyint(4) DEFAULT NULL,
  `xuat` tinyint(4) DEFAULT NULL,
  `activite` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `vaitro_mavaitrocha_fkey` (`mavaitrocha`),
  CONSTRAINT `vaitro_mavaitrocha_fkey` FOREIGN KEY (`mavaitrocha`) REFERENCES `vaitro` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of vaitro
-- ----------------------------
