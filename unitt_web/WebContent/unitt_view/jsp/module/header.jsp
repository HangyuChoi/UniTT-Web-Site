<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>header</title>
</head>
<script type="text/javascript">
	<!-- 회원가입/마이페이지 -->
	function showPopup(path) {
		if(path == "unitt_view/jsp/register.jsp") {
			var a = window.open('<%= request.getAttribute("mPath") %>', 'child',
					'width=480, height=550, left=700, top=200', true);
		} else {
			location.replace(path);         // 이동전 주소가 안보임.
			location.href(path);            // 이동전 주소가 보임
			history.go(-1);                 // 이전페이지가기. ()안의 값이 현재페이지에 대한 상대좌표
			location.reload();              // 새로고침
		}
	}
		<%-- var a = window.open('<%= request.getAttribute("mPath") %>', 'child',
				'width=480, height=550, left=700, top=200', true); // (URL,name,specs,replace) --%>
	function showPopup2() {
		var b = window.open('<%= request.getAttribute("rPath") %>', 'child',
				'width=480, height=250, left=700, top=200', true);
	}
</script>

<div id="header">
	<div id="logo">
		<img src="unitt_view/img/nui.jpg" />
	</div>
	<div id="login-btn">
		<h2 id="loginId"><%= request.getAttribute("mainTop") %></h2>
		<div class="myButton" onclick="showPopup2();" ><%= request.getAttribute("rNote") %></div>
		<!-- 회원가입/마이페이지 -->
		<input id="mPath" type="hidden" value="<%= request.getAttribute("mPath") %>">
		<div class="myButton" onclick="showPopup(mPath.value);"><%= request.getAttribute("mNote") %></div>
	</div>
</div>