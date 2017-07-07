package com.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.user.dao.UserMapper;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userMapper")
	private UserMapper userMapper;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public int updatePassword(User user) {
		// TODO Auto-generated method stub
		return userMapper.updatePassword(user);
	}

	@Override
	public List<User> queryByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int page=(int) map.get("page");
		int pageSize=(int) map.get("pageSize");
		String key=(String) map.get("key");
		String rolename=(String) map.get("rolename");
		
		int from=(page-1)*pageSize;
		Map<String, Object> map2=new HashMap<>();
		map2.put("from", from);
		map2.put("pageSize", pageSize);
		map2.put("key", key);
		map2.put("rolename", rolename);
		return userMapper.queryByPage(map2);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		return userMapper.count(map);
	}

	@Override
	public List<Role> queryAllRole() {
		// TODO Auto-generated method stub
		return userMapper.queryAllRole();
	}
	
	
}
