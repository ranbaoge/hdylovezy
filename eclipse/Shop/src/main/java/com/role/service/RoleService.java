package com.role.service;

import java.util.List;

import com.role.entity.Role;

/**
 * @author huangdaye
 *角色Service层
 */
public interface RoleService {
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	int saveRole(Role role);
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	int updateRole(Role role);
	
	/**
	 * 根据ID删除角色
	 * @param id
	 * @return
	 */
	int deleteRole(long id);
	
	/**
	 * 查询所有角色
	 * @return
	 */
	List<Role> queryAll();
}
