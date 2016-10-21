/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.6.12-log : Database - qlbh
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qlbh` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `qlbh`;

/*Table structure for table `tygia` */

DROP TABLE IF EXISTS `tygia`;

CREATE TABLE `tygia` (
  `ma` VARCHAR(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` VARCHAR(255) CHARACTER SET utf8 DEFAULT NULL,
  `tygiaquydoi` FLOAT DEFAULT NULL,
  `activity` BIT(1) DEFAULT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
