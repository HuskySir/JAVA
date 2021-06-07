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

 Date: 14/07/2020 22:03:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '问题编号',
  `question_user_id` int(0) UNSIGNED NOT NULL COMMENT '问题的提问者用户编号（关联用户表）',
  `question_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题标题',
  `question_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '问题内容',
  `question_view_count` int(0) NULL DEFAULT 0 COMMENT '问题浏览量',
  `question_follow_count` int(0) NULL DEFAULT 0 COMMENT '问题关注量',
  `question_answer_count` int(0) NULL DEFAULT 0 COMMENT '问题回答量',
  `question_update_time` datetime(6) NULL DEFAULT NULL COMMENT '问题更新时间',
  `question_create_time` datetime(6) NULL DEFAULT NULL COMMENT '问题创建时间',
  `question_status` int(0) NOT NULL DEFAULT 1 COMMENT '问题状态',
  PRIMARY KEY (`question_id`) USING BTREE,
  INDEX `q_qu_id`(`question_user_id`) USING BTREE,
  CONSTRAINT `q_qu_id` FOREIGN KEY (`question_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
