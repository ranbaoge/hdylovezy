<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="../script/jquery.js"></script>
    <script language="javascript" src="../script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="../script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="../script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="../script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="../style/blue/pageCommon.css" />
    <style type="text/css">
         td{
           text-align: center;
           font-size: 16px;
           font-style: normal;
         }
         tr{
           height: 30px;
         }
    </style>
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
        	 
        	 //跳转页面
        	 $("#go").click(function(){
        	     var goPage=$("#goPage").val();
        		 window.location.href="query2.do?page="+goPage;
        	 });
        	 
        	 //新建用户
        	 $("#save").click(function(){
        		 window.location.href="save.jsp";
        	 });
        	 
        	 //模糊查询
        	 $("#like").click(function(){
        		 var likeString=$("#likeString").val();
        		 window.location.href="query3.do?page=1&name="+likeString;
        	 });
         });
         
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 用户管理|
            <!-- <a href="saveUI.html"><img src="../style/images/createNew.png" /></a> -->
            <button id="save">新建</button>
            <span>关键字查询:</span><input type="text" size="5" id="likeString">
            <button id="like">查询</button>
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">用户</td>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <c:forEach items="${list}" var="l">
        <!--   <tbody id="TableData" class="dataContainer" datakey="userList"> -->
            <tr class="TableDetail1 template">
                <td><img alt="" src="../style/images/top/user.gif"> </td>
                <td>${l.loginname}&nbsp;</td>
                <td>${l.name}&nbsp;</td>
                <td>${l.department.name}&nbsp;</td>
                <td>
                  <c:forEach items="${l.roleSet}" var="r">
                        <span>${r.name}&nbsp;</span>
                   </c:forEach>
                </td> 
                <td>${l.department.description}&nbsp;</td>
                <td><a onClick="return delConfirm()" href="delete.do?id=${l.id}&page=1">
                       <img alt="删除" src="../style/images/delete.gif" class="delete">
                    </a>&nbsp;
                    <a href="update.jsp?id=${l.id}">
                       <img alt="修改" src="../style/images/icq.gif" class="update"> 
                    </a>
                </td>
            </tr>
          <!--  </tbody> -->
        </c:forEach>
        <tr id="pageTr" style="color: grey;">
          <td colspan="7" align="center">
            <a href="query2.do?page=1">首页</a>&nbsp;&nbsp;
            <a href="query2.do?page=${page-1}" id="upPage">上一页</a>&nbsp;&nbsp;
            <a href="query2.do?page=${page+1}" id="downPage">下一页</a>&nbsp;&nbsp;
            <span>共${endPage}页</span>&nbsp;&nbsp;
            <span>第${page}页</span>
            <span>共${count}条</span>
                              跳转到<input type="text" id="goPage" size="1">
            <button id="go">Go</button>
            <input type="hidden" id="page" value="${page}">
            <input type="hidden" id="endPage" value="${endPage}">
            <a href="query2.do?page=${endPage}">尾页</a>
          </td>
       </tr>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
       <p align="center" style="font-size: 12px;">&copy;www.huangdaye.com&nbsp;&nbsp;版权所限</p>
    </div>
</div>
</body>
</html>