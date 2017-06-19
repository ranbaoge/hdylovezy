<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>viewUser</h1>
   <a href="${flowExecutionUrl}&_eventId=submit">Submit</a>
   <hr>
   <div>
      <table>
          <tr>
             <th colspan="3">用户数据展示</th>
          </tr>
          <tr>
             <td>用户名</td>
             <td>密码</td>
             <td>真实姓名</td>
          </tr>
          <c:forEach items="${users}" var="u">
            <tr>
             <td>${u.username}</td>
             <td>${u.password}</td>
             <td>${u.truename}</td>
           </tr>
          </c:forEach>
      </table>
   </div>
</body>
</html>