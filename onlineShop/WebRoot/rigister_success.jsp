<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  <title>注册成功页面</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
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
<div id="register">
	<div class="title">
		<h2>欢迎注册北大青鸟网上书城</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="past">1.填写注册信息</li>
			<li class="last">2.注册成功</li>
		</ul>
	</div>
	<div class="success">
		<div class="information">
			<p>恭喜：注册成功！</p>
			<p><a href="index.jsp">点此进入用户中心&gt;&gt;</a></p>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	北大青鸟网上书城 &copy; 版权所有

</div>
</body>
</html>
  