

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오피씨</title>
<style type="text/css">
	html, body{height: 100%;}
	
	body{
		margin: 0px;
		padding: 0px;
		background: #EFEFEF;
		font-family: 'Open Sans', sans-serif;
		font-size: 10pt;
		font-weight: 400;
		color: #8d8d8d;
		min-width: 1400px;
	}
	
	h1, h2, h3{
		margin: 0;
		padding: 0;
		color: #525252;
	}
	
	p, ol, ul{margin-top: 0;}
	
	ol, ul{
		padding: 0;
		list-style: none;
	}
	
	p{line-height: 180%;}

	a{color: #525252;}
	
	a:hover{text-decoration: none;}

	.container{
		margin: 0px auto;
		width: 1400px;
		text-align: center;
	}
/*********************************************************************************/
/* Header                                                                        */
/*********************************************************************************/

	#header{
		background: #333;
		border-top: 1px solid #333;
	}

/*********************************************************************************/
/* Logo,search,login                                                              */
/*********************************************************************************/
	#top {
		padding: 65px 0px;
		text-decoration: none;
		margin: auto;
	}
	.logo a{
		float: left;
		text-decoration: none;
		line-height: 1px;
	}
	.join a{
		float: left;
		margin-left:325px;
		text-decoration: none;
		line-height: 66px;
		height: 20px;
	}
	.login a{
		float: left;
		margin-left:10px;
		text-decoration: none;
		line-height: 66px;
		height: 20px;
	}
	.basket a{
		float: left;
		margin-left:10px;
		text-decoration: none;
		line-height: 66px;
		height: 20px;
	}
	.logout a{
		float: left;
		margin-left:10px;
		text-decoration: none;
		line-height: 66px;
		height: 20px;
	}

	.modify a{
		float: left;
		margin-left: 225px;
		text-decoration: none;
		line-height: 66px;
		height: 20px;
	}
	.productList a{
		float: left;
		margin-left: 170px;
		text-decoration: none;
		line-height: 66px;
		height: 20px;
	}
	.userList a{
		float: left;
		margin-left: 10px;
		text-decoration: none;
		line-height: 66px;
		height: 20px;
	}
	
	.search{
		border: 0.5px solid #525252;
		float: left;
		margin-left:290px;
		background-color: #525252;
		width: 570px;
		height: 46px;
	}
	#text{
		margin-left : 3px;
		height:30px;
		font-size: 16px;
		width: 500px;
	}
	#submit{
		border: 0px;
		width: 50px;
		height: 40px;
		color: white;
		background-color: #525252;
		outline: none;
		cursor: pointer;
	}
/*********************************************************************************/
/* Menu                                                                          */
/*********************************************************************************/
	
	#menu ul{
		margin: 0;
		padding: 20px 0px 20px 0px;
		list-style: none;
		line-height: normal;
		display: inline-block;
	}
	
	#menu li{
		display: inline-block;
		text-align: left;
	}
	
	#menu a{
		display: block;
		padding: 1em 2em;
		letter-spacing: 1px;
		text-decoration: none;
		text-transform: uppercase;
		font-size: 1em;
		font-weight: 700;
		color: #FFF;
		
	}
	
	#menu .computer_drop, .sound_drop, .assembled_pc_drop, .laptop_drop, .storage_device_drop{
	    display: inline-block;
	    color: white;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	    background: #525252;
	}
	
	#menu li a:hover, .computer:hover .computer_drop,
				.sound:hover .sound_drop,
				.assembled_pc:hover .assembled_pc_drop,
				.laptop:hover .laptop_drop,
				.storage_device:hover .storage_device_drop{
	    background-color: #747474;
	}
	
	#menu li .computer, .sound, .assembled_pc, .laptop, .storage_device{
	    display: inline-block;
	}
	
	#menu .computer_content, .sound_content, .assembled_pc_content, .laptop_content, .storage_device_content{
	    display: none;
	    position: absolute;
	    left: auto;
	    background-color: #333;
	    min-width: 160px;
	    z-index: 1;
	}
	
	#menu .computer_content a, .sound_content a, .assembled_pc_content a, .laptop_content a, .storage_device_content a{
	    padding: 12px 16px;
	    text-decoration: none;
	    display: block;
	}
	
	#menu .computer_content a:hover,
		.sound_content a:hover,
		.assembled_pc_content a:hover,
		.laptop_content a:hover,
		.storage_device_content a:hover{
		background: #949494;
		text-decoration: none;
	}
	#menu .computer:hover .computer_content,
		.sound:hover .sound_content,
		.assembled_pc:hover .assembled_pc_content,
		.laptop:hover .laptop_content,
		.storage_device:hover .storage_device_content{
	    display: inline-block;
	}

/*********************************************************************************/
/* Page                                                                          */
/*********************************************************************************/

	#page-wrapper{
		padding: 4em 0em 6em 0em;
		background: #FFF;
		border-top: 1px solid #47A665;
	}
	#page-wrapper li{
		border: 1px solid black;
	}
	
	

	#page{
		overflow: hidden;
		padding-top: 6em;
		border-top: 1px solid #E5E5E5;
		color: #717171;
	}

	#page .title{
		margin-bottom: 2em;
	}
	
	#page .title h2{
		font-size: 2em;
		font-weight: 800;
		color: #333;
	}
