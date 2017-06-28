package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;

@Controller
public class UserController {

	@RequestMapping("login.do")
	public String login(User user,Model model,HttpSession session){
		session.setAttribute("user", user);
		return "success";
	}
	
	@RequestMapping("form.do")
	public String loginPage(){
		
		return "login";
	}
	
	@RequestMapping("success.do")
	public String loginsuccess(){
		return "success";
	}
	
	@RequestMapping("error.do")
	public String errorPage(){
		return "error";
	}
	
	@RequestMapping("logout.do")
	public String logout(){
		return "welcome";
	}
}
