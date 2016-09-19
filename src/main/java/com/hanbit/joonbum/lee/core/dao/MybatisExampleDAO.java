package com.hanbit.joonbum.lee.core.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisExampleDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(MybatisExampleDAO.class);

	@Autowired
	private SqlSession sqlSession;

	public void logSysdate(){
		Map result = sqlSession.selectOne("dual.selectSysdate"); // map : 키와 값으로 구성되있다.

		LOGGER.debug(result.toString());
	}

}
