/**
 * 通过Ajax验证密码
 */


$(function(){
	
	$("#oldpassword").blur(function(){
		//取得旧密码和用户名
		var oldPassword=$("#oldpassword").val();
		var username=$("#username").val();
		//发送Ajax请求
		$.getJSON("../user/validatePassword","usercode="+username+"&userpassword="+oldPassword,fun);
		
		function fun(data){
			if(data.flag=="true"){
				$("#sp").html("密码正确");
				$("#sp").css("color","green");
			}else{
				$("#sp").html("密码错误");
				$("#sp").css("color","red");
			}
		}
	});
	
	
	
	//判断二次密码是否一致
	$("#rnewpassword").blur(function(){
		//取新密码和确认新密码的值
		var newpassword=$("#newpassword").val();
		var rnewpassword=$("#rnewpassword").val();
		
		 if(newpassword==rnewpassword){
			 $("#sp1").html("√");
			 $("#sp1").css("color","green");
		 }else{
			 $("#sp1").html("二次密码不一致");
			 $("#sp1").css("color","red");
		 }
		 
	});
	
	//通过jQuery发送表单数据
	$("#save").click(function(){
		$("#userForm").submit();
	});
});

