package test;

import model.Recipe;
import model.RecipeEditLogic;

public class EditTest {

	public static void main(String[] args) {
		String accountId = "default";
		String recipeName = "ゆでゆでじゃが";
		String food1 = "じゃがいも";
		String recipeContent = "茹でる";
		Recipe recipe = new Recipe();
		recipe.setAccountId(accountId);
		recipe.setRecipeName(recipeName);
		recipe.setFood1(food1);
		recipe.setRecipeContent(recipeContent);
		RecipeEditLogic lo = new RecipeEditLogic();
		boolean result = lo.regist(recipe);
		if (result) {
			System.out.println("登録成功");
			updateTest();
			deleteTest();

		} else {
			System.out.println("登録失敗");
		}

	}

	public static void updateTest() {
		String accountId = "default";
		int recipeId = 3;
		String recipeName = "フライドポテト";
		String food1 = "じゃがいも";
		String recipeContent = "油で揚げる。";
		Recipe recipe = new Recipe();
		recipe.setRecipeId(recipeId);
		recipe.setAccountId(accountId);
		recipe.setRecipeName(recipeName);
		recipe.setFood1(food1);
		recipe.setRecipeContent(recipeContent);
		RecipeEditLogic lo = new RecipeEditLogic();
		boolean result = lo.edit(recipe);
		if (result) {
			System.out.println("update成功");
		} else {
			System.out.println("update失敗");
		}

	}

	public static void deleteTest() {
		//			String accountId = "default";
		//			String recipeName = "フライドポテト";
		//			String food1 = "じゃがいも";
		//			String recipeContent = "揚げる";
		Recipe recipe = new Recipe();
		recipe.setRecipeId(12);
		//			recipe.setAccountId(accountId);
		//			recipe.setRecipeName(recipeName);
		//					recipe.setFood1(food1);
		//					recipe.setRecipeContent(recipeContent);
		RecipeEditLogic lo = new RecipeEditLogic();
		boolean result = lo.delete(recipe.getRecipeId());
		if (result) {
			System.out.println("delete成功");
		} else {
			System.out.println("delete失敗");
		}
	}
}
