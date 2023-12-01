package com.YOU_I.model;

import java.util.List;

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
	
	public List<Group_DTO> rank() {
		SqlSession sqlSession = factory.openSession();
		List<Group_DTO> gr_dto1 = sqlSession.selectList("rank");
		sqlSession.close();
		return gr_dto1;

	}

	public List<Group_DTO> rankCt(Group_DTO gr_dto) {
		SqlSession sqlSession = factory.openSession();
		System.out.println("rankCt DAO 에서 확인" + gr_dto);
		List<Group_DTO> gr_dto2 = sqlSession.selectList("rankCt",gr_dto);
		System.out.println(gr_dto2);
		sqlSession.close();
		return gr_dto2;

	}
	public List<Group_DTO> searchGroup(Group_DTO dto){
		SqlSession sqlSession = factory.openSession();
		List<Group_DTO> groupList = sqlSession.selectList("searchGroup",dto);
		sqlSession.close();
		return groupList;
	}

}
