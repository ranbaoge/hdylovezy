<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table>
        <tr>
           <td>用户编号</td>
           <td>用户名</td>
           <td>密码</td>
           <td>身份证号码</td>
        </tr>
        <s:if test="#session.list!=null">
            <s:iterator value="#session.list" var="l">
              <tr>
               <td><s:property value="#l.id"/> </td>
               <td><s:property value="#l.username"/></td>
               <td><s:property value="#l.password"/></td>
               <td><s:property value="#l.idCard.no"/></td>
             </tr>
            </s:iterator>
        </s:if>
        <s:else>
           <tr>
              <td style="color: red;">没有你想要的数据</td>
           </tr>
        </s:else>
    </table>
</body>
</html>