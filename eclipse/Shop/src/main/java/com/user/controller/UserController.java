package com.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.role.entity.Role;
import com.role.service.RoleService;
import com.user.entity.User;
import com.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="roleService")
	private RoleService roleService;
	
	/**
	 * 保存用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("save")
	public String save(User user,Model model,int page){
		user.setCreationdate(new Date());
		userService.saveUser(user);
		return queryAll(page, model);
	}
	
	/**
	 * 更新用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String update(User user,Model model,int page){
		user.setModifydate(new Date());
		userService.updateUser(user);
		return queryAll(page, model);
	}
	
	/**
	 * 根据ID删除用户
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(int id,Model model,int page){
		userService.deleteUser(id);
		return queryAll(page, model);
	}
	
	/**
	 * 分页查询所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("query")
	public String queryAll(int page,Model model){
		int count=userService.count();
		int pageSize=8;
		int lastPage=count%pageSize==0?count/pageSize:count/pageSize+1;
		
		Map<String, Integer> map=new HashMap<>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		List<User> list=userService.queryAll(map);
		List<Role> role=roleService.queryAll();
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("count", count);
		model.addAttribute("role", role);
		return "jsp/userlist";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user,Model model,HttpSession session){
		User u= userService.login(user);
		if(u!=null){
			session.setAttribute("u", u);
			return "redirect:/jsp/userview.jsp";
		}else{
			return "redirect:/error.jsp";
		}
		
	}
	
	/**
	 * 查询role列表
	 * @param username
	 * @param rolename
	 * @param model
	 * @return
	 */
	@RequestMapping("query1")
	public String queryByNameAndRole(String username,String rolename,Model model){
		Map<String, String> map=new HashMap<>();
		map.put("username", username);
		map.put("rolename", rolename);
		
		List<Role> role=roleService.queryAll();
		List<User> list=userService.queryByNameAndRole(map);
		model.addAttribute("list", list);
		model.addAttribute("role", role);
		return "jsp/userlist";
	}
	
	/**
	 * 使用Ajax返回role数据
	 * @return
	 */
	@RequestMapping("queryRole")
	@ResponseBody
	public Object queryRole(){
		List<Role> list=roleService.queryAll();
		String json=JSON.toJSONString(list);
		return json;
	}
	
	/**
	 * 根据ajax返回User列表
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("queryById")
	@ResponseBody
	public Object queryById(int id,Model model){
		User user=userService.queryById(id);
		String json=JSON.toJSONString(user);
		return json;
	}
	
	/**
	 * 退出登录，使session失效
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("loginOut")
	public String loginOut(Model model,HttpSession session){
		if(session!=null){
			System.out.println("使session失效");
			session.invalidate();
		}
		return "redirect:/login.jsp";
	}
	
	/**
	 * 使用ajxa验证修改的原密码信息
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping("validate")
	@ResponseBody
	public Object validate(String username,String password,Model model){
		User u=new User();
		u.setUsername(username);
		u.setUserpassword(password);
		boolean flag=userService.validate(u);
		//[{"name1":"value1",....},{},{}]
		String json="{\"flag\":"+"\""+flag+"\"}";
		System.out.println(json);
		return json;
	}
	
	/**
	 * 修改密码
	 * @param username
	 * @param newpassword
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("updatepwd")
	public String updatepwd(String username,String newpassword,Model model){
		Map<String, String> map=new HashMap<>();
		map.put("username", username);
		map.put("password", newpassword);
		userService.updatepwd(map);
		return "redirect:/login.jsp";
	}
	
	
}
