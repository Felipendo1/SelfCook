package test;

import dao.AccountDAO;
import model.Account;

public class AccountDAOTest {

	public static void main(String[] args) {
		//		String id = "minato";
		//		String pass = "1234";
		//		String name = "湊 雄輔";
		//		Account account = new Account(id, pass, name);
		//		AccountDAO dao = new AccountDAO();
		//		boolean createTest = dao.create(account);
		//		if (createTest) {
		testFindByLogin1();// ユーザーが見つかる場合のテスト
		testFindByLogin2();// ユーザーが見つからない場合のテスト
		//		} else {
		//			System.out.println("データベースに書き込み失敗");
		//		}
	}

	public static void testFindByLogin1() {
		Account account = new Account("minato", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(account);
		if (result != null &&
				result.getId().equals("minato") &&
				result.getPass().equals("1234") &&
				result.getName().equals("湊 雄輔")) {
			System.out.println("testFindByLogin1:成功しました");
		} else

		{
			System.out.println("testFindByLogin1:失敗しました");
		}
	}

	public static void testFindByLogin2() {
		Account account = new Account("minato", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(account);
		if (result == null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
