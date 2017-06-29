package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value={"/hello/hdy.do"})
	public String hello(Model model){
		model.addAttribute("leo", "Leonhardt");
		return "success";
	}
	
	@RequestMapping("/hdy")
	public String index(){
		return "login";
	}
	
}
