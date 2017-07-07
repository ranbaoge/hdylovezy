/**
 * 
 */

$(function(){
	//触发查询Role的ajax请求
	$("#rolename").blur(function(){
		$.getJSON("../user/queryAllRole",null,fun);
		
		function fun(data){
			var rolename=$("#rolename");
			for(var i=0;i<data.length;i++){
				rolename.append("<option value="+"\""+data[i].rolename+"\">"+data[i].rolename+"</option>");
			}
		}
	});
});