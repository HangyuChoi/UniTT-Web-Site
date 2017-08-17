<%@ page language="java" contentType="text/html; charset=EUC-KR"

    pageEncoding="EUC-KR"%>

    <% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
int count = Integer.parseInt(request.getParameter("count"));

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>업로드 결과 페이지</title>
</head>
<body>

<%
for(int i = 1; i<=count; i++){
	System.out.println("업로드 결과 포문");
    String filename = "fileName"+i;
    String filelength = "fileLength"+i;
    System.out.println("파일 이름"+filename);
    System.out.println("파일 용량"+filelength);
    if(request.getParameter("filename") != null){%>
    파일이름 : <%=request.getParameter("filename")%><br>
    파일 용량 : <%=request.getParameter("filelength") %>KB<br><br>
    <%
    }
}
%>
</body>
</html>
