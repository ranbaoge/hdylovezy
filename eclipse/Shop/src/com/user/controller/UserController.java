package com.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.service.UserService;

@Controller
public class UserController {

	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * 登录功能
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("user/login")
	public String login(User user,Model model,HttpSession session){
		User u =userService.login(user);
		if(u!=null){
			session.setAttribute("u", u);
			return "jsp/userview";
		}else{
			return "error";
		}
	}
	
	/**
	 * 注销用户
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("user/logout")
	public String logout(HttpSession session,Model model){
		
		User user= (User) session.getAttribute("u");
		System.out.println("session中:"+user);
		//使session失效
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("user/udpatePassword")
	public String updatePassword(Model model,User user){
		int rs= userService.updatePassword(user);
		System.out.println("修改了数据库"+rs+"行");
		return "login";
	}
	
	/**
	 * 通过Ajax来验证旧密码
	 * @return
	 */
	@RequestMapping("user/validatePassword")
	@ResponseBody
	public Object validatePassword(User user){
		User u=userService.login(user);
		System.out.println(u);
		if(u!=null){
			String json="{\"flag\":\"true\"}";
			return json;
		}else{
			String json="{\"flag\":\"false\"}";
			System.out.println(json);
			return json;
		}
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param model
	 * @param key
	 * @return
	 */
	@RequestMapping("user/query")
	public String queryByPage(int page,Model model,
			                  @RequestParam(value="key",required=false) String key,
			                  @RequestParam(value="rolename",required=false) String rolename){
		
		Map<String, Object> map=new HashMap<>();
		map.put("key", key);
		map.put("rolename", rolename);
		System.out.println(rolename+"\t"+key);
		//查询总记录数
		int count=userService.count(map);
		int pageSize=8;
		//计算尾页
		int lastPage=count%pageSize==0?count/pageSize:count/pageSize+1;
		
		map.put("page", page);
		map.put("pageSize", pageSize);
		//分页查询
		List<User> list=userService.queryByPage(map);
		
		//封装数据回页面
		model.addAttribute("page", page);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		model.addAttribute("count",count);
		model.addAttribute("key", key);
		model.addAttribute("rolename", rolename);
		return "jsp/userlist";
	}
	
	/**
	 * 通过Ajax查询role信息列表
	 * @return
	 */
	@RequestMapping(value="user/queryAllRole",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object queryAllRole(){
		
		List<Role> rolelist=userService.queryAllRole();
		//转化为JSON数据
		String json=JSON.toJSONString(rolelist);
		return json;
	}
	
}
