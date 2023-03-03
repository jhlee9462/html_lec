package book.biz;

import book.dao.LoginDAO;

public class LoginBiz {
	public boolean getLoginUser(String id, String pass) {
		LoginDAO dao = new LoginDAO();
		return dao.getLoginUser(id, pass);
	}
}
