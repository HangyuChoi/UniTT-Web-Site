<%@ page contentType = "text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="../css/register.css" />
<title>Login</title></head>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="../js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript">
   function showPopup (){
      var a = window.open('register.jsp', 'child',
         'width=480, height=550, left=700, top=200', true); // (URL,name,specs,replace)
   //    a.self.close();
   }
</script>
</head>
<body>
<form action="../../MemberController?member=login" method="post">
<fieldset>
<legend>로그인</legend>
<ol>
  <li>
    <label for="userid">아이디</label>
    <input id="userid" name="id" type="text">
  </li>
  <li>
    <label for="pw">비밀번호</label>
    <input id="pw" name="password" type="text">
  </li>
</ol>
</fieldset>

<fieldset id="f">
  <!-- <div id="button"> -->
  <button type="submit">로그인</button>
  <button id="reset" onclick="showPopup();"> 회원가입 </button>
  <!-- </div> -->
</fieldset>
</form>
</body>
</html>l>