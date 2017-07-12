package com.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Book {

	private Integer id;
	private String name;
	private String author;
	private String publisher;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishDate;
	private Float price;
	private Integer cid;
	private Category category;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String author, String publisher, Date publishDate, Float price) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.price = price;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", publishDate=" + publishDate + ", price=" + price + ", cid=" + cid + "]";
	}
	
}
