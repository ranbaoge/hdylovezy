<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${ctx}/user/update?page=1">
             <div>
                <input type="hidden" name="modifyby" id="modifyby" value="<%=request.getParameter("modifyby") %>"> 
             </div>
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="username" id="userName" value="<%=request.getParameter("username") %>" readonly="readonly"> 
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                    <input type="radio" name="gender" value="1" checked="checked">女&nbsp;
                    <input type="radio" name="gender" value="2">男
             </div>
			 <div>
                    <label for="data">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday"
					readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="phone"> 
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="address">
                </div>
				<div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<input type="hidden" id="rid" />
					<select name="userrole" id="userRole">
					
					</select>
        			<font color="red"></font>
                </div>
			 <div class="providerAddBtn">
                    <input type="submit"  id="save" value="修改" />
                    <input type="button" id="back" value="返回"/>
                    <input type="hidden" value="${ctx}" id="ctx">
                </div>
            </form>
        </div>
    </div>
    
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/usermodify.js"></script>
