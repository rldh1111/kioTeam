<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>검색기능</h1>
	<table border="1">
		<tr>
			<td>이름</td>
			<td>가격</td>
			<td>설명</td>
		</tr>

		<c:forEach var="product" items="${productList }">
			<tr>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.explanation }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>