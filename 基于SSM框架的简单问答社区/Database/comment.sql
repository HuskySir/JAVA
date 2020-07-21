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

 Date: 14/07/2020 22:03:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `comment_user_id` int(0) UNSIGNED NOT NULL COMMENT '评论的评论者用户编号（关联用户表）',
  `comment_answer_id` int(0) UNSIGNED NOT NULL COMMENT '评论所对应的回答编号（关联回答表）',
  `comment_last_id` int(0) NULL DEFAULT NULL COMMENT '评论上一条回复编号（关联评论表）',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `comment_time` datetime(6) NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `c_cu_id`(`comment_user_id`) USING BTREE,
  INDEX `c_ca_id`(`comment_answer_id`) USING BTREE,
  CONSTRAINT `c_ca_id` FOREIGN KEY (`comment_answer_id`) REFERENCES `answer` (`answer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `c_cu_id` FOREIGN KEY (`comment_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
