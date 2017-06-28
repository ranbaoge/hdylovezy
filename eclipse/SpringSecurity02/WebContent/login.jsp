<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="login.do" var="login"></c:url>
<title>登录页面</title>
</head>
<body>
    <form action="${login}" method="post">
        <span>用户名:</span><input type="text" name="username"><br>
        <span>密码:</span><input type="password" name="password"><br>
        <!-- 设置token -->
        <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf_token }"> --%>
        <input type="submit" value="登录">
    </form>
</body>
</html>