package com.billy.interconn.monitor.alarmEngine.monitor;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 解析出来的task实体类，包含task的基础信息和条件以及临时保存的结果
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/9 16:08
 */
@Data
public class TaskDto implements Serializable{

    public TaskDto(String taskName){
        this.taskName = taskName;
    }

    public TaskDto(){};

    /**
     * 任务id；
     */
    private long taskId;

    /**
     * 任务名称,对应description字段
     */
    private String taskName;

    private int  strategyType; //1、dubbo;2、webapp;3、自定义custom

    private String description; //描述

    private String groupIds; //告警组ids

    private String userIds; //用户ids,额外通知用户

    private String level; //告警等级

    private int domainId; //domainId

    private String project; //项目名称

    private String app; //应用名称


    private String metric; //

    private String operator; //大于 小于  gt或者lt

    private int value;

    private String frequency;

    private int status;//生效字段 1生效, 0不生效


    //dubbo类型的告警策略字段

    private String service; //服务名

    private String method; //方法名

    //webapp类型的告警策略字段
    private String uri;





    /**
     * 缓存结果
     */
    private List<TaskResultDto> cachedValues;

    /**
     * trigger条件
     */
    private TriggerDto triggerDto;

    /**
     * 消息类型 create update delete
     */
    private String type;



    private int counter=0;
}
