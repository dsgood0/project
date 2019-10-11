<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add.do" method="post">
		<table>
			<tr>
				<td>프로젝트 이름</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>프로젝트 내용</td>
				<td><textarea name="content" rows="60" cols="10"></textarea></td>
			</tr>
			<tr>
				<td>시작날짜</td>
				<td><input type="date" name="start_date"></td>
			</tr>
			<tr>
				<td>마감날짜</td>
				<td><input type="date" name="end_date"></td>
			</tr>
			<tr>
				<td>상태</td>
				<td><select name="state">
						<option>준비</option>
						<option>진행중</option>
						<option>종료</option>
						<option>보류</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="저장"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>