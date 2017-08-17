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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="unitt_view/css/index.css">
<title>클릭한 카테고리 : ${title}</title>
</head>
<body>
<%
	request.getAttribute("mapArr");
%>
	<%-- <center>
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
	</center> --%>
	
<form>
<div id="list_header">
	<div id="delete_logo">
		<a href="unitt_view/jsp/index.jsp"><img src="unitt_view/img/nui.jpg" /></a>
	</div>
	<p class="list_p"></p>

</div>
<div id="category1">
<div id="topMenu1">
	<ul>
		<li class="topMenuLi"><a class="menuLink"
				href="CategoryController?category=search&select=교육">교육</a></li>
			<li class="topMenuLi"><a class="menuLink"
				href="CategoryController?category=search&select=IT">IT</a></li>
			<li class="topMenuLi"><a class="menuLink"
				href="CategoryController?category=search&select=스포츠">스포츠</a></li>
			<li class="topMenuLi"><a class="menuLink"
				href="CategoryController?category=search&select=게임">게임</a></li>
			<li class="topMenuLi"><a class="menuLink"
				href="CategoryController?category=search&select=음악">음악</a></li>
			<li class="topMenuLi"><a class="menuLink"
				href="CategoryController?category=search&select=기타">기타</a></li>
		<!-- <li>|</li> -->
		
	</ul>
</div>
</div>	
<p id="clear"></p>	
<div id="list_section">
<table class="table_list" summary="제로거의 HTML/CSS 게시판 입니다." cellspacing="0">



<colgroup>
<col width="8%" />
<col width="*"/>
<col width="11%"/>
<col width="8%" />
<col width="8%" />
</colgroup>
<thead>
	<tr>
		<th scope="col">번호</th>
		<th scope="col">제목</th>
		<th scope="col">작성자</th>
	</tr>
</thead>
<tbody>
<%
	request.getAttribute("mapArr");
%>
<c:set var="categoryArr" value="${mapArr}" />
<c:forEach var="data" items="${categoryArr}">
	<tr>
		<td class="num1">${data.courseboard_idx}</td>
		<td class="title"><a href="/unitt_web/CategoryController?category=view&pageNum=${data.courseboard_idx}">${data.title} </a>
		<a href="#"></a>
		</td>
		<td class="num2">${data.name}</td>
	</tr>
	</c:forEach>
	<!-- <tr>
		<td class="num1">2</td>
		<td class="title"><a href="#">제로거의 테이블 만들기는 어려워욧</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">3</td>
		<td class="title">
		<a href="#">제로거의 말파이 강의는 매우 유익하고 재밌습니다
		하지만 어렵다는 의견이 많아 고민이네요</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">4</td>
		<td class="title"><a href="#">제로거의 테이블 만들기는 어려워욧</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">5</td>
		<td class="title">
		<a href="#">제로거의 말파이 강의는 매우 유익하고 재밌습니다
		하지만 어렵다는 의견이 많아 고민이네요</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">6</td>
		<td class="title"><a href="#">제로거의 테이블 만들기는 어려워욧</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">7</td>
		<td class="title">
		<a href="#">제로거의 말파이 강의는 매우 유익하고 재밌습니다
		하지만 어렵다는 의견이 많아 고민이네요</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">8</td>
		<td class="title"><a href="#">제로거의 테이블 만들기는 어려워욧</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">9</td>
		<td class="title">
		<a href="#">제로거의 말파이 강의는 매우 유익하고 재밌습니다
		하지만 어렵다는 의견이 많아 고민이네요</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr>
	<tr>
		<td class="num1">10</td>
		<td class="title"><a href="#">제로거의 테이블 만들기는 어려워욧</a>
		</td>
		<td class="num2">제로거</td>
		<td class="num3">2017-05-01</td>
		<td class="num">1,555</td>
	</tr> -->
	</tbody>	
	</table>
	
</div>
<p id="clear"></p>
<div id="list_footer">
	<div id="list_wrap"></div>
	<div id="img"><img src="unitt_view/img/nui.jpg" /></div>
</div>
</form>
</body>
</html>
