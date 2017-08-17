<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>동영상 목록 페이지</title>
</head>
<body style="background-image: url('view/videoView/img.png'); background-color: #ffa0df; ">
	<%
	request.getAttribute("mapArr");
	request.getAttribute("countNum");
	request.getAttribute("content");
	request.getAttribute("path");
	request.getAttribute("title");
	String auth = (String) request.getAttribute("auth");
%>
	<center>

		<table border="1" bordercolor="#85FFFF" bgcolor="#FFC19E">
			<tr>
				<td colspan="2" bgcolor="#FAF4C0"><center>동영상 페이지</center></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#FFFFFF"><center>${title}</center></td>
			</tr>
			<tr>
				<td colspan="2"><video poster="http://placehold.it/640x360"
						width="640" height="360" controls="controls">
						<source src="http://210.123.255.152:8080/file${path}" type="video/mp4">
					<source src="/" type="video/webm"></video></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#C1D9FB">동영상내용</td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#FFFFFF"><center>
						<label>${content}</lable>
					</center></td>
			</tr>
			<tr><td>
				<%
					if(auth != null) {
						if(auth.equals("no")) {%>
						<a href="#"></a>
						<a href="#"></a>
						<%
					} else { %>
						<a href="#">수정하기</a>
						<a href="#">삭제하기</a>
						<%
					}
					}
				%>
			</td></tr>
			</br><hr>
			<!--  ${countNum = countNum+1} <!-- 순번 0부터 시작하는걸 1부터 시작할 수 있게 설정 -->
		</table>
		<br>
		<br>
		<hr>
		<br>
		<table border="1" bordercolor="#85FFFF" bgcolor="#FFC19E">
			<tr>
				<td>동영상 순서</td>
				<td>동영상 제목</td>
			</tr>
			<c:set var="videoArr" value="${mapArr}" />
			<c:forEach var="data" items="${videoArr}" varStatus="varStatus">
				<tr>
					<td>${varStatus.index+1}</td>
					<td><a
						href="VideoController?video=show&idx=${data.courseboard_idx}&pageNum=${varStatus.index+1}">
							${data.title } </a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="/unitt_web/CategoryController?category=view&pageNum=${idx}">강좌페이지로</a>
	</center>
</body>
</html>