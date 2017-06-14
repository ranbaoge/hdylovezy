<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
   <div>
     <s:fielderror/>
   </div>
   <form action="login.action" method="post">
        <span>用户名:</span><input type="text" name="username"><br>
        <span>密码:</span><input type="password" name="password"><br>
        <input type="submit" value="登录">
   </form>
   <%-- <s:form action="login.action">
        <span>用户名:</span><s:text name="username"/><br>
        <span>密码:</span><s:password name="password"/><br>
        <s:submit value="登录"/>
   </s:form> --%>
</body>
</html>