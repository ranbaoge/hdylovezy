<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="logout.do" var="logout"></c:url>
<title>退出页面</title>
</head>
<body>
   <form action="${logout}" method="post">
        <!-- 设置token -->
        <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf_token }"> --%>
        <input type="submit" value="退出">
    </form> 
</body>
</html>