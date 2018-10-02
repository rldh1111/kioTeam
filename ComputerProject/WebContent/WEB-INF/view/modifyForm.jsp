<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script>
	function check() {
		var f = document.form;
		 if (!f.password.value) {
			alert("비밀번호를 입력하세요")
			f.Password.focus();
			return false;
		}else if (f.password.value != f.confirmPassword.value){
			alert("두 비밀번호가 일치하지 않습니다.")
			f.confirmPassword.focus();
			return false;
		}
	}

	function checkloginId() {

	}
</script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	width: 50%;
	margin-left: 25%;
	margin-top: 10%;
}

form {
	border: 3px solid #669999;
}

input[type=text], input[type=password], input[type=email], input[type=tel]
	{
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
a{
text-decoration: none
}

.question{
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	border: 1px solid #cccccc;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오를 드립니다 기오PC -- 회원수정</title>
</head>
<body>

		<h1 style="text-align: center">회원가입</h1>

	<form action="modify" onsubmit="return check();" method="post"
		name="form">
		<div class="container">
			<input type="hidden" name="userId" value="${modReq.userId }">
			<label for="name"><b>이름</b><input type="text" name="name"value="${modReq.name }" required></label>
			<label for="password"><b>비밀번호</b><input type="text" name="password"></label>
			<label for="confirmPassword"><b>비밀번호 확인</b><input type="text" name="confirmPassword" required></label>
			<label for="address"><b>주소</b> <input type="text" name="address" value="${modReq.address }" required></label> 
			<label for="email"><b>이메일</b> <input type="email" name="email" value="${modReq.email }" required></label> 
			<label for="tel"><b>전화번호</b> <input type="tel" name="phone" value="${modReq.phone }" required></label>
			<label for="question"><b>질문</b><select name="question" class="question" style="color:black;">
				<option value="제일 컸을대 키는?">제일 컸을때 키는 ?</option>
				<option value="가장 아끼는 물건은 ?">가장 아끼는 물건은 ?</option>
			</select></label> 
			<label for="answer"><b>답변</b><input type="text" name="answer" value="${modReq.answer }" required></label>  
			<input type="submit" value="수정하기">
		</div>
		<div class="container1" style="background-color: #f1f1f1">
			<span class="psw">
				<a href="findID.jsp">아이디 찾기 |</a> 
				<a href="findPw.jsp">비밀번호 찾기 | </a>
				<a>회원가입</a> 
			</span>
		</div>
	</form>
</body>
</html>
