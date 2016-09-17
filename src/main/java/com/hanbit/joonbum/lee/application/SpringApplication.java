package com.hanbit.joonbum.lee.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.joonbum.lee.core.service.SchedulerService;
import com.hanbit.joonbum.lee.core.vo.ScheduleVo;
import com.sun.org.apache.bcel.internal.util.ClassPath;

public class SpringApplication {

	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");

			ApplicationContext applicationContext = //ioc 컨테이너
					new ClassPathXmlApplicationContext("spring/applicationContext-core.xml",
							"spring/applicationContext-dao.xml");

			SchedulerService schedulerService = applicationContext.getBean(SchedulerService.class);

			ScheduleVo schedule = new ScheduleVo();
			schedule.setScheduleId(String.valueOf(System.currentTimeMillis()));
			schedule.setTitle("아점");
			schedule.setMemo("돈까스");
			schedule.setStartDt("20160917");
			schedule.setEndDt("20160918");

			int result = schedulerService.addSchedule(schedule);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
