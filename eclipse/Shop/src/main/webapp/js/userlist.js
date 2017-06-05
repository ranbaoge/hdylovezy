$(function(){
    //修改提示
	$(".modifyUser").click(function(){
		if(confirm("确定修改吗？")){
			return true;
		}else{
			return false;
		}
	});
	
	//删除提示
	$(".deleteUser").click(function(){
		if(confirm("确定删除吗？")){
			return true;
		}else{
			return false;
		}
	});
	
	//查询提示
	$(".viewUser").click(function(){
		if(confirm("确定查询个人信息吗？")){
			return true;
		}else{
			return false;
		}
	});
	
	
	//通过Ajax查询个人信息
	$(".viewUser").click(function(){
		var ctx=$("#ctx").val();
		var uid=$(".uid").val();
		$.getJSON(ctx+"/user/queryById","id="+uid,fun);
		
		function fun(data){
			$("#info p").remove();
			$("#info").css("background-color","#F7F3EA");
			$("#info").css("border","1px solid blue");
			$("#info").css("height","400px");
			$("#info").css("font-size","30px");
			
			$("#info").append("<p>用户名:<span>"+data.usercode+"</span></p>"+
					          "<p>用户名称:<span>"+data.username+"</span></p>"+
					          "<p>用户性别:<span>"+data.gender+"</span></p>"+
					          "<p>出生日期:<span>"+data.birthday+"</span></p>"+
					          "<p>用户电话:<span>"+data.phone+"</span></p>"+
					          "<p>用户地址:<span>"+data.address+"</span></p>"+
					          "<p>用户角色:<span>"+data.role.rolename+"</span></p>");
		}
		
		
	});
	
	
});