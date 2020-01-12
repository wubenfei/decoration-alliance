/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50621
Source Host           : 192.168.31.220:3306
Source Database       : stagethree

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2020-01-11 16:22:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_apply
-- ----------------------------
DROP TABLE IF EXISTS `business_apply`;
CREATE TABLE `business_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `apply_title` varchar(255) NOT NULL COMMENT '申请标题',
  `apply_type` varchar(255) NOT NULL COMMENT '业务申请的类型:合同审批，经费申请，工作计划审批...',
  `apply_number` varchar(20) NOT NULL COMMENT '申请编号:ZSLM20190101001',
  `fund_demand` float(255,2) DEFAULT '0.00' COMMENT '资金需求',
  `submit_date` date NOT NULL COMMENT '提交时间',
  `verify_date` date DEFAULT NULL COMMENT '审核通过时间',
  `apply_content` varchar(6000) DEFAULT '' COMMENT '申请的内容，最多两千字',
  `apply_status` varchar(255) NOT NULL DEFAULT '未处理' COMMENT '申请单状态:未处理，不通过，通过',
  `file_url` varchar(255) NOT NULL COMMENT '合同附件url',
  `apply_user` varchar(255) DEFAULT NULL COMMENT '申请人',
  `file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `apply_title` (`apply_title`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_apply
-- ----------------------------
INSERT INTO `business_apply` VALUES ('1', '1.《装饰联盟人事部关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190101', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '驳回', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('2', '2.《装饰联盟人事部关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190102', '10000.00', '2019-12-24', '2019-12-24', '据央视新闻报道 近日，中共中央办公厅、国务院办公厅印发了《关于促进劳动力和人才社会性流动体制机制改革的意见》，并发出通知，要求各地区各部门结合实际认真贯彻落实。\r\n\r\n《关于促进劳动力和人才社会性流动体制机制改革的意见》全文如下。\r\n\r\n合理、公正、畅通、有序的社会性流动，是经济持续健康发展的有力支撑，是社会和谐进步的重要标志，是实现人的全面发展的必然要求。党的十九大报告提出，要破除妨碍劳动力、人才社会性流动的体制机制弊端，使人人都有通过辛勤劳动实现自身发展的机会。为深入贯彻落实党的十九大精神，促进劳动力和人才社会性流动体制机制改革，现提出如下意见。\r\n\r\n一、总体要求\r\n\r\n以习近平新时代中国特色社会主义思想为指导，全面贯彻党的十九大和十九届二中、三中、四中全会精神，坚持和加强党的全面领导，坚持以人民为中心的发展思想，立足基本国情，把握发展规律，注重市场引领、政府引导，注重改革发力、服务助力，搭建横向流动桥梁、纵向发展阶梯，激发全社会创新创业创造活力，构建合理、公正、畅通、有序的社会性流动格局，引导个人发展融入国家富强、民族复兴进程，促进经济持续健康发展、社会公平正义、国家长治久安。\r\n\r\n二、推动经济高质量发展，筑牢社会性流动基础\r\n\r\n（一）实施就业优先政策创造流动机会。坚持把稳定和扩大就业作为经济社会发展的优先目标，将就业优先政策置于宏观政策层面，加强政策协调配合，确保经济运行在合理区间，统筹发展资本密集型、技术密集型、知识密集型和劳动密集型产业，创造更充分的流动机会。培育和壮大经济发展新动能，发展新一代信息技术、高端装备、数字创意等新兴产业，实施传统产业智能化改造提升工程，培育智慧农业、现代物流等产业，提供更高质量流动机会。研究机器人、人工智能等技术对就业影响的应对办法。\r\n\r\n（二）推动区域协调发展促进流动均衡。建立健全城乡融合发展体制机制和政策体系，推进新型城镇化建设和乡村振兴战略实施，引导城乡各类要素双向流动、平等交换、合理配置。统筹区域协调发展，建立区域合作机制、区域互助机制、区际利益补偿机制，支持中西部、东北地区培育优势特色产业，促进区域间流动机会均衡。优化行政区划设置，以中心城市和城市群为主体构建大中小城市和小城镇协调发展格局，拓宽城市间流动空间。\r\n\r\n（三）推进创新创业创造激发流动动力。加强基础学科建设，深化产教融合，加快高层次技术技能型人才培养，开展跨学科和前沿科学研究，推进高水平科技成果转化，厚植创新型国家建设根基。进一步规范行政程序、行政行为和自由裁量权，营造便捷高效、公平竞争、稳定透明的营商环境，压缩企业开办时间，发挥银行、小额贷款公司、创业投资、股权和债券等融资渠道作用，提高民营企业和中小微企业融资可获得性，促进各种所有制经济健康稳定发展。高质量建设一批创业培训（实训）基地、创业孵化基地和农村创新创业园，鼓励劳动者通过创业实现个人发展。\r\n\r\n三、畅通有序流动渠道，激发社会性流动活力\r\n\r\n（四）以户籍制度和公共服务牵引区域流动。全面取消城区常住人口300万以下的城市落户限制，全面放宽城区常住人口300万至500万的大城市落户条件。完善城区常住人口500万以上的超大特大城市积分落户政策，精简积分项目，确保社会保险缴纳年限和居住年限分数占主要比例。推进基本公共服务均等化，常住人口享有与户籍人口同等的教育、就业创业、社会保险、医疗卫生、住房保障等基本公共服务。稳妥有序探索推进门诊费用异地直接结算，提升就医费用报销便利程度。进一步发挥城镇化促进劳动力和人才社会性流动的作用，全面落实支持农业转移人口市民化的财政政策，推动城镇建设用地增加规模与吸纳农业转移人口落户数量挂钩，推动中央预算内投资安排向吸纳农业转移人口落户数量较多的城镇倾斜。', '已读', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('3', '3.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190103', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '已读', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('4', '4.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190104', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '已读', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('5', '5.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190105', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '驳回', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('6', '6.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190106', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '已读', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('7', '7.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190107', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '驳回', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('8', '8.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190108', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '通过', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('9', '9.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190109', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '驳回', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('10', '10.《装饰联盟关于2019年第一季度营业时间调整的通知》', '合同审批', 'ZSLM-HT20190110', '10000.00', '2019-12-24', '2019-12-24', '申请上级补助资金10000', '驳回', 'https://wenku.baidu.com/browse/downloadrec?doc_id=1590d7ce162ded630b1c59eef8c75fbfc77d942c&wp=2&', null, '装修合同');
INSERT INTO `business_apply` VALUES ('23', '大四的发555阿士大夫士大夫唉说的阿斯蒂芬阿斯蒂芬的是', '业务审批', 'ZSLM-YW202001061713', '0.00', '2020-01-06', null, '5555555555555555555555555555555555555555555', '已读', '', '联系人', '');
INSERT INTO `business_apply` VALUES ('24', '任职申请', '业务审批', 'ZSLM-YW202001061925', '0.00', '2020-01-06', null, '我想当董事长', '未读', '', '联系人', '');
INSERT INTO `business_apply` VALUES ('25', '辞职报告', '业务审批', 'ZSLM-YW202001061928', '0.00', '2020-01-06', null, '本人要辞职回家创业采蘑菇', '未读', '', '联系人', '');
INSERT INTO `business_apply` VALUES ('26', '请假审批', '资金申请', 'ZSLM-ZJ202001061930', '0.00', '2020-01-06', null, '大4444', '未读', '', '联系人', '');
INSERT INTO `business_apply` VALUES ('27', '试试公告试试公告试试公告试试公告试试公告试试公告试试公告试试公告试试公告', '问题反馈', 'ZSLM-FK202001072007', '111.00', '2020-01-07', null, '试试公告', '未读', '', '阿瑟', '');
INSERT INTO `business_apply` VALUES ('28', '任职申请', '资金申请', 'ZSLM-2ZJ202001082110', '5000.00', '2020-01-08', null, '我想当董事长', '未读', '', '阿瑟', '');
INSERT INTO `business_apply` VALUES ('29', '怎么还不发工资', '资金申请', 'ZSLM-2ZJ202001082112', '0.00', '2020-01-08', null, '都一年了，还不发工资？', '未读', '', '阿瑟', '');
INSERT INTO `business_apply` VALUES ('30', '我很不爽', '问题反馈', 'ZSLM-2FK202001101152', '0.00', '2020-01-10', null, '这设计师就是个垃圾，我要吐了', '未读', '', '用用er', '');
INSERT INTO `business_apply` VALUES ('31', '哦', '问题反馈', 'ZSLM2-FK202001101156', '0.00', '2020-01-10', null, '？？？？？？？', '未读', '', '用用er', '');

-- ----------------------------
-- Table structure for chat_record
-- ----------------------------
DROP TABLE IF EXISTS `chat_record`;
CREATE TABLE `chat_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '聊天id',
  `send_id` varchar(255) DEFAULT NULL COMMENT '发送方id',
  `send_name` varchar(255) DEFAULT NULL COMMENT '发送方昵称',
  `receiver_id` varchar(255) DEFAULT NULL COMMENT '接收方id',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '接收方昵称',
  `content` text COMMENT '聊天内容',
  `status` int(255) DEFAULT '1' COMMENT '阅读状态 : 1-已读;0-未读',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `type` varchar(255) DEFAULT 'text' COMMENT 'text,img',
  `other` varchar(255) DEFAULT NULL,
  `w` int(255) DEFAULT NULL COMMENT '图片宽',
  `h` int(255) DEFAULT NULL COMMENT '高',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_record
-- ----------------------------
INSERT INTO `chat_record` VALUES ('1', 'yonghu4', '用用一', 'des2', '阿瑟', '你好', '1', '2019-12-30 16:46:17', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('2', 'des2', '阿瑟', 'yonghu4', '用用一', '尊敬的用户,你好', '1', '2019-12-30 17:45:24', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('9', 'des2', '阿瑟', 'yonghu2', '用用er', '请告诉我11111', '1', '2019-12-30 17:45:24', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('11', 'yonghu2', '用用er', 'des2', '阿瑟', '我想装修房子111111111111111111111111111111111111111111111111111', '1', '2019-12-30 16:46:17', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('12', 'des2', '阿瑟', 'yonghu2', '用用er', '请告诉我我是设计师', '1', '2019-12-30 17:45:24', 'text', '', null, null);
INSERT INTO `chat_record` VALUES ('13', 'yonghu2', '用用er', 'des2', '阿瑟', '我想装修房子我是客户', '1', '2020-01-02 16:46:17', 'text', '', null, null);
INSERT INTO `chat_record` VALUES ('106', 'des2', '阿瑟', 'yonghu4', '用用一', 'http://111.229.146.83/jiandu/2020/01/09/1578555136195809.JPG', '1', '2020-01-09 15:32:18', 'img', null, '1280', '720');
INSERT INTO `chat_record` VALUES ('107', 'des2', '阿瑟', 'yonghu2', '用用er', '用于  少时诵诗书', '1', '2020-01-09 16:39:28', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('118', 'yonghu2', '用用er', 'des2', '阿瑟', '[笑]', '1', '2020-01-09 17:04:58', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('120', 'des2', '阿瑟', 'yonghu2', '用用er', 'http://111.229.146.83/jiandu/2020/01/09/1578562306444620.jpeg', '1', '2020-01-09 17:31:47', 'img', null, '112', '120');
INSERT INTO `chat_record` VALUES ('121', 'des2', '阿瑟', 'dec3', '重庆装饰联盟信息科技有限公司', '用于  少时诵诗书', '1', '2020-01-09 16:39:28', 'text', '', null, null);
INSERT INTO `chat_record` VALUES ('122', 'dec3', '重庆装饰联盟信息科技有限公司', 'des2', '阿瑟', '测试装修公司', '1', '2020-01-09 16:39:28', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('145', 'des2', '阿瑟', 'dec3', '重庆装饰联盟信息科技有限公司', '1212', '0', '2020-01-10 15:06:29', 'text', null, null, null);
INSERT INTO `chat_record` VALUES ('146', 'dec3', '重庆装饰联盟信息科技有限公司', 'des2', '阿瑟', '1212', '1', '2020-01-10 15:06:29', 'text', '', null, null);
INSERT INTO `chat_record` VALUES ('147', 'des2', '阿瑟', 'dec3', '重庆装饰联盟信息科技有限公司', 'http://111.229.146.83/jiandu/2020/01/10/1578640514967950.JPG', '0', '2020-01-10 15:15:16', 'img', null, '1280', '720');

-- ----------------------------
-- Table structure for chat_record_des_dec
-- ----------------------------
DROP TABLE IF EXISTS `chat_record_des_dec`;
CREATE TABLE `chat_record_des_dec` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '聊天id',
  `send_id` varchar(255) DEFAULT NULL COMMENT '发送方id',
  `send_name` varchar(255) DEFAULT NULL COMMENT '发送方昵称',
  `receiver_id` varchar(255) DEFAULT NULL COMMENT '接收方id',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '接收方昵称',
  `content` text COMMENT '聊天内容',
  `status` int(255) DEFAULT '0' COMMENT '阅读状态 : 1-已读;0-未读',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `type` varchar(255) DEFAULT 'text' COMMENT 'text,img',
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_record_des_dec
-- ----------------------------
INSERT INTO `chat_record_des_dec` VALUES ('1', 'dec3', '公司名称', 'des2', '阿瑟', '你好', '1', '2019-12-30 16:46:17', 'text', null);
INSERT INTO `chat_record_des_dec` VALUES ('2', 'des2', '阿瑟', 'dec3', '公司名称', '装修团队,你好', '1', '2019-12-30 17:45:24', 'text', null);

-- ----------------------------
-- Table structure for company_data
-- ----------------------------
DROP TABLE IF EXISTS `company_data`;
CREATE TABLE `company_data` (
  `company_name` varchar(255) NOT NULL DEFAULT '装饰联盟信息科技有限公司' COMMENT '公司名字',
  `company_number` varchar(255) NOT NULL DEFAULT '84TWT424FAS666YEYQ' COMMENT '组织机构代码',
  `account_permission` varchar(255) NOT NULL DEFAULT 'SHSDF6212265555444466664444' COMMENT '开户许可证号',
  `business_license` varchar(255) NOT NULL DEFAULT 'QSGSD56415313538832' COMMENT '营业执照',
  `representative` varchar(255) NOT NULL DEFAULT '李某人' COMMENT '法人',
  `representative_tel` varchar(255) NOT NULL DEFAULT '13888888888' COMMENT '法人电话',
  `create_date` date NOT NULL DEFAULT '2019-09-09',
  `company_type` varchar(255) NOT NULL DEFAULT '有限责任公司',
  `register_capital` int(255) NOT NULL DEFAULT '50000000' COMMENT '注册资本',
  `register_status` varchar(255) NOT NULL DEFAULT '存续' COMMENT '''登记状态：存续|注销''',
  `company_address` varchar(255) NOT NULL DEFAULT '重庆市江北区**街道**大厦' COMMENT '''公司地址''',
  `company_synopsis` varchar(3000) NOT NULL DEFAULT '装饰联盟信息科技有限公司（简称装饰联盟）成立于2019年09月09日，是一家集成国内众多实力装修团队和金牌设计师的一体化设计装修服务平台，立足于中国房地产发展盛况下装饰市场的众多弊端，装饰联盟整合国内众多优势资源，潜心服务装饰行业，争当装饰行业的清流，真正做到“材料使用透明化”、“装饰成本透明化”、“管理流程制度化”的核心理念' COMMENT '''公司简介'''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_data
-- ----------------------------
INSERT INTO `company_data` VALUES ('重庆装饰联盟信息科技有限公司', '915101003319649632', '', 'QSGSD56415313538832', '李某人', '13888888888', '2019-09-09', '有限责任公司', '50000000', '存续', '重庆市江北区**街道**大厦', '装饰联盟信息科技有限公司（简称装饰联盟）成立于2019年09月09日，是一家集成国内众多实力装修团队和金牌设计师的一体化设计装修服务平台，立足于中国房地产发展盛况下装饰市场的众多弊端，装饰联盟整合国内众多优势资源，潜心服务装饰行业，争当装饰行业的清流，真正做到“材料使用透明化”、“装饰成本透明化”、“管理流程制度化”的核心理念');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
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
  `contract_name` varchar(255) CHARACTER SET utf16 DEFAULT NULL COMMENT '合同名称',
  `signing_time` datetime DEFAULT NULL COMMENT '合同签署时间',
  `validity_of_contract` varchar(255) DEFAULT NULL COMMENT '合同有效时间',
  `due_time` datetime DEFAULT NULL COMMENT '合同到期时间',
  `content_of_contract` varchar(255) DEFAULT NULL COMMENT '合同内容pdf文件地址',
  `supplementary_contents_of_the_contract` varchar(255) DEFAULT NULL COMMENT '合同补充内容pdf文件地址',
  `contract_type` varchar(255) DEFAULT NULL COMMENT '设计合同,装修合同',
  `contract_status` varchar(255) DEFAULT '进行中' COMMENT '合同状态:进行中,已完成,异常终止',
  `contract_houseid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contract_number` (`contract_number`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('1', '4', '1', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '1', '第一份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '装修合同', '进行中', '1');
INSERT INTO `contract` VALUES ('2', '4', '1', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '2', '第二份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '装修合同', '已完成', '2');
INSERT INTO `contract` VALUES ('3', '1', '1', '111', '2', '3', '222', '3', '3', '333', '4', '4', '444', '3', '第三份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '设计合同', '进行中', '3');
INSERT INTO `contract` VALUES ('4', '1', '1', '111', '3', '3', '222', '3', '3', '333', '4', '4', '444', '5', '第四份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '设计合同', '进行中', '4');
INSERT INTO `contract` VALUES ('5', '1', '2', '111', '2', '3', '222', '3', '3', '333', '4', '4', '444', '6', '第五份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '设计合同', '进行中', '5');
INSERT INTO `contract` VALUES ('6', '1', '2', '111', '3', '2', '222', '3', '3', '333', '4', '4', '444', '7', '第五份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '设计合同', '进行中', '6');
INSERT INTO `contract` VALUES ('7', '1', '2', '111', '3', '2', '222', '3', '3', '333', '4', '4', '444', '8', '第五份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '设计合同', '进行中', '7');
INSERT INTO `contract` VALUES ('8', '1', '2', '111', '2', '3', '222', '3', '3', '333', '4', '4', '444', '9', '第五份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '设计合同', '已完成', '8');
INSERT INTO `contract` VALUES ('9', '1', '2', '111', '2', '2', '222', '3', '3', '333', '4', '4', '444', '10', '第五份装修合同', '2019-12-10 14:15:46', '90天', '2020-02-10 14:16:39', 'http://111.229.146.83/装饰联盟(周圣杰,吴本飞,何瑜城,殷智).xlsx', 'http://111.229.146.83/redis.docx', '设计合同', '已完成', '9');
INSERT INTO `contract` VALUES ('32', '2', '222222222222222222', '18883285733', '2', '222222222222222222', '15234567821', '3', '555555555555555555', '13984416520', '1', '522122199606160014', '13333333333', 'ZSLM-HT20190106', '装修合同', '2020-01-10 00:00:00', '91天', '2020-04-10 00:00:00', '', '', '装修合同', '未读', '-1');

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
  `password` varchar(255) DEFAULT '123456' COMMENT '密码',
  `company_name` varchar(255) NOT NULL COMMENT '装修公司名字',
  `company_address` varchar(3000) NOT NULL COMMENT '装修公司地址',
  `company_synopsis` varchar(3000) DEFAULT '一个装修团队' COMMENT '装修商简介',
  `company_intime` date NOT NULL COMMENT '装修公司入驻时间',
  `company_phone` varchar(255) DEFAULT NULL COMMENT '装修公司电话',
  `company_rephone` varchar(255) DEFAULT NULL COMMENT '装修公司备用电话',
  `company_idcard` varchar(255) DEFAULT NULL COMMENT '装修公司责任人身份证号',
  `company_idname` varchar(255) DEFAULT NULL COMMENT '装修公司责任人姓名',
  `company_status` varchar(255) DEFAULT '合作中' COMMENT '合作状态:合作中,合作解除',
  `company_url` varchar(3000) DEFAULT NULL COMMENT '装修团队资质路径',
  `decorationid_title` varchar(255) NOT NULL DEFAULT 'dec',
  `url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of decoration_company
-- ----------------------------
INSERT INTO `decoration_company` VALUES ('3', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '重庆装饰联盟信息科技有限公司', '公司地址', '简介', '2020-01-04', '13984416520', '13984416520', '555555555555555555', '联系人', '合作中', 'http://111.229.146.83/zizhi/2019/12/25/1577259061929362.jpg', 'dec', 'https://img-cdn-qiniu.dcloud.net.cn/uniapp/doc/github.svg');
INSERT INTO `decoration_company` VALUES ('52', 'f3c6b429c665c140db8fe878b5bef89ae9e1be09bd87ecd537706b8db3ef7e62', '测试1', '测试路径', '一个装修团队', '2019-12-30', '13333333333', '14323443233', '143234432341111', '啊啊', '合作中', 'http://111.229.146.83/zizhi/2019/12/25/1577259061929362.jpg', 'dec', 'https://img-cdn-qiniu.dcloud.net.cn/uniapp/doc/github.svg');
INSERT INTO `decoration_company` VALUES ('53', '123456', 'company_url', 'company_url', '一个装修团队', '2019-12-25', '14131212122', '14131212123', '141312121221111', '啊啊', '合作中', 'http://111.229.146.83/zizhi/2019/12/25/1577259061929362.jpg', 'dec', 'https://img-cdn-qiniu.dcloud.net.cn/uniapp/doc/github.svg');
INSERT INTO `decoration_company` VALUES ('54', '123456', '181901212', '1212', '一个装修团队', '2019-12-25', '15312121222', '15312121221', '153121212221111', '啊啊', '合作中', 'http://111.229.146.83/zizhi/2019/12/25/1577259061929362.jpg', 'dec', 'https://img-cdn-qiniu.dcloud.net.cn/uniapp/doc/github.svg');

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_id` varchar(11) NOT NULL COMMENT '部门编号',
  `dep_name` varchar(255) NOT NULL COMMENT '部门名字',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dep_id` (`dep_id`,`dep_name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('18', 'ZSLM-CW', '财务部');
INSERT INTO `department` VALUES ('11', 'ZSLM-RS', '人事部');
INSERT INTO `department` VALUES ('10', 'ZSLM-SJ', '设计部');

-- ----------------------------
-- Table structure for department_permission
-- ----------------------------
DROP TABLE IF EXISTS `department_permission`;
CREATE TABLE `department_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dep_id` varchar(11) NOT NULL COMMENT '部门id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department_permission
-- ----------------------------
INSERT INTO `department_permission` VALUES ('1', 'zslm-jg', '1');
INSERT INTO `department_permission` VALUES ('2', 'zslm-rs', '1');
INSERT INTO `department_permission` VALUES ('3', 'zslm-sc', '1');
INSERT INTO `department_permission` VALUES ('4', 'zslm-sj', '1');

-- ----------------------------
-- Table structure for designer
-- ----------------------------
DROP TABLE IF EXISTS `designer`;
CREATE TABLE `designer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `designer_job` varchar(255) NOT NULL COMMENT '设计师工号',
  `wages` varchar(255) DEFAULT NULL COMMENT '工资',
  `designer_name` varchar(255) NOT NULL COMMENT '设计师名',
  `designer_phone` varchar(255) NOT NULL COMMENT '设计师电话',
  `designer_email` varchar(255) DEFAULT NULL COMMENT '设计师邮箱',
  `designer_password` varchar(255) NOT NULL DEFAULT '123456' COMMENT '设计师密码',
  `designer_status` varchar(255) NOT NULL DEFAULT '正常' COMMENT '''状态:正常,锁定,注销''',
  `role_id` int(11) DEFAULT '2' COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '设计师职级',
  `tel` varchar(11) DEFAULT NULL COMMENT '紧急手机号码',
  `addr` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `join_data` date DEFAULT NULL COMMENT '入职时间',
  `dismission_date` date DEFAULT NULL COMMENT '离职时间',
  `designerid_title` varchar(255) NOT NULL DEFAULT 'des',
  `designer_synopsis` varchar(3000) DEFAULT NULL COMMENT '设计师简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of designer
-- ----------------------------
INSERT INTO `designer` VALUES ('2', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577953110582&di=3008516b0af77e3cebd84b1b6b9b0a10&imgtype=0&src=http%3A%2F%2Fpic4.zhimg.com%2F50%2Fv2-bd0e3f6d1d3bec2e1764de06d70b4a91_hd.jpg', '20191024', '50000', '阿瑟', '15234567821', '88888888@qq.com', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '正常', '2', '主管', '15234567822', '重庆市江北区某某街道办事处', '222222222222222222', '2019-12-26', null, 'des', '我是一个专门负责吃饭的设计师，吃饭贼凶哦！');
INSERT INTO `designer` VALUES ('3', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577953146100&di=5bd698ce7f1923141367ca1fecd0ab2f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201710%2F09%2F20171009155213_xHJBN.jpeg', '20191023', null, '涉及涉及', '15212121211', null, '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '正常', '2', '总经理', '15212121212', '1121212', null, '2019-12-26', null, 'des', null);

-- ----------------------------
-- Table structure for designer_effect
-- ----------------------------
DROP TABLE IF EXISTS `designer_effect`;
CREATE TABLE `designer_effect` (
  `id` int(11) NOT NULL COMMENT '主键',
  `designer_id` int(11) DEFAULT NULL COMMENT '设计师id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `designer_img1` varchar(255) DEFAULT NULL COMMENT '效果图1',
  `designer_img2` varchar(255) DEFAULT NULL COMMENT '效果图2',
  `designer_img3` varchar(255) DEFAULT NULL COMMENT '效果图3',
  `designer_img4` varchar(255) DEFAULT NULL COMMENT '效果图4',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of designer_effect
-- ----------------------------
INSERT INTO `designer_effect` VALUES ('1', '2', '4', 'https://tgi13.jia.com/126/339/26339967.jpg', 'https://tgi1.jia.com/126/339/26339341.jpg', 'https://tgi12.jia.com/126/338/26338554.jpg', '');
INSERT INTO `designer_effect` VALUES ('2', '2', '4', 'https://tgi13.jia.com/126/339/26339967.jpg', 'https://tgi1.jia.com/126/339/26339341.jpg', 'https://tgi12.jia.com/126/338/26338554.jpg', 'https://tgi12.jia.com/126/340/26340526.jpg');
INSERT INTO `designer_effect` VALUES ('3', '2', '4', 'https://tgi13.jia.com/126/339/26339967.jpg', 'https://tgi1.jia.com/126/339/26339341.jpg', 'https://tgi12.jia.com/126/338/26338554.jpg', 'https://tgi12.jia.com/126/340/26340526.jpg');
INSERT INTO `designer_effect` VALUES ('4', '2', '4', 'https://tgi13.jia.com/126/339/26339967.jpg', 'https://tgi1.jia.com/126/339/26339341.jpg', 'https://tgi12.jia.com/126/338/26338554.jpg', 'https://tgi12.jia.com/126/340/26340526.jpg');
INSERT INTO `designer_effect` VALUES ('5', '3', '4', 'https://tgi13.jia.com/126/339/26339967.jpg', 'https://tgi1.jia.com/126/339/26339341.jpg', 'https://tgi12.jia.com/126/338/26338554.jpg', 'https://tgi12.jia.com/126/340/26340526.jpg');
INSERT INTO `designer_effect` VALUES ('6', '2', '4', 'https://tgi13.jia.com/126/339/26339967.jpg', 'https://tgi1.jia.com/126/339/26339341.jpg', 'https://tgi12.jia.com/126/338/26338554.jpg', 'https://tgi12.jia.com/126/340/26340526.jpg');

-- ----------------------------
-- Table structure for des_dec
-- ----------------------------
DROP TABLE IF EXISTS `des_dec`;
CREATE TABLE `des_dec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `des_id` int(11) DEFAULT NULL COMMENT '设计师id',
  `dec_id` int(11) DEFAULT NULL COMMENT '装修团队id',
  `push` int(11) DEFAULT '1' COMMENT '1推荐,0不推荐',
  `in` int(11) DEFAULT NULL COMMENT '1显示0不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of des_dec
-- ----------------------------
INSERT INTO `des_dec` VALUES ('1', '2', '3', '1', '1');
INSERT INTO `des_dec` VALUES ('2', '2', '52', '1', null);
INSERT INTO `des_dec` VALUES ('3', '2', '53', '0', null);

-- ----------------------------
-- Table structure for forstaff_app
-- ----------------------------
DROP TABLE IF EXISTS `forstaff_app`;
CREATE TABLE `forstaff_app` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forstaffapp_name` varchar(255) DEFAULT NULL COMMENT '功能名字',
  `forstaffapp_value` varchar(255) DEFAULT NULL,
  `forstaffapp_url` varchar(255) DEFAULT NULL COMMENT '图标图片url',
  `tourl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forstaff_app
-- ----------------------------
INSERT INTO `forstaff_app` VALUES ('1', 'advice', '合同列表', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578400870432&di=cc367760d176b45d4d07f4b698767146&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fitbbs%2F1402%2F07%2Fc14%2F31057378_1391755694847_mthumb.jpg', '/pages/upload/contractList');
INSERT INTO `forstaff_app` VALUES ('2', 'plan', '项目安排', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=167504111,276535959&fm=15&gp=0.jpg', '/pages/tree/accordion');
INSERT INTO `forstaff_app` VALUES ('3', 'apply', '业务报备', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4266087731,4251193957&fm=26&gp=0.jpg', '/pages/person/apply');
INSERT INTO `forstaff_app` VALUES ('4', 'userlist1', '客户列表', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578401063500&di=ef92c0a94c67eefce7221a1b2ec49771&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D191545303%2C795568867%26fm%3D214%26gp%3D0.jpg', '/pages/myclienteles/myclienteles1');
INSERT INTO `forstaff_app` VALUES ('5', 'userlist2', '客户列表', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578401026206&di=27443bcdaf5d84a76fcb615d33659080&imgtype=0&src=http%3A%2F%2Fimg.article.pchome.net%2F00%2F27%2F27%2F20%2Fpic_lib%2Fwm%2F036.jpg', '/pages/myclienteles/myclienteles2');
INSERT INTO `forstaff_app` VALUES ('6', 'slary', '我的薪资', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578401026205&di=87cf2a2c1ec7aa807eefbe47ca5807df&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F279759ee3d6d55fbcbbaf29966224f4a20a4dd15.jpg', '/pages/myslary/reseller');
INSERT INTO `forstaff_app` VALUES ('7', 'list', '上传管理', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578401177349&di=20fbce1c3e879e404fca2d60ec08e419&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D1987093995%2C2694977892%26fm%3D214%26gp%3D0.jpg', '/pages/upload/typeItem');
INSERT INTO `forstaff_app` VALUES ('8', 'declist1', '通讯列表', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1709364414,3988099115&fm=15&gp=0.jpg', '/pages/myclienteles/myDecorationCompany');
INSERT INTO `forstaff_app` VALUES ('9', 'deslist2', '通讯列表', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578401026203&di=e455b3bd8942e532a8f98c48e01ffeed&imgtype=0&src=http%3A%2F%2Fdik.img.kttpdq.com%2Fpic%2F25%2F17363%2F6b3d0a8890449f2c_640x1136.jpg', null);
INSERT INTO `forstaff_app` VALUES ('10', 'wick', '工程监督', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578401026202&di=f2f2c7bb4086857fb70b459e50c7be68&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fd%2F58115bcb07466.jpg', '/pages/steps/stepslist');
INSERT INTO `forstaff_app` VALUES ('11', 'myconpany', '公司详情', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1578401307022&di=03c996161848dfb9f2bf831766085d8b&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D1343018473%2C3804440424%26fm%3D214%26gp%3D0.jpg', '/pages/person/company');

-- ----------------------------
-- Table structure for friendlycompany
-- ----------------------------
DROP TABLE IF EXISTS `friendlycompany`;
CREATE TABLE `friendlycompany` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '友商种类表主键',
  `friendly_company_kind` varchar(255) DEFAULT NULL,
  `friendly_company_value` varchar(255) DEFAULT NULL COMMENT '友商种类名',
  `role_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friendlycompany
-- ----------------------------
INSERT INTO `friendlycompany` VALUES ('1', 'decoration_company', '装修团队', '1');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋id',
  `house_address` varchar(255) DEFAULT NULL COMMENT '房屋地址',
  `house_height` double DEFAULT NULL COMMENT '房屋高度',
  `house_area` double DEFAULT NULL COMMENT '房屋面积',
  `house_type` varchar(11) DEFAULT NULL COMMENT '户型',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('1', '啊大大飒飒是', '3.5', '120', '4', '2');
INSERT INTO `house` VALUES ('2', '北京市-市辖区-西城区-哈哈哈哈', '3.2', '56.4', '一室一厅', '2');
INSERT INTO `house` VALUES ('4', '北京市-市辖区-西城区-理想大厦', '3.3', '123.67', '三室两厅', '2');
INSERT INTO `house` VALUES ('5', '北京市-市辖区-西城区-加州花园', '3.3', '45.2', '一室一厅', '2');
INSERT INTO `house` VALUES ('6', '辽宁省-丹东市-元宝区-鲤鱼池', '3.2', '54.68', '一室一厅', '5');
INSERT INTO `house` VALUES ('7', '辽宁省-丹东市-元宝区-融景城丽园', '3.2', '124.23', '四室两室', '5');
INSERT INTO `house` VALUES ('8', '吉林省-松原市-宁江区-奥术大师', '2.3', '63.25', '两室一厅', '5');
INSERT INTO `house` VALUES ('9', '河北省-邯郸市-永年区-十大科技第三轮', '3.2', '45.2', '一室一厅', '2');
INSERT INTO `house` VALUES ('10', '吉林省-长春市-南关区-阿打算', '3.2', '65.21', '两室一厅', '2');
INSERT INTO `house` VALUES ('22', '重庆市江北区', '888', '123', '三室一厅', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'friendlyCompany', '友商');
INSERT INTO `role` VALUES ('2', 'staff', '员工');

-- ----------------------------
-- Table structure for role_app
-- ----------------------------
DROP TABLE IF EXISTS `role_app`;
CREATE TABLE `role_app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL COMMENT '角色',
  `app` int(11) DEFAULT NULL COMMENT '功能',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_app
-- ----------------------------
INSERT INTO `role_app` VALUES ('1', '1', '1');
INSERT INTO `role_app` VALUES ('2', '1', '2');
INSERT INTO `role_app` VALUES ('3', '1', '3');
INSERT INTO `role_app` VALUES ('4', '1', '4');
INSERT INTO `role_app` VALUES ('5', '1', '6');
INSERT INTO `role_app` VALUES ('6', '1', '7');
INSERT INTO `role_app` VALUES ('7', '1', '8');
INSERT INTO `role_app` VALUES ('8', '1', '10');
INSERT INTO `role_app` VALUES ('9', '1', '11');
INSERT INTO `role_app` VALUES ('10', '2', '1');
INSERT INTO `role_app` VALUES ('11', '2', '2');
INSERT INTO `role_app` VALUES ('13', '2', '3');
INSERT INTO `role_app` VALUES ('14', '2', '5');
INSERT INTO `role_app` VALUES ('15', '2', '7');
INSERT INTO `role_app` VALUES ('16', '2', '9');
INSERT INTO `role_app` VALUES ('17', '2', '11');

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
INSERT INTO `role_permission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(3000) DEFAULT 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif' COMMENT '员工头像',
  `job_number` varchar(255) NOT NULL COMMENT '员工工号',
  `wages` varchar(255) DEFAULT NULL COMMENT '工资',
  `staff_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '员工电话',
  `password` varchar(255) DEFAULT '123456' COMMENT '员工登录密码',
  `status` varchar(255) DEFAULT '正常' COMMENT '员工状态',
  `role_id` int(11) DEFAULT '2' COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '员工职级',
  `tel` varchar(11) DEFAULT NULL COMMENT '紧急手机号码',
  `addr` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `join_date` date DEFAULT NULL COMMENT '入职时间',
  `dismission_date` date DEFAULT NULL COMMENT '离职时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif', '20191001', '1000', '员工1', '120', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '离职', null, '总经理', '13333333333', '重庆市渝北区龙溪街道理想大厦A座4楼', '522122199606160014', '2019-12-20', '2019-12-29');
INSERT INTO `staff` VALUES ('2', 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif', '20191002', '1000', '员工2', '110', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '正常', null, '主管', '13333333334', '重庆市渝北区龙溪街道理想大厦A座4楼', '522122199606160014', '2019-12-20', '2019-12-20');
INSERT INTO `staff` VALUES ('3', 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif', '20191003', '1000', '员工3', '119', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '离职', null, '总经理', '13333333335', '重庆市渝北区龙溪街道理想大厦A座4楼', '522122199606160014', '2019-12-20', '2019-12-20');
INSERT INTO `staff` VALUES ('4', 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif', '20191004', '1000', '员工4', '10086', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '正常', null, '普通员工', '13333333336', '重庆市渝北区龙溪街道理想大厦A座4楼', '522122199606160014', '2019-12-20', '2019-12-20');
INSERT INTO `staff` VALUES ('5', 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif', '20191005', '1000', '员工5', '10000', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '正常', null, '普通员工', '13333333337', '重庆市渝北区龙溪街道理想大厦A座4楼', '522122199606160014', '2019-12-20', '2019-12-20');
INSERT INTO `staff` VALUES ('7', 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif', '20191026', null, '啊啊', '15212121211', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '离职', '2', '普通员工', '15212121212', '15212121211', '252525266666666', '2019-12-26', '2019-12-29');
INSERT INTO `staff` VALUES ('8', 'https://p.ssl.qhimg.com/dmfd/400_300_/t013afecdd652914cb5.gif', '20191025', null, '阿瑟升水', '15234567821', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '正常', '2', '普通员工', '15234567822', '啊啊啊', '121222222222222', '2019-12-26', null);

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
-- Table structure for staff_dep
-- ----------------------------
DROP TABLE IF EXISTS `staff_dep`;
CREATE TABLE `staff_dep` (
  `job_number` varchar(11) NOT NULL COMMENT '员工工号',
  `dep_id` varchar(11) NOT NULL COMMENT '所述部门id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_dep
-- ----------------------------
INSERT INTO `staff_dep` VALUES ('20191001', 'ZSLM-RS');
INSERT INTO `staff_dep` VALUES ('20191002', 'ZSLM-RS');
INSERT INTO `staff_dep` VALUES ('20191003', 'ZSLM-RS');
INSERT INTO `staff_dep` VALUES ('20191004', 'ZSLM-CW');
INSERT INTO `staff_dep` VALUES ('20191005', 'ZSLM-CW');
INSERT INTO `staff_dep` VALUES ('20191022', 'ZSLM-CW');
INSERT INTO `staff_dep` VALUES ('20191020', 'ZSLM-CW');
INSERT INTO `staff_dep` VALUES ('20191021', 'ZSLM-CW');
INSERT INTO `staff_dep` VALUES ('20191023', 'ZSLM-SJ');
INSERT INTO `staff_dep` VALUES ('20191026', 'ZSLM-CW');
INSERT INTO `staff_dep` VALUES ('20191024', 'ZSLM-SJ');
INSERT INTO `staff_dep` VALUES ('20191025', 'ZSLM-CW');

-- ----------------------------
-- Table structure for staff_role
-- ----------------------------
DROP TABLE IF EXISTS `staff_role`;
CREATE TABLE `staff_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `staff_role_name` varchar(255) NOT NULL COMMENT '员工角色英文名',
  `staff_role_value` varchar(255) DEFAULT NULL COMMENT '员工角色中文名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_role
-- ----------------------------
INSERT INTO `staff_role` VALUES ('1', 'manger', '总经理');
INSERT INTO `staff_role` VALUES ('2', 'supervisor', '主管');
INSERT INTO `staff_role` VALUES ('3', 'ordinarystaff', '普通员工');

-- ----------------------------
-- Table structure for step
-- ----------------------------
DROP TABLE IF EXISTS `step`;
CREATE TABLE `step` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `contractid` int(11) DEFAULT NULL COMMENT '合同id',
  `img1` varchar(3000) DEFAULT NULL COMMENT '监督图片',
  `img2` varchar(3000) DEFAULT NULL COMMENT '监督图片',
  `img3` varchar(3000) DEFAULT NULL COMMENT '监督图片',
  `img4` varchar(3000) DEFAULT NULL COMMENT '监督图片',
  `img5` varchar(3000) DEFAULT NULL COMMENT '监督图片',
  `img6` varchar(3000) DEFAULT NULL,
  `img7` varchar(3000) DEFAULT NULL,
  `time1` datetime DEFAULT NULL,
  `time2` datetime DEFAULT NULL,
  `time3` datetime DEFAULT NULL,
  `time4` datetime DEFAULT NULL,
  `time5` datetime DEFAULT NULL,
  `time6` datetime DEFAULT NULL,
  `time7` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of step
-- ----------------------------
INSERT INTO `step` VALUES ('1', '1', 'http://111.229.146.83/jiandu/2020/01/10/1578628193445985.JPG,http://111.229.146.83/jiandu/2020/01/10/1578628195311425.JPG,http://111.229.146.83/jiandu/2020/01/10/1578628197552153.JPG', 'http://111.229.146.83/jiandu/2020/01/10/1578628193445985.JPG,http://111.229.146.83/jiandu/2020/01/10/1578628195311425.JPG,http://111.229.146.83/jiandu/2020/01/10/1578628197552153.JPG', 'http://111.229.146.83/jiandu/2020/01/10/1578628193445985.JPG,http://111.229.146.83/jiandu/2020/01/10/1578628195311425.JPG,http://111.229.146.83/jiandu/2020/01/10/1578628197552153.JPG', '', '', '', '', '2020-01-10 11:50:02', '2020-01-09 20:52:29', '2020-01-10 11:46:17', '2020-01-10 09:51:06', '2020-01-09 17:37:52', '2020-01-09 17:52:28', '2020-01-09 19:53:54');
INSERT INTO `step` VALUES ('3', '3', '', null, null, null, null, null, null, '2020-01-09 11:30:51', null, null, null, null, null, null);
INSERT INTO `step` VALUES ('4', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `step` VALUES ('5', '12', 'http://111.229.146.83/jiandu/2020/01/10/1578641127851348.JPG,http://111.229.146.83/jiandu/2020/01/10/1578641127886616.JPG', null, null, null, null, null, null, '2020-01-10 15:25:31', null, null, null, null, null, null);
INSERT INTO `step` VALUES ('6', '14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `step` VALUES ('7', '29', 'http://111.229.146.83/jiandu/2020/01/10/1578645955636229.JPG', 'http://111.229.146.83/jiandu/2020/01/10/1578645962849126.JPG,http://111.229.146.83/jiandu/2020/01/10/1578645964413020.JPG', null, null, null, null, null, '2020-01-10 16:45:59', '2020-01-10 16:46:07', null, null, null, null, null);
INSERT INTO `step` VALUES ('8', '32', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for step_des
-- ----------------------------
DROP TABLE IF EXISTS `step_des`;
CREATE TABLE `step_des` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_des_id` int(11) DEFAULT NULL,
  `contractid` int(11) DEFAULT NULL COMMENT '合同id',
  `img1` varchar(3000) DEFAULT NULL COMMENT '监督图片',
  `img2` varchar(3000) DEFAULT NULL COMMENT '监督图片',
  `time1` datetime DEFAULT NULL,
  `time2` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of step_des
-- ----------------------------
INSERT INTO `step_des` VALUES ('1', null, '1', 'http://111.229.146.83/jiandu/2020/01/09/1578547424872185.JPG', 'http://111.229.146.83/jiandu/2020/01/09/1578547458602712.JPG,http://111.229.146.83/jiandu/2020/01/09/1578547460859261.JPG', '2020-01-09 13:23:48', '2020-01-09 13:24:23');
INSERT INTO `step_des` VALUES ('3', null, '3', '', null, '2020-01-09 11:30:51', null);
INSERT INTO `step_des` VALUES ('4', null, '2', null, null, null, null);
INSERT INTO `step_des` VALUES ('5', '3', null, 'http://111.229.146.83/jiandu/2020/01/10/1578651905712489.JPG,http://111.229.146.83/jiandu/2020/01/10/1578651907534767.JPG,http://111.229.146.83/jiandu/2020/01/10/1578651910154794.JPG', null, '2020-01-10 18:25:21', null);

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
  `userid_title` varchar(255) NOT NULL DEFAULT 'yonghu',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '用用er', '18883285733', '111111111111111111', '68378d409dc4d373f2abdc0bc6fc24b52b6ba19579b0a6d6346e04ec7122aa76', '正常', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577953057493&di=9ff254152a4d3f7060e996c9c20dca84&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201901%2F17%2F20190117230425_eofqv.thumb.700_0.jpg', 'yonghu');
INSERT INTO `user` VALUES ('4', '用用一', '15730263205', '111@qq.com', '68378d409dc4d373f2abdc0bc6fc24b52b6ba19579b0a6d6346e04ec7122aa76', '正常', 'http://img3.imgtn.bdimg.com/it/u=1912113785,1587702892&fm=26&gp=0.jpg', 'yonghu');
INSERT INTO `user` VALUES ('5', '12', '111111', null, '68378d409dc4d373f2abdc0bc6fc24b52b6ba19579b0a6d6346e04ec7122aa76', '正常', null, 'yonghu');

-- ----------------------------
-- Table structure for user_dec
-- ----------------------------
DROP TABLE IF EXISTS `user_dec`;
CREATE TABLE `user_dec` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `dec_id` int(11) NOT NULL COMMENT '装修团队',
  `user_status` int(11) NOT NULL DEFAULT '1' COMMENT '客户状态:0-合作崩了,1-合作中,2-合作结束',
  `user_name` varchar(255) NOT NULL,
  `des_status` int(11) NOT NULL DEFAULT '1' COMMENT '设计师状态:0-合作崩了,1-合作中,2-合作结束',
  `in` int(255) NOT NULL DEFAULT '1' COMMENT '是否:1-显示,0-不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_dec
-- ----------------------------

-- ----------------------------
-- Table structure for user_des
-- ----------------------------
DROP TABLE IF EXISTS `user_des`;
CREATE TABLE `user_des` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `des_id` int(11) NOT NULL COMMENT '设计师',
  `user_name` varchar(255) NOT NULL,
  `user_status` int(11) NOT NULL DEFAULT '1' COMMENT '客户状态:0-合作崩了,1-合作中,2-合作结束',
  `des_status` int(11) NOT NULL DEFAULT '1' COMMENT '设计师状态:0-合作崩了,1-合作中,2-合作结束',
  `in` int(255) NOT NULL DEFAULT '1' COMMENT '是否:1-显示,0-不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_des
-- ----------------------------
INSERT INTO `user_des` VALUES ('1', '4', '2', '用用一', '1', '2', '0');
INSERT INTO `user_des` VALUES ('3', '2', '2', '用用er', '1', '1', '1');

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

-- ----------------------------
-- Table structure for wages
-- ----------------------------
DROP TABLE IF EXISTS `wages`;
CREATE TABLE `wages` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `job_number` varchar(255) DEFAULT NULL COMMENT '工号',
  `name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `wages` int(11) DEFAULT '0' COMMENT '基本工资',
  `royalty` int(11) DEFAULT '0' COMMENT '提成',
  `status` varchar(255) DEFAULT NULL COMMENT '员工状态',
  `granted` varchar(255) DEFAULT NULL COMMENT '发放状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wages
-- ----------------------------
INSERT INTO `wages` VALUES ('1', '20191001', '员工1', '10000', '0', '正常', '未发放');
INSERT INTO `wages` VALUES ('2', '20191002', '员工2', '1000', '0', '正常', '未发放');
INSERT INTO `wages` VALUES ('3', '20191003', '员工3', '1000', '0', '正常', '未发放');
INSERT INTO `wages` VALUES ('4', '20191004', '员工4', '1000', '0', '正常', '未发放');
INSERT INTO `wages` VALUES ('5', '20191005', '员工5', '1000', '0', '正常', '未发放');
INSERT INTO `wages` VALUES ('6', '20191024', '阿瑟', '2000', '0', '正常', '未发放');
INSERT INTO `wages` VALUES ('7', '20191023', '涉及涉及', '2100', '0', '正常', '未发放');
