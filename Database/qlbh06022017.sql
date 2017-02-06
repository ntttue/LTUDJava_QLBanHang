/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbh

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-02-06 14:34:12
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bophan
-- ----------------------------
INSERT INTO `bophan` VALUES ('1', 'GD', 'Giám Đốc', 'Giám đốc công ty', '');
INSERT INTO `bophan` VALUES ('2', 'KD', 'Phòng kinh doanh', 'Phòng kinh doanh', '');
INSERT INTO `bophan` VALUES ('3', 'KT', 'Phòng kế toán', 'Phòng kế toán', '');
INSERT INTO `bophan` VALUES ('4', 'KTH', 'Phòng Kỹ Thuật', 'Phòng Kỹ Thuật', '');
INSERT INTO `bophan` VALUES ('27', 'NS', 'Nhân sự', 'Bộ phận nhân sự', '');
INSERT INTO `bophan` VALUES ('30', 'BH', 'Bộ phận bán hàng', 'Bộ phận bán hàng', '');

-- ----------------------------
-- Table structure for chitietchuyenkho
-- ----------------------------
DROP TABLE IF EXISTS `chitietchuyenkho`;
CREATE TABLE `chitietchuyenkho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` double DEFAULT NULL,
  `thanhtien` double DEFAULT NULL,
  `hanghoaid` int(11) DEFAULT NULL,
  `chuyenkhoid` int(11) DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chitietck_chuyenkho_fkey` (`chuyenkhoid`),
  KEY `chitietck_hanghoa_fkey` (`hanghoaid`),
  CONSTRAINT `chitietck_chuyenkho_fkey` FOREIGN KEY (`chuyenkhoid`) REFERENCES `chuyenkho` (`id`),
  CONSTRAINT `chitietck_hanghoa_fkey` FOREIGN KEY (`hanghoaid`) REFERENCES `hanghoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietchuyenkho
