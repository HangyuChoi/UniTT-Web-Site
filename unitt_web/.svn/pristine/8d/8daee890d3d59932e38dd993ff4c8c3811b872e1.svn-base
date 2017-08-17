<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String id = (String)session.getAttribute("id");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="unitt_view/css/index.css">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function showPopup2() {
		var b = window.open('/unitt_web/VideoController?video=show&idx=${pageIdx}&auth=${auth}', 'child',
				'width=1200, height=500, left=300, top=200', true);
	}
</script>


<body>
	<form action="" method="post">

		<div id="myPage_header">
			<div id="myPage_logo">
				<a href="unitt_view/jsp/index.jsp"><img
					src="unitt_view/img/nui.jpg" /></a>
			</div>
			<p class="myPage_p"></p>

			<div id="eduPage_img"></div>
			<c:set var="saveArr" value="${viewData}" />
			<c:forEach var="data" items="${saveArr}">
				<h1 class="myPage_id">${data.title }</h1>


				<div id="eduPage_my">
					<h1 class="eduPage_my2">°­»ç</h1><br>
					<h1 class="eduPage_my2">${data.member_id}</h1><br>
					<h1 class="eduPage_my2">${data.name }</h1>
				</div>
				<h1 class="myPage_id">°­ÁÂ ³»¿ë</h1>

				<p class="myPage_p2"></p>
				<h1 id="eduPage_id2">${data.content }</h1>


				<h1 class="myPage_id">°­ÁÂ °£´Ü¼Ò°³</h1>

				<p class="myPage_p2"></p>
				<h1 id="eduPage_id2">${data.shot_introduce }</h1>


				<h1 class="myPage_id">°­ÁÂ °èÈ¹</h1>

				<p class="myPage_p2"></p>
				<h1 id="eduPage_id2">${data.plan }</h1>
			</c:forEach>

			<div id="myButton2"class="myButton"><a href="${uploadPath}" onclick="showPopup();">${uploadName}</a><br></div>
			<div class="myButton" id="myButton2"
				onclick="showPopup2();">°­ÁÂ µ¿¿µ»ó º¸±â</div>






			<div id="myPage_footer">
				<div id="myPage_wrap"></div>
				<div id="img">
					<img src="unitt_view/img/nui.jpg" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>