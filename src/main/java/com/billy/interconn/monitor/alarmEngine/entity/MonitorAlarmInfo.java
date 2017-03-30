package com.billy.interconn.monitor.alarmEngine.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 告警信息实体
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/10 16:34
 */
@Data
public class MonitorAlarmInfo {

    private  long id;
    private String userIds; //用户ids
    private String applicationId; //应用id
    private String applicationName;
    private String  groupIds; //告警组
    private String reason;
    private String alarmLvl;
    private Date createTime;
    private String appName; //应用名称



}
