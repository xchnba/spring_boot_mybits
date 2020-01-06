/*
 Navicat Premium Data Transfer

 Source Server         : bendilianji
 Source Server Type    : MySQL
 Source Server Version : 50132
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50132
 File Encoding         : 65001

 Date: 07/01/2020 00:01:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shares
-- ----------------------------
DROP TABLE IF EXISTS `shares`;
CREATE TABLE `shares`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `gpdate` date DEFAULT NULL COMMENT '股票日期',
  `gpdm` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '股票代码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '股票名称',
  `spj` double(255, 0) DEFAULT NULL COMMENT '收盘价',
  `zgj` double(255, 0) DEFAULT NULL COMMENT '最高价',
  `zdj` double(255, 0) DEFAULT NULL COMMENT '最低价',
  `kpj` double(255, 0) DEFAULT NULL COMMENT '开盘价',
  `qspj` double(255, 0) DEFAULT NULL COMMENT '前收盘价',
  `pjj` double(255, 0) DEFAULT NULL COMMENT '平均价',
  `zde` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '涨跌额',
  `zdf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '涨跌幅',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
