package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="t_card")
public class IdCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="c_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_card")
	@SequenceGenerator(name="seq_card",sequenceName="seq_card",initialValue=1,allocationSize=1)
	private Integer id;
	@Column(name="c_no")
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
