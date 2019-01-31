/*
Navicat MySQL Data Transfer

Source Server         : test_254
Source Server Version : 50722
Source Host           : 192.168.0.254:3306
Source Database       : boluo-dict

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-01-31 18:52:55
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
INSERT INTO `boluo_dict` VALUES ('2', 'list_type', '名单类型', '名单类型', '1', '2019-01-17 19:38:45', '2019-01-23 19:17:31');
INSERT INTO `boluo_dict` VALUES ('3', 'list_level', '名单等级', '名单等级', '1', '2019-01-17 19:43:21', '2019-01-23 19:13:18');
INSERT INTO `boluo_dict` VALUES ('4', 'sale_status', '名单销售状态', '名单销售状态', '1', '2019-01-17 19:47:54', '2019-01-17 19:47:54');
INSERT INTO `boluo_dict` VALUES ('5', 'loop_frequency', '序列循环周期', '', '1', '2019-01-17 19:50:21', '2019-01-30 19:25:49');
INSERT INTO `boluo_dict` VALUES ('6', 'sys_name', '系统名称', '', '1', '2019-01-17 19:50:58', '2019-01-30 19:51:12');
INSERT INTO `boluo_dict` VALUES ('8', 'is_enabel', '数据状态', '', '1', '2019-01-18 17:49:54', '2019-01-31 16:57:47');
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boluo_dict_item
-- ----------------------------
INSERT INTO `boluo_dict_item` VALUES ('1', 'offline_classroom', '2501', '2501', '1', null, '1', '2019-01-11 16:19:06', null, null);
INSERT INTO `boluo_dict_item` VALUES ('2', 'offline_classroom', '2502', '2502', '2', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('3', 'offline_classroom', '2503', '2503', '3', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('4', 'offline_classroom', '2504', '2504', '4', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('5', 'offline_classroom', '2505', '2504', '5', '', '1', '2019-01-11 16:19:06', '2019-01-11 16:19:42', null);
INSERT INTO `boluo_dict_item` VALUES ('6', 'list_type', '0', '名单', '1', '名单', '0', '2019-01-18 17:47:49', null, null);
INSERT INTO `boluo_dict_item` VALUES ('7', 'list_type', '1', '线索', '2', '线索', '0', '2019-01-18 17:52:00', null, null);
INSERT INTO `boluo_dict_item` VALUES ('8', 'list_type', '2', '运营', '3', '运营', '0', '2019-01-18 17:52:26', null, null);
INSERT INTO `boluo_dict_item` VALUES ('9', 'list_type', '3', '精推', '4', '精推', '0', '2019-01-18 17:57:32', null, null);
INSERT INTO `boluo_dict_item` VALUES ('10', 'list_level', 'S', 'S级', '1', 'S级', '1', '2019-01-21 14:01:13', '2019-01-22 13:56:59', '');
INSERT INTO `boluo_dict_item` VALUES ('11', 'list_level', 'A', 'A级', '2', 'A级', '1', '2019-01-22 15:06:55', '2019-01-22 15:06:55', null);
INSERT INTO `boluo_dict_item` VALUES ('12', 'relationship', '1', '父亲', '1', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('13', 'relationship', '2', '母亲', '2', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('14', 'relationship', '3', '爷爷', '3', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('15', 'relationship', '4', '奶奶', '4', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('16', 'relationship', '5', '叔叔', '5', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('17', 'relationship', '6', '阿姨', '6', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('18', 'relationship', '7', '其他', '7', null, '1', '2019-01-23 16:19:58', '2019-01-23 16:20:01', null);
INSERT INTO `boluo_dict_item` VALUES ('19', 'list_level', 'B', 'B级', '3', 'B级', '1', '2019-01-21 14:01:13', '2019-01-22 13:56:59', null);
INSERT INTO `boluo_dict_item` VALUES ('20', 'list_level', 'C', 'C级', '4', 'C级', '1', '2019-01-22 15:06:55', '2019-01-22 15:06:55', null);
INSERT INTO `boluo_dict_item` VALUES ('21', 'sale_status', '0', '未分配', '1', '未分配', '1', '2019-01-30 18:53:54', '2019-01-30 18:53:54', null);
INSERT INTO `boluo_dict_item` VALUES ('22', 'sale_status', '1', '已分配未拨打', '2', '已分配未拨打', '1', '2019-01-30 18:53:54', '2019-01-30 18:53:54', null);
INSERT INTO `boluo_dict_item` VALUES ('23', 'sale_status', '2', '已拨打未试听', '3', '已拨打未试听', '1', '2019-01-30 18:53:54', '2019-01-30 18:53:54', null);
INSERT INTO `boluo_dict_item` VALUES ('24', 'sale_status', '3', '已申请试听', '4', '已申请试听', '1', '2019-01-30 18:53:54', '2019-01-30 18:53:54', null);
INSERT INTO `boluo_dict_item` VALUES ('25', 'sale_status', '4', '已安排试听', '5', '已安排试听', '1', '2019-01-30 18:53:54', '2019-01-30 18:53:54', null);
INSERT INTO `boluo_dict_item` VALUES ('26', 'sale_status', '8', '失败', '6', '失败', '1', '2019-01-30 18:53:54', '2019-01-30 18:53:54', null);
INSERT INTO `boluo_dict_item` VALUES ('27', 'sale_status', '9', '已签单', '7', '已签单', '1', '2019-01-30 18:53:54', '2019-01-30 18:53:54', null);
INSERT INTO `boluo_dict_item` VALUES ('28', 'loop_frequency', '1', '按天', '1', '', '1', '2019-01-30 19:26:48', '2019-01-30 19:47:06', '');
INSERT INTO `boluo_dict_item` VALUES ('29', 'loop_frequency', '30', '按月', '2', '', '1', '2019-01-30 19:27:10', '2019-01-30 19:47:10', '');
INSERT INTO `boluo_dict_item` VALUES ('30', 'loop_frequency', '365', '按年', '3', '', '1', '2019-01-30 19:27:22', '2019-01-30 19:47:14', '');
INSERT INTO `boluo_dict_item` VALUES ('31', 'sys_name', 'dict', 'dict', '1', '', '1', '2019-01-30 19:51:36', null, null);
INSERT INTO `boluo_dict_item` VALUES ('32', 'sys_name', 'crm', 'crm', '2', '', '1', '2019-01-30 19:51:46', null, null);
INSERT INTO `boluo_dict_item` VALUES ('33', 'sys_name', 'marketing', 'marketing', '3', '', '1', '2019-01-30 19:51:56', null, null);
INSERT INTO `boluo_dict_item` VALUES ('34', 'is_enabel', '1', '启用', '1', '', '1', '2019-01-31 16:58:13', null, null);
INSERT INTO `boluo_dict_item` VALUES ('35', 'is_enabel', '0', '禁用', '2', '', '1', '2019-01-31 16:58:27', null, null);

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
  `err_msg` varchar(500) DEFAULT NULL COMMENT '异常信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'crm', 'ditch', 'DitchServiceImpl', 'delDitch', null, null, 'id=13	', '192.168.0.108', '发生异常！', '2019-01-25 16:42:08', null);
INSERT INTO `sys_log` VALUES ('2', 'crm', 'ditch', 'DitchServiceImpl', 'delDitch', null, null, 'id=13	', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-25 16:50:41', null);
INSERT INTO `sys_log` VALUES ('3', 'crm', 'ditch', 'DitchServiceImpl', 'delDitch', null, null, 'id=13	', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-25 16:53:46', null);
INSERT INTO `sys_log` VALUES ('4', 'crm', 'ditch', 'DitchServiceImpl', 'delDitch', null, null, 'id=13	', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-25 16:53:58', null);
INSERT INTO `sys_log` VALUES ('5', 'crm', 'ditch', 'DitchServiceImpl', 'delDitch', null, null, 'id=13	', '0:0:0:0:0:0:0:1', '执行成功！', '2019-01-25 16:55:10', null);
INSERT INTO `sys_log` VALUES ('6', 'crm', 'ditch', 'DitchServiceImpl', 'delDitch', null, null, 'id=12	', '192.168.0.108', '执行成功！', '2019-01-25 17:04:48', null);
INSERT INTO `sys_log` VALUES ('7', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 17:56:19', null);
INSERT INTO `sys_log` VALUES ('8', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 17:58:37', null);
INSERT INTO `sys_log` VALUES ('9', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:00:18', null);
INSERT INTO `sys_log` VALUES ('10', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:03:28', null);
INSERT INTO `sys_log` VALUES ('11', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:03:32', null);
INSERT INTO `sys_log` VALUES ('12', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:03:36', null);
INSERT INTO `sys_log` VALUES ('13', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.108', '发生异常！', '2019-01-25 18:09:42', null);
INSERT INTO `sys_log` VALUES ('14', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.108', '发生异常！', '2019-01-25 18:10:10', null);
INSERT INTO `sys_log` VALUES ('15', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:15:52', null);
INSERT INTO `sys_log` VALUES ('16', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:16:03', null);
INSERT INTO `sys_log` VALUES ('17', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:17:37', null);
INSERT INTO `sys_log` VALUES ('18', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:18:45', null);
INSERT INTO `sys_log` VALUES ('19', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:18:57', null);
INSERT INTO `sys_log` VALUES ('20', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:30:49', null);
INSERT INTO `sys_log` VALUES ('21', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:45:03', null);
INSERT INTO `sys_log` VALUES ('22', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:45:42', null);
INSERT INTO `sys_log` VALUES ('23', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:48:55', null);
INSERT INTO `sys_log` VALUES ('24', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:49:00', null);
INSERT INTO `sys_log` VALUES ('25', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:49:55', null);
INSERT INTO `sys_log` VALUES ('26', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:50:01', null);
INSERT INTO `sys_log` VALUES ('27', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.108', '发生异常！', '2019-01-25 18:50:05', null);
INSERT INTO `sys_log` VALUES ('28', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:52:10', null);
INSERT INTO `sys_log` VALUES ('29', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:52:16', null);
INSERT INTO `sys_log` VALUES ('30', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:52:21', null);
INSERT INTO `sys_log` VALUES ('31', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:52:24', null);
INSERT INTO `sys_log` VALUES ('32', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 18:58:05', null);
INSERT INTO `sys_log` VALUES ('33', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.108', '发生异常！', '2019-01-25 19:01:12', null);
INSERT INTO `sys_log` VALUES ('34', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.108', '发生异常！', '2019-01-25 19:01:51', null);
INSERT INTO `sys_log` VALUES ('35', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 19:07:19', null);
INSERT INTO `sys_log` VALUES ('36', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 19:07:57', null);
INSERT INTO `sys_log` VALUES ('37', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 19:08:01', null);
INSERT INTO `sys_log` VALUES ('38', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.108', '发生异常！', '2019-01-25 19:13:49', null);
INSERT INTO `sys_log` VALUES ('39', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 19:14:29', null);
INSERT INTO `sys_log` VALUES ('40', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 19:14:37', null);
INSERT INTO `sys_log` VALUES ('41', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 19:14:43', null);
INSERT INTO `sys_log` VALUES ('42', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.123', '执行成功！', '2019-01-25 19:20:12', null);
INSERT INTO `sys_log` VALUES ('43', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.104', '发生异常！', '2019-01-27 14:57:50', null);
INSERT INTO `sys_log` VALUES ('44', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.104', '发生异常！', '2019-01-27 14:59:20', null);
INSERT INTO `sys_log` VALUES ('45', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.104', '发生异常！', '2019-01-27 15:13:04', null);
INSERT INTO `sys_log` VALUES ('46', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.104', '发生异常！', '2019-01-27 18:57:31', null);
INSERT INTO `sys_log` VALUES ('47', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.104', '发生异常！', '2019-01-27 18:58:55', null);
INSERT INTO `sys_log` VALUES ('48', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-27 19:03:22', null);
INSERT INTO `sys_log` VALUES ('49', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-27 19:04:43', null);
INSERT INTO `sys_log` VALUES ('50', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '0:0:0:0:0:0:0:1', '执行成功！', '2019-01-27 19:07:43', null);
INSERT INTO `sys_log` VALUES ('51', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-28 10:22:54', null);
INSERT INTO `sys_log` VALUES ('52', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-28 10:24:13', null);
INSERT INTO `sys_log` VALUES ('53', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '0:0:0:0:0:0:0:1', '发生异常！', '2019-01-28 10:26:19', null);
INSERT INTO `sys_log` VALUES ('54', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '0:0:0:0:0:0:0:1', '执行成功！', '2019-01-28 10:29:05', null);
INSERT INTO `sys_log` VALUES ('55', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.109', '发生异常！', '2019-01-28 10:32:23', null);
INSERT INTO `sys_log` VALUES ('56', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictDesc=	pageSize=10	dictCode=	pageNo=1	', '192.168.0.109', '执行成功！', '2019-01-28 15:47:32', null);
INSERT INTO `sys_log` VALUES ('57', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.109', '发生异常！', '2019-01-28 17:35:02', null);
INSERT INTO `sys_log` VALUES ('58', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.109', '发生异常！', '2019-01-28 17:37:15', null);
INSERT INTO `sys_log` VALUES ('59', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.109', '发生异常！', '2019-01-28 17:37:20', null);
INSERT INTO `sys_log` VALUES ('60', 'crm', 'ditch', 'DitchServiceImpl', 'reallocate', null, null, '', '192.168.0.109', '发生异常！', '2019-01-28 17:37:24', null);
INSERT INTO `sys_log` VALUES ('61', 'crm', 'ditch', 'DitchServiceImpl', 'saveDitch', null, null, '', '192.168.0.109', '发生异常！', '2019-01-28 17:51:30', null);
INSERT INTO `sys_log` VALUES ('62', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.108', '执行成功！', '2019-01-29 11:38:48', null);
INSERT INTO `sys_log` VALUES ('63', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.108', '执行成功！', '2019-01-29 11:39:43', null);
INSERT INTO `sys_log` VALUES ('64', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.108', '执行成功！', '2019-01-29 11:40:07', null);
INSERT INTO `sys_log` VALUES ('65', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 13:26:17', null);
INSERT INTO `sys_log` VALUES ('66', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 13:26:20', null);
INSERT INTO `sys_log` VALUES ('67', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 13:26:49', null);
INSERT INTO `sys_log` VALUES ('68', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 13:26:51', null);
INSERT INTO `sys_log` VALUES ('69', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 13:27:19', null);
INSERT INTO `sys_log` VALUES ('70', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 13:27:48', null);
INSERT INTO `sys_log` VALUES ('71', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.108', '执行成功！', '2019-01-29 13:30:00', null);
INSERT INTO `sys_log` VALUES ('72', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-29 13:59:30', null);
INSERT INTO `sys_log` VALUES ('73', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-29 14:00:00', null);
INSERT INTO `sys_log` VALUES ('74', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-29 14:00:59', null);
INSERT INTO `sys_log` VALUES ('75', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-29 14:01:38', null);
INSERT INTO `sys_log` VALUES ('76', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-29 14:02:03', null);
INSERT INTO `sys_log` VALUES ('77', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-29 14:02:40', null);
INSERT INTO `sys_log` VALUES ('78', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 14:40:10', null);
INSERT INTO `sys_log` VALUES ('79', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-29 14:53:39', null);
INSERT INTO `sys_log` VALUES ('80', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:36:41', null);
INSERT INTO `sys_log` VALUES ('81', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:37:22', null);
INSERT INTO `sys_log` VALUES ('82', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '7', 'yangzexun', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.109', '执行成功！', '2019-01-30 10:37:54', null);
INSERT INTO `sys_log` VALUES ('83', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '7', 'yangzexun', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:41:25', null);
INSERT INTO `sys_log` VALUES ('84', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '7', 'yangzexun', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.109', '执行成功！', '2019-01-30 10:41:39', null);
INSERT INTO `sys_log` VALUES ('85', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:43:44', null);
INSERT INTO `sys_log` VALUES ('86', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:49:41', null);
INSERT INTO `sys_log` VALUES ('87', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:50:20', null);
INSERT INTO `sys_log` VALUES ('88', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:51:43', null);
INSERT INTO `sys_log` VALUES ('89', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:52:31', null);
INSERT INTO `sys_log` VALUES ('90', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:53:02', null);
INSERT INTO `sys_log` VALUES ('91', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:53:35', null);
INSERT INTO `sys_log` VALUES ('92', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.123', '执行成功！', '2019-01-30 10:53:45', null);
INSERT INTO `sys_log` VALUES ('93', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '7', 'yangzexun', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.109', '执行成功！', '2019-01-30 10:57:13', null);
INSERT INTO `sys_log` VALUES ('94', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '7', 'yangzexun', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.109', '执行成功！', '2019-01-30 10:57:20', null);
INSERT INTO `sys_log` VALUES ('95', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-30 11:03:18', null);
INSERT INTO `sys_log` VALUES ('96', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-30 11:03:21', null);
INSERT INTO `sys_log` VALUES ('97', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-30 11:03:24', null);
INSERT INTO `sys_log` VALUES ('98', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=offline_classroom	', '192.168.0.130', '执行成功！', '2019-01-30 11:03:35', null);
INSERT INTO `sys_log` VALUES ('99', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=4321	', '192.168.0.130', '执行成功！', '2019-01-30 11:03:46', null);
INSERT INTO `sys_log` VALUES ('100', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=123456	', '192.168.0.130', '执行成功！', '2019-01-30 11:03:50', null);
INSERT INTO `sys_log` VALUES ('101', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=1234567	', '192.168.0.130', '执行成功！', '2019-01-30 11:03:53', null);
INSERT INTO `sys_log` VALUES ('102', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-30 11:08:32', null);
INSERT INTO `sys_log` VALUES ('103', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-30 11:08:33', null);
INSERT INTO `sys_log` VALUES ('104', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-30 11:09:15', null);
INSERT INTO `sys_log` VALUES ('105', 'dict', 'dict', 'BoluoDictServiceImpl', 'findPagination', '2', 'admin', 'dictCode=	dictDesc=	pageNo=1	pageSize=10	', '192.168.0.130', '执行成功！', '2019-01-30 11:09:17', null);
INSERT INTO `sys_log` VALUES ('106', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:25:59', null);
INSERT INTO `sys_log` VALUES ('107', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=1	dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:26:08', null);
INSERT INTO `sys_log` VALUES ('108', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=1	dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:26:48', null);
INSERT INTO `sys_log` VALUES ('109', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:26:48', null);
INSERT INTO `sys_log` VALUES ('110', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=2	dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:26:52', null);
INSERT INTO `sys_log` VALUES ('111', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=30	dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:26:57', null);
INSERT INTO `sys_log` VALUES ('112', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=30	dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:27:10', null);
INSERT INTO `sys_log` VALUES ('113', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:27:10', null);
INSERT INTO `sys_log` VALUES ('114', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=365	dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:27:17', null);
INSERT INTO `sys_log` VALUES ('115', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=365	dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:27:22', null);
INSERT INTO `sys_log` VALUES ('116', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:27:22', null);
INSERT INTO `sys_log` VALUES ('117', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:36:11', null);
INSERT INTO `sys_log` VALUES ('118', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:36:27', null);
INSERT INTO `sys_log` VALUES ('119', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:37:25', null);
INSERT INTO `sys_log` VALUES ('120', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=	', '192.168.0.109', '执行成功！', '2019-01-30 19:38:16', null);
INSERT INTO `sys_log` VALUES ('121', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=	', '192.168.0.109', '执行成功！', '2019-01-30 19:39:31', null);
INSERT INTO `sys_log` VALUES ('122', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:43:21', null);
INSERT INTO `sys_log` VALUES ('123', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:43:34', null);
INSERT INTO `sys_log` VALUES ('124', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:44:10', null);
INSERT INTO `sys_log` VALUES ('125', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:44:11', null);
INSERT INTO `sys_log` VALUES ('126', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:44:11', null);
INSERT INTO `sys_log` VALUES ('127', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loopFrequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:44:11', null);
INSERT INTO `sys_log` VALUES ('128', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:44:18', null);
INSERT INTO `sys_log` VALUES ('129', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:46:16', null);
INSERT INTO `sys_log` VALUES ('130', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:46:35', null);
INSERT INTO `sys_log` VALUES ('131', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=1	dictCode=loop_frequency	dictitemId=28	', '192.168.0.109', '执行成功！', '2019-01-30 19:46:40', null);
INSERT INTO `sys_log` VALUES ('132', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:02', null);
INSERT INTO `sys_log` VALUES ('133', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=1	dictCode=loop_frequency	dictitemId=28	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:06', null);
INSERT INTO `sys_log` VALUES ('134', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:06', null);
INSERT INTO `sys_log` VALUES ('135', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=30	dictCode=loop_frequency	dictitemId=29	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:10', null);
INSERT INTO `sys_log` VALUES ('136', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:10', null);
INSERT INTO `sys_log` VALUES ('137', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=365	dictCode=loop_frequency	dictitemId=30	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:14', null);
INSERT INTO `sys_log` VALUES ('138', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:14', null);
INSERT INTO `sys_log` VALUES ('139', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=loop_frequency	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:47:24', null);
INSERT INTO `sys_log` VALUES ('140', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=1234567	', '192.168.0.109', '执行成功！', '2019-01-30 19:50:37', null);
INSERT INTO `sys_log` VALUES ('141', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:18', null);
INSERT INTO `sys_log` VALUES ('142', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=dict	dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:29', null);
INSERT INTO `sys_log` VALUES ('143', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=dict	dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:36', null);
INSERT INTO `sys_log` VALUES ('144', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:36', null);
INSERT INTO `sys_log` VALUES ('145', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=crm	dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:44', null);
INSERT INTO `sys_log` VALUES ('146', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=crm	dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:46', null);
INSERT INTO `sys_log` VALUES ('147', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:46', null);
INSERT INTO `sys_log` VALUES ('148', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=marketing	dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:53', null);
INSERT INTO `sys_log` VALUES ('149', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictitemCode=marketing	dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:56', null);
INSERT INTO `sys_log` VALUES ('150', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	', '192.168.0.109', '执行成功！', '2019-01-30 19:51:56', null);
INSERT INTO `sys_log` VALUES ('151', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:55:28', null);
INSERT INTO `sys_log` VALUES ('152', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:55:34', null);
INSERT INTO `sys_log` VALUES ('153', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:55:35', null);
INSERT INTO `sys_log` VALUES ('154', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 19:56:05', null);
INSERT INTO `sys_log` VALUES ('155', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 20:00:46', null);
INSERT INTO `sys_log` VALUES ('156', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 20:04:15', null);
INSERT INTO `sys_log` VALUES ('157', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '7', 'yangzexun', 'dictCode=sys_name	isEnabel=1	', '192.168.0.109', '执行成功！', '2019-01-30 20:06:09', null);
INSERT INTO `sys_log` VALUES ('158', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=sys_name	isEnabel=1	', '192.168.0.130', '执行成功！', '2019-01-30 20:06:42', null);
INSERT INTO `sys_log` VALUES ('159', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=sys_name	isEnabel=1	', '192.168.0.130', '执行成功！', '2019-01-30 20:07:04', null);
INSERT INTO `sys_log` VALUES ('160', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=sys_name	isEnabel=1	', '192.168.0.130', '执行成功！', '2019-01-31 14:38:18', null);
INSERT INTO `sys_log` VALUES ('161', 'dict', 'dict', 'BoluoDictItemServiceImpl', 'findByDictCode', '2', 'admin', 'dictCode=loop_frequency	isEnabel=1	', '192.168.0.130', '执行成功！', '2019-01-31 14:38:51', null);

-- ----------------------------
-- Table structure for sys_sequence
-- ----------------------------
DROP TABLE IF EXISTS `sys_sequence`;
CREATE TABLE `sys_sequence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seq_name` varchar(50) NOT NULL COMMENT '序列名称',
  `curr_value` int(255) NOT NULL COMMENT '起始值',
  `increse_value` int(11) NOT NULL COMMENT '增加步长',
  `loop_frequency` varchar(4) NOT NULL COMMENT '循环周期，1每天，30每月，365，每年',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_enabel` int(1) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_seq_name` (`seq_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='公共的序列表，用于为非自增且要求唯一的字段记录和获取唯一ID';

-- ----------------------------
-- Records of sys_sequence
-- ----------------------------
INSERT INTO `sys_sequence` VALUES ('1', 'ditch_code', '24', '1', '30', '渠道编号', '1', '2019-01-30 15:40:04', '2019-01-31 14:39:28');
INSERT INTO `sys_sequence` VALUES ('2', '123', '0', '1', '1', '123', '1', '2019-01-30 19:18:41', '2019-01-31 16:45:10');
INSERT INTO `sys_sequence` VALUES ('3', '234', '0', '1', '1', '123', '1', '2019-01-30 19:18:58', '2019-01-31 16:45:25');
INSERT INTO `sys_sequence` VALUES ('4', '11111', '0', '1', '30', '123', '1', '2019-01-30 19:47:53', '2019-01-31 16:15:20');
INSERT INTO `sys_sequence` VALUES ('6', '1234', '0', '1', '1', '', '1', '2019-01-31 16:30:45', null);
INSERT INTO `sys_sequence` VALUES ('7', '12345', '0', '1', '1', '', '1', '2019-01-31 16:38:35', null);
INSERT INTO `sys_sequence` VALUES ('8', '123456', '0', '1', '1', '', '1', '2019-01-31 16:50:29', null);

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
