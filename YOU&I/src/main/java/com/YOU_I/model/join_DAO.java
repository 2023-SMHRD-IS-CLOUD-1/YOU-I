package com.YOU_I.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.YOU_I.database.SqlSessionManager;

public class join_DAO {
	SqlSessionFactory factory = SqlSessionManager.getFactory();

	
	public int groupKing(join_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.insert("groupKing", dto);
		sqlSession.close();
		return row;
	}

}
