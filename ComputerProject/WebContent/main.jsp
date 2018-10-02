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
	color: #333;
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

strong {
	color: #525252;
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
	width: 1200px;
}

/*********************************************************************************/
/* Image Style                                                                   */
/*********************************************************************************/
.image {
	display: inline-block;
}

.image img {
	display: block;
	width: 100%;
}

.image-full {
	display: block;
	width: 100%;
	margin: 0 0 2em 0;
}

.image-left {
	float: left;
	margin: 0 2em 2em 0;
}

.image-centered {
	display: block;
	margin: 0 0 2em 0;
}

.image-centered img {
	margin: 0 auto;
	width: auto;
}

/*********************************************************************************/
/* List Styles                                                                   */
/*********************************************************************************/
ul.style1 {
	
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
/* Button Style                                                                  */
/*********************************************************************************/
.button {
	display: inline-block;
	padding: 1em 3em 1em 0em;
	letter-spacing: 0.10em;
	text-decoration: none;
	text-transform: uppercase;
	font-weight: 800;
	font-size: 0.90em;
	color: #333;
}

.button:before {
	display: inline-block;
	background: #8aa2fc;
	margin-right: 1em;
	padding: 8px;
	text-align: center;
	color: #FFF;
}

/*********************************************************************************/
/* Header                                                                        */
/*********************************************************************************/
#header {
	background: #56BD78;
	border-top: 1px solid #47A665;
}

/*********************************************************************************/
/* Logo,serch,login                                                              */
/*********************************************************************************/
#top {
	padding: 4em 0em;
	text-transform: uppercase;
	text-decoration: none;
}

#logo h1 {
	text-align: left;
	font-weight: 900;
	font-size: 2.5em;
	text-decoration: none;
}

#logo h1 a {
	text-decoration: none;
}

#logo span {
	text-decoration: none;
	float: left;
}

#logo h1:before {
	text-decoration: none;
}

#logo a {
	color: #51AD6F;
	text-decoration: none;
}

#login a {
	float: right;
	text-decoration: none;
}

#logo:before {
	text-decoration: none;
}

#logo {
	float: left;
	width: 33%;
}

#login {
	float: left;
	width: 33%;
}

#serch {
	width: 430px;
	height: 46px;
}

#serch {
	border: 0.5px solid lightgreen;
	float: left;
	width: 33%;
	background-color: lightgreen;
}

#text {
	margin-left: 5px;
	height: 30px;
	font-size: 16px;
	width: 330px;
}

#submit {
	border: 0px;
	width: 50px;
	height: 40px;
	background-color: lightgreen;
	outline: none;
}

#join {
	float: left;
	width: 33%;
}

#join a {
	float: right;
	text-decoration: none;
}

#basket {
	float: left;
	width: 33%;
}

#basket a {
	float: right;
	text-decoration: none;
}

/*********************************************************************************/
/* Menu                                                                          */
/*********************************************************************************/
#menu ul {
	margin: 0;
	padding: 20px 0px 20px 0px;
	list-style: none;
	line-height: normal;
}

#menu li {
	display: inline-block;
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

#menu .current_page_item a {
	background: #7BDB99;
	color: #FFF;
}

#menu a:hover {
	background: #7BDB99;
	text-decoration: none;
	color: #FFF;
}

/*********************************************************************************/
/* Banner                                                                        */
/*********************************************************************************/
#banner {
	margin-bottom: 3em;
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
/* Content                                                                       */
/*********************************************************************************/
#content {
	float: left;
	width: 588px;
}

/*********************************************************************************/
/* Sidebar                                                                       */
/*********************************************************************************/
#sidebar {
	float: right;
	width: 588px;
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
				<a href="#" class="icon icon-spinner"><span>기오피씨</span></a>
			</h1>
		</div>
		<div id="serch">
			<form>
				<table>
					<tr>
						<td><input type="text" name="serchName" id="text"></td>
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
				<a href="${pageContext.request.contextPath }/modify" class="modify">회원정보수정</a>
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
				<li class="current_page_item"><a href="#" accesskey="1"
					title="">CPU</a></li>
				<li><a href="#" accesskey="1" title="">Mainboard</a></li>
				<li><a href="#" accesskey="2" title="">RAM</a></li>
				<li><a href="#" accesskey="3" title="">VGA</a></li>
				<li><a href="#" accesskey="4" title="">SSD</a></li>
				<li><a href="#" accesskey="5" title="">ODD</a></li>
				<li><a href="#" accesskey="6" title="">case</a></li>
				<li><a href="#" accesskey="7" title="">power</a></li>
				<li><a href="#" accesskey="8" title="">keyboard</a></li>
				<li><a href="#" accesskey="9" title="">mouse</a></li>
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
