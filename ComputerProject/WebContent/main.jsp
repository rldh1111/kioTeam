<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기오피씨</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Open+Sans:400,300,600,700,800"
	rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
html, body {
	height: 100%;
}

body {
	margin: 0px;
	padding: 0px;
	background: #EFEFEF url(images/bg01.png) repeat;
	font-family: 'Open Sans', sans-serif;
	font-size: 10pt;
	font-weight: 400;
	color: #8d8d8d;
}

h1, h2, h3 {
	margin: 0;
	padding: 0;
	color: #525252;
}

p, ol, ul {
	margin-top: 0;
}

ol, ul {
	padding: 0;
	list-style: none;
}

p {
	line-height: 180%;
}

a {
	color: #525252;
}

a:hover {
	text-decoration: none;
}

.container {
	border: 1px solid black;
	margin: 0px auto;
	width: 1400px;
	text-align: center;
}
/*********************************************************************************/
/* Social Icon Styles                                                            */
/*********************************************************************************/
ul.contact {
	margin: 0;
	padding: 2em 0em 0em 0em;
	list-style: none;
}

ul.contact li {
	display: inline-block;
	padding: 0em 0.10em;
	font-size: 1em;
}

ul.contact li span {
	display: none;
	margin: 0;
	padding: 0;
}

ul.contact li a {
	color: #FFF;
}

ul.contact li a:before {
	display: inline-block;
	width: 30px;
	height: 30px;
	background: #3f3f3f;
	line-height: 30px;
	text-align: center;
	color: #FFFFFF;
}

ul.contact li a.icon-twitter:before {
	background: #2DAAE4;
}

ul.contact li a.icon-facebook:before {
	background: #39599F;
}

ul.contact li a.icon-dribbble:before {
	background: #C4376B;
}

ul.contact li a.icon-tumblr:before {
	background: #31516A;
}

ul.contact li a.icon-rss:before {
	background: #F2600B;
}

/*********************************************************************************/
/* Header                                                                        */
/*********************************************************************************/
#header {
	background: #333;
	border-top: 1px solid #333;
}

/*********************************************************************************/
/* Logo,serch,login                                                              */
/*********************************************************************************/
#top {
	padding: 65px 0px;
	text-decoration: none;
}

#logo {
	float: left;
}

#logo h1 {
	text-decoration: none;
	line-height: 1px;
}

#join {
	float: left;
	margin-left: 250px;
}

#join a {
	text-decoration: none;
	line-height: 90px;
}

#login {
	float: left;
	margin-left: 10px;
}

#login a {
	text-decoration: none;
	line-height: 90px;
}

#basket {
	float: left;
	margin-left: 10px;
}

#basket a {
	text-decoration: none;
	line-height: 90px;
}

#serch {
	border: 0.5px solid #525252;
	float: left;
	margin-left: 290px;
	background-color: #525252;
	width: 570px;
	height: 46px;
}

#text {
	margin-left: 5px;
	height: 30px;
	font-size: 16px;
	width: 500px;
}

#submit {
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
#menu ul {
	margin: 0;
	padding: 20px 0px 20px 0px;
	list-style: none;
	line-height: normal;
	display: inline-block;
}

#menu li {
	display: inline-block;
	text-align: left;
}

#menu a {
	display: block;
	padding: 1em 2em;
	letter-spacing: 1px;
	text-decoration: none;
	text-transform: uppercase;
	font-size: 1em;
	font-weight: 700;
	color: #FFF;
}

.computer_drop, .sound_drop, .assembled_pc_drop, .laptop_drop,
	.storage_device_drop {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	background: #525252;
}

li a:hover, .computer:hover .computer_drop, .sound:hover .sound_drop,
	.assembled_pc:hover .assembled_pc_drop, .laptop:hover .laptop_drop,
	.storage_device:hover .storage_device_drop {
	background-color: #747474;
}

li .computer, .sound, .assembled_pc, .laptop, .storage_device {
	display: inline-block;
}

.computer_content, .sound_content, .assembled_pc_content,
	.laptop_content, .storage_device_content {
	display: none;
	position: absolute;
	left: auto;
	background-color: #333;
	min-width: 160px;
	z-index: 1;
}

.computer_content a, .sound_content a, .assembled_pc_content a,
	.laptop_content a, .storage_device_content a {
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.computer_content a:hover, .sound_content a:hover, .assembled_pc_content a:hover,
	.laptop_content a:hover, ..storage_device_content a:hover {
	background: #949494;
	text-decoration: none;
}

.computer:hover .computer_content, .sound:hover .sound_content,
	.assembled_pc:hover .assembled_pc_content, .laptop:hover .laptop_content,
	.storage_device:hover .storage_device_content {
	display: inline-block;
}

/*********************************************************************************/
/* Page                                                                          */
/*********************************************************************************/
#page-wrapper {
	padding: 4em 0em 6em 0em;
	background: #FFF;
	border-top: 1px solid #47A665;
}

