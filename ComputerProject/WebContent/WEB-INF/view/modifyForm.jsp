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
	html, body{height: 100%;}
	
	body{
		margin: 0px;
		padding: 0px;
		background: #EFEFEF url(images/bg01.png) repeat;
		font-size: 10pt;
		font-weight: 400;
		color: black;
	}
	
	p, ol, ul{margin-top: 0;}
	
	a:hover{text-decoration: none;}

	.container{
		width: 700px;
		margin: 0px auto;
	}
	#top {
		padding: 50px 0px;
		text-decoration: none;
		height: 0px;
		margin-bottom: 30px;
	}
	
	.logo a{
		text-decoration: none;
		line-height: 80px;
		margin: 0;
		padding: 0;
		color: #525252;
		float: left;
		}
	.modify h1{
		float: left;
	    margin-left: 160px;
	    line-height: 10px;
	    font-size: 43px;
	    color: black;
	}
	.findId a{
		float : left;
		margin-left: 97px;
		text-decoration: none;
		line-height: 83px;
		color: #525252;
	}
	.findPw a{
		float : left;
		margin-left: 10px;
		text-decoration: none;
		line-height: 83px;
		color: #525252;
	}
	.from b{
		font-size: 15px;
    	margin-left: 10px;
	}
/* -------------------------------------------------------------------------------------- */
body {
	font-family: Arial, Helvetica, sans-serif;
	width: 700px;
	margin: auto;
}

form {
	border: 3px solid #525252;
	width: 700px;
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
	background-color: #525252;
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

.question{
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	border: 1px solid #cccccc;
}

span {
	float: right;
	text-decoration: none;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오를 드립니다 기오PC -- 회원수정</title>
</head>
<body>
	<div id="top" class="container">
		<div class="logo">
			<h1><a href="main.jsp">기오피씨</a></h1>
		</div>
		<div class="modify">
			<h1>정보수정</h1>
		</div>
		<div class="findId">
			<a href="findId">아이디 찾기</a>
		</div>
		<div class="findPw">
				<a href="findPw">비밀번호 찾기</a>
		</div>
	</div>
	<form action="modify" onsubmit="return check();" method="post" name="form" class="from">
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
			<input type="submit" value="수정하기" ">
		</div>
	</form>
</body>
</html>
