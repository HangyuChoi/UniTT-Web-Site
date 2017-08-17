<%@page import="board.* " %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String reqPage = request.getParameter("page");
	String no = request.getParameter("no"); // 시퀀스 넘버를 가지고온다.

	//임시 조회수 제한하기 위한 변수
	BoardMgr bMgr = BoardMgr.getInstance();
	//순번, 조회 true
	BoardData bd = bMgr.selectBoardData(Integer.parseInt(no), true);
%>
<html>
<head>
<title> 게시판 확인 </title>
<link rel="stylesheet" type="text/css" href="../css/board.css"/>
</head>
<center>
	<h3> * 게시판 확인 * </h3><hr><p>
<body>
<center>
	<table width="800" border="3" bordercolor="#000000">
		<tr>
			<td align="center"> 제 목 </td>
			<td><%=bd.getTitle()%></td>
		</tr>
		<tr>
			<td width="15%" align="center"> 작성자 </td>
			<td><%=bd.getId()%></td>
		</tr>
		<tr>
			<td align="center"> 날 짜 </td>
			<td><%=bd.getWdate()%></td>
		</tr>
		<tr>
			<td align="center"> 조회수 </td>
			<td><%=bd.getReadno()%></td>
		</tr>	
		<tr>
			<td colspan=2><%= bd.getContent()%></td>
		</tr>
		<tr>
			<td colspan=2>
				<a href=board_list.jsp?page=<%=reqPage%>>[ 목록으로 돌아가기 ]</a>
				
				<!-- 공지사항, QnA는 필요없는 기능 -->
				<!-- <a href=board_write_re_form.jsp?page=<%=reqPage%>&no=<%=no%>>[ 답변쓰기 ]</a> -->
				
				<!-- 관리자의 경우 수정,삭제 가능하게 활성화 -->
				<a href=board_update_form.jsp?page=<%=reqPage%>&no=<%=no%>>[(관리자) 수정하기 ]</a>
				<a href=board_delete.jsp?page=<%=reqPage%>&no=<%=no%>>[(관리자) 삭제하기 ]</a>
			</td>
		</tr>
	</table>
</body>
</html>