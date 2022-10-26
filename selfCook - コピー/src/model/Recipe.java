package model;

import java.io.Serializable;

//レシピ情報を保存するデータモデル。
public class Recipe implements Serializable {
	private int recipeId;
	private String accountId;
	private String recipeName;
	private String food1;
	private String food2;
	private String food3;
	private String food4;
	private String food5;
	private String recipeContent;

	public Recipe() {
	}

	public Recipe(int recipeId, String accountId, String recipeName, String food1, String food2, String food3,
			String food4, String food5, String recipeContent) {
		this.recipeId = recipeId;
		this.accountId = accountId;
		this.recipeName = recipeName;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.food4 = food4;
		this.food5 = food5;
		this.recipeContent = recipeContent;
	}

	public Recipe(String accountId, String recipeName, String food1, String food2, String food3, String food4,
			String food5, String recipeContent) {
		super();
		this.accountId = accountId;
		this.recipeName = recipeName;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.food4 = food4;
		this.food5 = food5;
		this.recipeContent = recipeContent;
	}

	public Recipe(String accountId, String recipeName, String food1) {
		super();
		this.accountId = accountId;
		this.recipeName = recipeName;
		this.food1 = food1;
	}

	public Recipe(String recipeName, int recipeId, String food1, String recipeContent) {
		this.recipeName = recipeName;
		this.recipeId = recipeId;
		this.food1 = food1;
		this.recipeContent = recipeContent;
	}

	public Recipe(String recipeName, int recipeId, String food1, String food2, String recipeContent) {
		this.recipeName = recipeName;
		this.recipeId = recipeId;
		this.food1 = food1;
		this.food2 = food2;
		this.recipeContent = recipeContent;
	}

	public Recipe(String recipeName, int recipeId, String food1, String food2, String food3, String recipeContent) {
		this.recipeName = recipeName;
		this.recipeId = recipeId;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.recipeContent = recipeContent;
	}

	public Recipe(String recipeName, int recipeId, String food1, String food2, String food3, String food4,
			String recipeContent) {
		this.recipeName = recipeName;
		this.recipeId = recipeId;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.food4 = food4;
		this.recipeContent = recipeContent;
	}

	public Recipe(String recipeName, int recipeId, String food1, String food2, String food3, String food4,
			String food5, String recipeContent) {
		this.recipeName = recipeName;
		this.recipeId = recipeId;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.food4 = food4;
		this.food5 = food5;
		this.recipeContent = recipeContent;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getFood1() {
		return food1;
	}

	public void setFood1(String food1) {
		this.food1 = food1;
	}

	public String getFood2() {
		return food2;
	}

	public void setFood2(String food2) {
		this.food2 = food2;
	}

	public String getFood3() {
		return food3;
	}

	public void setFood3(String food3) {
		this.food3 = food3;
	}

	public String getFood4() {
		return food4;
	}

	public void setFood4(String food4) {
		this.food4 = food4;
	}

	public String getFood5() {
		return food5;
	}

	public void setFood5(String food5) {
		this.food5 = food5;
	}

	public String getRecipeContent() {
		return recipeContent;
	}

	public void setRecipeContent(String recipeContent) {
		this.recipeContent = recipeContent;
	}

}
