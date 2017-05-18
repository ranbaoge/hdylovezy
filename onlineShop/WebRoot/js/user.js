//验证注册用户信息
function validate(){
	var password=document.getElementsByName("password")[0].value;
	var repassword=document.getElementsByName("repassword")[0].value;
	var email=document.getElementsByName("email")[0].value;
	var sp2=document.getElementById("sp2");
	var sp3=document.getElementById("sp3");
	var sp4=document.getElementById("sp4");
	//验证密码长度
	if(password.length<5){
		sp2.innerHTML="*密码长度过短";
		sp2.style.color="red";
	}else{
		sp2.innerHTML="√";
	    sp2.style.color="blue";
	}
	
	//验证二次密码是否一致
	if(password!=repassword){
		sp3.innerHTML="二次密码不一致";
		sp3.style.color="red";
	}else{
		sp3.innerHTML="√";
	    sp3.style.color="blue";
	}
	
	//正则表达式验证邮箱
	var reg=/^[A-Za-zd0-9]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/; 
	//验证是否通过正则表达式
	var va=reg.test(email);
	if(va==false){
		sp4.innerHTML="邮箱格式不正确";
		sp4.style.color="red";
	}else{
		sp4.innerHTML="√";
	    sp4.style.color="blue";
	}
	
}

