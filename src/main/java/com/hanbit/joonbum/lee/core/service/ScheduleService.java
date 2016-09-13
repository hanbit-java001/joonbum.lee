package com.hanbit.joonbum.lee.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hanbit.joonbum.lee.core.dao.ScheduleDAO;
import com.hanbit.joonbum.lee.core.vo.ScheduleVo;

public class ScheduleService {
	public int addSchedule(ScheduleVo schedule){
		ScheduleDAO scheduleDAO = new ScheduleDAO();

		return scheduleDAO.insertSchedule(schedule);
	}
	public int modifySchedule(ScheduleVo schedule){

		return 0;
	}
	public int removeSchedule(String Scheduleid){

		return 0;
	}
	public List<ScheduleVo> listSchdules(String StarDt, String endDt){

		return null;
	}

}
