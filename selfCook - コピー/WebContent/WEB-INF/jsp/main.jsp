<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Account"%>
<%@ page import="model.Recipe"%>
<%@ page import="java.util.*"%>
<%
Account account = (Account) session.getAttribute("accountId");
%>
<%
// セッションスコープに保存されたエラーメッセージを取得
Integer randomId = (Integer) session.getAttribute("randomId");
// セッションスコープに保存されたallRecipeを取得
Map<Integer, Recipe> allRecipe = (Map<Integer, Recipe>) session.getAttribute("allRecipe");
%>

<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<!--レスポンシブ対応-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>検索結果 - SELFCOOK</title>
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

<body id="main-select">
	<div class="second-container">
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
						<li><a href="/selfCook/Edit?action=main">検索結果</a></li>
					</ul>
				</nav>

			</div>
		</header>

		<div class="random-wrapper">
			<div class="recipe-box">
				<p class="recipe-title">今日のレシピ</p>
				<p class="random-menu"><%=allRecipe.get(randomId).getRecipeName()%></p>
			</div>

			<div class="push-button-box">
				<a class="push-button" href="/selfCook/Main?action=shuffle"><i class="fa-solid fa-shuffle"></i>　ランダム</a>
				<a class="push-button" href="/selfCook/Edit?action=selected"><i class="fa-solid fa-list"></i>　別レシピ一覧</a>
			</div>

			<p class="random-list">
			<i class="fa-solid fa-utensils fa-lg food-mark"></i> 食材</p>
			<p class="random-food">
			<%=allRecipe.get(randomId).getFood1()%>
			<!-- food2がnullでなかったら -->
			<%if(allRecipe.get(randomId).getFood2()!=null){%>
			<%=allRecipe.get(randomId).getFood2()%>
			<%}%>
			<!-- food3がnullでなかったら -->
			<%if(allRecipe.get(randomId).getFood3()!=null){%>
			<%=allRecipe.get(randomId).getFood3()%>
			<%}%>
			<!-- food4がnullでなかったら -->
			<%if(allRecipe.get(randomId).getFood4()!=null){%>
			<%=allRecipe.get(randomId).getFood4()%>
			<%}%>
			<!-- food5がnullでなかったら -->
			<%if(allRecipe.get(randomId).getFood5()!=null){%>
			<%=allRecipe.get(randomId).getFood5()%>
			<%}%>
			</p>

			<p class="random-list">
			<i class="fa-solid fa-utensils fa-lg food-mark"></i> つくりかた</p>
			<p class="random-recipe"><%=allRecipe.get(randomId).getRecipeContent()%></p>
		</div>

		<footer>
			<div>
				<p>
					<small>&copy; 2022 6 セルフクック製作委員会 </small>
				</p>
			</div>
		</footer>
	</div>
</body>

</html>