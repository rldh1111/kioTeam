<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오피씨</title>
<link rel="stylesheet" href="css/main.css?2">
</head>
<style>
 	#img img{
		width: 200px;
		height: 250px;
		padding: 15px;
		margin: 10px;
	}
</style>
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
		<div id="img">
			<img src="img/computer1.jpg">
			<img src="img/computer2.jpg">
			<img src="img/computer3.jpg">
			<img src="img/computer4.jpg">
			<img src="img/monitor1.jpg">
			<img src="img/monitor2.jpg">
			<img src="img/monitor3.jpg">
			<img src="img/monitor4.jpg">
			<img src="img/monitor5.jpg">
			<img src="img/monitor6.jpg">
			<img src="img/monitor7.jpg">
			<img src="img/mouse1.jpg">
			<img src="img/mouse2.jpg">
			<img src="img/mouse3.jpg">
			<img src="img/mouse5.jpg">
			<img src="img/keyboard1.jpg">
			<img src="img/keyboard2.jpg">
			<img src="img/keyboard3.jpg">
			<img src="img/keyboard4.jpg">
			<img src="img/keyboard5.jpg">
		
		</div>
	</div>
	<div id="footer">
		<p>
			이현승 권기오 박용훈 프로젝트!
		</p>
	</div>
</body>
</html>