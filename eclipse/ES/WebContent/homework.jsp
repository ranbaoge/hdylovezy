<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交作业表单</title>
<style type="text/css">
  body{
      background-image: url("image/2.jpg");
     }
</style>
</head>
<body>
     <form action="upload.do" method="post" enctype="multipart/form-data">
        <fieldset>
          <legend>提交作业表单</legend>
          <label for="username">用户名:</label>
          <input type="text" name="username" id="username" value="<%=request.getSession().getAttribute("username") %>" readonly="readonly"><br>
          <label for="password">上传作业:</label>
          <input type="file" name="file" id="file"><span style="color: red;">*需要上传zip压缩文件</span><br>
          <input type="submit" value="上传">
          <input type="reset" value="重置">
        </fieldset>  
     </form>
</body>
</html>