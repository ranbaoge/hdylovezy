package com.example;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.TeacherDao;
import com.entity.Teacher;

/**
 * @author huangdaye
 *使用slf4j配置springboot打印日志信息
 */
@RestController
public class Example {
 
	private static Logger logger=LoggerFactory.getLogger(Example.class);
	@Autowired
	private TeacherDao teacheDao;
	
	@RequestMapping("/")
	public String home(){
		logger.debug("访问home");
		List<Teacher> list=teacheDao.queryAll();
		for (Teacher t : list) {
			logger.info(t.toString());
		}
		return "hello world";
	}
	
	@RequestMapping("hello/{name}")
	public String index(@PathVariable String name){
		logger.debug("访问index,参数name="+name);
		return "hello"+name;
	}
}
