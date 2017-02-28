package com.springstudy.mapper;

import java.util.List;

import com.springstudy.domain.Country;

public interface CountryMapper {
	
	List<Country> select();
	
	int insert(Country country);
}
