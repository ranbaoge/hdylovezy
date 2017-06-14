package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

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
	private String username;
	private String password;
	

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(this.getUsername()==null || "".equals(this.getUsername())){
			this.addFieldError("username", "用户名不能为空");
		}
		if(this.getPassword()==null || "".equals(this.getPassword())){
			this.addFieldError("password", "密码不能为空");
		}
		if(username.length()<5 || username.length()>20){
			this.addFieldError("userlen", "用户名长度不能小于5或者大于20");
		}
		if(password.length()<5 || password.length()>20){
			this.addFieldError("pwdlen", "密码长度不能小于5或者大于20");
		}
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if("admin".equals(username) && "admin".equals(password)){
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("user", username);
			request.setAttribute("pwd", password);
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
