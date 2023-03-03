package com.exam.biz;

import com.exam.dao.LoginDao;
import com.exam.entity.LoginEntity;

public class LoginBiz {

	public LoginEntity getLoginUser(String id, String pwd) {
		LoginDao dao = new LoginDao();
		LoginEntity entity = dao.getLoginUser(id, pwd);
		return entity;
	}

}
