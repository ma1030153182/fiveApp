/*
Navicat MySQL Data Transfer

Source Server         : mpc
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : fiveapp

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-05-07 12:38:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `beijian_apply`
-- ----------------------------
DROP TABLE IF EXISTS `beijian_apply`;
CREATE TABLE `beijian_apply` (
  `apply_id` varchar(50) NOT NULL,
  `beijian_name` varchar(50) default NULL,
  `beijian_number` varchar(50) default NULL,
  `beijian_price` varchar(50) default NULL,
  `apply_time` varchar(50) default NULL,
  `apply_pass_time` varchar(50) default NULL,
  `apply_man_id` varchar(50) default NULL,
  `apply_pass_man_id` varchar(50) default NULL,
  `beijian_id` varchar(50) default NULL,
  `apply_state` varchar(50) default NULL,
  `beijian_version` varchar(50) default NULL,
  `apply_man_name` varchar(50) default NULL,
  `apply_pass_man_name` varchar(50) default NULL,
  PRIMARY KEY  (`apply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of beijian_apply
-- ----------------------------
INSERT INTO `beijian_apply` VALUES ('64d7757c-d1cd-11e4-a87e-f6c4f47b8940', '鼠标', '2', '78', '2015-03-24 10:28:00', '2015-03-24 10:28:39', '1211610313', '1211610311', '123345645', '已收货', '124-523-3425-235-63', '杨春雨', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('8ec24b04-cfb1-11e4-b3d4-25490128c66a', '鼠标', '1', '78', '2015-03-21 18:03:42', '2015-03-23 14:58:10', '1211610313', '1211610311', '123345645', '已收货', '124-523-3425-235-63', '杨春雨', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('94716da4-cfb1-11e4-b3d4-25490128c66a', ' 灯管', '2', '30', '2015-03-21 18:03:52', '2015-03-21 18:05:54', '1211610313', '1211610311', '2d2c5227-cf9f-11e4-b3d4-25490128c66a', '已收货', ' 4312-213-423-2', '杨春雨', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('9bef94be-cfb1-11e4-b3d4-25490128c66a', ' 路由器', '3', '167', '2015-03-21 18:04:04', '2015-03-21 18:05:14', '1211610313', '1211610311', '42b35b0f-cf9f-11e4-b3d4-25490128c66a', '已通过', ' 231-234-2134-2', '杨春雨', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('a0ce524b-cfb1-11e4-b3d4-25490128c66a', '键盘', '1', '230', '2015-03-21 18:04:12', '2015-03-21 18:06:00', '1211610313', '1211610311', '45634564', '不通过', '3245-456-6734-75478', '杨春雨', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('e08c911b-d129-11e4-a2b8-dfa393f61a9d', null, '1', null, '2015-03-23 14:57:28', null, '1211610313', null, null, '待审核', null, '杨春雨', null);
INSERT INTO `beijian_apply` VALUES ('e11fbea5-cfaf-11e4-b3d4-25490128c66a', '鼠标', '1', '78', '2015-03-21 17:51:41', '2015-03-21 17:53:24', '1211354267', '1211610311', '123345645', '已通过', '124-523-3425-235-63', '袁树伟', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('e63debd8-cfaf-11e4-b3d4-25490128c66a', ' 路由器', '1', '167', '2015-03-21 17:51:50', '2015-03-21 17:59:28', '1211354267', '1211610311', '42b35b0f-cf9f-11e4-b3d4-25490128c66a', '不通过', ' 231-234-2134-2', '袁树伟', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('ea83ec66-cfaf-11e4-b3d4-25490128c66a', '键盘', '1', '230', '2015-03-21 17:51:57', '2015-03-21 17:59:12', '1211354267', '1211610311', '45634564', '不通过', '3245-456-6734-75478', '袁树伟', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('ee94781c-cfaf-11e4-b3d4-25490128c66a', ' 投影仪', '1', '3800', '2015-03-21 17:52:04', '2015-03-21 18:00:29', '1211354267', '1211610311', '78a9b03f-cf9f-11e4-b3d4-25490128c66a', '不通过', ' 345-324-345-3245', '袁树伟', '丁振豪');
INSERT INTO `beijian_apply` VALUES ('f25e1d8b-cfaf-11e4-b3d4-25490128c66a', ' 机箱', '1', '220', '2015-03-21 17:52:10', '2015-03-21 18:00:33', '1211354267', '1211610311', 'c65f0fed-cfa1-11e4-b3d4-25490128c66a', '已通过', ' 45-234-2345-324-32', '袁树伟', '丁振豪');

-- ----------------------------
-- Table structure for `bei_jian`
-- ----------------------------
DROP TABLE IF EXISTS `bei_jian`;
CREATE TABLE `bei_jian` (
  `beijian_id` varchar(50) NOT NULL,
  `beijian_name` varchar(50) default NULL,
  `beijian_version` varchar(50) default NULL,
  `beijian_price` varchar(50) default NULL,
  `beijian_number` varchar(50) default NULL,
  `warn_number` varchar(50) default NULL,
  `beijian_state` varchar(50) default NULL,
  PRIMARY KEY  (`beijian_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bei_jian
-- ----------------------------
INSERT INTO `bei_jian` VALUES ('123345645', '鼠标', '124-523-3425-235-63', '78', '16', '10', '');
INSERT INTO `bei_jian` VALUES ('2d2c5227-cf9f-11e4-b3d4-25490128c66a', ' 灯管', ' 4312-213-423-2', '30', '208', '10', null);
INSERT INTO `bei_jian` VALUES ('42b35b0f-cf9f-11e4-b3d4-25490128c66a', ' 路由器', ' 231-234-2134-2', '167', '120', '10', null);
INSERT INTO `bei_jian` VALUES ('45634564', '键盘', '3245-456-6734-75478', '230', '45', '10', '');
INSERT INTO `bei_jian` VALUES ('5e64c2a9-cf9f-11e4-b3d4-25490128c66a', ' 网线', ' 23-234-23-23-4', '23', '99', '10', null);
INSERT INTO `bei_jian` VALUES ('78a9b03f-cf9f-11e4-b3d4-25490128c66a', ' 投影仪', ' 345-324-345-3245', '3800', '79', '10', null);
INSERT INTO `bei_jian` VALUES ('96ac857b-d11d-11e4-a2b8-dfa393f61a9d', '键盘', '342-3245-3425', '342', '222', '10', null);
INSERT INTO `bei_jian` VALUES ('b4bc34eb-cf9e-11e4-b3d4-25490128c66a', 'cpu', '123-123-123-123', '2300', '77', '10', null);
INSERT INTO `bei_jian` VALUES ('c65f0fed-cfa1-11e4-b3d4-25490128c66a', ' 机箱', ' 45-234-2345-324-32', '220', '266', '10', null);
INSERT INTO `bei_jian` VALUES ('ca3cfc31-cf9e-11e4-b3d4-25490128c66a', ' 显卡', ' 241-2134-1234-234', '1900', '190', '10', null);
INSERT INTO `bei_jian` VALUES ('ecd44cf1-cf9e-11e4-b3d4-25490128c66a', ' 内存', ' 312421-324-234', '400', '140', '10', null);
INSERT INTO `bei_jian` VALUES ('fe7af580-cf9e-11e4-b3d4-25490128c66a', ' 显示器', ' 34-123-2134-2134', '1900', '18', '10', null);

-- ----------------------------
-- Table structure for `custom`
-- ----------------------------
DROP TABLE IF EXISTS `custom`;
CREATE TABLE `custom` (
  `add_kefu_id` varchar(50) default NULL,
  `custom_id` varchar(50) NOT NULL,
  `custom_name` varchar(50) default NULL,
  `custom_id_card` varchar(50) default NULL,
  `custom_company` varchar(50) default NULL,
  `custom_tel` varchar(50) default NULL,
  `custom_mabile` varchar(50) default NULL,
  `custom_addrass` varchar(50) default NULL,
  `custom_email` varchar(50) default NULL,
  `custom_post` varchar(50) default NULL,
  `add_kefu_name` varchar(50) default NULL,
  PRIMARY KEY  (`custom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom
-- ----------------------------
INSERT INTO `custom` VALUES ('1211611311', '15a82d26-cf94-11e4-b3d4-25490128c66a', '郭英奇', '3322199234567898', '东软', '0123843279', '18222951234', '天津工业大学', 'guoyingqi@qq.com', '454957', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', '37d855c8-cf77-11e4-b3d4-25490128c66a', '马云', '12432314', '阿里巴巴', '88888888', '14521354', '杭州', 'topviptop@qq.com', '300000', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', '4cde05b3-cf94-11e4-b3d4-25490128c66a', ' 马肖攀', '41082319932501236', '东软', ' 03917663912', ' 18222958280', ' 天津工业大学', ' xiaopan9@gmail.com', ' 454350', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', '50805f52-cf93-11e4-b3d4-25490128c66a', '彭刚', '4212335621124315', '东软', '03917661684', '18222959632', '唐宁街23号', 'penggang@qq.com', '454951', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', '535a2e12-cf75-11e4-b3d4-25490128c66a', '丁振豪', '411527', '天津工业大学软件学院', '5412432', '15620960752', '天津工业大学', '1144673474@qq.com', '400300', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', '7789edba-cf75-11e4-b3d4-25490128c66a', ' 高照富', '4554646', ' 天津工业', ' 123412', ' 345236325', ' 天津工业大学', ' 11446656@11.com', ' 400300', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', '7f9746d7-cf93-11e4-b3d4-25490128c66a', ' 江亚欧', '211233565321314361', ' 东软', ' 03916889546', ' 18222963254', ' 天津工业大学', ' jiangyaou@qq.com', ' 454955', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', '86c2a2fb-cf94-11e4-b3d4-25490128c66a', ' 韩巍', '46325695123654', ' 东软', ' 03678964523', '13512869271', ' 天津', ' hanwei@qq.com', ' 46895231', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', 'b46bf892-cf93-11e4-b3d4-25490128c66a', ' 杨春雨', '232131243242364', '东软', '04278991122', '18678962234', '天津工业大学', 'yangchhunyu@qq.com', '234587', '马肖攀');
INSERT INTO `custom` VALUES ('1211611311', 'cefac187-cf75-11e4-b3d4-25490128c66a', ' 马俊龙', '451321655', ' 常州大学', ' 412213423', ' 1234123421', '常州大学', ' topviptop@qq.com', '300000', '马肖攀');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `record_id` varchar(50) NOT NULL,
  `emp_id` varchar(50) default NULL,
  `role_id` varchar(50) default NULL,
  `emp_name` varchar(30) default NULL,
  `emp_password` varchar(30) default NULL,
  `emp_account` varchar(50) default NULL,
  PRIMARY KEY  (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1232435', '1211610311', '库管', '丁振豪', '123', 'dingzhenhao');
INSERT INTO `emp` VALUES ('2341243', '1324124214', '库管', '吴灿斌', '123', 'wuchanbin');
INSERT INTO `emp` VALUES ('2343452', '1211611311', '客服', '马肖攀', '123', 'maxiaopan');
INSERT INTO `emp` VALUES ('2345235', '1211611316', '调度员', '高照富', '123', 'gaozhaofu');
INSERT INTO `emp` VALUES ('3463723', '12114325634', '管理员', '韩巍', '123', 'hanwei');
INSERT INTO `emp` VALUES ('4123412', '1211354267', '维修员', '袁树伟', '123', 'yuanshuwei');
INSERT INTO `emp` VALUES ('41234123', '2357457688', '维修员', '江亚欧', '123', 'jiangyaou');
INSERT INTO `emp` VALUES ('41243125', '2141234123', '维修员', '付新忠', '123', 'fuxinzhong');
INSERT INTO `emp` VALUES ('4523456', '1211610313', '维修员', '杨春雨', '123', 'yangchunyu');
INSERT INTO `emp` VALUES ('5234523', '1242463465', '维修员', '彭刚', '123', 'penggang');

-- ----------------------------
-- Table structure for `emp_info`
-- ----------------------------
DROP TABLE IF EXISTS `emp_info`;
CREATE TABLE `emp_info` (
  `emp_id` varchar(50) NOT NULL,
  `emp_mobile` varchar(50) default NULL,
  `emp_name` varchar(50) default NULL,
  `emp_dep` varchar(50) default NULL,
  `emp_addrass` varchar(50) default NULL,
  `emp_email` varchar(50) default NULL,
  `part_company` varchar(50) default NULL,
  `good_at` varchar(50) default NULL,
  PRIMARY KEY  (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_info
-- ----------------------------
INSERT INTO `emp_info` VALUES ('1211354267', '15686895489', '袁树伟', '维修员', '林肯大道105号', '235234532574@qq.com', '1', '打印机类');
INSERT INTO `emp_info` VALUES ('1211610311', '15620960752', '丁振豪', '库管', '天津工业大学', '11144673474@qq.com', '1', null);
INSERT INTO `emp_info` VALUES ('1211610313', '15283065569', '杨春雨', '维修员', '上海路35324号', '15234573474@qq.com', '1', '手机类');
INSERT INTO `emp_info` VALUES ('1211611311', '13845672634', '马肖攀', '客服', '硅谷105号', 'cxzkl@qq.com', '1', null);
INSERT INTO `emp_info` VALUES ('1211611316', '15656873459', '高照富', '调度员', '天津工业大学', '234532555474@qq.com', '1', null);
INSERT INTO `emp_info` VALUES ('1242463465', '15893065489', '彭刚', '维修员', '河南路435号', '1113454534474@qq.com', '1', '电脑类');
INSERT INTO `emp_info` VALUES ('1324124214', '15293055489', '吴灿斌', '库管', '北京路23号', 'dsadsa@sina.com', '1', null);
INSERT INTO `emp_info` VALUES ('2141234123', '13782726534', '付新忠', '维修员', '唐宁街23号', '3452345273474@qq.com', '1', '空调类');
INSERT INTO `emp_info` VALUES ('2357457688', '15843565489', '江亚欧', '维修员', '华尔街3463号', '34552425474@qq.com', '1', '变电器类');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` varchar(50) NOT NULL,
  `module_name` varchar(50) default NULL,
  `parent_id` varchar(50) default NULL,
  `module_url` varchar(50) default NULL,
  PRIMARY KEY  (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('00010', '客服管理', '0', null);
INSERT INTO `module` VALUES ('00011', '报修管理', '00010', 'jsp/kefuguanli/baoxiuguanli.jsp');
INSERT INTO `module` VALUES ('00012', '结算管理', '00010', 'jsp/kefuguanli/jiesuanguanli.jsp');
INSERT INTO `module` VALUES ('00013', '客户管理', '00010', 'jsp/kefuguanli/kehuguanli.jsp');
INSERT INTO `module` VALUES ('00020', '库房管理', '0', null);
INSERT INTO `module` VALUES ('00021', '备件管理', '00020', 'jsp/kufangguanli/beijianguanli.jsp');
INSERT INTO `module` VALUES ('00022', '备件流水', '00020', 'jsp/kufangguanli/beijianliushui.jsp');
INSERT INTO `module` VALUES ('00023', '管理申请', '00020', 'jsp/kufangguanli/guanlishenqing.jsp');
INSERT INTO `module` VALUES ('00030', '任务调度管理', '0', null);
INSERT INTO `module` VALUES ('00031', '维修调度', '00030', 'jsp/renwudiaoduguanli/weixiudiaodu.jsp');
INSERT INTO `module` VALUES ('00040', '维修管理', '0', null);
INSERT INTO `module` VALUES ('00041', '申请设备', '00040', 'jsp/weixiuguanli/shenqingshebei.jsp');
INSERT INTO `module` VALUES ('00042', '我的任务', '00040', 'jsp/weixiuguanli/woderenwu.jsp');
INSERT INTO `module` VALUES ('00043', '我的申请', '00040', 'jsp/weixiuguanli/wodeshenqing.jsp');

-- ----------------------------
-- Table structure for `module_role`
-- ----------------------------
DROP TABLE IF EXISTS `module_role`;
CREATE TABLE `module_role` (
  `role_id` varchar(50) NOT NULL,
  `moudle_id` varchar(50) default NULL,
  `role_name` varchar(50) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module_role
-- ----------------------------
INSERT INTO `module_role` VALUES ('0032526', '00021', '库管');
INSERT INTO `module_role` VALUES ('0054634', '00043', '管理员');
INSERT INTO `module_role` VALUES ('1234123', '00020', '库管');
INSERT INTO `module_role` VALUES ('1243212', '00041', '维修员');
INSERT INTO `module_role` VALUES ('1412348', '00040', '维修员');
INSERT INTO `module_role` VALUES ('15434563', '00010', '管理员');
INSERT INTO `module_role` VALUES ('2413222', '00030', '调度员');
INSERT INTO `module_role` VALUES ('2435234535', '00023', '管理员');
INSERT INTO `module_role` VALUES ('32457265324', '00021', '管理员');
INSERT INTO `module_role` VALUES ('3276437', '00022', '库管');
INSERT INTO `module_role` VALUES ('3654373623', '00020', '管理员');
INSERT INTO `module_role` VALUES ('43643563', '00042', '管理员');
INSERT INTO `module_role` VALUES ('436456335', '00011', '管理员');
INSERT INTO `module_role` VALUES ('4524236', '00043', '维修员');
INSERT INTO `module_role` VALUES ('4563833', '00011', '客服');
INSERT INTO `module_role` VALUES ('45643562', '00041', '管理员');
INSERT INTO `module_role` VALUES ('45645634', '00040', '管理员');
INSERT INTO `module_role` VALUES ('5234535', '00042', '维修员');
INSERT INTO `module_role` VALUES ('5485393', '00031', '调度员');
INSERT INTO `module_role` VALUES ('5634786', '00010', '客服');
INSERT INTO `module_role` VALUES ('56734436', '00031', '管理员');
INSERT INTO `module_role` VALUES ('634363246', '00013', '管理员');
INSERT INTO `module_role` VALUES ('7895632634', '00030', '管理员');
INSERT INTO `module_role` VALUES ('8658690', '00013', '客服');
INSERT INTO `module_role` VALUES ('8679442', '00023', '库管');
INSERT INTO `module_role` VALUES ('985674564', '00022', '管理员');

-- ----------------------------
-- Table structure for `repair`
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `emp_repairman_id` varchar(50) default NULL,
  `report_repair_id` varchar(50) default NULL,
  `repair_id` varchar(50) NOT NULL,
  `repair_schdul_time` varchar(50) default NULL,
  `machine_check_record` varchar(50) default NULL,
  `machine_check_time` varchar(50) default NULL,
  `repair_record` varchar(50) default NULL,
  `repair_work_time` varchar(50) default NULL,
  `repair_labour_price` varchar(50) default NULL,
  `material_price` varchar(50) default NULL,
  `repair_promise` varchar(50) default NULL,
  `attention_matter` varchar(50) default NULL,
  `repair_state` varchar(50) default NULL,
  `schedule_man_name` varchar(50) default NULL,
  `repair_man_name` varchar(50) default NULL,
  `emp_scheduling_man_id` varchar(50) default NULL,
  `end_time` varchar(50) default NULL,
  PRIMARY KEY  (`repair_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('1211610313', '658c0c29-d1c8-11e4-a87e-f6c4f47b8940', '1f22953f-d1cd-11e4-a87e-f6c4f47b8940', '2015-03-24 10:26:03', null, null, null, null, null, null, null, null, '维修中', '高照富', '杨春雨', '1211611316', null);
INSERT INTO `repair` VALUES ('1211610313', '35046245-cf95-11e4-b3d4-25490128c66a', '7ef1522d-cf99-11e4-b3d4-25490128c66a', '2015-03-21 15:11:28', null, null, null, null, null, null, null, null, '维修中', '高照富', '杨春雨', '1211611316', null);
INSERT INTO `repair` VALUES ('1211610313', '8489b6ab-d127-11e4-a2b8-dfa393f61a9d', '80bf603b-d129-11e4-a2b8-dfa393f61a9d', '2015-03-23 14:54:48', null, null, null, null, null, null, null, null, '维修中', '高照富', '杨春雨', '1211611316', null);
INSERT INTO `repair` VALUES ('1211354267', '4179bf71-d11e-11e4-a2b8-dfa393f61a9d', 'a01134bf-d11e-11e4-a2b8-dfa393f61a9d', '2015-03-23 13:37:06', null, null, null, null, null, null, null, null, '待维修', '高照富', '袁树伟', '1211611316', null);
INSERT INTO `repair` VALUES ('2141234123', 'ea0ad01d-d121-11e4-a2b8-dfa393f61a9d', 'af8e2e1c-d127-11e4-a2b8-dfa393f61a9d', '2015-03-23 14:41:47', null, null, null, null, null, null, null, null, '待维修', '高照富', '付新忠', '1211611316', null);
INSERT INTO `repair` VALUES ('1211610313', 'd9dbb3f1-cf95-11e4-b3d4-25490128c66a', 'b59ecd78-cf9b-11e4-b3d4-25490128c66a', '2015-03-21 15:27:18', '硬盘损坏', '2015-9-12', '已经修好', '2', '434', '799', '保修一年', '正常使用', '完成', '高照富', '杨春雨', '1211611316', '2015-03-21 18:19:43');
INSERT INTO `repair` VALUES ('1211354267', '9d4ac499-cf95-11e4-b3d4-25490128c66a', 'bef22562-cf9b-11e4-b3d4-25490128c66a', '2015-03-21 15:27:34', null, null, null, null, null, null, null, null, '维修中', '高照富', '袁树伟', '1211611316', null);
INSERT INTO `repair` VALUES ('1211610313', 'c7858b70-cf95-11e4-b3d4-25490128c66a', 'cdd11a8d-d11d-11e4-a2b8-dfa393f61a9d', '2015-03-23 13:31:13', null, null, null, null, null, null, null, null, '待维修', '高照富', '杨春雨', '1211611316', null);

-- ----------------------------
-- Table structure for `report_repair`
-- ----------------------------
DROP TABLE IF EXISTS `report_repair`;
CREATE TABLE `report_repair` (
  `report_repair_id` varchar(50) NOT NULL,
  `custom_id` varchar(50) default NULL,
  `emp_kefu_id` varchar(50) default NULL,
  `custom_sent_time` varchar(50) default NULL,
  `custom_properties` varchar(50) default NULL,
  `forecast_price` varchar(50) default NULL,
  `forecast_complete_time` varchar(50) default NULL,
  `report_state` varchar(50) default NULL,
  `product_type` varchar(50) default NULL,
  `machine_brand` varchar(50) default NULL,
  `machine_version` varchar(50) default NULL,
  `machine_bug_phenomenon` varchar(50) default NULL,
  `machine_start_password` varchar(50) default NULL,
  `machine_RAM` varchar(50) default NULL,
  `other` varchar(50) default NULL,
  `custom_name` varchar(50) default NULL,
  `diaodu_man_name` varchar(50) default NULL,
  `kefu_name` varchar(50) default NULL,
  `diaodu_man_id` varchar(50) default NULL,
  PRIMARY KEY  (`report_repair_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report_repair
-- ----------------------------
INSERT INTO `report_repair` VALUES ('35046245-cf95-11e4-b3d4-25490128c66a', '15a82d26-cf94-11e4-b3d4-25490128c66a', '1211611311', '2015-03-21 14:40:43', 'vip', '100', '30', '已分配', '打印机', '上好', '456456', '打印不了', '456321', '2g', '', '郭英奇', '高照富', '马肖攀', '1211611316');
INSERT INTO `report_repair` VALUES ('4179bf71-d11e-11e4-a2b8-dfa393f61a9d', '37d855c8-cf77-11e4-b3d4-25490128c66a', '1211611311', '2015-03-23 13:34:27', '企业', '234', '2016-4-4', '已分配', '投影仪', '惠普', '432-1234-234-234', '不亮', '123', '4', '无', '马云', '高照富', '马肖攀', '1211611316');
INSERT INTO `report_repair` VALUES ('63dbe7be-d28c-11e4-8d1c-88f224dde9f7', '535a2e12-cf75-11e4-b3d4-25490128c66a', '1211611311', '2015-03-25 09:15:11', null, '300', '2015-9-20', '未分配', null, '戴尔', '32412-234-234', '不能开机', '123', '4', '无', '丁振豪', null, '马肖攀', null);
INSERT INTO `report_repair` VALUES ('658c0c29-d1c8-11e4-a87e-f6c4f47b8940', '7789edba-cf75-11e4-b3d4-25490128c66a', '1211611311', '2015-03-24 09:52:14', '企业', '100', '2015-08-08', '已分配', '电脑', 'hp', '123456', '黑屏', '123', '4', '无', ' 高照富', '高照富', '马肖攀', '1211611316');
INSERT INTO `report_repair` VALUES ('8489b6ab-d127-11e4-a2b8-dfa393f61a9d', '535a2e12-cf75-11e4-b3d4-25490128c66a', '1211611311', '2015-03-23 14:40:35', '企业', '100', '2015-07-08', '已分配', '电脑', 'hp', '123456', '黑屏', '123', '4', '无', '丁振豪', '高照富', '马肖攀', '1211611316');
INSERT INTO `report_repair` VALUES ('9d4ac499-cf95-11e4-b3d4-25490128c66a', '535a2e12-cf75-11e4-b3d4-25490128c66a', '1211611311', '2015-03-21 14:43:38', 'vip', '1500', '100', '已分配', '电脑', '苹果', '123456', '屏幕坏了', '123', '500g', '', '丁振豪', '高照富', '马肖攀', '1211611316');
INSERT INTO `report_repair` VALUES ('c7858b70-cf95-11e4-b3d4-25490128c66a', '7789edba-cf75-11e4-b3d4-25490128c66a', '1211611311', '2015-03-21 14:44:49', 'vip', '1500', '150', '已分配', '手机', '苹果', '123456', '屏幕坏了', '123', '500g', '', ' 高照富', '高照富', '马肖攀', '1211611316');
INSERT INTO `report_repair` VALUES ('d9dbb3f1-cf95-11e4-b3d4-25490128c66a', '7f9746d7-cf93-11e4-b3d4-25490128c66a', '1211611311', '2015-03-21 14:45:20', 'vip', '1500', '150', '已分配', '电脑', '苹果', '123456', '主机', '123', '500g', '', ' 江亚欧', '高照富', '马肖攀', '1211611316');
INSERT INTO `report_repair` VALUES ('ea0ad01d-d121-11e4-a2b8-dfa393f61a9d', '535a2e12-cf75-11e4-b3d4-25490128c66a', '1211611311', '2015-03-23 14:00:28', '', '', '', '已分配', '', '', '', '', '', '', '', '丁振豪', '高照富', '马肖攀', '1211611316');
