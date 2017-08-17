<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 답글 폼</title>
</head>
<body>
   <center>
      <%
         request.setCharacterEncoding("utf-8");
         String no = request.getParameter("no");
         BoardMgr bMgr = BoardMgr.getInstance();
         // 테이블 명 , 순번, 조회 false
         BoardData bd = bMgr.selectBoardData(Integer.parseInt(no), false);
         String reqPage = request.getParameter("page");
      %>
      <h3> * 게시판 답변쓰기 * </h3>
      <hr><p>
      <form action=board_write_re.jsp method="post">
         <input type="hidden" name="page" value="<%=reqPage %>"/>
         <input type="hidden" name="group" value="<%=bd.getGroup() %>"/>
         <input type="hidden" name="order" value="<%=bd.getOrder() %>"/>
         <input type="hidden" name="nested" value="<%=bd.getNested() %>"/>
         <table width="650" border=3 bordercolor="#000000">
            <tr>
               <td> 작성자 </td>
               <td>
                  <input type="text" size="20" name="name"/>
               </td>
            </tr>
            <tr>
               <td>ID</td>
               <td>
                  <input type="text" size="20" name="id"/>
               </td>
            </tr>
            <tr>
               <td align="center" width="80"> 제목 </td>
               <td>
                  <input type="text" value="re : <%=bd.getTitle()%>" name="title" size=60/>
               </td>
            </tr>
            <tr>
               <td align="center"> 내 용 </td>
               <td align="top">
                  <textarea rows="10" cols="70" name="content">
                     ---- <%=bd.getId() %>님이 작성하신 글 ----<%=bd.getContent()%>
                  </textarea>
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <input type="submit" value="답변 쓰기"/>
               </td>
            </tr>
         </table>
      </form>
   </center>
</body>
</html>