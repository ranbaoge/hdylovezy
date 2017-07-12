<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
   <iframe width="100%" height="50px" frameborder="1" name="top"
    scrolling="no" src="top.jsp" marginheight="0" marginwidth="0">
   </iframe>
   <iframe width="15%" height="650px" frameborder="1" name="left"
   scrolling="no" src="left.jsp" marginheight="0" marginwidth="0">
   </iframe>
   <iframe width="83%" height="650px" frameborder="1" name="right"
   scrolling="yes" src="right.jsp" marginheight="0" marginwidth="0">
   </iframe>
   <iframe width="100%" height="65px" frameborder="1" name="top"
    scrolling="no" src="foot.jsp" marginheight="0" marginwidth="0">
   </iframe>
</body>
</html>