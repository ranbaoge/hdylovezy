<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="${ctx}/user/save?page=1">
                <div>
                    <input type="hidden" name=createdby id="createdby" value="<%=request.getParameter("createdby") %>"> 
                </div>
                <div>
                    <label for="userCode">用户编码：</label>
                    <input type="text" name="usercode" id="usercode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red" id="code"></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="username" id="username" value=""> 
					<font color="red" id="name"></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userpassword" id="userpassword" value=""> 
					<font color="red" id="pwd"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" id="ruserPassword" value=""> 
					<font color="red" id="repwd"></font>
                </div>
                <div>
                    <label >用户性别：</label>
                    <input type="radio" name="gender" value="1" checked="checked">女&nbsp;
                    <input type="radio" name="gender" value="2">男
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red" id="ph"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                   <font color="red" id="add"></font>
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<select name="userrole" id="userRole">
					
					</select>
	        		<font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" id="add" value="保存">
					<input type="button" id="back" value="重置" >
					<input type="hidden" value="${ctx}" id="ctx">
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/useradd.js"></script>
