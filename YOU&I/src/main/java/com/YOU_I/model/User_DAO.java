package com.YOU_I.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.YOU_I.database.SqlSessionManager;

public class User_DAO {
	
	SqlSessionFactory factory = SqlSessionManager.getFactory();
	
	public int user_Join(User_DTO dto) {
		
		SqlSession sqlSession = factory.openSession(true);
		
		int result = sqlSession.insert("user_join", dto);
		sqlSession.close();
		
		return result;
	}
	
	public User_DTO user_Login(User_DTO dto) {
		
		User_DTO result = null;
		
		SqlSession sqlSession = factory.openSession();
		
		result = (User_DTO)sqlSession.selectOne("user_login", dto);
		sqlSession.close();
		
		return result;
	}
	public int update(User_DTO dto) {

		SqlSession sqlSession = factory.openSession(true);
		int row = sqlSession.update("update", dto);
		sqlSession.close();
		return row;
	}
	
	public User_DTO userMypg(User_DTO dto) {
		
		User_DTO result = null;
		
		SqlSession sqlSession = factory.openSession();
		
		result = sqlSession.selectOne("userMypg", dto);
		String temp = result.getProfileImg();
		String resultTemp = temp.substring(8);
		result.setProfileImg(resultTemp);
		sqlSession.close();
		
		return result;
	}
	
	public int unregister(User_DTO dto) {
		
		SqlSession sqlSession = factory.openSession(true);
		
		int res = sqlSession.delete("unregister", dto);
		sqlSession.close();
		return res;
		
	}
	
	public List<User_DTO> member(Group_DTO dto) {
		
		
		SqlSession sqlSession = factory.openSession();
		
		List<User_DTO> result = sqlSession.selectList("memberInfo", dto);
		sqlSession.close();
		
		return result;
	}
	
	
}


