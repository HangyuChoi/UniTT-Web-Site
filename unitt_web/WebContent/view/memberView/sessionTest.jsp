<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Session Test</title>
<style type="text/css">
	a {color:RED; text-decoration: none;}
</style>
</head>
<body>
	<center>
		<h1>
			<p>
				<%
					String id = (String) session.getAttribute("id");
					if(id == null) {
				%>
						session none.....
						<p><a href="../index.jsp">[메인 페이지로 이동]</a>
				<%
					} else {
				%>
						<%= id %>님 로그인 중입니다.
						<p><a href="../index.jsp">[메인 페이지로 이동]</a>
			<p>
				<%
					}
				%>
		</h1>
	</center>
</body>
</html>