/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : qlbh

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-10-25 00:35:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bophan
-- ----------------------------
DROP TABLE IF EXISTS `bophan`;
CREATE TABLE `bophan` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` LONGTEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ma` (`ma`)
) ENGINE=INNODB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bophan
-- ----------------------------
INSERT INTO `bophan` VALUES ('1', 'GD', 'Giám Đốc', 'Giám đốc công ty', TRUE);
INSERT INTO `bophan` VALUES ('2', 'KD', 'Phòng kinh doanh', 'Phòng kinh doanh', TRUE);
INSERT INTO `bophan` VALUES ('3', 'KT', 'Phòng kế toán', 'Phòng kế toán', TRUE);
INSERT INTO `bophan` VALUES ('4', 'KTH', 'Phòng Kỹ Thuật', 'Phòng Kỹ Thuật', TRUE);
INSERT INTO `bophan` VALUES ('22', 'Test', 'tesst', '123', '\0');
INSERT INTO `bophan` VALUES ('26', '1', '1', '1', '\0');
INSERT INTO `bophan` VALUES ('27', '1', '1', '111111', TRUE);
INSERT INTO `bophan` VALUES ('28', '2', '2', '2', '\0');
INSERT INTO `bophan` VALUES ('29', '2', '2222', '1222222', TRUE);

-- ----------------------------
-- Table structure for chitietphieunhap
-- ----------------------------
DROP TABLE IF EXISTS `chitietphieunhap`;
CREATE TABLE `chitietphieunhap` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `hanghoaid` INT(11) DEFAULT NULL,
  `soluong` INT(11) DEFAULT NULL,
  `dongia` DOUBLE DEFAULT NULL,
  `thanhtien` DOUBLE DEFAULT NULL,
  `ghichu` LONGTEXT COLLATE utf8_unicode_ci,
  `phieunhapid` INT(11) DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chitietphieunhap_hanghoa_fkey` (`hanghoaid`),
  KEY `chitietphieunhap_phieunhap_fkey` (`phieunhapid`),
  CONSTRAINT `chitietphieunhap_hanghoa_fkey` FOREIGN KEY (`hanghoaid`) REFERENCES `hanghoa` (`id`),
  CONSTRAINT `chitietphieunhap_phieunhap_fkey` FOREIGN KEY (`phieunhapid`) REFERENCES `phieunhap` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietphieunhap
-- ----------------------------

-- ----------------------------
-- Table structure for chitietphieuxuat
-- ----------------------------
DROP TABLE IF EXISTS `chitietphieuxuat`;
CREATE TABLE `chitietphieuxuat` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hanghoaid` INT(11) DEFAULT NULL,
  `phieuxuatid` INT(11) DEFAULT NULL,
  `soluong` INT(11) DEFAULT NULL,
  `dongia` DOUBLE DEFAULT NULL,
  `thanhtien` DOUBLE DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chitietphieuxuat_hanghoa_fkey` (`hanghoaid`),
  KEY `chitietphieuxuat_phieuxuat_fkey` (`phieuxuatid`),
  CONSTRAINT `chitietphieuxuat_hanghoa_fkey` FOREIGN KEY (`hanghoaid`) REFERENCES `hanghoa` (`id`),
  CONSTRAINT `chitietphieuxuat_phieuxuat_fkey` FOREIGN KEY (`phieuxuatid`) REFERENCES `phieuxuat` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietphieuxuat
-- ----------------------------

-- ----------------------------
-- Table structure for congty
-- ----------------------------
DROP TABLE IF EXISTS `congty`;
CREATE TABLE `congty` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `masothue` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `tel` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `website` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `logo` TEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of congty
-- ----------------------------

-- ----------------------------
-- Table structure for donvitinh
-- ----------------------------
DROP TABLE IF EXISTS `donvitinh`;
CREATE TABLE `donvitinh` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` LONGTEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of donvitinh
-- ----------------------------

