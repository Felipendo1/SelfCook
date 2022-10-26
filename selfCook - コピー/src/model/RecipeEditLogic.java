package model;

import dao.RecipeDAO;

//レシピの編集用
//①レシピの新規登録(registメソッド)
//②レシピの編集(editメソッド)
//③レシピの削除のメソッドを持つ(deleteメソッド)
public class RecipeEditLogic {//①レシピの新規登録(registメソッド)
	public boolean regist(Recipe recipe) {
		RecipeDAO registDao = new RecipeDAO();
		boolean registered = registDao.create(recipe);
		if (registered) {
			return true;

		}
		return false;
	}

	public boolean edit(Recipe recipe) {//②レシピの編集(editメソッド)
		RecipeDAO editDao = new RecipeDAO();
		boolean edited = editDao.update(recipe);
		if (edited) {
			return true;

		}
		return false;
	}

	public boolean delete(Integer number) {//③レシピの削除のメソッドを持つ(deleteメソッド)
		RecipeDAO deleteDao = new RecipeDAO();
		Recipe recipe = new Recipe();
		recipe.setRecipeId(number);
		boolean deleted = deleteDao.remove(recipe.getRecipeId());
		if (deleted) {
			return true;

		}
		return false;
	}
}

//}
