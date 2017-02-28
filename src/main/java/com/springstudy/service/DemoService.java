package com.springstudy.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.springstudy.domain.Country;
import com.springstudy.mapper.CountryMapper;

@Service
public class DemoService {
	
	private CountryMapper writeMapper;
	private CountryMapper readMapper;

    @Resource(name = "sqlSessionMaster")
    public void setWriteMapper(SqlSession sqlSession) {
        this.writeMapper = sqlSession.getMapper(CountryMapper.class);
    }
    @Resource(name = "sqlSessionSlave")
    public void setReadMapper(SqlSession sqlSession) {
        this.readMapper = sqlSession.getMapper(CountryMapper.class);
    }

    public int save(Country country){
        return writeMapper.insert(country);
    }

    public List<Country> selectPage(int pageNum, int pageSize) {
            return readMapper.select();
    }
}
