package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/")
	public String hello(Model model){
		System.out.println("进入Springmvc");
		return "viewUser";
	}
}
