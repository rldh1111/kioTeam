<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<script>
	function check() {
		var f = document.form;
		if (f.loginId.value == "") {
			alert("아이디를 입력하세요 !")
			f.loginId.focus();
			return false;
		} 
		if(!f.password.value) {
			alert("비밀번호를 입력하세요 !")
			f.password.focus();
			return false;
		}
		if (f.password.value != f.confirmPassword.value) {
			alert("비밀번호가 같지 않습니다 !")
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
	margin-top: 1%;
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

input[type=button] {
	background-color: black;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}
.question{
	background-color: white;
	color: black;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	font-size: 13px;
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
<title>기오를 드립니다 기오PC -- 회원 가입</title>
</head>
<body>

		<h1 style="text-align: center">회원가입</h1>

	<form action="join" onsubmit="return check();" method="post" name="form">
		<div class="container">
			<input type="hidden" name="userType" value="B">	
			
			<label for="loginId">
				<b>아이디</b>
				<input type="text" placeholder="아이디" name="loginId" id="loginId">
			</label> 
			
			<label for="password">
				<b>비밀번호</b>
				<input type="password" placeholder="비빌번호" name="password">
			
			</label> 
			
			<label for="confirmPassword">
				<b>비밀번호확인</b>
				<input type="password" placeholder="비밀번호확인" name="confirmPassword" id="confirmPassword">
			</label> 
				
			<label for="name">
				<b>이름</b>
				<input type="text" placeholder="이름" name="name" id="name" required>
			</label> 
			
			<label for="email">
				<b>이메일</b>
				<input type="email" placeholder="이메일" name="email" required>
			</label> 
			
			<label for="phone">
				<b>전화번호</b>
				<input type="tel" placeholder="전화번호" name="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required>
			</label> 
			
			<label for="address">
				<b>주소</b>
				<input type="text" placeholder="주소" name="address" required>
			</label> 			
			
			<label for="question">
				<b>아이디/비밀번호 분실시 질문사항</b>
				<select id="question" class="question" name="question" style="border:1px solid #d9d9d9;">
					<option value="자신의 보물 1호는?">자신의 보물 1호는?</option>
					<option value="내가 나온 중학교 이름은?" >내가 나온 중학교의 이름은?</option>						
				</select>	 
			</label>
			
			<label for="answer">
				<b>답변</b>
				<input type="text" name="answer" placeholder="답변" required>
			</label>
			<c:if test="${errors.duplicateId }">
				<script>alert("아이디가 중복되었습니다.");</script>
			</c:if>
			<input type="submit" value="회원가입">
			<input type="button" onclick="mainGo();" value="쇼핑하기">
		</div>
	</form>	
</body>
</html>