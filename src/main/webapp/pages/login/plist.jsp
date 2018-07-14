<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<!-- 插件使用的样式表文件，分bootstrap2和bootstrap3两个环境使用，根据使用环境引用 -->
<!-- bootstrap2环境使用 -->
<link rel="stylesheet" href="js/bpage/b.page.css" type="text/css" />
<!-- bootstrap3环境使用 -->
<link rel="stylesheet" href="js/bpage/b.page.bootstrap3.css" type="text/css" />

<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js" ></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<!-- 插件核心脚本 -->
<script type="text/javascript" src="js/bpage/b.page.js"></script>
<script type="text/javascript" src="js/bpage/b.page.min.js"></script>  


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">	
	function deleteId(uid) {
		var r = confirm("确定要删除吗")
		if (r == true) {
			document.deleteName.action = "User/" + uid;
			document.deleteName.submit();
		}
	}
	$(function() {
		$('#page1').bPage({
			//页面跳转的目标位置
			url : 'User/pList',
			//分页数据设置
			totalPage : $('#totalPage').val(),
			totalRow : $('#totalRow').val(),
			pageSize : $('#pageSize').val(),
			pageNumber : $('#pageNumber').val(),
		//页面跳转时需要同时传递给服务端的自定义参数设置		    
		});
	});
</script>
</head>
<body>
	<table class="table table-striped table-bordered table-hover table-condensed">
		<thead>
			<tr>
				<th class="selectColumn">选择</th>
				<th>登录名</th>
				<th>密码</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>信息</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList.content }" var="d">
				<tr>
					<td class="selectColumn"><input type="radio" name="userSelect"
						value="${d.uid}" /></td>
					<td>${d.uname}</td>
					<td>${d.upass}</td>
					<td>${d.name}</td>
					<td>${d.sex}</td>
					<td>${d.age}</td>
					<td>${d.remark}</td>
					<td>
						<a href="pages/login/save.jsp">添加</a>						
						<a href="User/findOne/?uid=${d.uid }">查看</a>
						<a href="User/findOne/?uid=${d.uid }">修改</a>
						<a href="javascript:deleteId(${d.uid})">删除</a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 生成分页数据内容，必须设置 -->
	<c:if test="${userList != null}">
		<input type="hidden" id="pageNumber" value="${userList.number+1 }">
		<input type="hidden" id="pageSize" value="${userList.size }">
		<input type="hidden" id="totalPage" value="${userList.totalPages }">
		<input type="hidden" id="totalRow" value="${userList.totalElements }">  
	</c:if>
	<!-- 分页栏 -->
	<div id="page1"></div>	
	<form name="deleteName" action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>
</body>

</html>