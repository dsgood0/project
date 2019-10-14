<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$("#del").click(function() {
			if(confirm("삭제하시겠습니까?") == true) {
				location.href = "delete.do?no=${project.no}";	
			} else{
				return false;
			}
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<td>${project.title }</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${project.content }</td>
		</tr>
		<tr>
			<th>시작날짜</th>
			<td>${project.start_date }</td>
		</tr>
		<tr>
			<th>종료날짜</th>
			<td>${project.end_date }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${project.state }</td>
		</tr>
	</table>
	<a href="update.do?no=${project.no}">수정</a>
	<a href="#" id="del">삭제</a> <!-- jqeury로 확인, 취소 구현 -->
	<a href="list.do">돌아가기</a>
</body>
</html>