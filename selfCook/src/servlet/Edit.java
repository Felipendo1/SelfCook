package servlet;

//
//レシピの新規登録、更新、削除に関するコントローラ。
//

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.AllRecipeLogic;
import model.Recipe;
import model.RecipeEditLogic;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action != null && action.equals("register")) {
			// allRecipeから新規登録画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeRegister.jsp");
			dispatcher.forward(request, response);

		} else if (action != null && action.equals("edit")) {
			// 全レシピ検索or別レシピ一覧からレシピEdit画面へ
			// リクエストスコープにレシピIDを保存してrecipeEdit画面へ

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeEdit.jsp");
			dispatcher.forward(request, response);

		} else if (action != null && action.equals("search")) {
			// NavigationBarから食材検索画面へ

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
			dispatcher.forward(request, response);

		} else if (action != null && action.equals("selected")) {
			// メイン画面から別レシピ一覧へ

			List<Integer> recipeList = (List<Integer>) session.getAttribute("recipeList");
			if (recipeList == null) {
				System.out.println("レシピを検索してください。");
				String errorMsg = "レシピを検索してください。";
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", errorMsg);
				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/selectedRecipe.jsp");
				dispatcher.forward(request, response);
			}

		} else if (action != null && action.equals("all")) {
			// NavigationBarから全レシピ検索画面へ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/allRecipe.jsp");
			dispatcher.forward(request, response);

		} else {
			List<Integer> recipeList = (List<Integer>) session.getAttribute("recipeList");
			if (recipeList == null) {
				System.out.println("検索結果が見つかりませんでした。もう一度検索してください。");
				String errorMsg = "検索結果が見つかりませんでした。もう一度検索してください。";
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", errorMsg);
				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String recipeName = request.getParameter("recipename");
		String food1 = request.getParameter("food1");
		String food2 = request.getParameter("food2");
		String food3 = request.getParameter("food3");
		String recipeContent = request.getParameter("message");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("accountId");

		if (action != null && action.equals("register")) {
			Recipe recipe = new Recipe();
			recipe.setRecipeName(recipeName);
			recipe.setFood1(food1);
			recipe.setFood2(food2);
			recipe.setFood3(food3);
			recipe.setFood4(request.getParameter("food4"));
			recipe.setFood5(request.getParameter("food5"));
			recipe.setRecipeContent(recipeContent);
			recipe.setAccountId(account.getId());
			RecipeEditLogic recipeEditLogic = new RecipeEditLogic();
			boolean registerRecipe = recipeEditLogic.regist(recipe);
			// ここでRegisterLogicメソッドを使ってDBに書き込む
			if (registerRecipe) {
				// もう一回全レシピを取得しセッションスコープに入れる
				AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
				Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();
				if (allRecipe != null) {
					// 新しい全レシピリストを使い検索画面リストを更新しセッションスコープに入れる
					session.setAttribute("allRecipe", allRecipe);
					RequestDispatcher dispatcher = request
							// レシピ新規登録確認画面に飛ばす
							.getRequestDispatcher("/WEB-INF/jsp/recipeRegisterConfirm.jsp");
					dispatcher.forward(request, response);
				} else {
					System.out.println("登録失敗です");
					String errorMsg = "登録済みのレシピです";
					// エラーメッセージをリクエストスコープに保存
					request.setAttribute("errorMsg", errorMsg);
					// フォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeRegister.jsp");
					dispatcher.forward(request, response);

					// } else if (action != null && action.equals("selected")) {
					// // ここでRegisterLogicメソッドを使ってDBに書き込む
					// // セッションスコープに入れた全レシピをRemove
					// // もう一回全レシピを取得しセッションスコープに入れる
					// // レシピ一覧画面に飛ばす
					//
					// RequestDispatcher dispatcher =
					// request.getRequestDispatcher("/WEB-INF/jsp/selectedRecipe.jsp");
					// dispatcher.forward(request, response);

				}
			}
		} else if (action != null && action.equals("edit")) {
			String edit = request.getParameter("editDel");
			if (edit == null) {
				System.out.println("編集開始");
				Recipe recipe = new Recipe();
				recipe.setRecipeName(recipeName);
				recipe.setFood1(food1);
				recipe.setFood2(food2);
				recipe.setFood3(food3);
				recipe.setRecipeContent(recipeContent);
				recipe.setAccountId(account.getId());
				String hiddenId = request.getParameter("hiddenId");
				System.out.println(hiddenId);
				Integer recipeId = Integer.parseInt(hiddenId);
				System.out.println("RecipeId" + recipeId);
				recipe.setRecipeId(recipeId);

				System.out.println(
						"編集" + recipe.getRecipeName() + recipe.getFood1() + account.getId() + recipe.getRecipeId());
				RecipeEditLogic recipeEditLogic = new RecipeEditLogic();
				boolean editLogic = recipeEditLogic.edit(recipe);
				if (editLogic) {
					AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
					Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();
					if (allRecipe != null) {
						session.setAttribute("allRecipe", allRecipe);
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/WEB-INF/jsp/recipeUpdateConfirm.jsp");
						dispatcher.forward(request, response);
					} else {
						System.out.println("編集失敗です");
						String errorMsg = "編集失敗しました";
						// エラーメッセージをリクエストスコープに保存
						request.setAttribute("errorMsg", errorMsg);
						// フォワード
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/WEB-INF/jsp/recipeEdit.jsp");
						dispatcher.forward(request, response);

					}

					// ここでrecipeEdit.jspからきたレシピ名、食材１・・・、レシピを使ってUPDATEする
					// セッションスコープに入れた全レシピと検索レシピリストをRemove
					// もう一回全レシピを取得しセッションスコープに入れる
					// 新しい全レシピリストを使い検索画面リストを更新しセッションスコープに入れる
					// レシピ変更確認画面に飛ばす
				}

			} else if (edit.length() != 0 && edit.equals("編集")) {
				String recipeId = request.getParameter("RecipeId");
				System.out.println(recipeId);
				String hiddenId = request.getParameter("RecipeId");
				request.setAttribute("hiddenId", hiddenId);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeEdit.jsp");
				dispatcher.forward(request, response);

			} else if (edit.length() != 0 && edit.equals("削除")) {
				Integer hiddenId = Integer.parseInt(request.getParameter("RecipeId"));
				System.out.println(hiddenId);
				RecipeEditLogic recipeEditLogic = new RecipeEditLogic();
				boolean editLogic = recipeEditLogic.delete(hiddenId);
				if (editLogic) {
					AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
					Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();
					if (allRecipe != null) {
						session.setAttribute("allRecipe", allRecipe);
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/WEB-INF/jsp/recipeDeleteConfirm.jsp");
						dispatcher.forward(request, response);
					} else {
						System.out.println("削除失敗です");
						String errorMsg = "削除失敗しました";
						// エラーメッセージをリクエストスコープに保存
						request.setAttribute("errorMsg", errorMsg);
						// フォワード
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeEdit.jsp");
						dispatcher.forward(request, response);

					}
				}
			}
		}
	}
}
