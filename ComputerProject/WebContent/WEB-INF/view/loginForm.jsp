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
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	width:50%;
		margin-left:25%;
	    margin-top:10%;
}

form {
	border: 3px solid #669999;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type=submit] {
	background-color: #00ccff;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

input[type=submit]:hover {
	opacity: 0.8;
}


.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span {
	float: right;
	padding-top: 16px;
	text-decoration: none;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오를 드립니다 기오PC -- 로그인</title>
</head>
<body>
	<form action="login" onsubmit="return check();" method="post" name="form">
		<div class="container">
			<label for="uname"><b>아이디</b><input type="text" placeholder="아이디" name="loginId" id="loginId"></label>
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
    			<a href="findFw" style="text-decoration: none">비밀번호 찾기 | </a>
    			<a href="join" style="text-decoration: none">회원가입</a>
    		</span>
  		</div>
	</form>
</body>
</html>