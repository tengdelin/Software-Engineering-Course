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

 Date: 13/06/2021 17:36:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_SEX` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_BIRTHDAY` datetime NOT NULL,
  `USER_IDENITY_CODE` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_EMAIL` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_STATUS` decimal(6, 0) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
