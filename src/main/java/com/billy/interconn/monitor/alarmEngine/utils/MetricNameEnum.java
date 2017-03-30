package com.billy.interconn.monitor.alarmEngine.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * metric中文名字映射
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/21 16:31
 */
public class  MetricNameEnum {

private static Map<String,String> metricMap = new HashMap<String,String>();

    static {
        metricMap.put("qpm","每分钟请求数");
        metricMap.put("latency.median","调用耗时中位数");
        metricMap.put("latency.avg","调用耗时平均值");
        metricMap.put("latency.75","调用耗时75线");
        metricMap.put("latency.95","调用耗时95线");
        metricMap.put("latency.95","调用耗时95线");
        metricMap.put("latency.99","调用耗时99线");
        metricMap.put("error","每分钟错误数");
        metricMap.put("error","每分钟错误数");
        metricMap.put("error.rate","每分钟错误率");
    }

    public static final String  getChineseNameByMetric(String metric){
        return metricMap.get(metric);
    }


}
