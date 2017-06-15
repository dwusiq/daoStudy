/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-06-15 18:02:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student_exam_info`
-- ----------------------------
DROP TABLE IF EXISTS `student_exam_info`;
CREATE TABLE `student_exam_info` (
  `studentId` int(10) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名',
  `studentClass` varchar(30) NOT NULL DEFAULT '' COMMENT '学生班别',
  `studentScore` int(20) NOT NULL DEFAULT '0' COMMENT '学生成绩',
  `subjectsName` varchar(50) NOT NULL COMMENT '考试科目',
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_exam_info
-- ----------------------------
INSERT INTO `student_exam_info` VALUES ('1', 'hg', ' g', '44', '   g');
INSERT INTO `student_exam_info` VALUES ('2', 'hg', ' g', '44', '   g');
INSERT INTO `student_exam_info` VALUES ('3', '大牛', '牛二班', '82', '  吃草');
INSERT INTO `student_exam_info` VALUES ('4', '??', '??', '53', '  ??');
INSERT INTO `student_exam_info` VALUES ('5', '狗子', '大狗二班', '88', ' 四腿跑');
