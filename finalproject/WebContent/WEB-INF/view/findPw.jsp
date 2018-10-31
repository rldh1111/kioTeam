<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<script>
	function check() {
		 var f=document.form;
		 if(!f.loginId.value){
			 alert("아이디를 입력하세요 !");
			 f.loginId.focus();
			 return false;
		 }else if(!f.phone.value){
			 alert("전화번호를  입력하세요 !");
			 f.phone.focus();
			 return false;
		 }else if(!f.email.value){
			 alert("이메일를  입력하세요 !");
			 f.email.focus();
			 return false;
		 }
	
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오를 드립니다 기오PC -- 비밀번호 찾기</title>
<link rel="stylesheet" href="css/findPw.css">
</head>
<body>
	<div id="header" class="container">
		<div class="logo">
			<h1><a href="main.jsp">기오피씨</a></h1>
		</div>
		
		<div class="findPw">
			<h1>비밀번호 찾기</h1>
		</div>
			<div class="findId">
				<a href="findId">아이디 찾기</a>
			</div>
			<div class="login">
				<a href="login">로그인</a>
			</div>
	</div>
	<form action="findPw" onsubmit="return check();" method="post" name="form" class="from">
		<div class="container">	
			<label for="loginId">
				<b>가입자 아이디</b>
				<input type="text" placeholder="아이디" name="loginId" id="loginId" value="${user.loginId }" required>
			</label>
			
			<label for="phone">
				<b>가입자 전화번호</b>
				<input type="tel" placeholder="전화번호" name="phone" value="${param.phone }"pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required>
			</label>
			
			<label for="email">
				<b>가입자 이메일</b>
				<input type="email" placeholder="이메일" name="email" value="${param.email }" required>
			</label>
					
			
			<label for="qusetion">
				<b>가입자 비밀번호 분실 질문 사항</b>
				<select id="question" class="question" name="question" value="${param.question }"  style="border:1px solid #d9d9d9;">
					<option value="자신의 보물 1호는?">자신의 보물 1호는?</option>
					<option value="내가 나온 중학교 이름은?" >내가 나온 중학교의 이름은?</option>						
				</select>	 
			</label>
			
			<label for="answer">
				<b>답변</b>
				<input type="text" name="answer"  value="${param.answer }" placeholder="답변" required>
			</label>	
			
					
			<label for="yourId">
					<c:if test="${user.loginId != null}">				
					고객님의 비밀번호는 ${user.loginId }입니다.</c:if>
						<c:if test="${param.phone != null}">
							<c:if test ="${user.loginId == null}">
								입력한 정보로 가입된 비밀번호가 없습니다.				
							</c:if>
					</c:if>
	
			</label>

			<input type="submit" value="비밀번호 찾기">
		</div>
	</form>
</body>
</html>