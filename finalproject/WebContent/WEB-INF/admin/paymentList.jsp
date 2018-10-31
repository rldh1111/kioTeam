<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	    padding: 10px;
	    background: #EFEFEF;
	    font-size: 10pt;
	    width: 1000px;
	    margin: auto;
	}
	a{color: black;}
	
	.container{
		margin: 0px auto;
		width: 1000px;
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
		line-height: 116px;
		color: #525252;
		float: left;
	}

	.userbuy h1{
		float: left;
		text-decoration: none;
		line-height: 80px;
		text-align: center;
		margin-left: 310px;
	}
	
	table {
	border: 3px solid #525252;
	border-collapse: collapse;
	width: 1000px;
	text-align: center;
	margin: auto;
	}
	table th,td{
		border-bottom : 1px solid black;
		line-height: 35px;
	}
	.pageNum{
		text-decoration: none;
	    border: 0.5px solid gray;
	    border-radius: 4px;
	    padding: 1px;
	}
	.pageNum:hover{
		text-decoration: none;
		background-color: gray;
	}
</style>
</head>
<body>
	<div class="header">
		<div class="logo">
				<h1><a href="${pageContext.request.contextPath }/main.jsp">기오피씨</a></h1>
		</div>
		<div class="userbuy">
			<h1>회원 결제내역</h1>
		</div>
	</div>
	<table border="1">
		<tr>
			<td>url</td>
			<td>paymentId</td>
			<td>userId</td>
			<td>userName</td>
			<td>productId</td>
			<td>productName</td>
			<td>price</td>
			<td>count</td>
			<td>userName</td>
			<td>address</td>
			<td>phone</td>
		</tr>
		<c:forEach var="payment" items="${paymentPage.payments }">
			<tr>
				<td><img src="${pageContext.request.contextPath }/${payment.url }" style="width:100px; height:100xp;"></td>
				<td>${payment.paymentId }</td>
				<td>${payment.userId }</td>
				<td>${payment.userName }</td>
				<td>${payment.productId }</td>
				<td>${payment.productName }</td>
				<td>${payment.price * payment.count}</td>
				<td>${payment.count }</td>
				<td>${payment.userName }</td>
				<td>${payment.address }</td>
				<td>${payment.phone }</td>
			</tr>
		</c:forEach>
		<c:if test="${productPage.hasProducts() }">
		<tr>
			<td colspan="11">
				<a href="paymentList?pageNum=1" class="pageNum">처음</a>
	
				<c:if test="${productPage.startPage > 5 }">
					<a href="paymentList?pageNum=${paymentPage.startPage - 5  }" class="pageNum">이전</a>
				</c:if>
	
				<c:forEach var="pageNum" begin="${paymentPage.startPage}" end="${paymentPage.endPage }">
					<a href="paymentList?pageNum=${pageNum}" class="pageNum">${pageNum}</a>
				</c:forEach>
	
				<c:if test="${paymentPage.endPage < paymentPage.totalPages }">
					<a href="paymentList?pageNum=${paymentPage.startPage + 5 }" class="pageNum">다음</a>
				</c:if>
				<a href="paymentList?pageNum=${paymentPage.totalPages }" class="pageNum">마지막</a>
			</td>
		</tr>
		</c:if>
	</table>
</body>
</html>