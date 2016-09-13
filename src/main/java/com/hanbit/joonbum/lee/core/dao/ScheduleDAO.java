package com.hanbit.joonbum.lee.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.joonbum.lee.core.vo.ScheduleVo;

import oracle.net.aso.e;

public class ScheduleDAO extends AbstractDAO{


	public int insertSchedule(ScheduleVo schedule) {
		Connection connection = getConnection();
		String sql = "INSERT INTO SCHEDULE (SCHEDULE_ID, TITLE, MEMO, START_DT, END_DT) "
				+ " VALUES(?, ?, ?, ?, ?)";
		List params = new ArrayList();
		params.add(schedule.getScheduleId());
		params.add(schedule.getTitle());
		params.add(schedule.getMemo());
		params.add(schedule.getStartDt());
		params.add(schedule.getEndDt());
		int result = executeSql(connection, sql, params);
		closeConnection(connection);
		return result;

	}

	public int updateSchedule(ScheduleVo schedule){
		Connection connection = getConnection();

		String sql = "UPDATE SCHEDULE SET TITLE = ?, MEMO = ?, "
				+ "START_DT = ?, END_DT = ? "
				+ "WHERE SCHEDULE_ID = ?";

		List params = new ArrayList();
		params.add(schedule.getTitle());
		params.add(schedule.getMemo());
		params.add(schedule.getStartDt());
		params.add(schedule.getEndDt());
		params.add(schedule.getScheduleId());

		int result = executeSql(connection, sql, params);

		closeConnection(connection);

		return result;
	}

	public int deleteSchedule(String scheduleId){
		Connection connection = getConnection();

		String sql = "DELETE FROM SCHEDULE WHERE SCHEDULE_ID = ?";

		List params = new ArrayList();
		params.add(scheduleId);

		int result = executeSql(connection, sql, params);

		closeConnection(connection);

		return result;
	}

	public List<ScheduleVo> selectSchedules(String startDt, String endDt) {
		Connection connection = getConnection();

		String sql = "SELECT SCHEDULE_ID, TITLE, MEMO, "
				+ "START_DT, END_DT FROM SCHEDULE "
				+ "WHERE START_DT <= ? AND END_DT >= ? "
				+ "ORDER BY START_DT";

		List params = new ArrayList();
		params.add(endDt);
		params.add(startDt);

		List<ScheduleVo> result = new ArrayList<ScheduleVo>();

		try{
			PreparedStatement statement = connection.prepareStatement(sql);

			for(int i=0; i<params.size(); i++){
				statement.setObject(i+1, params.get(i));
			}

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()){
				ScheduleVo schedule = new ScheduleVo();

				schedule.setScheduleId(resultSet.getString("SCHEDULE_ID"));
				schedule.setTitle(resultSet.getString("TITLE"));
				schedule.setMemo(resultSet.getString("MEMO"));
				schedule.setStartDt(resultSet.getString("START_DT"));
				schedule.setEndDt(resultSet.getString("END_DT"));

				result.add(schedule);
			}

			resultSet.close();

		} catch(Exception e){
			e.printStackTrace();
		}


		closeConnection(connection);

		return result;
	}

	public ScheduleVo selectSchedule(String scheduleId) {
		Connection connection = getConnection();

		String sql = "SELECT SCHEDULE_ID, TITLE, MEMO, "
				+ "START_DT, END_DT FROM SCHEDULE "
				+ "WHERE SCHEDULE_ID = ?";

		List params = new ArrayList();
		params.add(scheduleId);

		ScheduleVo schedule = null;

		try{
			PreparedStatement statement = connection.prepareStatement(sql);

			for(int i=0; i<params.size(); i++){
				statement.setObject(i+1, params.get(i));
			}

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()){
				schedule = new ScheduleVo();

				schedule.setScheduleId(resultSet.getString("SCHEDULE_ID"));
				schedule.setTitle(resultSet.getString("TITLE"));
				schedule.setMemo(resultSet.getString("MEMO"));
				schedule.setStartDt(resultSet.getString("START_DT"));
				schedule.setEndDt(resultSet.getString("END_DT"));

			}

			resultSet.close();
		} catch(Exception e){
			e.printStackTrace();
		}


		closeConnection(connection);

		return schedule;
	}

}










