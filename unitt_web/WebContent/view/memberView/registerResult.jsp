<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 결과</title>
</head>
<body>
	결과는 = <%= request.getAttribute("registerResult") %>

	<a href="view/index.jsp">[메인페이지로 이동] </a>
</body>
</html>