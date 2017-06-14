package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author huangdaye
 *Struts2实现登录验证
 */
public class UserAction implements Action{

	private String username;
	private String password;
	
	/**
	 * strust2获取Servlet API有2中方式:
	 * 1.与servlet耦合的方式
	 * 2.与servlet解耦的方式
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//与servlet耦合的形式
		/*if("admin".equals(username)&&"admin".equals(password)){
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("user", username);
			session.setAttribute("pwd", password);
			return "success";
		}else{
			return "error";
		}*/
		
	  //与servlet解耦的形式
      if("admin".equals(username)&&"admin".equals(password)){
		/*Map<String, Object> session=ActionContext.getContext().getSession();
		session.put("user", username);
		session.put("pwd", password);*/
		Map<String, Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("user", username);
		request.put("pwd", password);
		return "success";
	   }else{
	 	return "error";
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
