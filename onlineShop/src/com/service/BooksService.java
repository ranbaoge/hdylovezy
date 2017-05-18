package com.service;

import java.util.List;

import com.entity.Books;

public interface BooksService {
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Books> queryByPage(int page,int pageSize);
	
	/**
	 * 查询总记录数
	 * @return
	 */
	int count();
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	Books queryById(int id);
}
