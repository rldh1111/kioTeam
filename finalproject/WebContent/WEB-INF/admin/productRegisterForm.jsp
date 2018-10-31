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
	    padding: 190px;
	    background: #EFEFEF;
	    font-size: 10pt;
	    width: 350px;
	    margin: auto;
	}
	
	.container{
		margin: 0px auto;
		width: 350px;
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
	.register a{
		float: left;
		text-decoration: none;
		line-height: 80px;
		text-align: center;
		margin-left: 127px;
	}
	
	table {
	border: 3px solid #525252;
	border-collapse: collapse;
	width: 350px;
	}
	table th,td{
		border-bottom : 1px solid black;
		padding: 10px 0px 10px 0px;
		text-align: center;
	}
</style>
</head>
<body>
	<div class="header">
		<div class="logo">
				<h1><a href="main.jsp">기오피씨</a></h1>
		</div>
		<div class="register">
			<h1><a>제품 등록</a></h1>
		</div>
	</div>
	<form action="productRegister" method="post">
		<table border="1">
			<tr>
				<td>name</td>
				<td><input type="text" name="name" required></td>
				<c:if test="${errors.sameProduct }">
					<script>
						alert("중복된 이름입니다");
					</script>
				</c:if>
			</tr>
			<tr>
				<td>type</td>
				<td><select name ="type">
					<option value="notebook">노트북</option>
					<option value="sound">사운드</option>
					<option value="mainparts">컴퓨터주요부품</option>
					<option value="save">저장장치</option>
				</select></td>
			</tr>
			
			<tr>
				<td>productType</td>
				<td><select name ="productType">
					<option value="cpu">cpu</option>
					<option value="ram">ram</option>
					<option value="mainboard">메인보드</option>
					<option value="vga">그래픽 카드</option>
					<option value="case">케이스</option>
					<option value="power">파워</option>
					<option value="keyboard">키보드</option>
					<option value="mouse">마우스</option>
					<option value="hdd">HDD</option>
					<option value="ssd">SSD</option>
					<option value="odd">ODD</option>
					<option value="headset">해드셋</option>
					<option value="speaker">스피커</option>
					<option value="mic">마이크</option>
					<option value="glap">게이밍 노트북</option>
					<option value="slap">초경량 노트북</option>
					<option value="dlap">디자인 노트북</option>
					<option value="blap">비지니스 노트북</option>
					<option value="ehd">외장하드</option>
					<option value="essd">외장SSD</option>
					<option value="nas">NAS</option>
					<option value="usb">usb메모리</option>
				
				</select></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price" required></td>
			</tr>
			<tr>
				<td>explanation</td>
				<td><input type="text" name="explanation" required></td>
			</tr>
			<tr>
				<td>url</td>
				<td><input type="file" name="url" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>