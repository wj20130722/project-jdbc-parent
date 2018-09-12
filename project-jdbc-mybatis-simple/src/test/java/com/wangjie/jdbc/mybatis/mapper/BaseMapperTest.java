package com.wangjie.jdbc.mybatis.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**
 * 基础测试类
 */
public class BaseMapperTest {
	private static SqlSessionFactory sqlSessionFactory;

	private static final String MYBATIC_CONFIG_PATH  = "mybatis-config.xml";

	@BeforeClass
	public static void init(){
		try {
			Reader reader = Resources.getResourceAsReader(MYBATIC_CONFIG_PATH);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}

	public static void close(){
		if(sqlSessionFactory!=null)
			sqlSessionFactory = null;
	}
	
}
