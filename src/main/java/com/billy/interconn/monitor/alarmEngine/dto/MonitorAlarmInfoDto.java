package com.billy.interconn.monitor.alarmEngine.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 发送给告警实体的mq消息对象
 * Author: bandd
 * Mailto:bandd@haier.com
 * On: 2017/3/7  11:16
 */
@Data
public class MonitorAlarmInfoDto implements Serializable {

    private  long id;
    private List<Object>  userIds; //用户id数组
    private String applicationName;
    private List<Object>  groupIds; //告警组
    private String reason;
    private String alarmLvl;
    private long createTime;


//    {
//        "id": 124,
//            "userIds": ["01431003","01431001","01431002"],
//        "applicationName": "PDM研发数据管理系统",
//            "groupIds": ["11","14","17"],
//        "reason": "哪个应用，哪个方法，访问量超标",
//            "alarmLvl": "critical",
//            "createTime": 1486361397091
//    }


}
