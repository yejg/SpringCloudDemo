package com.ye.app.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private Environment env;
	
	// @Scheduled(fixedRate = 5000)
	@Scheduled(fixedRateString = "${scheduled.fixedRate:5000}") //默认值5秒
	public void scheduledDemo() {
		logger.info("-----------"+ env.getProperty("scheduled.fixedRate") +"-----------");// null
		logger.info("scheduled - fixedRate - print time every 2 seconds:{}", formate.format(new Date()));
	}

	/**
	 * "0/5 * *  * * ?" 每5秒触发
	 * "0 0 12 * * ?" 每天中午十二点触发
	 * "0 15 10 ? * *" 每天早上10：15触发
	 * "0 15 10 * * ?" 每天早上10：15触发
	 * "0 15 10 * * ? *" 每天早上10：15触发
	 * "0 15 10 * * ? 2005" 2005年的每天早上10：15触发
	 * "0 * 14 * * ?" 每天从下午2点开始到2点59分每分钟一次触发
	 * "0 0/5 14 * * ?" 每天从下午2点开始到2：55分结束每5分钟一次触发
	 * "0 0/5 14,18 * * ?" 每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
	 * "0 0-5 14 * * ?" 每天14:00至14:05每分钟一次触发
	 * "0 10,44 14 ? 3 WED" 三月的每周三的14：10和14：44触发
	 * "0 15 10 ? * MON-FRI" 每个周一、周二、周三、周四、周五的10：15触发
	 */
	// @Scheduled(cron = "0/10 * *  * * ?")
	@Scheduled(cron = "${scheduled.cron}")
	public void scheduledCronDemo() {
		logger.info("=============="+ env.getProperty("scheduled.cron") +"=============");
		logger.info("scheduled - cron - print time every 10 seconds:{}", formate.format(new Date()));
	}
}
