<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册页面</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/user.js"></script>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
     //使用Ajax无刷新进行验证
     $(function(){
       //通过js取标签值
      $("#username").blur(function(){
          var username=$(this).val();
         //使用jquery简化ajxa写法
         $.ajax({
           //发送的url请求
           url:"UserServlet?flag=register",
           //发送请求的类型
           type:"GET",
           //发送的数据
           data:"username="+username,
           //返回的数据类型
           dataType:"text",
           //定义回调函数
           success:fun
        });
        
        function fun(data){
           if(data=="true"){
              $("#sp1").html("用户可用");
              $("#sp1").css("color","green");
           }else{
              $("#sp1").html("用户以被注册");
              $("#sp1").css("color","red");
           }
        }
        });
     });
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">北大青鸟网上书城</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="register">
	<div class="title">
		<h2>欢迎注册北大青鸟网上书城</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="current">1.填写注册信息</li>
			<li class="unpass">2.注册成功</li>
		</ul>
	</div>
	<form method="post" action="UserServlet?flag=save">
		<dl>
			<dt>用 户 名：</dt>
			<dd><input class="input-text" type="text" name="username" id="username"/><span id="sp1"></span></dd>
			<dt>密　　码：</dt>
			<dd><input class="input-text" type="password" name="password" onblur="validate()"/><span id="sp2"></span></dd>
			<dt>确认密码：</dt>
			<dd><input class="input-text" type="password" name="repassword" onblur="validate()"/><span id="sp3"></span></dd>
			<dt>Email地址：</dt>
			<dd><input class="input-text" type="text" name="email" onblur="validate()"/><span id="sp4"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	北大青鸟网上书城 &copy; 版权所有
</div>
</body>
</html>
    