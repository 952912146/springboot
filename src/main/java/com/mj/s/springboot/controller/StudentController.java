package com.mj.s.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.s.springboot.entity.Student;
import com.mj.s.springboot.service.StudentServiceI;

@RestController("/stu")
@PropertySource("classpath:stu.properties")
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentServiceI studentServiceI;
	@Autowired 
	private HttpServletRequest request;
	
	@Value("${stu.name2}")
	private String str;
	
	@RequestMapping("/hello")
	public String hello(){
		return str;
	}
	
	@RequestMapping("/create")
	public Student create(Student stu){
		studentServiceI.create(stu);
		return stu;
	}
	
	@RequestMapping("/getStu")
	public Student getStu(int id){
		return studentServiceI.getStu(id);
	}
	
	@RequestMapping("/updateStu")
	public Student updateStu(Student stu){
		studentServiceI.updateStu(stu);
		return stu;
	}
	
	@RequestMapping("/deleteStu")
	public void deleteStu(int id){
		studentServiceI.deleteStu(id);
	}
	
	@RequestMapping("/getStus")
	public List<Student> getStus(){
		return studentServiceI.getStus();
	}
	
	
}
