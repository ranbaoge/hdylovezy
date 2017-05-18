//验证登录
function validate(){
	var password=document.getElementsByName("password")[0].value;
	
	//验证密码长度
	if(password.length<5){
		sp2.innerHTML="*密码长度过短";
		sp2.style.color="red";
	}else{
		sp2.innerHTML="√";
	    sp2.style.color="blue";
	}
}