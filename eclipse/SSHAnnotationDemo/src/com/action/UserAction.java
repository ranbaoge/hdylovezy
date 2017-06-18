package com.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entity.IdCard;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.service.UserService;
@Controller("userAction")
@Scope(value="prototype")
public class UserAction {

	private User user;
	private IdCard idCard;
	@Autowired
	private UserService userService;
	
	public String save(){
		System.out.println(user+"\t"+idCard);
		userService.saveUser(user,idCard);
		return queryAll();
	}
	
	
    public String queryAll(){
		List<User> list=userService.queryAll();
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.put("list", list);
		return "success";
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public IdCard getIdCard() {
		return idCard;
	}


	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
    
}
