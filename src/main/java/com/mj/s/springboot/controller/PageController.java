package com.mj.s.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/fl")
	public ModelAndView fl(){
		ModelAndView m = new ModelAndView();
		m.setViewName("a");
		m.addObject("user", "asjhdjashdjkjk");
		
		return m;
	}
}
