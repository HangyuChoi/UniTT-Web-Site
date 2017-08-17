<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 정보 수정 폼 </title>
</head>
<body>
	<center>
		<br>
		<br>
		<form action="MemberController?member=modify" method="post">
			<br>
			<hr>
			<br>
			<table border="1">
				<tr>
					<td>ID</td>
					<td><input name="mID" type="text" value="<%= request.getAttribute("returnId")%>" disabled="disabled">
					</td>
				</tr>
				<tr>
					<td> 기존 PW</td>
					<td><input name="mPW" type="text" value="<%= request.getAttribute("returnPw")%>">
					</td>
				</tr>
				<tr>
					<td> 바꿀 PW</td>
					<td><input name="cPW" type="text">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="정보수정"></td>
				</tr>
			</table>
			<br>
		</form>
	</center>
</body>
</html>