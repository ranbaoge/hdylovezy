package com.entity;

/**
 * @author huangdaye
 *柱状图描述实体类
 */
public class Chart {

	//柱状图描述
	private String caption;
	//柱状图X轴
	private String xAxisName;
	//柱状图Y轴
	private String yAxisName;
	//数字前缀
	private String numberPrefix;
	public Chart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Chart(String caption, String xAxisName, String yAxisName, String numberPrefix) {
		super();
		this.caption = caption;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.numberPrefix = numberPrefix;
	}
	

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getxAxisName() {
		return xAxisName;
	}

	public void setxAxisName(String xAxisName) {
		this.xAxisName = xAxisName;
	}

	public String getyAxisName() {
		return yAxisName;
	}

	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}

	public String getNumberPrefix() {
		return numberPrefix;
	}

	public void setNumberPrefix(String numberPrefix) {
		this.numberPrefix = numberPrefix;
	}

	@Override
	public String toString() {
		return "Chart [caption=" + caption + ", xAxisName=" + xAxisName + ", yAxisName=" + yAxisName + ", numberPrefix="
				+ numberPrefix + "]";
	}

}
