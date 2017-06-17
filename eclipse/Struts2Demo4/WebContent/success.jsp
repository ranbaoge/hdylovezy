<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
</head>
<body>
   <h2>登录成功</h2>
   <ul>
      <li>用户名:<s:property value="user.username"/> </li>
      <li>密码:<s:property value="user.password"/></li>
      <li>性别:<s:property value="user.gender"/></li>
      <li>年龄:<s:property value="user.age"/></li>
      <li>
                     兴趣:<s:property value="user.hobby"/>
      </li>
      <li>地址:<s:property value="user.address"/></li>
   </ul>
</body>
</html>