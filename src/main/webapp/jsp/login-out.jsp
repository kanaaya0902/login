<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ようこそ、${customer.login }さん!

<p><a href="${pageContext.request.contextPath}/jsp/dummy.jsp">次のページへ進む</a></p>
</body>
</html>