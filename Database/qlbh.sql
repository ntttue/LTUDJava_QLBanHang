/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbh

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-10-21 20:34:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bophan
-- ----------------------------
DROP TABLE IF EXISTS `bophan`;
CREATE TABLE `bophan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ma` (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for chitietphieunhap
-- ----------------------------
DROP TABLE IF EXISTS `chitietphieunhap`;
CREATE TABLE `chitietphieunhap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hanghoaid` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` double DEFAULT NULL,
  `thanhtien` double DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `phieunhapid` int(11) DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chitietphieunhap_hanghoa_fkey` (`hanghoaid`),
  KEY `chitietphieunhap_phieunhap_fkey` (`phieunhapid`),
  CONSTRAINT `chitietphieunhap_hanghoa_fkey` FOREIGN KEY (`hanghoaid`) REFERENCES `hanghoa` (`id`),
  CONSTRAINT `chitietphieunhap_phieunhap_fkey` FOREIGN KEY (`phieunhapid`) REFERENCES `phieunhap` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for chitietphieuxuat
-- ----------------------------
DROP TABLE IF EXISTS `chitietphieuxuat`;
CREATE TABLE `chitietphieuxuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hanghoaid` int(11) DEFAULT NULL,
  `phieuxuatid` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` double DEFAULT NULL,
  `thanhtien` double DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chitietphieuxuat_hanghoa_fkey` (`hanghoaid`),
  KEY `chitietphieuxuat_phieuxuat_fkey` (`phieuxuatid`),
  CONSTRAINT `chitietphieuxuat_hanghoa_fkey` FOREIGN KEY (`hanghoaid`) REFERENCES `hanghoa` (`id`),
  CONSTRAINT `chitietphieuxuat_phieuxuat_fkey` FOREIGN KEY (`phieuxuatid`) REFERENCES `phieuxuat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for congty
-- ----------------------------
DROP TABLE IF EXISTS `congty`;
CREATE TABLE `congty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `masothue` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `logo` text COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for donvitinh
-- ----------------------------
DROP TABLE IF EXISTS `donvitinh`;
CREATE TABLE `donvitinh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for hanghoa
-- ----------------------------
DROP TABLE IF EXISTS `hanghoa`;
CREATE TABLE `hanghoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khohangid` int(11) DEFAULT NULL,
  `nhomhangid` int(11) DEFAULT NULL,
  `loaihangid` int(11) DEFAULT NULL,
  `nhaccid` int(11) DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `donviid` int(11) DEFAULT NULL,
  `xuatxu` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `giamua` double DEFAULT NULL,
  `giabanle` double DEFAULT NULL,
  `giabansi` double DEFAULT NULL,
  `tonkho` int(11) DEFAULT NULL,
  `anh` text COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hanghoa_khohang_fkey` (`khohangid`),
  KEY `hanghoa_nhomhang_fkey` (`nhomhangid`),
  KEY `hanghoa_loaihang_fkey` (`loaihangid`),
  KEY `hanghoa_nhacungcap_fkey` (`nhaccid`),
  KEY `hanghoa_donvi_fkey` (`donviid`),
  CONSTRAINT `hanghoa_donvi_fkey` FOREIGN KEY (`donviid`) REFERENCES `donvitinh` (`id`),
  CONSTRAINT `hanghoa_khohang_fkey` FOREIGN KEY (`khohangid`) REFERENCES `khohang` (`id`),
  CONSTRAINT `hanghoa_loaihang_fkey` FOREIGN KEY (`loaihangid`) REFERENCES `loaihang` (`id`),
  CONSTRAINT `hanghoa_nhacungcap_fkey` FOREIGN KEY (`nhaccid`) REFERENCES `nhacungcap` (`id`),
  CONSTRAINT `hanghoa_nhomhang_fkey` FOREIGN KEY (`nhomhangid`) REFERENCES `nhomhanghoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `makh` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `loaikhid` int(11) DEFAULT NULL,
  `khuvucid` int(11) DEFAULT NULL,
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
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khachang_loaikh_fkey` (`loaikhid`),
  KEY `khachhang_khuvuc_fkey` (`khuvucid`),
  CONSTRAINT `khachang_loaikh_fkey` FOREIGN KEY (`loaikhid`) REFERENCES `loaikhachhang` (`id`),
  CONSTRAINT `khachhang_khuvuc_fkey` FOREIGN KEY (`khuvucid`) REFERENCES `khuvuc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for khohang
-- ----------------------------
DROP TABLE IF EXISTS `khohang`;
CREATE TABLE `khohang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nguoiqlid` int(11) DEFAULT NULL,
  `nguoilienhe` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `dienthoai` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diengiai` longtext COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khohang_nhanvien_fkey` (`nguoiqlid`),
  CONSTRAINT `khohang_nhanvien_fkey` FOREIGN KEY (`nguoiqlid`) REFERENCES `nhanvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for khuvuc
-- ----------------------------
DROP TABLE IF EXISTS `khuvuc`;
CREATE TABLE `khuvuc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ma` (`ma`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for loaihang
-- ----------------------------
DROP TABLE IF EXISTS `loaihang`;
CREATE TABLE `loaihang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ghichu` text COLLATE utf8_unicode_ci,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for loaikhachhang
-- ----------------------------
DROP TABLE IF EXISTS `loaikhachhang`;
CREATE TABLE `loaikhachhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `mota` longtext COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ma` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for nguoidung
-- ----------------------------
DROP TABLE IF EXISTS `nguoidung`;
CREATE TABLE `nguoidung` (
  `mand` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tennd` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `matkhau` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `vaitroid` int(11) DEFAULT NULL,
  `nhanvienid` int(11) DEFAULT NULL,
  `diengiai` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nguoidung_vaitro_fkey` (`vaitroid`),
  KEY `nguoidung_nhanvien_fkey` (`nhanvienid`),
  CONSTRAINT `nguoidung_nhanvien_fkey` FOREIGN KEY (`nhanvienid`) REFERENCES `nhanvien` (`id`),
  CONSTRAINT `nguoidung_vaitro_fkey` FOREIGN KEY (`vaitroid`) REFERENCES `vaitro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for nhacungcap
-- ----------------------------
DROP TABLE IF EXISTS `nhacungcap`;
CREATE TABLE `nhacungcap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khuvucid` int(11) DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `masothue` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `taikhoan` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nganhang` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `manguoilienhe` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chucvu` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nhacungcap_khuvuc_fkey` (`khuvucid`),
  CONSTRAINT `nhacungcap_khuvuc_fkey` FOREIGN KEY (`khuvucid`) REFERENCES `khuvuc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for nhanvien
-- ----------------------------
DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE `nhanvien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ma` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `Ten` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `DiaChi` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `GioiTinh` bit(1) DEFAULT NULL,
  `ChucVu` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `DienThoai` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `BoPhanId` int(11) DEFAULT NULL,
  `NguoiLienQuan` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Luong` double(65,0) DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nhanvien_bophan_fkey` (`BoPhanId`),
  CONSTRAINT `nhanvien_bophan_fkey` FOREIGN KEY (`BoPhanId`) REFERENCES `bophan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Table structure for nhomhanghoa
-- ----------------------------
DROP TABLE IF EXISTS `nhomhanghoa`;
CREATE TABLE `nhomhanghoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` longtext COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for phieunhap
-- ----------------------------
DROP TABLE IF EXISTS `phieunhap`;
CREATE TABLE `phieunhap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nhaccid` int(11) DEFAULT NULL,
  `nhanviennhapid` int(11) DEFAULT NULL,
  `khoid` int(11) DEFAULT NULL,
  `dienthoai` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diachi` text COLLATE utf8_unicode_ci,
  `ngaynhap` date DEFAULT NULL,
  `ghichu` text COLLATE utf8_unicode_ci,
  `tongtien` double DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phieunhap_nhacungcap_fkey` (`nhaccid`),
  KEY `phieunhap_nhanvien_fkey` (`nhanviennhapid`),
  KEY `phieunhap_khohang_fkey` (`khoid`),
  CONSTRAINT `phieunhap_khohang_fkey` FOREIGN KEY (`khoid`) REFERENCES `khohang` (`id`),
  CONSTRAINT `phieunhap_nhacungcap_fkey` FOREIGN KEY (`nhaccid`) REFERENCES `nhacungcap` (`id`),
  CONSTRAINT `phieunhap_nhanvien_fkey` FOREIGN KEY (`nhanviennhapid`) REFERENCES `nhanvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for phieuxuat
-- ----------------------------
DROP TABLE IF EXISTS `phieuxuat`;
CREATE TABLE `phieuxuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diachi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `khoid` int(11) DEFAULT NULL,
  `ngaygiao` date DEFAULT NULL,
  `nhanvienbanhangid` int(11) DEFAULT NULL,
  `ngaylap` date DEFAULT NULL,
  `khachhangid` int(11) DEFAULT NULL,
  `dienthoai` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tongtien` double DEFAULT NULL,
  `ghichu` text COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phieuxuat_khohang_fkey` (`khoid`),
  KEY `phieuxuat_nhanvien_fkey` (`nhanvienbanhangid`),
  KEY `phieuxuat_khachhang_fkey` (`khachhangid`),
  CONSTRAINT `phieuxuat_khachhang_fkey` FOREIGN KEY (`khachhangid`) REFERENCES `khachhang` (`id`),
  CONSTRAINT `phieuxuat_khohang_fkey` FOREIGN KEY (`khoid`) REFERENCES `khohang` (`id`),
  CONSTRAINT `phieuxuat_nhanvien_fkey` FOREIGN KEY (`nhanvienbanhangid`) REFERENCES `nhanvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tygia
-- ----------------------------
DROP TABLE IF EXISTS `tygia`;
CREATE TABLE `tygia` (
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tygiaquydoi` float(4,0) DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for vaitro
-- ----------------------------
DROP TABLE IF EXISTS `vaitro`;
CREATE TABLE `vaitro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diengiai` longtext COLLATE utf8_unicode_ci,
  `vaitrochaid` int(11) DEFAULT NULL,
  `truycap` bit(1) DEFAULT NULL,
  `them` bit(1) DEFAULT NULL,
  `xem` bit(1) DEFAULT NULL,
  `xoa` bit(1) DEFAULT NULL,
  `sua` bit(1) DEFAULT NULL,
  `in` bit(1) DEFAULT NULL,
  `nhap` bit(1) DEFAULT NULL,
  `xuat` bit(1) DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ma` (`ma`),
  KEY `vaitro_vaitro_fkey` (`vaitrochaid`),
  CONSTRAINT `vaitro_vaitro_fkey` FOREIGN KEY (`vaitrochaid`) REFERENCES `vaitro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
