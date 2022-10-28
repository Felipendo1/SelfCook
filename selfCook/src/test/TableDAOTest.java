package test;

import dao.AccountDAO;
import dao.TableDAO;
import model.Account;

public class TableDAOTest {
	public static void main(String[] args) {
		Account account = new Account("ABC2@co.jp", "test", "テスト");
		AccountDAO dao1 = new AccountDAO();
		boolean sts = dao1.create(account);
		if (sts) {
			System.out.println("accountレコードABC2@co.jp追加成功");
		} else {
			System.out.println("accountレコードABC2@co.jp追加失敗");
		}
		TableDAO dao = new TableDAO();
		sts = dao.create("ABC2@co.jp");
		RecipeDAOTest test= new RecipeDAOTest();
		test.testGetAll2("ABC2@co.jp"); // 全レコード確認
	}

}
