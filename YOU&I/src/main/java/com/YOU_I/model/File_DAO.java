package com.YOU_I.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.YOU_I.database.SqlSessionManager;

public class File_DAO {

	SqlSessionFactory factory = SqlSessionManager.getFactory();
		
	public int fileUpload(File_DTO f_dto) {
		SqlSession sqlSession = factory.openSession(true);
		
		int result = sqlSession.insert("fileUpload",f_dto);
		sqlSession.close();
		System.out.println(result + "2");
		return result;
	}
public File_DTO GroupImageTake(String data){
		
		SqlSession sqlSession = factory.openSession();
		System.out.println(data);
		try {
		File_DTO result = (File_DTO)sqlSession.selectOne("GroupImageTake",data);
		sqlSession.close();
		System.out.println(result.getFileNo() + "결과값");
		return result;
		}
		catch (Exception e) {
			// TODO: handle exception
			
			return null;
		}
	}
}
