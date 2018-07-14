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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="User/update" method="post">
	<table width=300px align="center" border="1">
	
		<tr>
			<th>编号</th><td><input type="hidden" name="uid" value="${user.uid }" >${user.uid }</td>			
		</tr>
		<tr>
			<th>登录名</th><td><input type="text" name="uname" value="${user.uname }"></td>			
		</tr>
		<tr>			
			<th>密码</th><td><input type="text" name="upass" value="${user.upass }"></td>		
		</tr>
		<tr>			
			<th>姓名</th><td><input type="text" name="name" value="${user.name }"></td>		
		</tr>
		<tr>			
			<th>性别</th><td><input type="text" name="sex" value="${user.sex }"></td>		
		</tr>
		<tr>			
			<th>年龄</th><td><input type="text" name="age" value="${user.age }"></td>		
		</tr>
		<tr>			
			<th>信息</th><td><input type="text" name="remark" value="${user.remark }"></td>		
		</tr>
		<tr>
			<th><input type="submit" value="提交"></th>
		</tr>
	</table>
</form>
</body>
</html>