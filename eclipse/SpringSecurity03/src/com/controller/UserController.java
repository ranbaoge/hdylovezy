package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/user/{id}")
	public String user(@PathVariable(value="id") int id,Model model){
		model.addAttribute("id", id);
		model.addAttribute("user", "user");
		return "index";
	}
	
	@RequestMapping("/admin/{id}")
	public String admin(@PathVariable(value="id") int id,Model model){
		model.addAttribute("id", id);
		model.addAttribute("user", "admin");
		return "index";
	}
	
	@RequestMapping("/home/{id}")
	public String home(@PathVariable(value="id") int id,Model model){
		model.addAttribute("id", id);
		model.addAttribute("user", "home");
		return "index";
	}
	
}
