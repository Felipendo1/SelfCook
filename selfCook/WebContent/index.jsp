<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <!--レスポンシブ対応-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SELFCOOK</title>
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
</head>

<body>

    <div class="container no-header-container">
        <h1 class="entrance logo">SELFCOOK</h1>
        <p class="entrance-message">毎日の食事のメニューを考えることから解放されましょう</p>
        <a id="entrance" class="button" href="/selfCook/RegisterUser?action=welcome">はじめる</a>

        <footer>
            <div>
                <p><small>&copy; 2022 6 セルフクック製作委員会 </small></p>
            </div>
        </footer>
    </div>

</body>

</html>