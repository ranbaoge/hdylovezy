package com.demo;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

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
        	//获取输出流,定义文件以附件形式下载
        	OutputStream os=response.getOutputStream();
        	//定义输出流,文件写在特定的文件夹
        	FileOutputStream fos=new FileOutputStream("D:/tools/eclipse/ExcelDemo/WebContent/file/user.xls");
        	//清空输出流
        	response.reset();
        	
        	response.setCharacterEncoding("utf-8");
        	excelName=URLEncoder.encode(excelName, "utf-8");
        	//定义文件输出的头信息
        	response.setHeader("Content-Disposition", "attachment;filename="+new String(excelName.getBytes("utf-8"), "GBK")+".xls");
        	//定义文件输出的类型
        	response.setContentType("application/msexcel");
        	excelDemo(os);
        	excelDemo(fos);
        }
        
        if("pdf".equals(flag)){
        	pdfDemo(request, response);
        	response.sendRedirect("/success.html");
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
	
	/**
	 * 将数据库信息导出成Excel
	 * @param os
	 */
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
			
			//把创建的内容写在输出流里面，并关流
			workbook.write();
			workbook.close();
			os.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pdfDemo(HttpServletRequest request,HttpServletResponse response){
		String path="E:\\user.pdf";
		//定义输出页面大小
		Rectangle rectangle=new Rectangle(PageSize.A5);
		//设置背景颜色
		rectangle.setBackgroundColor(Color.YELLOW);
		//设置边框线颜色
		rectangle.setBorderColor(Color.RED);
		//定义输出文档
		Document document=new Document(rectangle);
		//定义输入流
		PdfWriter writer;
		try {
			writer=PdfWriter.getInstance(document, new FileOutputStream(path));
			//设置密码
			writer.setEncryption(true, "000000", "000000", 0);
			//设置标题
			document.addTitle("用户信息显示");
			//设置作者
			document.addAuthor("Leoonhardt");
			document.addCreator("黄大业");
			document.addCreationDate();
			
			//打开文档
			document.open();
			//处理中文问题
			BaseFont baseFont=BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font=new Font(baseFont, 12, Font.NORMAL);
			
			//向文档添加段落
			Paragraph paragraph=new Paragraph("用户情况分析", font);
			document.add(paragraph);
			Paragraph paragraph2=new Paragraph("用户编号\t用户名\t密码\t性别\t年龄\t手机\t地址", font);
			document.add(paragraph2);
			
			//遍历数据库信息输出内容
			List<User> list=userDao.queryAll();
			for (int i = 0; i < list.size(); i++) {
				Integer id=list.get(i).getId();
				String username=list.get(i).getUsername();
				String password=list.get(i).getPassword();
				String gender=list.get(i).getGender();
				Integer age=list.get(i).getAge();
				String phone=list.get(i).getPhone();
				String address=list.get(i).getAddress();
						
				Paragraph paragraph3=new Paragraph(id+"\t"+username+"\t"+password+"\t"+gender
						+"\t"+age+"\t"+phone+"\t"+address, font);
				document.add(paragraph3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			document.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
