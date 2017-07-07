package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Book;

public interface BookDao {

	int saveBook(Book book);
	
	
	int updateBook(Book book);
	
	int deleteById(int id);
	
	List<Book> queryByPage(Map<String, Integer> map);
	
	int count();
	
	List<Map<String, Object>> countType();
	
}
