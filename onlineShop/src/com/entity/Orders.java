package com.entity;

import java.io.Serializable;

public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String username) {
		super();
		this.username = username;
	}
	public Orders(Integer id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", username=" + username + "]";
	}
	

}
