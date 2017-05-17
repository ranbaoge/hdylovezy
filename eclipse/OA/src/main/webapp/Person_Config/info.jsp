<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
    <script language="javascript" src="../script/jquery.js"></script>
    <script language="javascript" src="../script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="../script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="../script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="../script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="../style/blue/pageCommon.css" />
    <style type="text/css">
        td{
          font-size: 18px;
        }
        tr{
          height: 30px;
        }
        .text00{
         color: orange;
         font-size: 20px;
        }
    </style>
    <script type="text/javascript">
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 个人信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表内容-->
<div id=MainArea>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 个人信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr>
                        <td width="150">用户名</td>
                        <td class="text00"><%=request.getSession().getAttribute("loginname") %></td>
						<td rowspan="5" align="right">
							<img src="../style/images/defaultAvatar.gif"/>
						</td>
                    </tr>
                    <tr>
                        <td>部门</td>
                        <td class="text00"><%=request.getSession().getAttribute("department") %></td>
                    </tr>
					<tr>
                        <td>岗位</td>
                        <td class="text00">
                           <c:forEach items="<%=request.getSession().getAttribute(\"role\")%>" var="r">
                               ${r.name}&nbsp;
                           </c:forEach> 
                        </td>
                    </tr>
					<tr>
                        <td>姓名</td>
                        <td class="text00"><%=request.getSession().getAttribute("username")%></td>
                    </tr>
                </table>
            </div>
        </div>
       
</div>

<div class="Description">
</div>

</body>
</html>