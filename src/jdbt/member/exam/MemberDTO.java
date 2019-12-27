package jdbt.member.exam;

public class MemberDTO {
	private String id;
	private String password;
	private String name;  
	private String addr;
	private String deptno;
	
	public MemberDTO() {
	}
	//delete¿ë
	public MemberDTO(String id) {
		super();
		this.id = id;
	}//delete¿ë
	public MemberDTO(String id, String addr) {
		super();
		this.id = id;
		this.addr = addr;
	}
	//insert¿ë
	public MemberDTO(String id, String password, String name, String addr, String deptno) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.addr = addr;
		this.deptno = deptno;
	}
	
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", addr=" + addr + ", deptno="
				+ deptno + "]";
	}
	//Setter&Getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
}

