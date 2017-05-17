<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="../script/jquery.js"></script>
    <script language="javascript" src="../script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="../script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="../script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="../script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="../style/blue/pageCommon.css" />
    <script type="text/javascript">
        $(function(){
        	$("#btn").click(function(){
        		var re=$("#re").val();
        		var register=$("#register").val();
        		alert(re+"\t"+register);
        		if(re==register){
        			$("#btn").submit();
        		}else{
        			alert("二次输入新密码不一致");
        		}
        	});
        });
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="update.do?page=1" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="../style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td>登录名</td>
                        <td><input type="text" name="loginname" class="InputStyle"/> *
						</td>
                    </tr>
                    <tr><td>原密码</td>
                        <td><input type="text" name="password" class="InputStyle"/> *
						</td>
                    </tr>
                    <tr><td>新密码</td>
                        <td><input type="text" name="repassword" class="InputStyle" id="re"/> *
						</td>
                    </tr>
                    <tr><td>新密码验证</td>
                        <td><input type="text" name="repasswordRegister" class="InputStyle" id="register"/> *
						</td>
                    </tr>
                    <tr>
                      <td>
                      </td>
                      <td>
                         <input type="button" value="保存" style="color: blue;" id="btn">&nbsp;&nbsp;
                         <input type="reset" value="重置" style="color: blue;">
                      </td>
                    </tr>
                </table>
            </div>
        </div>
        
    </form>
</div>


</body>
</html>