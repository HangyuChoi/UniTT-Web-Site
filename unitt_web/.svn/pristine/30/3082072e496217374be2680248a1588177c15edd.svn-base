<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
   MyCalendar mycal = new MyCalendar();
   BoardData bd = new BoardData();
   BoardMgr bMgr = BoardMgr.getInstance();
   String no = request.getParameter("no");
   String p = request.getParameter("page");
   String title = request.getParameter("title");
   String content = request.getParameter("content");
   bd.setNum(Integer.parseInt(no));
   bd.setTitle(title);
   bd.setContent(content);
   bd.setWdate(mycal.getToday());
   bMgr.updateBoardData(bd);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> * 수정 결과 * </title>
</head>
<body>
   <h3> * 수정 결과 * </h3><hr><p>
      <b>글을 수정하였습니다. </b>
         <br><br>
         <a href="board_list.jsp?page=<%=p%>">[글 목록 보기]</a>
</body>
</html>