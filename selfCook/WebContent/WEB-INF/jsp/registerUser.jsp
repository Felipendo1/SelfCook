<%-- 新規登録画面 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セルフクック</title>
</head>
<body>
<h1>セルフクックへようこそ(アカウント登録画面)</h1>
<form action="/selfCook/RegisterUser?action=register" method="post" >
ユーザーID（メール）：<input type="text" name="Id"><br>
パスワード：<input type="password" name="pass"><br>
ユーザー名：<input type="text" name="name"><br>
<input type="submit" value="新規登録">
</form>
</body>
</html>