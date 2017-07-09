package com.jdbc;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;


/**
 * @author huangdaye
 *对字符串的CRUD测试使用
 */
public class DemoString {

	private Jedis jedis;
	
	/**
	 * 连接Reids数据库
	 */
	@Before
	public void connectionRedis(){
		//获取Redis本地连接
		jedis=new Jedis("localhost");
		//查看服务是否正常运行
		System.out.println("服务正常运行:"+jedis.ping());
	}
	
	/**
	 * 字符串:测试Redis对单个Key的添加
	 */
	@Test
	public void testStringAdd(){
		//插入Key和value
		jedis.set("admin", "123");
	}
	
	/**
	 * 字符串：插入多条Key-value数据
	 */
	@Test
	public void testStringAdd2(){
		//插入多条Key和value
		jedis.mset("hello","oop","world","iis");
	}
	
	
	/**
	 * 字符串:查询单个Key-value的值
	 */
	@Test
	public void queryByKey(){
		String value= jedis.get("admin");
		System.out.println("admin:"+value);
	}
	
	/**
	 * 字符串:查询多条key-value值
	 */
	@Test
	public void queryByAll(){
		List<String> valus=jedis.mget("admin","hello","world");
		valus.forEach(System.out::println);
	}
	
	/**
	 * 删除key-value
	 */
	@Test
	public void delKey(){
		long rs= jedis.del("hello","world");
		System.out.println("删除了"+rs+"行");
	}
}
