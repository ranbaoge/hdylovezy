package com.jdbc;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @author huangdaye
 *Redis操作set集合
 */
public class DemoSet {

	private Jedis jedis;
	
	@Before
	public void before(){
		jedis=new Jedis("localhost", 6379);
		jedis.auth("000000");
		System.out.println("Redis运行成功"+jedis.ping()+",当前时间:"+LocalDateTime.now());
	}
	
	/**
	 * 添加set集合
	 */
	@Test
	public void addSet(){
		Long rs = jedis.sadd("korin", "1","2","3","4","5","6");
		System.out.println(rs);
		
	}
	
	/**
	 * 查询set集合
	 */
	@Test
	public void querySet(){
		Long len = jedis.scard("korin");
		System.out.println(len);
		//查询set中多有成员
		Set<String> sets = jedis.smembers("korin");
		System.out.println(sets);
		//查询某个元素是否在集合中
		Boolean flag = jedis.sismember("korin", "1");
		System.out.println(flag);
	}
	
	
	
}
