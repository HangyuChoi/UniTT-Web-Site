<%@page import="board.*"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 답글 결과</title>
</head>
<body><center>
   <%
      request.setCharacterEncoding("utf-8");
      BoardData bd = new BoardData();
      bd.setId(request.getParameter("id"));
      bd.setName(request.getParameter("name"));
      bd.setTitle(request.getParameter("title"));
      Calendar cal = Calendar.getInstance();
      int y = cal.get(Calendar.YEAR);
      int m = cal.get(Calendar.MONTH)+1;
      int d = cal.get(Calendar.DATE);
      String wdate = y +"년 " +m +"월 " +d +"일";
      bd.setWdate(wdate);
      bd.setContent(request.getParameter("content"));
      int group = Integer.parseInt(request.getParameter("group"));
      int order = Integer.parseInt(request.getParameter("order"));
      int nested = Integer.parseInt(request.getParameter("nested"));
      BoardMgr bMgr = new BoardMgr();
      bMgr.insertBoardData(group, order, nested, bd);
   %>
   <h3>답변글을 저장하였습니다.</h3><hr><p>
   <a href="board_list.jsp?page=<%=request.getParameter("page")%>"> [ 글 목록보기 ]</a>
</center>
</body>
</html>