package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author huangdaye
 *使用JPA注解来实现hibernate映射
 *
 */
@Entity
@Table(name="t_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 指定oracle的序列，然后generator是主键生成策略
	 * @SequenceGenerator是指定序列的名字和主键生成策略的关系
	 */
	@Id
	@Column(name="u_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user")
	@SequenceGenerator(name="seq_user",sequenceName="seq_user",initialValue=1,allocationSize=1)
	private Integer id;
	@Column(name="u_username")
	private String username;
	@Column(name="u_password")
	private String password;
	@OneToOne(targetEntity=IdCard.class)
	private IdCard idCard;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
