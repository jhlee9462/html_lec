package com.exam.biz;

import java.util.ArrayList;

import com.exam.dao.EmpDao;
import com.exam.entity.EmpEntity;

public class EmpBiz {

	private EmpDao dao = new EmpDao();
	
	public int insertEmp(EmpEntity emp) {
		return dao.insertEmp(emp);
	}
	
	public ArrayList<EmpEntity> listEmp() {
		ArrayList<EmpEntity> list = dao.listEmp();
		return list;
	}
	
	public int updateEmp(EmpEntity emp) {
		int r = dao.updateEmp(emp);
		return r;
	}

	public int deleteEmp(int eno) {
		int r = dao.deleteEmp(eno);
		return r;
	}
}
