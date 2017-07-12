package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.entity.Book;
import com.entity.Charts;
import com.service.BookService;
@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public int saveBook(Book book) {
		return bookDao.saveBook(book);
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return bookDao.deleteById(id);
	}

	@Override
	public List<Book> queryByPage(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		Integer page=map.get("page");
		Integer pageSize=map.get("pageSize");
		Integer from=(page-1)*pageSize;
		
		Map<String, Integer> map1=new HashMap<>();
		map1.put("from", from);
		map1.put("pageSize", pageSize);
		
		return bookDao.queryByPage(map1);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return bookDao.count();
	}

	@Override
	public List<Map<String, Object>> countType() {
		// TODO Auto-generated method stub
		return bookDao.countType();
	}

	/**
	 * 返回基本曲线图信息
	 */
	@Override
	public Charts chart01() {
	
		//添加标题数据
		Map<String, Object> title=new HashMap<>();
		title.put("text", "书籍种类统计图");
		//添加副标题数据
		Map<String, Object> subtitle=new HashMap<>();
		subtitle.put("text", "Huangdaye");
		//添加X轴数据
		List<Map<String, Object>> lists = countType();
		List<String> types=new ArrayList<>();
		for (Map<String, Object> map : lists) {
			String name=(String) map.get("c_name");
			types.add(name);
		}
		Map<String, Object> xAxis=new HashMap<>();
		xAxis.put("categories", types);
		//添加Y轴数据
		Map<String, Object> yAxis=new HashMap<>();
		yAxis.put("text", "本");
		List<Map<String, Object>> plotLines=new ArrayList<>();
		Map<String, Object> pl=new HashMap<>();
		pl.put("color", "#808080");
		pl.put("width", 1);
		pl.put("value", 0);
		plotLines.add(pl);
		yAxis.put("plotLines", plotLines);
		//添加图表提示信息
		Map<String, Object> tooltip=new HashMap<>();
		tooltip.put("valueSuffix", "本");
		//添加曲线图展示方式
		Map<String, Object> legend=new HashMap<>();
		legend.put("layout", "vertical");
		legend.put("align", "right");
		legend.put("verticalAlign", "middle");
		legend.put("borderWidth", 0);
		//添加数据
		List<Map<String, Object>> series=new ArrayList<>();
		List<Object> datalist=new ArrayList<>();
		for (Map<String, Object> map : lists) {
			long count=(long) map.get("count(1)");
			datalist.add(count);
		}
		Map<String, Object> obj=new HashMap<>();
		obj.put("data", datalist);
		obj.put("name", "book");
		series.add(obj);
		//实例化Charts
		Charts charts=new Charts(title, subtitle, xAxis, yAxis, tooltip, legend, series);
		
		return charts;
	}

	@Override
	public Charts chart02() {
		// TODO Auto-generated method stub
		//添加标题数据
				Map<String, Object> title=new HashMap<>();
				title.put("text", "书籍种类统计图");
				//添加副标题数据
				Map<String, Object> subtitle=new HashMap<>();
				subtitle.put("text", "Huangdaye");
				//添加X轴数据
				List<Map<String, Object>> lists = countType();
				List<String> types=new ArrayList<>();
				for (Map<String, Object> map : lists) {
					String name=(String) map.get("c_name");
					types.add(name);
				}
				Map<String, Object> xAxis=new HashMap<>();
				xAxis.put("categories", types);
				//添加Y轴数据
				Map<String, Object> yAxis=new HashMap<>();
				yAxis.put("text", "本");
				List<Map<String, Object>> plotLines=new ArrayList<>();
				Map<String, Object> pl=new HashMap<>();
				pl.put("color", "#808080");
				pl.put("width", 1);
				pl.put("value", 0);
				plotLines.add(pl);
				yAxis.put("plotLines", plotLines);
				
				//添加图表提示信息
				Map<String, Object> tooltip=new HashMap<>();
				tooltip.put("valueSuffix", "本");
				//添加图表类型
				Map<String, Object> chart=new HashMap<>();
				chart.put("type", "areaspline");
				
				Map<String, Object> credits=new HashMap<>();
				credits.put("enabled", "fasle");
				
				Map<String, Object> plotOptions=new HashMap<>();
				Map<String, Object> areaspline=new HashMap<>();
				areaspline.put("fillOpacity", 0.5);
				plotOptions.put("areaspline", areaspline);
				
				//添加曲线图展示方式
				Map<String, Object> legend=new HashMap<>();
				legend.put("layout", "vertical");
				legend.put("align", "right");
				legend.put("verticalAlign", "middle");
				legend.put("borderWidth", 0);
				//添加数据
				List<Map<String, Object>> series=new ArrayList<>();
				List<Object> datalist=new ArrayList<>();
				for (Map<String, Object> map : lists) {
					long count=(long) map.get("count(1)");
					datalist.add(count);
				}
				Map<String, Object> obj=new HashMap<>();
				obj.put("data", datalist);
				obj.put("name", "book");
				series.add(obj);
				Charts charts=new Charts(title, subtitle, xAxis, yAxis, tooltip, legend, series, chart, credits, plotOptions);
				
		return charts;
	}

	@Override
	public Charts chart03() {
		// TODO Auto-generated method stub
		
		// 添加标题数据
		Map<String, Object> title = new HashMap<>();
		title.put("text", "书籍种类统计图");
		// 添加副标题数据
		Map<String, Object> subtitle = new HashMap<>();
		subtitle.put("text", "Huangdaye");
		// 添加X轴数据
		List<Map<String, Object>> lists = countType();
		List<String> types = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			String name = (String) map.get("c_name");
			types.add(name);
		}
		Map<String, Object> xAxis = new HashMap<>();
		xAxis.put("categories", types);
		// 添加Y轴数据
		Map<String, Object> yAxis = new HashMap<>();
		yAxis.put("text", "本");
		List<Map<String, Object>> plotLines = new ArrayList<>();
		Map<String, Object> pl = new HashMap<>();
		pl.put("color", "#808080");
		pl.put("width", 1);
		pl.put("value", 0);
		plotLines.add(pl);
		yAxis.put("plotLines", plotLines);

		// 添加图表提示信息
		Map<String, Object> tooltip = new HashMap<>();
		tooltip.put("valueSuffix", "本");
		// 添加图表类型
		Map<String, Object> chart = new HashMap<>();
		chart.put("type", "bar");

		Map<String, Object> credits = new HashMap<>();
		credits.put("enabled", "fasle");

		Map<String, Object> plotOptions = new HashMap<>();
		Map<String, Object> areaspline = new HashMap<>();
		areaspline.put("fillOpacity", 0.5);
		plotOptions.put("areaspline", areaspline);

		// 添加曲线图展示方式
		Map<String, Object> legend = new HashMap<>();
		legend.put("layout", "vertical");
		legend.put("align", "right");
		legend.put("borderWidth", 1);
		legend.put("x", "-40");
		legend.put("y", "100");
		legend.put("floating",true);
		legend.put("verticalAlign", "top");
		legend.put("shadow", true);
		legend.put("backgroundColor","((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF')");
		// 添加数据
		List<Map<String, Object>> series = new ArrayList<>();
		List<Object> datalist = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			long count = (long) map.get("count(1)");
			datalist.add(count);
		}
		Map<String, Object> obj = new HashMap<>();
		obj.put("data", datalist);
		obj.put("name", "book");
		series.add(obj);
		Charts charts = new Charts(title, subtitle, xAxis, yAxis, tooltip, legend, series, chart, credits, plotOptions);

		return charts;
	}

	@Override
	public Charts chart04() {
		// 添加标题数据
		Map<String, Object> title = new HashMap<>();
		title.put("text", "书籍种类统计图");
		// 添加副标题数据
		Map<String, Object> subtitle = new HashMap<>();
		subtitle.put("text", "Huangdaye");
		// 添加X轴数据
		List<Map<String, Object>> lists = countType();
		List<String> types = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			String name = (String) map.get("c_name");
			types.add(name);
		}
		Map<String, Object> xAxis = new HashMap<>();
		xAxis.put("categories", types);
		// 添加Y轴数据
		Map<String, Object> yAxis = new HashMap<>();
		yAxis.put("text", "本");
		List<Map<String, Object>> plotLines = new ArrayList<>();
		Map<String, Object> pl = new HashMap<>();
		pl.put("color", "#808080");
		pl.put("width", 1);
		pl.put("value", 0);
		plotLines.add(pl);
		yAxis.put("plotLines", plotLines);

		// 添加图表提示信息
		Map<String, Object> tooltip = new HashMap<>();
		tooltip.put("valueSuffix", "本");
		// 添加图表类型
		Map<String, Object> chart = new HashMap<>();
		chart.put("type", "column");

		Map<String, Object> credits = new HashMap<>();
		credits.put("enabled", "fasle");

		Map<String, Object> plotOptions = new HashMap<>();
		Map<String, Object> column = new HashMap<>();
		column.put("pointPadding", 0.2);
		column.put("borderWidth", 0);
		plotOptions.put("areaspline", column);

		// 添加曲线图展示方式
		Map<String, Object> legend = new HashMap<>();
		legend.put("layout", "vertical");
		legend.put("align", "right");
		legend.put("borderWidth", 1);
		legend.put("x", "-40");
		legend.put("y", "100");
		legend.put("floating", true);
		legend.put("verticalAlign", "top");
		legend.put("shadow", true);
		legend.put("backgroundColor", "((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF')");
		// 添加数据
		List<Map<String, Object>> series = new ArrayList<>();
		List<Object> datalist = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			long count = (long) map.get("count(1)");
			datalist.add(count);
		}
		Map<String, Object> obj = new HashMap<>();
		obj.put("data", datalist);
		obj.put("name", "book");
		series.add(obj);
		Charts charts = new Charts(title, subtitle, xAxis, yAxis, tooltip, legend, series, chart, credits, plotOptions);

		return charts;
	}

	@Override
	public Charts chart05() {
		// TODO Auto-generated method stub
		// 添加标题数据
		Map<String, Object> title = new HashMap<>();
		title.put("text", "书籍种类统计图");
		// 添加副标题数据
		Map<String, Object> subtitle = new HashMap<>();
		subtitle.put("text", "Huangdaye");

		// 添加图表提示信息
		Map<String, Object> tooltip = new HashMap<>();
		tooltip.put("pointFormat", "{series.name}: <b>{point.percentage:.1f}%</b>");
		
		// 添加图表类型
		Map<String, Object> chart = new HashMap<>();
		chart.put("plotBackgroundColor", null);
		chart.put("plotBorderWidth", null);
		chart.put("plotShadow", false);


		Map<String, Object> plotOptions = new HashMap<>();
		Map<String, Object> pie = new HashMap<>();
		pie.put("allowPointSelect", true);
		pie.put("cursor", "pointer");
		Map<String, Object> dataLabels=new HashMap<>();
		dataLabels.put("enabled", true);
		dataLabels.put("format", "<b>{point.name}%</b>: {point.percentage:.1f}");
		Map<String, Object> style=new HashMap<>();
		style.put("color", "(Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'");
		dataLabels.put("style", style);
		pie.put("dataLabels", dataLabels);
		plotOptions.put("pie", pie);

		// 添加数据
		List<Map<String, Object>> lists = countType();
		List<Map<String, Object>> series = new ArrayList<>();
		List<Object> datalist = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			if(i==3){
				Map<String, Object> data1=new HashMap<>();
				long count = (long) lists.get(i).get("count(1)");
				String name=(String) lists.get(i).get("c_name");
				data1.put("name", name);
				data1.put("y", count);
				data1.put("sliced", true);
				data1.put("selected", true);
				datalist.add(data1);
			}
			Map<String, Object> data1=new HashMap<>();
			long count = (long) lists.get(i).get("count(1)");
			String name=(String) lists.get(i).get("c_name");
			data1.put("name", name);
			data1.put("y", count);
			datalist.add(data1);
		}
		
		Map<String, Object> obj = new HashMap<>();
		obj.put("data", datalist);
		obj.put("name", "book");
		obj.put("type", "pie");
		series.add(obj);
		Charts charts=new Charts(title, subtitle, tooltip, series, chart, plotOptions);
		return charts;
	}

	@Override
	public Charts chart06() {
		// TODO Auto-generated method stub
		// 添加标题数据
		Map<String, Object> title = new HashMap<>();
		title.put("text", "书籍种类统计图");
		// 添加副标题数据
		Map<String, Object> subtitle = new HashMap<>();
		subtitle.put("text", "Huangdaye");
		// 添加X轴数据
		List<Map<String, Object>> lists = countType();
		List<String> types = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			String name = (String) map.get("c_name");
			types.add(name);
		}
		Map<String, Object> xAxis = new HashMap<>();
		xAxis.put("categories", types);
		// 添加Y轴数据
		Map<String, Object> yAxis = new HashMap<>();
		yAxis.put("text", "本");
		List<Map<String, Object>> plotLines = new ArrayList<>();
		Map<String, Object> pl = new HashMap<>();
		pl.put("color", "#808080");
		pl.put("width", 1);
		pl.put("value", 0);
		plotLines.add(pl);
		yAxis.put("plotLines", plotLines);

		// 添加图表类型
		Map<String, Object> chart = new HashMap<>();
		chart.put("type", "scatter");
		chart.put("zoomType", "xy");

		Map<String, Object> plotOptions=new HashMap<>();
		
		Map<String, Object> scatter=new HashMap<>();
		Map<String, Object> marker=new HashMap<>();
		marker.put("radius", 5);
		Map<String, Object> states1=new HashMap<>();
		Map<String, Object> hover1=new HashMap<>();
		hover1.put("enabled", true);
		hover1.put("lineColor", "rgb(100,100,100)");
		states1.put("hover", hover1);
		marker.put("state", states1);
		scatter.put("marker", marker);
		
		
		Map<String, Object> states=new HashMap<>();
		Map<String, Object> hover2=new HashMap<>();
		Map<String, Object> marker2=new HashMap<>();
		marker2.put("enabled", false);
		hover2.put("marker", marker2);
		states.put("hover", hover2);
		
		
		Map<String, Object> tooltip=new HashMap<>();
		tooltip.put("headerFormat", "<b>{series.name}</b><br>");
		tooltip.put("pointFormat", "{point.x}, {point.y}");
		
		
		plotOptions.put("scatter", scatter);
		plotOptions.put("states", states);
		plotOptions.put("tooltip", tooltip);
		

		// 添加曲线图展示方式
		Map<String, Object> legend = new HashMap<>();
		legend.put("layout", "vertical");
		legend.put("align", "right");
		legend.put("borderWidth", 1);
		legend.put("x", "100");
		legend.put("y", "70");
		legend.put("floating", true);
		legend.put("verticalAlign", "top");
		legend.put("backgroundColor", "((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF')");
		// 添加数据
		List<Map<String, Object>> series = new ArrayList<>();
		List<Object> datalist = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			long count = (long) map.get("count(1)");
			datalist.add(count);
		}
		Map<String, Object> obj = new HashMap<>();
		obj.put("data", datalist);
		obj.put("name", "book");
		series.add(obj);
		
		Charts charts=new Charts(title, subtitle, xAxis, yAxis, legend, series, chart, plotOptions);
		return charts;
		
	}

	@Override
	public Charts chart07() {
		// TODO Auto-generated method stub
		// 添加标题数据
		Map<String, Object> title = new HashMap<>();
		title.put("text", "书籍种类统计图");
		// 添加副标题数据
		Map<String, Object> subtitle = new HashMap<>();
		subtitle.put("text", "Huangdaye");
		// 添加X轴数据
		List<Map<String, Object>> lists = countType();
		List<String> types = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			String name = (String) map.get("c_name");
			types.add(name);
		}
		Map<String, Object> xAxis = new HashMap<>();
		xAxis.put("categories", types);
		
		//添加图表数据
		List<Map<String, Object>> series=new ArrayList<>();
		//柱状
		Map<String, Object> s1=new HashMap<>();
		s1.put("type", "column");
		s1.put("name", "book");
		List<Object> data=new ArrayList<>();
		for (Map<String, Object> maps  : lists) {
			long count=(long) maps.get("count(1)");
			data.add(count);
		}
		s1.put("data", data);
		
		//折线
		Map<String, Object> s2=new HashMap<>();
		s2.put("type", "spline");
		s2.put("name", "book");
		s2.put("data", data);
		Map<String, Object> marker=new HashMap<>();
		marker.put("lineWidth", 2);
		marker.put("lineColor", "Highcharts.getOptions().colors[3]");
		marker.put("fillColor", "white");
		s2.put("marker", marker);
		
		//饼
		Map<String, Object> s3=new HashMap<>();
		s3.put("type", "pie");
		s3.put("name", "book");
		List<Object> d=new ArrayList<>();
		for (Map<String, Object> maps  : lists) {
			Map<String, Object> data1=new HashMap<>();
			String name=(String) maps.get("c_name");
			long count=(long) maps.get("count(1)");
			data1.put("name", name);
			data1.put("y", count);
			d.add(data1);
		}
		s3.put("data", d);
		s3.put("center", "2");
		s3.put("size", 100);
		s3.put("showInLegend", false);
		Map<String,Object> dataLabels=new HashMap<>();
		dataLabels.put("enabled", false);
		s3.put("dataLabels", dataLabels);
		
		series.add(s1);
		series.add(s2);
		series.add(s3);

		//定义饼图的信息描述
		Map<String, Object> labels=new HashMap<>();
		List<Object> items=new ArrayList<>();
		Map<String, Object> it=new HashMap<>();
		it.put("html", "书籍类型统计");
		Map<String, Object> style=new HashMap<>();
		style.put("left", "600px");
		style.put("top", "18px");
		it.put("style", style);
		items.add(it);
		labels.put("items", items);
		
		Charts charts=new Charts(title, subtitle, xAxis, series, labels);
		return charts;
	}

	@Override
	public Charts chart08() {
		// TODO Auto-generated method stub
		// 添加标题数据
		Map<String, Object> title = new HashMap<>();
		title.put("text", "书籍种类统计图");
		// 添加副标题数据
		Map<String, Object> subtitle = new HashMap<>();
		subtitle.put("text", "Huangdaye");
		
		Map<String, Object> plotOptions=new HashMap<>();
		Map<String, Object> column=new HashMap<>();
		column.put("depth", 25);
		plotOptions.put("column", column);
		
		// 添加X轴数据
		List<Map<String, Object>> lists = countType();
		List<String> types = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			String name = (String) map.get("c_name");
			types.add(name);
		}
		Map<String, Object> xAxis = new HashMap<>();
		xAxis.put("categories", types);
		// 添加Y轴数据
		Map<String, Object> yAxis = new HashMap<>();
		yAxis.put("text", "本");
		List<Map<String, Object>> plotLines = new ArrayList<>();
		Map<String, Object> pl = new HashMap<>();
		pl.put("color", "#808080");
		pl.put("width", 1);
		pl.put("value", 0);
		plotLines.add(pl);
		yAxis.put("plotLines", plotLines);

		// 添加图表提示信息
		Map<String, Object> tooltip = new HashMap<>();
		tooltip.put("valueSuffix", "本");
		
		Map<String, Object> chart=new HashMap<>();
		chart.put("renderTo", "container");
		chart.put("type", "column");
		chart.put("margin", 75);
		Map<String, Object> options3d=new HashMap<>();
		options3d.put("enabled", true);
		options3d.put("alpha", 8);
		options3d.put("beta", 30);
		options3d.put("depth", 50);
		options3d.put("viewDistance", "25");
		chart.put("options3d", options3d);
		
		// 添加数据
		List<Map<String, Object>> series = new ArrayList<>();
		List<Object> datalist = new ArrayList<>();
		for (Map<String, Object> map : lists) {
			long count = (long) map.get("count(1)");
			datalist.add(count);
		}
		Map<String, Object> obj = new HashMap<>();
		obj.put("data", datalist);
		obj.put("name", "book");
		series.add(obj);
		
		Charts charts=new Charts(title, subtitle, xAxis, yAxis, tooltip, series, chart, plotOptions);
		return charts;
	}

	@Override
	public Charts chart09() {
		// TODO Auto-generated method stub
		// 添加标题数据
		Map<String, Object> title = new HashMap<>();
		title.put("text", "书籍种类统计图");
		// 添加副标题数据
		Map<String, Object> subtitle = new HashMap<>();
		subtitle.put("text", "Huangdaye");

		// 添加图表提示信息
		Map<String, Object> tooltip = new HashMap<>();
		tooltip.put("pointFormat", "{series.name}: <b>{point.percentage:.1f}%</b>");

		// 添加图表类型
		Map<String, Object> chart = new HashMap<>();
		chart.put("type", "pie");
		Map<String, Object> options3d=new HashMap<>();
		options3d.put("enabled", true);
		options3d.put("alpha", 45);
		options3d.put("beta", 0);
		chart.put("options3d", options3d);
		

		Map<String, Object> plotOptions = new HashMap<>();
		Map<String, Object> pie = new HashMap<>();
		pie.put("allowPointSelect", true);
		pie.put("cursor", "pointer");
		pie.put("depth", 35);
		Map<String, Object> dataLabels = new HashMap<>();
		dataLabels.put("enabled", true);
		dataLabels.put("format", "{point.name}");
		pie.put("dataLabels", dataLabels);
		plotOptions.put("pie", pie);

		// 添加数据
		List<Map<String, Object>> lists = countType();
		List<Map<String, Object>> series = new ArrayList<>();
		List<Object> datalist = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			if (i == 3) {
				Map<String, Object> data1 = new HashMap<>();
				long count = (long) lists.get(i).get("count(1)");
				String name = (String) lists.get(i).get("c_name");
				data1.put("name", name);
				data1.put("y", count);
				data1.put("sliced", true);
				data1.put("selected", true);
				datalist.add(data1);
			}
			Map<String, Object> data1 = new HashMap<>();
			long count = (long) lists.get(i).get("count(1)");
			String name = (String) lists.get(i).get("c_name");
			data1.put("name", name);
			data1.put("y", count);
			datalist.add(data1);
		}

		Map<String, Object> obj = new HashMap<>();
		obj.put("data", datalist);
		obj.put("name", "book");
		obj.put("type", "pie");
		series.add(obj);
		Charts charts = new Charts(title, subtitle, tooltip, series, chart, plotOptions);
		return charts;
	}

}
