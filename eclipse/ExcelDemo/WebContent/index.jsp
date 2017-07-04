<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">
    table{
      border: 1px solid black;
      width: 800px;
      border-collapse: collapse;
      text-align: center;
    }
    
    td,th{
        border: 1px solid black;   
    }
    
    tr{
       height: 40px;
    }
 
 </style>
</head>
<body>
    <table>
        <tr>
           <th colspan="7">用户信息显示</th>
        </tr>
        <tr>
           <td>用户ID</td>
           <td>用户名</td>
           <td>密码</td>
           <td>性别</td>
           <td>年龄</td>
           <td>手机</td>
           <td>地址</td>
        </tr>
        <c:forEach items="${list}" var="l">
          <tr>
             <td>${l.id }</td>
             <td>${l.username}</td>
             <td>${l.password}</td>
             <td>${l.gender}</td>
             <td>${l.age}</td>
             <td>${l.phone}</td>
             <td>${l.address}</td>
          </tr>
        </c:forEach>
        <tr>
           <td colspan="7"><a href="ExcelServlet?flag=excel">导出Excel表</a></td>
        </tr>
    </table>
</body>
</html>