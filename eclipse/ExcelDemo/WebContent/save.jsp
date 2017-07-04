<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <form action="ExcelServlet?flag=save" method="post">
        <span>用户名:</span><input type="text" name="username"><br>
        <span>密码:</span><input type="password" name="password"><br>
        <span>性别:</span><input type="radio" name="gender" value="男" checked="checked">男&nbsp;
                         <input type="radio" name="gender" value="女">女<br>
        <span>年龄:</span><input type="text" name="age"><br>
        <span>手机:</span><input type="text" name="phone"><br>
        <span>地址:</span><textarea rows="4" cols="50" name="address"></textarea><br>
        <input type="submit" value="注册">
   </form>
</body>
</html>