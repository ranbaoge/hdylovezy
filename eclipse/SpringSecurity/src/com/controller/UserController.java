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
		if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
			session.setAttribute("username", user.getUsername());
			return "success";
		}else{
			return "login";
		}
	}
}
