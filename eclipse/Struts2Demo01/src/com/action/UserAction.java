package com.action;

import com.opensymphony.xwork2.Action;

public class UserAction implements Action{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hello,struts2");
		return "success";
	}

}
