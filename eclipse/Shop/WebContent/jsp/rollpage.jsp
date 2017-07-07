<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页跳转</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js">
</script>
</head>
<body>
 		<div class="page-bar">
			   <tr align="center">
			      <td colspan="8">
			       <input type="button" value="首页" id="b1">&nbsp;
				   <span style="color: blue;">共${count}条记录&nbsp;&nbsp;第${page }页</span>
				   <input type="button" value="上一页" id="b2">&nbsp;
				   <input type="button" value="下一页" id="b3">&nbsp;
				   <span style="color: blue;">共${lastPage}页&nbsp;&nbsp;</span>
				   <input type="button" value="尾页" id="b4">&nbsp;
				   <input type="hidden" value="${page}" id="page">
				   <input type="hidden" value="${lastPage }" id="lastPage">
				   
				  <span><label>跳转至</label>
	              <input type="text" name="inputpage" id="ipage" size="1"/>页
	              <button type="button" id="b5">GO</button>
		          </span>
			      </td>
			   </tr>
		 
		</div> 
</body>
<script type="text/javascript" src="${ctx}/js/rollpage.js"></script>
</html>