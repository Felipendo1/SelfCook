package model;

import java.io.Serializable;

public class RandomId implements Serializable {
	private int recipeId;

	public RandomId() {
	}

	public RandomId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

}
