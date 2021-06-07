/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : questionplatform

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 14/07/2020 22:04:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_relation_user
-- ----------------------------
DROP TABLE IF EXISTS `user_relation_user`;
CREATE TABLE `user_relation_user`  (
  `from_user_id` int(0) UNSIGNED NOT NULL COMMENT '发起用户编号',
  `to_user_id` int(0) UNSIGNED NOT NULL COMMENT '关注用户编号',
  INDEX `uru_fu_id`(`from_user_id`) USING BTREE,
  INDEX `uru_tu_id`(`to_user_id`) USING BTREE,
  CONSTRAINT `uru_fu_id` FOREIGN KEY (`from_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uru_tu_id` FOREIGN KEY (`to_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
