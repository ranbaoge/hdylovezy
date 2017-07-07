package com.entity;

public class PieChart {

	//边框线大小
	private String showborder;
	//信息描述
	private String caption;
	//背景颜色
	private String bgcolor;
	//显示值
	private String showvalues;
	//显示说明
	private String showlegend;
	//显示名称
	private String showlabels;
	//起始角度
	private String startingangle;
	//距离中心距离
	private String slicingdistance;
	//图表透明度
	private String pieinnerfacealpha;
	//每片边框透明度
	private String plotfillalpha;
	//饼图立起来角度
	private String pieyscale;
	public PieChart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PieChart(String showborder, String caption, String bgcolor, String showvalues, String showlegend,
			String showlabels, String startingangle, String slicingdistance, String pieinnerfacealpha,
			String plotfillalpha, String pieyscale) {
		super();
		this.showborder = showborder;
		this.caption = caption;
		this.bgcolor = bgcolor;
		this.showvalues = showvalues;
		this.showlegend = showlegend;
		this.showlabels = showlabels;
		this.startingangle = startingangle;
		this.slicingdistance = slicingdistance;
		this.pieinnerfacealpha = pieinnerfacealpha;
		this.plotfillalpha = plotfillalpha;
		this.pieyscale = pieyscale;
	}
	public String getShowborder() {
		return showborder;
	}
	public void setShowborder(String showborder) {
		this.showborder = showborder;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}
	public String getShowvalues() {
		return showvalues;
	}
	public void setShowvalues(String showvalues) {
		this.showvalues = showvalues;
	}
	public String getShowlegend() {
		return showlegend;
	}
	public void setShowlegend(String showlegend) {
		this.showlegend = showlegend;
	}
	public String getShowlabels() {
		return showlabels;
	}
	public void setShowlabels(String showlabels) {
		this.showlabels = showlabels;
	}
	public String getStartingangle() {
		return startingangle;
	}
	public void setStartingangle(String startingangle) {
		this.startingangle = startingangle;
	}
	public String getSlicingdistance() {
		return slicingdistance;
	}
	public void setSlicingdistance(String slicingdistance) {
		this.slicingdistance = slicingdistance;
	}
	public String getPieinnerfacealpha() {
		return pieinnerfacealpha;
	}
	public void setPieinnerfacealpha(String pieinnerfacealpha) {
		this.pieinnerfacealpha = pieinnerfacealpha;
	}
	public String getPlotfillalpha() {
		return plotfillalpha;
	}
	public void setPlotfillalpha(String plotfillalpha) {
		this.plotfillalpha = plotfillalpha;
	}
	public String getPieyscale() {
		return pieyscale;
	}
	public void setPieyscale(String pieyscale) {
		this.pieyscale = pieyscale;
	}
	@Override
	public String toString() {
		return "PieChart [showborder=" + showborder + ", caption=" + caption + ", bgcolor=" + bgcolor + ", showvalues="
				+ showvalues + ", showlegend=" + showlegend + ", showlabels=" + showlabels + ", startingangle="
				+ startingangle + ", slicingdistance=" + slicingdistance + ", pieinnerfacealpha=" + pieinnerfacealpha
				+ ", plotfillalpha=" + plotfillalpha + ", pieyscale=" + pieyscale + "]";
	}
	
	
	
}
