package com.YOU_I.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.YOU_I.database.SqlSessionManager;

public class Hobby_DAO {

	SqlSessionFactory factory = SqlSessionManager.getFactory();
	
	public List<Hobby_DTO> SelectAllHobbyName(){
		
		SqlSession sqlSession = factory.openSession();
		List<Hobby_DTO> result = sqlSession.selectList("SelectAllHobbyName");
		sqlSession.close();
		
		return result;
	}

		public List<Hobby_DTO> mypgCt() {

		SqlSession sqlSession = factory.openSession();
		List<Hobby_DTO> result = sqlSession.selectList("mypgCt1");
		sqlSession.close();

		return result;
	}

	
}
