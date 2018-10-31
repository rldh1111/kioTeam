<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>로그인 화면</h4>
	<form action="<%=request.getContextPath()%>/loginSuccess.jsp">
		<input type="text" name="memberId" placeholder="아이디" autofocus> 
		<input type="password" name="password" placeholder="비밀번호"> 
		<input type="submit" value="로그인">
	</form>
</body>
</html>