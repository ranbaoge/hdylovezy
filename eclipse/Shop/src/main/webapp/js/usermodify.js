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
	
	
});