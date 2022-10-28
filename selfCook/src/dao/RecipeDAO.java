package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
//import java.util.List;
//import java.util.ArrayList;
import java.util.Map;

import model.Recipe;

//
//RECIPEテーブルと連動するDAO。
//
public class RecipeDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/selfcook?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	// RECIPEテーブルの全レコード検索し、Map<Recipe>を返す
	public Map<Integer, Recipe> getAll() {
		// DB接続
		Map<Integer, Recipe> map = new HashMap<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT RECIPE_ID,ACCOUNT_ID,RECIPE_NAME,FOOD1,FOOD2,FOOD3,FOOD4,FOOD5,RECIPE_CONTENT" +
					" FROM RECIPE ORDER BY RECIPE_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SELECT実行
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("recipe_id");
				String account_id = rs.getString("account_id");
				String recipe_name = rs.getString("recipe_name");
				String food1 = rs.getString("food1");
				String food2 = rs.getString("food2");
				String food3 = rs.getString("food3");
				String food4 = rs.getString("food4");
				String food5 = rs.getString("food5");
				String recipe_content = rs.getString("recipe_content");
				Recipe recipe = new Recipe(id, account_id, recipe_name, food1, food2, food3, food4, food5,
						recipe_content);
				//				lst.add(recipe);
				map.put(id, recipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	// RECIPEテーブルの指定アカウント用の全レコード検索し、Map<Recipe>を返す
	public Map<Integer, Recipe> getAll(String accountId) {
		// DB接続
		Map<Integer, Recipe> map = new HashMap<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECT文を準備
			String sql = "SELECT RECIPE_ID,ACCOUNT_ID,RECIPE_NAME,FOOD1,FOOD2,FOOD3,FOOD4,FOOD5,RECIPE_CONTENT" +
					" FROM RECIPE WHERE ACCOUNT_ID=? ORDER BY RECIPE_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, accountId);
			// SELECT実行
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("recipe_id");
				String account_id = rs.getString("account_id");
				String recipe_name = rs.getString("recipe_name");
				String food1 = rs.getString("food1");
				String food2 = rs.getString("food2");
				String food3 = rs.getString("food3");
				String food4 = rs.getString("food4");
				String food5 = rs.getString("food5");
				String recipe_content = rs.getString("recipe_content");
				Recipe recipe = new Recipe(id, account_id, recipe_name, food1, food2, food3, food4, food5,
						recipe_content);
				//				lst.add(recipe);
				map.put(id, recipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	// RECIPEテーブルに新規レコードインサート
	public boolean create(Recipe recipe) {
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// INSERT文を準備
			String sql = "INSERT INTO " +
					"RECIPE(ACCOUNT_ID,RECIPE_NAME,FOOD1,FOOD2,FOOD3,FOOD4,FOOD5,RECIPE_CONTENT) " +
					"VALUES(         ?,          ?,    ?,    ?,    ?,    ?,    ?,             ?)";
			//                       1           2     3     4     5     6     7              8
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setInt(1, recipe.getRecipe_id());
			pStmt.setString(1, recipe.getAccountId());
			pStmt.setString(2, recipe.getRecipeName());
			pStmt.setString(3, recipe.getFood1());
			pStmt.setString(4, recipe.getFood2());
			pStmt.setString(5, recipe.getFood3());
			pStmt.setString(6, recipe.getFood4());
			pStmt.setString(7, recipe.getFood5());
			pStmt.setString(8, recipe.getRecipeContent());
			// INSERT実行
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// RECIPEテーブルの指定recipe_idのレコード更新
	public boolean update(Recipe recipe) {
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// UODATE文を準備
			String sql = "UPDATE RECIPE SET " +
					"ACCOUNT_ID=?,RECIPE_NAME=?,FOOD1=?,FOOD2=?,FOOD3=?,FOOD4=?,FOOD5=?,RECIPE_CONTENT=? " +
					//          1             2       3       4       5       6       7                8
					"WHERE RECIPE_ID=?";
			//                       9
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, recipe.getAccountId());
			pStmt.setString(2, recipe.getRecipeName());
			pStmt.setString(3, recipe.getFood1());
			pStmt.setString(4, recipe.getFood2());
			pStmt.setString(5, recipe.getFood3());
			pStmt.setString(6, recipe.getFood4());
			pStmt.setString(7, recipe.getFood5());
			pStmt.setString(8, recipe.getRecipeContent());
			pStmt.setInt(9, recipe.getRecipeId());
			// UPDATE実行
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// RECIPEテーブルの指定recipe_idのレコード削除
	public boolean remove(int recipe_id) {
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// DELETE文を準備
			String sql = "DELETE FROM RECIPE WHERE RECIPE_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, recipe_id);
			// DELETE実行
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
