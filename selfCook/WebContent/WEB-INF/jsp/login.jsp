<%-- ログイン画面 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <!--レスポンシブ対応-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - SELFCOOK</title>
    <!--CSSの読み込み-->
    <!--ノーマライズ-->
    <link rel="stylesheet" href="css/normalize.css">
    <!--googleフォント-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Kosugi&display=swap">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaisei+Opti&display=swap" rel="stylesheet">
    <!--デザインCSS-->
    <link href="css/style.css" rel="stylesheet">
    <!-- アイコンFontAwesome -->
<link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css"
	rel="stylesheet">
</head>

<body>
    <div class="container no-footer-container">
        <h1 class="logo">SELFCOOK</h1>
        <%
		if (errorMsg != null) {
		%>
		<p class="errormsg"><i class="fa-solid fa-triangle-exclamation fa-lg"></i> <%=errorMsg%></p>
		<%
		}
		%>
        <form action="/selfCook/RegisterUser?action=login" method="post">
            <ul>
                <li>メールアドレス（ユーザー名）</li>
                <li><input type="email" name="accountId" placeholder="example@selfcook.com" required></li>
            </ul>
            <ul>
                <li>パスワード</li>
                <li><input type="password" name="pass" pattern="^[0-9a-zA-Z]{4,10}$" placeholder="半角英数4～10文字で入力" required></li>
            </ul>
            <input type="submit" class="button" value="ログイン">
        </form>
        <a class="login-register-link" href="/selfCook/RegisterUser?action=register">新規登録の方はこちら</a>

        <footer>
            <div>
                <p><small>&copy; 2022 6 セルフクック製作委員会 </small></p>
            </div>
        </footer>
    </div>
</body>

</html>