package com.billy.interconn.monitor.alarmEngine.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 接收到mq消息对应的实体
 * Author: bandd
 * Mailto:bandd@haier.com
 * On: 2017/3/8  15:36
 */
@Data
public class MessageDto implements Serializable {

    private String changeType;  //CREATE,UPDATE,DELETE
    private int[] taskIds;
    private int strategyType; ////1、dubbo;2、webapp;3、自定义
}
