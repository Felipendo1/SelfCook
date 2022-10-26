package model;

//ログイン用のBusiness Objectクラス
//
import dao.AccountDAO;

public class LoginLogic {
	public Account execute(Account account) {
		AccountDAO dao = new AccountDAO();
		Account login = new Account();
		login = dao.findByLogin(account);
		System.out.println("LoginLogic" + login);
		return login;
	}
}
