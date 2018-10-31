<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${user.loginId != null }">
		<script>
			alert("고객님의 아이디는 [ "+ ${user.loginId} ] +"입니다.");
			location.href = "main.jsp";
		</script>
	</c:if>
	<c:if test="${param.name != null }">
		<c:if test="${user.loginId == null }">
			<script>
				alert("입력한 정보로 가입된 아이디가 없습니다.");
				location.href = "main.jsp";
			</script>
		</c:if>
	</c:if>
</body>
</html>