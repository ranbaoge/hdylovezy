package com.entity;

import java.util.List;
import java.util.Map;

/**
 * @author huangdaye
 * @name Charts
 *定义曲线图表实体类
 */
/**
 * @author huangdaye
 *
 */
public class Charts {

	//图表标题
	private Map<String, Object> title;
	//图表副标题
	private Map<String, Object> subtitle;
	//曲线图X轴数据信息
	private Map<String, Object> xAxis;
	//曲线图Y轴数据信息
	private Map<String, Object> yAxis;
	//曲线图提示信息
	private Map<String, Object> tooltip;
	//曲线图展示方式
	private Map<String, Object> legend;
	//定义曲线图数据
	private List<Map<String, Object>> series;
	//图表类型
	private Map<String, Object> chart;
	private Map<String, Object> credits;
	private Map<String, Object> plotOptions;
	private Map<String, Object> labels;
	
	public Map<String, Object> getTitle() {
		return title;
	}
	public void setTitle(Map<String, Object> title) {
		this.title = title;
	}
	public Map<String, Object> getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(Map<String, Object> subtitle) {
		this.subtitle = subtitle;
	}
	public Map<String, Object> getxAxis() {
		return xAxis;
	}
	public void setxAxis(Map<String, Object> xAxis) {
		this.xAxis = xAxis;
	}
	public Map<String, Object> getyAxis() {
		return yAxis;
	}
	public void setyAxis(Map<String, Object> yAxis) {
		this.yAxis = yAxis;
	}
	public Map<String, Object> getTooltip() {
		return tooltip;
	}
	public void setTooltip(Map<String, Object> tooltip) {
		this.tooltip = tooltip;
	}
	public Map<String, Object> getLegend() {
		return legend;
	}
	public void setLegend(Map<String, Object> legend) {
		this.legend = legend;
	}
	
	public Map<String, Object> getChart() {
		return chart;
	}
	public void setChart(Map<String, Object> chart) {
		this.chart = chart;
	}
	public Map<String, Object> getCredits() {
		return credits;
	}
	public void setCredits(Map<String, Object> credits) {
		this.credits = credits;
	}
	public Map<String, Object> getPlotOptions() {
		return plotOptions;
	}
	public void setPlotOptions(Map<String, Object> plotOptions) {
		this.plotOptions = plotOptions;
	}
	public List<Map<String, Object>> getSeries() {
		return series;
	}
	public void setSeries(List<Map<String, Object>> series) {
		this.series = series;
	}
	public Charts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Charts(Map<String, Object> title, Map<String, Object> subtitle, Map<String, Object> xAxis,
			Map<String, Object> yAxis, Map<String, Object> tooltip, Map<String, Object> legend,
			List<Map<String, Object>> series) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.tooltip = tooltip;
		this.legend = legend;
		this.series = series;
	}
	public Charts(Map<String, Object> title, Map<String, Object> subtitle, Map<String, Object> xAxis,
			Map<String, Object> yAxis, Map<String, Object> tooltip, Map<String, Object> legend,
			List<Map<String, Object>> series, Map<String, Object> chart, Map<String, Object> credits,
			Map<String, Object> plotOptions) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.tooltip = tooltip;
		this.legend = legend;
		this.series = series;
		this.chart = chart;
		this.credits = credits;
		this.plotOptions = plotOptions;
	}
	public Charts(Map<String, Object> title, Map<String, Object> subtitle, Map<String, Object> tooltip,
			List<Map<String, Object>> series, Map<String, Object> chart, Map<String, Object> plotOptions) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.tooltip = tooltip;
		this.series = series;
		this.chart = chart;
		this.plotOptions = plotOptions;
	}
	public Charts(Map<String, Object> title, Map<String, Object> subtitle, Map<String, Object> xAxis,
			Map<String, Object> yAxis, Map<String, Object> legend, List<Map<String, Object>> series,
			Map<String, Object> chart, Map<String, Object> plotOptions) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.legend = legend;
		this.series = series;
		this.chart = chart;
		this.plotOptions = plotOptions;
	}
	public Charts(Map<String, Object> title, Map<String, Object> subtitle, Map<String, Object> xAxis,
			List<Map<String, Object>> series, Map<String, Object> labels) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.xAxis = xAxis;
		this.series = series;
		this.labels = labels;
	}
	
	public Charts(Map<String, Object> title, Map<String, Object> subtitle, Map<String, Object> xAxis,
			Map<String, Object> yAxis, Map<String, Object> tooltip, Map<String, Object> legend,
			List<Map<String, Object>> series, Map<String, Object> chart, Map<String, Object> plotOptions) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.tooltip = tooltip;
		this.legend = legend;
		this.series = series;
		this.chart = chart;
		this.plotOptions = plotOptions;
	}
	public Map<String, Object> getLabels() {
		return labels;
	}
	public void setLabels(Map<String, Object> labels) {
		this.labels = labels;
	}
	
	
}
