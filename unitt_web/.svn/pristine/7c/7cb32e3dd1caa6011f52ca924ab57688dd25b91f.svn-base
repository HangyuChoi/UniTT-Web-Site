<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="../css/register.css" />
<title>Register</title>
</head>
<body>
	<br>
	<br>
	<form action="../../MemberController?member=register" method="post">
		<fieldset>
			<legend>로그인 정보</legend>
			<ol>
				<li><label for="userid">아이디</label> <input id="userid"
					name="id" type="text" required autofocus></li>
				<li><label for="pw">비밀번호</label> <input id="pw" name="password"
					type="password" required></li>
			</ol>
		</fieldset>
		<fieldset>
			<legend>개인 정보</legend>
			<ol>
				<li><label pwd="name">이름(닉네임)</label> <input id="name"
					name="name" type="text" required></li>
				<li><label pwd="email">메일 주소</label> <input id="email"
					name="email" type="email" placeholder="abcd@domain.com" required
					autocomplete="off"></li>
				<li><label pwd="phonenumber">연락처</label> <input
					id="phonenumber" name="phone_number" type="tel" autocomplete="off">
				</li>
				<li><label pwd="question">질문(비밀번호) </label> <select
					name="question"><br>
						<option value="select" name="question" selected(초기 선택된항목)>선택해주세요</option>
						<br>
						<option value="자신이 태어난 곳은?" name="question">자신이 태어난 곳은?</option>
						<br>
						<option value="자신이 나온 초등학교 이름은?" name="question">자신이 나온
							초등학교 이름은??</option>
						<br>
						<option value="처음 사귄 친구의 이름은?" name="question">처음 사귄 친구의
							이름은?</option>
						<br>
				</select><br></li>
				<li><label pwd="answer">답변</label> <input type="text"
					id="answer" name="answer" required></li>
			</ol>
		</fieldset>
		<fieldset>
			<legend> 관심분야 </legend>
			<ol>
				<li><input value="IT" type="checkbox" id="inter" name="interest">IT</input>

					<input value="교육" type="checkbox" id="inter" name="interest">교육</input>
					<input value="게임" type="checkbox" id="inter" name="interest">게임</input>
					<input value="음악" type="checkbox" id="inter" name="interest">음악</input>
					<input value="스포츠" type="checkbox" id="inter" name="interest">스포츠</input>
					<input value="다이어트" type="checkbox" id="inter" name="interest">다이어트</input>
				</li>
				<li><label>자기소개</label> <input type="text" name="introduce"></input>
				</li>
			</ol>
		</fieldset>
		<fieldset id="f">
			<!-- <div id="button"> -->
			<button type="submit">가입</button>
			<button type="reset" id="reset">취소</button>
			<!-- </div> -->
		</fieldset>
	</form>
</body>
</html>
