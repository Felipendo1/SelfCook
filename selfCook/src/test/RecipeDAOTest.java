package test;

//import java.util.List;
import java.util.Map;

import dao.AccountDAO;
import dao.RecipeDAO;
import model.Account;
import model.Recipe;

public class RecipeDAOTest {

	public static void main(String[] args) {
		// アカウントレコード追加
		Account account = new Account("test@co.jp", "test", "テスト");
		AccountDAO dao1 = new AccountDAO();
		boolean sts = dao1.create(account);
		if (sts) {
			System.out.println("accountレコードtest@co.jp追加成功");
		} else {
			System.out.println("accountレコードtest@co.jp追加失敗");
		}
		account = new Account("test2@co.jp", "test", "テスト");
		dao1 = new AccountDAO();
		sts = dao1.create(account);
		if (sts) {
			System.out.println("accountレコードtest2@co.jp追加成功");
		} else {
			System.out.println("accountレコードtest2@co.jp追加失敗");
		}
		System.out.println("RECIPE DAO テスト開始");
		testGetAll2("test@co.jp"); // 全レコード確認
		System.out.println("レコード追加");
		testCreate();
		System.out.println("同一レコード追加");
		testCreate();
		System.out.println("異なるレコード追加");
		testCreate2();
		System.out.println("recipe_id=89のレコード更新");
		testUpdate();
		testGetAll2("test@co.jp"); // 全レコード確認
		System.out.println("recipe_id=37のレコード削除");
		testRemove();
		testGetAll2("test@co.jp"); // 全レコード確認

	}

	public static void testGetAll() {
		RecipeDAO dao = new RecipeDAO();
		//		List<Recipe> result = dao.getAll();
		Map<Integer, Recipe> result = dao.getAll();
		if (result != null) {
			for (Map.Entry<Integer, Recipe> entry : result.entrySet()) {
				int key = entry.getKey();
				System.out.print("MapのKeyは:" + key + "\n");
				Recipe recipe = entry.getValue();
				System.out.print("recipe_id:" + recipe.getRecipeId() + "\n");
				System.out.print("account_id:" + recipe.getAccountId() + "\n");
				System.out.print("recipe_name:" + recipe.getRecipeName() + "\n");
				System.out.print("food1:" + recipe.getFood1() + " ");
				System.out.print("food2:" + recipe.getFood2() + " ");
				System.out.print("food3:" + recipe.getFood3() + " ");
				System.out.print("food4:" + recipe.getFood4() + " ");
				System.out.print("food5:" + recipe.getFood5() + " ");
				System.out.println("recipe_content:" + recipe.getRecipeContent());
			}
		} else {
			System.out.println("testGetAll:RECIPEテーブルレコード無し");
		}
	}

	public static void testGetAll2(String accountId) {
		RecipeDAO dao = new RecipeDAO();
		//		List<Recipe> result = dao.getAll();
		Map<Integer, Recipe> result = dao.getAll(accountId);
		if (result != null) {
			for (Map.Entry<Integer, Recipe> entry : result.entrySet()) {
				int key = entry.getKey();
				System.out.println("");
				System.out.print("MapのKeyは:" + key + "\n");
				Recipe recipe = entry.getValue();
				System.out.print("recipe_id:" + recipe.getRecipeId() + "\n");
				System.out.print("account_id:" + recipe.getAccountId() + "\n");
				System.out.print("recipe_name:" + recipe.getRecipeName() + "\n");
				System.out.print("food1:" + recipe.getFood1() + " ");
				System.out.print("food2:" + recipe.getFood2() + " ");
				System.out.print("food3:" + recipe.getFood3() + " ");
				System.out.print("food4:" + recipe.getFood4() + " ");
				System.out.print("food5:" + recipe.getFood5() + " ");
				System.out.println("recipe_content:" +
				(recipe.getRecipeContent()==null || recipe.getRecipeContent().length() < 2 ? null:recipe.getRecipeContent().substring(0, 2)));
				System.out.println("");
			}
		} else {
			System.out.println("");
			System.out.println("testGetAll:RECIPEテーブルレコード無し");
			System.out.println("");
		}
	}

	public static void testCreate() {
		// レコード作成
		//		int recipe_id = 0;
		String account_id = "test@co.jp";
		String recipe_name = "肉じゃが";
		String food1 = "じゃがいも";
		//		String food2 = "food2";
		//		String food3 = "food3";
		//		String food4 = "food4";
		//		String food5 = "food5";
		//		String recipe_content = "煮る";

		Recipe recipe = new Recipe(account_id, recipe_name, food1);
		RecipeDAO dao = new RecipeDAO();
		boolean result = dao.create(recipe);
		if (result) {
			System.out.println("レコード追加成功");
		} else {
			System.out.println("レコード追加失敗");
		}
	}

	public static void testCreate2() {
		// レコード作成
		int recipe_id = 0;
		String account_id = "test@co.jp";
		String recipe_name = "じゃがいものソテー";
		String food1 = "じゃがいも";
		String food2 = "food2";
		String food3 = "food3";
		String food4 = "food4";
		String food5 = "food5";
		String recipe_content = "たく";

		Recipe recipe = new Recipe(recipe_id, account_id, recipe_name, food1,
				food2, food3, food4, food5, recipe_content);
		RecipeDAO dao = new RecipeDAO();
		boolean result = dao.create(recipe);
		if (result) {
			System.out.println("レコード追加成功");
		} else {
			System.out.println("レコード追加失敗");
		}
	}

	public static void testUpdate() {
		// レコード更新
		int recipe_id = 89;
		String account_id = "test2@co.jp";
		String recipe_name = "肉じゃが2";
		String food1 = "じゃがいも";
		String food2 = "にんじん";
		String food3 = "food3";
		String food4 = "food4";
		String food5 = "food5";
		String recipe_content = "煮る";

		Recipe recipe = new Recipe(recipe_id, account_id, recipe_name,
				food1, food2, food3, food4, food5, recipe_content);
		RecipeDAO dao = new RecipeDAO();
		boolean result = dao.update(recipe);
		if (result) {
			System.out.println("recipe_id=89のレコード更新成功");
		} else {
			System.out.println("recipe_id=89のレコード更新失敗");
		}
	}

	public static void testRemove() {
		// レコード削除
		int recipe_id = 37;
		//		String account_id = "t1@co.jp";
		//		String recipe_name = "肉じゃが";
		//		String food1 = "じゃがいも";
		//		String food2 = "にんじん";
		//		String food3 = "food3";
		//		String food4 = "food4";
		//		String food5 = "food5";
		//		String recipe_content = "煮る";

		//		Recipe recipe =
		//				new Recipe(recipe_id);
		RecipeDAO dao = new RecipeDAO();
		boolean result = dao.remove(recipe_id);
		if (result) {
			System.out.println("recipe_id=37のレコード削除成功");
		} else {
			System.out.println("recipe_id=37のレコード削除失敗");
		}
	}

}
