/*
Navicat MySQL Data Transfer

Source Server         : 111.229.146.83_3306
Source Server Version : 50646
Source Host           : 111.229.146.83:3306
Source Database       : stagethree

Target Server Type    : MYSQL
Target Server Version : 50646
File Encoding         : 65001

Date: 2019-12-20 10:07:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat_record
-- ----------------------------
DROP TABLE IF EXISTS `chat_record`;
CREATE TABLE `chat_record` (
  `id` int(11) NOT NULL COMMENT '聊天id',
  `send_id` int(11) DEFAULT NULL COMMENT '发送方id',
  `send_name` varchar(255) DEFAULT NULL COMMENT '发送方昵称',
  `receiver_id` int(11) DEFAULT NULL COMMENT '接收方id',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '接收方昵称',
  `content` text COMMENT '聊天内容',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_record
-- ----------------------------

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_idcard` varchar(255) DEFAULT NULL COMMENT '用户身份证',
  `user_phone` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `designer_id` int(11) DEFAULT NULL COMMENT '设计师id',
  `designer_idcard` varchar(255) DEFAULT NULL COMMENT '设计师身份证',
  `designer_phone` varchar(255) DEFAULT NULL COMMENT '设计师电话',
  `decoration_company_id` int(11) DEFAULT NULL COMMENT '装修施工方id',
  `decoration_company_idcard` varchar(255) DEFAULT NULL COMMENT '装修施工方身份证',
  `decoration_company_phone` varchar(255) DEFAULT NULL COMMENT '装修施工方电话',
  `staff_id` int(11) DEFAULT NULL COMMENT '员工id',
  `staff_card` varchar(255) DEFAULT NULL COMMENT '平台证件号',
  `staff_phone` varchar(255) DEFAULT NULL COMMENT '员工电话',
  `contract_number` varchar(255) DEFAULT NULL COMMENT '合同编号',
  `contract_name` varchar(255) DEFAULT NULL COMMENT '合同名称',
  `signing_time` datetime DEFAULT NULL COMMENT '合同签署时间',
  `validity_of_contract` varchar(255) DEFAULT NULL COMMENT '合同有效时间',
  `due_time` datetime DEFAULT NULL COMMENT '合同到期时间',
  `content_of_contract` varchar(255) DEFAULT NULL COMMENT '合同内容pdf文件地址',
  `supplementary_contents_of_the_contract` varchar(255) DEFAULT NULL COMMENT '合同补充内容pdf文件地址',
  `contract_type` varchar(255) DEFAULT NULL COMMENT '设计合同,装修合同',
  `contract_status` varchar(255) DEFAULT '进行中' COMMENT '合同状态:进行中,已完成,异常终止',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('1', '1', '1', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '1', '第一份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', '', '', '设计合同', '进行中');
INSERT INTO `contract` VALUES ('2', '1', '1', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '2', '第一份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', '', '', '设计合同', '进行中');
INSERT INTO `contract` VALUES ('3', '1', '1', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '3', '第一份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', '', '', '设计合同', '进行中');
INSERT INTO `contract` VALUES ('4', '1', '1', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '4', '第一份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', '', '', '设计合同', '进行中');
INSERT INTO `contract` VALUES ('5', '1', '1', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '5', '第一份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', '', '', '设计合同', '进行中');

-- ----------------------------
-- Table structure for decorate
-- ----------------------------
DROP TABLE IF EXISTS `decorate`;
CREATE TABLE `decorate` (
  `id` int(11) NOT NULL COMMENT '装修预算表id',
  `decorate_premoney` double(255,0) NOT NULL COMMENT '装修预算金钱',
  `house_id` int(11) NOT NULL COMMENT '房屋id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of decorate
-- ----------------------------

-- ----------------------------
-- Table structure for decoration_company
-- ----------------------------
DROP TABLE IF EXISTS `decoration_company`;
CREATE TABLE `decoration_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '装修商id',
  `decoration_company_name` varchar(255) NOT NULL COMMENT '装修公司名字',
  `decoration_company_address` varchar(3000) NOT NULL COMMENT '装修公司地址',
  `decoration_company_intime` datetime NOT NULL COMMENT '装修公司入驻时间',
  `decoration_company_phone` varchar(255) DEFAULT NULL COMMENT '装修公司备用电话',
  `decoration_company_idcard` varchar(255) DEFAULT NULL COMMENT '装修公司责任人身份证号',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of decoration_company
-- ----------------------------
INSERT INTO `decoration_company` VALUES ('3', '一号家装公司', '不知道', '2019-12-17 14:12:00', '222', '22222', '2');

-- ----------------------------
-- Table structure for decoration_company_order
-- ----------------------------
DROP TABLE IF EXISTS `decoration_company_order`;
CREATE TABLE `decoration_company_order` (
  `id` int(11) NOT NULL COMMENT '装修公司订单id',
  `decoration_company_id` int(11) NOT NULL COMMENT '装修公司id',
  `house_id` int(11) NOT NULL COMMENT '房屋id',
  `project_money` varchar(255) NOT NULL COMMENT '装修工程价格',
  `order_status` varchar(255) NOT NULL DEFAULT '正常' COMMENT '装修公司订单状态',
  `contract_id` int(11) NOT NULL COMMENT '装修合同id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of decoration_company_order
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dep_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dep_name` varchar(255) NOT NULL COMMENT '部门名字',
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '机关');
INSERT INTO `department` VALUES ('2', '业务部');
INSERT INTO `department` VALUES ('3', '设计部');
INSERT INTO `department` VALUES ('4', '人事部');

-- ----------------------------
-- Table structure for designer
-- ----------------------------
DROP TABLE IF EXISTS `designer`;
CREATE TABLE `designer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `designer_name` varchar(255) NOT NULL COMMENT '设计师名',
  `designer_phone` varchar(255) NOT NULL COMMENT '设计师电话',
  `designer_email` varchar(255) DEFAULT NULL COMMENT '设计师邮箱',
  `designer_password` varchar(255) NOT NULL COMMENT '设计师密码',
  `designer_status` varchar(255) NOT NULL DEFAULT '正常' COMMENT '''状态:正常,锁定,注销''',
  `url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of designer
-- ----------------------------
INSERT INTO `designer` VALUES ('1', '用户一', '111', '111@qq.com', '111', '正常', null);
INSERT INTO `designer` VALUES ('2', '设计一', '222', '222@qq.com', '222', '正常', null);

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋id',
  `house_address` varchar(255) DEFAULT NULL COMMENT '房屋地址',
  `house_height` double DEFAULT NULL COMMENT '房屋高度',
  `house_area` double(255,0) DEFAULT NULL COMMENT '房屋面积',
  `house_bedroom` int(11) DEFAULT NULL COMMENT '几室',
  `house_livingroom` int(11) DEFAULT NULL COMMENT '几厅',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------

-- ----------------------------
-- Table structure for imageanduser
-- ----------------------------
DROP TABLE IF EXISTS `imageanduser`;
CREATE TABLE `imageanduser` (
  `id` int(11) NOT NULL COMMENT '图片id',
  `imageurl` varchar(3000) NOT NULL COMMENT '图片url',
  `imageuse_id` int(11) DEFAULT NULL COMMENT '图片用途id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imageanduser
-- ----------------------------

-- ----------------------------
-- Table structure for imageuse
-- ----------------------------
DROP TABLE IF EXISTS `imageuse`;
CREATE TABLE `imageuse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片用途id',
  `imageuse_name` varchar(255) NOT NULL COMMENT '图片用途名(英语的那个)',
  `imageuse_value` varchar(255) NOT NULL COMMENT '图片用途值(中文那个)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imageuse
-- ----------------------------

-- ----------------------------
-- Table structure for material_businessman
-- ----------------------------
DROP TABLE IF EXISTS `material_businessman`;
CREATE TABLE `material_businessman` (
  `id` int(11) NOT NULL COMMENT '材料商家id',
  `material_businessman_name` varchar(255) NOT NULL COMMENT '材料商人姓名',
  `material_businessman_synopsis` varchar(3000) DEFAULT '这个材料商很懒,什么都没有留下!' COMMENT '材料商人简介',
  `intime` datetime NOT NULL COMMENT '材料商人入驻时间',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material_businessman
-- ----------------------------

-- ----------------------------
-- Table structure for order_parent_address
-- ----------------------------
DROP TABLE IF EXISTS `order_parent_address`;
CREATE TABLE `order_parent_address` (
  `id` int(11) NOT NULL COMMENT '主键',
  `parent_name` varchar(255) DEFAULT NULL COMMENT '区县名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_parent_address
-- ----------------------------

-- ----------------------------
-- Table structure for order_son_address
-- ----------------------------
DROP TABLE IF EXISTS `order_son_address`;
CREATE TABLE `order_son_address` (
  `id` int(11) NOT NULL COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '区县id',
  `son_name` varchar(255) DEFAULT NULL COMMENT '街道名字',
  `detailed_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_son_address
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL COMMENT '权限id',
  `permission_name` varchar(255) NOT NULL COMMENT '权限名(英语的那个)',
  `permission_value` varchar(255) DEFAULT NULL COMMENT '权限名(中文的那个)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` int(11) NOT NULL COMMENT '平台证件主键',
  `platform_name` varchar(255) DEFAULT NULL COMMENT '平台证件名',
  `platform_card` varchar(255) DEFAULT NULL COMMENT '平台证件编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) NOT NULL COMMENT '角色名(英语的那个)',
  `role_value` varchar(255) DEFAULT NULL COMMENT '角色值(中文的那个)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL COMMENT '主键',
  `url` varchar(255) DEFAULT NULL COMMENT '员工头像',
  `wages` varchar(255) DEFAULT NULL COMMENT '工资',
  `staff_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '员工电话',
  `password` varchar(255) DEFAULT NULL COMMENT '员工登录密码',
  `status` varchar(255) DEFAULT '正常' COMMENT '员工状态',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('4', null, '1000', '员工1', '1111', '1111', '正常', null);

-- ----------------------------
-- Table structure for staffloginmessage
-- ----------------------------
DROP TABLE IF EXISTS `staffloginmessage`;
CREATE TABLE `staffloginmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '登录记录表id',
  `userlogin_time` datetime NOT NULL COMMENT '用户登录时间',
  `userlogin_address` varchar(3000) NOT NULL COMMENT '登录地点',
  `staff_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffloginmessage
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `phone` varchar(255) NOT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `status` varchar(255) NOT NULL DEFAULT '正常' COMMENT '''状态:正常,锁定,注销''',
  `url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '用户一', '111', '111@qq.com', '111', '正常', null);
INSERT INTO `user` VALUES ('2', '装修一', '222', '222@qq.com', '222', '正常', null);

-- ----------------------------
-- Table structure for user_dep
-- ----------------------------
DROP TABLE IF EXISTS `user_dep`;
CREATE TABLE `user_dep` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `dep_id` int(11) NOT NULL COMMENT '所述部门id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_dep
-- ----------------------------
INSERT INTO `user_dep` VALUES ('1', '3');
INSERT INTO `user_dep` VALUES ('1', '3');
INSERT INTO `user_dep` VALUES ('1', '3');
INSERT INTO `user_dep` VALUES ('2', '3');
INSERT INTO `user_dep` VALUES ('2', '3');
INSERT INTO `user_dep` VALUES ('2', '3');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
