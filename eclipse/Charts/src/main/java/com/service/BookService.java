package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Book;

public interface BookService {

    int saveBook(Book book);
	
	int updateBook(Book book);
	
	int deleteById(int id);
	
	List<Book> queryByPage(Map<String, Integer> map);
	
	int count();
	
	List<Map<String, Object>> countType();
	
	/**
	 * 饼图内容显示
	 * @return
	 */
	Map<String, Object> pieCharts();
	
	/**
	 * 柱状图内容显示
	 * @return
	 */
	Map<String, Object> Charts();
}
