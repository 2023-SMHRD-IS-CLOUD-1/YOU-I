package com.YOU_I.database;

import java.io.IOException;
import java.io.InputStream;

// org.apache.ibatis >> package는 기본 패키지가 아니라, mybatis library에서 제공해주고 있는 패키지다!!!
// 만약에 import가 제대로 안된다면? mybatis lib이 잘가져와졌는 지 확인!!!
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {

	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "com/YOU_I/database/mybatis-config.xml";
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return sqlSessionFactory;
	}
}