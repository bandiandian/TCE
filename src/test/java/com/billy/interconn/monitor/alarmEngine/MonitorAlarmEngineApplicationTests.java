package com.billy.interconn.monitor.alarmEngine;

import com.billy.interconn.monitor.alarmEngine.entity.MonitorAlarmInfo;
import com.billy.interconn.monitor.alarmEngine.service.MonitorAlarminfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MonitorAlarmEngineApplication.class)
public class MonitorAlarmEngineApplicationTests {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	protected MonitorAlarminfoService monitorAlarminfoService;




	@Test
	public void contextLoads() {
		logger.debug("fsfsfs_debug");
		logger.info("fsfsfs_info");
	}




	@Test
	public void dbTest(){
		MonitorAlarmInfo monitorAlarmInfo = new MonitorAlarmInfo();
		monitorAlarmInfo.setApplicationId("S00002");
		monitorAlarmInfo.setApplicationName("PDM研发数据管理系统");

		monitorAlarmInfo.setGroupIds("11,12,14");
		monitorAlarmInfo.setReason("系统访问量超标");
		monitorAlarmInfo.setAlarmLvl("critical");
		monitorAlarmInfo.setAppName("应用名称");
		this.monitorAlarminfoService.insertAlarmInfo(monitorAlarmInfo);
		long id = monitorAlarmInfo.getId();
		System.out.println("id:"+id);
		Assert.assertTrue(id>0);
		MonitorAlarmInfo monitorAlarmInfo1 = this.monitorAlarminfoService.getMonitorAlarmInoById(id);
		Assert.assertTrue(null!=monitorAlarmInfo1);
		logger.info(monitorAlarmInfo1.getApplicationId());
		logger.info(monitorAlarmInfo1.getApplicationName());
		logger.info(monitorAlarmInfo1.getAlarmLvl());
		logger.info(monitorAlarmInfo1.getGroupIds());
		logger.info(monitorAlarmInfo1.getReason());
		logger.info(monitorAlarmInfo1.getAppName());
	}





	@Test
	public void  ArrayToString(){
		int[] taskArray ={};
		StringBuilder taskids = new StringBuilder();
		for(int i=0;i<taskArray.length;i++){
			taskids.append(taskArray[i]).append(",");

		}

		logger.info("taskids:"+taskids.toString());

	}
}

