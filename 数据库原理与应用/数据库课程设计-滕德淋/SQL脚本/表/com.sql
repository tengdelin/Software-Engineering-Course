/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : dbxml

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 13/06/2021 17:34:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for com
-- ----------------------------
DROP TABLE IF EXISTS `com`;
CREATE TABLE `com`  (
  `fid` bigint(255) NOT NULL AUTO_INCREMENT,
  `commend` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_fid` bigint(255) NULL DEFAULT NULL,
  `house_fid` bigint(255) NOT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
