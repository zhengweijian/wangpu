/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-05-04 11:08:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tshop
-- ----------------------------
DROP TABLE IF EXISTS `tshop`;
CREATE TABLE `tshop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_site_id` bigint(20) DEFAULT NULL,
  `released_site_id` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=999 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop
-- ----------------------------
INSERT INTO `tshop` VALUES ('998', null, null, '998');

-- ----------------------------
-- Table structure for tshop_layout_comp
-- ----------------------------
DROP TABLE IF EXISTS `tshop_layout_comp`;
CREATE TABLE `tshop_layout_comp` (
  `layout_comp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `layout_type` varchar(20) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `css_name` varchar(30) NOT NULL,
  `trans_group` varchar(30) DEFAULT NULL,
  `main_width` varchar(10) NOT NULL,
  `sub_width` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`layout_comp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_layout_comp
-- ----------------------------
INSERT INTO `tshop_layout_comp` VALUES ('1', 'HEAD', '头部950px', 'grid-m', 'head', 'h950', null);
INSERT INTO `tshop_layout_comp` VALUES ('2', 'FOOT', '底部950px', 'grid-m', 'foot', 'f950', null);
INSERT INTO `tshop_layout_comp` VALUES ('3', 'BODY', '中间950px', 'grid-m', 'body-m', 'b950', null);
INSERT INTO `tshop_layout_comp` VALUES ('4', 'BODY', '左边190，右边750', 'grid-sm', 'body-sm', 'b750', 'b190');
INSERT INTO `tshop_layout_comp` VALUES ('5', 'BODY', '左边750，右边190', 'grid-ms', 'body-sm', 'b750', 'b190');

-- ----------------------------
-- Table structure for tshop_layout_widget
-- ----------------------------
DROP TABLE IF EXISTS `tshop_layout_widget`;
CREATE TABLE `tshop_layout_widget` (
  `layout_widget_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `layout_comp_id` bigint(20) NOT NULL,
  `page_id` bigint(20) NOT NULL,
  `display_order` int(11) NOT NULL,
  `layout_type` varchar(30) NOT NULL,
  `max_module` int(11) NOT NULL DEFAULT '40',
  PRIMARY KEY (`layout_widget_id`),
  KEY `layout_comp_id` (`layout_comp_id`),
  CONSTRAINT `tshop_layout_widget_ibfk_1` FOREIGN KEY (`layout_comp_id`) REFERENCES `tshop_layout_comp` (`layout_comp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_layout_widget
-- ----------------------------
INSERT INTO `tshop_layout_widget` VALUES ('2', '1', '1', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('3', '2', '1', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('9', '4', '1', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('13', '1', '2', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('14', '2', '2', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('15', '4', '2', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('16', '1', '3', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('17', '2', '3', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('18', '4', '3', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('19', '1', '5', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('20', '2', '5', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('21', '4', '5', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('22', '1', '6', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('23', '2', '6', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('24', '4', '6', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('25', '1', '7', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('26', '2', '7', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('27', '4', '7', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('28', '1', '8', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('29', '2', '8', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('30', '4', '8', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('31', '1', '9', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('32', '2', '9', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('33', '4', '9', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('34', '1', '10', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('35', '2', '10', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('36', '4', '10', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('37', '1', '11', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('38', '2', '11', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('39', '4', '11', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('40', '1', '12', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('41', '2', '12', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('42', '4', '12', '1', 'BODY', '40');
INSERT INTO `tshop_layout_widget` VALUES ('43', '1', '13', '0', 'HEAD', '1');
INSERT INTO `tshop_layout_widget` VALUES ('44', '2', '13', '0', 'FOOT', '1');
INSERT INTO `tshop_layout_widget` VALUES ('45', '4', '13', '1', 'BODY', '40');

-- ----------------------------
-- Table structure for tshop_module
-- ----------------------------
DROP TABLE IF EXISTS `tshop_module`;
CREATE TABLE `tshop_module` (
  `module_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `max_append` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `support_width` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `tips` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_module
-- ----------------------------
INSERT INTO `tshop_module` VALUES ('1', '40', '服务推荐', '/images/fuwutuijian.png', 'b950-b190-b750', '1', '服务推荐');
INSERT INTO `tshop_module` VALUES ('2', '40', '服务排行', '/images/fuwupaihang.gif', 'b190', '1', '服务排行');
INSERT INTO `tshop_module` VALUES ('3', '40', '服务分类', '/images/fuwufenlei.gif', 'b190', '1', '服务分类');
INSERT INTO `tshop_module` VALUES ('4', '40', '自定义区', '/images/zidingyiqu.gif', 'b950-b190-b750-f950', '1', '自定义内容区');
INSERT INTO `tshop_module` VALUES ('5', '40', '图片轮播', '/images/tupianlunbo.gif', 'b950-b190-b750', '1', '图片轮播');
INSERT INTO `tshop_module` VALUES ('6', '1', '客服中心', '/images/kefuzhongxin.gif', 'b190', '1', '客服中心');
INSERT INTO `tshop_module` VALUES ('7', '1', '友情链接', '/images/youqinglianjie.gif', 'b950-b190', '0', '友情链接');
INSERT INTO `tshop_module` VALUES ('8', '1', '店铺招牌', '/images/dianpuzhaopai.gif', 'h950', '1', '店铺招牌');
INSERT INTO `tshop_module` VALUES ('9', '40', '宝贝搜索', '/images/baobeisousuo.gif', 'b950-b150-b750', '0', '宝贝搜索');
INSERT INTO `tshop_module` VALUES ('10', '1', '店铺导航', '//gdp.alicdn.com/tps/i2/TB1_SDIGVXXXXboXpXX4HBZGFXX-38-38.gif', 'h950', '0', '店铺导航');
INSERT INTO `tshop_module` VALUES ('11', '1', '服务列表', '', 'b750', '0', '服务列表');
INSERT INTO `tshop_module` VALUES ('12', '1', '服务基础信息', ' ', 'b750', '0', '服务基础信息');
INSERT INTO `tshop_module` VALUES ('13', '1', '服务描述信息', ' ', 'b750', '0', '服务描述信息');

-- ----------------------------
-- Table structure for tshop_module_widget
-- ----------------------------
DROP TABLE IF EXISTS `tshop_module_widget`;
CREATE TABLE `tshop_module_widget` (
  `module_widget_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `is_del` tinyint(1) NOT NULL,
  `is_move` tinyint(1) NOT NULL,
  `is_edit` tinyint(1) NOT NULL,
  `is_add` tinyint(1) NOT NULL DEFAULT '1',
  `layout_widget_id` bigint(20) NOT NULL,
  `slide` varchar(10) NOT NULL,
  `display_order` int(11) NOT NULL,
  `form_json` text,
  PRIMARY KEY (`module_widget_id`),
  KEY `module_id` (`module_id`),
  CONSTRAINT `tshop_module_widget_ibfk_1` FOREIGN KEY (`module_id`) REFERENCES `tshop_module` (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_module_widget
-- ----------------------------
INSERT INTO `tshop_module_widget` VALUES ('1', '8', '店铺招牌', '0', '0', '1', '0', '2', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('3', '2', '服务排行', '1', '1', '1', '1', '9', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('22', '8', '店铺招牌', '0', '0', '1', '0', '13', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('23', '3', '服务分类', '1', '1', '1', '1', '15', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('24', '2', '服务排行', '1', '1', '1', '1', '15', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('26', '11', '服务列表', '0', '0', '1', '0', '15', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('30', '3', '服务分类', '1', '1', '1', '1', '18', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('31', '2', '服务排行', '1', '1', '1', '1', '18', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('32', '1', '服务推荐', '1', '1', '1', '1', '18', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('33', '12', '服务基础信息', '0', '0', '1', '0', '18', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('34', '13', '服务描述信息', '0', '0', '1', '0', '18', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('37', '6', '客服中心', '1', '1', '1', '1', '9', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('38', '3', '服务分类', '1', '1', '1', '1', '9', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('39', '1', '服务推荐', '1', '1', '1', '1', '9', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('40', '1', '服务推荐', '1', '1', '1', '1', '9', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('41', '1', '服务推荐', '1', '1', '1', '1', '9', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('42', '1', '服务推荐', '1', '1', '1', '1', '9', 'main', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('43', '6', '客服中心', '1', '1', '1', '1', '15', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('44', '1', '服务推荐', '1', '1', '1', '1', '15', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('45', '6', '客服中心', '1', '1', '1', '1', '18', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('46', '8', '店铺招牌', '0', '0', '1', '0', '19', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('47', '2', '服务排行', '1', '1', '1', '1', '21', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('48', '6', '客服中心', '1', '1', '1', '1', '21', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('49', '3', '服务分类', '1', '1', '1', '1', '21', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('50', '1', '服务推荐', '1', '1', '1', '1', '21', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('51', '1', '服务推荐', '1', '1', '1', '1', '21', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('52', '1', '服务推荐', '1', '1', '1', '1', '21', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('53', '1', '服务推荐', '1', '1', '1', '1', '21', 'main', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('54', '8', '店铺招牌', '0', '0', '1', '0', '22', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('55', '3', '服务分类', '1', '1', '1', '1', '24', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('56', '2', '服务排行', '1', '1', '1', '1', '24', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('57', '11', '服务列表', '0', '0', '1', '0', '24', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('58', '6', '客服中心', '1', '1', '1', '1', '24', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('59', '1', '服务推荐', '1', '1', '1', '1', '24', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('60', '3', '服务分类', '1', '1', '1', '1', '27', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('61', '2', '服务排行', '1', '1', '1', '1', '27', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('62', '1', '服务推荐', '1', '1', '1', '1', '27', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('63', '12', '服务基础信息', '0', '0', '1', '0', '27', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('64', '13', '服务描述信息', '0', '0', '1', '0', '27', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('65', '6', '客服中心', '1', '1', '1', '1', '27', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('66', '8', '店铺招牌', '0', '0', '1', '0', '28', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('67', '2', '服务排行', '1', '1', '1', '1', '30', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('68', '6', '客服中心', '1', '1', '1', '1', '30', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('69', '3', '服务分类', '1', '1', '1', '1', '30', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('70', '1', '服务推荐', '1', '1', '1', '1', '30', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('71', '1', '服务推荐', '1', '1', '1', '1', '30', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('72', '1', '服务推荐', '1', '1', '1', '1', '30', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('73', '1', '服务推荐', '1', '1', '1', '1', '30', 'main', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('74', '8', '店铺招牌', '0', '0', '1', '0', '31', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('75', '3', '服务分类', '1', '1', '1', '1', '33', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('76', '2', '服务排行', '1', '1', '1', '1', '33', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('77', '11', '服务列表', '0', '0', '1', '0', '33', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('78', '6', '客服中心', '1', '1', '1', '1', '33', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('79', '1', '服务推荐', '1', '1', '1', '1', '33', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('80', '3', '服务分类', '1', '1', '1', '1', '36', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('81', '2', '服务排行', '1', '1', '1', '1', '36', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('82', '1', '服务推荐', '1', '1', '1', '1', '36', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('83', '12', '服务基础信息', '0', '0', '1', '0', '36', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('84', '13', '服务描述信息', '0', '0', '1', '0', '36', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('85', '6', '客服中心', '1', '1', '1', '1', '36', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('86', '8', '店铺招牌', '0', '0', '1', '0', '37', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('87', '2', '服务排行', '1', '1', '1', '1', '39', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('88', '6', '客服中心', '1', '1', '1', '1', '39', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('89', '3', '服务分类', '1', '1', '1', '1', '39', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('90', '1', '服务推荐', '1', '1', '1', '1', '39', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('91', '1', '服务推荐', '1', '1', '1', '1', '39', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('92', '1', '服务推荐', '1', '1', '1', '1', '39', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('93', '1', '服务推荐', '1', '1', '1', '1', '39', 'main', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('94', '8', '店铺招牌', '0', '0', '1', '0', '40', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('95', '3', '服务分类', '1', '1', '1', '1', '42', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('96', '2', '服务排行', '1', '1', '1', '1', '42', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('97', '11', '服务列表', '0', '0', '1', '0', '42', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('98', '6', '客服中心', '1', '1', '1', '1', '42', 'sub', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('99', '1', '服务推荐', '1', '1', '1', '1', '42', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('100', '3', '服务分类', '1', '1', '1', '1', '45', 'sub', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('101', '2', '服务排行', '1', '1', '1', '1', '45', 'sub', '3', null);
INSERT INTO `tshop_module_widget` VALUES ('102', '1', '服务推荐', '1', '1', '1', '1', '45', 'sub', '4', null);
INSERT INTO `tshop_module_widget` VALUES ('103', '12', '服务基础信息', '0', '0', '1', '0', '45', 'main', '1', null);
INSERT INTO `tshop_module_widget` VALUES ('104', '13', '服务描述信息', '0', '0', '1', '0', '45', 'main', '2', null);
INSERT INTO `tshop_module_widget` VALUES ('105', '6', '客服中心', '1', '1', '1', '1', '45', 'sub', '1', null);

-- ----------------------------
-- Table structure for tshop_page
-- ----------------------------
DROP TABLE IF EXISTS `tshop_page`;
CREATE TABLE `tshop_page` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) DEFAULT NULL,
  `site_instance_id` bigint(20) NOT NULL,
  `page_type` tinyint(4) NOT NULL,
  `page_name` varchar(50) NOT NULL,
  `hd_bgcolor` varchar(255) DEFAULT NULL,
  `hd_show_bgcolor` tinyint(1) DEFAULT NULL,
  `hd_bgimg` varchar(255) DEFAULT NULL,
  `bd_bgcolor` varchar(255) DEFAULT NULL,
  `bd_show_bgcolor` tinyint(1) DEFAULT NULL,
  `bd_bgimg` varchar(255) DEFAULT NULL,
  `custom_css` text,
  `max_layout` int(11) NOT NULL DEFAULT '1',
  `max_module` int(11) NOT NULL DEFAULT '40',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_page
-- ----------------------------
INSERT INTO `tshop_page` VALUES ('1', null, '1', '1', '旺铺首页', null, null, null, null, null, null, null, '5', '40');
INSERT INTO `tshop_page` VALUES ('2', null, '1', '2', '店内搜索页', null, null, null, null, null, null, null, '1', '40');
INSERT INTO `tshop_page` VALUES ('3', null, '1', '3', '服务详情页', null, null, null, null, null, null, null, '1', '40');
INSERT INTO `tshop_page` VALUES ('5', null, '2', '1', '旺铺首页', null, null, null, null, null, null, null, '5', '40');
INSERT INTO `tshop_page` VALUES ('6', null, '2', '2', '店内搜索页', null, null, null, null, null, null, null, '1', '40');
INSERT INTO `tshop_page` VALUES ('7', null, '2', '3', '服务详情页', null, null, null, null, null, null, null, '1', '40');
INSERT INTO `tshop_page` VALUES ('8', null, '3', '1', '旺铺首页', null, null, null, null, null, null, null, '5', '40');
INSERT INTO `tshop_page` VALUES ('9', null, '3', '2', '店内搜索页', null, null, null, null, null, null, null, '1', '40');
INSERT INTO `tshop_page` VALUES ('10', null, '3', '3', '服务详情页', null, null, null, null, null, null, null, '1', '40');
INSERT INTO `tshop_page` VALUES ('11', null, '4', '1', '旺铺首页', null, null, null, null, null, null, null, '5', '40');
INSERT INTO `tshop_page` VALUES ('12', null, '4', '2', '店内搜索页', null, null, null, null, null, null, null, '1', '40');
INSERT INTO `tshop_page` VALUES ('13', null, '4', '3', '服务详情页', null, null, null, null, null, null, null, '1', '40');

-- ----------------------------
-- Table structure for tshop_site_instance
-- ----------------------------
DROP TABLE IF EXISTS `tshop_site_instance`;
CREATE TABLE `tshop_site_instance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) NOT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  `temp_skin_id` bigint(20) DEFAULT NULL,
  `template_id` bigint(20) DEFAULT NULL,
  `type` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `template_id` (`template_id`),
  KEY `temp_skin_id` (`temp_skin_id`),
  CONSTRAINT `tshop_site_instance_ibfk_1` FOREIGN KEY (`template_id`) REFERENCES `tshop_template` (`id`),
  CONSTRAINT `tshop_site_instance_ibfk_2` FOREIGN KEY (`temp_skin_id`) REFERENCES `tshop_template_skin` (`skin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_site_instance
-- ----------------------------
INSERT INTO `tshop_site_instance` VALUES ('1', '1', '1', null, null, '0');
INSERT INTO `tshop_site_instance` VALUES ('2', '1', '1', '1', '1', '0');
INSERT INTO `tshop_site_instance` VALUES ('3', '1', '1', '4', '2', '0');
INSERT INTO `tshop_site_instance` VALUES ('4', '1', '1', '8', '3', '0');

-- ----------------------------
-- Table structure for tshop_template
-- ----------------------------
DROP TABLE IF EXISTS `tshop_template`;
CREATE TABLE `tshop_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `dead_line_time` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `type` tinyint(4) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `back_up_org_id` bigint(20) DEFAULT NULL,
  `back_up_name` varchar(50) DEFAULT NULL,
  `back_up_time` datetime DEFAULT NULL,
  `back_up_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_template
-- ----------------------------
INSERT INTO `tshop_template` VALUES ('1', '简约时尚官方模板', '检啦官方', '永久使用', '免费', '//gdp.alicdn.com/L1/142/1078206/assets/images/default-thumbnail.png', '2017-04-20 14:12:54', '1', '0', null, null, null, null);
INSERT INTO `tshop_template` VALUES ('2', '动感红官方模板', '检啦官方', '永久使用', '免费', 'https://gdp.alicdn.com/L1/142/1016304/assets/images/bigthumb.jpg', '2017-04-20 14:13:40', '1', '0', null, null, null, null);
INSERT INTO `tshop_template` VALUES ('3', '收费店铺官方模板', '检啦官方', '永久使用', '免费', '//gdp.alicdn.com/tps/i4/T1gonBXopbXXcllE.T-336-500.png', '2017-04-22 11:35:28', '1', '0', null, null, null, null);

-- ----------------------------
-- Table structure for tshop_template_skin
-- ----------------------------
DROP TABLE IF EXISTS `tshop_template_skin`;
CREATE TABLE `tshop_template_skin` (
  `skin_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_id` bigint(20) NOT NULL,
  `skin_color` varchar(255) DEFAULT NULL,
  `skin_name` varchar(255) NOT NULL,
  `skin_img_url` varchar(255) DEFAULT NULL,
  `css_paths` varchar(1023) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`skin_id`),
  KEY `template_id` (`template_id`),
  CONSTRAINT `tshop_template_skin_ibfk_1` FOREIGN KEY (`template_id`) REFERENCES `tshop_template` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_template_skin
-- ----------------------------
INSERT INTO `tshop_template_skin` VALUES ('1', '1', '#00ff09', '草绿色', '//gdp.alicdn.com/tps/i3/T1jG_GXnJmXXXmMqDm-70-70.png', '/index.css', '0');
INSERT INTO `tshop_template_skin` VALUES ('2', '1', '#f55dcc', '粉红色', '//gdp.alicdn.com/tps/i2/T1HXTEXeRoXXX1aRHm-72-72.jpg', '/index.css', '0');
INSERT INTO `tshop_template_skin` VALUES ('3', '1', '#5debf5', '天蓝色', '//gdp.alicdn.com/tps/i1/T1HpTKXj8kXXXmMqDm-70-70.png', '/index.css', '0');
INSERT INTO `tshop_template_skin` VALUES ('4', '2', '#d9ccbd', '黑白色', '//gdp.alicdn.com/tps/i3/T1EYfLXctcXXXmMqDm-70-70.png', '/index.css', '0');
INSERT INTO `tshop_template_skin` VALUES ('5', '2', '#3a72c7', '深蓝色', '//gdp.alicdn.com/tps/i1/T1Go.WFoNbXXXmMqDm-70-70.png', '/index.css', '0');
INSERT INTO `tshop_template_skin` VALUES ('6', '2', '#c73a3a', '深红色', '//gdp.alicdn.com/tps/i1/T1segPFk8fXXXmMqDm-70-70.png', '/index.css', '0');
INSERT INTO `tshop_template_skin` VALUES ('7', '1', '#41a314', '草原绿', null, '/caoyuanlv.css', '1');
INSERT INTO `tshop_template_skin` VALUES ('8', '3', '#ff961f', '橙色皮肤', null, '', '0');
INSERT INTO `tshop_template_skin` VALUES ('9', '3', '#1fceff', '蓝色皮肤', null, '/blue.css', '0');

-- ----------------------------
-- Table structure for tshop_temp_backup
-- ----------------------------
DROP TABLE IF EXISTS `tshop_temp_backup`;
CREATE TABLE `tshop_temp_backup` (
  `backup_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `backup_name` varchar(30) NOT NULL,
  `backup_desc` varchar(255) NOT NULL,
  `backup_time` datetime NOT NULL,
  `site_instance_id` bigint(20) NOT NULL,
  PRIMARY KEY (`backup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_temp_backup
-- ----------------------------

-- ----------------------------
-- Table structure for tshop_temp_site
-- ----------------------------
DROP TABLE IF EXISTS `tshop_temp_site`;
CREATE TABLE `tshop_temp_site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_id` bigint(20) NOT NULL,
  `site_instance_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `template_id` (`template_id`) USING BTREE,
  UNIQUE KEY `site_instance_id` (`site_instance_id`) USING BTREE,
  CONSTRAINT `tshop_temp_site_ibfk_1` FOREIGN KEY (`template_id`) REFERENCES `tshop_template` (`id`),
  CONSTRAINT `tshop_temp_site_ibfk_2` FOREIGN KEY (`site_instance_id`) REFERENCES `tshop_site_instance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tshop_temp_site
-- ----------------------------
INSERT INTO `tshop_temp_site` VALUES ('1', '1', '2');
INSERT INTO `tshop_temp_site` VALUES ('2', '2', '3');
INSERT INTO `tshop_temp_site` VALUES ('3', '3', '4');
