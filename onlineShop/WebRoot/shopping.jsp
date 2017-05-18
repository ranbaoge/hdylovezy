<%@page import="com.entity.Item"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">北大青鸟网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
			    <li><span style="color:blue; font-weight: bolder; font-size: 18px">当前用户:${user.username}&nbsp;</span></li>
				<li><a href="BooksServlet?flag=query&page=1">User首页</a></li>
				<li><a href="orderlist.jsp">我的订单</a></li>
				<li class="current"><a href="shopping.jsp">购物车</a></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="shopping_success.jsp">
			<table>
				<tr class="title">
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
				</tr>
				<c:forEach items="${list1}" var="l">
				   <tr>
					<td class="thumb"><img src="${l.books.image }" /></td>
					<td class="title">${l.books.bookname }</td>
					<td><input class="input-text" type="text" name="nums" value="1" /></td>
					<td>￥<span>${l.price}</span></td>
				  </tr>
				</c:forEach>
			</table>
			<div class="button">
			    <%
			      List<Item> list1=(List<Item>)session.getAttribute("list1");
			      float countPrice=0.0f;
			      for(Item it:list1){
			          countPrice=it.getPrice()+countPrice;
			      }
			      out.print("<h4>总价：￥"+countPrice+"元</h4>");
			     %>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	北大青鸟网上书城 &copy; 版权所有

</div>
</body>
</html>
   