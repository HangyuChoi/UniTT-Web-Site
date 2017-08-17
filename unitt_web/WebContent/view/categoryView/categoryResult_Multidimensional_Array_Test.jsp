<%@page import="java.util.Map"%>
<%@page import="java.util.Hashtable"%>
<%@page import="bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>클릭한 카테고리 : ${title}</title>
</head>
<body>
<%
	System.out.println("결과페이지 접근");
	request.getAttribute("mapArr");
%>
	<center>
		<c:set var="categoryArr" value="${mapArr}" />
		<table border="1" bordercolor="#85FFFF" bgcolor="#FFC19E">
			<tr>
				<td colspan="4" bgcolor="#FAF4C0"><center>카테고리 검색 결과
						페이지</center></td>
			</tr>
			<c:forEach var="data" items="${categoryArr}">
				<tr>
					<td style="background-color: #B5B2FF">강좌제목</td>
					<td><a href="/unitt_web/CategoryController?category=view_Arr_Test&pageNum=${data.courseboard_idx}">${data.title} </a></td>
					<td style="background-color: #B5B2FF">강사이름</td><td>${data.name}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>