package com.mj.s.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * 设置为全局异常捕获
 * @author Administrator
 *
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ResponseBody
	@ExceptionHandler(value=RuntimeException.class)
	public Map<String,Object> Exception500(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 500);
		map.put("msg", "5xx类错误");
		
		return map;
		
	}
	
	@ResponseBody
	@ExceptionHandler(value=NoHandlerFoundException.class)
	public Map<String,Object> Exception404(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", 404);
		map.put("msg", "4xx类错误");
		
		return map;
		
	}
}