-- ----------------------------
-- Table structure for hanghoa
-- ----------------------------
DROP TABLE IF EXISTS `hanghoa`;
CREATE TABLE `hanghoa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khohangid` INT(11) DEFAULT NULL,
  `nhomhangid` INT(11) DEFAULT NULL,
  `loaihangid` INT(11) DEFAULT NULL,
  `nhaccid` INT(11) DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `donviid` INT(11) DEFAULT NULL,
  `xuatxu` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `giamua` DOUBLE DEFAULT NULL,
  `giabanle` DOUBLE DEFAULT NULL,
  `giabansi` DOUBLE DEFAULT NULL,
  `tonkho` INT(11) DEFAULT NULL,
  `anh` TEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
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
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hanghoa
-- ----------------------------

-- ----------------------------
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `makh` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `loaikhid` INT(11) DEFAULT NULL,
  `khuvucid` INT(11) DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` LONGTEXT COLLATE utf8_unicode_ci,
  `masothue` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `dienthoai` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `taikhoan` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `nganhang` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `gioihanno` DECIMAL(30,10) DEFAULT NULL,
  `nohientai` DECIMAL(30,10) DEFAULT NULL,
  `yahoo` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `skype` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `nguoilienhe` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khachang_loaikh_fkey` (`loaikhid`),
  KEY `khachhang_khuvuc_fkey` (`khuvucid`),
  CONSTRAINT `khachang_loaikh_fkey` FOREIGN KEY (`loaikhid`) REFERENCES `loaikhachhang` (`id`),
  CONSTRAINT `khachhang_khuvuc_fkey` FOREIGN KEY (`khuvucid`) REFERENCES `khuvuc` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khachhang
-- ----------------------------
INSERT  INTO `khachhang`(`id`,`ma`,`makh`,`loaikhid`,`khuvucid`,`ten`,`diachi`,`masothue`,`dienthoai`,`email`,`taikhoan`,`nganhang`,`gioihanno`,`nohientai`,`yahoo`,`skype`,`nguoilienhe`,`activity`) VALUES (1,'KH00001',NULL,1,1,'Trần Văn Khánh','227, Nguyễn Văn Cừ, Phường 9, Quận 5, TP.HCM','THUE0098EF','0986543345','vana@gmail.com','KHONGBIET0021','VietcomBank','0.0000000000','0.0000000000',NULL,'nickSkypeNè','Nguyễn Văn A',TRUE),(2,'KH00002',NULL,1,1,'','227, Nguyễn Văn Cừ, Phường 9, Quận 5, TP.HCM','THUE0098EF','0986543345','vana@gmail.com','KHONGBIET0021','VietcomBank','0.0000000000','0.0000000000',NULL,'nickSkypeNè','Nguyễn Văn A',TRUE),(3,'KH00003',NULL,1,1,'','227, Nguyễn Văn Cừ, Phường 9, Quận 5, TP.HCM','THUE0098EF','0986543345','vana@gmail.com','KHONGBIET0021','VietcomBank','0.0000000000','0.0000000000',NULL,'nickSkypeNè','Nguyễn Văn A',TRUE),(4,'KH00004',NULL,1,1,'Trần Văn Khánh','','','','','','','0.0000000000','0.0000000000',NULL,'','',TRUE);

-- ----------------------------
-- Table structure for khohang
-- ----------------------------
DROP TABLE IF EXISTS `khohang`;
CREATE TABLE `khohang` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `nguoiqlid` INT(11) DEFAULT NULL,
  `nguoilienhe` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `dienthoai` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `diengiai` LONGTEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `khohang_nhanvien_fkey` (`nguoiqlid`),
  CONSTRAINT `khohang_nhanvien_fkey` FOREIGN KEY (`nguoiqlid`) REFERENCES `nhanvien` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khohang
-- ----------------------------

