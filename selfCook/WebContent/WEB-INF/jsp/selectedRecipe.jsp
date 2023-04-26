<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Recipe"%>
<%@ page import="model.KeyIn"%>
<%@ page import="java.util.*"%>
<%
// セッションスコープに保存されたrandomIdを取得
Integer randomId = (Integer) session.getAttribute("randomId");
// セッションスコープに保存されたrecipeListを取得
List<Integer> recipeList = (List<Integer>) session.getAttribute("recipeList");
// セッションスコープに保存されたallRecipeを取得
Map<Integer, Recipe> allRecipe = (Map<Integer, Recipe>) session.getAttribute("allRecipe");
// セッションスコープに保存されたkayinを取得
KeyIn keyin=(KeyIn) session.getAttribute("keyIn");
%>

<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<!--レスポンシブ対応-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>別レシピ一覧 - SELFCOOK</title>
<!--CSSの読み込み-->
<!--ノーマライズ-->
<link rel="stylesheet" href="css/normalize.css">
<!--googleフォント-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Kosugi&display=swap">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaisei+Opti&display=swap"
	rel="stylesheet">
<!--デザインCSS-->
<link href="css/style.css" rel="stylesheet">
<!-- アイコンFontAwesome -->
<link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css"
	rel="stylesheet">

</head>

<body>
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

		<div class="random-wrapper selected">

			<!--↓食材名うまく表示するか？要チェック -->
			<p class="selectedrecipe"><i class="fa-solid fa-list list-mark"></i>
			<%=keyin.getFood1()%>
			<!-- food2がnullでなかったら -->
			<%if(keyin.getFood2()!=null){%>
			×<%=keyin.getFood2()%>
			<%}%>
			<!-- food3がnullでなかったら -->
			<%if(keyin.getFood3()!=null){%>
			×<%=keyin.getFood3()%>
			<%}%>
			のレシピ一覧</p>

			<% for(Integer recipelist : recipeList){
			%>

			<p><i class="fa-sharp fa-solid fa-check"></i> <a href="/selfCook/Main?recipe=<%=allRecipe.get(recipelist).getRecipeId()%>"><%=allRecipe.get(recipelist).getRecipeName()%></a></p>
			<%
			}
			%>
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