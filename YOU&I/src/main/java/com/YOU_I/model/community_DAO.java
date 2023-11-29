package com.YOU_I.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.YOU_I.database.SqlSessionManager;

public class community_DAO {
	SqlSessionFactory factory = SqlSessionManager.getFactory();

	public int commContent(community_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.insert("commContent", dto);
		sqlSession.close();
		return row;
	}

	
		
    }