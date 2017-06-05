package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.role.entity.Role;
import com.role.service.RoleService;
import com.user.entity.User;
import com.user.service.UserService;

/**
 * @author huangdaye
 *测试类
 */
public class Test {
    private ClassPathXmlApplicationContext context;
    private UserService userService;
    private RoleService roleService;
    
	@Before
	public void before(){
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserService) context.getBean("userService");
		roleService=(RoleService) context.getBean("roleService");
	}
	
	@org.junit.Test
	public void queryAllUser(){
		Map<String, Integer> map=new HashMap<>();
		map.put("page", 2);
		map.put("pageSize", 5);
		List<User> list=userService.queryAll(map);
		for (User u : list) {
			System.out.println(u+"\t"+u.getRole());
		}
	}
	
	@org.junit.Test
	public void queryAllRole(){
		List<Role> list=roleService.queryAll();
		for (Role r : list) {
			System.out.println(r);
		}
	}
	
	@org.junit.Test
	public void queryByNameAndRole(){
		Map<String, String> map=new HashMap<>();
		map.put("username", "李明");
		map.put("rolename", "经理");
		List<User> list=userService.queryByNameAndRole(map);
		for (User u : list) {
			System.out.println(u+"\t"+u.getRole());
		}
	}
}
