package bean;
// VO DTO bean
public class EmpVo {
	private String name, phone, addr;

	public EmpVo() {
		super();
	}
	
	public EmpVo(String name, String phone, String addr) {
		this();
		this.name = name;
		this.phone = phone;
		this.addr = addr;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
