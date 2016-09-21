/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbanhang

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-09-21 18:51:16
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
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang` (
  `ma` int(11) NOT NULL,
  `makh` varchar(255) CHARACTER SET utf8 NOT NULL,
  `maloaikh` int(11) DEFAULT NULL,
  `makhuvuc` int(11) DEFAULT NULL,
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
  KEY `khachhang_khuvuc_fkey` (`makhuvuc`),
  CONSTRAINT `khachhang_khuvuc_fkey` FOREIGN KEY (`makhuvuc`) REFERENCES `khuvuc` (`ma`),
  CONSTRAINT `khachhang_maloaikh_fkey` FOREIGN KEY (`maloaikh`) REFERENCES `loaikhachhang` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  PRIMARY KEY (`ma`),
  KEY `KhoHang_NhanVien_fkey` (`manguoiql`),
  CONSTRAINT `KhoHang_NhanVien_fkey` FOREIGN KEY (`manguoiql`) REFERENCES `nhanvien` (`Ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
-- Table structure for nhanvien
-- ----------------------------
DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE `nhanvien` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `DiaChi` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `GioiTinh` bit(64) DEFAULT NULL,
  `ChucVu` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `DienThoai` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `MaBoPhan` int(11) DEFAULT NULL,
  `NguoiLienQuan` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Luong` double(65,0) DEFAULT NULL,
  `Activiti` bit(64) DEFAULT NULL,
  PRIMARY KEY (`Ma`),
  KEY `NhanVien_BoPhan_fkey` (`MaBoPhan`),
  CONSTRAINT `NhanVien_BoPhan_fkey` FOREIGN KEY (`MaBoPhan`) REFERENCES `bophan` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

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
  KEY `phieunhap_nhanvien_fkey` (`manvn`),
  CONSTRAINT `phieunhap_makho_fkey` FOREIGN KEY (`makho`) REFERENCES `khohang` (`ma`),
  CONSTRAINT `phieunhap_manhacc_fkey` FOREIGN KEY (`manhacc`) REFERENCES `nhacungcap` (`ma`),
  CONSTRAINT `phieunhap_nhanvien_fkey` FOREIGN KEY (`manvn`) REFERENCES `nhanvien` (`Ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  KEY `phieuxuat_nhanvien_fkey` (`manvbh`),
  CONSTRAINT `phieuxuat_makhachhang_fkey` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`ma`),
  CONSTRAINT `phieuxuat_makho_fkey` FOREIGN KEY (`makho`) REFERENCES `khohang` (`ma`),
  CONSTRAINT `phieuxuat_nhanvien_fkey` FOREIGN KEY (`manvbh`) REFERENCES `nhanvien` (`Ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
SET FOREIGN_KEY_CHECKS=1;
