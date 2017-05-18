package com.entity;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer iid;
	private Integer oid;
	private Integer bid;
	private Date createdate;
	private Integer count;
	private Float price;
	private Float total_price;
	private Books books;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Integer oid, Integer bid, Date createdate, Integer count,
			Float price, Float total_price) {
		super();
		this.oid = oid;
		this.bid = bid;
		this.createdate = createdate;
		this.count = count;
		this.price = price;
		this.total_price = total_price;
	}
	public Item(Integer iid, Integer oid, Integer bid, Date createdate,
			Integer count, Float price, Float total_price) {
		super();
		this.iid = iid;
		this.oid = oid;
		this.bid = bid;
		this.createdate = createdate;
		this.count = count;
		this.price = price;
		this.total_price = total_price;
	}
	public Integer getIid() {
		return iid;
	}
	
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Float total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", oid=" + oid + ", bid=" + bid
				+ ", createdate=" + createdate + ", count=" + count
				+ ", price=" + price + ", total_price=" + total_price + "]";
	}
	

}
