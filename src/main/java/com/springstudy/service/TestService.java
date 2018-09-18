package com.springstudy.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.domain.Country;
import com.springstudy.mapper.CountryMapper;

@Service
public class TestService {
	@Autowired
    protected SqlSession sqlSessionMaster;
	
	@Autowired
    protected SqlSession sqlSessionSlave;
	
	
	public List<Country> list() {
		CountryMapper mapper = sqlSessionSlave.getMapper(CountryMapper.class);
		List<Country> list = mapper.select();		
		return list;
	}	
}
