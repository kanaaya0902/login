<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>ID<input type="text" name="login"></p>
    <p>パスワード<input type="password" name="password"></p>
    <p><input type="submit" value="ログイン"></p>
</form>

<p><a href="${pageContext.request.contextPath}/jsp/register.jsp">会員登録がお済でない方はこちら</a></p>

</body>
</html>
