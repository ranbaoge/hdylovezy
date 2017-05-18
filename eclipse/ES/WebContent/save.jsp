<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>

<style type="text/css">
  body{
      background-image: url("image/2.jpg");
     }
</style>
</head>
<body>
    <form action="save.do?page=1" method="post">
      <fieldset>
        <legend>用户注册</legend>
        <label for="username">用户名:</label>
        <input type="text" name="username" id="username"><br>
        <label for="password">密码:</label>
        <input type="password" name="password" id="password"><br>
        <label for="truename">真实姓名:</label>
        <input type="text" name="truename" id="truename"><br>
        <input type="submit" value="提交">&nbsp;&nbsp;
        <input type="reset" value="重置">
     </fieldset>
    </form>
</body>
</html>