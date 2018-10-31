<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<script>
	function check() {
		 var f=document.form;
		 if(f.loginId.value==""){
			 alert("아이디를 입력하세요")
			 f.loginId.focus();
			 return false;
		 }else if(!f.password.value){
			 alert("비밀번호를 입력하세요")
			 f.password.focus();
			 return false;
		 }
	}
	
	function checkloginId(){
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오를 드립니다 기오PC -- 로그인</title>
<link rel="stylesheet" href="css/loginForm.css?2">
</head>
<body>
	<div id="header" class="container">
		<div class="logo">
			<h1><a href="main.jsp">기오피씨</a></h1>
		</div>
	</div>
	<form action="login" onsubmit="return check();" method="post" name="form" class="from">
		<div class="container">
			<label for="uname"><b>아이디</b><input type="text" placeholder="아이디" name="loginId" id="loginId" autofocus></label>
			<label for="psw"><b>비밀번호</b><input type="password" placeholder="비빌번호" name="password"></label> 
			<input type="submit" value="로그인">
			<c:if test="${errors.idOrPwNotMatch }">
				<script>
					alert("아이디 또는 비밀번호가 틀렸습니다.");
				</script>
			</c:if>
		</div>
		<div class="container1" style="background-color:#f1f1f1">
    		<span class="psw">
    			<a href="findId" style="text-decoration: none">아이디 찾기 |</a>
    			<a href="findPw" style="text-decoration: none">비밀번호 찾기 | </a>
    			<a href="join" style="text-decoration: none">회원가입</a>
    		</span>
  		</div>
	</form>
</body>
</html>