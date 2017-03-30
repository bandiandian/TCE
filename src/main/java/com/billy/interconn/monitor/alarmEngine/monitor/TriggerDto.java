package com.billy.interconn.monitor.alarmEngine.monitor;

import lombok.Data;

import java.io.Serializable;

/**
 * 触发条件实体
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/13 15:29
 */
@Data
public class TriggerDto implements Serializable {

    /**
     * 次数
     */
    private int times;

    /**
     * 周期
     */
    private int period;

    /**
     * 时间单位，都是分钟,默认都是min，不用赋值
     */
    private String timeUnit;
}
