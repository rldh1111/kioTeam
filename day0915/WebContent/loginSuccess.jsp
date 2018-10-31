<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//로그인을 하고나서 세션을 생성해주고 로그인 정보를 넣어줌!!
	String memberId = request.getParameter("memberId");
	session.setAttribute("member", memberId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=memberId%>
	로그인 성공 처리화면
	<a href="board/list.jsp">[리스트]</a>
</body>
</html>