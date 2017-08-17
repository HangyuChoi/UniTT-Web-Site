<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/unitt_web/BoardController?board=write" method="post" enctype="multipart/form-data">
	<center>
		<table border="1">
			<tr>
				<th align="center"> 글쓴이 </th>
				<td>
				<input name="id" type="text" value=${sessionScope.id } readonly> 
				<%-- <input name="id" type="text" value="<%= (String)session.getAttribute("id") %>" disabled="disabled"> --%>					
				</td>
			</tr>
			<tr>
				<th align="center"> 닉네임</th>
				<td>
				<input name="name" type="text" value=${sessionScope.name } readonly>
				</td>
			</tr>
			<tr>
				<th align="center"> 카테고리</th>
				<td>
				<select name="category">
					<option value="교육">교육</option>
					<option value="IT">IT</option>
					<option value="스포츠">스포츠</option>
					<option value="음악">음악</option>
					<option value="요리">요리</option>
					<option value="게임">게임</option>
					<option value="기타">기타</option>
				</select>
				</td>
			</tr>	
			<tr>
				<th align="center"> 제 목</th>
				<td>
					<input name="title" type="text" placeholder="제목을 입력해주세요">	
				</td>
			</tr>
			<tr>
				<th align="center"> 강좌 내용</th>
				<td>
					<textarea name="content" rows="20" cols="100"></textarea>	
				</td>
			</tr>
			<tr>
				<th align="center"> 이미지</th>
				<td>
					<input type="file" name="image" >
					<!-- <input type="text" name="image"> -->
				</td>
			</tr>
			<tr>
				<th align="center">이미지 밑에 넣을 글</th>	
				<td>
					<input type="text" name="shot_introduce">
				</td>
			</tr>
			<tr>
				<th align="center">강의 계획</th>
				<td>
					<textarea name="plan" rows="20" cols="100"></textarea>
				</td>
			</tr>		
			<tr>
				<th align="center">	
			<tr>
				<td colspan="2">
					<input type="submit" value="결정">
					<input type="button" value="취소" onclick="location.href='/unitt_web/MemberController?member=main'"> 
				</td>
			</tr>	
		</table>
	</center>
	</form>
</body>
</html>