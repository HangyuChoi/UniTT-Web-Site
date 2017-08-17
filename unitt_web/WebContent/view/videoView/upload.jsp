<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드하기</title>
</head>
<body>
<h1>로그인 된 사용자가 자신의 강좌페이지에 접근했다고 가정 ( 세션 아이디 , 강좌 인덱스 가 둘다 있는 튜플체크  )</h1>
<h2> 파일 업로드</h2>
	<form action="../../VideoController?video=upload" method=post enctype="multipart/form-data">
		제목 : <input type=text name=TITLE> <br>
		<!-- 세션 아이디
			   강좌 인덱스
	    -->

		파일 : <input type="file" value="" name="UPLOAD_FILE[]" multiple>

		<!--  <input type=file name=UPLOAD_FILE> <br><br> -->
		<!-- mp4 인지 webm 인지 체크하자. -->
		설명 : <input type=text name=DESCRIPTION> <br>
			 <input type=submit value="보내기">
	</form>
</body>
</html>