<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="unitt_view/css/index.css" />
<title>정보수정</title>
<%
	String a = (String)request.getAttribute("게임");
	String b = (String)request.getAttribute("음악");
	String c = (String)request.getAttribute("스포츠");
	String d = (String)request.getAttribute("IT");
	String e = (String)request.getAttribute("기타");
	String f = (String)request.getAttribute("교육");
%>
</head>

<body>
<div id="myPage_header">
	<div id="myPage_logo">
		<a href="unitt_view/jsp/index.jsp"><img src="unitt_view/img/nui.jpg" /></a>
	</div>
	<p class="myPage_p"><h1 class="myPage_id">마이페이지</h1></p>
	<p class="myPage_p2"></p>
	</div>
<div id="myPage_section">
	<div class="myPage_wrap">
	<br>
	<br>
	<form action="MemberController?member=modify" method="post">
		<fieldset>
			<legend>로그인 정보</legend>
			<ol>
				<li><label for="userid">아이디</label> <input id="userid" class="text_ui"
					name="id" type="text" value="<%= request.getAttribute("uid")%>" disabled="disabled" required></li>
				<li><label for="pw">비밀번호</label> <input id="pw1" name="password1" class="text_ui"
					type="text" value="<%= request.getAttribute("upw")%>" disabled="disabled" required></li>
				<li><label for="pw">변경할 비밀번호</label> <input id="pw2" name="password2" class="text_ui"
					type="password" required autofocus></li>
			</ol>
		</fieldset>
		<fieldset>
			<legend>개인 정보</legend>
			<ol>
				<li><label pwd="name">이름(닉네임)</label> <input id="name"class="text_ui"
					name="name" type="text" value="<%= request.getAttribute("uname")%>" required></li>
				<li><label pwd="email">메일 주소</label> <input id="email"class="text_ui"
					name="email" type="email" value="<%= request.getAttribute("uemail")%>" required
					autocomplete="off"></li>
				<li><label pwd="phonenumber">연락처</label> <input
					id="phonenumber" name="phone_number" type="tel" value="<%= request.getAttribute("uphone_number")%>" autocomplete="off" class="text_ui">
				</li>

				<li><label pwd="question">질문(비밀번호) </label> <select
					name="question"><br>
						<option id="register_que" value="<%= request.getAttribute("uquestion")%>" name="question" selected(초기 선택된항목)><%= request.getAttribute("uquestion")%></option>
						<br>
						<option id="register_que"value="자신이 태어난 곳은?" name="question">자신이 태어난 곳은?</option>
						<br>
						<option id="register_que"value="자신이 나온 초등학교 이름은??" name="question">자신이 나온
							초등학교 이름은?</option>
						<br>
						<option value="처음 사귄 친구의 이름은?" id="register_que" name="question">태어나서 처음으로 첫 키스를 한 여자의 중학교와 고등학교는?
							</option>
						<br>
				</select><br></li>
				<li><label pwd="answer">답변</label> <input type="text"
					id="answer" name="answer" class="text_ui" value="<%= request.getAttribute("uanswer")%>" required></li>
			</ol>
		</fieldset>
		<fieldset>
			<legend> 관심분야 </legend>
			<ol>
				<li>
				<%
				if(f == null) { %>
				<input value="교육" type="checkbox" id="inter" name="interest">교육</input>
				<%
				} else { %>
				<input value="교육" type="checkbox" id="inter" name="interest" checked="checked">교육</input>
				<%
				}
				if(d == null) { %>
				<input value="IT" type="checkbox" id="inter" name="interest">IT</input>
				<%
				} else { %>
				<input value="IT" type="checkbox" id="inter" name="interest" checked="checked">IT</input>
				<%
				}
				if(c == null) { %>
				<input value="스포츠" type="checkbox" id="inter" name="interest">스포츠</input>
				<%
				} else { %>
				<input value="스포츠" type="checkbox" id="inter" name="interest" checked="checked">스포츠</input>
				<%
				}
				if(a == null) { %>
					<input value="게임" type="checkbox" id="inter" name="interest">게임</input>
				<%
				} else { %>
				<input value="게임" type="checkbox" id="inter" name="interest" checked="checked">게임</input>
				<%
				}
				if(b == null) { %>
					<input value="음악" type="checkbox" id="inter" name="interest">음악</input>
				<%
				} else { %>
				<input value="음악" type="checkbox" id="inter" name="interest" checked="checked">음악</input>
				<%
				}
				if(e == null) { %>
				<input value="기타" type="checkbox" id="inter" name="interest">기타</input>
				<%
				} else { %>
				<input value="기타" type="checkbox" id="inter" name="interest" checked="checked">기타</input>
				<%
				}
				%>
				</li>
				<li><label>자기소개</label> <input type="text" id ="intro"name="introduce" value="<%= request.getAttribute("uintroduce")%>"></input>
				</li>
			</ol>
		</fieldset>
		<fieldset id="f">
			<!-- <div id="button"> -->
			<button type="submit">수정</button>
			<button type="reset" id="reset">다시입력</button>
			<!-- </div> -->
		</fieldset>
	</form>
	</div>
	</div>
<div id="update_footer">
	<div id="update_wrap"></div>
	<div id="img"><img src="unitt_view/img/nui.jpg" /></div>
</div>
</body>
</html>

