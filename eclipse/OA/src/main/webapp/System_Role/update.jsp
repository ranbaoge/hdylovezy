<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色信息</title>
	<script language="javascript" src="../script/jquery.js"></script>
    <script language="javascript" src="../script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="../script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="../script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="../script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="../style/blue/pageCommon.css" />
    <script type="text/javascript"> 
    </script>
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 岗位设置
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <form action="update.do?page=1" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                   <tr>
                        <td width="100">角色ID</td>
                        <td><input type="text" name="id" class="InputStyle" value="<%=request.getParameter("id") %>" readonly="readonly"/> *</td>
                    </tr>
                    <tr>
                        <td width="100">岗位名称</td>
                        <td><input type="text" name="name" class="InputStyle" /> *</td>
                    </tr>
                    <tr>
                        <td>岗位说明</td>
                        <td><textarea name="description" class="TextareaStyle"></textarea></td>
                    </tr>
                    <tr>
                        <td>用户ID</td>
                        <td><input type="text" name="userId" class="InputStyle"></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="submit" value="保存" style="color: blue;">&nbsp;&nbsp;
            <input type="reset" value="重置" style="color: blue;">
            <!-- <input type="image" src="../style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="../style/images/goBack.png"/></a> -->
        </div>
    </form>
</div>

</body>
</html>