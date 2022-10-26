package model;

import java.io.Serializable;

public class RecipeList implements Serializable {
	private int[] recipeList;

	public RecipeList() {
	}

	public RecipeList(int[] recipeList) {
		this.recipeList = recipeList;
	}

	public int[] getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(int[] recipeList) {
		this.recipeList = recipeList;
	}

}
