<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지</h1>
	<form action="productModify" method="post">
		<table>
			<tr>
				<td>productId</td>
				<td><input type="text" name="productId" value="${modReq.productId }" required></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${modReq.name }" required></td>
			
			</tr>
			<tr>
				<td>productType</td>
				<td><input type="text" name="productType" value="${modReq.productType }" required></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price" value="${modReq.price }" required></td>
			</tr>
			<tr>
				<td>explanation</td>
				<td><input type="text" name="explanation" value="${modReq.explanation }" required></td>
			</tr>
			<tr>
				<td>url</td>
				<td><input type="text" name="url" value="${modReq.url }" required></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="수정"></td>
			</tr>
		</table>

	</form>
</body>
</html>