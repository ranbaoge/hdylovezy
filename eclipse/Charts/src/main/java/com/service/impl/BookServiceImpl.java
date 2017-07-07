package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.entity.Book;
import com.entity.PieChart;
import com.entity.PieData;
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


	@Override
	public Map<String, Object> pieCharts() {
		// TODO Auto-generated method stub
		
		//饼图内容描述
		PieChart pieChart=new PieChart("1", "书籍类型分布图", "E1E1E1,FFFFFF", "0", "1", "0", "190", "35", "60", "80", "30");
		
		//饼图数据
		List<Map<String, Object>> list=countType();
		List<PieData> datas=new ArrayList<>();
		
		//遍历封装数据
		for (int i = 0; i < list.size(); i++) {
			PieData data=new PieData();
			String label=(String) list.get(i).get("c_name");
			Long value=(Long) list.get(i).get("count(1)");
			data.setLabel(label);
			data.setValue(value.toString());
			if(i==0){
				data.setIssliced("1");
			}
			datas.add(data);
		}
		//将数据封装到map集合
		Map<String, Object> map=new HashMap<>();
		map.put("chart", pieChart);
		map.put("data", datas);
		return map;
	}

	@Override
	public Map<String, Object> Charts() {
		// TODO Auto-generated method stub
		//X-Y坐标图内容显示
		PieChart chart=new PieChart("书籍类型分布图", "书籍类型", "类型值", "");
		
		//X-Y坐标图数据
		List<Map<String, Object>> list=countType();
		List<PieData> datas=new ArrayList<>();
		
		//遍历封装数据
		for (int i = 0; i <list.size(); i++) {
			PieData data=new PieData();
			Long value=(Long) list.get(i).get("count(1)");
			data.setValue(value.toString());
			data.setLabel((String) list.get(i).get("c_name"));
			datas.add(data);
		}
		
		//将描述和数据存放在Map集合
		Map<String, Object> map=new HashMap<>();
		map.put("chart", chart);
		map.put("data", datas);
		return map;
	}

}
