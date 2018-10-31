<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/paymentList.css?1">
</head>
<div id="header" class="container">
		<div class="logo">
			<h1>
				<a href="main.jsp">기오피씨</a>
			</h1>
		</div>
		<div class="search">
			<form action="search">
				<table>
					<tr>
						<td><input type="text" name="search" id="text"></td>
						<td><input type="submit" value="검색" id="submit"></td>
					</tr>
				</table>
			</form>
		</div>
		<c:if test="${user == null }">
			<div class="join">
				<a href="join" class="join">회원가입</a>
			</div>
			<div class="login">
				<a href="login" class="login">로그인</a>
			</div>
		</c:if>
		<c:if test="${user != null }">
			<c:if test="${user.userType == 'B' }">
				<div class="modify">
					<a href="modify?userId=${user.userId}" class="modify">회원정보수정</a>
				</div>
				<div class="basket">
					<a href="basket?userId=${user.userId}" class="basket">장바구니</a>
				</div>
				<div class="payment">
					<a href="paymentList?userId=${user.userId }">결제정보</a>
				</div>
				<div class="logout">
					<a href="logout" class="logout">로그아웃</a>
				</div>
			</c:if>
		</c:if>
		<c:if test="${user.userType == 'A' }">
			<div class="productList">
				<a href="admin/productList">제품관리</a>
			</div>
			<div class="userList">
				<a href="admin/userList">회원관리</a>
			</div>
			<div class="payment">
				<a href = "admin/paymentList">결제정보</a>
			</div>
			<div class="logout">
				<a href="logout">로그아웃</a>
			</div>
		</c:if>
	</div>
			<div id="menu" class="container">
			<ul>
				<li class="computer">
					<a href="typeList?type=mainparts" class="computer_drop">컴퓨터 주요부품</a>
					<div class="computer_content">
						<a href="item?productType=cpu">cpu</a> 
						<a href="item?productType=ram">램</a> 
						<a href="item?productType=mainboard">메인보드</a>
						<a href="item?productType=vga">그래픽 카드</a> 
						<a href="item?productType=case">케이스</a> 
						<a href="item?productType=power">파워</a> 
						<a href="item?productType=keyboard">키보드</a>
						<a href="item?productType=mouse">마우스</a> 
						<a href="item?productType=hdd">HDD</a>
						<a href="item?productType=ssd">SSD</a> 
						<a href="item?productType=odd">ODD</a>
					</div>
				</li>
			</ul>
			<ul>
				<li class="sound"><a href="typeList?type=sound" class="sound_drop">사운드</a>
					<div class="sound_content">
						<a href="item?productType=headset">헤드셋</a> <a
							href="item?productType=speaker">스피커</a> <a
							href="item?productType=mic">마이크</a> <a
							href="item?productType=sc">사운드 카드</a>
					</div></li>
			</ul>

			<ul>
				<li class="laptop"><a href="typeList?type=notebook" class="laptop_drop">노트북</a>
					<div class="laptop_content">
						<a href="item?productType=glap">게이밍 노트북</a> <a
							href="item?productType=slap">초경량 노트북</a> <a
							href="item?productType=dlap">디자인 노트북</a> <a
							href="item?productType=blap">비지니스 노트북</a>
					</div></li>
			</ul>
			<ul>
				<li class="storage_device"><a href="typeList?type=save"
					class="storage_device_drop">저장장치</a>
					<div class="storage_device_content">
						<a href="item?productType=ehd">외장하드</a> <a
							href="item?productType=essd">외장SSD</a> <a
							href="item?productType=nas">NAS</a> <a
							href="item?productType=usb">USB메모리</a>
					</div></li>
			</ul>
		</div>
	<div id="main" class="container">
	<div class="paymentList">
			<c:if test="${!paymentPage.hasProduct()}">
			<h1 style="font-size:40px">결제한 상품이 없습니다</h1>
			</c:if>
			<c:if test="${paymentPage.hasProduct()}">
			<table>
	
			<tr>
				<td>사진</td>
				<td>제품이름</td>
				<td width="40px;">개수</td>
				<td>가격</td>
				<td>구매 날짜</td>
			</tr>
				
			
			<c:forEach var="payment" items="${paymentPage.payments }">
				<tr>
					<td><img  src="${payment.url }" style="width: 150px" height="140px">
					<td>${payment.productName }</td>
					<td>${payment.count  }</td>
					<td><fmt:formatNumber value="${payment.price * payment.count}"/>원</td>
					<td>${payment.wdate}
				</tr>
	
	
			</c:forEach>
		
		</table>
		</c:if>
	</div>
	<c:if test="${paymentPage.hasProduct()}">
		<div>
					<a href="paymentList?userId=${user.userId }&pageNum=1" class="pageNum">처음</a>
		
					<c:if test="${productPage.startPage > 5 }">
						<a href="paymentList?userId=${user.userId }&pageNum=${paymentPage.startPage - 5  }" class="pageNum">이전</a>
					</c:if>
		
					<c:forEach var="pageNum" begin="${paymentPage.startPage}" end="${paymentPage.endPage }">
						<a href="paymentList?userId=${user.userId }&pageNum=${pageNum}" class="pageNum">${pageNum}</a>
					</c:forEach>
		
					<c:if test="${paymentPage.endPage < paymentPage.totalPages }">
						<a href="paymentList?userId=${user.userId }&pageNum=${paymentPage.startPage + 5 }" class="pageNum">다음</a>
					</c:if>
			
					<a href="paymentList?userId=${user.userId }&pageNum=${paymentPage.totalPages }" class="pageNum">마지막</a>
		</div>
		</c:if>
	</div>
	<div id="footer">
		<p>
			이현승 권기오 박용훈 프로젝트!
		</p>
	</div>
</body>
</html>