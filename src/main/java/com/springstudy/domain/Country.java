package com.springstudy.domain;

import org.apache.ibatis.type.Alias;


public class Country {
	private String name;
	private String abbr;
	public Country() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
}
