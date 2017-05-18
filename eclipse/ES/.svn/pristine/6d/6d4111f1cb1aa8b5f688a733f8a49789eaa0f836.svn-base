<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户密码</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
      $(function(){
    	  $("#button").click(function(){
    		  var username=$("#username").val();
    		  var repassword=$("#repassword").val();
    		  var repassword1=$("#repassword1").val();
    		  if(repassword==repassword1){
    			 $("#form").submit();
    		 }else{
    			 alert("输入两次新密码不一致");
    			 $("#repassword1").val("");
    			 $("#repassword").val("");
    		 }
    	  });
      });
</script>

<style type="text/css">
  body{
      background-image: url("image/2.jpg");
     }
</style>
</head>
<body>
    <form action="repassword.do?page=1" method="post" id="form">
      <fieldset>
        <legend>用户密码修改</legend>
        <label for="username">用户名:</label>
        <input type="text" name="username" id="username" value="<%=request.getParameter("username") %>" readonly="readonly"><br>
        <label for="repassword">新密码:</label>
        <input type="password" name="repassword" id="repassword"><br>
        <label for="repassword1">重复新密码:</label>
        <input type="password" name="repassword1" id="repassword1"><br>
        <input type="button" value="提交" id="button">&nbsp;&nbsp;
        <input type="reset" value="重置">
     </fieldset>
    </form>
</body>
</html>