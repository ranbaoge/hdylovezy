<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
    <form action="hello/hdy.do" method="post">
         <span>用户名:</span><input type="text" name="username"><br>
         <span>密码:</span><input type="password" name="password"><br>
         <span>记住:</span><input type="checkbox" name="remember_me" id="rememberme" checked="checked">
         <input type="submit" value="登录">
    </form>
</body>
</html>