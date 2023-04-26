package model;

import dao.TableDAO;

public class TableLogic {
	public boolean exec(String id) {
		TableDAO dao = new TableDAO();
//		Account account = new Account();
//		boolean bo = dao.create(account.getId());
		boolean bo = dao.create(id);
		if (bo) {
			return true;

		}
		return false;
	}
}
