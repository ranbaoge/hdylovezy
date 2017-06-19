package com.entity;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String truename;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String truename) {
		super();
		this.username = username;
		this.password = password;
		this.truename = truename;
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
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", truename=" + truename + "]";
	}
	
}
