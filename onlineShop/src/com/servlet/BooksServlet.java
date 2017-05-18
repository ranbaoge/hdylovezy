package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Books;
import com.service.BooksService;
import com.service.impl.BooksServiceImpl;

public class BooksServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BooksService booksService=new BooksServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if("query".equals(flag)){
			//获取传递过来的页数
			int page=Integer.parseInt(request.getParameter("page"));
			//定义每页显示多少条数
			int pageSize=5;
			//获取总记录数
			int count=booksService.count();
			//三目运算符判断尾页
			int lastPage=count%pageSize==0?count/pageSize:count/pageSize+1;
			//调用业务方法取Books对象集合
			List<Books> list=booksService.queryByPage(page, pageSize);
			//将需要的信息封装到作用域中
			request.setAttribute("list", list);
			request.setAttribute("count", count);
			request.setAttribute("page", page);
			request.setAttribute("lastPage", lastPage);
			//转发跳转
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
