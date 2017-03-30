package com.billy.interconn.monitor.alarmEngine.service;

import com.billy.interconn.monitor.alarmEngine.entity.MonitorAlarmInfo;
import com.haier.adp.sla.service.SlaInterfaceService;
import com.billy.interconn.monitor.alarmEngine.dao.MonitorAlarmInfoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TO-DO
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/10 16:56
 */
@Service
public class MonitorAlarminfoService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MonitorAlarmInfoDAO monitorAlarmInfoDAO;




    public MonitorAlarmInfo getMonitorAlarmInoById(long id){
        return monitorAlarmInfoDAO.getMonitorAlarmInoById(id);
    }

    /**
     * 插入一条记录
     * @param monitorAlarmInfo
     * @return
     */
    public long insertAlarmInfo(MonitorAlarmInfo monitorAlarmInfo){
        long id = monitorAlarmInfoDAO.insertAlarmInfo(monitorAlarmInfo);
        return id;
    }



}
