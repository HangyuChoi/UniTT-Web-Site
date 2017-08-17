<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과는 = <%= request.getAttribute("writeResult") %>
	제목 : ${param.TITLE} <br>
	설명 : ${param.DESCRIPTION} <br>
	파일 : ${param.FILE_NAME} <br>
	파일이 업로드 되었습니다. <br><p><hr><br><p> 
	<a href="view/index.jsp">[메인페이지로 이동]</a>
</body>
</html>