package servlet;

//
//ログイン後の画面遷移用コントローラ。
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
import model.KeyIn;
import model.Recipe;
import model.ResearchRecipeLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action != null && action.equals("logOut")) {// ログアウトボタンを押す
			if (session != null) {
				System.out.println("invalidating session");
				session.invalidate();
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}

		} else if (action != null && action.equals("shuffle")) {
			List<Integer> recipeList = (List<Integer>) session.getAttribute("recipeList");
			if (recipeList == null) {
				System.out.println("シャッフル出来ません。レシピを検索してください。");
				String errorMsg = "シャッフル出来ません。レシピを検索してください。";
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", errorMsg);
				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
				dispatcher.forward(request, response);
			} else {
				Account account = (Account) session.getAttribute("accountId");
				System.out.println(account.getId());
				System.out.println(account.getName());
				ResearchRecipeLogic reserchRecipeLogic = new ResearchRecipeLogic();
				Integer randomId = reserchRecipeLogic.randomId(recipeList);
				session.setAttribute("randomId", randomId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
			}
		} else {

			Integer ranInt = (Integer) session.getAttribute("randomId");
			// session.setAttribute("randomId", randomId);
			System.out.println("randomId now " + ranInt);
			Integer randomId = Integer.parseInt(request.getParameter("recipe"));
			System.out.println("after Id" + randomId);
			session.setAttribute("randomId", randomId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String food1 = request.getParameter("food1");
		String food2 = request.getParameter("food2");
		String food3 = request.getParameter("food3");
		System.out.println(food1 + food2 + food3);
		KeyIn keyIn = new KeyIn();
		// keyIn.setFood1(food1);
		// keyIn.setFood2(food2);
		// keyIn.setFood3(food3);

		if (food3.length() != 0) {// 食材を3つ入れて検索

			keyIn.setFood1(food1);
			keyIn.setFood2(food2);
			keyIn.setFood3(food3);
			System.out.println(keyIn);

			AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
			Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();

			ResearchRecipeLogic reserchRecipeLogic = new ResearchRecipeLogic();
			// 全レシピリストと入力食材を照合して検索レシピ(recipeList)を作る
			List<Integer> recipeList = reserchRecipeLogic.researchRecipe(allRecipe, keyIn);
			if (recipeList.size() != 0) {
				// 検索レシピ(recipeList)を使ってランダムID(randomId)を作る
				Integer randomId = reserchRecipeLogic.randomId(recipeList);

				// ランダムIDと検索レシピをセッションスコープに入れる
				System.out.println(recipeList);
				System.out.println(randomId);
				System.out.println(keyIn.getFood3() + keyIn.getFood2() + keyIn.getFood1());
				session.setAttribute("keyIn", keyIn);
				session.setAttribute("randomId", randomId);
				session.setAttribute("recipeList", recipeList);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);

			} else {
				System.out.println("検索結果が見つかりませんでした。もう一度検索してください。");
				String errorMsg = "検索結果が見つかりませんでした。もう一度検索してください。";
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", errorMsg);
				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
				dispatcher.forward(request, response);
			}

		} else if (food2.length() != 0) {// 食材を2つ入れて検索

			keyIn.setFood1(food1);
			keyIn.setFood2(food2);
			System.out.println(keyIn);

			AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
			Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();

			ResearchRecipeLogic reserchRecipeLogic = new ResearchRecipeLogic();
			// 全レシピリストと入力食材を照合して検索レシピ(recipeList)を作る
			List<Integer> recipeList = reserchRecipeLogic.researchRecipe(allRecipe, keyIn);
			if (recipeList.size() != 0) {
				// 検索レシピ(recipeList)を使ってランダムID(randomId)を作る
				Integer randomId = reserchRecipeLogic.randomId(recipeList);

				// ランダムIDと検索レシピをセッションスコープに入れる
				System.out.println(recipeList);
				System.out.println(randomId);
				System.out.println(keyIn.getFood1() + keyIn.getFood2());
				session.setAttribute("keyIn", keyIn);
				session.setAttribute("randomId", randomId);
				session.setAttribute("recipeList", recipeList);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);

			} else {
				System.out.println("検索結果が見つかりませんでした。もう一度検索してください。");
				String errorMsg = "検索結果が見つかりませんでした。もう一度検索してください。";
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", errorMsg);
				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
				dispatcher.forward(request, response);
			}

		} else if (food1.length() != 0) {// 食材を一つ入れて検索
			keyIn.setFood1(food1);
			System.out.println("KEYIN");
			System.out.println(keyIn);
			System.out.println(keyIn.getFood1());

			AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
			Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();

			ResearchRecipeLogic researchLogic = new ResearchRecipeLogic();
			System.out.println("ReserchRecipeLogicインスタンス");
			// 全レシピリストと入力食材を照合して検索レシピ(recipeList)を作る
			List<Integer> recipeList = researchLogic.researchRecipe(allRecipe, keyIn);
			System.out.println(recipeList.size());
			if (recipeList.size() != 0) {
				System.out.println(recipeList);
				Integer randomId = researchLogic.randomId(recipeList);
				System.out.println(randomId);
				System.out.println("レシピロジック");
				System.out.println(recipeList);
				// 検索レシピ(recipeListx)を使ってランダムID(randomId)を作る
				System.out.println("ランダムIDロジック");
				System.out.println(randomId);

				// ランダムIDと検索レシピをセッションスコープに入れる
				System.out.println(recipeList);
				System.out.println(randomId);

				session.setAttribute("keyIn", keyIn);
				session.setAttribute("randomId", randomId);
				session.setAttribute("recipeList", recipeList);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("検索結果が見つかりませんでした。もう一度検索してください。");
				String errorMsg = "検索結果が見つかりませんでした。もう一度検索してください。";
				// エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", errorMsg);
				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
				dispatcher.forward(request, response);
			}
		}

	}
}
