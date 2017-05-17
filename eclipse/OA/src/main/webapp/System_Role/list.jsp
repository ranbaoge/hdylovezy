<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
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
         font-family: "宋体";
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
  		 window.location.href="query.do?page="+goPage;
  	 });
  	 
  	 //新建角色
  	 $("#save").click(function(){
  		 window.location.href="save.jsp";
  	 });
  	 
   });
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 岗位管理|
             <button id="save">新建</button>
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
                <td width=10%">角色</td>
            	<td width="20%">岗位名称</td>
                <td width="50%">岗位说明</td>
                <td width="20%">相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
		<c:forEach items="${list}" var="l">
		   <tr class="TableDetail1 template">
		        <td><img alt="角色" src="../style/images/MenuIcon/FUNC20001.gif"></td>
				<td>${l.name}&nbsp;</td>
				<td>${l.description}&nbsp;</td>
				<td><a onClick="return delConfirm()" href="delete.do?id=${l.id}&page=1">
                       <img alt="删除" src="../style/images/delete.gif" class="delete">
                    </a>&nbsp;
                    <a href="update.jsp?id=${l.id}">
                       <img alt="修改" src="../style/images/icq.gif" class="update"> 
                    </a>
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
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        </div>
    </div>
</div>
</body>
</html>