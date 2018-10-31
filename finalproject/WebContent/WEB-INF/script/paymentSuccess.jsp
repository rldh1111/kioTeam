<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>

	var r = confirm("결제내역을 확인하시겠습니까?");
	if(r == true){
		location.href = "paymentList?userId=${user.userId}";
	}else{
		location.replace(history.go(-1));
	}
	
</script>
</body>
</html>