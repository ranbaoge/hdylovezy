package com.service.impl;

import java.util.List;

import com.dao.BooksDao;
import com.dao.impl.BooksDaoImpl;
import com.entity.Books;
import com.service.BooksService;

public class BooksServiceImpl implements BooksService{
	private BooksDao booksDao=new BooksDaoImpl();
	
	@Override
	public List<Books> queryByPage(int page, int pageSize) {
		
		return booksDao.queryByPage(page, pageSize);
	}

	@Override
	public int count() {
		
		return booksDao.count();
	}

	@Override
	public Books queryById(int id) {
		
		return booksDao.queryById(id);
	}

}
