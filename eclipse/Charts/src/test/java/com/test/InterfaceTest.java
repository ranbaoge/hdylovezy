package com.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookDao;

public class InterfaceTest {

	private ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
	private BookDao bookDao;
	
	@Test
	public void test1(){
		bookDao=(BookDao) app.getBean("bookDao");
		List<Map<String, Object>> list=bookDao.countType();
		for (Map<String, Object> map : list) {
			Long count= (Long) map.get("count(1)");
			String c_name=(String) map.get("c_name");
			System.out.println(count+"\t"+c_name);
			
		}
	}
	
}
