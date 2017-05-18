package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Books;
import com.entity.Item;
import com.entity.Orders;
import com.service.BooksService;
import com.service.ItemService;
import com.service.impl.BooksServiceImpl;
import com.service.impl.ItemServiceImpl;

public class ItemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemService itemService=new ItemServiceImpl();
	private BooksService booksService=new BooksServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if("save".equals(flag)){
			String username= request.getParameter("username");
			//保存订单信息
			Orders od=new Orders(username);
			itemService.saveOrders(od);
			//定义返回页面的 购物车集合
			List<Item> list=new ArrayList<Item>();
			//然后保存购物车信息
			String[] idString=request.getParameterValues("bid");
			for (String id : idString) {
				System.out.println("id的序列"+id);
				Books b= booksService.queryById(Integer.parseInt(id));
				System.out.println(b);
				Integer bid=b.getId();
				Float bprice=b.getB_price();
				Item it=new Item(Integer.parseInt(id), bid, new Date(), 1, bprice, bprice);
				itemService.saveItem(it);
				//然后将添加到购物车的信息查询出来
				Item item=itemService.queryByIn(Integer.parseInt(id));
				//然后保存到List集合
				list.add(item);
			}
			//将集合放到作用域中
			request.getSession().setAttribute("list1", list);
			//转发跳转
			request.getRequestDispatcher("/shopping.jsp").forward(request, response);
		}
		
		if("query".equals(flag)){
			//获取传递过来的页数
			int page=Integer.parseInt(request.getParameter("page"));
			//定义每页显示多少条数
			int pageSize=5;
			//获取总记录数
			int count=itemService.count();
			//三目运算符判断尾页
			int lastPage=count%pageSize==0?count/pageSize:count/pageSize+1;
			//调用业务方法取Books对象集合
			List<Item> list=itemService.queryByPage(page, pageSize);
			//将需要的信息封装到作用域中
			request.setAttribute("list1", list);
			request.setAttribute("count", count);
			request.setAttribute("page", page);
			request.setAttribute("lastPage", lastPage);
			//转发跳转
			request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
