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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="css/joinForm.css?1">
</head>
<body>
	<div id="header" class="container">
		<div class="logo">
			<h1><a href="main.jsp">기오피씨</a></h1>
		</div>
		<div class="join">
			<h1>회원가입</h1>
		</div>
		<c:if test="${user == null }">
			<div class="login">
				<a href="login" class="login">로그인</a>
			</div>
		</c:if>
	
	</div>
	<div class="container">

		<form action="join" onsubmit="return check()" method="post" name="form" class="from">

			<input type="hidden" name="userType" value="B">	

			<label for="loginId">
				<b>아이디</b>
				<input type="text" placeholder="아이디" name="loginId" id="loginId" value=${param.loginId } pattern="((?=.*\d)(?=.*[a-z]).{7,12})" title="소문자하나 숫자하나 이상 6~11자">
			</label> 
			
			<label for="password">
				<b>비밀번호</b>
				<input type="password" placeholder="비빌번호" name="password" value=${param.password } pattern="((?=.*\d)(?=.*[a-z])(?=.*[*\/+?!@#$%^&*()-_=|`~{},.]).{7,12})" title="소문자 ,특수기호,숫자 하나 이상 7~12자"></label> 
			
			<label for="confirmPassword">
				<b>비밀번호확인</b>
				<input type="password" placeholder="비밀번호확인" name="confirmPassword" value=${param.confirmPassword } id="confirmPassword">
			</label> 
				
			<label for="name">
				<b>이름</b>
				<input type="text" placeholder="이름" name="name" id="name" value=${param.name } required>
			</label> 
			
			<label for="email">
				<b>이메일</b>
				<input type="email" placeholder="이메일" name="email" value=${param.email } required>
			</label> 
			
			<label for="phone">
				<b>전화번호</b>
				<input type="tel" placeholder="전화번호" name="phone" value=${param.phone } pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="010-####-####형식으로 입력하시오" required>
			</label> 
			
			<label for="address">
				<b>주소</b>
				<input type="text" placeholder="주소" name="address" value=${param.address } pattern="([가-힣].{1,4})+[시]\s([가-힣].{0,4})+[구]\s([가-힣].{0,4})+[동]" title="OO시 OO구 OO동"   required>
			</label> 			
			
			<label for="question">
				<b>아이디/비밀번호 분실시 질문사항</b>
				<select id="question" class="question" name="question" value=${param.question } style="border:1px solid #d9d9d9;">
					<option value="자신의 보물 1호는?">자신의 보물 1호는?</option>
					<option value="내가 나온 중학교 이름은?" >내가 나온 중학교의 이름은?</option>						
				</select>	 
			</label>
			
			<label for="answer">
				<b>답변</b>
				<input type="text" name="answer" placeholder="답변" value=${param.answer } required>
			</label>
			<c:if test="${errors.duplicateId }">
				<script>alert("아이디가 중복되었습니다.");</script>
			</c:if>
			<c:if test="${errors.duplicateEmail }">
				<script>alert("이메일이 중복되었습니다.");</script>
			</c:if>
			<c:if test="${errors.duplicatePhone }">
				<script>alert("전화번호가 중복되었습니다.");</script>
			</c:if>
			<input type="submit" value="회원가입" >
		</form>	
	</div>
</body>
</html>