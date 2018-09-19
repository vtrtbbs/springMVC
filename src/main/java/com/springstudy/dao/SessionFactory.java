package com.springstudy.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	
	private static  SqlSessionFactory sqlSessionFactory; 
	
	private static ConcurrentHashMap<String, SqlSessionFactory> map = new ConcurrentHashMap<String, SqlSessionFactory>();
	
	private SessionFactory(){
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory(String source) {
		sqlSessionFactory = map.get(source);
		if (sqlSessionFactory==null) {
			InputStream inputStream;   
            try{   
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");   
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                map.put(source, sqlSessionFactory);
            }catch (IOException e){   
                throw new RuntimeException(e.getCause());   
          }   
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession(String source){   
	     return getSqlSessionFactory(source).openSession();   
	} 
}
