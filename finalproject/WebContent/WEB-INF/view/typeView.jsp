<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/typeView.css?2">
</head>
<body>
<script>
function insertFunc(userId, productId, count){
	var r = confirm("장바구니에 추가하시겠습니까?");
	if(r == true){
		alert("추가 완료!");
		location.href = "type?userId="+userId+"&productId="+productId+"&pageNum=${productPage.currentPage}&count="+count
	}
}
function paymentFunc(userId, productId, count){
	var r = confirm("결제하시겠습니까?");
	if(r == true){
		alert("결제 성공");
		location.href = "buy?userId="+userId+"&productId="+productId+"&count="+count+"&pageNum=${productPage.currentPage}";
	}
}
</script>
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
		<div class="noProduct">
			<c:if test="${!productPage.hasProducts()}">
				제품이 없습니다.
			</c:if>
		</div>
		<ul>
	<c:forEach var="product" items="${productPage.products}">
				${type = product.type;''}
				<li class="product_list">
						<div class="product_img">
							<img src="${product.url }" style="width: 250px; height: 250px">
						</div>
						<div class="product_cnt">
							<div class="title">
								${product.productName }
							</div>
							<div class="spec">
								<a>${product.explanation}</a>
							</div>
								<div class="price">
								<input type="text"  id="A+${product.productId}" value="${product.price }" class="money" disabled="disabled">
								<input type="number" id="B+${product.productId}" value="1" min="1" max="20" name="count">
								<script type="text/javascript">
									var A= 'A';
									var A${product.productId}A = document.getElementById('B+${product.productId}');
									var B= 'B';
									var B${product.productId} = document.getElementById('A+${product.productId}').value;
									var C= 'C';
									var C${product.productId} = '';					
									var count1 = 1;
									A${product.productId}A.addEventListener("input", function(e) {
										count1++;
										C${product.productId} = (A${product.productId}A.value*B${product.productId});
										console.log(B${product.productId});
										C${product.productId} = C${product.productId}.toString().replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,')
										document.getElementById('A+${product.productId}').value = C${product.productId}				
									}, false);
									function count(){
										return count1;
									}
					
								</script>	 
							</div>
							<c:if test="${user!=null }">
							<div>
								<button onclick="insertFunc(${user.userId}, ${product.productId },count())">장바구니추가</button>
								<button onclick ="paymentFunc(${user.userId},${product.productId },count())">구매</button>
							</div>
							</c:if>
						</div>	
				</li>
			</c:forEach>
		</ul>
		<c:if test="${productPage.hasProducts()}">
		<div id="pageNum">
			<c:if test="${productPage.startPage > 5 }">
					<a href="typeList?type=${type}&pageNum=${productPage.startPage - 5  }" class="pageNum">이전</a>
			</c:if> 
			<c:forEach var="pageNum" begin="${productPage.startPage}" end="${productPage.endPage }">
				<a href="typeList?type=${type}&pageNum=${pageNum}" class="pageNum"> ${pageNum}</a>
			</c:forEach> 
			<c:if test="${productPage.endPage < productPage.totalPages }">
				<a href="typeList?type=${type}&pageNum=${productPage.startPage + 5 }" class="pageNum">다음</a>
			</c:if>
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