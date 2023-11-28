package com.YOU_I.model;

import java.util.List;

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
	public List<calendar_DTO> getSchedules() {
	    SqlSession sqlSession = factory.openSession(true);
	    List<calendar_DTO> schedules = sqlSession.selectList("getSchedules");
	    sqlSession.close();
	    System.out.println(schedules);
	    return schedules;
	}
}
