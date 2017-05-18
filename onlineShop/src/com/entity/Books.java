package com.entity;

import java.io.Serializable;

public class Books implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String bookname;
	private Float b_price;
	private String image;
	private Integer stock;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(String bookname, Float b_price, String image, Integer stock) {
		super();
		this.bookname = bookname;
		this.b_price = b_price;
		this.image = image;
		this.stock = stock;
	}
	public Books(Integer id, String bookname, Float b_price, String image,
			Integer stock) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.b_price = b_price;
		this.image = image;
		this.stock = stock;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Float getB_price() {
		return b_price;
	}
	public void setB_price(Float b_price) {
		this.b_price = b_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", bookname=" + bookname + ", b_price="
				+ b_price + ", image=" + image + ", stock=" + stock + "]";
	}
	
	
}
