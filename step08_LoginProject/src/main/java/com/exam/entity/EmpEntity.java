package com.exam.entity;

public class EmpEntity {
	private int eno;
	private String name, phone, dept;
	
	public EmpEntity() {
	}

	public EmpEntity(int eno, String name, String phone, String dept) {
		super();
		this.eno = eno;
		this.name = name;
		this.phone = phone;
		this.dept = dept;
	}
	
	public int getEno() {
		return eno;
	}
	
	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
