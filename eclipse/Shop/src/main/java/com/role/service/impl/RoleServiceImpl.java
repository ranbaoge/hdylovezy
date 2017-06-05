package com.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.role.dao.RoleMapper;
import com.role.entity.Role;
import com.role.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Resource(name="roleMapper")
	private RoleMapper roleMapper;
	
	@Override
	public int saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.saveRole(role);
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateRole(role);
	}

	@Override
	public int deleteRole(long id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRole(id);
	}

	@Override
	public List<Role> queryAll() {
		// TODO Auto-generated method stub
		return roleMapper.queryAll();
	}

}
