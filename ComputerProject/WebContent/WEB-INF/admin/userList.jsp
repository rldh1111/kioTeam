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
	<table border="1">
		<tr>
			<td>userId</td>
			<td>userType</td>
			<td>name</td>
			<td>loginId</td>
			<td>password</td>
			<td>address</td>
			<td>email</td>
			<td>phone</td>
			<td>question</td>
			<td>answer</td>
			<td>wdate</td>
		</tr>
		<c:forEach var="user" items="${userPage.users}">
			<tr>
				<td><a href="userModify?userId=${user.userId }">${user.userId }</a>
				</td>
				<td>${user.userType }</td>
				<td>${user.name }</td>
				<td>${user.loginId }</td>
				<td>${user.password }</td>
				<td>${user.address }</td>
				<td>${user.email }</td>
				<td>${user.phone }</td>
				<td>${user.question }</td>
				<td>${user.answer }</td>
				<td>${user.wdate }</td>
				<td><button onclick="location.href='userDelete?userId=${user.userId}'">삭제</button>
			</tr>
		</c:forEach>
		<c:if test="${userPage.hasUsers() }">
			<tr style="text-align: center">
				<td colspan="11"><c:if test="${userPage.startPage > 5 }">
						<a href="userList?pageNum=${userPage.startPage - 5  }"
							style="text-align: center">[이전]</a>
					</c:if> <c:forEach var="pageNum" begin="${userPage.startPage}"
						end="${userPage.endPage }">
						<a href="userList?pageNum=${pageNum}" style="text-align: center">
							[${pageNum}]</a>
					</c:forEach> <c:if test="${userPage.endPage < userPage.totalPages }">
						<a href="userList?pageNum=${userPage.startPage + 5 }"
							style="text-align: center">[다음]</a>
					</c:if></td>
			</tr>
		</c:if>
		<c:if test="${userPage.hasUsers() == null }">
			등록된 상품이 없습니다
		</c:if>
	</table>
	<div></div>
</body>
</html>