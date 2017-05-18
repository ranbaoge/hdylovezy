<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传成功</title>

<style type="text/css">
  body{
      background-image: url("image/2.jpg");
     }
</style>
</head>
<body>
   <h3>上传成功,${username}</h3>
   <a href="login.jsp">返回登录页面</a><br>
   <a href="query.do?page=1">查询用户及作业情况</a>
</body>
</html>