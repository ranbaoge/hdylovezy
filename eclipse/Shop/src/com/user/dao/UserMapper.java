package com.user.dao;

import java.util.List;
import java.util.Map;

import com.user.entity.Role;
import com.user.entity.User;

public interface UserMapper {
   
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User login(User user);
    
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
    int updatePassword(User user);
    
    /**
     * 分页模糊查询
     * @param map
     * @return
     */
    List<User> queryByPage(Map<String, Object> map);
    
    /**
     * 查询相应的记录条数
     * @param map
     * @return
     */
    int count(Map<String, Object> map);
    
    /**
     * 查询多有角色
     * @return
     */
    List<Role> queryAllRole();
    
}