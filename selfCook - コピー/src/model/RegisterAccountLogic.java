package model;

import dao.AccountDAO;

public class RegisterAccountLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		// IDが登録済みか確認
		boolean registered = dao.findByAccount(account);
		// 登録処理
		if (!registered) {
			dao.create(account);
			return true;
		} else {
			return false;
		}
	}
}
