<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页左边</title>
  <style type="text/css">
     ul{
      list-style-type: circle;
      font-size: 18px;
      color: orange;
     }
  </style>
</head>
<body>
    <ul>
      <li><a href="${ctx}/save.jsp" target="right">添加书籍</a></li>
      <li><a href="${ctx}/query?page=1" target="right">查询书籍</a></li>
      <li><a href="${ctx}/chart/chart01.html" target="right">2D图形信息</a></li>
      <li><a href="${ctx}/chart/chart02.html" target="right">3D图形信息</a></li>
    </ul>
</body>
</html>