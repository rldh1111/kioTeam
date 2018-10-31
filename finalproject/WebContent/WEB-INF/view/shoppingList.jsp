<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>기오피씨</title>
<link rel="stylesheet" href="css/shoppingList.css?2">
<script>
	var sum = 0;
	function allclear(productId){
		location.href= "delete?productId="+productId;
	}
	function deleteFunc(productId, userId){
	    var r = confirm("정말 삭제하시겠습니까?");
	    if (r == true) {
	    	location.href="basketDelete?productId="+productId+"&userId="+userId;
	    } 
	}
	function payment(userId){
		  var r = confirm("모두 구매하시겠습니까?");
		    if (r == true) {
		    	location.href="payment?userId="+userId;
		    	alert("결제 성공");
		    } 
	}

	

</script>

</head>
<body>
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
				<div class="paymentList">
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
			<div class="adminPaylist">
				<a href = "admin/paymentList" >결제정보</a>
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
			<div class="basketlist">
					<c:if test="${!shoppingPage.hasProduct()}">
						<tr>
							<td><a style="font-size: 50px;">장바구니에 제품이 없습니다.</a></td>
						</tr>
					</c:if>
					<c:if test="${shoppingPage.hasProduct()}">
					<table>
					
					<c:forEach var="shopping" items="${shoppingPage.spList}">
								<input type="hidden" name="productId" value="${shopping.productId}">
								<input type="hidden" name="productType" value="${shopping.productType }">
						<tr>
								<td rowspan="2" class="img" style="padding: 5px 20px 5px 20px"><img src="${shopping.url }" style="width: 150px; height: 150px"> </td>
								<td>${shopping.productName }</td>
									
								<td id="price" >${shopping.price }</td>
								<td>${shopping.price * shopping.count }</td>
								<td rowspan="2" class="delete" style="width: 80px; text-align: center;">
								<button onclick="deleteFunc(${shopping.productId},'${shopping.userId}')">삭제</button></td>
						</tr>
						<tr>
							<td class="explanation">${shopping.explanation }</td>
							<td class="count">
								<input id="count" name="count" type="number" min="1" max="20"
								value="${shopping.count }" disabled="disabled">
							</td>
						</tr>	
									${sum = sum+(shopping.price*shopping.count); ''}
									
					<input type="hidden" value="${sum}" name="sumprice">
					</c:forEach>
					
					<c:if test="${shoppingPage.hasProduct()}">
						<tr style="text-align: center;">
							<td colspan="6"><c:if test="${shoppingPage.startPage > 5 }">
									<a href="basket?pageNum=${shoppingPage.startPage - 5  }&userId=${user.userId}&sumprice=${sum}" class="pageNum">이전</a>
								</c:if> <c:forEach var="pNo" begin="${shoppingPage.startPage}" end="${shoppingPage.endPage }">
									<a href="basket?pageNum=${pNo}&userId=${user.userId}&sumprice=${sum}" class="pageNum">${pNo}</a>
								</c:forEach> <c:if test="${shoppingPage.endPage < shoppingPage.totalPages }">
									<a href="basket?pageNum=${shoppingPage.startPage + 5 }&userId=${user.userId}&sumprice=${sum}" class="pageNum">다음</a>			
								</c:if></td>
						</tr>
					</c:if>
				</table>
				</c:if>
			</div>
				<c:if test="${shoppingPage.hasProduct()}">
				<div class="buy">
					<table>
							<tr>
								<td>총 가격 : <fmt:formatNumber value="${sum+sumPrice}" currencyCode="kor"/>원</td>
							</tr>
							<tr>
								<td class="buyButton"><button onclick="payment(${user.userId})">구매하기</button></td>
							</tr>	
					</table>
				</div>
			</c:if>
		</div>
	<div class="shoppingmarket">
		<span id="Basketname" value=""></span>
	</div>
	<div id="footer">
		<p>
			이현승 권기오 박용훈 프로젝트!
		</p>
	</div>
</body>
</html>