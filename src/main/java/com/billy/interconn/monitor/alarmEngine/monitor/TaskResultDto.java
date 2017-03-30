package com.billy.interconn.monitor.alarmEngine.monitor;

import lombok.Data;

import java.io.Serializable;

/**
 *  一个线程执行完毕返回结果
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/13 14:54
 */
@Data
public class TaskResultDto implements Serializable {

    /**
     * 任务id
     */
    private long taskId;


    private String taskName;

    private int  strategyType; //1、dubbo;2、webapp;3、自定义custom



    /**
     * 结果
     */
    private Double currentResult;

    /**
     * 结果的时间戳字段[精确到毫秒]
     */
    private long timestamp;

}
