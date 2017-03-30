package com.billy.interconn.monitor.alarmEngine.dao;

import com.billy.interconn.monitor.alarmEngine.entity.MonitorAlarmInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * TO-DO
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/10 16:46
 */
@Mapper
public interface MonitorAlarmInfoDAO {


    /**
     * 根据id查询一个实体
     * @param id
     * @return
     */
    @Select("SELECT id, application_id AS applicationId, application_name AS applicationName,group_ids AS groupIds,reason,alarm_lvl AS alarmLvl,create_time AS createTime,app_name AS appName"
            + " FROM monitor.monitor_alarm_info WHERE id=#{0};")
    public MonitorAlarmInfo getMonitorAlarmInoById(long id);

    /**
     * 插入一条记录
     * @param monitorAlarmInfo
     * @return
     */
    public long insertAlarmInfo(MonitorAlarmInfo monitorAlarmInfo);
}
