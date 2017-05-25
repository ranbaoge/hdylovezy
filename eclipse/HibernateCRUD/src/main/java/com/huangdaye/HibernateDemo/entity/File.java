package com.huangdaye.HibernateDemo.entity;

import java.io.Serializable;

/**
 * @author huangdaye
 *文件实体类
 */
public class File implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String path;
	private Integer u_id;
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	public File(Integer id, String name, String path, Integer u_id) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.u_id = u_id;
	}
	public File(String name, String path, Integer u_id) {
		super();
		this.name = name;
		this.path = path;
		this.u_id = u_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", path=" + path + ", u_id=" + u_id + "]";
	}
	
	

}
