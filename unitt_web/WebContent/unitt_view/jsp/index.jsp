<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv=refresh content="0; url=/unitt_web/MemberController?member=main">
	<script src="../js/jquery-1.11.0.min.js"></script>
<script src="../js/jquery-ui-1.10.4.custom.js"></script>
<%
	System.out.println("login.jsp 들어옴");
%>
<%
	String param = request.getParameter("param");
	System.out.println(param);
	if (param != null) {
%>
<script>
	opener.location.reload();
	window.close();
</script>
<%
	}
%>
</head>
</html>
