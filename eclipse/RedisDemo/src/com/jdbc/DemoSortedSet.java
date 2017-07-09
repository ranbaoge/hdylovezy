package com.jdbc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @author huangdaye
 *对Redis中sortedSet的操作
 */
public class DemoSortedSet {

    private Jedis jedis;
	
	/**
	 * 连接Reids数据库
	 */
	@Before
	public void connectionRedis(){
		//获取Redis本地连接
		jedis=new Jedis("localhost");
		jedis.auth("000000");
		//查看服务是否正常运行
		System.out.println("服务正常运行:"+jedis.ping());
	}
	
	/**
	 * 添加sortedSet集合
	 */
	@Test
	public void addSortedSet(){
		Map<String, Double> map=new HashMap<>();
		map.put("您好",  1.0);
		map.put("世界",  2.0);
		map.put("莱恩哈特", 3.0);
		map.put("卡琳", 4.0);
		
		Long zadd = jedis.zadd("cfg", map);
		System.out.println(zadd);
	}
	
	/**
	 * 查询set集合
	 */
	@Test
	public void querySortedSet(){
		//查询集合的长度
		Long len = jedis.zcard("cfg");
		System.out.println(len);
		//查询范围内集合的大小
		Set<String> zrange = jedis.zrange("cfg", 0, len);
		System.out.println(zrange);
	}
	
}
