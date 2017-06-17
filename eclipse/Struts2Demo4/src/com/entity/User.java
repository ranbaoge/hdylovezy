package com.entity;

import java.util.Arrays;

public class User {
	
	private String username;
	private String password;
	private String gender;
	private Integer age;
	private String[] hobby;
	private String address;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String gender, Integer age, String[] hobby, String address) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.hobby = hobby;
		this.address = address;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", gender=" + gender + ", age=" + age
				+ ", hobby=" + Arrays.toString(hobby) + ", address=" + address + "]";
	}
	
}
