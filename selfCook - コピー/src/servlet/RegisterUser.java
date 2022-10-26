package servlet;

import java.io.IOException;
import java.util.Map;

//
//アカウントの新規登録、ログイン用のコントローラ。
//

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.AllRecipeLogic;
import model.LoginLogic;
import model.Recipe;
import model.RegisterAccountLogic;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletRequest request;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        // index page -> login bottom
        // index.jsp のログインボタン
        //
        if (action != null && action.equals("welcome")) {
            HttpSession session = request.getSession();
            // ↓セッションスコープをチェック、もしrecipeListが入っていればメイン画面へ
            // 既にログイン、検索をしているユーザーがログアウトせずにINDEXから入る時
            if (session.getAttribute("recipeList") != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
                dispatcher.forward(request, response);
                // ↓もしセッションスコープにallRecipeが入っていればメイン画面へ、入ってなければログインへ↓
            } else if (session.getAttribute("allRecipe") != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher.forward(request, response);
            }

            // ↓もしセッションスコープにrecipeListが入っていればメイン画面へフォワード入ってなければ食材検索画面へ↓
            // } else if (sessionscope recipeList check) {
            // RequestDispatcher dispatcher =
            // request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            // dispatcher.forward(request, response);
            // } else {
            // RequestDispatcher dispatcher =
            // request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
            // dispatcher.forward(request, response);
        }

        // login.jsp page -> new Account bottom
        // ログイン画面の新規登録ボタンをクリック→新規登録画面へフォワード
        else if (action != null && action.equals("register")) {

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/WEB-INF/jsp/registerAccount.jsp");
            dispatcher.forward(request, response);

            // else, redirect to index
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        //
        // login page -> login bottom
        // ログインページのログインボタン
        if (action != null && action.equals("login")) {

            String id = request.getParameter("accountId");
            String pass = request.getParameter("pass");

            // Account login = new Account(id, pass);
            // ↓Account class & LoginLogic class↓

            Account login = new Account(id, pass);
            LoginLogic bo = new LoginLogic();
            Account result = bo.execute(login);
            System.out.println("RegisterUser" + result);

            if (result != null) {// ログイン成功の場合
                System.out.println("ログイン成功です");
                System.out.println(result.getName());
                Account accountId = new Account();
                accountId.setId(result.getId());
                accountId.setName(result.getName());
                HttpSession session = request.getSession();
                session.setAttribute("accountId", accountId);
                System.out.println("セッションスコープにアカウントIDが入りました！");
                System.out.println(accountId.getId());
                System.out.println(accountId.getPass());
                System.out.println(accountId.getName());

                AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
                Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();
                if (allRecipe != null) {
                    session.setAttribute("allRecipe", allRecipe);
                    for (Integer key : allRecipe.keySet()) {
                        System.out.println(key);
                        System.out.println(allRecipe.get(key));
                    }
                    System.out.println("セッションスコープにAllRecipeが入りました");
                } else {
                    System.out.println("全レシピ,セッションスコープに保存失敗です");
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
                dispatcher.forward(request, response);

            } else {// ログイン失敗の場合
                System.out.println("ログイン失敗です");
                String errorMsg = "ユーザーID又はパスワードが間違っています";
                request.setAttribute("errorMsg", errorMsg);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher.forward(request, response);

            }
            // ↓if LoginLogic execute return FALSE set errorMSG to request scope and forward
            // to login↓

            // RegisterUser page -> register bottom
        } else if (action != null && action.equals("register")) {

            String id = request.getParameter("email");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");

            Account registerAccount = new Account(id, pass, name);

            RegisterAccountLogic logic = new RegisterAccountLogic();
            boolean registration = logic.execute(registerAccount);

            if (registration) {// 登録成功の場合
                System.out.println("登録成功");
                Account accountId = new Account(name);
                HttpSession session = request.getSession();
                session.setAttribute("accountId", accountId);
                System.out.println("セッションスコープにアカウントIDが入りました！");
                AllRecipeLogic allRecipeLogic = new AllRecipeLogic();
                Map<Integer, Recipe> allRecipe = allRecipeLogic.execute();
                if (allRecipe != null) {
                    session.setAttribute("allRecipe", allRecipe);
                    System.out.println("セッションスコープにAllRecipeが入りました");
                } else {
                    System.out.println("全レシピセッションスコープに保存失敗です");
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/preMain.jsp");
                dispatcher.forward(request, response);
            } else {// 登録済みだった場合
                System.out.println("登録失敗です");
                String errorMsg = "登録済みのIDです";
                // エラーメッセージをリクエストスコープに保存
                request.setAttribute("errorMsg", errorMsg);
                // フォワード
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerAccount.jsp");
                dispatcher.forward(request, response);

            }

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
