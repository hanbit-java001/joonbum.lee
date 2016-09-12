package com.hanbit.joonbum.lee.application;

import com.hanbit.joonbum.lee.core.service.ScheduleService;
import com.hanbit.joonbum.lee.core.vo.ScheduleVo;

public class SimpleApplication {
	public static void main(String[] args) {
		ScheduleService scheduleService = new ScheduleService();


		ScheduleVo schedule = new ScheduleVo();
		schedule.setScheduleId(String.valueOf(System.currentTimeMillis()));
		schedule.setTitle("점심");
		schedule.setMemo("메모");
		schedule.setStartDt("20160912");
		schedule.setEndDt("20160913");

		int result = scheduleService.addSchedule(schedule);

		System.out.println("결과 : " + result);

	}
}
