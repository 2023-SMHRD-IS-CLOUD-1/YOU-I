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
	public int joinGroup(join_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.insert("joinGroup", dto);
		sqlSession.close();
		return row;
	}
	public List<join_DTO> getUserInfo(join_DTO dto) {
	    SqlSession sqlSession = factory.openSession();
	    List<join_DTO> users = sqlSession.selectList("getUserInfo",dto);
	    sqlSession.close();
	    return users;
	}
	public int acceptUser(join_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.update("acceptUser", dto);
		return row;
	}
	public int refuseUser(join_DTO dto) {
		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.delete("refuseUser", dto);
		return row;
	}

	public join_DTO findKing(join_DTO dto) {
		SqlSession sqlSession = factory.openSession();
		join_DTO result = sqlSession.selectOne("findKing", dto);

		sqlSession.close();
		return result;

	}
}
