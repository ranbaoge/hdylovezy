<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
    #tab{
       border: 1px solid black;
       width: 500px;
       border-collapse: collapse;
       position:relative;
       left: 500px;
       top: 100px;
    }
    
    tr{
      height: 30px;
    }
    
    td,th{
      border: 1px solid black;
    }
  
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
   $(function(){
	   $("tr:even").css("background-color","red");
   });
</script>
</head>
<body>
     <div>
         <table id="tab">
              <tr>
                 <th colspan="3" style="background-color: white;">教师信息数据</th>
              </tr>
              <tr>
                <td>教师编号</td>
                <td>教师姓名</td>
                <td>操作</td>
              </tr>
              <c:forEach items="${list }" var="l">
                <tr>
                  <td>${l.id}</td>
                  <td>${l.name}</td>
                  <td>
                     <a href="${ctx}/update.jsp?id=${l.id}">修改</a>&nbsp;
                     <a href="${ctx}/delete.do/${l.id}">删除</a>
                  </td>
                </tr>
              </c:forEach>
         </table>
     </div>
</body>
</html>