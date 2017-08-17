<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="board.*" %>
<%@ page import="java.util.*" %>
<%!
	int reqPageNo;
	BoardData data[];
	String reqPage;
	BoardMgr mgr;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/index.css">
<title>공지사항</title>
</head>
<body>
<form>
<div id="list_header">
	<div id="delete_logo" onclick="index.jsp">
		<img src="../img/nui.jpg" />
	</div>
	<p class="myPage_p"><h1 class="myPage_id">QnA</h1></p>
	<p class="myPage_p2"></p>
</div>
<p id="clear"></p>	
<div id="list_section">
<table class="notice_list" summary="제로거의 HTML/CSS 게시판 입니다." cellspacing="0">

<colgroup>
<col width="8%" />
<col width="*"/>
<col width="11%"/>
<col width="8%" />
<col width="8%" />
</colgroup>
<thead>
	<tr>
		<th scope="col">번호</th>
		<th scope="col">제목</th>
		<th scope="col">작성자</th>
		<th scope="col">작성일</th>
		<th scope="col">조회수</th>
	</tr>
</thead>
<tbody>
	<%
         reqPage = request.getParameter("page"); //page
         if(reqPage != null){
            reqPageNo = Integer.parseInt(reqPage);
         }

         mgr = BoardMgr.getInstance();
         int pageCount = mgr.getPageCount();
         if(pageCount == 0){
      %>
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
		<td class="num1"><%= (data[i].getNested() == 0) ? data[i].getGroup() : "" %></td>
		<td class="title">
		<a href="#"><%
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
		<td class="num2"><%= data[i].getId() %></td>
		<td class="num3"><%= data[i].getWdate()%></td>
		<td class="num"><%=data[i].getReadno() %></td>
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
	
	</tbody>	
	</table>
	
</div>
	<!-- <ul>  
    <li><a href="#">1</a></li>  
    <li><a href="#">2</a></li>  
    <li><a href="#">3</a></li>  
    <li><a href="#">4</a></li>  
    <li><a href="#">5</a></li>  
    <li><a href="#">6</a></li>  
    <li><a href="#">7</a></li>  
    <li><a href="#">8</a></li>  
    <li><a href="#">9</a></li>  
    <li><a href="#">10</a></li>  
</ul>  -->
<p id="clear"></p>
<div id="list_footer">
	<div id="list_wrap"></div>
	<div id="img"><img src="../img/nui.jpg" /></div>
</div>
</form>
</body>
</html>
