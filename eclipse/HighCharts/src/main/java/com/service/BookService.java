package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Book;
import com.entity.Charts;

public interface BookService {

    int saveBook(Book book);
	
	int updateBook(Book book);
	
	int deleteById(int id);
	
	List<Book> queryByPage(Map<String, Integer> map);
	
	int count();
	
	List<Map<String, Object>> countType();
	
	/**
	 * 曲线图
	 * @return
	 */
	Charts chart01();
	
	/**
	 * 区域图
	 * @return
	 */
	Charts chart02();
	
	/**
	 * 条形图
	 * @return
	 */
	Charts chart03();
	
	/**
	 * 柱形图
	 * @return
	 */
	Charts chart04();
	
	/**
	 * 饼图
	 * @return
	 */
	Charts chart05();
	
	/**
	 * 散点图
	 * @return
	 */
	Charts chart06();
	
	/**
	 * 组合图
	 * @return
	 */
	Charts chart07();
	
	/**
	 * 3D柱状图
	 * @return
	 */
	Charts chart08();
	
	/**
	 * 3D饼图图
	 * @return
	 */
	Charts chart09();
	
}
