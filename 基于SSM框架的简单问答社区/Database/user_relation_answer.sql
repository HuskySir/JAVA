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

 Date: 14/07/2020 22:04:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_relation_answer
-- ----------------------------
DROP TABLE IF EXISTS `user_relation_answer`;
CREATE TABLE `user_relation_answer`  (
  `from_user_id` int(0) UNSIGNED NOT NULL COMMENT '发起用户编号',
  `to_answer_id` int(0) UNSIGNED NOT NULL COMMENT '赞同回答编号',
  INDEX `u_fu_id`(`from_user_id`) USING BTREE,
  INDEX `u_ta_id`(`to_answer_id`) USING BTREE,
  CONSTRAINT `u_fu_id` FOREIGN KEY (`from_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_ta_id` FOREIGN KEY (`to_answer_id`) REFERENCES `answer` (`answer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
