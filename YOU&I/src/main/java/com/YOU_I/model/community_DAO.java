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

	public List<community_DTO> selectAll(community_DTO dto) {

		SqlSession sqlSession = factory.openSession(true);
		List<community_DTO> resultList = sqlSession.selectList("selectAll", dto);
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

	public int likes(community_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.update("likes", dto);
		sqlSession.close();
		return row;
	}

	public int GetlastCommNo() {

		SqlSession sqlSession = factory.openSession();
		community_DTO c_dto = sqlSession.selectOne("GetlastCommNo");
		int result = c_dto.getComm_no();
		sqlSession.close();

		return result;
	}

}