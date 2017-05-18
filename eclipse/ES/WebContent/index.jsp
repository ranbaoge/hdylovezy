<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
  body{
      background-image: url("image/2.jpg");
     }
  .frame{
     position: relative;
     top: 100px;
  }
  #top{
     width: 100%;
     height: 10px;
  }
  h3{
     margin: 0px;
     padding: 0px;
     font-size: 25px;
  }
</style>
</head>
<body>
    <div id="top">
       <h3>欢迎你&nbsp;<span style="color: #57BFFA; font-weight: bold;"><%=session.getAttribute("username") %><span></h3>
    </div>
    <iframe src="left.jsp" width="20%" height="600px" name="left" class="frame" frameborder="1"></iframe>
    <iframe src="" width="78%" height="600px" name="rightFrame" class="frame" frameborder="1"></iframe><br>
</body>
</html>