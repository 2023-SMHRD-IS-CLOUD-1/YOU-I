package com.YOU_I.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.YOU_I.database.SqlSessionManager;

public class calendar_DAO {
	SqlSessionFactory factory = SqlSessionManager.getFactory();
	public int addSchedule(calendar_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.insert("addSchedule", dto);
		sqlSession.close();
		return row;
	}
}
