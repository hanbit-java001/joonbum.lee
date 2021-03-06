package com.hanbit.joonbum.lee.core.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.joonbum.lee.core.vo.FileVO;

@Repository
public class FileDAO {

	@Autowired
	private SqlSession sqlSession;

	public int insertFile (FileVO file){
		return sqlSession.insert("file.insertFile", file);

	}

	public FileVO selectFile(String fileId){

		return sqlSession.selectOne("file.selectFile", fileId);
	}

}
