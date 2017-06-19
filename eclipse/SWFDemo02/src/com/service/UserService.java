package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.User;
@Service("userService")
public class UserService {

	private Map<Integer, User> map=new HashMap<>();
	
	public UserService(){
		System.out.println("初始化UserService");
		map.put(1, new User("Leonhardt", "123", "莱恩哈特"));
		map.put(2, new User("Korin", "123", "卡琳"));
		map.put(3, new User("Siver", "123", "希维尔"));
	}
	
	public List<User> getUserList(){
		System.out.println("执行业务方法getUserList");
		return new ArrayList<>(map.values());
	}
	
	public User getUser(Integer id){
		return map.get(id);
	}
}
