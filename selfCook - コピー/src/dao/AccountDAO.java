package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountDAO {
	// DB接続用情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/"
			+ "selfcook"
			+ "?characterEncoding=UTF-8"
			+ "&serverTimezone=Asia/Tokyo";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public Account findByLogin(Account account) {// ログイン用（変更なし）
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ACCOUNT_ID,PASSWORD,NICKNAME FROM ACCOUNT WHERE ACCOUNT_ID = ? "
					+ "AND PASSWORD = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getId());
			pStmt.setString(2, account.getPass());
			System.out.println("データベースに接続しました");

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合
			// そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				// 結果表からデータを取得
				String id = rs.getString("ACCOUNT_ID");/* 「"id"」と入力してもOK */
				String pass = rs.getString("PASSWORD");/* 「"pass"」と入力してもOK */
				String name = rs.getString("NICKNAME");/* 「"name"」と入力してもOK */
				System.out.println("ログイン情報をみつけました");
				account = new Account(id, pass, name);
				System.out.println("dao1" + account.getName());
			} else {
				account = null;

			}
		} catch (SQLException e) {
			e.printStackTrace();// スタックトレース（Javaのテキスト P.664～665 参照）
			return null;
		}
		// 見つかったユーザーまたはnullを返す
		System.out.println("dao3" + account);
		return account;
	}

	/* 以下、ユーザー登録用に追加 */
	public boolean findByAccount(Account account) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ACCOUNT_ID FROM ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getId());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合（登録済みのID）、trueを返す
			if (rs.next()) {
				System.out.println("ログイン情報をみつけました");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		// ユーザーが見つからなかったら（未登録のID）、falseを返す
		return false;
	}

	// 新規登録
	public boolean create(Account account) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文の準備
			String sql = "INSERT INTO ACCOUNT(ACCOUNT_ID,PASSWORD,NICKNAME,LASTLOGIN_DATE) VALUES(?,?,?,cast(now() as datetime))";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, account.getId());// 1つ目の「?」
			pStmt.setString(2, account.getPass());// 2つ目の「?」
			pStmt.setString(3, account.getName());// 3つ目の「?」

			// INSERT文を実行（resultには正常終了した場合は「1」、正常終了しなかった場合は「0」が代入される）
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 引数のidのレコード削除
	public boolean remove(String id) {
		// DB接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,
				DB_USER,
				DB_PASS)) {
			// DELETE文を準備
			String str = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(str);
			pStmt.setString(1, id);
			// DELETE実行
			int result = pStmt.executeUpdate();
			return (result == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
