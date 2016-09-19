package com.hanbit.joonbum.lee.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.joonbum.lee.core.vo.ScheduleVo;

@Repository
public class ScheduleDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleDAO.class);

	@Autowired private SqlSession sqlSession;

	public int insertSchedule(ScheduleVo schedule) {

		LOGGER.debug("인서트 스케줄");

		int result = sqlSession.insert("schedule.insetSchedule", schedule);

		return result;

	}

	public int updateSchedule(ScheduleVo schedule){

		int result = sqlSession.update("schedule.updateSchedule", schedule);

		return result;
	}

	public int deleteSchedule(String scheduleId){
		int result = sqlSession.delete("schedule.deleteSchedule", scheduleId);

		return result;
	}

	public List<ScheduleVo> selectSchedules(String startDt, String endDt) {
		Map params = new HashMap();
		params.put("startDt", startDt);
		params.put("endDt", endDt);

		List<ScheduleVo> result = sqlSession.selectList("schedule.selectSchedules", params);

		return result;
	}

	public ScheduleVo selectSchedule(String scheduleId) {

		ScheduleVo schedule = sqlSession.selectOne("schedule.selectSchedule", scheduleId);

		return schedule;
	}

}










