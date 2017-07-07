<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息显示</title>
<script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript">
     $(function(){
    	 var page=$("#page").val();
    	 var lastPage=$("#lastPage").val();
    	 
    	 //触发首页按钮
    	 $("#b1").click(function(){
    		 window.location.href="query?page=1";
    	 });
    	 
    	 //触发尾页按钮
    	 $("#b4").click(function(){
    		 window.location.href="query?page="+lastPage;
    	 });
    	 
    	 //触发上一页按钮
    	 $("#b2").click(function(){
    		 if(page<=1){
    			 page=1;
    		 }else{
    			 page--;
    		 }
    		 window.location.href="query?page="+page;
    	 });
    	 
    	 //触发下一页
    	 $("#b3").click(function(){
    		 if(page>=lastPage){
    			 page=lastPage;
    		 }else{
    			 page++;
    		 }
    		 window.location.href="query?page="+page;
    	 });
    	 
    	 //隔行变色
    	 $(".tr:even").css("background-color","red");
    	 
     });
  </script>
  <style type="text/css">
     table{
       border: 1px solid black;
       width: 1200px;
       border-collapse: collapse;
       text-align: center;
     }
  
     th,td{
      border: 1px solid black;
      padding: 10px;
     }
     
     tr{
       height: 30px;
     }
  </style>
</head>
<body>
    <div>
        <table>
           <tr>
              <th colspan="8">书籍信息展示</th>
           </tr>
           <tr>
              <td>书籍ID</td>
              <td>书籍名称</td>
              <td>作者</td>
              <td>出版社</td>
              <td>出版时间</td>
              <td>价格</td>
              <td>类型</td>
              <td>编辑</td>
           </tr>
           <c:forEach items="${list}" var="l">
             <tr class="tr">
              <td>${l.id }</td>
              <td>${l.name }</td>
              <td>${l.author }</td>
              <td>${l.publisher }</td>
              <td><fmt:formatDate value="${l.publishDate }" pattern="yyyy-MM-dd"/></td>
              <td>${l.price }</td>
              <td>${l.category.name}</td>
              <td>
                 <a href="update.jsp?id=${l.id}">修改</a>&nbsp;
                 <a href="delete?id=${l.id}">删除</a>
              </td>
            </tr>
           </c:forEach>
           <tr align="center">
              <td colspan="8">
                 <input type="button" value="首页" id="b1">&nbsp;
                 <span>第${page}页</span>&nbsp;
                 <input type="button" value="上一页" id="b2">&nbsp;
                 <input type="button" value="下一页" id="b3">&nbsp;
                 <span>共${lastPage}页</span>&nbsp;
                 <input type="button" value="尾页" id="b4">&nbsp;
                 <input type="hidden" value="${page}" id="page">
                 <input type="hidden" value="${lastPage}" id="lastPage">
              </td>
           </tr>
        </table>
    
    </div>
</body>
</html>