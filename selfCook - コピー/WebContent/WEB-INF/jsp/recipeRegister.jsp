<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <!--レスポンシブ対応-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>レシピ新規登録 - SELFCOOK</title>
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
    <div class="container">
        <!--ヘッダー-->
		<header>
			<div class="header-wrapper">

				<div class="header-inner">
					<p class="header-logo logo">SELFCOOK</p>
					<p>
						<a href="/selfCook/Main?action=logOut"><i class="fa-solid fa-right-from-bracket"></i>
							ログアウト</a>
					</p>
				</div>

				<nav>
					<ul class="main-nav">
						<li><a href="/selfCook/Edit?action=search">ランダム検索</a></li>

						<li><a href="/selfCook/Edit?action=all">全レシピ一覧</a></li>
						<li><a href="/selfCook/Edit?acton=main">検索結果</a></li>
					</ul>
				</nav>

			</div>
		</header>

        <p class="register-inner">レシピ新規登録</p>

        <form action="/selfCook/Edit?action=register" method="post">
            <ul class="recipe-input">
                <li><span>レシピ名</span></li>
                <li><input type="text" name="recipename"></li>
            </ul>
            <ul class="recipe-input">
                <li><span>食材１</span></li>
                <li><input type="text" name="food1"></li>
            </ul>
            <ul class="recipe-input">
                <li><span>食材２</span></li>
                <li><input type="text" name="food2"></li>
            </ul>
            <ul class="recipe-input">
                <li><span>食材３</span></li>
                <li><input type="text" name="food3"></li>
            </ul>
            <ul class="recipe-input">
                <li><span>つくりかた</span></li>
                <li><textarea name="message"></textarea></li>
            </ul>
            <div id="register-submit">
                <input type="submit" class="button" value="登録">
            </div>
        </form>
        <a class="recipe-register-link" href="/selfCook/Edit?action=all">レシピ編集へ</a>

        <footer>
            <div>
                <p><small>&copy; 2022 6 セルフクック製作委員会 </small></p>
            </div>
        </footer>
    </div>
</body>

</html>