package com.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.entity.User;

import redis.clients.jedis.Jedis;

/**
 * @author huangdaye
 *对Hash的CRUD操作
 */
public class DemoHash {

	private Jedis jedis;
	
	@Before
	public void before(){
		//获取redis连接
		jedis=new Jedis("localhost", 6379);
		//进行权限验证
		jedis.auth("000000");
		System.out.println("Redis连接成功:"+jedis.ping());
	}
	
	
	/**
	 * 对单个hash值的添加,hash适合添加对象
	 */
	@Test
	public void addHash(){
		User user=new User(1, "Leonhardt", "123", 24);
		Map<String, String> hash=new HashMap<>();
		hash.put("id", user.getId().toString());
		hash.put("username", user.getUsername());
		hash.put("password", user.getPassword());
		hash.put("age", user.getAge().toString());
		//添加hash
		String rs= jedis.hmset("user", hash);
		System.out.println(rs);
	}
	
	/**
	 * 获取hash里面对象属性值
	 */
	@Test
	public void queryByKeyHash(){
		List<String> user = jedis.hmget("user", "id","username");
		user.forEach(System.out::println);
	}
	
	/**
	 * 删除hash里面的字段
	 */
	@Test
	public void delHash(){
		Long rs = jedis.hdel("user", "password","age");
		System.out.println("删除了多少:"+rs+"字段");
		
		List<String> lists = jedis.hmget("user", "id","username","password","age");
		lists.forEach(System.out::println);
	}
}
