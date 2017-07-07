package com.entity;

public class PieData {

	private String label;
	private String value;
	private String color;
	//是否被切开
	private String issliced;
	public PieData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PieData(String label, String value, String color, String issliced) {
		super();
		this.label = label;
		this.value = value;
		this.color = color;
		this.issliced = issliced;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIssliced() {
		return issliced;
	}
	public void setIssliced(String issliced) {
		this.issliced = issliced;
	}
	@Override
	public String toString() {
		return "PieData [label=" + label + ", value=" + value + ", color=" + color + ", issliced=" + issliced + "]";
	}
	
}
