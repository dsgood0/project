<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
	}
	td, th {
		padding:5px;
		border:1px solid black;
	}
</style>
</head>
<body>
	<a href="add.do">새 프로젝트 등록</a>
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>상태</th>
		</tr>
		<c:forEach var="project" items="${list}">
			<tr>
				<td><a href="detail.do?no=${project.no}">${project.name}</a></td>
				<td>${project.start_date}</td>
				<td>${project.end_date}</td>
				<td>${project.progress}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>