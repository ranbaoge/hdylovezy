<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <title>网上商城主页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<style type="text/css">
   th,td{
     text-align: center;
   }
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){
         //获取传回来的page值
         var page=$("#page").val();
         //获取传回来的lastPage值
         var lastPage=$("#last").val();
         //触发首页点击事件
         $("#b1").click(function(){
            window.location.href="BooksServlet?flag=query&page=1";
         });
         //触发上一页点击事件
         $("#b2").click(function(){
            var newPage=Number(page);
            if(page<=1){
              newPage=newPage+1;
            }
            location.href="BooksServlet?flag=query&page="+(newPage-1);
         });
         //触发下一页点击事件
         $("#b3").click(function(){
           var newPage=Number(page);
           if(page>=lastPage){
             newPage=Number(lastPage)-1;
           }
            location.href="BooksServlet?flag=query&page="+(newPage+1);
         });
         //触发尾页点击事件
         $("#b4").click(function(){
            location.href="BooksServlet?flag=query&page="+lastPage;
         });
         
         //表格隔行变色
         $("tr:odd").css("background-color","#D6E9FA");
         
    });
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">北大青鸟网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
			    <li><span style="color:blue; font-weight: bolder; font-size: 18px">当前用户:${user.username}&nbsp;</span></li>
				<li class="current"><a href="BooksServlet?flag=query&page=1">User首页</a></li>
				<li><a href="orderlist.jsp">我的订单</a></li>
				<li><a href="shopping.jsp">购物车</a></li>
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
		<form method="post" name="shoping" action="ItemServlet?flag=save">
			<table>
				<tr class="title">
					<th class="checker"></th>
					<th class="">书名</th>
					<th class="price">价格</th>
					<th class="store">库存</th>
					<th class="view">图片预览</th>
				</tr>
				<c:forEach items="${list}" var="l" varStatus="i">
				   <tr>
					<td>
					  <input type="checkbox" name="bid" value="${l.id}"/>
					</td>
					<td class="title">${l.bookname }</td>
					<td>${l.b_price }</td>
					<td>${l.stock}&nbsp;</td>
					<td class="thumb"><img src="${l.image}" /></td>
				   </tr>
				</c:forEach>
				<tr>
				   <td colspan="5">
				      <input type="button" id="b1" value="首页">&nbsp;
				      <span style="color: blue; font-weight: bold;">第${page}页</span>&nbsp;&nbsp;&nbsp;
				      <input type="button" id="b2" value="上一页">&nbsp;
				      <input type="button" id="b3" value="下一页">&nbsp;
				      <span style="color: blue; font-weight: bold;" id="lastPage">共${lastPage}页</span>
				      <input type="button" id="b4" value="尾页">&nbsp;
				      <input type="hidden" id="page" value="${page}">
				      <input type="hidden" id="last" value="${lastPage}">
				      <input type="hidden" name="username" value="${user.username}">
				   </td>
				</tr>
			</table>
			
			<div class="button"><input class="input-btn" type="submit" name="submit" value=""/></div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	北大青鸟网上书城 &copy; 版权所有

</div>
</body>
</html>
   