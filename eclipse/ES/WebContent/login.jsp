<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
	<style>
		body{
			background:url(image/111.jpg) no-repeat center center;
			background-size:cover;
		}
		*{
			margin: 0;
		}
		.f0{
			margin: 100px auto;
			width: 400px;
		}
		.f1{
			height: 70px;
			background: #F85252;
			border-radius: 20px 20px 0 0;
		}
		.f1 h2{
			color: white;
			height: 70px;
			line-height: 70px;
			text-align: center;
		}
		.f2{
			height: 250px;
			border-radius: 0 0 20px 20px;
			overflow: hidden;
			background: rgba(255,255,255,0.7);
		}
		form{
			text-align: center;
		}
		.f2 form p{
			color: blue;
			text-align: left;
			font-size: 16px;
			font-family: "黑体";
			margin-left: 38px;
			margin-top: 22px;
			margin-bottom: 15px;
		}
		input{
			width: 310px;
			height: 30px;
			background: #fff;
			padding-left: 15px;
			outline:none;
			border: none;
			font-size: 14px;
			font-family: '微软雅黑';
		}
		.f3{
			padding: 0;
			width: 95px;
			height: 30px;
			color: white;
			background: #38CD79;
			margin-top: 23px;
		}
	</style>
	
	<script type="text/javascript">
	    function fun(){
	    	window.document.location.href="save.jsp";
	    	
	    }
	</script>
</head>
<body>
	<div class="f0">
		<div class="f1">
			<h2>Sign In</h2>
		</div>
		<div class="f2">
			<form action="login.do" method="post">
				<p>账号</p>
				<input type="text" name="username" placeholder="输入您的账号" required="required">
				<p>密码</p>
				<input type="password" name="password" placeholder="输入您的密码" required="required">
				<input class="f3" type="submit" value="登录">&nbsp;
				<input class="f3" type="button" value="注册账号" onclick="fun()">
			</form>
		</div>
	</div>
</body>
</html>