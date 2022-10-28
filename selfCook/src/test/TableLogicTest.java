package test;

import dao.AccountDAO;
import model.Account;
import model.TableLogic;

public class TableLogicTest {

	public static void main(String[] args) {
		// まずaccountテーブルにテスト用アカウントを新規登録する。
		Account account = new Account("table@co.jp", "test", "テーブルテスト");
		AccountDAO dao1 = new AccountDAO();
		boolean sts = dao1.create(account);
		if (sts) {
			System.out.println("accountレコードtable@co.jp追加成功");
		} else {
			System.out.println("accountレコードtable@co.jp追加失敗");
		}
		System.out.println("TableLogicTest.javaテスト開始します");
		TableLogic logic = new TableLogic();
		sts = logic.exec("table@co.jp");
		System.out.println("全レコード確認します");
		RecipeDAOTest test = new RecipeDAOTest();
		test.testGetAll();
	}

}
