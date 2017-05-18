package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService=new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		//获取工程名
		String url=request.getContextPath();
		
		//用户注册
		if("save".equals(flag)){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			User user=new User(username, password, email);
			int rs= userService.saveUser(user);
			//获取工程名
			if(rs==0){
				System.out.println("注册不成功");
				response.sendRedirect(url+"/register.jsp");
			}else{
				System.out.println("注册成功");
				request.getRequestDispatcher("/rigister_success.jsp").forward(request, response);
			}
		}
		
		//用户登录
		if("login".equals(flag)){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			//执行业务方法
			User u=userService.login(user);
			HttpSession session=request.getSession();
			if(u!=null){
				//登录成功
				session.setAttribute("user", u);
				request.getRequestDispatcher("/BooksServlet?flag=query&page=1").forward(request, response);
			}else{
				//登录失败
				response.sendRedirect(url+"/login.jsp");
			}
		}
		
		//进行登录名验证
		if("register".equals(flag)){
			String username=request.getParameter("username");
			System.out.println("用户名:"+username);
			User user= userService.queryByName(username);
			boolean f=false;
			if(user==null){
				f=true;
			}
			//通过response实例化写入客户端页面的流
			PrintWriter out=response.getWriter();
			System.out.println(f);
			out.print(f);
			out.flush();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
