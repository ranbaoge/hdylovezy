<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <input type="hidden" value="${ctx}" id="ctx">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="get" action="${pageContext.request.contextPath }/user/query1">
					 <span>用户名：</span>
					 <input name="username" class="input-text"	type="text" value="${queryUserName }">
					 
					 <span>用户角色：</span>
					 <select name="rolename">
						<c:if test="${role!= null}">
						   <option value="">--请选择--</option>
						   <c:forEach var="r" items="${role}">
						   		<option  value="${r.rolename}">${r.rolename}</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="${pageContext.request.contextPath}/jsp/useradd.jsp?createdby=${u.userrole}" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">出生日期</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                </tr>
                   <c:forEach var="l" items="${list }" varStatus="status">
					<tr>
						<td>
						<span>${l.usercode}</span>
						</td>
						<td>
						<span>${l.username }</span>
						</td>
						<td>
							<span>
								<c:if test="${l.gender==1}">女</c:if>
								<c:if test="${l.gender==2}">男</c:if>
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
						<span>
						   <a class="viewUser">
						        <input type="hidden" value="${l.id}" class="uid">
						        <img src="${ctx}/images/read.png" alt="查看" title="查看"/>
						   </a>
						</span>
						<span><a class="modifyUser" href="${ctx}/jsp/usermodify.jsp?username=${l.username}&modifyby=${u.userrole}"><img src="${ctx}/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteUser" href="${ctx}/user/delete?id=${l.id}&page=1"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div id="info">
                 
            </div>
			
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
          	
        </div>
       
    </section>
     

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userlist.js"></script>
