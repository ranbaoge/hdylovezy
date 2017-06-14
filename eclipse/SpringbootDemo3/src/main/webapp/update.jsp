<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改教师信息</title>
</head>
<body>
   <form action="update.do" method="post">
       <span>教师编号:</span><input type="text" name="id" readonly="readonly" value="<%=request.getParameter("id") %>"><br>
       <span>姓名:</span><input type="text" name="name"><br>
       <input type="submit" value="修改">
   </form>
</body>
</html>