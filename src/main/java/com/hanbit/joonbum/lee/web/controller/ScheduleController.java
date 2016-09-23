package com.hanbit.joonbum.lee.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.joonbum.lee.core.service.SchedulerService;
import com.hanbit.joonbum.lee.core.vo.ScheduleVO;

@Controller
public class ScheduleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private SchedulerService schedulerService;

	@RequestMapping("/schedule/list")
	public String list(){
		return "schedule/list";
	}

	@RequestMapping("/api/schedule/list")
	@ResponseBody
	public List<ScheduleVO> listSchedules(@RequestParam("startDt") String startDt,
			@RequestParam("endDt") String endDt){

		List<ScheduleVO> result = schedulerService.listSchedules(startDt, endDt);

		return result;
	}

	@RequestMapping("/api/schedule/add")
	@ResponseBody
	public ScheduleVO addSchedule(@RequestBody ScheduleVO schedule) {

		String scheduleId = schedulerService.generateId();
		schedule.setScheduleId(scheduleId);

		int countAdded = schedulerService.addSchedule(schedule);

		if (countAdded == 0) {
			throw new RuntimeException();
		}

		return schedule;
	}
	@RequestMapping("/api/schedule/countSchedule")
	@ResponseBody
	public Map countSchedule(@RequestParam("startDt") String startDt,
			@RequestParam("endDt") String endDt) {

		int eventCount = schedulerService.countSchedule(startDt, endDt);

		Map result = new HashMap();

		result.put("eventCount", eventCount);

		return result;
	}
}
