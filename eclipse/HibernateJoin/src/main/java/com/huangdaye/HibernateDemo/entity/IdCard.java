package com.huangdaye.HibernateDemo.entity;

public class IdCard {
	private Integer id;
	private String no;
	private Teacher teacher;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", no=" + no + "]";
	}
	
}
