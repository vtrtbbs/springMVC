package com.springstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.domain.Country;
import com.springstudy.service.DemoService;

@Controller
public class HelloController {

	@Autowired
	DemoService demoService;

	@RequestMapping("/hello")
	public ModelAndView hello() {
		List<Country> list = demoService.selectPage(1, 2);
		System.out.println("==========" + list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("spring", "spring mvc");
		mv.setViewName("hello");
		return mv;
	}
}
