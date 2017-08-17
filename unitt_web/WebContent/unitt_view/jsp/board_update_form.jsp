<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>게시판 수정</title>
</head>
<body><center>
   <%
      String no = request.getParameter("no");
      BoardMgr bMgr = BoardMgr.getInstance();
      // 테이블 명, 순번, 조회 false
      BoardData bd = bMgr.selectBoardData(Integer.parseInt(no), false);
   %>
   <h3> * 수정 폼 * </h3><hr><p>
   <form action = "board_update.jsp" method="post">
      <input type="hidden" name="page" value="<%=request.getParameter("page")%>"/>
      <input type="hidden" name="no" value="<%=no%>"/>
      <center>
         <table width="650" border="1" bordercolor="#000000">
            <tr>
               <td align="center" width="80"> 제 목 </td>
               <td>
                  <input type="text" value="<%=bd.getTitle()%>" name="title" size="60">
               </td>
            </tr>
            <tr>
               <td align="center"> 내 용 </td>
               <td>
                  <textarea rows="10" cols="60" name="content"><%=bd.getContent() %></textarea>
               </td>
            </tr>
            <tr>
               <td colspan=2>
                  <input type="submit" value="수정하기">
               </td>
            </tr>
         </table>
   </form>
</center>
</body>
</html>