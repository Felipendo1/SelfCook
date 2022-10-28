package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

//
//食材を入力してレシピを検索するロジック。
//
public class ResearchRecipeLogic {

	public List<Integer> researchRecipe(Map<Integer, Recipe> allRecipe, KeyIn keyIn) {
		List<Integer> recipeList = new ArrayList<>();
		//allRecipeにデータが入っている場合
		if (allRecipe != null) {
			int key;
			Recipe recipe;
			String food;
			//Map内(allRecipe)の全recipeデータを取得し、
			//keyInとマッチするrecipeをrecipeListに格納する
			for (Map.Entry<Integer, Recipe> entry : allRecipe.entrySet()) {
				key = entry.getKey();
				recipe = entry.getValue();
				food = recipe.getFood1() + recipe.getFood2() + recipe.getFood3() + recipe.getFood4()
						+ recipe.getFood5();
				//			food3,food2なし,food1あるパターンの生成
				if (keyIn.getFood3() == null) {
					if (keyIn.getFood2() == null) {
						if (food.contains(keyIn.getFood1())) {
							recipeList.add(key);
						}
						//						food3なしfood2あるパターンの生成
					} else {
						if (food.contains(keyIn.getFood1()) && food.contains(keyIn.getFood2())) {
							recipeList.add(key);
						}
					}
					//						food3あるパターンの生成
				} else {
					if (food.contains(keyIn.getFood1()) && food.contains(keyIn.getFood2())
							&& food.contains(keyIn.getFood3())) {
						recipeList.add(key);
					}
				}
			}

		}
		//recipeを格納したrecipeListを返す
		return recipeList;
	}

	//researchRecipeで作成したList(recipeList)から
	//ランダムに1つ選択し、そのidを返す
	public int randomId(List<Integer> recipeList) {
		Random random = new Random();
		int randomIndex = random.nextInt(recipeList.size());
		System.out.println(recipeList.get(randomIndex));
		int randomId = recipeList.get(randomIndex);
		System.out.println(randomId);
		return randomId;
	}
}