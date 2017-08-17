<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.*"%>
<%@ page import="java.util.*" %>
<%!
   int reqPageNo;
   BoardData data[];
   String reqPage;
   BoardMgr mgr;
%>
<html>
<head>
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../css/board.css"/>
</head>
<body><center>
<header>

</header>
<h3> * 게시물 목록 * </h3><br><p>
<section>
<article>
   <!-- <table width="800" cellspacing="1"> -->
   <table cellspacing="1">
      <tr bgcolor="#0008b" align="center">
         <td width="100"><font color="white">번 호</font></td>
         <td width="100"><font color="white">I D</font></td>
         <td width="200"><font color="white">날 짜</font></td>
         <td width="300"><font color="white">제 목</font></td>
         <td width="100"><font color="white">조회수</font></td>
      </tr>
       <%
         reqPage = request.getParameter("page"); //page
         if(reqPage != null){
            reqPageNo = Integer.parseInt(reqPage);
         }

         mgr = BoardMgr.getInstance();
         int pageCount = mgr.getPageCount();
         if(pageCount == 0){
      %>
      <tr bgcolor="white">
         <td colspan="5" align="center"> 저장된 글이 없습니다. </td>
      </tr>
      <%
         } else {
            if(reqPageNo < 1){
               reqPageNo = 1;
            }
            //현재 보여지고 있는 페이지의 정보
            data = mgr.selectBoardDataList(reqPageNo);
            for(int i=0; i<data.length; i++){
      %>
      <tr>
         <td align="center">
            <%= (data[i].getNested() == 0) ? data[i].getGroup() : "" %>
         </td>
         <td align="center">
            <%= data[i].getId() %>
         </td>
         <td align="center">
            <%= data[i].getWdate() %>
         </td>
         <td>
            <%
               if(data[i].getNested() > 0){
            %>
            <img alt="" src="img/sp.png" width="<%= data[i].getNested()*10 %>">
            <img alt="" src="img/arrow.png">
            <%
               }
            %>
         <a href=board_read.jsp?page=<%= reqPageNo %>&no=<%= data[i].getNum() %> style="vertical-align: top;">
            <%= data[i].getTitle() %></a>
         </td>
         <td align="center"><%=data[i].getReadno() %></td>
      </tr>
      <%
            }
         }
      %>
      <tr>
         <td colspan ="5" align="right">
         	<!-- 관리자만 글쓰기 허용 -->
            <a href="board_write_form.jsp?page=<%=reqPageNo %>">[(관리자) 글쓰기] </a>
         </td>
      </tr>
      <tr>
         <td colspan ="5" align="center">
            <%
               for(int i=1; i<=pageCount;i++){
            %>
               <a href="notice.jsp?page=<%=i %>">[<%=i %>]</a>
            <%
               }
            %>
         </td>
      </tr>
   </table>
</article>
</section>
</body>
</html>