package com.service;

import java.util.List;
import java.util.Map;

import com.entity.User;

public interface UserService {
	
    void saveUser(User user);
	
	void updateUser(Map<String, String> map);
	
	void deleteUser(int id);
	
	List<User> queryByPage(Map<String, Integer> map);
	
	int count();
	
	User login(User user);
	
	/**
	 * 修改作业提交状态
	 */
	void updateState(String username);
	
	/**
	 * 清空作业状态
	 */
	void emptyState();
}
