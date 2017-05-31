package com.entity;

public class User {
	
	private String username;
	private String password;
	private String message;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
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



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}

    public String validate(){
    	if(!username.equals("admin") || !password.equals("123456")){
    		message="用户名或密码错误";
    		return "failure";
    	}else{
    		return "success";
    	}
    }

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
