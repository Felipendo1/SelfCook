package test;

import model.Account;
import model.LoginLogic;

public class LoginLogicTest {

	public static void main(String[] args) {
		testExecute1();// ログイン成功のテスト
		testExecute2();// ログイン失敗のテスト
	}

	public static void testExecute1() {
		String id = "userA@user.com";
		String pass = "1234";
		Account login = new Account(id, pass);
		LoginLogic bo = new LoginLogic();
		Account result = bo.execute(login);
		if (result != null) {
			System.out.println("testExecute1:成功しました");
		} else {
			System.out.println("testExecute2:失敗しました");
		}
	}

	public static void testExecute2() {
		String id = "userA@user.com";
		String pass = "12345";
		Account login = new Account(id, pass);
		LoginLogic bo = new LoginLogic();
		Account result = bo.execute(login);
		if (result == null) {
			System.out.println("testExecute2:成功しました");
		} else {
			System.out.println("testExecute2:失敗しました");
		}
	}
}
