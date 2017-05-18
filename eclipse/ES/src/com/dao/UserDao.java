package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.User;

public interface UserDao {
	/**
	 * 注册用户
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * 更新用户
	 * @param map
	 */
	void updateUser(Map<String, String> map);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(int id);
	
	/**
	 * 分页查询用户信息
	 * @param map
	 * @return
	 */
	List<User> queryByPage(Map<String, Integer> map);
	
	/**
	 * 查询总记录数
	 * @return
	 */
	int count();
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
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
