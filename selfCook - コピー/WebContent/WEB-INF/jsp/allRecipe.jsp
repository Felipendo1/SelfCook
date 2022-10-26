<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Recipe"%>
<%@ page import="java.util.*"%>
<%
// セッションスコープに保存されたallRecipeを取得
Map<Integer, Recipe> allRecipe = (Map<Integer, Recipe>) session.getAttribute("allRecipe");
%>

<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<!--レスポンシブ対応-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>全レシピ一覧 - SELFCOOK</title>
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

<body id="allRecipe-select">
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
						<li><a href="/selfCook/Edit?acton=main">検索結果</a></li>
					</ul>
				</nav>

			</div>
		</header>

		<div class="random-wrapper">
			<a class="push-button all" href="/selfCook/Edit?action=register"><i class="fa-solid fa-pen-to-square"></i> 新規登録</a>

			<% for(Integer key : allRecipe.keySet()){
        	Recipe allrecipe = allRecipe.get(key);
        	%>
			<form action="/selfCook/Edit?action=edit" method="post">
				<div class="form-wrapper">
					<a class="recipe-name" href="/selfCook/Main?recipe=<%=allrecipe.getRecipeId()%>"><%=allrecipe.getRecipeName()%></a>
					<input type=hidden name=RecipeId value="<%=allrecipe.getRecipeId()%>">
					<!-- <input type=text name=RecipeId value="<%=allrecipe.getRecipeId()%>"> -->
						<div class="edit-delete-button">
							<input type="submit" class="edit-button" value="編集" name="editDel">
							<input type="submit" class="edit-button" value="削除" name="editDel">
						</div>
				</div>
			</form>
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