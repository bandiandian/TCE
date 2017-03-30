/*
Navicat MySQL Data Transfer

Source Server         : 63
Source Server Version : 50550
Source Host           : 10.138.8.63:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-03-30 16:26:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for console_alarm_strategy_customermetric
-- ----------------------------
DROP TABLE IF EXISTS `console_alarm_strategy_customermetric`;
CREATE TABLE `console_alarm_strategy_customermetric` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strategyType` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `groupIds` varchar(255) DEFAULT NULL,
  `userIds` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `domainId` int(11) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `customerMetricId` int(11) DEFAULT NULL,
  `metric` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  `lastEditId` varchar(255) NOT NULL COMMENT '最后修改人Id',
  `lastEditName` varchar(255) NOT NULL COMMENT '最后修改人Name',
  `lastEditTime` datetime NOT NULL COMMENT '最后修改时间',
  `createId` varchar(255) NOT NULL,
  `createName` varchar(255) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `deleteFlag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for console_alarm_strategy_dubbo
-- ----------------------------
DROP TABLE IF EXISTS `console_alarm_strategy_dubbo`;
CREATE TABLE `console_alarm_strategy_dubbo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strategyType` int(11) DEFAULT NULL COMMENT '1、dubbo;2、webapp;3、自定义',
  `description` varchar(255) DEFAULT NULL,
  `groupIds` varchar(255) DEFAULT NULL COMMENT '告警组：智能制造',
  `userIds` varchar(255) DEFAULT NULL COMMENT '额外通知用户',
  `level` varchar(255) DEFAULT NULL COMMENT '告警级别：严重',
  `status` int(11) DEFAULT NULL COMMENT '是否生效：1、生效；0、不生效；',
  `domainId` int(11) DEFAULT NULL COMMENT '智能制造',
  `project` varchar(255) DEFAULT NULL COMMENT 'monitor',
  `app` varchar(255) DEFAULT NULL COMMENT 'webapp1',
  `service` varchar(255) DEFAULT NULL COMMENT '服务',
  `method` varchar(255) DEFAULT NULL COMMENT '方法',
  `metric` varchar(255) DEFAULT NULL COMMENT 'error.times',
  `operator` varchar(255) DEFAULT NULL,
  `value` int(255) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL COMMENT '没有结果 存null',
  `lastEditId` varchar(255) NOT NULL COMMENT '最后修改人',
  `lastEditName` varchar(255) NOT NULL,
  `lastEditTime` datetime NOT NULL COMMENT '最后修改时间',
  `createId` varchar(255) NOT NULL,
  `createName` varchar(255) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL,
  `deleteFlag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for console_alarm_strategy_webapp
-- ----------------------------
DROP TABLE IF EXISTS `console_alarm_strategy_webapp`;
CREATE TABLE `console_alarm_strategy_webapp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strategyType` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `groupIds` varchar(255) DEFAULT NULL,
  `userIds` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `domainId` int(11) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `app` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `metric` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `value` int(11) DEFAULT '1',
  `frequency` varchar(255) DEFAULT NULL,
  `lastEditId` varchar(255) NOT NULL COMMENT '最后修改人',
  `lastEditName` varchar(255) NOT NULL,
  `lastEditTime` datetime NOT NULL COMMENT '最后修改时间',
  `createId` varchar(255) NOT NULL,
  `createName` varchar(255) NOT NULL DEFAULT '' COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `deleteFlag` int(11) NOT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for console_customer_metrics
-- ----------------------------
DROP TABLE IF EXISTS `console_customer_metrics`;
CREATE TABLE `console_customer_metrics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domainId` varchar(255) DEFAULT NULL COMMENT '领域：infus',
  `project` varchar(255) DEFAULT NULL COMMENT '项目',
  `metricType` int(11) DEFAULT NULL COMMENT '逻辑类别：{1:''计数器'',2:''计时器'',3:''瞬时值''}',
  `metricName` varchar(255) NOT NULL COMMENT '监控指标名称',
  `description` varchar(255) DEFAULT NULL COMMENT '备注',
  `lastEditId` varchar(255) NOT NULL COMMENT '最后修改人',
  `lastEditName` varchar(255) NOT NULL,
  `lastEditTime` datetime NOT NULL COMMENT '最后修改时间',
  `createId` varchar(255) NOT NULL,
  `createName` varchar(255) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `deleteFlag` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `metricName` (`metricName`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for console_customer_view
-- ----------------------------
DROP TABLE IF EXISTS `console_customer_view`;
CREATE TABLE `console_customer_view` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `viewName` varchar(255) DEFAULT NULL,
  `isPublic` varchar(255) DEFAULT NULL,
  `lastEditId` varchar(255) NOT NULL,
  `lastEditName` varchar(255) NOT NULL,
  `lastEditTime` datetime NOT NULL,
  `createId` varchar(255) NOT NULL,
  `createName` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `deleteFlag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for console_customer_view_config
-- ----------------------------
DROP TABLE IF EXISTS `console_customer_view_config`;
CREATE TABLE `console_customer_view_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `viewId` int(11) DEFAULT NULL,
  `configType` int(11) DEFAULT NULL,
  `configName` varchar(255) DEFAULT NULL,
  `viewPath` varchar(255) DEFAULT NULL,
  `lastEditId` varchar(255) NOT NULL,
  `lastEditName` varchar(255) NOT NULL,
  `lastEditTime` datetime NOT NULL,
  `createId` varchar(255) NOT NULL,
  `createName` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  `deleteFlag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dubbo_app_relation
-- ----------------------------
DROP TABLE IF EXISTS `dubbo_app_relation`;
CREATE TABLE `dubbo_app_relation` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(128) DEFAULT NULL COMMENT 'dubbo应用名',
  `interface_name` varchar(512) DEFAULT NULL COMMENT 'dubbo服务名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  UNIQUE KEY `primary_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2365 DEFAULT CHARSET=utf8 COMMENT='保存zk的应用和服务的对应关系表';

-- ----------------------------
-- Table structure for monitor_alarm_info
-- ----------------------------
DROP TABLE IF EXISTS `monitor_alarm_info`;
CREATE TABLE `monitor_alarm_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `application_id` varchar(10) DEFAULT NULL COMMENT '应用id',
  `application_name` varchar(255) DEFAULT NULL,
  `user_ids` varchar(128) DEFAULT NULL COMMENT ' 用户ids',
  `group_ids` varchar(128) DEFAULT '告警组id,多个用逗号区分',
  `reason` varchar(1024) DEFAULT NULL COMMENT '告警信息',
  `alarm_lvl` varchar(64) DEFAULT NULL COMMENT '告警等级',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `app_name` varchar(50) DEFAULT NULL COMMENT '应用名称',
  UNIQUE KEY `primarykey` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4308 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for notify_group
-- ----------------------------
DROP TABLE IF EXISTS `notify_group`;
CREATE TABLE `notify_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) DEFAULT NULL COMMENT '告警组名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL COMMENT '是否有效 1：有效 ；0：无效',
  `demo` varchar(300) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_id` (`id`) USING BTREE,
  KEY `s_id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for notify_group_alarmtype
-- ----------------------------
DROP TABLE IF EXISTS `notify_group_alarmtype`;
CREATE TABLE `notify_group_alarmtype` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) DEFAULT NULL COMMENT '告警组id',
  `alam_type` varchar(10) DEFAULT NULL COMMENT '1.短信2.邮件3.IHaier 4.POP',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL COMMENT '是否有效 1：有效 ；0：无效',
  `demo` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_id` (`id`) USING BTREE,
  KEY `s_id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for notify_group_user
-- ----------------------------
DROP TABLE IF EXISTS `notify_group_user`;
CREATE TABLE `notify_group_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL COMMENT '告警组id',
  `group_id` bigint(20) DEFAULT NULL COMMENT '告警组id',
  `type` varchar(2) DEFAULT NULL COMMENT '1：普通成员 2：告警组管理员',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL COMMENT '是否有效 1：有效 ；0：无效',
  `demo` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
