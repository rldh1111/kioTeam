<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	body{
	    padding: 60px;
	    background: #EFEFEF;
	    font-size: 10pt;
	    width: 1000px;
	    margin: auto;
	}

	a{color: black;}
	
	.container{
		margin: 0px auto;
		width: 1400px;
		text-align: center;
	}
	
	#header {
		padding: 60px 0px;
		text-decoration: none;
		height: 0px;
		margin-bottom: 30px;
	}
	
	.logo a{
		text-decoration: none;
		line-height: 80px;
		color: #525252;
		float: left;
	}
	.productlist a{
		float: left;
		text-decoration: none;
		line-height: 80px;
		text-align: center;
		margin-left: 330px;
	}
	
	table {
		border: 3px solid #525252;
		border-collapse: collapse;
		width: 1000px;
	}
	table th,td{
		border-bottom : 1px solid black;
		text-align: center;
		border-right: 1px solid black;
	}
	.pageNum {
		text-decoration: none;
		border: 0.5px solid gray;
		border-radius: 4px;
		padding: 1px;
	}
	.pageNum:hover {
		text-decoration: none;
		background-color: gray;
	}
	img{
		width: 100px;
		height: 100px;
	}
</style>
</head>
<body>
	<script>
	function deleteFunc(productId){
		    var r = confirm("정말 삭제하시겠습니까?");
		    if (r == true) {
		    	location.href="productDelete?productId="+productId+"&pageNum=${productPage.currentPage}";
		    } 
	}
</script>
	<div class="header">
		<div class="logo">
					<h1><a href="${pageContext.request.contextPath }/main.jsp">기오피씨</a></h1>
		</div>
		<div class="productlist">
				<h1><a>제품 정보 관리</a></h1>
		</div>
	</div>
	<table>
		<tr>
			<th>url</th>
			<th>productId</th>
			<th>name</th>
			<th>productType</th>
			<th>price</th>
			<th>explanation</th>
			<th>wdate</th>
			<th>udate</th>
			<th colspan="2">button</th>
		</tr>

		<c:forEach var="product" items="${productPage.products }">
			<tr>
				<td><img src="${pageContext.request.contextPath }/${product.url }"></td>
				<td>${product.productId }</td>
				<td>${product.productName }</td>
				<td>${product.productType }</td>
				<td>${product.price }</td>
				<td>${product.explanation }</td>
				<td>${product.wdate }</td>
				<td>${product.udate }</td>
				<td width="50px;"><button onclick="deleteFunc(${product.productId})">삭제</button>
				<td width="50px;"><button onclick="location.href='productModify?productId=${product.productId}'">수정</button>
			</tr>
		</c:forEach>
		<c:if test="${productPage.hasProducts() }">
		<tr>
			<td colspan="9"  style="border: 0px; padding-left: 90px;">
				<a href="productList?pageNum=1" class="pageNum">처음</a>
	
				<c:if test="${productPage.startPage > 5 }">
					<a href="productList?pageNum=${productPage.startPage - 5  }" class="pageNum">이전</a>
				</c:if>
	
				<c:forEach var="pageNum" begin="${productPage.startPage}" end="${productPage.endPage }">
					<a href="productList?pageNum=${pageNum}" class="pageNum">${pageNum}</a>
				</c:forEach>
	
				<c:if test="${productPage.endPage < productPage.totalPages }">
					<a href="productList?pageNum=${productPage.startPage + 5 }" class="pageNum">다음</a>
				</c:if>
		
				<a href="productList?pageNum=${productPage.totalPages }" class="pageNum">마지막</a>
			</td>
			<td><button onclick="location.href='productRegister'" >추가</button></td>
		</tr>
		</c:if>
		<c:if test="${errors.duplicateName }">
			<script>
				alert("이름이 중복되었습니다");
			</script>
		</c:if>
	</table>
	<div></div>
</body>
</html>