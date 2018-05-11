package com.mj.s.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mj.s.springboot.entity.Student;
import com.mj.s.springboot.mapper.StudentMapper;
import com.mj.s.springboot.service.StudentServiceI;


@Service
@Transactional
public class StudentServiceImpl implements StudentServiceI {

	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Resource
	private StudentMapper studentMapper;
	
	
	@Override
	@Cacheable(value="getStu")
	public String getStr(String str) {
		return str;
	}
	
	@Override
	@Cacheable(value="getStu")
	public Student getStu(int id) {
		logger.info("从数据库获取！！！！！！！！！！！！！！！！！！！！！！！STUDENT:"+id);
		/*Object obj = redisTemplate.opsForValue().get("getStu"+id);
		if(obj==null){
			Student s = studentMapper.getStu(id);
			redisTemplate.opsForValue().set("getStu"+id,s);
			return s;
		}else{
			return (Student)obj;
		}*/
		
		return studentMapper.getStu(id);
	}

	@Override
	public void create(Student stu) {
		studentMapper.create(stu);
		//int i = 8/0;
	}

	@Override
	public void updateStu(Student stu) {
		studentMapper.updateStu(stu);
	}

	@Override
	public void deleteStu(int id) {
		studentMapper.deleteStu(id);
	}

	@Override
	public List<Student> getStus() {
		List<Student> list = studentMapper.getStus();
		return list;
	}

}
