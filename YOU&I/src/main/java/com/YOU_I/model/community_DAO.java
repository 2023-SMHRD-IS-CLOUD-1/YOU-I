package com.YOU_I.model;

import java.util.List;

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

	public List<community_DTO> selectAll() {

		SqlSession sqlSession = factory.openSession(true);
		List<community_DTO> resultList = sqlSession.selectList("selectAll");
		sqlSession.close();
		return resultList;
	}
	public int comment(community_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.insert("comment", dto);
		sqlSession.close();
		return row;
	}
	public List<community_DTO> selectComment() {

		SqlSession sqlSession = factory.openSession(true);
		List<community_DTO> selectComment = sqlSession.selectList("selectComment");
		sqlSession.close();
		return selectComment;
	}
	
	

}