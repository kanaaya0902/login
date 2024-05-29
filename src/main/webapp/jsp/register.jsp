<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/register" method="post">
    <p>ID<input type="text" name="login"></p>
    <p>パスワード<input type="password" name="password"></p>
    <p><input type="submit" value="登録"></p>
</form>

</body>
</html>
