package com.entity;

import java.io.Serializable;

public class IdCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String no;
	public IdCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IdCard(String no) {
		super();
		this.no = no;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", no=" + no + "]";
	}
	
	
}
