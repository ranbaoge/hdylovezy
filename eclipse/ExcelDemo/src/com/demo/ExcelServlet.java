package com.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao=new UserDaoImpl();
       
    public ExcelServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag=request.getParameter("flag");
        if("save".equals(flag)){
        	String username=request.getParameter("username");
			String password=request.getParameter("password");
			String gender=request.getParameter("gender");
			Integer age=Integer.parseInt(request.getParameter("age"));
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			User user=new User(username, password, gender, age, phone, address);
			userDao.saveUser(user);
			query(request, response);
        }
        
        if("excel".equals(flag)){
        	String excelName="用户信息管理情况";
        	//获取输出流
        	OutputStream os=response.getOutputStream();
        	//清空输出流
        	response.reset();
        	
        	response.setCharacterEncoding("utf-8");
        	excelName=URLEncoder.encode(excelName, "utf-8");
        	//定义文件输出的头信息
        	response.setHeader("Content-Disposition", "attachment;filename="+new String(excelName.getBytes("utf-8"), "GBK")+".xls");
        	//定义文件输出的类型
        	response.setContentType("application/msexcel");
        	excelDemo(os);
        }
        
        if("query".equals(flag)){
        	query(request, response);
        }
	}
	
	public void query(HttpServletRequest request,HttpServletResponse response){
		List<User> list=userDao.queryAll();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excelDemo(OutputStream os){
		try {
			//创建工作簿
			WritableWorkbook workbook=Workbook.createWorkbook(os);
			//创建新的一页
			WritableSheet sheet=workbook.createSheet("First Sheet", 0);
			//创建要显示的内容，创建第一行和参数属性
			Label id=new Label(0, 0, "编号");
			Label username=new Label(1, 0, "用户名");
			Label password=new Label(2, 0, "密码");
			Label gender=new Label(3, 0, "性别");
			Label age=new Label(4, 0, "年龄");
			Label phone=new Label(5, 0, "电话");
			Label address=new Label(6, 0, "地址");
			sheet.addCell(id);
			sheet.addCell(username);
			sheet.addCell(password);
			sheet.addCell(gender);
			sheet.addCell(age);
			sheet.addCell(phone);
			sheet.addCell(address);
			
			//遍历结果输出内容
			List<User> list=userDao.queryAll();
			for (int i = 0; i < list.size(); i++) {
				Label id1=new Label(0, i+1, list.get(i).getId().toString());
				Label username1=new Label(1, i+1, list.get(i).getUsername());
				Label password1=new Label(2, i+1, list.get(i).getPassword());
				Label gender1=new Label(3, i+1, list.get(i).getGender());
				Label age1=new Label(4, i+1, list.get(i).getAge().toString());
				Label phone1=new Label(5, i+1, list.get(i).getPhone());
				Label address1=new Label(6, i+1, list.get(i).getAddress());
				sheet.addCell(id1);
				sheet.addCell(username1);
				sheet.addCell(password1);
				sheet.addCell(gender1);
				sheet.addCell(age1);
				sheet.addCell(phone1);
				sheet.addCell(address1);
			}
			
			//把创建的内容卸载输出流里面，并关流
			workbook.write();
			workbook.close();
			os.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
