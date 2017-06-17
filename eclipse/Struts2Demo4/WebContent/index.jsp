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
   <!-- struts2表单标签的使用 -->
   <form action="login.action" method="post">
        <!-- 文本输入框 -->
        <span>用户名:</span><s:textfield name="user.username"/><br>
        <!-- 密码输入框 -->
        <span>密码:</span><s:password name="user.password"/><br>
        <!-- 单选框 -->
        <span>性别:</span><s:radio list="#{'男':'男','女':'女' }" name="user.gender" value="男"></s:radio><br>
        <span>年龄:</span><input type="text" name="user.age"><br>
        <!-- 复选框 -->
        <span>兴趣:</span><s:checkboxlist list="#{'游戏':'游戏','音乐':'音乐','编程':'编程','篮球':'篮球'}" name="user.hobby" value="游戏"></s:checkboxlist><br>
        <!-- 文本域 -->
        <span>地址:</span><s:textarea cols="50" rows="4" name="user.address"></s:textarea><br>
        <!-- 提交表单 -->
        <s:submit value="登录"/>&nbsp;
        <!-- 重置表单 -->
        <s:reset value="重置"/>
   </form>
   
</body>
</html>