<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>제품등록폼</h1>
	<form action="productRegister" method="post">
		<table border="1">
			<tr>
				<td>name</td>
				<td><input type="text" name="name" required></td>
				<c:if test="${errors.sameProduct }">
					<script>
						alert("중복된 이름입니다");
					</script>
				</c:if>
			</tr>
			<tr>
				<td>productType</td>
				<td><input type="text" name="productType" required></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price" required></td>
			</tr>
			<tr>
				<td>explanation</td>
				<td><input type="text" name="explanation" required></td>
			</tr>
			<tr>
				<td>url</td>
				<td><input type="text" name="url" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>