<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>故障原因管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/disconnectcause/radiusDisconnectcause/">故障原因列表</a></li>
		<shiro:hasPermission name="disconnectcause:radiusDisconnectcause:edit"><li><a href="${ctx}/disconnectcause/radiusDisconnectcause/form">故障原因添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="radiusDisconnectcause" action="${ctx}/disconnectcause/radiusDisconnectcause/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>故障编码：</label>
				<form:input path="errorCode" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>故障原因：</label>
				<form:input path="errorCause" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>备注信息：</label>
				<form:input path="remarks" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>故障编码</th>
				<th>故障原因</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="disconnectcause:radiusDisconnectcause:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="radiusDisconnectcause">
			<tr>
				<td><a href="${ctx}/disconnectcause/radiusDisconnectcause/form?id=${radiusDisconnectcause.id}">
					${radiusDisconnectcause.errorCode}
				</a></td>
				<td>
					${radiusDisconnectcause.errorCause}
				</td>
				<td>
					${radiusDisconnectcause.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${radiusDisconnectcause.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${radiusDisconnectcause.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${radiusDisconnectcause.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${radiusDisconnectcause.remarks}
				</td>
				<shiro:hasPermission name="disconnectcause:radiusDisconnectcause:edit"><td>
    				<a href="${ctx}/disconnectcause/radiusDisconnectcause/form?id=${radiusDisconnectcause.id}">修改</a>
					<a href="${ctx}/disconnectcause/radiusDisconnectcause/delete?id=${radiusDisconnectcause.id}" onclick="return confirmx('确认要删除该故障原因吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>