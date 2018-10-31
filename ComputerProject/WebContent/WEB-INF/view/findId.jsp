<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<script>
	function check() {
		 var f=document.form;
		 if(!f.name.value){
			 alert("이름을 입력하세요 !");
			 f.name.focus();
			 return false;
		 }else if(!f.phone.value){
			 alert("전화번호 입력하세요 !");
			 f.phone.focus();
			 return false;
		 }else if(!f.email.value){
			 alert("이메일을 입력하세요 !");
			 f.email.focus();
			 return false;
		 }
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
		line-height: 65px;
		margin: 0;
		padding: 0;
		float: left;
		color: #525252;
	}
	.findId h1{
		float: left;
	    margin-left: 130px;
	    line-height: 7px;
	    font-size: 43px;
	    color: black;
	    color: #525252;
	}
	.login a{
		float: left;
		margin-left:10px;
		text-decoration: none;
		line-height: 83px;
		height: 20px;
		color: #525252;
	}
	.findPw a{
		float: left;
		margin-left: 102px;
		text-decoration: none;
		line-height: 83px;
		height: 20px;
		color: #525252;
	}
	.from b{
		font-size: 15px;
    	margin-left: 10px;
	}
/* ---------------------------------------------------------------------------------------- */
	body {
		font-family: Arial, Helvetica, sans-serif;
		width: 700px;
		margin: auto;
		margin-top: 120px;
		height: auto;
	}
	
	form {
		border: 3px solid #525252;
		width: 700px;
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
		background-color: #525252;
		color: white;
		padding: 14px 20px;
		margin: 8px 0;
		border: none;
		cursor: pointer;
		width: 100%;
	}
	
	input[type=email] {
		width: 100%;
		padding: 12px 20px;
		margin: 8px 0;
		display: inline-block;
		border: 1px solid #ccc;
		box-sizing: border-box;
	}
	
	input[type=tel] {
		width: 100%;
		padding: 12px 20px;
		margin: 8px 0;
		display: inline-block;
		border: 1px solid #ccc;
		box-sizing: border-box;
	}
	
	.question {
		background-color: white;
		color: black;
		padding: 14px 20px;
		margin: 8px 0;
		border: none;
		cursor: pointer;
		width: 100%;
		font-size: 13px;
	}
	
	.userId {
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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오를 드립니다 기오PC -- 아이디 찾기</title>
</head>
<body>
	<div id="top" class="container">
		<div class="logo">
			<h1><a href="main.jsp">기오피씨</a></h1>
		</div>
		
		<div class="findId">
			<h1>아이디 찾기</h1>
		</div>
		<div class="findPw">
			<a href="findPw">비밀번호 찾기</a>
		</div>
		<div class="login">
			<a href="login">로그인</a>
		</div>
	</div>
	<form action="findId" onsubmit="return check();" method="post" name="form" class="from">
		<div class="container">
			<label for="name">
				<b>가입자 성명</b>
				<input type="text" placeholder="이름" name="name" id="name" value="${user.name }"required>
			</label>
			<label for="phone">
				<b>가입자 전화번호</b>
				<input type="tel" placeholder="전화번호" name="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="010-####-####형식으로 입력하시오" required>
			</label>
			<label for="email">
				<b>가입자 이메일</b>
				<input type="email" placeholder="이메일" name="email" required>
			</label>
			<label for="qusetion">
				<b>가입자 아이디 분실 질문 사항</b>
				<select id="question" class="question" name="question" style="border: 1px solid #d9d9d9;">
						<option value="자신의 보물 1호는?">자신의 보물 1호는?</option>
						<option value="내가 나온 중학교 이름은?">내가 나온 중학교의 이름은?</option>
				</select>
			</label>
			<label for="answer">
				<b>답변</b>
				<input type="text" name="answer" placeholder="답변" required>
			</label> 
			<label for="yourId">
			</label> <input type="submit" value="아이디 찾기">
		</div>
	</form>
</body>
</html>