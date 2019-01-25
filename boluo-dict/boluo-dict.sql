/*
Navicat MySQL Data Transfer

Source Server         : test_254
Source Server Version : 50722
Source Host           : 192.168.0.254:3306
Source Database       : boluo-dict

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-01-25 16:35:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for boluo_dict
-- ----------------------------
DROP TABLE IF EXISTS `boluo_dict`;
CREATE TABLE `boluo_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(30) NOT NULL COMMENT '字典编码',
  `dict_desc` varchar(200) NOT NULL COMMENT '字典类型描述',
  `remark` varchar(500) DEFAULT NULL,
  `is_enabel` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_dict_code` (`dict_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boluo_dict
-- ----------------------------
INSERT INTO `boluo_dict` VALUES ('1', 'offline_classroom', '线下教室', '线下教室', '0', '2018-12-26 18:04:03', '2019-01-18 14:47:53');
INSERT INTO `boluo_dict` VALUES ('2', '4321', '123123', '', '1', '2019-01-17 19:38:45', '2019-01-23 19:17:31');
INSERT INTO `boluo_dict` VALUES ('3', '1234', '12345', '', '1', '2019-01-17 19:43:21', '2019-01-23 19:13:18');
INSERT INTO `boluo_dict` VALUES ('4', '12345', '12345', '', '1', '2019-01-17 19:47:54', null);
INSERT INTO `boluo_dict` VALUES ('5', '123456', '123456', '', '1', '2019-01-17 19:50:21', null);
INSERT INTO `boluo_dict` VALUES ('6', '1234567', '1234567', '', '1', '2019-01-17 19:50:58', null);
INSERT INTO `boluo_dict` VALUES ('8', '321321', '321321', '', '1', '2019-01-18 17:49:54', '2019-01-23 19:04:43');
INSERT INTO `boluo_dict` VALUES ('9', '1230', '1235', '', '1', '2019-01-18 19:19:46', null);
INSERT INTO `boluo_dict` VALUES ('10', '1239', '1234', '', '1', '2019-01-19 15:19:48', '2019-01-23 19:04:29');
INSERT INTO `boluo_dict` VALUES ('11', '2345', '2345', '', '1', '2019-01-19 16:06:20', null);
INSERT INTO `boluo_dict` VALUES ('12', '123478', '123456', '', '1', '2019-01-21 18:20:16', null);
INSERT INTO `boluo_dict` VALUES ('13', '12345678', '123345', '12', '1', '2019-01-21 18:23:33', null);
INSERT INTO `boluo_dict` VALUES ('14', '765432', '1234556', '123', '1', '2019-01-22 15:05:15', '2019-01-22 15:05:29');
INSERT INTO `boluo_dict` VALUES ('15', 'relationship', '关系', null, '1', '2019-01-23 16:19:13', '2019-01-23 16:19:15');

-- ----------------------------
-- Table structure for boluo_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `boluo_dict_item`;
CREATE TABLE `boluo_dict_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(30) NOT NULL,
  `dictItem_code` varchar(30) NOT NULL,
  `dictItem_desc` varchar(30) NOT NULL,
  `sort` int(2) NOT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `is_enabel` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `busi_code` varchar(200) DEFAULT NULL COMMENT '业务编码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_dict_item` (`dict_code`,`dictItem_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boluo_dict_item
-- ----------------------------
INSERT INTO `boluo_dict_item` VALUES ('1', 'offline_classroom', '2501', '2501', '1', null, '1', '2019-01-11 16:19:06', null, null);
INSERT INTO `boluo_dict_item` VALUES ('2', 'offline_classroom', '2502', '2502', '2', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('3', 'offline_classroom', '2503', '2503', '3', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('4', 'offline_classroom', '2504', '2504', '4', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('5', 'offline_classroom', '2505', '2504', '5', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('6', 'offline_classroom', 'zwq1', '12345', '1', '1234', '0', '2019-01-18 17:47:49', null, null);
INSERT INTO `boluo_dict_item` VALUES ('7', 'offline_classroom', 'zzz', 'zzzz', '1', 'zwq', '0', '2019-01-18 17:52:00', null, null);
INSERT INTO `boluo_dict_item` VALUES ('8', 'offline_classroom', 'zzz1', 'zzzz', '2', '123', '0', '2019-01-18 17:52:26', null, null);
INSERT INTO `boluo_dict_item` VALUES ('9', 'offline_classroom', '123', '12312', '1', '123', '0', '2019-01-18 17:57:32', null, null);
INSERT INTO `boluo_dict_item` VALUES ('10', '4321', '1234', '1234', '1', '1', '1', '2019-01-21 14:01:13', '2019-01-22 13:56:59', '');
INSERT INTO `boluo_dict_item` VALUES ('11', '765432', '098765', '12345', '123', '123', '1', '2019-01-22 15:06:55', null, null);
INSERT INTO `boluo_dict_item` VALUES ('12', 'relationship', '1', '父亲', '1', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('13', 'relationship', '2', '母亲', '2', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('14', 'relationship', '3', '爷爷', '3', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('15', 'relationship', '4', '奶奶', '4', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('16', 'relationship', '5', '叔叔', '5', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('17', 'relationship', '6', '阿姨', '6', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('18', 'relationship', '7', '其他', '7', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);

-- ----------------------------
-- Table structure for sms_send_log
-- ----------------------------
DROP TABLE IF EXISTS `sms_send_log`;
CREATE TABLE `sms_send_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(20) NOT NULL COMMENT '手机号',
  `template_code` varchar(500) NOT NULL COMMENT '短信模板',
  `param` varchar(500) NOT NULL COMMENT '参数',
  `create_by` int(20) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '请求时间',
  `bizId` varchar(100) DEFAULT NULL,
  `receive_code` varchar(200) DEFAULT NULL,
  `exception_msg` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_send_log
-- ----------------------------
INSERT INTO `sms_send_log` VALUES ('1', '13524943121', 'SMS_143867530', '{\"password\":\"123\",\"salePhone\":\"13524943121\",\"surname\":\"王\",\"userId\":\"SDST20191001427\",\"startDate\":\"2019-01-24 20:00:00\"}', null, '2019-01-23 11:34:45', null, 'Exception', null);
INSERT INTO `sms_send_log` VALUES ('2', '13524943121', 'SMS_143867530', '{\"password\":\"123\",\"salePhone\":\"13524943121\",\"surname\":\"王\",\"userId\":\"SDST20191001427\",\"startDate\":\"2019-01-24 20:00:00\"}', null, '2019-01-23 11:43:13', null, null, 'Exception=null');
INSERT INTO `sms_send_log` VALUES ('3', '13524943121', 'SMS_143867530', '{\"password\":\"123\",\"salePhone\":\"13524943121\",\"surname\":\"王\",\"userId\":\"SDST20191001427\",\"startDate\":\"2019-01-24 20:00:00\"}', null, '2019-01-23 11:45:20', null, null, 'Exception=null');
INSERT INTO `sms_send_log` VALUES ('4', '13524943121', 'SMS_143867530', '{\"password\":\"123\",\"salePhone\":\"13524943121\",\"surname\":\"王\",\"userId\":\"SDST20191001427\",\"startDate\":\"2019-01-24 20:00:00\"}', null, '2019-01-23 11:49:00', null, null, 'Exception=null');
INSERT INTO `sms_send_log` VALUES ('5', '13524943121', 'SMS_143867530', '{\"password\":\"123\",\"salePhone\":\"13524943121\",\"surname\":\"王\",\"userId\":\"SDST20191001427\",\"startDate\":\"2019-01-24 20:00:00\"}', null, '2019-01-23 11:50:41', null, null, 'Exception=null');
INSERT INTO `sms_send_log` VALUES ('6', '13524943121', 'SMS_143867530', '{\"password\":\"123\",\"salePhone\":\"13524943121\",\"surname\":\"王\",\"userId\":\"SDST20191001427\",\"startDate\":\"2019-01-24 20:00:00\"}', '2', '2019-01-23 12:01:18', '376721348216078502^0', 'OK', null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_name` varchar(50) NOT NULL,
  `module` varchar(200) NOT NULL,
  `class_name` varchar(100) NOT NULL,
  `method` varchar(200) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_account` varchar(50) DEFAULT NULL,
  `request_param` varchar(1000) DEFAULT NULL,
  `request_ip` varchar(100) NOT NULL,
  `commit` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sequence
-- ----------------------------
DROP TABLE IF EXISTS `sys_sequence`;
CREATE TABLE `sys_sequence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seq_name` varchar(50) NOT NULL,
  `curr_value` int(255) NOT NULL,
  `increse_value` int(11) NOT NULL,
  `loop_frequency` int(3) NOT NULL COMMENT '循环周期，1每天，30每月，365，每年',
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_seq_name` (`seq_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='公共的序列表，用于为非自增且要求唯一的字段记录和获取唯一ID';

-- ----------------------------
-- Records of sys_sequence
-- ----------------------------
INSERT INTO `sys_sequence` VALUES ('1', 'ditch_code', '23', '1', '30', null);

-- ----------------------------
-- Function structure for fnc_nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `fnc_nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `fnc_nextval`(p_seq_name VARCHAR(50)) RETURNS int(11)
BEGIN

DECLARE v_curr_value INT;

UPDATE sys_sequence
SET curr_value = curr_value + increse_value
WHERE
	seq_name = p_seq_name;

SELECT
	curr_value INTO v_curr_value
FROM
	sys_sequence
WHERE
	seq_name = p_seq_name;

RETURN v_curr_value;


END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for fnc_setval
-- ----------------------------
DROP FUNCTION IF EXISTS `fnc_setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `fnc_setval`(p_seq_name varchar(50),p_value int) RETURNS int(11)
begin
 update sys_sequence
 set curr_value = p_value,modify_time=now()
 where seq_name = p_seq_name;
 return p_value;
end
;;
DELIMITER ;
