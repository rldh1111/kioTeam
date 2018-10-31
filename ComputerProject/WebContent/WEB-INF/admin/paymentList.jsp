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
	<h1>admin 결제내역</h1>
	<table border="1">
		<tr>
			<td>paymentId</td>
			<td>productId</td>
			<td>productName</td>
			<td>numbers</td>
			<td>price</td>
			<td>loginId</td>
			<td>userName</td>
			<td>address</td>
			<td>phone</td>
		</tr>
		<c:forEach var="payment" items="${paymentpage.payments }">
			<tr>
				<td>${payment.paymentId }</td>
				<td>${payment.productId }</td>
				<td>${payment.productName }</td>
				<td>${payment.price }</td>
				<td>${payment.numbers }</td>
				<td>${payment.loginId }</td>
				<td>${payment.userName }</td>
				<td>${payment.address }</td>
				<td>${payment.phone }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>