<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="user_save.action" method="post">
        <span>用户名:</span><input type="text" name="user.username"><br>
        <span>密码:</span><input type="password" name="user.password"><br>
        <span>IdCard:</span><input type="text" name="idCard.no"><br>
        <input type="submit" value="注册">
   </form>
</body>
</html>