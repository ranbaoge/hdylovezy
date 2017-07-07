/**
 * 
 */

$(function(){
	//取得当前页值
	var page=$("#page").val();
	//取得尾页值
	var lastPage=$("#lastPage").val();
	
	var key=$("#key").val();
	var rolename=$("#rolename").val();
	
	//触发首页按钮
	$("#b1").click(function(){
		window.location.href="../user/query?page=1&key="+key+"&rolename="+rolename;
	});
	
	//触发尾页按钮
	$("#b4").click(function(){
		window.location.href="../user/query?page="+lastPage+"&key="+key+"&rolename="+rolename;
	});
	
	//触发上一页按钮
	$("#b2").click(function(){
		if(page<=1){
			page=1;
		}else{
			page--;
		}
		window.location.href="../user/query?page="+page+"&key="+key+"&rolename="+rolename;
	});
	
	//触发下一页按钮
	$("#b3").click(function(){
		if(page>=lastPage){
			page=lastPage;
		}else{
			page++;
		}
		window.location.href="../user/query?page="+page+"&key="+key+"&rolename="+rolename;
	});
	
	//触发跳转按钮
	$("#b5").click(function(){
		var inputpage=$("#ipage").val();
		window.location.href="../user/query?page="+inputpage;
	});
	
	//触发查询Role的ajax请求
	$("#rolename").blur(function(){
		$.getJSON("user/queryAllRole",null,fun);
		
		function fun(data){
			var rolename=$("#rolename");
			for(var i=0;i<data.length;i++){
				rolename.append("<option value="+data.rolename+">"+data.rolename+"</option>");
			}
		}
	});
});