-- ----------------------------
INSERT INTO `chitietchuyenkho` VALUES ('1', 'CTCK00001', '1', '100000', '100000', '1', '1', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietphieunhap
-- ----------------------------
INSERT INTO `chitietphieunhap` VALUES ('1', '6', '0', '20000', '0', '', '1', '', '');
INSERT INTO `chitietphieunhap` VALUES ('2', '8', '1', '100000000', '100000000', '', '3', '', '');
INSERT INTO `chitietphieunhap` VALUES ('3', '7', '1', '2357000', '2357000', '', '4', '', '');
INSERT INTO `chitietphieunhap` VALUES ('4', '1', '1', '10000', '10000', '', '5', '', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietphieuxuat
-- ----------------------------
INSERT INTO `chitietphieuxuat` VALUES ('1', '', '9', '1', '10', '100000', '2000000', '');
INSERT INTO `chitietphieuxuat` VALUES ('2', '', '2', '2', '2', '100000000', '200000000', '');
INSERT INTO `chitietphieuxuat` VALUES ('3', '', '9', '2', '2', '4000000', '8000000', '');
INSERT INTO `chitietphieuxuat` VALUES ('5', '', '9', '3', '1', '899999', '899999', '');
INSERT INTO `chitietphieuxuat` VALUES ('7', '', '9', '4', '1', '1000000', '1000000', '');
INSERT INTO `chitietphieuxuat` VALUES ('9', '', '9', '5', '1', '10000', '10000', '');

-- ----------------------------
-- Table structure for chuyenkho
-- ----------------------------
DROP TABLE IF EXISTS `chuyenkho`;
CREATE TABLE `chuyenkho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `khochuyenid` int(11) DEFAULT NULL,
  `khonhanid` int(11) DEFAULT NULL,
  `nguoichuyenid` int(11) DEFAULT NULL,
  `nguoinhanid` int(11) DEFAULT NULL,
  `ghichu` text COLLATE utf8_unicode_ci,
  `ma` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phieuchuyentay` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay` date DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chuyenkho_nhanvienchuyen_fkey` (`nguoichuyenid`),
  KEY `chuyenkho_nhanviennhan_fkey` (`nguoinhanid`),
  KEY `chuyenkho_khochuyen_id` (`khochuyenid`),
  KEY `chuyenkho_khonhan_fkey` (`khonhanid`),
  CONSTRAINT `chuyenkho_khochuyen_id` FOREIGN KEY (`khochuyenid`) REFERENCES `khohang` (`id`),
  CONSTRAINT `chuyenkho_khonhan_fkey` FOREIGN KEY (`khonhanid`) REFERENCES `khohang` (`id`),
  CONSTRAINT `chuyenkho_nhanvienchuyen_fkey` FOREIGN KEY (`nguoichuyenid`) REFERENCES `nhanvien` (`id`),
  CONSTRAINT `chuyenkho_nhanviennhan_fkey` FOREIGN KEY (`nguoinhanid`) REFERENCES `nhanvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chuyenkho
-- ----------------------------
INSERT INTO `chuyenkho` VALUES ('1', '1', '2', '3', '3', '', 'ABC', '', '2016-10-26', '');

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
-- Records of congty
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of donvitinh
-- ----------------------------
INSERT INTO `donvitinh` VALUES ('1', 'KG', 'kilogam', 'Kilogam', '');
INSERT INTO `donvitinh` VALUES ('2', 'DV01', 'bình', 'bình', '');
INSERT INTO `donvitinh` VALUES ('3', 'DV02', 'bộ', 'bộ', '');
INSERT INTO `donvitinh` VALUES ('4', 'DV03', 'cái', 'cái', '');
INSERT INTO `donvitinh` VALUES ('5', 'DV04', 'cặp', 'cặp', '');
INSERT INTO `donvitinh` VALUES ('6', 'DV05', 'cây', 'cây', '');
INSERT INTO `donvitinh` VALUES ('7', 'DV06', 'chai', 'chai', '');
INSERT INTO `donvitinh` VALUES ('8', 'DV07', 'con', 'con', '');
INSERT INTO `donvitinh` VALUES ('9', 'DV09', 'cụm', 'cụm', '');
INSERT INTO `donvitinh` VALUES ('10', 'DV10', 'cuộn', 'cuộn', '');
INSERT INTO `donvitinh` VALUES ('11', 'DV12', 'dây', 'dây', '');
INSERT INTO `donvitinh` VALUES ('12', 'DV13', 'đôi', 'đôi', '');
INSERT INTO `donvitinh` VALUES ('13', 'DV15', 'hộp', 'hộp', '');
INSERT INTO `donvitinh` VALUES ('14', 'DV16', 'khúc', 'khúc', '');
INSERT INTO `donvitinh` VALUES ('15', 'DV18', 'lít', 'lít', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hanghoa
-- ----------------------------
INSERT INTO `hanghoa` VALUES ('1', 'ANS0001', '2', '1', '1', '1', 'Tem từ giấy  4x4', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('2', 'ANS0002', '2', '1', '1', '1', 'Tem từ giấy 3x3', '2', 'Việt Nam', '10000', '50000', '20000', '9999998', null, '');
INSERT INTO `hanghoa` VALUES ('3', 'ANS0003', '2', '1', '1', '1', 'Dây đeo kim loại BB L002', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('4', 'ANS0004', '2', '1', '1', '1', 'Dây đeo nhựa BB L003/G', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('5', 'ANS0005', '2', '1', '1', '1', 'Mở khóa DO-0004', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('6', 'ANS0006', '2', '1', '1', '1', 'Cổng từ  Foxcom EAS5000', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('7', 'ANS0007', '2', '1', '1', '1', 'Cổng từ  Foxcom EAS5001', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('8', 'ANS0008', '2', '1', '1', '1', 'Cổng từ Foxcom 5002', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('9', 'ANS0009', '2', '1', '1', '1', 'Cổng từ Foxcom 5005', '2', 'Việt Nam', '10000', '50000', '20000', '9999995', null, '');
INSERT INTO `hanghoa` VALUES ('10', 'ANS0010', '2', '1', '1', '1', 'Cổng từ Foxcom  EAS5011', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('11', 'ANS0011', '2', '1', '1', '1', 'Cổng từ Foxcom EAS5012', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('12', 'ANS0012', '2', '1', '1', '1', 'Đinh ghim nhựa', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('13', 'ANS0013', '2', '1', '1', '1', 'Đinh ghim sắt', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('14', 'ANS0014', '2', '1', '1', '1', 'Bàn khử từ Biển Bạc', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');
INSERT INTO `hanghoa` VALUES ('15', 'ANS0015', '2', '1', '1', '1', 'Tem trắng AM super tag lớn', '2', 'Việt Nam', '10000', '50000', '20000', '10000000', null, '');

-- ----------------------------
-- Table structure for keeplogged
-- ----------------------------
DROP TABLE IF EXISTS `keeplogged`;
CREATE TABLE `keeplogged` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of keeplogged
-- ----------------------------
INSERT INTO `keeplogged` VALUES ('12', 'ntttue', '1111', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khachhang
-- ----------------------------
INSERT INTO `khachhang` VALUES ('3', 'KH000115', null, '1', '1', 'A Xuân Anh - Siêu Thị Thiết Bị Số', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('4', 'KH000116', null, '1', '1', 'A Xuân', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('5', 'KH000117', null, '1', '1', 'Trần Văn Trãi', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('6', 'KH000118', null, '1', '1', 'Phạm Chung Tú', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('7', 'KH000119', null, '1', '1', 'Nguyễn Thanh Nhàn', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('8', 'KH000120', null, '1', '1', 'Hồ Tuấn Thanh', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('9', 'KH000121', null, '1', '1', 'Hồ Trung Dũng', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('10', 'KH000122', null, '1', '1', 'A Xuân Anh', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('11', 'KH000123', null, '1', '1', 'A Văn B', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');
INSERT INTO `khachhang` VALUES ('12', 'KH000124', null, '1', '1', 'Đàm Vĩnh Hưng', '227 Nguyễn Văn Cừ', '010299898309', '01699952101', 'ntttue.gl@mail.com', '010299898309', 'Vietcombank', '50000000188416.0000000000', '200000000.0000000000', null, 'ntttue@skype.com', 'Nguyễn Thị Trí Tuệ', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khohang
-- ----------------------------
INSERT INTO `khohang` VALUES ('1', 'CT', 'Kho công ty', '3', 'Trần Văn Trãi', '227 Nguyễn Văn Cừ', '01699952101', 'ntttue.gl@gmail.com', '', 'Kho công ty', '');
INSERT INTO `khohang` VALUES ('2', 'CT1', 'Kho Hà Nội', '3', 'Trần Văn Trãi', '227 Nguyễn Văn Cừ', '01699952101', 'ntttue.gl@gmail.com', '', 'Kho công ty', '');
INSERT INTO `khohang` VALUES ('3', 'CT2', 'Kho Phạm Văn Hai', '3', 'Trần Văn Trãi', '227 Nguyễn Văn Cừ', '01699952101', 'ntttue.gl@gmail.com', '', 'Kho công ty', '');
INSERT INTO `khohang` VALUES ('4', 'CT3', 'Kho 6 HCM', '3', 'Trần Văn Trãi', '227 Nguyễn Văn Cừ', '01699952101', 'ntttue.gl@gmail.com', '', 'Kho công ty', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khuvuc
-- ----------------------------
INSERT INTO `khuvuc` VALUES ('1', 'KV000001', 'Miền Nam', 'Khu vực miền nam', '');
INSERT INTO `khuvuc` VALUES ('2', 'KV000002', 'Miền Bắc', 'Khu vực miền bắc', '');
INSERT INTO `khuvuc` VALUES ('3', 'KV000003', 'Miền trung', 'Khu Vực miền trung', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of loaihang
-- ----------------------------
INSERT INTO `loaihang` VALUES ('1', 'HH', 'Hàng hóa', 'Hàng hóa', '');
INSERT INTO `loaihang` VALUES ('2', 'DV', 'Dịch Vụ', 'Dịch Vụ', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of loaikhachhang
-- ----------------------------
INSERT INTO `loaikhachhang` VALUES ('1', 'KL', 'Khách lẻ', 'Khách lẻ', '');
INSERT INTO `loaikhachhang` VALUES ('2', 'DL', 'Đại Lý', 'Đại lý', '');

-- ----------------------------
-- Table structure for nguoidung
-- ----------------------------
DROP TABLE IF EXISTS `nguoidung`;
CREATE TABLE `nguoidung` (
  `mand` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tennd` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `matkhau` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `nhanvienid` int(11) DEFAULT NULL,
  `diengiai` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nguoidung_vaitro_fkey` (`roleid`),
  KEY `nguoidung_nhanvien_fkey` (`nhanvienid`),
  CONSTRAINT `nguoidung_nhanvien_fkey` FOREIGN KEY (`nhanvienid`) REFERENCES `nhanvien` (`id`),
  CONSTRAINT `nguoidung_quyen_fkey` FOREIGN KEY (`roleid`) REFERENCES `quyen` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nguoidung
-- ----------------------------
INSERT INTO `nguoidung` VALUES ('ND0001', '2', '1', '1', '1', '3', null, '');
INSERT INTO `nguoidung` VALUES ('ND0002', '3', 'ntttue', '1111', '1', '7', null, '');
INSERT INTO `nguoidung` VALUES ('ND0002', '4', 'admin', '1111', '1', '10', null, '');
INSERT INTO `nguoidung` VALUES ('ND0002', '5', 'quanly', '1111', '2', '9', null, '');
INSERT INTO `nguoidung` VALUES ('ND0003', '6', 'nhanvien', '1111', '3', '12', null, '');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhacungcap
-- ----------------------------
INSERT INTO `nhacungcap` VALUES ('1', 'NCC000001', '1', 'Công ty CP Minh An', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('2', 'NCC000040', '1', 'Công ty TNHH TMDV Sao Việt', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('3', 'NCC000041', '1', 'Công ty Phúc Bình', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('4', 'NCC000045', '1', 'Công ty Hàn Việt', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('5', 'NCC000046', '1', 'Trung tâm kinh doanh di động BBMobile', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('6', 'NCC000047', '1', 'Công ty TNHH Thương mại Quốc Tế HPT Việt Nam', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('7', 'NCC000048', '1', 'Công ty TNHH MTV Thiên An Phát', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('8', 'NCC000049', '1', 'Công ty Cổ Phần Biển Bạc', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('9', 'NCC000050', '1', 'Công ty TNHH TMDV Công Nghệ Chí Cường', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('10', 'NCC000051', '1', 'Công ty TNHH TMDV XNK HPT Việt Nam', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('11', 'NCC000053', '1', 'Công ty CP SX TM & DV tin học xây dựng NaNo', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('12', 'NCC000054', '1', 'Công ty Cổ Phần Phân Phối Tân Niềm Tin', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');
INSERT INTO `nhacungcap` VALUES ('13', 'NCC000054', '1', 'Công ty TNHH MTV Quản trị mạng Quang Phát', '227 Nguyễn Văn Cừ', null, '', '01699952101', 'nttue.gl@gmail.com', 'https://courses.fit.hcmus.edu.vn/login/index.php', null, null, 'Nguyễn Thị Trí Tuệ', null, '');

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
  `NguoiQuanLyID` int(11) DEFAULT NULL,
  `Luong` double(65,0) DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nhanvien_bophan_fkey` (`BoPhanId`),
  KEY `NguoiQuanLyID` (`NguoiQuanLyID`),
  CONSTRAINT `nhanvien_bophan_fkey` FOREIGN KEY (`BoPhanId`) REFERENCES `bophan` (`id`),
  CONSTRAINT `nhanvien_nhanvienql_fkey` FOREIGN KEY (`NguoiQuanLyID`) REFERENCES `nhanvien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of nhanvien
-- ----------------------------
INSERT INTO `nhanvien` VALUES ('3', '1', 'Nguyễn Thị Trí Tuệ', '391 trần phú', '\0', 'Tổng giám đốc', 'ntttue.gl@gmail.com', '01699952101', '1', '9', '20000000', '');
INSERT INTO `nhanvien` VALUES ('4', 'ntttue', 'ntttue', '392 NVC', '', 'Phó Tổng giám đốc', 'ntttue.gl@gmail.com', '01699952101', '1', '3', '20000000', '\0');
INSERT INTO `nhanvien` VALUES ('5', 'NV01', 'Trần văn Trãi', '', '', '', 'ntttue.gl@gmail.com', '', '1', '3', '0', '');
INSERT INTO `nhanvien` VALUES ('6', 'NV02', 'Nguyễn Thanh Nhàn', '', '', '', 'ntnhan@gmail.com', '', '1', null, '0', '');
INSERT INTO `nhanvien` VALUES ('7', 'NV03', 'Phạm Chung Tú', '', '', '', 'pctu@gmail.com', '1699952101', '1', null, '0', '');
INSERT INTO `nhanvien` VALUES ('8', 'NV04', 'Hồ Tuấn Thanh', '', '', '', '', '', '1', '3', '50000000', '');
INSERT INTO `nhanvien` VALUES ('9', 'NV05', 'Lê Ngọc Thành', '', '', '', '', '01699952101', '1', null, '0', '');
INSERT INTO `nhanvien` VALUES ('10', 'NV06', 'Trần Trung Kiên', '', '', '', 'ttkien@gmail.com', '01699952101', '1', null, '20000', '');
INSERT INTO `nhanvien` VALUES ('11', 'NV07', 'Lê Ngọc Sơn', '', '', '', 'lnson@gmail.com', '01699952101', '1', null, '100000', '');
INSERT INTO `nhanvien` VALUES ('12', 'NV08', 'Lương Vĩ Minh', '', '', '', '', '', '1', null, '40000000', '');
INSERT INTO `nhanvien` VALUES ('13', 'NV09', 'Trần Đang Thư', '227 Nguyễn Văn Cừ', '\0', 'Kế toán trưởng', 'tdthu@gmail.com', '01699952101', '3', '3', '100000000', '');
INSERT INTO `nhanvien` VALUES ('14', 'NV010', 'Lâm Như Quỳnh', '227 Nguyễn Văn Cừ', '\0', 'Thư ký', 'lnquyanh@gmail.com', '01699952101', '3', '3', '20000000', '');
INSERT INTO `nhanvien` VALUES ('15', 'NV11', 'Lâm Tâm Như', '227 Nguyễn Văn Cừ', '\0', 'Nhân viên bán hàng', 'ltnhu@gmail.com', '01699952101', '2', '3', '200000000', '');
INSERT INTO `nhanvien` VALUES ('16', 'NV012', 'Triệu Vi', '227 Nguyễn Văn Cừ', '\0', 'nhân viên bán hàng', 'tvi@gmail.com', '01699952101', '2', '3', '20000000', '');
INSERT INTO `nhanvien` VALUES ('17', 'NV013', 'Hồ Trung Dũng', '227 Nguyễn Văn Cừ', '', 'Nhân viên ', 'htdung@gmail.com', '01699952101', '2', '3', '2000000', '');
INSERT INTO `nhanvien` VALUES ('18', 'NV014', 'Đàm Vĩnh Hưng', '', '', '', '', '', '1', null, '0', '');
INSERT INTO `nhanvien` VALUES ('19', 'NV015', 'Mỹ Tâm', '', '\0', '', '', '', '2', '3', '0', '');
INSERT INTO `nhanvien` VALUES ('20', 'NV016', 'Lê Cát Trọng Lý', '', '\0', '', '', '', '2', '3', '0', '');
INSERT INTO `nhanvien` VALUES ('22', 'test1', 'test1', '', '', '', '', '', '1', '3', '0', '');
INSERT INTO `nhanvien` VALUES ('23', 'NV020', 'Lệ Quyên', '227 Nguyễn Văn Cừ', '\0', 'Nhân viên bán hàng', 'lquyen@gmail.com', '01699952101', '30', '3', '2000000', '');
INSERT INTO `nhanvien` VALUES ('24', 'abc', 'abc', '', '', '', '', '01699952101', '1', null, '0', '');
INSERT INTO `nhanvien` VALUES ('25', 'NV030', 'anc', '', '', '', '', '01699952101', '1', null, '0', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhatky
-- ----------------------------
INSERT INTO `nhatky` VALUES ('86', 'ntttue', 'Bộ phận công ty', 'Cập nhật', '2016-10-26 15:40:47', '');
INSERT INTO `nhatky` VALUES ('87', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 15:43:31', '');
INSERT INTO `nhatky` VALUES ('88', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 15:46:27', '');
INSERT INTO `nhatky` VALUES ('89', 'ntttue', 'Nhân viên', 'Thêm', '2016-10-26 15:47:50', '');
INSERT INTO `nhatky` VALUES ('90', 'ntttue', 'Nhân viên', 'Thêm', '2016-10-26 15:48:44', '');
INSERT INTO `nhatky` VALUES ('91', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 15:57:22', '');
INSERT INTO `nhatky` VALUES ('92', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 15:57:46', '');
INSERT INTO `nhatky` VALUES ('93', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 15:58:33', '');
INSERT INTO `nhatky` VALUES ('94', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 15:58:53', '');
INSERT INTO `nhatky` VALUES ('95', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:00:20', '');
INSERT INTO `nhatky` VALUES ('96', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:01:29', '');
INSERT INTO `nhatky` VALUES ('97', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:06:23', '');
INSERT INTO `nhatky` VALUES ('98', 'ntttue', 'Nhân viên', 'Thêm', '2016-10-26 16:06:38', '');
INSERT INTO `nhatky` VALUES ('99', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:10:18', '');
INSERT INTO `nhatky` VALUES ('100', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:13:29', '');
INSERT INTO `nhatky` VALUES ('101', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:14:30', '');
INSERT INTO `nhatky` VALUES ('102', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:16:29', '');
INSERT INTO `nhatky` VALUES ('103', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:17:46', '');
INSERT INTO `nhatky` VALUES ('104', 'ntttue', 'Nhân viên', 'Cập nhật', '2016-10-26 16:18:00', '');
INSERT INTO `nhatky` VALUES ('105', 'ntttue', 'Nhân viên', 'Cập nhật', '2016-10-26 16:18:16', '');
INSERT INTO `nhatky` VALUES ('106', 'ntttue', 'Nhân viên', 'Cập nhật', '2016-10-26 16:18:25', '');
INSERT INTO `nhatky` VALUES ('107', 'ntttue', 'Nhân viên', 'Cập nhật', '2016-10-26 16:18:35', '');
INSERT INTO `nhatky` VALUES ('108', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:19:40', '');
INSERT INTO `nhatky` VALUES ('109', 'ntttue', 'Nhân viên', 'Cập nhật', '2016-10-26 16:19:58', '');
INSERT INTO `nhatky` VALUES ('110', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:23:27', '');
INSERT INTO `nhatky` VALUES ('111', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:37:01', '');
INSERT INTO `nhatky` VALUES ('112', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:38:31', '');
INSERT INTO `nhatky` VALUES ('113', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:38:52', '');
INSERT INTO `nhatky` VALUES ('114', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:39:19', '');
INSERT INTO `nhatky` VALUES ('115', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:40:04', '');
INSERT INTO `nhatky` VALUES ('116', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:46:52', '');
INSERT INTO `nhatky` VALUES ('117', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 16:59:37', '');
INSERT INTO `nhatky` VALUES ('118', 'ND0002 - ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:03:14', '');
INSERT INTO `nhatky` VALUES ('119', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:24:48', '');
INSERT INTO `nhatky` VALUES ('120', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:27:13', '');
INSERT INTO `nhatky` VALUES ('121', null, 'Hệ thống', 'Sao lưu dữ liệu', '2016-10-26 17:27:26', '');
INSERT INTO `nhatky` VALUES ('122', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:28:26', '');
INSERT INTO `nhatky` VALUES ('123', 'ntttue', 'Hệ thống', 'Phục hồi dữ liệu sao lưu', '2016-10-26 17:29:58', '');
INSERT INTO `nhatky` VALUES ('124', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:35:57', '');
INSERT INTO `nhatky` VALUES ('125', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:40:34', '');
INSERT INTO `nhatky` VALUES ('126', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:43:39', '');
INSERT INTO `nhatky` VALUES ('127', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:44:26', '');
INSERT INTO `nhatky` VALUES ('128', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:44:59', '');
INSERT INTO `nhatky` VALUES ('129', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:45:19', '');
INSERT INTO `nhatky` VALUES ('130', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:52:09', '');
INSERT INTO `nhatky` VALUES ('131', 'ntttue', 'Khu vực', 'Thêm', '2016-10-26 17:52:56', '');
INSERT INTO `nhatky` VALUES ('132', 'ntttue', 'Khu vực', 'Thêm', '2016-10-26 17:53:23', '');
INSERT INTO `nhatky` VALUES ('133', 'ntttue', 'Khu vực', 'Thêm', '2016-10-26 17:54:13', '');
INSERT INTO `nhatky` VALUES ('134', 'ntttue', 'Khách hàng', 'Xóa', '2016-10-26 17:54:27', '');
INSERT INTO `nhatky` VALUES ('135', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 17:57:00', '');
INSERT INTO `nhatky` VALUES ('136', 'ntttue', 'Khách hàng', 'Thêm', '2016-10-26 18:00:49', '');
INSERT INTO `nhatky` VALUES ('137', 'ntttue', 'Nhà cung cấp', 'Thêm', '2016-10-26 18:07:15', '');
INSERT INTO `nhatky` VALUES ('138', 'ntttue', 'Kho hàng', 'Thêm', '2016-10-26 18:11:30', '');
INSERT INTO `nhatky` VALUES ('139', 'ntttue', 'Đơn vị tính', 'Thêm', '2016-10-26 18:13:14', '');
INSERT INTO `nhatky` VALUES ('140', 'ntttue', 'Loại hoàng hóa', 'Thêm', '2016-10-26 18:16:56', '');
INSERT INTO `nhatky` VALUES ('141', 'ntttue', 'Tỷ giá', 'Thêm', '2016-10-26 18:32:18', '');
INSERT INTO `nhatky` VALUES ('142', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 18:40:56', '');
INSERT INTO `nhatky` VALUES ('143', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:07:11', '');
INSERT INTO `nhatky` VALUES ('144', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:09:10', '');
INSERT INTO `nhatky` VALUES ('145', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:11:10', '');
INSERT INTO `nhatky` VALUES ('146', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:12:32', '');
INSERT INTO `nhatky` VALUES ('147', 'ntttue', 'Phiếu nhập', 'Thêm', '2016-10-26 19:13:32', '');
INSERT INTO `nhatky` VALUES ('148', 'ntttue', 'Phiếu nhập', 'Thêm', '2016-10-26 19:14:20', '');
INSERT INTO `nhatky` VALUES ('149', 'ntttue', 'Phiếu nhập', 'Cập nhật', '2016-10-26 19:14:22', '');
INSERT INTO `nhatky` VALUES ('150', 'ntttue', 'Phiếu nhập', 'Cập nhật', '2016-10-26 19:14:24', '');
INSERT INTO `nhatky` VALUES ('151', 'ntttue', 'Phiếu xuất', 'Thêm', '2016-10-26 19:15:16', '');
INSERT INTO `nhatky` VALUES ('152', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:16:34', '');
INSERT INTO `nhatky` VALUES ('153', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:17:30', '');
INSERT INTO `nhatky` VALUES ('154', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:19:38', '');
INSERT INTO `nhatky` VALUES ('155', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:23:15', '');
INSERT INTO `nhatky` VALUES ('156', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:33:23', '');
INSERT INTO `nhatky` VALUES ('157', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:34:29', '');
INSERT INTO `nhatky` VALUES ('158', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:35:52', '');
INSERT INTO `nhatky` VALUES ('159', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:37:33', '');
INSERT INTO `nhatky` VALUES ('160', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:38:08', '');
INSERT INTO `nhatky` VALUES ('161', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:39:17', '');
INSERT INTO `nhatky` VALUES ('162', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:40:00', '');
INSERT INTO `nhatky` VALUES ('163', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:41:41', '');
INSERT INTO `nhatky` VALUES ('164', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 19:59:07', '');
INSERT INTO `nhatky` VALUES ('165', 'ntttue', 'Chuyển kho', 'Thêm', '2016-10-26 20:00:14', '');
INSERT INTO `nhatky` VALUES ('166', 'ntttue', 'Chi tiết chuyển kho', 'Thêm', '2016-10-26 20:00:14', '');
INSERT INTO `nhatky` VALUES ('167', 'ntttue', 'Phiếu nhập', 'Thêm', '2016-10-26 20:02:45', '');
INSERT INTO `nhatky` VALUES ('168', 'ntttue', 'Phiếu nhập', 'Thêm', '2016-10-26 20:04:02', '');
INSERT INTO `nhatky` VALUES ('169', 'ntttue', 'Phiếu xuất', 'Thêm', '2016-10-26 20:05:09', '');
INSERT INTO `nhatky` VALUES ('170', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:12', '');
INSERT INTO `nhatky` VALUES ('171', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:13', '');
INSERT INTO `nhatky` VALUES ('172', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:29', '');
INSERT INTO `nhatky` VALUES ('173', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:29', '');
INSERT INTO `nhatky` VALUES ('174', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:40', '');
INSERT INTO `nhatky` VALUES ('175', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:41', '');
INSERT INTO `nhatky` VALUES ('176', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:42', '');
INSERT INTO `nhatky` VALUES ('177', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:05:48', '');
INSERT INTO `nhatky` VALUES ('178', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 20:07:07', '');
INSERT INTO `nhatky` VALUES ('179', 'ntttue', 'Phiếu xuất', 'Thêm', '2016-10-26 20:07:46', '');
INSERT INTO `nhatky` VALUES ('180', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 20:09:14', '');
INSERT INTO `nhatky` VALUES ('181', 'ntttue', 'Phiếu xuất', 'Thêm', '2016-10-26 20:09:58', '');
INSERT INTO `nhatky` VALUES ('182', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 20:18:50', '');
INSERT INTO `nhatky` VALUES ('183', 'ntttue', 'Phiếu xuất', 'Thêm', '2016-10-26 20:19:45', '');
INSERT INTO `nhatky` VALUES ('184', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:46', '');
INSERT INTO `nhatky` VALUES ('185', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('186', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('187', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('188', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('189', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('190', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('191', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('192', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:47', '');
INSERT INTO `nhatky` VALUES ('193', 'ntttue', 'Phiếu xuất', 'Cập nhật', '2016-10-26 20:19:48', '');
INSERT INTO `nhatky` VALUES ('194', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 20:21:51', '');
INSERT INTO `nhatky` VALUES ('195', 'ntttue', 'Phiếu nhập', 'Thêm', '2016-10-26 20:22:54', '');
INSERT INTO `nhatky` VALUES ('196', 'ntttue', 'Phiếu nhập', 'Cập nhật', '2016-10-26 20:22:57', '');
INSERT INTO `nhatky` VALUES ('197', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 20:25:14', '');
INSERT INTO `nhatky` VALUES ('198', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-26 20:26:12', '');
INSERT INTO `nhatky` VALUES ('199', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-10-27 18:02:36', '');
INSERT INTO `nhatky` VALUES ('200', 'ntttue', 'Người dùng', 'Đăng nhập', '2016-11-03 23:40:51', '');
INSERT INTO `nhatky` VALUES ('201', 'ntttue', 'Người dùng', 'Đăng nhập', '2017-01-26 12:32:48', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhomhanghoa
-- ----------------------------
INSERT INTO `nhomhanghoa` VALUES ('1', 'ANS', 'An ninh siêu thị', 'An ninh siêu thị', '');
INSERT INTO `nhomhanghoa` VALUES ('2', 'BAT', 'Báo trộm, báo cháy', 'Báo trộm, báo cháy', '');
INSERT INTO `nhomhanghoa` VALUES ('3', 'CAM', 'Camera quan sát', 'Camera quan sát', '');
INSERT INTO `nhomhanghoa` VALUES ('4', 'CARCAM', 'Camera hành trình', 'Camera hành trình', '');
INSERT INTO `nhomhanghoa` VALUES ('5', 'CHA', 'Máy chấm công', 'Máy chấm công', '');
INSERT INTO `nhomhanghoa` VALUES ('6', 'CHM', 'Chuông cửa màn hình', 'Chuông cửa màn hình', '');
INSERT INTO `nhomhanghoa` VALUES ('7', 'DAC', 'Dây cáp', 'Dây cáp', '');
INSERT INTO `nhomhanghoa` VALUES ('8', 'DAD', 'Đầu ghi', 'Đầu ghi', '');
INSERT INTO `nhomhanghoa` VALUES ('9', 'KIS', 'Kiểm soát ra vào', 'Kiểm soát ra vào', '');
INSERT INTO `nhomhanghoa` VALUES ('10', 'OCU', 'Ổ cứng', 'Ổ cứng', '');
INSERT INTO `nhomhanghoa` VALUES ('11', 'TBK', 'Thiết bị khác', 'Thiết bị khác', '');
INSERT INTO `nhomhanghoa` VALUES ('12', 'TBN', 'Thiết bị hội nghị', 'Thiết bị hội nghị', '');
INSERT INTO `nhomhanghoa` VALUES ('13', 'TBV', 'Thiết bị định vị', 'Thiết bị định vị', '');
INSERT INTO `nhomhanghoa` VALUES ('14', 'TDKL', 'Tay dò kim loại', 'Tay dò kim loại', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of phieunhap
-- ----------------------------
INSERT INTO `phieunhap` VALUES ('1', 'PN0000001', '1', '3', '1', '', '', '2016-10-26', '', '0', '');
INSERT INTO `phieunhap` VALUES ('2', 'PN0000002', '5', '6', '1', '', '', '2016-10-26', '', '8060000000', '');
INSERT INTO `phieunhap` VALUES ('3', 'PN0000003', '2', '5', '1', '01674777824', '614 Dien Bien Phu', '2016-10-26', 'abc', '150000000', '');
INSERT INTO `phieunhap` VALUES ('4', 'PN0000004', '8', '10', '1', '0898335545', '217 Ly Thai To - F.11 - Quan 10 ', '2016-10-26', '', '6357000', '');
INSERT INTO `phieunhap` VALUES ('5', 'PN0000005', '1', '3', '1', '', '', '2016-10-26', '', '10000', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of phieuxuat
-- ----------------------------
INSERT INTO `phieuxuat` VALUES ('1', 'PX0000001', '', '1', '2016-10-26', '3', '2016-10-26', '4', '', '2000000', '', '');
INSERT INTO `phieuxuat` VALUES ('2', 'PX0000002', '34 Bac Hai - F.11 - Quan 10', '1', '2016-10-26', '6', '2016-10-26', '6', '21122112', '208000000', '122121', '');
INSERT INTO `phieuxuat` VALUES ('3', 'PX0000003', '', '1', '2016-10-26', '3', '2016-10-26', '4', '', '899999', '', '');
INSERT INTO `phieuxuat` VALUES ('4', 'PX0000004', '', '2', '2016-10-26', '3', '2016-10-26', '3', '', '1000000', '', '');
INSERT INTO `phieuxuat` VALUES ('5', 'PX0000005', '', '1', null, '3', '2016-10-26', '3', '', '10000', '', '');

-- ----------------------------
-- Table structure for quyen
-- ----------------------------
DROP TABLE IF EXISTS `quyen`;
CREATE TABLE `quyen` (
  `id` int(11) NOT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `diengiai` longtext COLLATE utf8_unicode_ci,
  `activity` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of quyen
-- ----------------------------
INSERT INTO `quyen` VALUES ('1', 'admin', 'full quyền', '');
INSERT INTO `quyen` VALUES ('2', 'quanly', null, '');
INSERT INTO `quyen` VALUES ('3', 'nhanvien', null, '');

-- ----------------------------
-- Table structure for tygia
-- ----------------------------
DROP TABLE IF EXISTS `tygia`;
CREATE TABLE `tygia` (
  `ma` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `tygiaquydoi` float DEFAULT NULL,
  `activity` bit(1) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tygia
-- ----------------------------
INSERT INTO `tygia` VALUES ('VND', 'Việt Nam Đồng', '1', '', '1');
INSERT INTO `tygia` VALUES ('USD', 'Dola My', '200000', '', '2');
INSERT INTO `tygia` VALUES ('GBP', 'Bảng Anh', '220000', '', '3');
INSERT INTO `tygia` VALUES ('EUR', 'Đồng tiền chung EU', '17988', '', '4');

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

-- ----------------------------
-- Records of vaitro
-- ----------------------------
