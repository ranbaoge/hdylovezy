<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
    <f:view>
        <h:form>
           <span>用户名:</span><h:inputText value="#{user.username}"/><br>
           <span>密码:</span><h:inputText value="#{user.password}"/><br>
           <h:commandButton value="登录" action="#{user.validate}"/>
        </h:form>
    </f:view>
</body>
</html>