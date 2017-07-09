package com.jdbc;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @author huangdaye
 *Java操作Redis的list型数据
 */
public class DemoList {

	private Jedis jedis;
	
	@Before
	public void before(){
		jedis=new Jedis("localhost");
		jedis.auth("000000");
		System.out.println("Redis连接成功:"+jedis.ping());
	}
	
	/**
	 * 插入list数据
	 */
	@Test
	public void addList(){
		Long rs = jedis.lpush("leo", "1","2","3","4","5");
		System.out.println("在Redis中插入了"+rs+"行数据");
	}
	
	/**
	 * 遍历获取list数据
	 */
	@Test
	public void queryList(){
		//获取key的长度
		Long rs = jedis.llen("leo");
		//输出key-value值
		List<String> lrange = jedis.lrange("leo", 0, rs);
		//遍历输出数据
		for (String s : lrange) {
			System.out.println(s);
		}
		
	}
	
}
