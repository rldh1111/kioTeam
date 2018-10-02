<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script>
	function check() {
		var f = document.form;
		if (f.loginId.value == "") {
			alert("아이디를 입력하세요")
			f.loginId.focus();
			return false;
		} else if (!f.password.value) {
			alert("비밀번호를 입력하세요")
			f.password.focus();
			return false;
		}
		if (f.password.value != f.confirmPassword.value) {
			alert("비밀번호가 같지 않습니다.!")
			f.confirmPassword.focus();
			return false;
		}

	}
	
</script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	width: 50%;
	margin-left: 22%;
	margin-top: 3%;
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
input[type=email] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
input[type=tel]{
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
input[type=name] {
	background-color: #00ccff;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}
input[type=addres] {
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

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f33236;
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

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>  
</head>
<body>
	<center>
		<h1>회원가입</h1>
	</center>
	<form action="join" onsubmit="return check();" method="post" name="form">
		<div class="container">
			<input type="hidden" name="userType" value="B">
			<label for="loginId"><b>아이디</b><input type="text"placeholder="아이디" name="loginId" id="loginId"></label> 
			<label for="password"><b>비밀번호</b><input type="password" placeholder="비빌번호" name="password"> </label> 
			<label for="confirmPassword"><b>비밀번호확인</b><input type="password" placeholder="비밀번호확인" name="confirmPassword" id="confirmPassword"></label>
			<label for="name"><b>이름</b> <input type="text" placeholder="이름" name="name" id="name" required></label>	
			<label for="email"><b>이메일</b><input type="email" placeholder="이메일" name="email" required> </label>
			<label for="phone"><b>전화번호</b><input type="tel" placeholder="전화번호" name="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required></label>
			<label for="주소"><b>주소</b><input type="text" placeholder="주소" name="address" required></label>
			<input type="submit" value="로그인">
		</div>
	</form>
</body>
</html>