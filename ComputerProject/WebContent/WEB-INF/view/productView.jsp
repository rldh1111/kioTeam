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
			<td>사진</td>
			<td>상품명</td>
			<td>가격</td>
			<td>설명</td>
		</tr>

		<c:forEach var="product" items="${productPage.products }">
			<tr>
				<td><img src="${product.url }">
				<td><a href="item/view?productId=${product.productId}">${product.name }</a></td>
				<td>${product.price }
				${type = product.productType;'' }</td>
				<td>${product.explanation }</td>
				
			</tr>
		</c:forEach>
		<tr style="text-align: center">
				<td colspan="8">
					<c:if test="${productPage.startPage > 5 }">
						<a href="productList?pageNum=${productPage.startPage - 5  }" style="text-align: center">[이전]</a>
					</c:if>
					<c:forEach var="pageNum" begin="${productPage.startPage}" end="${productPage.endPage }">
						<a href="productList?pageNum=${pageNum}" style="text-align: center"> [${pageNum}]</a>
					</c:forEach>
					<c:if test="${productPage.endPage < userPage.totalPages }">
						<a href="productList?pageNum=${productPage.startPage + 5 }" style="text-align: center">[다음]</a>
					</c:if>
				</td>
			</tr>
		<c:if test="${!productPage.hasProducts() }">
			상품이 존재하지 않습니다
		</c:if>
	</table>
</body>
</html>