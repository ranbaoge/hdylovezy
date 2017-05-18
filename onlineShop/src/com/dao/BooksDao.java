package com.dao;

import java.util.List;

import com.entity.Books;

/**
 * @author huangdaye
 *查询书籍信息
 */
public interface BooksDao {
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
