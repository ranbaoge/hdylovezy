<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		var page=$("#page").val();
		var lastPage=$("#lastPage").val();
		
		//首页按钮
		$("#b1").click(function(){
			window.location.href="${ctx}/user/query?page=1";
		});
		
		//上一页按钮
		$("#b2").click(function(){
			if(page<=1){
				page=1;
			}else{
				page--;
			}
			window.location.href="${ctx}/user/query?page="+page;
		});
		
		//下一页按钮
		$("#b3").click(function(){
			if(page>=lastPage){
				page=lastPage;
			}else{
				page++;
			}
			window.location.href="${ctx}/user/query?page="+page;
		});
		
		//尾页按钮
		$("#b4").click(function(){
			window.location.href="${ctx}/user/query?page="+lastPage;
		});
		
	});
</script>

<style type="text/css">
   .page-bar{
      font-size: 16px;
      font-weight: 400;
      left: 500px;
   }
</style>
</head>
<body>
 		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li> 
				   <input type="button" value="首页" id="b1">&nbsp;
				   <span>共${count }条</span>&nbsp;&nbsp;
				   <input type="button" value="上一页" id="b2">&nbsp;
				   <input type="button" value="下一页" id="b3">&nbsp;
				   <span>共${lastPage}页</span>
				   <input type="button" value="尾页" id="b4">&nbsp;
				   <input type="hidden" value="${page }" id="page">
				   <input type="hidden" value="${lastPage }" id="lastPage">
				</li>
				
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rollpage.js"></script>
</html>