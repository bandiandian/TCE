package com.billy.interconn.monitor.alarmEngine.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 频率对应的实体类
 * Author: bandd
 * Mailto:bandd@haier.com
 * On: 2017/3/24  10:15
 */
@Data
public class FrequencyDto implements Serializable {

    private int span;  //时间间隔 单位分钟

    private int times;  //次数
}
