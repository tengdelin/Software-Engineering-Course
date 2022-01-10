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

 Date: 13/06/2021 17:36:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wuhan_project
-- ----------------------------
DROP TABLE IF EXISTS `wuhan_project`;
CREATE TABLE `wuhan_project`  (
  `fid` int(10) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CityName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Polygon` geometry NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
