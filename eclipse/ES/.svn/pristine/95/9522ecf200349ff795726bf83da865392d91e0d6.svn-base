package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter("/*")
public class FilterTool implements Filter {

   
    public FilterTool() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse rsp=(HttpServletResponse) response;
		//过滤字符编码
		req.setCharacterEncoding("utf-8");
		rsp.setCharacterEncoding("utf-8");
		rsp.setContentType("text/html,charset=utf-8");
		HttpSession session=req.getSession(true);
		//截取url路径
		String requestURI = req.getRequestURI().substring(
                req.getRequestURI().lastIndexOf("/"),
                req.getRequestURI().length());
		String name=(String) session.getAttribute("username");
		//过滤验证
		if(name!=null || ("/login.jsp").equals(requestURI) || ("/login.do").equals(requestURI)){
			chain.doFilter(req, rsp);
		}else{
			rsp.sendRedirect("login.jsp");
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
