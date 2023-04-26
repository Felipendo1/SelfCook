package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * recipeテーブルのデフォルトデータ
 */
public class TableDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/selfcook?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	// RECIPEテーブルに指定ユーザ用デフォルトレコードインサート
	public boolean create(String accountId) {
		// DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// INSERT文を準備
			String sql = "INSERT INTO " +
			"RECIPE(ACCOUNT_ID,RECIPE_NAME,FOOD1,FOOD2,FOOD3,FOOD4,FOOD5,RECIPE_CONTENT) " +
			"SELECT          ?,RECIPE_NAME,FOOD1,FOOD2,FOOD3,FOOD4,FOOD5,RECIPE_CONTENT " +
			"FROM RECIPE WHERE ACCOUNT_ID='default'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, accountId);
			// INSERT実行
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
