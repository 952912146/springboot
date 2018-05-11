package com.mj.s.springboot.service;

import java.util.List;

import com.mj.s.springboot.entity.Student;

public interface StudentServiceI {
	
	public String getStr(String str);
	public Student getStu(int id);
	public void create(Student stu);
	public void updateStu(Student stu);
	public void deleteStu(int id);
	public List<Student> getStus();
}
