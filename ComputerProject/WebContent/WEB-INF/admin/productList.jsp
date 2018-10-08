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
			<td>url</td>
			<td>productId</td>
			<td>name</td>
			<td>productType</td>
			<td>price</td>
			<td>explanation</td>
			<td>wdate</td>
			<td>udate</td>
			<td colspan="2">button</td>
		</tr>

		<c:forEach var="product" items="${productPage.products }">
			<tr>
				<td><img src="${product.url }"
					style="width: 100px; height: 100px"></td>
				<td><a href="productModify?userId=${product.productId }">${product.productId }</a>
				</td>
				<td>${product.name }</td>
				<td>${product.productType }</td>
				<td>${product.price }</td>
				<td>${product.explanation }</td>
				<td>${product.wdate }</td>
				<td>${product.udate }</td>
				<td><button onclick="location.href='productDelete?productId=${product.productId}'">삭제</button>
				<td><button onclick="location.href='productModify?productId=${product.productId}'">수정</button>
			</tr>
		</c:forEach>

		<tr style="text-align: center">
			<td colspan="9">
				<a href="productList?pageNum=1">[처음]</a>
	
				<c:if test="${productPage.startPage > 5 }">
					<a href="productList?pageNum=${productPage.startPage - 5  }" style="text-align: center">[이전]</a>
				</c:if>
	
				<c:forEach var="pageNum" begin="${productPage.startPage}" end="${productPage.endPage }">
					<a href="productList?pageNum=${pageNum}" style="text-align: center">[${pageNum}]</a>
				</c:forEach>
	
				<c:if test="${productPage.endPage < productPage.totalPages }">
					<a href="productList?pageNum=${productPage.startPage + 5 }" style="text-align: center">[다음]</a>
				</c:if>
		
				<a href="productList?${productPage.totalPages }">[마지막]</a>
			<td>
		</tr>

		<tr>
			<td><button onclick="location.href='productRegister'">추가</button></td>
		</tr>

		<c:if test="${errors.duplicateName }">
			<script>
				alert("이름이 중복되었습니다");
			</script>
		</c:if>


	</table>
	<div></div>
</body>
</html>