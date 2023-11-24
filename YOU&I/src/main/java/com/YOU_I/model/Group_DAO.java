package com.YOU_I.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.YOU_I.database.SqlSessionManager;

public class Group_DAO {
	SqlSessionFactory factory = SqlSessionManager.getFactory();

	public int addGroup(Group_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.insert("addGroup", dto);
		sqlSession.close();
		return row;
	}
}
