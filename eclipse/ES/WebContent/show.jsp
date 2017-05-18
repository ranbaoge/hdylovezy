<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息展示</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	  $("tr:odd").css("background-color","#8DC2E6"); 
	  $("#pageTr").css("background-color","white"); 
	  $(".delete").click(function(){  
		  if(confirm("确定删除吗?")){
			  return true;
		  }else{
			  return false;
		  }
	  });
	  
	 $(".update").click(function(){
		 if(confirm("确定修改吗?")){
			  return true;
		     }else{
			  return false;
		     }
	 });
	 //对上一页与下一页进行处理
	 var page=$("#page").val();
	 var endPage=$("#endPage").val();
	 if(page<=1){
		 $("#upPage").removeAttr("href");
	 }
	 if(page>=endPage){
		 $("#downPage").removeAttr("href");
	 }
	 
	 //跳转页面
	 $("#go").click(function(){
	     var goPage=$("#goPage").val();
		 window.location.href="query.do?page="+goPage;
	 });
	 
	 //添加用户
	 $("#btn").click(function(){
		 if(confirm("添加用户?")){
		   window.location.href="save.jsp"; 
		   return true;
		 }else{
		   return false;
		 }
			 
	 });
	 
	 //设置权限
	 var username=$("#user").val();
	 if(username!="admin"){
		 $(".delete").hide();
		 $(".update").hide();
		 $("#btn").hide();
		 $("#empty").hide();
	 }
	 
	 $("#empty").click(function(){
		 window.location.href="empty.do?page=1";
	 });
	 
	 //返回首页
	 $("#index").click(function(){
		 if(confirm('是否返回首页')){
		   window.location.href="index.jsp";
		  return true;
		 }else{
			 return false;
		 }
	 });
	 
});
 
</script>
<style type="text/css">
     body{
      background-image: url("image/2.jpg");
     }
     #div1{
        width: 1000px;
        position: absolute;
        top: 80px;
        left: 130px;
        
     }
     #tab{
        border: 1px solid blue;
        width: 1000px;
        border-collapse: collapse;
     }
     td,th{
       border: 1px solid orange;
       text-align: center;
     }
     tr{
       height: 40px;
     }
     #span{
        position: relative;
        left: 270px;
        color: red;
        font-weight: bold;
        text-decoration: underline;
        top: 5px;
     }
     #btn{
         position: relative;
         left: 270px;
         color: green;
         top: 2px;
     }
     #empty,#index{
         position: relative;
         left: 270px;
         color: green;
         top: 2px;
     }
</style>
</head>
<body>
     <div id="div1">
        <table id="tab">
            <tr>
                <th colspan="5">用户信息展示&nbsp;
                    <button id="index">返回首页</button>
                    <button id="empty">清空状态</button>
                    <button id="btn">添加用户</button>
                    <span id="span">用户名:<%=request.getSession().getAttribute("username") %></span>
                    <input type="hidden" id="user" value="<%=request.getSession().getAttribute("username") %>">
                </th>
            </tr>
            <tr>
               <td>用户编号</td>
               <td>用户名</td>
               <td>真实姓名</td>
               <td>作业提交状态</td>
               <td>操作</td>
            </tr>
            <c:forEach items="${list}" var="l">
             <tr>
               <td>${l.id }</td>
               <td>${l.username }</td>
               <td>${l.truename }</td>
               <td>${l.state}</td>
               <td>
                  <a href="repassword.jsp?username=${l.username }" class="update">修改密码</a>&nbsp;
                  <a href="delete.do?id=${l.id }&page=1" class="delete">删除</a>
               </td>
            </tr>
            </c:forEach>
            
         <tr id="pageTr" style="color: grey;">
          <td colspan="7" align="center">
            <a href="query.do?page=1">首页</a>&nbsp;&nbsp;
            <a href="query.do?page=${page-1}" id="upPage">上一页</a>&nbsp;&nbsp;
            <a href="query.do?page=${page+1}" id="downPage">下一页</a>&nbsp;&nbsp;
            <span>共${endPage}页</span>&nbsp;&nbsp;
            <span>第${page}页</span>
            <span>共${count}条</span>
                              跳转到<input type="text" id="goPage" size="1">
            <button id="go">Go</button>
            <input type="hidden" id="page" value="${page}">
            <input type="hidden" id="endPage" value="${endPage}">
            <a href="query.do?page=${endPage}">尾页</a>
          </td>
         </tr>
        </table>
     
     </div>
</body>
</html>