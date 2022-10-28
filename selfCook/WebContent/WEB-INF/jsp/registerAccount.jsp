<%-- 新規登録画面 --%>
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
    <title>アカウント登録 - SELFCOOK</title>
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
    <link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css" rel="stylesheet">

</head>

<body>
    <div class="container no-header-container">
        <h1 class="logo">SELFCOOK</h1>
        <%
		if (errorMsg != null) {
		%>
		<p class="errormsg"><i class="fa-solid fa-triangle-exclamation fa-lg"></i> <%=errorMsg%></p>
		<%
		}
		%>
        <form action="/selfCook/RegisterUser?action=register" method="post">
            <ul>
                <li>メールアドレス（ユーザー名）</li>
                <li><input type="email" name="email" placeholder="example@selfcook.com" maxlength="40" required></li>
            </ul>
            <ul>
                <li>ニックネーム</li>
                <li><input type="text" name="name" placeholder="ニックネーム" maxlength="100" required></li>
            </ul>
            <ul>
                <li>パスワード</li>
                <li><input type="password" name="pass" pattern="^[0-9a-zA-Z]{4,10}$" placeholder="半角英数4～10文字で入力" required></li>
            </ul>
            <input type="submit" class="button" value="アカウントを作成">
        </form>
		<a class="login-register-link" href="/selfCook/RegisterUser?action=welcome">ログイン画面へ戻る</a>

        <footer>
            <div>
                <p><small>&copy; 2022 6 セルフクック製作委員会 </small></p>
            </div>
        </footer>
    </div>
</body>

</html>