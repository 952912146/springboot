package com.mj.s.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L; 

	private Integer id;
	private String name;
	private Integer age;
	private Date birth;
	private String gradeNo;
	
	
	
	
	public Student() {
		super();
		System.out.println("_______________________________________类加载器："+Student.class.getClassLoader().getClass().getName());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", gradeNo=" + gradeNo
				+ "]";
	}
	
	
}
