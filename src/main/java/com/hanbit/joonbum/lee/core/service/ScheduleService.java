package com.hanbit.joonbum.lee.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hanbit.joonbum.lee.core.vo.ScheduleVo;

public class ScheduleService {
	public int addSchedule(ScheduleVo schedule){
		String url = "jdbc:oracle:thin:@127.0.0.1/xe";
		String user = "hanbit";
		String password = "hanbit";

		String sql = "INSERT INTO SCHEDULE (SCHEDULE_ID, TITLE, MEMO, START_DT, END_DT) "
				+ " VALUES('" + schedule.getScheduleId() + "', "
				+ "'" + schedule.getTitle() + "', "
				+ "'" + schedule.getMemo() + "', "
				+ "'" + schedule.getStartDt() + "', "
				+ "'" + schedule.getEndDt() + "')";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection(url, user, password);

			Statement statement = connection.createStatement();
			result = statement.executeUpdate(sql);

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

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
