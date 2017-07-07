package com.entity;

public class Data {

	//数据图描述的名字
	private String label;
	//数据图描述的值
	private String value;
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Data [label=" + label + ", value=" + value + "]";
	}
	
}