#page {
	overflow: hidden;
	padding-top: 6em;
	border-top: 1px solid #E5E5E5;
	color: #717171;
}

#page .title {
	margin-bottom: 2em;
}

#page .title h2 {
	font-size: 2em;
	font-weight: 800;
	color: #333;
}
/*********************************************************************************/
/* Footer                                                                        */
/*********************************************************************************/
#footer-wrapper {
	padding: 6em 0em 6em 0em;
	background: #f4f4f4;
	border-bottom: 1px solid #EDEDED;
	border-top: 1px solid #EDEDED;
}

#footer {
	overflow: hidden;
	color: #666666;
}

#footer h2 {
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
#copyright {
	padding: 6em 0em;
	font-size: 0.85em;
	letter-spacing: 0.10em;
	text-align: center;
	color: #6A6A6A;
}

#copyright a {
	color: #747474;
}

/*********************************************************************************/
/* Featured                                                                      */
/*********************************************************************************/
#featured {
	overflow: hidden;
	padding-bottom: 6em;
	color: #717171;
}

#featured img {
	margin-bottom: 2em;
}

#featured .box {
	padding-bottom: 1.5em;
}

#featured .title {
	margin-bottom: 2em;
}

#featured .title h2 {
	font-size: 2em;
	font-weight: 800;
	color: #333;
}

#featured .subtitle {
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
		<div id="logo">
			<h1>
				<a href="#" class="icon icon-spinner">기오피씨</a>
			</h1>
		</div>
		<div id="serch">
			<form>
				<table>
					<tr>
						<td><input type="text" name="searchProduct" id="text"></td>
						<td><input type="submit" value="검색" id="submit"></td>
					</tr>
				</table>
			</form>
		</div>
		<c:if test="${user == null }">
			<div id="join">
				<a href="join" class="join">회원가입</a>
			</div>
			<div id="login">
				<a href="login" class="login">로그인</a>
			</div>
		</c:if>
		<c:if test="${user != null }">
			<div id="modify">
				<a
					href="${pageContext.request.contextPath }/modify?userId=${user.userId}"
					class="modify">회원정보수정</a>
			</div>
			<div id="login">
				<a href="logout" class="logout">로그아웃</a>
			</div>
		</c:if>

		<div id="basket">
			<a href="join" class="basket">장바구니</a>
		</div>
	</div>
	<div id="header">
		<div id="menu" class="container">
			<ul>
				<li class="computer"><a href="#" class="computer_drop">컴퓨터
						주요부품</a>
					<div class="computer_content">
						<a href="#">cpu</a> <a href="#">램</a> <a href="#">메인보드</a> <a
							href="#">그래픽 카드</a> <a href="#">케이스</a> <a href="#">파워</a> <a
							href="#">키보드</a> <a href="#">마우스</a> <a href="#">SSD</a> <a
							href="#">odd</a>
					</div></li>
			</ul>
			<ul>
				<li class="sound"><a href="#" class="sound_drop">사운드</a>
					<div class="sound_content">
						<a href="#">헤드셋</a> <a href="#">스피커</a> <a href="#">마이크</a> <a
							href="#">사운드 카드</a>
					</div></li>
			</ul>
			<ul>
				<li class="assembled_pc"><a href="#" class="assembled_pc_drop">조립PC</a>
					<div class="assembled_pc_content">
						<a href="#">10~40만원대</a> <a href="#">50~60만원대</a> <a href="#">70~100만원대</a>
						<a href="#">90~100만원대</a>
					</div></li>
			</ul>
			<ul>
				<li class="laptop"><a href="#" class="laptop_drop">노트북</a>
					<div class="laptop_content">
						<a href="#">게이밍 노트북</a> <a href="#">초경량 노트북</a> <a href="#">디자인
							노트북</a> <a href="#">비지니스 노트북</a>
					</div></li>
			</ul>
			<ul>
				<li class="storage_device"><a href="#"
					class="storage_device_drop">저장장치</a>
					<div class="storage_device_content">
						<a href="#">외장하드</a> <a href="#">외장SSD</a> <a href="#">NAS</a> <a
							href="#">USB메모리</a>
					</div></li>
			</ul>
		</div>
	</div>
	<div id="page-wrapper">
		<div id="featured" class="container">
			<div class="box">
				<div class="title">
					<h2>Recent Updates</h2>
				</div>
			</div>
			<div class="box">
				<div class="title">
					<h2>Recent Updates</h2>
				</div>
			</div>
			<div class="box">
				<div class="title">
					<h2>Recent Updates</h2>
				</div>
			</div>

		</div>
	</div>


	<div id="copyright">
		<p>
			&copy; Untitled. All rights reserved. | Photos by <a
				href="http://fotogrph.com/">Fotogrph</a> | Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
</body>
</html>
