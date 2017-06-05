//使用Ajax加载role信息
$(function(){
	//获取目标根路径
	var ctx=$("#ctx").val();
	//触发事件发送ajax请求
	$("#userRole").blur(function(){
		$.ajax({
			 url:ctx+"/user/queryRole",
			 data:null,
			 type:"GET",
			 dataType:"json",
			 success:fun
		 });
		 
		 //回调函数
		 function fun(data){
			 $("option").remove();
			 for(var i=0;i<data.length;i++){
				 $("#userRole").append("<option value='"+data[i].id+"'>"+data[i].rolename+"</option>");
			 }
		 }
	});
	
	
	//判断用户编码的长度
	$("#usercode").blur(function(){
		var usercode=$(this).val();
		if(usercode==null || usercode==""){
			$("#code").html("用户编码不能为空");
			$("#code").css("color","red");
		}else if(usercode.length<4 || usercode.length>16){
			$("#code").html("用户编码的长度不能小于4或者大于16");
			$("#code").css("color","red");
		}else{
			$("#code").html("√");
			$("#code").css("color","green");
		}
	});
	
	//判断用户名的长度
	$("#username").blur(function(){
		var username=$(this).val();
		if(username==null || username==""){
			$("#name").html("用户名不能为空");
			$("#name").css("color","red");
		}else if(username.length<2 || username.length>16){
			$("#name").html("用户名的长度不能小于2或者大于16");
			$("#name").css("color","red");
		}else{
			$("#name").html("√");
			$("#name").css("color","green");
		}
	});
	
	//判断密码的长度
	$("#userpassword").blur(function(){
		var userpassword=$(this).val();
		if(userpassword==null || userpassword==""){
			$("#pwd").html("密码不能为空");
			$("#pwd").css("color","red");
		}else if(userpassword.length<6 || userpassword.length>16){
			$("#pwd").html("密码的长度不能小于6或者大于16");
			$("#pwd").css("color","red");
		}else{
			$("#pwd").html("√");
			$("#pwd").css("color","green");
		}
	});
	
	//二次确认密码
	$("#ruserPassword").blur(function(){
		var userpassword=$("#userpassword").val();
		var ruserPassword=$(this).val();
		if(userpassword!=ruserPassword){
			$("#repwd").html("两次密码不一致");
			$("#repwd").css("color","red");
		}else{
			$("#repwd").html("√");
			$("#repwd").css("color","green");
		}
	});
	
	//判断电话号码的长度
	$("#phone").blur(function(){
		var phone=$(this).val();
		if(phone==null || phone==""){
			$("#ph").html("电话号码不能为空");
			$("#ph").css("color","red");
		}else if(phone.length<11 || phone.length>16){
			$("#ph").html("电话号码的长度不能小于11或者大于16");
			$("#ph").css("color","red");
		}else{
			$("#ph").html("√");
			$("#ph").css("color","green");
		}
	});
	
	//判断地址是否为空
	$("#address").blur(function(){
		var address=$(this).val();
		if(address==null || address==""){
			$("#add").html("地址不能为空");
			$("#add").css("color","red");
		}else{
			$("#add").html("√");
			$("#add").css("color","green");
		}
	});
	
	
});