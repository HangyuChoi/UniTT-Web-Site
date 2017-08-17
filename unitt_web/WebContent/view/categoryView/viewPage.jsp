<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌 게시판</title>
</head>
<body>
<!--
	int courseboard_idx;
	String member_id;
	String name;
	String category;
	String title;
	String content;
	String image;
	String shot_introduce;
	String plan;

 -->
 	<form action="" method="post">
	<c:set var="saveArr" value="${viewData}" />
	<c:forEach var="data" items="${saveArr}">
		강좌인덱스 : ${data.courseboard_idx} <br>
		강사아이디 : ${data.member_id} <br>
		강사이름 : ${data.name } <br>
		강좌 카테고리 : ${data.category } <br>
		강좌 제목 : ${data.title } <br>
		강좌 내용 : ${data.content } <br>
		강좌 이미지 : <img src="http://localhost:8080/img/${data.image }" alt="공사중"/><br>
		강좌 간단소개 : ${data.shot_introduce } <br>
		강좌 계획 : ${data.plan }
	</c:forEach>
	<br><hr><br>
	동영상 작업<br>
	<a href="${uploadPath}" onclick="showPopup();">${uploadName}</a><br>
	<a href="/unitt_web/VideoController?video=show&idx=${pageIdx}">강좌 동영상 보기</a>
	</form>
	<br>
</body>
</html>