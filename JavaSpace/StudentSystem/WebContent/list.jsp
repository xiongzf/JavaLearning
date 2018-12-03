<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表页面</title>
</head>
<body>
	<table border="1" width="700">
		
		<tr>
			<td colspan="8">
				<a href="add.jsp">添加</a>
			</td>
		</tr>
		
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${list }" var="stu">
			<tr align="center">
				<td>${stu.sid }</td>
				<td>${stu.sname }</td>
				<td>${stu.gender }</td>
				<td>${stu.phone }</td>
				<td>${stu.birthday }</td>
				<td>${stu.hobby }</td>
				<td>${stu.info }</td>
				<td><a href="#">更新</a>  <a href="#">删除</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>