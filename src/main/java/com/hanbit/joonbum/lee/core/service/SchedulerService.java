package com.hanbit.joonbum.lee.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.joonbum.lee.core.dao.ScheduleDAO;
import com.hanbit.joonbum.lee.core.vo.ScheduleVo;

@Service
public class SchedulerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerService.class);

	@Autowired
	private ScheduleDAO scheduleDAO;

	public void setScheduleDAO(ScheduleDAO scheduleDAO){
		this.scheduleDAO=scheduleDAO;
	}

	public int addSchedule(ScheduleVo schedule){
		LOGGER.debug("스케줄 추가");
		return scheduleDAO.insertSchedule(schedule);
	}

	public int modifySchedule(ScheduleVo schedule){

		return scheduleDAO.updateSchedule(schedule);
	}

	public int removeSchedule(String scheduleId){

		return scheduleDAO.deleteSchedule(scheduleId);
	}

	public List<ScheduleVo> listSchdules(String starDt, String endDt){

		return scheduleDAO.selectSchedules(starDt, endDt);
	}

	public ScheduleVo getSchedule(String scheduleId){
		return scheduleDAO.selectSchedule(scheduleId);
	}

}
