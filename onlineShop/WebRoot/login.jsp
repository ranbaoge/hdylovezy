<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录页面</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">北大青鸟网上书城</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="login">
	<h2>用户登陆</h2>
	<form method="post" action="UserServlet?flag=login">
		<dl>
			<dt>用户名：</dt>
			<dd><input class="input-text" type="text" name="username" /><span id="sp1"></span></dd>
			<dt>密　码：</dt>
			<dd><input class="input-text" type="password" name="password" onblur="validate()"/><span id="sp2"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-btn" type="submit" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.jsp';" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	北大青鸟网上书城 &copy; 版权所有

</div>
</body>
</html>
   