-- ----------------------------
-- Table structure for khuvuc
-- ----------------------------
DROP TABLE IF EXISTS `khuvuc`;
CREATE TABLE `khuvuc` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` LONGTEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ma` (`ma`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of khuvuc
-- ----------------------------
INSERT INTO `khuvuc`(`id`,`ma`,`ten`,`ghichu`,`activity`) VALUES (1,'MB','Miền Bắc','Khu vực miền Bắc',TRUE),(2,'MN','Miền Nam','Khu vực miền Nam',TRUE),(3,'MT','Miền Trung','Khu vực miền Trung',TRUE);
-- ----------------------------
-- Table structure for loaihang
-- ----------------------------
DROP TABLE IF EXISTS `loaihang`;
CREATE TABLE `loaihang` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ghichu` TEXT COLLATE utf8_unicode_ci,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of loaihang
-- ----------------------------

-- ----------------------------
-- Table structure for loaikhachhang
-- ----------------------------
DROP TABLE IF EXISTS `loaikhachhang`;
CREATE TABLE `loaikhachhang` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `mota` LONGTEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ma` (`ma`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of loaikhachhang
-- ----------------------------
INSERT INTO `loaikhachhang`(`id`,`ma`,`ten`,`mota`,`activity`) VALUES (1,'KL','Khách lẻ','Khách mua lẻ',TRUE),(2,'DL','Đại lý','Khách mua số lượng lón',TRUE);
-- ----------------------------
-- Table structure for nguoidung
-- ----------------------------
DROP TABLE IF EXISTS `nguoidung`;
CREATE TABLE `nguoidung` (
  `mand` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tennd` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `matkhau` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `roleid` INT(11) DEFAULT NULL,
  `nhanvienid` INT(11) DEFAULT NULL,
  `diengiai` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nguoidung_vaitro_fkey` (`roleid`),
  KEY `nguoidung_nhanvien_fkey` (`nhanvienid`),
  CONSTRAINT `nguoidung_nhanvien_fkey` FOREIGN KEY (`nhanvienid`) REFERENCES `nhanvien` (`id`),
  CONSTRAINT `nguoidung_quyen_fkey` FOREIGN KEY (`roleid`) REFERENCES `quyen` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nguoidung
-- ----------------------------
INSERT INTO `nguoidung` VALUES ('ND0001', '2', '1', '1', '1', '3', NULL, TRUE);

-- ----------------------------
-- Table structure for nhacungcap
-- ----------------------------
DROP TABLE IF EXISTS `nhacungcap`;
CREATE TABLE `nhacungcap` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khuvucid` INT(11) DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `masothue` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `fax` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `tel` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `website` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `taikhoan` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `nganhang` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `manguoilienhe` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chucvu` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nhacungcap_khuvuc_fkey` (`khuvucid`),
  CONSTRAINT `nhacungcap_khuvuc_fkey` FOREIGN KEY (`khuvucid`) REFERENCES `khuvuc` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhacungcap
-- ----------------------------

-- ----------------------------
-- Table structure for nhanvien
-- ----------------------------
DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE `nhanvien` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Ma` VARCHAR(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `Ten` VARCHAR(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `DiaChi` VARCHAR(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `GioiTinh` BIT(1) DEFAULT NULL,
  `ChucVu` VARCHAR(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Email` VARCHAR(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `DienThoai` VARCHAR(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `BoPhanId` INT(11) DEFAULT NULL,
  `NguoiQuanLyID` INT(11) DEFAULT NULL,
  `Luong` DOUBLE(65,0) DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nhanvien_bophan_fkey` (`BoPhanId`),
  KEY `NguoiQuanLyID` (`NguoiQuanLyID`),
  CONSTRAINT `nhanvien_bophan_fkey` FOREIGN KEY (`BoPhanId`) REFERENCES `bophan` (`id`),
  CONSTRAINT `nhanvien_nhanvienql_fkey` FOREIGN KEY (`NguoiQuanLyID`) REFERENCES `nhanvien` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Records of nhanvien
-- ----------------------------
INSERT INTO `nhanvien` VALUES ('3', '1', 'Nguyễn Thị Trí Tuệ', '391 trần phú', '\0', 'Tổng giám đốc', 'ntttue.gl@gmail.com', '01699952101', '1', NULL, '10000000', TRUE);

-- ----------------------------
-- Table structure for nhomhanghoa
-- ----------------------------
DROP TABLE IF EXISTS `nhomhanghoa`;
CREATE TABLE `nhomhanghoa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `ghichu` LONGTEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhomhanghoa
-- ----------------------------

-- ----------------------------
-- Table structure for phieunhap
-- ----------------------------
DROP TABLE IF EXISTS `phieunhap`;
CREATE TABLE `phieunhap` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nhaccid` INT(11) DEFAULT NULL,
  `nhanviennhapid` INT(11) DEFAULT NULL,
  `khoid` INT(11) DEFAULT NULL,
  `dienthoai` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diachi` TEXT COLLATE utf8_unicode_ci,
  `ngaynhap` DATE DEFAULT NULL,
  `ghichu` TEXT COLLATE utf8_unicode_ci,
  `tongtien` DOUBLE DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phieunhap_nhacungcap_fkey` (`nhaccid`),
  KEY `phieunhap_nhanvien_fkey` (`nhanviennhapid`),
  KEY `phieunhap_khohang_fkey` (`khoid`),
  CONSTRAINT `phieunhap_khohang_fkey` FOREIGN KEY (`khoid`) REFERENCES `khohang` (`id`),
  CONSTRAINT `phieunhap_nhacungcap_fkey` FOREIGN KEY (`nhaccid`) REFERENCES `nhacungcap` (`id`),
  CONSTRAINT `phieunhap_nhanvien_fkey` FOREIGN KEY (`nhanviennhapid`) REFERENCES `nhanvien` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of phieunhap
-- ----------------------------

-- ----------------------------
-- Table structure for phieuxuat
-- ----------------------------
DROP TABLE IF EXISTS `phieuxuat`;
CREATE TABLE `phieuxuat` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diachi` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `khoid` INT(11) DEFAULT NULL,
  `ngaygiao` DATE DEFAULT NULL,
  `nhanvienbanhangid` INT(11) DEFAULT NULL,
  `ngaylap` DATE DEFAULT NULL,
  `khachhangid` INT(11) DEFAULT NULL,
  `dienthoai` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tongtien` DOUBLE DEFAULT NULL,
  `ghichu` TEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phieuxuat_khohang_fkey` (`khoid`),
  KEY `phieuxuat_nhanvien_fkey` (`nhanvienbanhangid`),
  KEY `phieuxuat_khachhang_fkey` (`khachhangid`),
  CONSTRAINT `phieuxuat_khachhang_fkey` FOREIGN KEY (`khachhangid`) REFERENCES `khachhang` (`id`),
  CONSTRAINT `phieuxuat_khohang_fkey` FOREIGN KEY (`khoid`) REFERENCES `khohang` (`id`),
  CONSTRAINT `phieuxuat_nhanvien_fkey` FOREIGN KEY (`nhanvienbanhangid`) REFERENCES `nhanvien` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of phieuxuat
-- ----------------------------

-- ----------------------------
-- Table structure for quyen
-- ----------------------------
DROP TABLE IF EXISTS `quyen`;
CREATE TABLE `quyen` (
  `id` INT(11) NOT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `diengiai` LONGTEXT COLLATE utf8_unicode_ci,
  `activity` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of quyen
-- ----------------------------
INSERT INTO `quyen` VALUES ('1', 'admin', 'full quyền', TRUE);
INSERT INTO `quyen` VALUES ('2', 'quanly', NULL, TRUE);
INSERT INTO `quyen` VALUES ('3', 'nhanvien', NULL, TRUE);

-- ----------------------------
-- Table structure for tygia
-- ----------------------------
DROP TABLE IF EXISTS `tygia`;
CREATE TABLE `tygia` (
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `tygiaquydoi` FLOAT DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tygia
-- ----------------------------
INSERT INTO `tygia`(`ma`,`ten`,`tygiaquydoi`,`activity`,`id`) VALUES ('VND','Việt Nam đồng',1,TRUE,1),('USD','Đô la Mỹ',22000,TRUE,2),('JPY','Yên Nhật',234,TRUE,3);