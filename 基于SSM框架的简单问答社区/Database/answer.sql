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

 Date: 14/07/2020 22:02:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `answer_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '回答编号',
  `answer_user_id` int(0) UNSIGNED NOT NULL COMMENT '回答的回答者用户编号（关联用户表）',
  `answer_question_id` int(0) UNSIGNED NOT NULL COMMENT '回答所对应的问题编号（关联问题表）',
  `answer_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回答内容',
  `answer_view_count` int(0) NULL DEFAULT 0 COMMENT '回答浏览量',
  `answer_agree_count` int(0) NULL DEFAULT 0 COMMENT '回答赞同量',
  `answer_update_time` datetime(6) NULL DEFAULT NULL COMMENT '回答更新时间',
  `answer_create_time` datetime(6) NULL DEFAULT NULL COMMENT '回答创建时间',
  `answer_status` int(0) NULL DEFAULT 1 COMMENT '回答状态',
  PRIMARY KEY (`answer_id`) USING BTREE,
  INDEX `a_au_id`(`answer_user_id`) USING BTREE,
  INDEX `a_aq_id`(`answer_question_id`) USING BTREE,
  CONSTRAINT `a_aq_id` FOREIGN KEY (`answer_question_id`) REFERENCES `question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `a_au_id` FOREIGN KEY (`answer_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