/*********************************************************************************/
/* Footer                                                                        */
/*********************************************************************************/

	#footer-wrapper{
		padding: 6em 0em 6em 0em;
		background: #f4f4f4;
		border-bottom: 1px solid #EDEDED;
		border-top: 1px solid #EDEDED;
	}

	#footer {
		overflow: hidden;
		color: #666666;
	}
	
	#footer h2
	{
		letter-spacing: 0.10em;
		padding-bottom: 1em;
		font-size: 1.3em;
		font-weight: 700;
		color: #333;
	}

	#footer #fbox1 {
		float: left;
		width: 282px;
		margin-right: 24px;
	}
	
	#footer #fbox2 {
		float: left;
		width: 282px;
		margin-right: 24px;
	}
	
	#footer #fbox3 {
		float: left;
		width: 282px;
	}

	#footer #fbox4 {
		float: right;
		width: 282px;
	}


/*********************************************************************************/
/* Copyright                                                                     */
/*********************************************************************************/

	#copyright
	{
		padding: 6em 0em;
		font-size: 0.85em;
		letter-spacing: 0.10em;
		text-align: center;
		color: #6A6A6A;
	}
	
	#copyright a
	{
		color: #747474;
	}

/*********************************************************************************/
/* Featured                                                                      */
/*********************************************************************************/

	#featured
	{
		overflow: hidden;
		padding-bottom: 6em;
		color: #717171;
	}
	
	#featured img{
		margin-bottom: 2em;
	}
	
	#featured .box{
		padding-bottom: 1.5em;
	}
	
	#featured .title{
		margin-bottom: 2em;
	}
	
	#featured .title h2{
		font-size: 2em;
		font-weight: 800;
		color: #333;
	}
	
	#featured .subtitle{
		padding-bottom: 1em;
		font-size: 1.3em;
		font-weight: 700;
		color: #333;
	}

	#featured #box1 {
		float: left;
		width: 282px;
		margin-right: 24px;
	}
	
	#featured #box2 {
		float: left;
		width: 282px;
		margin-right: 24px;
	}
	
	#featured #box3 {
		float: left;
		width: 282px;
	}

	#featured #box4 {
		float: right;
		width: 282px;
	}
</style>
</head>
<body>
	<div id="top" class="container">
		<div class="logo">
			<h1><a href="main.jsp">기오피씨</a></h1>
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
				<div class="payment">
					<a href="payment">결제내역확인</a>
				</div>
				<div class="modify">
					<a href="modify?userId=${user.userId}" class="modify">회원정보수정</a>
				</div>
				<div class="logout">
					<a href="logout" class="logout">로그아웃</a>
				</div>
				<div class="shopping">
					<a href="shopping" class=shopping>장바구니</a>
				</div>
			</c:if>
		</c:if>

		<c:if test="${user.userType == 'A' }">
				<div class="payment">
					<a href="admin/payment">결제내역확인</a>
				</div>
			<div class="productList">
				<a href="admin/productList">상품관리페이지</a>
			</div>
			<div class="userList">
				<a href="admin/userList">회원관리페이지</a>
			</div>
			<div class="logout">
				<a href="logout">로그아웃</a>
			</div>
		</c:if>
	</div>
	<div id="header">
		<div id="menu" class="container">
			<ul>
				<li class="computer">
					<a href="#" class="computer_drop">컴퓨터 주요부품</a>
					<div class="computer_content">
						<a href="item?productType=cpu">cpu</a> 
						<a href="item?productType=ram">램</a> 
						<a href="item?productType=cpu">메인보드</a>
						<a href="item?productType=vga">그래픽 카드</a> 
						<a href="item?productType=case">케이스</a> 
						<a href="item?productType=poser">파워</a> 
						<a href="item?productType=keyboard">키보드</a>
						<a href="item?productType=mouse">마우스</a> 
						<a href="item?productType=hdd">HDD</a>
						<a href="item?productType=ssd">SSD</a> 
						<a href="item?productType=odd">ODD</a>
					</div>
				</li>
			</ul>
			<ul>
				<li class="sound"><a href="#" class="sound_drop">사운드</a>
					<div class="sound_content">
						<a href="item?productType=headset">헤드셋</a> <a
							href="item?productType=speaker">스피커</a> <a
							href="item?productType=mic">마이크</a> <a
							href="item?productType=sc">사운드 카드</a>
					</div></li>
			</ul>

			<ul>
				<li class="laptop"><a href="#" class="laptop_drop">노트북</a>
					<div class="laptop_content">
						<a href="item?productType=glap">게이밍 노트북</a> <a
							href="item?productType=slap">초경량 노트북</a> <a
							href="item?productType=dlap">디자인 노트북</a> <a
							href="item?productType=blap">비지니스 노트북</a>
					</div></li>
			</ul>
			<ul>
				<li class="storage_device"><a href="#"
					class="storage_device_drop">저장장치</a>
					<div class="storage_device_content">
						<a href="item?productType=ehd">외장하드</a> <a
							href="item?productType=essd">외장SSD</a> <a
							href="item?productType=nas">NAS</a> <a
							href="item?productType=usb">USB메모리</a>
					</div></li>
			</ul>
		</div>
	</div>
	<div id="page-wrapper" class="container">
		<ul>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div> 
	<div id="copyright">
		<p>
			&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
</body>
</html>

