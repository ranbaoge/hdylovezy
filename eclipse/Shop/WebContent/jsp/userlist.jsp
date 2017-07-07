<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="get" action="${ctx}/user/query">
					 <span>用户名：</span>
					 <input name="key" class="key" type="text" value="${key}">
					 <input type="hidden" name="page" value="1">
					 <span>用户角色：</span>
					 <select name="rolename" id="rolename">
					    <option value="${rolename }">${rolename}</option>
					 </select>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="${ctx}/jsp/useradd.jsp" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                </tr>
                   <c:forEach var="l" items="${list}" varStatus="status">
					<tr>
						<td>
						<span>${l.usercode }</span>
						</td>
						<td>
						<span>${l.username}</span>
						</td>
						<td>
							<span>
								<c:if test="${l.gender==1}">男</c:if>
								<c:if test="${l.gender==2}">女</c:if>
							</span>
						</td>
						<td>
						<span><fmt:formatDate value="${l.birthday}" pattern="yyyy-MM-dd"/></span>
						</td>
						<td>
						<span>${l.phone}</span>
						</td>
						<td>
							<span>${l.role.rolename}</span>
						</td>
						<td>
						<span><a href="#"><img src="${ctx}/images/read.png" alt="查看" title="查看"/></a></span>
						<span><a href="#"><img src="${ctx}/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a href="#s"><img src="${ctx}/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
		  	<c:import url="rollpage.jsp">
          	</c:import>
			</table>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/userlist.js"></script>
