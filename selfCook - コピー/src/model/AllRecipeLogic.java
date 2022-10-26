package model;

import java.util.Map;

import dao.RecipeDAO;

//
//全レシピ検索用ロジック。
//
public class AllRecipeLogic {
	public Map<Integer,Recipe> execute() {
		RecipeDAO dao = new RecipeDAO();
		Map<Integer, Recipe> allRecipe = dao.getAll();
		//		Iterable list =
		//		for (Recipe recipe : list) {
		//			System.out.println(recipe.getAccountId());
		//			System.out.println(recipe.getFood1());
		//		}
		return allRecipe;

	}

}
