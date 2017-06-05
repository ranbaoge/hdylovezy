//修改密码
$(function(){
	
	$("#save").click(function(){
		//获取用户名姓名
	    var username=$("#username").val();	
		//获取原密码
		var oldpassword=$("#oldpassword").val();
		//获取新密码
		var newpassword=$("#newpassword").val();
		//获取重复新密码
		var rnewpassword=$("#rnewpassword").val();
		//获取目标根目录
		var ctx=$("#ctx").val();
		
		//验证密码是否一致
		if(newpassword==rnewpassword){
			$("#renewpwd").html("");
			//触发密码提交事件
			$("#save").click(function(){
				//使用ajax验证原密码是否正确
				$.getJSON(ctx+"/user/validate",{username:username,password:oldpassword},fun);
			});
			
			function fun(data){
				
				if(data.flag=="true"){
					$("#userForm").submit();
				}else{
					alert("用户名的名的密码不正确");
				}
			}
		}else{
			$("#renewpwd").html("两次新密码不一致!!!");
		}
	});
	
	
});
