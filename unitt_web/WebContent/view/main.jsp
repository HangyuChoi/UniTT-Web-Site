<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="javascript/memberJavascript.js"></script>
<link rel="stylesheet" type="text/css" href="../css/index.css" />
<title>메인 페이지</title>
</head>
<body>
	<h1><%= request.getAttribute("mainTop") %></h1><br>
	<hr>
	###################<br>
	회원 작업<br>
	.<br>
	<a href=<%= request.getAttribute("rPath") %> ><%= request.getAttribute("rNote") %></a><br>
	<a href="/unitt_web/view/memberView/register.jsp">회원가입</a><br>
	<a href="/unitt_web/view/memberView/sessionTest.jsp">세션체크</a><br><br>
	<!-- 로그인 후에 path 제대로 연결됨  -->
	###################<br>
	로그인 성공 후  작업<br>
	.<br>
	<a id="mNote" href=<%= request.getAttribute("mPath") %>><%= request.getAttribute("mNote") %></a><br>
	<a id="dNote" href=<%= request.getAttribute("dPath") %>><%= request.getAttribute("dNote") %></a><br><br>
	####################<br>
	게시판 생성<br>
	.<br>
	<a href="/unitt_web/BoardController?board=boardCheck1">새 강의 만들기</a>
	<a href="/unitt_web/BoardController?board=boardCheck2">내 강좌 보기</a><br>
	###################<br>
	카테고리 작업 <br>
	<br>
	<a href="/unitt_web/view/categoryView/category_Multidimensional_Array_Test.jsp">카테고리 검색</a>
</body>
</html>