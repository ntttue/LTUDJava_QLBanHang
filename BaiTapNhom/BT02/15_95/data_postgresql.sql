/*
Navicat PGSQL Data Transfer

Source Server         : localhost
Source Server Version : 90500
Source Host           : localhost:5432
Source Database       : qlbanhang
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90500
File Encoding         : 65001

Date: 2016-08-24 00:45:42
*/


-- ----------------------------
-- Sequence structure for inventory_ledger_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."inventory_ledger_id_seq";
CREATE SEQUENCE "public"."inventory_ledger_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for sys_log_sys_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sys_log_sys_id_seq";
CREATE SEQUENCE "public"."sys_log_sys_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 86059
 CACHE 1;

-- ----------------------------
-- Sequence structure for sysdiagrams_diagram_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sysdiagrams_diagram_id_seq";
CREATE SEQUENCE "public"."sysdiagrams_diagram_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 18
 CACHE 1;

-- ----------------------------
-- Table structure for adjustment
-- ----------------------------
DROP TABLE IF EXISTS "public"."adjustment";
CREATE TABLE "public"."adjustment" (
"id" varchar(20) COLLATE "default" NOT NULL,
"refdate" timestamp(6),
"ref_orgno" varchar(20) COLLATE "default",
"reftype" int4,
"employee_id" varchar(20) COLLATE "default",
"stock_id" varchar(20) COLLATE "default",
"amount" money,
"accept" bool,
"isclose" bool,
"description" varchar(255) COLLATE "default",
"user_id" varchar(20) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of adjustment
-- ----------------------------

-- ----------------------------
-- Table structure for adjustment_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."adjustment_detail";
CREATE TABLE "public"."adjustment_detail" (
"id" uuid NOT NULL,
"adjustment_id" varchar(20) COLLATE "default" NOT NULL,
"product_id" varchar(20) COLLATE "default" NOT NULL,
"product_name" varchar(255) COLLATE "default",
"stock_id" varchar(20) COLLATE "default",
"unit" varchar(20) COLLATE "default",
"unitconvert" money,
"width" money,
"height" money,
"orgin" varchar(255) COLLATE "default",
"currentqty" money,
"newqty" money,
"qtydiff" money,
"unitprice" money,
"amount" money,
"qtyconvert" money,
"storeid" int8,
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of adjustment_detail
-- ----------------------------

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS "public"."book";
CREATE TABLE "public"."book" (
"id" varchar(20) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default",
"created" timestamp(6),
"closed" timestamp(6),
"ismain" bool,
"isclose" bool,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for cash
-- ----------------------------
DROP TABLE IF EXISTS "public"."cash";
CREATE TABLE "public"."cash" (
"id" uuid NOT NULL,
"refdate" timestamp(6),
"reforgno" varchar(20) COLLATE "default",
"reftype" int2,
"refstatus" int2,
"cashid" uuid,
"bookid" varchar(20) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"bamount" money,
"famount" money,
"aamount" money,
"damount" money,
"eamount" money,
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cash
-- ----------------------------

-- ----------------------------
-- Table structure for cash_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."cash_item";
CREATE TABLE "public"."cash_item" (
"id" uuid NOT NULL,
"code" varchar(20) COLLATE "default",
"name" varchar(255) COLLATE "default",
"nameen" varchar(255) COLLATE "default",
"reftype" int2,
"categoryid" varchar(20) COLLATE "default",
"parentid" uuid,
"currencyid" varchar(3) COLLATE "default",
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cash_item
-- ----------------------------
INSERT INTO "public"."cash_item" VALUES ('45ca2fb1-e1ca-458f-88fc-ac4f2f6832e0', '* TRIAL ', '222', '222', '0', '', '00000000-0000-0000-0000-000000000000', 'VND', 'f', '', '2009-03-01 10:44:10.937', '', '2009-03-01 00:00:00', '', '', '2', 't');
INSERT INTO "public"."cash_item" VALUES ('bce16ce2-1fa6-42aa-aff4-335180075753', 'CI000001', '111', '111', '0', '', '00000000-0000-0000-0000-000000000000', 'VND', 'f', '', '2009-03-01 10:43:58.877', '', '2009-03-01 00:00:00', '', '111', '1', 't');

-- ----------------------------
-- Table structure for cash_item_class
-- ----------------------------
DROP TABLE IF EXISTS "public"."cash_item_class";
CREATE TABLE "public"."cash_item_class" (
"id" uuid NOT NULL,
"code" varchar(20) COLLATE "default",
"name" varchar(255) COLLATE "default",
"nameen" varchar(255) COLLATE "default",
"reftype" int2,
"objecttype" int2,
"credit" uuid,
"debit" uuid,
"currencyid" varchar(3) COLLATE "default",
"parentid" uuid,
"issystem" bool DEFAULT false,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cash_item_class
-- ----------------------------
INSERT INTO "public"."cash_item_class" VALUES ('048e12d2-91b7-43cb-8b9d-f9c56442d58a', '* TRIAL ', 'Lãi ngân hàng', '* TRIAL * TRI', '1', '1', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2010-03-29 09:04:40.657', '', '2010-03-29 09:04:40.657', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('0d20dc12-d69d-4d0c-83c6-ea64d1a7c680', '* TRIAL ', 'Chi tạm ứng', '* TRIAL * T', '2', '3', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 10:39:37.563', '', '2009-03-10 10:39:37.563', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('4ba32980-6f6d-4536-8fc6-1ec5a8168a16', 'IL000016', 'Thu khác', 'Thu khác', '1', '3', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-09 16:52:51.953', '', '2009-03-09 16:52:51.953', '', '', '11', 't');
INSERT INTO "public"."cash_item_class" VALUES ('4f25cad9-bc88-4e67-92d7-3f72299bfafc', '* TRIAL ', 'Tiền nước', 'Tiền nước', '2', '5', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 09:40:56.813', '', '2009-03-10 09:40:56.813', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('530f9d54-b6ed-4521-a679-3444e1267d92', 'IL000003', '* TRIAL * TRIAL', '* TRIAL * TRIAL', '2', '3', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-09 16:28:55.877', '', '2009-03-09 16:28:55.877', '', '', '3', 't');
INSERT INTO "public"."cash_item_class" VALUES ('55cdc9eb-a749-41c3-a689-3b004bc199fd', 'IL000008', 'Chi phí công tác', 'Chi phí công tác', '2', '3', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 08:38:14.733', '', '2009-03-10 08:38:14.733', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('57133908-783b-4090-9d7f-5f39809d6432', 'IL000009', 'Chi tạm ứng', 'Chi tạm ứng', '2', '3', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 09:40:39.97', '', '2009-03-10 09:40:39.97', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('580ed701-1b31-46d3-a203-dfc96c5de25f', 'IL000012', 'Chi phí mua hàng', 'Chi phí mua hàng', '2', '0', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 09:39:29.22', '', '2009-03-10 09:39:29.22', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('6c3a7c86-6495-430c-8f0f-d3448beed3f9', 'IL000011', 'Đóng tiền lãi ngân hàng', 'Đóng tiền lãi ngân hàng', '2', '1', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 09:39:43.267', '', '2009-03-10 09:39:43.267', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('96d82e42-e835-4ece-958b-3f51c8390b85', 'IL000004', 'Tiền điện', '* TRIAL *', '2', '5', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 09:41:04.657', '', '2009-03-10 09:41:04.657', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('97675eb1-2708-4d5d-a096-8921a7731dc2', 'IL000002', 'Thuế hàng tháng', '* TRIAL * TRIAL', '2', '5', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 09:40:31.877', '', '2009-03-10 09:40:31.877', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('b32b270d-7a1d-4ea8-b52e-07f9dae8af2c', 'IL000014', 'Bán Hàng', 'Bán Hàng', '1', '2', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 08:32:48.483', '', '2009-03-10 08:32:48.483', '', '', '0', 't');
INSERT INTO "public"."cash_item_class" VALUES ('c9758a4f-72d8-4092-921c-27492f5880f4', 'IL000006', '* TRIAL * TRIAL *', '* TRIAL * TRIAL *', '2', '3', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-09 16:30:36.47', '', '2009-03-09 16:30:36.47', '', '', '6', 't');
INSERT INTO "public"."cash_item_class" VALUES ('d2624874-a461-4245-9ecc-1bc9540e0e42', '* TRIAL ', 'Chi trả lương', '* TRIAL * TRI', '2', '2', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-09 16:34:47.953', '', '2009-03-09 16:34:47.953', '', '', '7', 't');
INSERT INTO "public"."cash_item_class" VALUES ('ea161b5f-40fe-4d64-a8e5-0d757467543a', '* TRIAL ', 'Góp vốn', 'Góp vốn', '1', '4', '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000', 'VND', '00000000-0000-0000-0000-000000000000', 't', 'f', '', '2009-03-10 08:37:09.36', '', '2009-03-10 08:37:09.36', '', '', '0', 't');

-- ----------------------------
-- Table structure for cash_method
-- ----------------------------
DROP TABLE IF EXISTS "public"."cash_method";
CREATE TABLE "public"."cash_method" (
"id" uuid NOT NULL,
"code" varchar(20) COLLATE "default",
"name" varchar(255) COLLATE "default",
"nameen" varchar(255) COLLATE "default",
"typeid" int2,
"issystem" bool DEFAULT false,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int4,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cash_method
-- ----------------------------
INSERT INTO "public"."cash_method" VALUES ('11111111-1111-1111-1111-111111111111', 'TM', 'Tiền Mặt', 'Tiền Mặt', '0', 't', 'f', 'admin', '2009-02-10 08:19:12', 'admin', '2009-02-10 08:19:12.377', 'admin', '', '1', 't');
INSERT INTO "public"."cash_method" VALUES ('22222222-2222-2222-2222-222222222222', 'CK', 'Chuyển Khoản', 'Chuyển Khoản', '0', 't', 'f', 'admin', '2009-02-10 08:19:48', 'admin', '2009-02-10 08:19:48', 'admin', '', '4', 't');

-- ----------------------------
-- Table structure for cash_payment
-- ----------------------------
DROP TABLE IF EXISTS "public"."cash_payment";
CREATE TABLE "public"."cash_payment" (
"id" varchar(20) COLLATE "default" NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"refno" varchar(20) COLLATE "default",
"reforgno" varchar(20) COLLATE "default",
"reftype" int2,
"refstatus" int2,
"paymentmethod" uuid,
"classid" varchar(20) COLLATE "default",
"reason" varchar(255) COLLATE "default",
"branchid" varchar(20) COLLATE "default",
"contractid" varchar(20) COLLATE "default",
"customerid" varchar(20) COLLATE "default",
"customername" varchar(255) COLLATE "default",
"customeraddress" varchar(255) COLLATE "default",
"customertax" varchar(20) COLLATE "default",
"contactname" varchar(100) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"amount" money,
"discount" money,
"famount" money,
"fdiscount" money,
"isreceived" bool,
"isclosed" bool,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cash_payment
-- ----------------------------

-- ----------------------------
-- Table structure for cash_receipt
-- ----------------------------
DROP TABLE IF EXISTS "public"."cash_receipt";
CREATE TABLE "public"."cash_receipt" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"refno" varchar(20) COLLATE "default",
"reforgno" varchar(20) COLLATE "default",
"reftype" int2,
"refstatus" int2,
"paymentmethod" uuid,
"classid" varchar(20) COLLATE "default",
"reason" varchar(255) COLLATE "default",
"branchid" varchar(20) COLLATE "default",
"contractid" varchar(20) COLLATE "default",
"customerid" varchar(20) COLLATE "default",
"customername" varchar(255) COLLATE "default",
"customeraddress" varchar(255) COLLATE "default",
"customertax" varchar(20) COLLATE "default",
"contactname" varchar(100) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"amount" money,
"discount" money,
"famount" money,
"fdiscount" money,
"isreceived" bool,
"isclosed" bool,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cash_receipt
-- ----------------------------

-- ----------------------------
-- Table structure for cash_term
-- ----------------------------
DROP TABLE IF EXISTS "public"."cash_term";
CREATE TABLE "public"."cash_term" (
"id" varchar(20) COLLATE "default" NOT NULL,
"code" varchar(20) COLLATE "default",
"name" varchar(255) COLLATE "default",
"nameen" varchar(255) COLLATE "default",
"typeid" int2,
"duetime" int4,
"discounttime" int4,
"discountpercent" money,
"delaywithin" int4,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of cash_term
-- ----------------------------
INSERT INTO "public"."cash_term" VALUES ('CN', 'CN', 'Công Nợ ', 'Debt', null, null, null, null, null, null, null, null, null, null, null, null, null, 't');
INSERT INTO "public"."cash_term" VALUES ('TM', 'TM', 'Thanh Toán ngay', 'Cash', '0', '0', '30', '$10.00', '10', 't', null, null, null, null, null, null, null, 't');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS "public"."city";
CREATE TABLE "public"."city" (
"province_id" varchar(20) COLLATE "default" NOT NULL,
"province_name" varchar(255) COLLATE "default",
"acn" varchar(5) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS "public"."code";
CREATE TABLE "public"."code" (
"soft_id" varchar(20) COLLATE "default" NOT NULL,
"soft_name" varchar(255) COLLATE "default",
"version" varchar(20) COLLATE "default",
"type" int4,
"contact" varchar(255) COLLATE "default",
"companyname" varchar(255) COLLATE "default",
"address" varchar(255) COLLATE "default",
"tel" varchar(20) COLLATE "default",
"mobile" varchar(20) COLLATE "default",
"fax" varchar(20) COLLATE "default",
"email" varchar(20) COLLATE "default",
"website" varchar(255) COLLATE "default",
"language" varchar(20) COLLATE "default",
"created" timestamp(6),
"limit" timestamp(6),
"day" int4,
"license" int4,
"code" varchar(100) COLLATE "default",
"number" int4,
"command" int4,
"today" timestamp(6),
"active" varchar(100) COLLATE "default",
"computercode" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of code
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS "public"."company";
CREATE TABLE "public"."company" (
"companyid" varchar(50) COLLATE "default" NOT NULL,
"compamyname" varchar(255) COLLATE "default",
"companyaddress" varchar(255) COLLATE "default",
"companytax" varchar(50) COLLATE "default",
"tel" varchar(30) COLLATE "default",
"fax" varchar(50) COLLATE "default",
"website" varchar(30) COLLATE "default",
"email" varchar(30) COLLATE "default",
"logo" bytea
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for currency
-- ----------------------------
DROP TABLE IF EXISTS "public"."currency";
CREATE TABLE "public"."currency" (
"currency_id" varchar(3) COLLATE "default" NOT NULL,
"currencyname" varchar(50) COLLATE "default",
"exchange" money,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of currency
-- ----------------------------
INSERT INTO "public"."currency" VALUES ('USD', 'Dola My', '$20,000.00', 't');
INSERT INTO "public"."currency" VALUES ('VND', '* TRIAL * TRI', '$1.00', 't');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer";
CREATE TABLE "public"."customer" (
"customer_id" varchar(20) COLLATE "default" NOT NULL,
"orderid" int8,
"customername" varchar(255) COLLATE "default" NOT NULL,
"customer_type_id" varchar(20) COLLATE "default" NOT NULL,
"customer_group_id" varchar(20) COLLATE "default" NOT NULL,
"customeraddress" varchar(255) COLLATE "default",
"birthday" varchar(10) COLLATE "default",
"barcode" varchar(20) COLLATE "default",
"tax" varchar(20) COLLATE "default",
"tel" varchar(20) COLLATE "default",
"fax" varchar(20) COLLATE "default",
"email" varchar(100) COLLATE "default",
"mobile" varchar(20) COLLATE "default",
"website" varchar(100) COLLATE "default",
"contact" varchar(100) COLLATE "default",
"position" varchar(100) COLLATE "default",
"nickym" varchar(20) COLLATE "default",
"nicksky" varchar(20) COLLATE "default",
"area" varchar(100) COLLATE "default",
"district" varchar(100) COLLATE "default",
"contry" varchar(100) COLLATE "default",
"city" varchar(100) COLLATE "default",
"bankaccount" varchar(20) COLLATE "default",
"bankname" varchar(100) COLLATE "default",
"creditlimit" money,
"discount" money,
"isdebt" bool,
"isdebtdetail" bool,
"isprovider" bool,
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for customer_debt
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer_debt";
CREATE TABLE "public"."customer_debt" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"reforgno" varchar(20) COLLATE "default",
"reftype" int2,
"refstatus" int2,
"paymentmethod" uuid,
"customerid" varchar(20) COLLATE "default",
"productid" varchar(20) COLLATE "default",
"productname" varchar(255) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"termid" varchar(20) COLLATE "default",
"duedate" timestamp(6),
"quantity" money,
"requantity" money,
"amount" money,
"discount" money,
"payment" money,
"balance" money,
"famount" money,
"fpayment" money,
"fbalance" money,
"fdiscount" money,
"ischanged" bool,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of customer_debt
-- ----------------------------

-- ----------------------------
-- Table structure for customer_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer_group";
CREATE TABLE "public"."customer_group" (
"customer_group_id" varchar(20) COLLATE "default" NOT NULL,
"customer_group_name" varchar(255) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default",
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of customer_group
-- ----------------------------

-- ----------------------------
-- Table structure for customer_receipt
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer_receipt";
CREATE TABLE "public"."customer_receipt" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"reforgno" varchar(20) COLLATE "default",
"reftype" int2,
"refstatus" int2,
"paymentmethod" uuid,
"barcode" varchar(20) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"branchid" varchar(20) COLLATE "default",
"contractid" varchar(20) COLLATE "default",
"customerid" varchar(20) COLLATE "default",
"customername" varchar(255) COLLATE "default",
"customeraddress" varchar(255) COLLATE "default",
"customertax" varchar(20) COLLATE "default",
"contactname" varchar(100) COLLATE "default",
"amount" money,
"famount" money,
"discount" money,
"fdiscount" money,
"reconciled" bool,
"ispublic" bool NOT NULL,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of customer_receipt
-- ----------------------------

-- ----------------------------
-- Table structure for customer_receipt_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer_receipt_detail";
CREATE TABLE "public"."customer_receipt_detail" (
"id" uuid NOT NULL,
"receiptid" uuid NOT NULL,
"reforgno" uuid,
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"quantity" money,
"amount" money,
"debit" money,
"payment" money,
"discountpercent" money,
"discount" money,
"fdebit" money,
"famount" money,
"fdiscount" money,
"description" varchar(255) COLLATE "default",
"sorted" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of customer_receipt_detail
-- ----------------------------

-- ----------------------------
-- Table structure for customer_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer_type";
CREATE TABLE "public"."customer_type" (
"customer_type_id" varchar(20) COLLATE "default" NOT NULL,
"customer_type_name" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of customer_type
-- ----------------------------
INSERT INTO "public"."customer_type" VALUES ('KHHM', 'Khách hàng hỏi mua', '', 't');
INSERT INTO "public"."customer_type" VALUES ('KHTN', 'Khách hàng tiềm năng', '', 't');
INSERT INTO "public"."customer_type" VALUES ('KHTX', 'Khách hàng thường xuyên', '', 't');
INSERT INTO "public"."customer_type" VALUES ('KHVL', '* TRIAL * TRIAL * T', '', 't');

-- ----------------------------
-- Table structure for debt
-- ----------------------------
DROP TABLE IF EXISTS "public"."debt";
CREATE TABLE "public"."debt" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"reforgno" uuid,
"reftype" int2,
"refstatus" int2,
"paymentmethod" uuid,
"customerid" varchar(20) COLLATE "default",
"productid" varchar(20) COLLATE "default",
"productname" varchar(255) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"termid" varchar(20) COLLATE "default",
"duedate" timestamp(6),
"quantity" money,
"requantity" money,
"price" money,
"amount" money,
"payment" money,
"balance" money,
"famount" money,
"ischanged" bool,
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of debt
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS "public"."department";
CREATE TABLE "public"."department" (
"department_id" varchar(20) COLLATE "default" NOT NULL,
"department_name" varchar(255) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default",
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of department
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS "public"."employee";
CREATE TABLE "public"."employee" (
"employee_id" varchar(20) COLLATE "default" NOT NULL,
"firtname" varchar(50) COLLATE "default",
"lastname" varchar(50) COLLATE "default",
"employee_name" varchar(100) COLLATE "default",
"alias" varchar(100) COLLATE "default",
"sex" bool,
"address" varchar(255) COLLATE "default",
"country_id" varchar(20) COLLATE "default",
"h_tel" varchar(20) COLLATE "default",
"o_tel" varchar(20) COLLATE "default",
"mobile" varchar(20) COLLATE "default",
"fax" varchar(20) COLLATE "default",
"email" varchar(255) COLLATE "default",
"birthday" timestamp(6),
"married" int4,
"position_id" varchar(20) COLLATE "default",
"jobtitle_id" varchar(20) COLLATE "default",
"branch_id" varchar(20) COLLATE "default",
"department_id" varchar(20) COLLATE "default",
"team_id" varchar(20) COLLATE "default",
"personaltax_id" varchar(50) COLLATE "default",
"city_id" varchar(20) COLLATE "default",
"district_id" varchar(20) COLLATE "default",
"manager_id" varchar(20) COLLATE "default",
"employeetype" int4 DEFAULT 0,
"basicsalary" money,
"advance" money,
"advanceother" money,
"commission" money,
"discount" money,
"profitrate" money,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for form
-- ----------------------------
DROP TABLE IF EXISTS "public"."form";
CREATE TABLE "public"."form" (
"form_id" varchar(50) COLLATE "default" NOT NULL,
"form_caption" varchar(255) COLLATE "default",
"encaption" varchar(250) COLLATE "default",
"width" int4 DEFAULT 0,
"height" int4 DEFAULT 0,
"description" varchar(255) COLLATE "default",
"active" bool DEFAULT true
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of form
-- ----------------------------
INSERT INTO "public"."form" VALUES ('frmChangePassword', 'Thay đổi mật khẩu', 'Change password', '0', '0', '', 't');
INSERT INTO "public"."form" VALUES ('xfmAdjustment', 'Phiếu kiểm kê', 'Adjust', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmAdjustmentList', 'Bảng kê kiểm kê', 'Adjust List', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmBuild', '* TRIAL * TRI', 'Build', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmBuildList', 'Bảng kê lắp ráp', 'Build List', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmInventoryDetail', 'Tồn kho', '* TRIAL * TRIAL ', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmInventoryInit', 'Tồn kho', 'Inventory Init', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmInward', '* TRIAL * TRIA', 'Inward', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmInwardList', 'Bảng kê nhập hàng', '* TRIAL * T', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmOutward', 'Phiếu xuất kho', 'Outward', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmOutwardList', '* TRIAL * TRIAL *', 'Outward List', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmTransfer', 'Phiếu chuyển kho', 'Transfer', null, null, null, null);
INSERT INTO "public"."form" VALUES ('xfmTransferList', 'Bảng kê chuyển kho', 'Transfer List', '0', '0', '', 't');

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS "public"."inventory";
CREATE TABLE "public"."inventory" (
"id" int8 NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"reftype" int4,
"stock_id" varchar(20) COLLATE "default",
"product_id" varchar(20) COLLATE "default",
"customer_id" varchar(20) COLLATE "default",
"currency_id" varchar(3) COLLATE "default",
"limit" timestamp(6),
"quantity" money,
"amount" money,
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"chassyno" varchar(50) COLLATE "default",
"color" varchar(20) COLLATE "default",
"location" varchar(20) COLLATE "default",
"width" money DEFAULT 0,
"height" money DEFAULT 0,
"orgin" varchar(255) COLLATE "default",
"size" varchar(255) COLLATE "default",
"descritopn" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of inventory
-- ----------------------------

-- ----------------------------
-- Table structure for inventory_action
-- ----------------------------
DROP TABLE IF EXISTS "public"."inventory_action";
CREATE TABLE "public"."inventory_action" (
"action_id" int4 NOT NULL,
"action_name" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of inventory_action
-- ----------------------------
INSERT INTO "public"."inventory_action" VALUES ('0', 'Đầu kỳ');
INSERT INTO "public"."inventory_action" VALUES ('1', 'Nhập kho');
INSERT INTO "public"."inventory_action" VALUES ('2', 'Xuất kho');
INSERT INTO "public"."inventory_action" VALUES ('3', '* TRIAL ');
INSERT INTO "public"."inventory_action" VALUES ('4', 'Nhập Lắp');
INSERT INTO "public"."inventory_action" VALUES ('5', 'Kiểm Kê');
INSERT INTO "public"."inventory_action" VALUES ('6', 'Xuất chuyển');
INSERT INTO "public"."inventory_action" VALUES ('7', 'Nhập chuyển');
INSERT INTO "public"."inventory_action" VALUES ('8', '* TRIAL * TR');
INSERT INTO "public"."inventory_action" VALUES ('9', 'Nhập Lắp Ráp');

-- ----------------------------
-- Table structure for inventory_book
-- ----------------------------
DROP TABLE IF EXISTS "public"."inventory_book";
CREATE TABLE "public"."inventory_book" (
"id" uuid NOT NULL,
"book_id" varchar(20) COLLATE "default",
"created" timestamp(6),
"stock_date" timestamp(6),
"limit" timestamp(6),
"stock_id" varchar(20) COLLATE "default",
"product_id" varchar(20) COLLATE "default",
"productname" varchar(255) COLLATE "default",
"customer_id" varchar(20) COLLATE "default",
"currency_id" varchar(3) COLLATE "default",
"quantity" money,
"exchangerate" money,
"unitprice" money,
"amount" money,
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"frame" varchar(50) COLLATE "default",
"width" money,
"height" money,
"orgin" varchar(255) COLLATE "default",
"size" varchar(255) COLLATE "default",
"lock" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of inventory_book
-- ----------------------------

-- ----------------------------
-- Table structure for inventory_date
-- ----------------------------
DROP TABLE IF EXISTS "public"."inventory_date";
CREATE TABLE "public"."inventory_date" (
"id" int8 NOT NULL,
"refdate" timestamp(6),
"stock_id" varchar(20) COLLATE "default",
"product_id" varchar(20) COLLATE "default",
"e_qty" money,
"e_unt" money,
"e_amt" money
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of inventory_date
-- ----------------------------

-- ----------------------------
-- Table structure for inventory_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."inventory_detail";
CREATE TABLE "public"."inventory_detail" (
"id" int8 NOT NULL,
"refno" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"refdetailno" uuid,
"reftype" int4,
"refstatus" int4,
"storeid" int8,
"stock_id" varchar(20) COLLATE "default",
"product_id" varchar(20) COLLATE "default",
"product_name" varchar(255) COLLATE "default",
"customer_id" varchar(20) COLLATE "default",
"employee_id" varchar(20) COLLATE "default",
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"unit" varchar(50) COLLATE "default",
"price" money,
"quantity" money,
"unitprice" money,
"amount" money,
"e_qty" money,
"e_amt" money,
"description" varchar(255) COLLATE "default",
"sorted" int8,
"book_id" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of inventory_detail
-- ----------------------------

-- ----------------------------
-- Table structure for inventory_ledger
-- ----------------------------
DROP TABLE IF EXISTS "public"."inventory_ledger";
CREATE TABLE "public"."inventory_ledger" (
"id" int4 DEFAULT nextval('inventory_ledger_id_seq'::regclass) NOT NULL,
"refdate" timestamp(6),
"product_id" varchar(20) COLLATE "default" NOT NULL,
"product_name" varchar(255) COLLATE "default",
"unit_name" varchar(250) COLLATE "default",
"stock_id" varchar(20) COLLATE "default",
"stock_name" varchar(255) COLLATE "default",
"product_group_id" varchar(20) COLLATE "default",
"productgroup_name" varchar(255) COLLATE "default",
"openquantity" money,
"openamount" money,
"inquantity" money,
"inamount" money,
"outquantity" money,
"outamount" money,
"onhandquantity" money,
"closeamount" money
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of inventory_ledger
-- ----------------------------

-- ----------------------------
-- Table structure for keycode
-- ----------------------------
DROP TABLE IF EXISTS "public"."keycode";
CREATE TABLE "public"."keycode" (
"id_key" int4 NOT NULL,
"keycode" varchar(500) COLLATE "default" NOT NULL,
"id_contact" int4,
"datecreate" timestamp(6) NOT NULL,
"property" varchar(500) COLLATE "default",
"numactive" int4 NOT NULL,
"activated" int4 NOT NULL,
"blacklist" bool,
"typeactive" int4,
"typesoft" int4,
"datelimit" timestamp(6),
"register" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of keycode
-- ----------------------------

-- ----------------------------
-- Table structure for license
-- ----------------------------
DROP TABLE IF EXISTS "public"."license";
CREATE TABLE "public"."license" (
"id_license" int4 NOT NULL,
"id_soft" int4 NOT NULL,
"keycode" varchar(500) COLLATE "default" NOT NULL,
"machinecode" varchar(500) COLLATE "default" NOT NULL,
"active" bool,
"version" varchar(50) COLLATE "default",
"dateactive" timestamp(6),
"reactive" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of license
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS "public"."message";
CREATE TABLE "public"."message" (
"mess_id" varchar(50) COLLATE "default" NOT NULL,
"caption" varchar(200) COLLATE "default",
"encaption" varchar(200) COLLATE "default",
"description" varchar(250) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO "public"."message" VALUES ('* TRIAL ', '* TRIAL * TRIAL * TRI', 'Do you want to delete ?', null, null);
INSERT INTO "public"."message" VALUES ('* TRIAL * ', 'Vui lòng chọn người thực hiện', 'Please select employee', null, null);
INSERT INTO "public"."message" VALUES ('meBuildOver', 'Số lượng hàng trong kho không đủ lắp ráp', '* TRIAL * TRIAL * TRIAL * TRIAL * TRIAL ', null, null);
INSERT INTO "public"."message" VALUES ('meCustomerOutward', 'Vui lòng chọn khách hàng', 'Please select customer', null, null);
INSERT INTO "public"."message" VALUES ('meDuplicate', 'Mã này đã tồn tại', 'Exists  Code', null, null);
INSERT INTO "public"."message" VALUES ('meEmpty', 'Ô này không được rỗng', '* TRIAL * ', null, null);
INSERT INTO "public"."message" VALUES ('meProduct', 'Phiếu này rỗng, không thể lưu được', 'Please select product', null, null);
INSERT INTO "public"."message" VALUES ('meProviderInward', '* TRIAL * TRIAL * TRIAL * T', 'Please select provider', null, null);
INSERT INTO "public"."message" VALUES ('meStockInward', 'Vui lòng chọn kho', 'Please select stock', null, null);

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS "public"."module";
CREATE TABLE "public"."module" (
"id" int4 NOT NULL,
"ref_id" varchar(20) COLLATE "default",
"ref_name" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"path" varchar(255) COLLATE "default",
"version" varchar(20) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of module
-- ----------------------------

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS "public"."payment";
CREATE TABLE "public"."payment" (
"payment_id" varchar(20) COLLATE "default",
"payment_date" timestamp(6),
"payment_no" varchar(20) COLLATE "default",
"receivername" varchar(100) COLLATE "default",
"currency_id" varchar(3) COLLATE "default",
"exchange" money,
"customer_id" char(10) COLLATE "default",
"customer_name" varchar(255) COLLATE "default",
"customer_address" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"payment_group_id" varchar(20) COLLATE "default",
"amount" money
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of payment
-- ----------------------------

-- ----------------------------
-- Table structure for payment_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."payment_group";
CREATE TABLE "public"."payment_group" (
"payment_group_id" varchar(20) COLLATE "default" NOT NULL,
"payment_group_name" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of payment_group
-- ----------------------------
INSERT INTO "public"."payment_group" VALUES ('01', '024545', '02', 't');
INSERT INTO "public"."payment_group" VALUES ('03', '28', '', 't');
INSERT INTO "public"."payment_group" VALUES ('06', '099 ', '5', 't');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS "public"."product";
CREATE TABLE "public"."product" (
"product_id" varchar(20) COLLATE "default" NOT NULL,
"product_name" varchar(255) COLLATE "default",
"product_nameen" varchar(255) COLLATE "default",
"product_type_id" int4,
"manufacturer_id" int4,
"model_id" varchar(20) COLLATE "default",
"product_group_id" varchar(20) COLLATE "default",
"provider_id" varchar(20) COLLATE "default",
"origin" varchar(100) COLLATE "default",
"barcode" varchar(20) COLLATE "default",
"unit" varchar(20) COLLATE "default",
"unitconvert" varchar(20) COLLATE "default",
"unitrate" money,
"org_price" money,
"sale_price" money,
"retail_price" money,
"quantity" money DEFAULT 0,
"currentcost" money,
"averagecost" money,
"warranty" int4,
"vat_id" money,
"importtax_id" money,
"exporttax_id" money,
"luxurytax_id" money,
"customer_id" varchar(20) COLLATE "default",
"customer_name" varchar(255) COLLATE "default",
"costmethod" int2 DEFAULT 0,
"minstock" money DEFAULT 0,
"maxstock" money DEFAULT 0,
"discount" money DEFAULT 0,
"commission" money DEFAULT 0,
"description" varchar(255) COLLATE "default",
"color" varchar(50) COLLATE "default",
"expiry" bool,
"limitorders" money DEFAULT 0,
"expiryvalue" money DEFAULT 0,
"batch" bool,
"depth" money DEFAULT 0,
"height" money DEFAULT 0,
"width" money DEFAULT 0,
"thickness" money DEFAULT 0,
"size" varchar(50) COLLATE "default",
"photo" bytea,
"currency_id" varchar(3) COLLATE "default" DEFAULT 'VND'::character varying,
"exchangerate" money DEFAULT 1,
"stock_id" varchar(20) COLLATE "default",
"userid" varchar(20) COLLATE "default",
"serial" bool,
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for product_build
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_build";
CREATE TABLE "public"."product_build" (
"productid" varchar(20) COLLATE "default" NOT NULL,
"buildid" varchar(20) COLLATE "default" NOT NULL,
"quantity" money,
"price" money,
"amount" money
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of product_build
-- ----------------------------

-- ----------------------------
-- Table structure for product_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_group";
CREATE TABLE "public"."product_group" (
"productgroup_id" varchar(20) COLLATE "default" NOT NULL,
"productgroup_name" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"ismain" bool DEFAULT false,
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of product_group
-- ----------------------------

-- ----------------------------
-- Table structure for product_model
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_model";
CREATE TABLE "public"."product_model" (
"id" uuid,
"code" varchar(20) COLLATE "default",
"name" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of product_model
-- ----------------------------

-- ----------------------------
-- Table structure for product_price
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_price";
CREATE TABLE "public"."product_price" (
"id" uuid NOT NULL,
"refdate" timestamp(6),
"refstatus" int2,
"begindate" timestamp(6),
"enddate" timestamp(6),
"productid" uuid,
"customerid" uuid,
"price" money,
"discountrate" money,
"commissionrate" money,
"quantity" money,
"beginamount" money,
"endamount" money,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of product_price
-- ----------------------------

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_type";
CREATE TABLE "public"."product_type" (
"product_type_id" int4 NOT NULL,
"product_name" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of product_type
-- ----------------------------

-- ----------------------------
-- Table structure for product_unit
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_unit";
CREATE TABLE "public"."product_unit" (
"product_id" varchar(20) COLLATE "default" NOT NULL,
"unit_id" varchar(20) COLLATE "default" NOT NULL,
"unitconvert_id" varchar(20) COLLATE "default" NOT NULL,
"unitconvert" money NOT NULL,
"sorted" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of product_unit
-- ----------------------------

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS "public"."provider";
CREATE TABLE "public"."provider" (
"customer_id" varchar(20) COLLATE "default" NOT NULL,
"orderid" int8,
"customername" varchar(255) COLLATE "default" NOT NULL,
"customer_type_id" varchar(20) COLLATE "default" NOT NULL,
"customer_group_id" varchar(20) COLLATE "default" NOT NULL,
"customeraddress" varchar(255) COLLATE "default",
"birthday" varchar(10) COLLATE "default",
"barcode" varchar(20) COLLATE "default",
"tax" varchar(20) COLLATE "default",
"tel" varchar(20) COLLATE "default",
"fax" varchar(20) COLLATE "default",
"email" varchar(100) COLLATE "default",
"mobile" varchar(20) COLLATE "default",
"website" varchar(100) COLLATE "default",
"contact" varchar(100) COLLATE "default",
"position" varchar(100) COLLATE "default",
"nickym" varchar(20) COLLATE "default",
"nicksky" varchar(20) COLLATE "default",
"area" varchar(100) COLLATE "default",
"district" varchar(100) COLLATE "default",
"contry" varchar(100) COLLATE "default",
"city" varchar(100) COLLATE "default",
"bankaccount" varchar(20) COLLATE "default",
"bankname" varchar(100) COLLATE "default",
"creditlimit" money,
"discount" money,
"isdebt" bool,
"isdebtdetail" bool,
"isprovider" bool,
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of provider
-- ----------------------------

-- ----------------------------
-- Table structure for provider_debt
-- ----------------------------
DROP TABLE IF EXISTS "public"."provider_debt";
CREATE TABLE "public"."provider_debt" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default" NOT NULL,
"refdate" timestamp(6) NOT NULL,
"reforgno" varchar(20) COLLATE "default" NOT NULL,
"reftype" int2 NOT NULL,
"refstatus" int2 NOT NULL,
"paymentmethod" uuid NOT NULL,
"customerid" varchar(20) COLLATE "default" NOT NULL,
"productid" varchar(20) COLLATE "default" NOT NULL,
"productname" varchar(255) COLLATE "default",
"currencyid" varchar(20) COLLATE "default",
"exchangerate" money,
"termid" varchar(20) COLLATE "default",
"duedate" timestamp(6),
"quantity" money,
"requantity" money,
"amount" money,
"payment" money,
"balance" money,
"famount" money,
"fpayment" money,
"fbalance" money,
"discount" money,
"fdiscount" money,
"ischanged" bool,
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of provider_debt
-- ----------------------------

-- ----------------------------
-- Table structure for provider_payment
-- ----------------------------
DROP TABLE IF EXISTS "public"."provider_payment";
CREATE TABLE "public"."provider_payment" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"reforgno" varchar(20) COLLATE "default",
"reftype" int2,
"refstatus" int2,
"paymentmethod" uuid,
"barcode" varchar(20) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"branchid" varchar(20) COLLATE "default",
"contractid" varchar(20) COLLATE "default",
"customerid" varchar(20) COLLATE "default",
"customername" varchar(255) COLLATE "default",
"customeraddress" varchar(255) COLLATE "default",
"customertax" varchar(20) COLLATE "default",
"contactname" varchar(100) COLLATE "default",
"amount" money,
"famount" money,
"discount" money,
"fdiscount" money,
"reconciled" bool,
"ispublic" bool NOT NULL,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of provider_payment
-- ----------------------------

-- ----------------------------
-- Table structure for provider_payment_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."provider_payment_detail";
CREATE TABLE "public"."provider_payment_detail" (
"id" uuid NOT NULL,
"paymentid" uuid NOT NULL,
"reforgno" uuid,
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"quantity" money,
"amount" money,
"debit" money,
"payment" money,
"discountpercent" money,
"discount" money,
"famount" money,
"fdebit" money,
"fpayment" money,
"fdiscount" money,
"description" varchar(255) COLLATE "default",
"sorted" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of provider_payment_detail
-- ----------------------------

-- ----------------------------
-- Table structure for receipt
-- ----------------------------
DROP TABLE IF EXISTS "public"."receipt";
CREATE TABLE "public"."receipt" (
"receipt_id" varchar(20) COLLATE "default" NOT NULL,
"receipt_date" timestamp(6),
"receipt_no" varchar(20) COLLATE "default",
"deliverername" varchar(100) COLLATE "default",
"currency_id" varchar(3) COLLATE "default",
"exchange" money,
"customer_id" varchar(20) COLLATE "default",
"customer_name" varchar(255) COLLATE "default",
"customer_address" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"receipt_group_id" varchar(20) COLLATE "default",
"amount" money
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of receipt
-- ----------------------------

-- ----------------------------
-- Table structure for receipt_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."receipt_group";
CREATE TABLE "public"."receipt_group" (
"receipt_group_id" varchar(20) COLLATE "default" NOT NULL,
"receipt_group_name" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of receipt_group
-- ----------------------------
INSERT INTO "public"."receipt_group" VALUES ('01', '012', '', 't');
INSERT INTO "public"."receipt_group" VALUES ('03', 'uew', '', 't');
INSERT INTO "public"."receipt_group" VALUES ('06', 'ưe', '', 't');
INSERT INTO "public"."receipt_group" VALUES ('08', '125', '', 't');
INSERT INTO "public"."receipt_group" VALUES ('15', '2656 ưe', '', 't');
INSERT INTO "public"."receipt_group" VALUES ('36', 'sds ', '', 't');
INSERT INTO "public"."receipt_group" VALUES ('565', '2656 ', '56', 't');

-- ----------------------------
-- Table structure for reftype
-- ----------------------------
DROP TABLE IF EXISTS "public"."reftype";
CREATE TABLE "public"."reftype" (
"id" int2 NOT NULL,
"name" varchar(255) COLLATE "default",
"nameen" varchar(255) COLLATE "default",
"categoryid" int2,
"sorted" int8,
"issearch" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of reftype
-- ----------------------------
INSERT INTO "public"."reftype" VALUES ('0', 'Số Dư Đầu Kỳ Kho', null, '10', '1', 't');
INSERT INTO "public"."reftype" VALUES ('1', 'Nhập Kho', null, '10', '2', 't');
INSERT INTO "public"."reftype" VALUES ('2', 'Xuất Kho', null, '10', '3', 't');
INSERT INTO "public"."reftype" VALUES ('3', 'Lắp Ráp', null, '10', '4', 't');
INSERT INTO "public"."reftype" VALUES ('4', 'Tháo Gỡ', null, '10', '5', 't');
INSERT INTO "public"."reftype" VALUES ('5', 'Kiểm Kê', null, '10', '6', 't');
INSERT INTO "public"."reftype" VALUES ('6', 'Xuất & Đóng Gói', null, '10', '7', 't');
INSERT INTO "public"."reftype" VALUES ('7', 'Đóng Gói BTP', null, '10', '8', 't');
INSERT INTO "public"."reftype" VALUES ('8', 'Đóng Gói TP', null, '10', '9', 't');
INSERT INTO "public"."reftype" VALUES ('9', 'Chuyển Kho', null, '10', '10', 't');
INSERT INTO "public"."reftype" VALUES ('10', '* TRIAL * T', null, null, '0', 't');
INSERT INTO "public"."reftype" VALUES ('11', 'Nhập trả hàng', null, '10', '13', 't');
INSERT INTO "public"."reftype" VALUES ('12', '* TRIAL * TRI', null, '10', '14', 't');
INSERT INTO "public"."reftype" VALUES ('20', 'Quản Lý Bán Hàng', null, null, '1', 't');
INSERT INTO "public"."reftype" VALUES ('21', '* TRIAL * TRIA', null, null, '4', 't');
INSERT INTO "public"."reftype" VALUES ('22', '* TRIAL * TR', null, null, '5', 't');
INSERT INTO "public"."reftype" VALUES ('23', 'Phiếu Mua Hàng', null, '20', '13', 't');
INSERT INTO "public"."reftype" VALUES ('30', 'Quản Lý Công Nợ', null, null, '2', 't');
INSERT INTO "public"."reftype" VALUES ('31', 'Số Dư Công Nợ Khách Hàng', null, '30', '1', 't');
INSERT INTO "public"."reftype" VALUES ('32', 'Số Dư Công Nợ Nhà Phân Phối', null, '30', '2', 't');
INSERT INTO "public"."reftype" VALUES ('33', 'Số Dư Công Nợ Nhân Viên', null, '30', '3', 't');
INSERT INTO "public"."reftype" VALUES ('34', 'Số Dư Quỹ', null, '20', '4', 't');
INSERT INTO "public"."reftype" VALUES ('35', 'Phiếu Thu Tiền Nợ Khách Hàng', null, null, '5', 't');
INSERT INTO "public"."reftype" VALUES ('36', 'Phiếu Chi Tiền Nợ Nhà Phân Phối', null, null, '14', 't');
INSERT INTO "public"."reftype" VALUES ('40', 'Quản Lý Quỹ', null, null, '3', 't');
INSERT INTO "public"."reftype" VALUES ('41', 'Phiếu Thu', null, '40', '11', 't');
INSERT INTO "public"."reftype" VALUES ('42', 'Phiếu Chi', null, '40', '12', 't');
INSERT INTO "public"."reftype" VALUES ('43', 'Thu Tiền', null, '30', null, null);

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS "public"."report";
CREATE TABLE "public"."report" (
"report_id" varchar(20) COLLATE "default" NOT NULL,
"report_name" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"comment" varchar(255) COLLATE "default",
"filename" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"dataset" varchar(50) COLLATE "default",
"class" varchar(50) COLLATE "default",
"parent_id" varchar(20) COLLATE "default",
"order" int4,
"avtive" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO "public"."report" VALUES ('RD0000000', 'Báo cáo tồn kho', 'BÁO CÁO TỒN KHO', '', '', '', '', '', '', '0', 't');
INSERT INTO "public"."report" VALUES ('RD0000001', 'Thẻ kho', 'THẺ KHO', '', '', '', '', '', 'RD0000000', '1', 't');
INSERT INTO "public"."report" VALUES ('RD0000002', 'Sổ chi tiết vật tư', 'SỔ CHI TIẾT VẬT TƯ', '', '', '', '', '', 'RD0000000', '3', 't');
INSERT INTO "public"."report" VALUES ('RD0000003', 'Tổng số lượng xuất nhập tồn', 'TỔNG HỢP SỐ LƯỢNG XUẤT NHẬP TỒN', '', '', '', '', '', 'RD0000000', '4', 't');
INSERT INTO "public"."report" VALUES ('RD0000004', 'Tổng hợp xuất nhập tồn', '* TRIAL * TRIAL * TRIA', '', '', '', '', '', 'RD0000000', '5', 't');
INSERT INTO "public"."report" VALUES ('RD0000005', 'Tồn kho', 'TỒN KHO', '', '', '', '', '', 'RD0000000', '6', 't');
INSERT INTO "public"."report" VALUES ('RD0000006', 'Chi tiết tồn kho', 'CHI TIẾT TỒN KHO', '', '', '', '', '', 'RD0000000', '7', 't');
INSERT INTO "public"."report" VALUES ('RD0000007', 'Tồn kho theo hạn sử dụng', 'TỒN KHO THEO HẠN SỬ DỤNG', '', '', '', '', '', '* TRIAL *', '8', 't');
INSERT INTO "public"."report" VALUES ('RD0000008', '* TRIAL * TRIAL ', '* TRIAL * TRIAL ', '', '', '', '', '', 'RD0000000', '9', 't');
INSERT INTO "public"."report" VALUES ('RD0000009', 'Tồn kho vượt định mức', 'TỒN KHO VƯỢT ĐỊNH MỨC', '', '', '', '', '', 'RD0000000', '10', 't');
INSERT INTO "public"."report" VALUES ('RD0000010', 'Thẻ kho DN', 'THẺ KHO', '', '', '', '', '', 'RD0000000', '2', 't');
INSERT INTO "public"."report" VALUES ('RD0000011', '* TRIAL * TRIAL * TRI', 'TỒN KHO DƯỚI ĐỊNH MỨC', '', '', '', '', '', 'RD0000000', '11', 't');
INSERT INTO "public"."report" VALUES ('RD0000027', 'Tổng hợp xuất nhập tồn (Đơn giản)', '* TRIAL * TRIAL * TRIAL * TRIAL *', '', '', '', '', '', 'RD0000000', '12', 't');
INSERT INTO "public"."report" VALUES ('RD0000028', 'Tổng hợp nhập luân chuyển', 'TỔNG HỢP NHẬP LUÂN CHUYỂN', '', '', '', '', '', 'RD0000000', '13', 't');
INSERT INTO "public"."report" VALUES ('RD0000029', 'Tổng hợp xuất luân chuyển', '* TRIAL * TRIAL * TRIAL *', '', '', '', '', '', 'RD0000000', '14', 't');
INSERT INTO "public"."report" VALUES ('RD0000031', 'Bảng kê chi tiết nhập kho', '* TRIAL * TRIAL * TRIAL *', '', '', '', '', '', '* TRIAL *', '16', 't');
INSERT INTO "public"."report" VALUES ('RD0000033', 'Bảng kê chi tiết xuất kho', 'BẢNG KÊ CHIT TIẾT XUẤT KHO', '', '', '', '', '', 'RD0000000', '18', 't');
INSERT INTO "public"."report" VALUES ('RD0000035', 'Bảng kê chi tiết chuyển kho', 'BẢNG KÊ CHI TIẾT CHUYỂN KHO', '', '', '', '', '', 'RD0000000', '20', 't');
INSERT INTO "public"."report" VALUES ('RD0000037', 'Bảng kê chi tiết kiểm kê', 'BẢNG KÊ CHI TIẾT KIỀM KÊ', '', '', '', '', '', '* TRIAL *', '22', 't');
INSERT INTO "public"."report" VALUES ('RD0000080', 'Báo cáo Doanh Thu Theo Ngày', 'BẢNG KÊ DOANH THU THEO NGÀY', null, null, null, null, null, 'RD0000000', '23', 't');

-- ----------------------------
-- Table structure for report_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."report_group";
CREATE TABLE "public"."report_group" (
"report_group_id" varchar(20) COLLATE "default" NOT NULL,
"report_group_name" varchar(50) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of report_group
-- ----------------------------
INSERT INTO "public"."report_group" VALUES ('RG0000001', 'Báo cáo kho hàng', 'Báo cáo kho hàng', 't');

-- ----------------------------
-- Table structure for sale_order
-- ----------------------------
DROP TABLE IF EXISTS "public"."sale_order";
CREATE TABLE "public"."sale_order" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"refno" varchar(20) COLLATE "default",
"reforgno" varchar(20) COLLATE "default",
"reftype" int2,
"refstatus" int2,
"paymentmethod" varchar(20) COLLATE "default",
"barcode" varchar(20) COLLATE "default",
"stockid" varchar(20) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"branchid" varchar(20) COLLATE "default",
"contractid" varchar(20) COLLATE "default",
"customerid" varchar(20) COLLATE "default",
"customername" varchar(255) COLLATE "default",
"customeraddress" varchar(255) COLLATE "default",
"customertax" varchar(20) COLLATE "default",
"contactname" varchar(100) COLLATE "default",
"shipviaid" varchar(20) COLLATE "default",
"termid" varchar(20) COLLATE "default",
"duedate" timestamp(6),
"expecteddate" timestamp(6),
"discountdate" timestamp(6),
"discountpercent" money,
"discounttaken" money,
"ispaid" bool,
"isreceived" bool,
"isclosed" bool,
"isprinted" bool,
"isfob" bool,
"fob" money,
"amount" money,
"payment" money,
"vatamount" money,
"discount" money,
"otherdiscount" money,
"shipcharge" money,
"othercharge" money,
"famount" money,
"fpayment" money,
"fvatamount" money,
"fdiscount" money,
"fotherdiscount" money,
"fshipcharge" money,
"fothercharge" money,
"sellerid" varchar(20) COLLATE "default",
"deliverid" varchar(20) COLLATE "default",
"deliverydate" timestamp(6),
"driverid" varchar(20) COLLATE "default",
"trucknumber" varchar(20) COLLATE "default",
"carryingmeans" varchar(255) COLLATE "default",
"ispublic" bool,
"createdby" varchar(20) COLLATE "default",
"createddate" timestamp(6),
"modifiedby" varchar(20) COLLATE "default",
"modifieddate" timestamp(6),
"ownerid" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sale_order
-- ----------------------------

-- ----------------------------
-- Table structure for sale_order_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."sale_order_detail";
CREATE TABLE "public"."sale_order_detail" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default" NOT NULL,
"stockid" varchar(20) COLLATE "default",
"typeid" int2,
"productid" varchar(20) COLLATE "default" NOT NULL,
"productname" varchar(255) COLLATE "default",
"unit" varchar(20) COLLATE "default",
"unitconvert" money,
"taxid" varchar(20) COLLATE "default",
"taxrate" money,
"taxamount" money,
"vat" varchar(20) COLLATE "default",
"quantity" money,
"shipped" money,
"funitprice" money,
"unitprice" money,
"discountrate" money,
"fdiscount" money,
"discount" money,
"fvatamount" money,
"vatamount" money,
"fcharge" money,
"charge" money,
"famount" money,
"amount" money,
"batch" varchar(20) COLLATE "default",
"serialbegin" varchar(20) COLLATE "default",
"serialend" varchar(20) COLLATE "default",
"chassyno" varchar(20) COLLATE "default",
"width" money,
"height" money,
"orgin" varchar(255) COLLATE "default",
"size" varchar(255) COLLATE "default",
"isclosed" bool,
"iswarranty" bool,
"isborrow" bool,
"isbatch" bool,
"isserial" bool,
"sorted" int4,
"storeid" uuid,
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sale_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for soft
-- ----------------------------
DROP TABLE IF EXISTS "public"."soft";
CREATE TABLE "public"."soft" (
"id_soft" int4 NOT NULL,
"name" varchar(255) COLLATE "default" NOT NULL,
"newversion" varchar(50) COLLATE "default",
"date" timestamp(6),
"verhistory" varchar(500) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of soft
-- ----------------------------

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock";
CREATE TABLE "public"."stock" (
"stock_id" varchar(20) COLLATE "default" NOT NULL,
"stock_name" varchar(255) COLLATE "default",
"contact" varchar(255) COLLATE "default",
"address" varchar(255) COLLATE "default",
"email" varchar(50) COLLATE "default",
"telephone" varchar(20) COLLATE "default",
"fax" varchar(20) COLLATE "default",
"mobi" varchar(20) COLLATE "default",
"manager" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock
-- ----------------------------

-- ----------------------------
-- Table structure for stock_build
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_build";
CREATE TABLE "public"."stock_build" (
"id" varchar(20) COLLATE "default" NOT NULL,
"refdate" timestamp(6),
"ref_orgno" varchar(20) COLLATE "default",
"reftype" int4 DEFAULT 1,
"barcode" varchar(20) COLLATE "default",
"department_id" varchar(20) COLLATE "default",
"employee_id" varchar(20) COLLATE "default",
"fromstock_id" varchar(20) COLLATE "default",
"tostock_id" varchar(20) COLLATE "default",
"branch_id" varchar(20) COLLATE "default",
"contract_id" varchar(20) COLLATE "default",
"product_id" varchar(20) COLLATE "default",
"currency_id" varchar(3) COLLATE "default",
"productname" varchar(255) COLLATE "default",
"exchangerate" money,
"quantity" money,
"amount" money,
"famount" money,
"isclose" bool,
"description" varchar(255) COLLATE "default",
"user_id" varchar(20) COLLATE "default",
"sorted" int8,
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_build
-- ----------------------------

-- ----------------------------
-- Table structure for stock_build_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_build_detail";
CREATE TABLE "public"."stock_build_detail" (
"id" uuid NOT NULL,
"transfer_id" varchar(20) COLLATE "default" NOT NULL,
"reftype" int4,
"product_id" varchar(20) COLLATE "default" NOT NULL,
"product_name" varchar(250) COLLATE "default",
"outstock" varchar(20) COLLATE "default",
"instock" varchar(20) COLLATE "default",
"unit" varchar(20) COLLATE "default",
"unitconvert" money,
"unitprice" money,
"quantity" money,
"amount" money,
"qtyconvert" money,
"limit" timestamp(6),
"width" money,
"height" money,
"orgin" varchar(255) COLLATE "default",
"size" varchar(255) COLLATE "default",
"color" varchar(255) COLLATE "default",
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"chassyno" varchar(50) COLLATE "default",
"ime" varchar(50) COLLATE "default",
"storeid" int8,
"description" varchar(255) COLLATE "default",
"sorted" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_build_detail
-- ----------------------------

-- ----------------------------
-- Table structure for stock_inward
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_inward";
CREATE TABLE "public"."stock_inward" (
"id" varchar(20) COLLATE "default" NOT NULL,
"refdate" timestamp(6),
"ref_orgno" varchar(20) COLLATE "default",
"reftype" int4,
"refstatus" int4 DEFAULT 0,
"paymentmethod" uuid,
"termid" varchar(20) COLLATE "default",
"paymentdate" timestamp(6),
"deliverydate" timestamp(6),
"barcode" varchar(20) COLLATE "default",
"department_id" varchar(20) COLLATE "default",
"employee_id" varchar(20) COLLATE "default",
"stock_id" varchar(20) COLLATE "default",
"branch_id" varchar(20) COLLATE "default",
"contract_id" varchar(20) COLLATE "default",
"customer_id" varchar(20) COLLATE "default",
"customername" varchar(255) COLLATE "default",
"customeraddress" varchar(255) COLLATE "default",
"contact" varchar(100) COLLATE "default",
"reason" varchar(255) COLLATE "default",
"payment" int2,
"currency_id" varchar(3) COLLATE "default",
"exchangerate" money,
"vat" int4,
"vatamount" money,
"amount" money,
"famount" money,
"discountdate" timestamp(6),
"discountrate" money,
"discount" money,
"otherdiscount" money,
"charge" money,
"isclose" bool DEFAULT false,
"description" varchar(255) COLLATE "default",
"sorted" int8,
"user_id" varchar(20) COLLATE "default",
"active" bool NOT NULL,
"timestamp" bytea NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_inward
-- ----------------------------

-- ----------------------------
-- Table structure for stock_inward_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_inward_detail";
CREATE TABLE "public"."stock_inward_detail" (
"id" uuid NOT NULL,
"inward_id" varchar(20) COLLATE "default" NOT NULL,
"product_id" varchar(20) COLLATE "default" NOT NULL,
"productname" varchar(255) COLLATE "default",
"reftype" int4,
"stock_id" varchar(20) COLLATE "default",
"unit" varchar(20) COLLATE "default",
"unitconvert" money,
"vat" int4,
"vatamount" money,
"currentqty" money,
"quantity" money,
"unitprice" money,
"amount" money,
"qtyconvert" money,
"discountrate" money,
"discount" money,
"charge" money,
"limit" timestamp(6),
"width" money,
"height" money,
"orgin" varchar(255) COLLATE "default",
"size" varchar(255) COLLATE "default",
"color" varchar(20) COLLATE "default",
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"chassyno" varchar(50) COLLATE "default",
"ime" varchar(50) COLLATE "default",
"storeid" int8,
"description" varchar(255) COLLATE "default",
"sorted" int8 NOT NULL,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_inward_detail
-- ----------------------------

-- ----------------------------
-- Table structure for stock_outward
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_outward";
CREATE TABLE "public"."stock_outward" (
"id" varchar(20) COLLATE "default" NOT NULL,
"refdate" timestamp(6),
"ref_orgno" varchar(20) COLLATE "default",
"reftype" int4,
"refstatus" int4 DEFAULT 0,
"paymentmethod" uuid,
"termid" varchar(20) COLLATE "default",
"paymentdate" timestamp(6),
"deliverydate" timestamp(6),
"barcode" varchar(20) COLLATE "default",
"department_id" varchar(20) COLLATE "default",
"employee_id" varchar(20) COLLATE "default",
"stock_id" varchar(20) COLLATE "default",
"branch_id" varchar(20) COLLATE "default",
"contract_id" varchar(20) COLLATE "default",
"customer_id" varchar(20) COLLATE "default",
"customername" varchar(255) COLLATE "default",
"customeraddress" varchar(255) COLLATE "default",
"contact" varchar(100) COLLATE "default",
"reason" varchar(255) COLLATE "default",
"payment" int2,
"currency_id" varchar(3) COLLATE "default",
"exchangerate" money,
"vat" int4,
"vatamount" money,
"amount" money,
"famount" money,
"discountdate" timestamp(6),
"discountrate" money,
"discount" money,
"otherdiscount" money,
"charge" money,
"cost" money,
"profit" money,
"user_id" varchar(20) COLLATE "default",
"isclose" bool,
"sorted" int8,
"description" varchar(255) COLLATE "default",
"active" bool NOT NULL,
"timestamp" bytea NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_outward
-- ----------------------------

-- ----------------------------
-- Table structure for stock_outward_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_outward_detail";
CREATE TABLE "public"."stock_outward_detail" (
"id" uuid NOT NULL,
"outward_id" varchar(20) COLLATE "default" NOT NULL,
"stock_id" varchar(20) COLLATE "default",
"reftype" int4,
"product_id" varchar(20) COLLATE "default" NOT NULL,
"productname" varchar(255) COLLATE "default",
"vat" int4,
"vatamount" money,
"unit" varchar(20) COLLATE "default",
"unitconvert" money,
"currentqty" money,
"quantity" money,
"unitprice" money,
"amount" money,
"qtyconvert" money,
"discountrate" money,
"discount" money,
"charge" money,
"cost" money,
"profit" money,
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"chassyno" varchar(50) COLLATE "default",
"ime" varchar(50) COLLATE "default",
"width" money,
"height" money,
"orgin" varchar(255) COLLATE "default",
"size" varchar(255) COLLATE "default",
"storeid" int8,
"description" varchar(250) COLLATE "default",
"sorted" int8 NOT NULL,
"active" bool NOT NULL,
"timestamp" bytea NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_outward_detail
-- ----------------------------

-- ----------------------------
-- Table structure for stock_transfer
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_transfer";
CREATE TABLE "public"."stock_transfer" (
"id" varchar(20) COLLATE "default" NOT NULL,
"refdate" timestamp(6),
"ref_orgno" varchar(20) COLLATE "default",
"reftype" int4 DEFAULT 1,
"department_id" varchar(20) COLLATE "default",
"employee_id" varchar(20) COLLATE "default",
"fromstock_id" varchar(20) COLLATE "default",
"sender_id" varchar(20) COLLATE "default",
"tostock_id" varchar(20) COLLATE "default",
"receiver_id" varchar(20) COLLATE "default",
"branch_id" varchar(20) COLLATE "default",
"contract_id" varchar(20) COLLATE "default",
"currency_id" varchar(3) COLLATE "default",
"exchangerate" money,
"barcode" varchar(20) COLLATE "default",
"amount" money,
"isreview" bool,
"user_id" varchar(20) COLLATE "default",
"isclose" bool,
"sorted" int8,
"description" varchar(255) COLLATE "default",
"active" bool NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_transfer
-- ----------------------------

-- ----------------------------
-- Table structure for stock_transfer_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."stock_transfer_detail";
CREATE TABLE "public"."stock_transfer_detail" (
"id" uuid NOT NULL,
"transfer_id" varchar(20) COLLATE "default" NOT NULL,
"reftype" int4,
"product_id" varchar(20) COLLATE "default" NOT NULL,
"product_name" varchar(250) COLLATE "default",
"outstock" varchar(20) COLLATE "default" NOT NULL,
"outstockname" varchar(250) COLLATE "default",
"instock" varchar(20) COLLATE "default" NOT NULL,
"instockname" varchar(250) COLLATE "default",
"unit" varchar(20) COLLATE "default",
"unitconvert" money,
"unitprice" money,
"quantity" money,
"amount" money,
"qtyconvert" money,
"storeid" int8,
"batch" varchar(50) COLLATE "default",
"serial" varchar(50) COLLATE "default",
"description" varchar(255) COLLATE "default",
"sorted" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of stock_transfer_detail
-- ----------------------------

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_company";
CREATE TABLE "public"."sys_company" (
"company_id" varchar(20) COLLATE "default" NOT NULL,
"company" varchar(250) COLLATE "default",
"address" varchar(250) COLLATE "default",
"tel" varchar(50) COLLATE "default",
"fax" varchar(50) COLLATE "default",
"website" varchar(250) COLLATE "default",
"email" varchar(50) COLLATE "default",
"tax" varchar(50) COLLATE "default",
"licence" varchar(50) COLLATE "default",
"photo" bytea
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_company
-- ----------------------------
INSERT INTO "public"."sys_company" VALUES ('NV2L2CtM20c=', 'ryekVCR6vKnD0GnSoNE3aQ==', '* TRIAL * T', '08 00909812', '018989009', '* TRIAL * TR', '* TRIAL * TRIAL * TRIA', '* TRIAL * ', '* TRIAL * ', E'\\000\\000');

-- ----------------------------
-- Table structure for sys_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_group";
CREATE TABLE "public"."sys_group" (
"group_id" varchar(20) COLLATE "default" NOT NULL,
"group_name" varchar(100) COLLATE "default",
"group_nameen" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_group
-- ----------------------------
INSERT INTO "public"."sys_group" VALUES ('admin', '* TRIAL * TRIAL *', 'Quản trị hệ thống', '* TRIAL * TRIAL *', 't');

-- ----------------------------
-- Table structure for sys_group_object
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_group_object";
CREATE TABLE "public"."sys_group_object" (
"object_id" varchar(50) COLLATE "default" NOT NULL,
"goup_id" varchar(20) COLLATE "default" NOT NULL,
"active" char(10) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_group_object
-- ----------------------------

-- ----------------------------
-- Table structure for sys_group_stock
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_group_stock";
CREATE TABLE "public"."sys_group_stock" (
"groupid" varchar(50) COLLATE "default" NOT NULL,
"stockid" varchar(50) COLLATE "default" NOT NULL,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_group_stock
-- ----------------------------

-- ----------------------------
-- Table structure for sys_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_info";
CREATE TABLE "public"."sys_info" (
"sysinfo_id" varchar(10) COLLATE "default" NOT NULL,
"application" varchar(50) COLLATE "default",
"version" varchar(50) COLLATE "default",
"type" int4,
"created" timestamp(6),
"description" varchar(255) COLLATE "default",
"interface" int4,
"guid_id" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_info
-- ----------------------------
INSERT INTO "public"."sys_info" VALUES ('01', 'QLBH', '3.8', '0', '2012-02-21 10:10:10', ' ', '0', 'RYhjrnjcBlI=');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_log";
CREATE TABLE "public"."sys_log" (
"sys_id" int8 DEFAULT nextval('sys_log_sys_id_seq'::regclass) NOT NULL,
"mchine" varchar(200) COLLATE "default",
"ip" varchar(20) COLLATE "default",
"userid" varchar(20) COLLATE "default",
"created" timestamp(6),
"module" varchar(200) COLLATE "default",
"action" int4,
"action_name" varchar(50) COLLATE "default",
"reference" varchar(20) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO "public"."sys_log" VALUES ('86048', '* TRIAL * T', '* TRIAL * T', '* TRIAL ', '2015-09-03 14:58:40.66', 'Hệ Thống', '0', 'Đăng Nhập', '', '* TRIAL * TRIAL * ', 't');
INSERT INTO "public"."sys_log" VALUES ('86049', '* TRIAL * T', 'TRANNHAN-PC', 'US000001', '2015-09-03 14:58:47.757', 'Quản Lý Khách Hàng', '0', 'Xem', '', 'Xem Quản Lý Khách Hàng', 't');
INSERT INTO "public"."sys_log" VALUES ('86050', 'TRANNHAN-PC', 'TRANNHAN-PC', 'US000001', '2015-09-03 14:58:47.98', 'Quản Lý Khách Hàng', '0', 'Xem', '', '* TRIAL * TRIAL * TRIA', 't');
INSERT INTO "public"."sys_log" VALUES ('86051', 'TRANNHAN-PC', 'TRANNHAN-PC', 'US000001', '2015-09-03 14:58:53.12', 'Quản Lý Hàng Hoá', '0', 'Xem', '', 'Xem Quản Lý Hàng Hoá', 't');
INSERT INTO "public"."sys_log" VALUES ('86052', '* TRIAL * T', 'TRANNHAN-PC', 'US000001', '2015-09-03 14:58:57.95', 'Hệ Thống', '0', '* TRIAL ', '', '* TRIAL * TRIAL *', 't');
INSERT INTO "public"."sys_log" VALUES ('86053', 'TRANNHAN-PC', '* TRIAL * T', '* TRIAL ', '2015-09-03 14:58:57.95', 'Hệ Thống', '0', 'Kết Thúc', '', '* TRIAL * TRIAL *', 't');
INSERT INTO "public"."sys_log" VALUES ('86054', 'TRANNHAN-PC', 'TRANNHAN-PC', '* TRIAL ', '2015-09-22 10:40:30.58', 'Hệ Thống', '0', 'Đăng Nhập', '', 'Đăng Nhập Hệ Thống', 't');
INSERT INTO "public"."sys_log" VALUES ('86055', 'TRANNHAN-PC', 'TRANNHAN-PC', 'US000001', '2015-09-22 10:40:44.337', 'Quản Lý Khách Hàng', '0', 'Xem', '', 'Xem Quản Lý Khách Hàng', 't');
INSERT INTO "public"."sys_log" VALUES ('86056', '* TRIAL * T', '* TRIAL * T', 'US000001', '2015-09-22 10:40:44.66', 'Quản Lý Khách Hàng', '0', 'Xem', '', 'Xem Quản Lý Khách Hàng', 't');
INSERT INTO "public"."sys_log" VALUES ('86057', '* TRIAL * T', 'TRANNHAN-PC', 'US000001', '2015-09-22 10:40:48.627', 'Hệ Thống', '0', 'Kết Thúc', '', '* TRIAL * TRIAL *', 't');
INSERT INTO "public"."sys_log" VALUES ('86058', '* TRIAL * T', 'TRANNHAN-PC', 'US000001', '2015-09-22 10:40:48.627', 'Hệ Thống', '0', 'Kết Thúc', '', '* TRIAL * TRIAL *', 't');

-- ----------------------------
-- Table structure for sys_object
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_object";
CREATE TABLE "public"."sys_object" (
"id" uuid NOT NULL,
"object_id" varchar(50) COLLATE "default" NOT NULL,
"object_name" varchar(50) COLLATE "default",
"object_nameen" varchar(50) COLLATE "default",
"description" varchar(255) COLLATE "default",
"parent_id" varchar(20) COLLATE "default",
"level" int4,
"order_id" int4,
"owner" varchar(50) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_object
-- ----------------------------
INSERT INTO "public"."sys_object" VALUES ('07957401-146a-4879-a08a-59837bb702d7', 'rbpgPartner', 'Đối Tác', 'Partner', '', 'rbpDictionary', '1', '6', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('0bfdc0db-89d9-4d35-ac08-5c523c63e6fb', 'rbpgDicStock', 'Kho Hàng', 'Stock', '', 'rbpDictionary', '1', '7', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('0cff005d-6516-45f0-82ad-988f84931ae9', 'bbiTransfer', 'Chuyển Kho', 'Transfer', '', 'rbpgStockOther', '2', '46', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('0eceafd8-4067-471d-b388-387b20f3a25b', '* TRIAL * ', 'Xuất Kho', 'Outward', '', 'rbpgInventory', '2', '42', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('11e97c29-939b-4809-bc59-66d2d313269d', 'bbiSaleReturn', 'Xuất trả hàng', '* TRIAL * ', '', 'rbpgSale', '2', '56', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('122dff15-c518-4d13-a6eb-ffb24157dfc2', 'rbpgStockOther', 'Tiện ích', 'Utilities', '', 'rbpStock', '1', '12', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('124fbfad-b27d-41e1-8b56-4ea55515daa9', 'bbiRestore', 'Phục Hồi', 'Restore', '', 'rbpgDatabase', '2', '21', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('1abe3533-504f-471e-b015-f7d00ef9d392', 'bbiSysLog', 'Nhật Ký Hệ Thống', 'SysLog', '', '* TRIAL * TR', '2', '19', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('1e609ffc-8a66-44f8-9b01-b2c4e43cf352', 'bbiPrintBarcode', 'In Mã Vạch', 'PrintBarcode', '', 'rbpgDicStock', '2', '33', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('1fdeaa53-e193-406e-ac4e-ad69531850df', '* TRIAL * TRIAL *', 'Đổi Mật Khẩu', 'Changepassword', '', '* TRIAL * TR', '2', '18', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('2bf23d30-9bdc-435e-b1e2-2ac3fa16cb88', 'bbiStock', 'Kho', 'Stock', '', 'rbpgDicStock', '2', '29', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('326c091d-27d8-408e-a9dd-0c9374b48601', '* TRIAL ', 'Bán Hàng', 'Sale', '', 'rbpStock', '1', '9', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('369d8989-2c45-4e22-ae02-bc5ba6b24937', 'bbiInventorySummary', 'Tổng Hợp Tồn Kho', 'InventorySummary', '', 'rbpgStockOther', '2', '47', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('37a2038c-973d-4598-a6a4-e4270433ba1f', 'bbiMaterial', '* TRIAL ', 'Material', '', 'rbpgDicStock', '2', '32', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('391473df-78fd-484c-b6aa-37355414556c', 'bbiReportSale', 'Doanh Thu Bán Hàng', 'ReportSale', '', 'rpgReport', '2', '51', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('3de3193f-b607-452f-ac25-e6b8ca371829', '* TRIAL * ', 'Hoá Đơn', 'Invoice', '', 'rbpStock', '1', '13', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('3efd80d7-3d70-4d09-bfac-5ab88f5051e5', 'bbiFix', 'Sửa Chữa', 'Fix', '', 'rbpgDatabase', '2', '22', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('4506625e-186f-4820-abcc-672036ded9d6', 'bbiPurchaseReturn', '* TRIAL * TRI', 'PurchaseReturn', '', '* TRIAL ', '2', '57', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('45f63217-a739-41a1-86e7-f26000f9503a', 'bbiDepartment', 'Bộ Phận', 'Department', '', 'rpgDeparment', '2', '35', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('48c047da-ba2d-45e8-b91a-3d481d1a6c5b', '* TRIAL * TR', 'Nhóm Hàng', '* TRIAL *', '', '* TRIAL * TR', '2', '31', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('50760ad2-eb65-475a-8c45-4c193b9faaac', '* TRIAL *', 'Hạn Sử Dụng', 'Expire', '', 'rpgReport', '2', '52', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('53895501-c76d-461b-ac84-351160cd93c1', 'bbiAdjustment', 'Kiểm Kê', 'Adjustment', '', 'rbpgStockOther', '2', '45', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('5405ab60-9c28-4756-9880-ca6a6eb7a3e3', 'rbpDictionary', 'Danh Mục', 'Dictionary', '', '', '0', '1', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('58172443-92db-4fa1-af21-8f5ae89dd087', 'bbiSale', 'Bán Hàng', 'Sale', '', 'rbpgSale', '2', '38', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('6075d2e4-0bbd-40a9-9671-a1e8c7404de7', 'rbpSystem', 'Hệ Thống', 'System', '', '', '0', '0', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('645add70-e138-4fb1-86ba-e41a9e83db05', '* TRIAL ', 'Chức Năng', 'Stock', '', '', '0', '2', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('6a9d3a0b-cf91-4b5f-a577-e440873436b1', '* TRIAL * TRIAL ', 'Nhập Số Dư Ban Đầu', 'InitInventory', '', 'rpgTool', '2', '54', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('7145ac4b-9084-41f8-9fd6-dcaddf060a5c', '* TRIAL * TRIAL ', 'Khu Vực', 'CustomerGroup', '', '* TRIAL * T', '2', '26', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('71a6ca2c-b7b5-4319-8e58-7ee0ffc1feeb', 'rpgDeparment', 'Bộ Phận', 'Department', '', '* TRIAL * TRI', '1', '8', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('7964d843-7c76-436f-9d79-fbe6b991bfee', 'rbpgInventory', 'Kho Hàng', '* TRIAL *', '', '* TRIAL ', '1', '11', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('8c43b50f-8cac-4684-941d-c7dccd447496', 'bbiUser', 'Quản Lý Người Dùng', 'User', '', 'bbiPermission', '3', '24', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('94138cd3-21f7-4658-a516-97ec3010f7fe', '* TRIAL * TRIAL *', 'Đặt Hàng', '* TRIAL * TRIA', '', 'rpgTool', '2', '53', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('97930834-7385-4131-b1d6-13e89a94b48e', 'bbiEmployee', '* TRIAL *', 'Employee', '', '* TRIAL * TR', '2', '36', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('9bae914c-96b6-4b0a-acf6-484a2f1ae7b2', 'bbiUserRule', 'Vai Trò & Quyền Hạn', 'UserRule', '', '* TRIAL * TRI', '3', '25', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('9cc1babb-c33f-45ee-9d18-382aabdf498d', '* TRIAL *', 'Đóng Gói', 'Packet', '', 'rbpgStockOther', '2', '44', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('a297c145-3c87-4eb9-a9d2-e727bf727ff7', 'bbiReciept', 'Thu Tiền', 'Reciept', '', 'rpgDebt', '2', '39', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('a2eeefac-3f6e-43dc-b6ee-93454f8c59b4', 'bbiInventory', 'Tồn Kho', 'Inventory', '', 'rbpgInventory', '2', '43', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('a3bd8110-71d8-4c34-8dfa-3a2699e9d261', 'bbiCompanyInfo', 'Đơn Vị', '* TRIAL * T', '', 'rbpgClose', '2', '16', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('aa7e6096-4f80-40a7-a912-9b26ebc2851b', '* TRIAL * TR', 'Dữ Liệu', '* TRIAL ', '', '* TRIAL *', '1', '5', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('b2a51fbf-7e4f-4f36-a363-d3129c634c53', 'rpgTool', 'Công Cụ', 'Tool', '', '* TRIAL ', '1', '15', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('bbf47518-ef69-4c32-bed8-3b5032c137de', 'bbiLock', 'Kết Chuyễn', 'Lock', '', 'rbpgDatabase', '2', '23', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('bd45cd66-ae98-4fe1-87b2-caae2d67722c', 'bbiCustomer', 'Khách Hàng', 'Customer', '', '* TRIAL * T', '2', '27', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('ca2fed16-65e6-4d61-9fd4-c489f3a8e6a8', '* TRIAL * TR', 'Bảo Mật', '* TRIAL ', '', '* TRIAL *', '1', '4', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('d444edc3-d736-4395-846b-70f4a8c955ff', 'bbiUnitConvert', 'Quy đổi đơn vị', 'UnitConvert', '', 'rbpgDicStock', '2', '58', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('d54f21de-a188-4ca0-982a-898f35f2cecd', 'bbiPermission', '* TRIAL * TRIAL * ', 'Permission', '', 'rbpgSecurity', '2', '17', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('d98665d9-c8e1-4106-bb2a-34b357f291b1', 'bbiReport', '* TRIAL * T', 'Report', '', 'rpgReport', '2', '50', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('e56990a9-bb4c-41de-8923-086e96dbfeae', 'rpgReport', 'Báo Cáo', 'Report', '', 'rbpStock', '1', '14', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('e8709294-c7b4-4b56-b4c2-9b5d15dab980', 'bbiBackup', 'Sao Lưu', 'Backup', '', 'rbpgDatabase', '2', '20', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('e8c31caa-d79b-43d8-91ab-5fb3faed6f9b', 'bbiPurchase', 'Mua Hàng', 'Purchase', '', 'rbpgSale', '2', '37', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('efa7aef5-4c3f-4904-9ad8-e05d9e73ce5b', 'bbiInward', '* TRIAL ', 'Inward', '', 'rbpgInventory', '2', '41', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('efc3fd96-22b8-48fe-bc09-e0569876ac2f', 'bbiExchangeRate', 'Tỷ Giá', '* TRIAL * TR', '', '* TRIAL * TR', '2', '34', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('f02f230c-ff5a-481f-bbfd-a0cb68429edd', 'bbiHistory', '* TRIAL * TRIAL ', 'History', '', 'rpgTool', '2', '55', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('f0bdcbe6-3512-473a-b2db-94634c9682c9', 'bbiInvoice', 'Hoá Đơn', 'Invoice', '', 'rpgInvoice', '2', '48', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('f8a341cc-506e-4d9b-9a21-d4b9176fec5f', 'rbpgClose', 'Hệ Thống', 'System', '', 'rbpSystem', '1', '3', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('f92b1be2-efa6-4d59-a155-44b760f7f2f8', 'bbiPayment', 'Trả Tiền', 'Payment', '', 'rpgDebt', '2', '40', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('fa9deacf-d397-444e-8bee-393d1d6b8857', 'rpgDebt', 'Công Nợ', 'Debt', '', 'rbpStock', '1', '10', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('fdd06ebc-427a-4c28-a1ae-03b0e15964e6', 'bbiUnit', 'Đơn Vị', 'Unit', '', 'rbpgDicStock', '2', '30', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('fdff62dd-645d-4090-a8de-0f452e86e758', 'bbiVoucherManager', 'Quản Lý Chứng Từ', 'VoucherManager', '', 'rpgInvoice', '2', '49', 'QLKBH', 't');
INSERT INTO "public"."sys_object" VALUES ('ff1103df-b69c-40ef-bea9-2f73ef0bc41b', 'bbiProvider', 'Nhà Phân Phối', '* TRIAL ', '', 'rbpgPartner', '2', '28', 'QLKBH', 't');

-- ----------------------------
-- Table structure for sys_option
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_option";
CREATE TABLE "public"."sys_option" (
"option_id" varchar(50) COLLATE "default" NOT NULL,
"optionvalue" varchar(100) COLLATE "default",
"valuetype" int4,
"system" bool,
"description" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_option
-- ----------------------------
INSERT INTO "public"."sys_option" VALUES ('Batch', '0', '0', 't', 'Phân lô');
INSERT INTO "public"."sys_option" VALUES ('CostMethod', '0', '0', 't', '* TRIAL * TRIAL * TRIAL ');
INSERT INTO "public"."sys_option" VALUES ('Currency', 'VND', '3', 't', 'Loai Tien');
INSERT INTO "public"."sys_option" VALUES ('Deleted', '0', '0', 't', 'Co xoa that su ko');
INSERT INTO "public"."sys_option" VALUES ('Exchange', '17000', '0', 't', 'Ty Gia');
INSERT INTO "public"."sys_option" VALUES ('Language_Id', 'EN', '3', 't', 'Ngôn ngữ');
INSERT INTO "public"."sys_option" VALUES ('Limit', '0', '0', 't', 'Hạn sử dụng');
INSERT INTO "public"."sys_option" VALUES ('LimitStored', '30', '1', 't', 'Giới hạn cảnh báo HSD');
INSERT INTO "public"."sys_option" VALUES ('Negative', '1', '0', 't', 'Xuất kho âm');
INSERT INTO "public"."sys_option" VALUES ('OldStored', '90', '1', 't', '* TRIAL * TRIAL * TR');
INSERT INTO "public"."sys_option" VALUES ('PacketCalculator', '1', '0', 't', 'Tính lại giá trị đóng gói');
INSERT INTO "public"."sys_option" VALUES ('Round', '2', '1', 't', 'Gioi Han Lam Tron So');
INSERT INTO "public"."sys_option" VALUES ('ViHoa', '1', '0', 't', '* TRIAL * TR');

-- ----------------------------
-- Table structure for sys_rule
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_rule";
CREATE TABLE "public"."sys_rule" (
"rule_id" varchar(20) COLLATE "default" NOT NULL,
"rule_name" varchar(100) COLLATE "default",
"rule_nameen" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_rule
-- ----------------------------
INSERT INTO "public"."sys_rule" VALUES ('add', 'Thêm', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('all', 'Tất cả', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('delete', 'Xoá', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('edit', 'Sửa', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('export', '* TRIAL *', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('find', 'Tìm kiếm', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('import', '* TRIAL *', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('post', 'Gửi', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('print', 'In', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('report', 'Báo cáo', null, ' ', 't');
INSERT INTO "public"."sys_rule" VALUES ('view', 'Xem', null, '', 't');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
"userid" varchar(20) COLLATE "default" NOT NULL,
"username" varchar(50) COLLATE "default" NOT NULL,
"password" varchar(50) COLLATE "default",
"group_id" varchar(20) COLLATE "default" NOT NULL,
"description" varchar(255) COLLATE "default",
"partid" varchar(20) COLLATE "default",
"active" bool DEFAULT false NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES ('US000001', 'admin', '7CC3AC058E8DA6754769EDF8A11734F8', 'admin', '', '', 't');

-- ----------------------------
-- Table structure for sys_user_rule
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_rule";
CREATE TABLE "public"."sys_user_rule" (
"goup_id" varchar(20) COLLATE "default" NOT NULL,
"object_id" varchar(50) COLLATE "default" NOT NULL,
"rule_id" varchar(20) COLLATE "default" NOT NULL,
"allowadd" bool DEFAULT true,
"allowdelete" bool DEFAULT true,
"allowedit" bool DEFAULT true,
"allowaccess" bool DEFAULT true,
"allowprint" bool DEFAULT true,
"allowexport" bool DEFAULT true,
"allowimport" bool DEFAULT true,
"active" bool DEFAULT true NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user_rule
-- ----------------------------
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiAdjustment', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiBackup', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiChangepassword', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiCompanyInfo', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiCustomer', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiCustomerGroup', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiDepartment', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiEmployee', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiExchangeRate', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiExpire', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiFix', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiHistory', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiInitInventory', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiInventory', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiInventoryOrder', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiInventorySummary', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiInvoice', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiInward', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiItemGroup', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiLock', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiMaterial', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiOutward', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiPacket', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiPayment', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiPermission', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiPrintBarcode', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiProvider', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiPurchase', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiPurchaseReturn', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiReciept', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiReport', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiReportSale', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiRestore', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiSale', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiSaleReturn', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiStock', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiSysLog', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiTransfer', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiUnit', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiUnitConvert', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiUser', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiUserRule', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'bbiVoucherManager', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpDictionary', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgClose', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgDatabase', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgDicStock', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgInventory', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgPartner', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgSale', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgSecurity', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpgStockOther', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpStock', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rbpSystem', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rpgDebt', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rpgDeparment', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rpgInvoice', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rpgReport', 'view', 't', 't', 't', 't', 't', 't', 't', 't');
INSERT INTO "public"."sys_user_rule" VALUES ('admin', 'rpgTool', 'view', 't', 't', 't', 't', 't', 't', 't', 't');

-- ----------------------------
-- Table structure for sys_user_stock
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_stock";
CREATE TABLE "public"."sys_user_stock" (
"userid" varchar(50) COLLATE "default" NOT NULL,
"stockid" varchar(50) COLLATE "default" NOT NULL,
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user_stock
-- ----------------------------

-- ----------------------------
-- Table structure for sysdiagrams
-- ----------------------------
DROP TABLE IF EXISTS "public"."sysdiagrams";
CREATE TABLE "public"."sysdiagrams" (
"name" varchar(128) COLLATE "default" NOT NULL,
"principal_id" int4 NOT NULL,
"diagram_id" int4 DEFAULT nextval('sysdiagrams_diagram_id_seq'::regclass) NOT NULL,
"version" int4,
"definition" bytea
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sysdiagrams
-- ----------------------------
INSERT INTO "public"."sysdiagrams" VALUES ('Diagram_0', '1', '17', '1', E'\\320\\317\\021\\340\\241\\261\\032\\341\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000>\\000\\003\\000\\376\\377\\011\\000\\006\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\001\\000\\000\\000\\000\\000\\000\\000\\000\\020\\000\\000\\002\\000\\000\\000\\001\\000\\000\\000\\376\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\375\\377\\377\\377\\010\\000\\000\\000\\376\\377\\377\\377\\004\\000\\000\\000\\005\\000\\000\\000\\006\\000\\000\\000\\007\\000\\000\\000\\011\\000\\000\\000\\376\\377\\377\\377\\012\\000\\000\\000\\013\\000\\000\\000\\014\\000\\000\\000\\376\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377R\\000o\\000o\\000t\\000 \\000E\\000n\\000t\\000r\\000y\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\026\\000\\005\\000\\377\\377\\377\\377\\377\\377\\377\\377\\002\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\340Z<\\254\\207\\353\\313\\001\\003\\000\\000\\000\\300\\021\\000\\000\\000\\000\\000\\000f\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\004\\000\\002\\001\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000&\\002\\000\\000\\000\\000\\000\\000o\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\004\\000\\002\\001\\001\\000\\000\\000\\004\\000\\000\\000\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\011\\000\\000\\000-\\006\\000\\000\\000\\000\\000\\000\\001\\000C\\000o\\000m\\000p\\000O\\000b\\000j\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\022\\000\\002\\001\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000"\\000\\000\\000_\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\002\\000\\000\\000\\003\\000\\000\\000\\004\\000\\000\\000\\005\\000\\000\\000\\006\\000\\000\\000\\007\\000\\000\\000\\010\\000\\000\\000\\376\\377\\377\\377\\012\\000\\000\\000\\013\\000\\000\\000\\014\\000\\000\\000\\015\\000\\000\\000\\016\\000\\000\\000\\017\\000\\000\\000\\020\\000\\000\\000\\021\\000\\000\\000\\022\\000\\000\\000\\023\\000\\000\\000\\024\\000\\000\\000\\025\\000\\000\\000\\026\\000\\000\\000\\027\\000\\000\\000\\030\\000\\000\\000\\031\\000\\000\\000\\032\\000\\000\\000\\033\\000\\000\\000\\034\\000\\000\\000\\035\\000\\000\\000\\036\\000\\000\\000\\037\\000\\000\\000 \\000\\000\\000!\\000\\000\\000\\376\\377\\377\\377#\\000\\000\\000\\376\\377\\377\\377%\\000\\000\\000&\\000\\000\\000''\\000\\000\\000(\\000\\000\\000)\\000\\000\\000*\\000\\000\\000+\\000\\000\\000,\\000\\000\\000-\\000\\000\\000.\\000\\000\\000/\\000\\000\\0000\\000\\000\\0001\\000\\000\\0002\\000\\000\\0003\\000\\000\\0004\\000\\000\\0005\\000\\000\\0006\\000\\000\\0007\\000\\000\\0008\\000\\000\\0009\\000\\000\\000\\376\\377\\377\\377\\376\\377\\377\\377<\\000\\000\\000=\\000\\000\\000>\\000\\000\\000?\\000\\000\\000@\\000\\000\\000A\\000\\000\\000B\\000\\000\\000C\\000\\000\\000D\\000\\000\\000E\\000\\000\\000\\376\\377\\377\\377\\376\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\000\\004(\\000\\012\\016\\020\\014\\005\\000\\000\\200\\004\\000\\000\\000\\017\\000\\377\\377\\004\\000\\000\\000\\000}\\000\\000\\006W\\000\\0004P\\000\\000.a\\000\\000\\344q\\000\\000\\336\\200[\\020\\361\\225\\320\\021\\260\\240\\000\\252\\000\\275\\313\\\\\\000\\000\\010\\0000\\000\\000\\000\\000\\002\\000\\000\\003\\000\\000\\0008\\000+\\000\\000\\000\\011\\000\\000\\000\\331\\346\\260\\351\\034\\201\\320\\021\\255Q\\000\\240\\311\\017W9\\364;\\177\\204\\177a\\307C\\2055)\\206\\341\\325R\\370\\2402}\\262\\330b\\225B\\215\\230''<%\\242\\332-\\000\\000,\\000C \\000\\000\\000\\000\\000\\000\\000\\000\\000\\000SDM\\322\\001\\037\\321\\021\\216c\\000`\\227\\322\\337H4\\311\\322wyw\\330\\021\\220p\\000\\006[\\204\\015\\234\\000\\000,\\000C \\000\\000\\000\\000\\000\\000\\000\\000\\000\\000QDM\\322\\001\\037\\321\\021\\216c\\000`\\227\\322\\337H4\\311\\322wyw\\330\\021\\220p\\000\\006[\\204\\015\\234\\004\\000\\000\\0008\\001\\000\\000\\000\\204\\001\\000\\000\\0004\\000\\245\\011\\000\\000\\007\\000\\000\\200\\001\\000\\000\\000\\252\\002\\000\\000\\000\\200\\000\\000\\014\\000\\000\\200SchGrid\\221\\\\+\\000\\000,\\001\\000\\000SALE_INVOICE\\000\\000<\\000\\245\\011\\000\\000\\007\\000\\000\\200\\002\\000\\000\\000\\270\\002\\000\\000\\000\\200\\000\\000\\023\\000\\000\\200SchGrid\\221\\236\\007\\000\\000F\\005\\000\\000SALE_INVOICE_DETAIL\\000\\000\\000\\214\\000\\245\\011\\000\\000\\007\\000\\000\\200\\003\\000\\000\\000R\\000\\000\\000\\001\\200\\000\\000c\\000\\000\\200Control\\221\\220\\034\\000\\000\\267\\012\\000\\000Relationship ''FK_SALE_INVOICE_DETAIL_SALE_INVOICE'' between ''SALE_INVOICE'' and ''SALE_INVOICE_DETAIL''\\000\\000\\000(\\000\\265\\001\\000\\000\\007\\000\\000\\200\\004\\000\\000\\0001\\000\\000\\000y\\000\\000\\000\\002\\200\\000\\000Control\\221\\306\\030\\000\\000G\\012\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000!C4\\022\\010\\000\\000\\000\\025\\025\\000\\000\\324J\\000\\000xV4\\022\\007\\000\\000\\000\\024\\001\\000\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000\\000\\000\\271wa!\\271w\\000\\000\\000\\000\\001\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\240\\367\\367\\012\\010\\327\\324\\010\\314\\361iw\\000\\000/\\000\\000\\000\\000\\000\\250\\367\\367\\012@\\327\\324\\010\\346\\241\\335f\\000\\000/\\000\\000\\000\\000\\000\\002\\242\\335f\\236\\020m\\365\\320\\327\\324\\010\\001\\000\\000\\000\\000\\000\\000\\000\\377\\377\\377\\377\\233\\235\\335f|\\327\\324\\010\\224A*g\\002\\000\\000\\000\\000\\000\\000\\000\\350\\000\\000\\000\\000\\000/\\000\\210\\327\\324\\010\\274\\240\\335f\\000\\000/\\000\\000\\000\\000\\000\\333\\240\\335fV\\020m\\365\\030\\330\\324\\010\\001\\000\\000\\000\\000\\000\\000\\000\\220\\327\\324\\010\\201\\304\\335f\\000\\000\\305\\010\\304\\327\\324\\010DA*g\\377\\377\\377\\377\\333\\240\\335f:\\241\\335f\\000\\000/\\000\\000\\000\\000\\000\\340\\000\\000\\000\\320\\327\\324\\010\\226\\362\\335f\\000(\\244\\010\\263\\362\\335f\\016\\020\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\005\\000\\000\\000T\\000\\000\\000,\\000\\000\\000,\\000\\000\\000,\\000\\000\\0004\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\226$\\000\\000\\336 \\000\\000\\000\\000\\000\\000-\\001\\000\\000\\015\\000\\000\\000\\014\\000\\000\\000\\007\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000T\\006\\000\\000\\320\\002\\000\\000\\204\\003\\000\\000v\\002\\000\\0008\\004\\000\\000F\\005\\000\\000*\\003\\000\\000F\\005\\000\\000\\256\\006\\000\\000\\222\\004\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\025\\025\\000\\000\\324J\\000\\000\\000\\000\\000\\000 \\000\\000\\000\\014\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\034\\001\\000\\000\\253\\011\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\307\\021\\000\\000\\377\\005\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\001\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000\\001\\000\\000\\000\\000\\000\\000\\000\\307\\021\\000\\000\\355\\003\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\007,\\000\\000\\336 \\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\015\\000\\000\\000\\004\\000\\000\\000\\004\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000$\\011\\000\\000\\240\\005\\000\\000xV4\\022\\004\\000\\000\\000b\\000\\000\\000\\001\\000\\000\\000\\001\\000\\000\\000\\013\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\002\\000\\000\\000\\003\\000\\000\\000\\004\\000\\000\\000\\005\\000\\000\\000\\006\\000\\000\\000\\007\\000\\000\\000\\010\\000\\000\\000\\011\\000\\000\\000\\012\\000\\000\\000\\004\\000\\000\\000d\\000b\\000o\\000\\000\\000\\015\\000\\000\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000\\000\\000!C4\\022\\010\\000\\000\\000\\036\\026\\000\\000@\\035\\000\\000xV4\\022\\007\\000\\000\\000\\024\\001\\000\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000_\\000D\\000E\\000T\\000A\\000I\\000L\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\005\\000\\000\\000T\\000\\000\\000,\\000\\000\\000,\\000\\000\\000,\\000\\000\\0004\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\226$\\000\\000\\336 \\000\\000\\000\\000\\000\\000-\\001\\000\\000\\015\\000\\000\\000\\014\\000\\000\\000\\007\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000T\\006\\000\\000\\320\\002\\000\\000\\204\\003\\000\\000v\\002\\000\\0008\\004\\000\\000F\\005\\000\\000*\\003\\000\\000F\\005\\000\\000\\256\\006\\000\\000\\222\\004\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\036\\026\\000\\000@\\035\\000\\000\\000\\000\\000\\000\\013\\000\\000\\000\\013\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\034\\001\\000\\000A\\012\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\307\\021\\000\\000\\020\\010\\000\\000\\000\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000\\001\\000\\000\\000\\000\\000\\000\\000\\307\\021\\000\\000\\355\\003\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\007,\\000\\000\\336 \\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\015\\000\\000\\000\\004\\000\\000\\000\\004\\000\\000\\000\\034\\001\\000\\000\\274\\007\\000\\000$\\011\\000\\000\\240\\005\\000\\000xV4\\022\\004\\000\\000\\000p\\000\\000\\000\\001\\000\\000\\000\\001\\000\\000\\000\\013\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\002\\000\\000\\000\\003\\000\\000\\000\\004\\000\\000\\000\\005\\000\\000\\000\\006\\000\\000\\000\\007\\000\\000\\000\\010\\000\\000\\000\\011\\000\\000\\000\\012\\000\\000\\000\\004\\000\\000\\000d\\000b\\000o\\000\\000\\000\\024\\000\\000\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000_\\000D\\000E\\000T\\000A\\000I\\000L\\000\\000\\000\\002\\000\\013\\000\\\\+\\000\\000N\\014\\000\\000\\274\\035\\000\\000N\\014\\000\\000\\000\\000\\000\\000\\002\\000\\000\\000\\360\\360\\360\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\004\\000\\000\\000\\000\\000\\000\\000\\306\\030\\000\\000G\\012\\000\\000\\213\\027\\000\\000X\\001\\000\\0002\\000\\000\\000\\001\\000\\000\\002\\000\\000\\213\\027\\000\\000X\\001\\000\\000\\002\\000\\000\\000\\000\\000\\377\\377\\377\\000\\010\\000\\000\\200\\001\\000\\000\\000\\025\\000\\001\\000\\000\\000\\220\\001DB\\001\\000\\006Tahoma#\\000F\\000K\\000_\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000_\\000D\\000E\\000T\\000A\\000I\\000L\\000_\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\376\\377\\003\\012\\000\\000\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\027\\000\\000\\000Microsoft DDS Form 2.0\\000\\020\\000\\000\\000Embedded Object\\000\\000\\000\\000\\000\\3649\\262q\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\014\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000&\\000\\000\\000s\\000c\\000h\\000_\\000l\\000a\\000b\\000e\\000l\\000s\\000_\\000v\\000i\\000s\\000i\\000b\\000l\\000e\\000\\000\\000\\001\\000\\000\\000\\013\\000\\000\\000\\036\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000d\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\000\\000\\001\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\320\\002\\000\\000\\006\\000(\\000\\000\\000A\\000c\\000t\\000i\\000v\\000e\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000\\000\\000\\001\\000\\000\\000\\010\\000\\004\\000\\000\\0001\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0000\\000\\000\\000\\001\\000\\000\\000\\010\\000:\\000\\000\\0004\\000,\\0000\\000,\\0002\\0008\\000\\003\\000D\\000d\\000s\\000S\\000t\\000r\\000e\\000a\\000m\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\026\\000\\002\\000\\003\\000\\000\\000\\006\\000\\000\\000\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000$\\000\\000\\000C\\005\\000\\000\\000\\000\\000\\000S\\000c\\000h\\000e\\000m\\000a\\000 \\000U\\000D\\000V\\000 \\000D\\000e\\000f\\000a\\000u\\000l\\000t\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000&\\000\\002\\000\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000:\\000\\000\\000\\026\\000\\000\\000\\000\\000\\000\\000D\\000S\\000R\\000E\\000F\\000-\\000S\\000C\\000H\\000E\\000M\\000A\\000-\\000C\\000O\\000N\\000T\\000E\\000N\\000T\\000S\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000,\\000\\002\\001\\005\\000\\000\\000\\007\\000\\000\\000\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000;\\000\\000\\000\\244\\002\\000\\000\\000\\000\\000\\000S\\000c\\000h\\000e\\000m\\000a\\000 \\000U\\000D\\000V\\000 \\000D\\000e\\000f\\000a\\000u\\000l\\000t\\000 \\000P\\000o\\000s\\000t\\000 \\000V\\0006\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\0006\\000\\002\\000\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\377\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000F\\000\\000\\000\\022\\000\\000\\000\\000\\000\\000\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000,\\0001\\000,\\0001\\0006\\0002\\0000\\000,\\0005\\000,\\0001\\0000\\0008\\0000\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0001\\000\\000\\000\\001\\000\\000\\000\\010\\000\\036\\000\\000\\0002\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0002\\0004\\0007\\0005\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0002\\000\\000\\000\\001\\000\\000\\000\\010\\000\\036\\000\\000\\0002\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0003\\000\\000\\000\\001\\000\\000\\000\\010\\000\\036\\000\\000\\0002\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0004\\000\\000\\000\\001\\000\\000\\000\\010\\000>\\000\\000\\0004\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000,\\0001\\0002\\000,\\0002\\0003\\0004\\0000\\000,\\0001\\0001\\000,\\0001\\0004\\0004\\0000\\000\\000\\000\\002\\000\\000\\000\\002\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\320\\002\\000\\000\\006\\000(\\000\\000\\000A\\000c\\000t\\000i\\000v\\000e\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000\\000\\000\\001\\000\\000\\000\\010\\000\\004\\000\\000\\0001\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0000\\000\\000\\000\\001\\000\\000\\000\\010\\000:\\000\\000\\0004\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000,\\0001\\000,\\0001\\0006\\0002\\0000\\000,\\0005\\000,\\0001\\0000\\0008\\0000\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0001\\000\\000\\000\\001\\000\\000\\000\\010\\000\\036\\000\\000\\0002\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0002\\0006\\0002\\0005\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0002\\000\\000\\000\\001\\000\\000\\000\\010\\000\\036\\000\\000\\0002\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0003\\000\\000\\000\\001\\000\\000\\000\\010\\000\\036\\000\\000\\0002\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000\\000\\000 \\000\\000\\000T\\000a\\000b\\000l\\000e\\000V\\000i\\000e\\000w\\000M\\000o\\000d\\000e\\000:\\0004\\000\\000\\000\\001\\000\\000\\000\\010\\000>\\000\\000\\0004\\000,\\0000\\000,\\0002\\0008\\0004\\000,\\0000\\000,\\0001\\0009\\0008\\0000\\000,\\0001\\0002\\000,\\0002\\0003\\0004\\0000\\000,\\0001\\0001\\000,\\0001\\0004\\0004\\0000\\000\\000\\000\\003\\000\\000\\000\\003\\000\\000\\000\\000\\000\\000\\000X\\000\\000\\000\\001\\003\\000\\000\\001\\000\\000\\000d\\000b\\000o\\000\\000\\000F\\000K\\000_\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000_\\000D\\000E\\000T\\000A\\000I\\000L\\000_\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\304\\002\\000\\000\\000\\000\\004\\000\\000\\000\\004\\000\\000\\000\\003\\000\\000\\000\\010\\000\\000\\000\\001\\000\\000\\000\\250\\253\\357\\012\\000\\000\\000\\000\\000\\000\\000\\000\\255\\017\\000\\000\\001\\000\\000\\005\\000\\000\\000\\003\\000\\000\\000\\001\\000\\000\\000\\002\\000\\000\\000j\\000\\000\\000a\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\003\\000\\000\\000\\000\\000\\000\\000\\014\\000\\000\\000\\013\\000\\000\\000Na\\274\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\333\\346\\260\\351\\034\\201\\320\\021\\255Q\\000\\240\\311\\017W9\\000\\000\\002\\000@\\3625\\254\\207\\353\\313\\001\\002\\002\\000\\000\\020HE\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000~\\001\\000\\000D\\000a\\000t\\000a\\000 \\000S\\000o\\000u\\000r\\000c\\000e\\000=\\000.\\000\\\\\\000S\\000Q\\000L\\000E\\000X\\000P\\000R\\000E\\000S\\000S\\000;\\000I\\000n\\000i\\000t\\000i\\000a\\000l\\000 \\000C\\000a\\000t\\000a\\000l\\000o\\000g\\000=\\000H\\000O\\000N\\000G\\000P\\000H\\000U\\000O\\000N\\000G\\000;\\000I\\000n\\000t\\000e\\000g\\000r\\000a\\000t\\000e\\000d\\000 \\000S\\000e\\000c\\000u\\000r\\000i\\000t\\000y\\000=\\000T\\000r\\000u\\000e\\000;\\000M\\000u\\000l\\000t\\000i\\000p\\000l\\000e\\000A\\000c\\000t\\000i\\000v\\000e\\000R\\000e\\000s\\000u\\000l\\000t\\000S\\000e\\000t\\000s\\000=\\000F\\000a\\000l\\000s\\000e\\000;\\000P\\000a\\000c\\000k\\000e\\000t\\000 \\000S\\000i\\000z\\000e\\000=\\0004\\0000\\0009\\0006\\000;\\000A\\000p\\000p\\000l\\000i\\000c\\000a\\000t\\000i\\000o\\000n\\000 \\000N\\000a\\000m\\000e\\000=\\000"\\000M\\000i\\000c\\000r\\000o\\000s\\000o\\000f\\000t\\000 \\000S\\000Q\\000L\\000 \\000S\\000e\\000r\\000v\\000e\\000r\\000 \\000M\\000a\\000n\\000a\\000g\\000e\\000m\\000e\\000n\\000t\\000 \\000S\\000t\\000u\\000d\\000i\\000o\\000 \\000E\\000x\\000p\\000r\\000e\\000s\\000s\\000"\\000\\000\\000\\000\\200\\005\\000\\024\\000\\000\\000D\\000i\\000a\\000g\\000r\\000a\\000m\\000_\\0000\\000\\000\\000\\000\\002&\\000\\032\\000\\000\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000\\000\\000\\010\\000\\000\\000d\\000b\\000o\\000\\000\\000\\000\\002$\\000(\\000\\000\\000S\\000A\\000L\\000E\\000_\\000I\\000N\\000V\\000O\\000I\\000C\\000E\\000_\\000D\\000E\\000T\\000A\\000I\\000L\\000\\000\\000\\010\\000\\000\\000d\\000b\\000o\\000\\000\\000\\001\\000\\000\\000\\326\\205\\011\\263\\273k\\362E\\232\\2707\\026d\\3602p\\010\\000N\\000\\000\\000{\\0009\\0001\\0005\\0001\\0000\\0006\\0000\\0008\\000-\\0008\\0008\\0000\\0009\\000-\\0004\\0000\\0002\\0000\\000-\\0008\\0008\\0009\\0007\\000-\\000F\\000B\\000A\\0000\\0005\\0007\\000E\\0002\\0002\\000D\\0005\\0004\\000}\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\001\\000\\003\\000\\000\\000\\000\\000\\000\\000\\014\\000\\000\\000\\013\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000b\\210R\\024');

-- ----------------------------
-- Table structure for trans_cash
-- ----------------------------
DROP TABLE IF EXISTS "public"."trans_cash";
CREATE TABLE "public"."trans_cash" (
"id" uuid NOT NULL,
"bookid" varchar(20) COLLATE "default",
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"refno" uuid,
"reforgno" uuid NOT NULL,
"reftype" int2,
"refstatus" int2,
"customerid" varchar(20) COLLATE "default",
"paymentmethod" uuid,
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"amount" money,
"balance" money,
"famount" money,
"fbalance" money,
"description" varchar(255) COLLATE "default",
"sorted" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of trans_cash
-- ----------------------------

-- ----------------------------
-- Table structure for trans_debt
-- ----------------------------
DROP TABLE IF EXISTS "public"."trans_debt";
CREATE TABLE "public"."trans_debt" (
"id" uuid NOT NULL,
"bookid" varchar(20) COLLATE "default",
"refid" varchar(20) COLLATE "default",
"refdate" timestamp(6),
"refdetailno" uuid,
"refno" uuid NOT NULL,
"reforgno" uuid NOT NULL,
"reftype" int2,
"refstatus" int2,
"customerid" varchar(20) COLLATE "default",
"currencyid" varchar(3) COLLATE "default",
"exchangerate" money,
"isdebt" bool DEFAULT true,
"amount" money,
"discount" money,
"payment" money,
"balance" money,
"famount" money,
"fdiscount" money,
"fpayment" money,
"fbalance" money,
"debit" money DEFAULT 0,
"description" varchar(255) COLLATE "default",
"sorted" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of trans_debt
-- ----------------------------

-- ----------------------------
-- Table structure for trans_ref
-- ----------------------------
DROP TABLE IF EXISTS "public"."trans_ref";
CREATE TABLE "public"."trans_ref" (
"id" uuid NOT NULL,
"refid" varchar(20) COLLATE "default",
"reforgno" varchar(20) COLLATE "default",
"reftype" int4,
"refdate" timestamp(6),
"transfrom" varchar(20) COLLATE "default",
"transto" varchar(50) COLLATE "default",
"department_id" varchar(50) COLLATE "default",
"employee_id" varchar(50) COLLATE "default",
"stock_id" varchar(50) COLLATE "default",
"branch_id" varchar(50) COLLATE "default",
"contract_id" varchar(50) COLLATE "default",
"contract" varchar(200) COLLATE "default",
"reason" varchar(255) COLLATE "default",
"currency_id" varchar(3) COLLATE "default",
"exchangerate" money,
"amount" money,
"discount" money,
"famount" money,
"fdiscount" money,
"isclose" bool DEFAULT false,
"sorted" int8,
"description" varchar(255) COLLATE "default",
"user_id" varchar(20) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of trans_ref
-- ----------------------------

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS "public"."unit";
CREATE TABLE "public"."unit" (
"unit_id" varchar(20) COLLATE "default" NOT NULL,
"unit_name" varchar(250) COLLATE "default",
"description" varchar(250) COLLATE "default",
"active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of unit
-- ----------------------------

-- ----------------------------
-- Table structure for unitconvert
-- ----------------------------
DROP TABLE IF EXISTS "public"."unitconvert";
CREATE TABLE "public"."unitconvert" (
"id" varchar(255) COLLATE "default" NOT NULL,
"productid" varchar(20) COLLATE "default" NOT NULL,
"unitprime" varchar(20) COLLATE "default" NOT NULL,
"unitconvert" varchar(20) COLLATE "default" NOT NULL,
"convertrate" money,
"formation" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of unitconvert
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."inventory_ledger_id_seq" OWNED BY "inventory_ledger"."id";
ALTER SEQUENCE "public"."sys_log_sys_id_seq" OWNED BY "sys_log"."sys_id";
ALTER SEQUENCE "public"."sysdiagrams_diagram_id_seq" OWNED BY "sysdiagrams"."diagram_id";

-- ----------------------------
-- Primary Key structure for table adjustment
-- ----------------------------
ALTER TABLE "public"."adjustment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table adjustment_detail
-- ----------------------------
ALTER TABLE "public"."adjustment_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cash
-- ----------------------------
ALTER TABLE "public"."cash" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cash_item
-- ----------------------------
ALTER TABLE "public"."cash_item" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cash_item_class
-- ----------------------------
ALTER TABLE "public"."cash_item_class" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cash_method
-- ----------------------------
ALTER TABLE "public"."cash_method" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cash_payment
-- ----------------------------
ALTER TABLE "public"."cash_payment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cash_receipt
-- ----------------------------
ALTER TABLE "public"."cash_receipt" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cash_term
-- ----------------------------
ALTER TABLE "public"."cash_term" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table city
-- ----------------------------
ALTER TABLE "public"."city" ADD PRIMARY KEY ("province_id");

-- ----------------------------
-- Primary Key structure for table code
-- ----------------------------
ALTER TABLE "public"."code" ADD PRIMARY KEY ("soft_id");

-- ----------------------------
-- Primary Key structure for table company
-- ----------------------------
ALTER TABLE "public"."company" ADD PRIMARY KEY ("companyid");

-- ----------------------------
-- Primary Key structure for table currency
-- ----------------------------
ALTER TABLE "public"."currency" ADD PRIMARY KEY ("currency_id");

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "public"."customer" ADD PRIMARY KEY ("customer_id");

-- ----------------------------
-- Primary Key structure for table customer_debt
-- ----------------------------
ALTER TABLE "public"."customer_debt" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table customer_group
-- ----------------------------
ALTER TABLE "public"."customer_group" ADD PRIMARY KEY ("customer_group_id");

-- ----------------------------
-- Primary Key structure for table customer_receipt
-- ----------------------------
ALTER TABLE "public"."customer_receipt" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table customer_receipt_detail
-- ----------------------------
ALTER TABLE "public"."customer_receipt_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table customer_type
-- ----------------------------
ALTER TABLE "public"."customer_type" ADD PRIMARY KEY ("customer_type_id");

-- ----------------------------
-- Primary Key structure for table debt
-- ----------------------------
ALTER TABLE "public"."debt" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table department
-- ----------------------------
ALTER TABLE "public"."department" ADD PRIMARY KEY ("department_id");

-- ----------------------------
-- Primary Key structure for table employee
-- ----------------------------
ALTER TABLE "public"."employee" ADD PRIMARY KEY ("employee_id");

-- ----------------------------
-- Primary Key structure for table form
-- ----------------------------
ALTER TABLE "public"."form" ADD PRIMARY KEY ("form_id");

-- ----------------------------
-- Primary Key structure for table inventory
-- ----------------------------
ALTER TABLE "public"."inventory" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table inventory_action
-- ----------------------------
ALTER TABLE "public"."inventory_action" ADD PRIMARY KEY ("action_id");

-- ----------------------------
-- Primary Key structure for table inventory_book
-- ----------------------------
ALTER TABLE "public"."inventory_book" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table inventory_detail
-- ----------------------------
ALTER TABLE "public"."inventory_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table keycode
-- ----------------------------
ALTER TABLE "public"."keycode" ADD PRIMARY KEY ("id_key");

-- ----------------------------
-- Primary Key structure for table license
-- ----------------------------
ALTER TABLE "public"."license" ADD PRIMARY KEY ("id_license");

-- ----------------------------
-- Primary Key structure for table module
-- ----------------------------
ALTER TABLE "public"."module" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table payment_group
-- ----------------------------
ALTER TABLE "public"."payment_group" ADD PRIMARY KEY ("payment_group_id");

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD PRIMARY KEY ("product_id");

-- ----------------------------
-- Primary Key structure for table product_build
-- ----------------------------
ALTER TABLE "public"."product_build" ADD PRIMARY KEY ("productid", "buildid");

-- ----------------------------
-- Primary Key structure for table product_group
-- ----------------------------
ALTER TABLE "public"."product_group" ADD PRIMARY KEY ("productgroup_id");

-- ----------------------------
-- Primary Key structure for table product_price
-- ----------------------------
ALTER TABLE "public"."product_price" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table product_type
-- ----------------------------
ALTER TABLE "public"."product_type" ADD PRIMARY KEY ("product_type_id");

-- ----------------------------
-- Primary Key structure for table product_unit
-- ----------------------------
ALTER TABLE "public"."product_unit" ADD PRIMARY KEY ("product_id", "unit_id", "unitconvert_id");

-- ----------------------------
-- Primary Key structure for table provider
-- ----------------------------
ALTER TABLE "public"."provider" ADD PRIMARY KEY ("customer_id");

-- ----------------------------
-- Primary Key structure for table provider_debt
-- ----------------------------
ALTER TABLE "public"."provider_debt" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table provider_payment
-- ----------------------------
ALTER TABLE "public"."provider_payment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table provider_payment_detail
-- ----------------------------
ALTER TABLE "public"."provider_payment_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table receipt
-- ----------------------------
ALTER TABLE "public"."receipt" ADD PRIMARY KEY ("receipt_id");

-- ----------------------------
-- Primary Key structure for table receipt_group
-- ----------------------------
ALTER TABLE "public"."receipt_group" ADD PRIMARY KEY ("receipt_group_id");

-- ----------------------------
-- Primary Key structure for table reftype
-- ----------------------------
ALTER TABLE "public"."reftype" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table report
-- ----------------------------
ALTER TABLE "public"."report" ADD PRIMARY KEY ("report_id");

-- ----------------------------
-- Primary Key structure for table report_group
-- ----------------------------
ALTER TABLE "public"."report_group" ADD PRIMARY KEY ("report_group_id");

-- ----------------------------
-- Primary Key structure for table sale_order
-- ----------------------------
ALTER TABLE "public"."sale_order" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sale_order_detail
-- ----------------------------
ALTER TABLE "public"."sale_order_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table soft
-- ----------------------------
ALTER TABLE "public"."soft" ADD PRIMARY KEY ("id_soft");

-- ----------------------------
-- Primary Key structure for table stock
-- ----------------------------
ALTER TABLE "public"."stock" ADD PRIMARY KEY ("stock_id");

-- ----------------------------
-- Primary Key structure for table stock_build
-- ----------------------------
ALTER TABLE "public"."stock_build" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_inward
-- ----------------------------
ALTER TABLE "public"."stock_inward" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_inward_detail
-- ----------------------------
ALTER TABLE "public"."stock_inward_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_outward
-- ----------------------------
ALTER TABLE "public"."stock_outward" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_outward_detail
-- ----------------------------
ALTER TABLE "public"."stock_outward_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_transfer
-- ----------------------------
ALTER TABLE "public"."stock_transfer" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table stock_transfer_detail
-- ----------------------------
ALTER TABLE "public"."stock_transfer_detail" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_company
-- ----------------------------
ALTER TABLE "public"."sys_company" ADD PRIMARY KEY ("company_id");

-- ----------------------------
-- Primary Key structure for table sys_group
-- ----------------------------
ALTER TABLE "public"."sys_group" ADD PRIMARY KEY ("group_id");

-- ----------------------------
-- Primary Key structure for table sys_group_object
-- ----------------------------
ALTER TABLE "public"."sys_group_object" ADD PRIMARY KEY ("object_id", "goup_id");

-- ----------------------------
-- Primary Key structure for table sys_group_stock
-- ----------------------------
ALTER TABLE "public"."sys_group_stock" ADD PRIMARY KEY ("groupid", "stockid");

-- ----------------------------
-- Primary Key structure for table sys_info
-- ----------------------------
ALTER TABLE "public"."sys_info" ADD PRIMARY KEY ("sysinfo_id");

-- ----------------------------
-- Primary Key structure for table sys_log
-- ----------------------------
ALTER TABLE "public"."sys_log" ADD PRIMARY KEY ("sys_id");

-- ----------------------------
-- Primary Key structure for table sys_object
-- ----------------------------
ALTER TABLE "public"."sys_object" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_option
-- ----------------------------
ALTER TABLE "public"."sys_option" ADD PRIMARY KEY ("option_id");

-- ----------------------------
-- Primary Key structure for table sys_rule
-- ----------------------------
ALTER TABLE "public"."sys_rule" ADD PRIMARY KEY ("rule_id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD PRIMARY KEY ("userid");

-- ----------------------------
-- Primary Key structure for table sys_user_rule
-- ----------------------------
ALTER TABLE "public"."sys_user_rule" ADD PRIMARY KEY ("goup_id", "object_id");

-- ----------------------------
-- Primary Key structure for table sys_user_stock
-- ----------------------------
ALTER TABLE "public"."sys_user_stock" ADD PRIMARY KEY ("userid", "stockid");

-- ----------------------------
-- Indexes structure for table sysdiagrams
-- ----------------------------
CREATE UNIQUE INDEX "uk_principal_name" ON "public"."sysdiagrams" USING btree ("principal_id", "name");

-- ----------------------------
-- Primary Key structure for table sysdiagrams
-- ----------------------------
ALTER TABLE "public"."sysdiagrams" ADD PRIMARY KEY ("diagram_id");

-- ----------------------------
-- Primary Key structure for table trans_cash
-- ----------------------------
ALTER TABLE "public"."trans_cash" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table trans_debt
-- ----------------------------
ALTER TABLE "public"."trans_debt" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table trans_ref
-- ----------------------------
ALTER TABLE "public"."trans_ref" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table unit
-- ----------------------------
ALTER TABLE "public"."unit" ADD PRIMARY KEY ("unit_id");

-- ----------------------------
-- Primary Key structure for table unitconvert
-- ----------------------------
ALTER TABLE "public"."unitconvert" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."adjustment_detail"
-- ----------------------------
ALTER TABLE "public"."adjustment_detail" ADD FOREIGN KEY ("adjustment_id") REFERENCES "public"."adjustment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."adjustment_detail" ADD FOREIGN KEY ("product_id") REFERENCES "public"."product" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."customer_receipt_detail"
-- ----------------------------
ALTER TABLE "public"."customer_receipt_detail" ADD FOREIGN KEY ("receiptid") REFERENCES "public"."customer_receipt" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."inventory_detail"
-- ----------------------------
ALTER TABLE "public"."inventory_detail" ADD FOREIGN KEY ("stock_id") REFERENCES "public"."stock" ("stock_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."inventory_detail" ADD FOREIGN KEY ("storeid") REFERENCES "public"."inventory" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."inventory_detail" ADD FOREIGN KEY ("product_id") REFERENCES "public"."product" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."product_unit"
-- ----------------------------
ALTER TABLE "public"."product_unit" ADD FOREIGN KEY ("unit_id") REFERENCES "public"."unit" ("unit_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."provider_payment_detail"
-- ----------------------------
ALTER TABLE "public"."provider_payment_detail" ADD FOREIGN KEY ("paymentid") REFERENCES "public"."provider_payment" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."stock_inward_detail"
-- ----------------------------
ALTER TABLE "public"."stock_inward_detail" ADD FOREIGN KEY ("inward_id") REFERENCES "public"."stock_inward" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."stock_inward_detail" ADD FOREIGN KEY ("product_id") REFERENCES "public"."product" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."stock_outward_detail"
-- ----------------------------
ALTER TABLE "public"."stock_outward_detail" ADD FOREIGN KEY ("outward_id") REFERENCES "public"."stock_outward" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."stock_outward_detail" ADD FOREIGN KEY ("product_id") REFERENCES "public"."product" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."stock_transfer_detail"
-- ----------------------------
ALTER TABLE "public"."stock_transfer_detail" ADD FOREIGN KEY ("transfer_id") REFERENCES "public"."stock_transfer" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."stock_transfer_detail" ADD FOREIGN KEY ("product_id") REFERENCES "public"."product" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."sys_group_object"
-- ----------------------------
ALTER TABLE "public"."sys_group_object" ADD FOREIGN KEY ("goup_id") REFERENCES "public"."sys_group" ("group_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."sys_user"
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD FOREIGN KEY ("group_id") REFERENCES "public"."sys_group" ("group_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."sys_user_rule"
-- ----------------------------
ALTER TABLE "public"."sys_user_rule" ADD FOREIGN KEY ("rule_id") REFERENCES "public"."sys_rule" ("rule_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."sys_user_rule" ADD FOREIGN KEY ("goup_id") REFERENCES "public"."sys_group" ("group_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
