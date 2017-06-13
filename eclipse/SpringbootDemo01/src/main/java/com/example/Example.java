package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangdaye
 *使用slf4j配置springboot打印日志信息
 */
@RestController
@EnableAutoConfiguration
public class Example {
 
	private static Logger logger=LoggerFactory.getLogger(Example.class);
	
	@RequestMapping("/")
	public String home(){
		logger.debug("访问home");
		return "hello world";
	}
	
	@RequestMapping("hello/{name}")
	public String index(@PathVariable String name){
		logger.debug("访问index,参数name="+name);
		return "hello"+name;
	}
}
