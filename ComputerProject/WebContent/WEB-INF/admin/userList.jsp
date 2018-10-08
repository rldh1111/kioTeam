<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	html, body{height: 100%;}
	
	body{
		margin: 0px;
		padding: 0px;
		background: #EFEFEF url(images/bg01.png) repeat;
		font-family: 'Open Sans', sans-serif;
		font-size: 10pt;
		text-align: center;
		width: 1000px;
		margin: auto;
	}
	
	h1, h2, h3{
		margin: 0;
		padding: 0;
		color: #525252;
	}
	
	p, ol, ul{margin-top: 0;}
	
	ol, ul{
		padding: 0;
		list-style: none;
	}
	
	p{line-height: 180%;}

	a{color: #525252;}
	
	a:hover{text-decoration: none;}

	.container{
		margin: 0px auto;
		width: 1400px;
		text-align: center;
	}
	table {
	border: 3px solid #525252;
	border-collapse: collapse;
	width: 1000px;
	}
	table th,td{
		border-bottom : 1px solid black;
		padding: 3px;
	}
</style>
</head>
<body>
	<div id="user" class="container">
	<table>
		<tr>
			<th>userId</th>
			<th>userType</th>
			<th>name</th>
			<th>loginId</th>
			<th>password</th>
			<th>address</th>
			<th>email</th>
			<th>phone</th>
			<th>question</th>
			<th>answer</th>
			<th>wdate</th>
			<th>delete</th>
		</tr>
		<c:forEach var="user" items="${userPage.users}">
			<tr>
				<td>
					<a href="userModify?userId=${user.userId }">${user.userId }</a>
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
				<td colspan="12"><c:if test="${userPage.startPage > 5 }">
						<a href="userList?pageNum=${userPage.startPage - 5  }" style="text-align: center">[이전]</a>
					</c:if>
					<c:forEach var="pageNum" begin="${userPage.startPage}" end="${userPage.endPage }">
						<a href="userList?pageNum=${pageNum}" style="text-align: center">[${pageNum}]</a>
					</c:forEach>
					<c:if test="${userPage.endPage < userPage.totalPages }">
						<a href="userList?pageNum=${userPage.startPage + 5 }" style="text-align: center">[다음]</a>
					</c:if>
				</td>
			</tr>
		</c:if>
		<c:if test="${userPage.hasUsers() == null }">
			등록된 상품이 없습니다
		</c:if>
	</table>
	</div>
</body>
</html>