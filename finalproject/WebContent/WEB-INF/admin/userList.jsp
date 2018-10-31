<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
	body{
	    padding: 50px;
	    background: #EFEFEF;
	    font-size: 10pt;
	    width: 1300px;
	    margin: auto;
	}
	a{color: black;}
	
	.container{
		margin: 0px auto;
		width: 1300px;
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
	.userlist a{
		float: left;
		text-decoration: none;
		line-height: 80px;
		text-align: center;
		margin-left: 455px;
	}
	
	table {
	border: 3px solid #525252;
	border-collapse: collapse;
	width: 1300px;
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
<script>
function userDelete(userId){
	var r = confirm("회원을 삭제하시겠습니까?");
	if(r == true){
		alert("회원삭제에 성공하였습니다");
		location.replace("userDelete?userId="+userId+"&pageNum=${userPage.currentPage}");
	}
}

</script>
	<div class="header">
		<div class="logo">
					<h1><a href="${pageContext.request.contextPath }/main.jsp">기오피씨</a></h1>
		</div>
		<div class="userlist">
				<h1><a>유저 정보 관리</a></h1>
		</div>
	</div>
	<div id="user" class="container">
	<table>
		<tr>
			<th>userId</th>
			<th>userType</th>
			<th>name</th>
			<th>loginId</th>
			<th>password</th>
			<th>address</th>
			<th>email</th>
			<th>phone</th>
			<th>question</th>
			<th>answer</th>
			<th>wdate</th>
			<th>delete</th>
		</tr>
		<c:forEach var="user" items="${userPage.users}">
			<tr>
				<td>${user.userId }</td>
				<td>${user.userType }</td>
				<td>${user.name }</td>
				<td>${user.loginId }</td>
				<td>${user.password }</td>
				<td>${user.address }</td>
				<td>${user.email }</td>
				<td>${user.phone }</td>
				<td>${user.question }</td>
				<td>${user.answer }</td>
				<td>${user.wdate }</td>
				<td><button onclick="userDelete(${user.userId})">삭제</button></td>
			</tr>
		</c:forEach>
		<c:if test="${userPage.hasUsers() }">
			<tr style="text-align: center">
				<td colspan="12">
					<a href="userList?pageNum=${userPage.totalPages}" class="pageNum">치음</a>
					<c:if test="${userPage.startPage > 5 }">
					<a href="userList?pageNum=${userPage.startPage - 5  }" class="pageNum">이전</a>
					</c:if>
					<c:forEach var="pageNum" begin="${userPage.startPage}" end="${userPage.endPage }">
						<a href="userList?pageNum=${pageNum}" class="pageNum">${pageNum}</a>
					</c:forEach>
					<c:if test="${userPage.endPage < userPage.totalPages }">
						<a href="userList?pageNum=${userPage.startPage + 5 }" class="pageNum">다음</a>
					</c:if>
					<a href="userList?pageNum=${userPage.totalPages}" class="pageNum">마지막</a>
				</td>
			</tr>
		</c:if>
		<c:if test="${userPage.hasUsers() == null }">
			등록된 상품이 없습니다
		</c:if>
	</table>
	</div>
</body>
</html>