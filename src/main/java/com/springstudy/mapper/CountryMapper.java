package com.springstudy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springstudy.domain.Country;

public interface CountryMapper {
	
	List<Country> select();
	
	int insert(Country country);
	
	List<Country> list(@Param("name") String name);
}
