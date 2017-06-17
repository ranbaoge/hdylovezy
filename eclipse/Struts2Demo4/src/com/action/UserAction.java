package com.action;

import com.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author huangdaye
 *Struts2验证机制
 *继承ActionSupport
 */
public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user);
		/*@SuppressWarnings("unchecked")
		Map<String, Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("user", user);*/
		return Action.SUCCESS;
	}
	

}
