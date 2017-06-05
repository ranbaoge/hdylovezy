package com.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.user.dao.UserMapper;
import com.user.entity.User;
import com.user.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.saveUser(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id);
	}

	@Override
	public List<User> queryAll(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		Integer page=map.get("page");
		Integer pageSize=map.get("pageSize");
		Integer from =(page-1)*pageSize;
		map.put("from", from);
		return userMapper.queryAll(map);
	}
	

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return userMapper.count();
	}

	@Override
	public List<User> queryByNameAndRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userMapper.queryByNameAndRole(map);
	}

	@Override
	public User queryById(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryById(id);
	}

	@Override
	public boolean validate(User user) {
		// TODO Auto-generated method stub
		User u=userMapper.validate(user);
		boolean flag=false;
		if(u!=null){
			flag=true;
		}
		return flag;
	}

	@Override
	public int updatepwd(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userMapper.updatepwd(map);
	}


}
