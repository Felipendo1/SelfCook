package test;

import java.util.List;
import java.util.Map;

import dao.RecipeDAO;
import model.KeyIn;
import model.Recipe;
import model.ResearchRecipeLogic;

public class researchLogicTest {

	public static void main(String[] args) {
		KeyIn keyIn = new KeyIn();
		keyIn.setFood1("オクラ");
//		keyIn.setFood2("梅干し");
//		keyIn.setFood3("豚肉");
		System.out.println(keyIn);
//		System.out.println(keyIn.getFood1());
//		System.out.println(keyIn.getFood2());
		RecipeDAO dao = new RecipeDAO();
		Map<Integer, Recipe> allRecipe = dao.getAll();
		ResearchRecipeLogic researchLogic = new ResearchRecipeLogic();
		List<Integer> recipeList = researchLogic.researchRecipe(allRecipe, keyIn);
		if (recipeList.size() != 0) {
			System.out.println(recipeList);
			int randomId = researchLogic.randomId(recipeList);
			System.out.println(randomId);
		} else {
			System.out.println("recipeListのサイズは0、検索失敗しました");
		}
	}

}
