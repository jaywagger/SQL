package jdbt.customer.exam;

public class CustomerDTO {
	private String id;
	private String pass;
	private String name;
	private String addr;
	
	public CustomerDTO() {
	}
	//delete¿ë
	public CustomerDTO(String id) {
		super();
		this.id = id;
	}//delete¿ë
	public CustomerDTO(String id, String addr) {
		super();
		this.id = id;
		this.addr = addr;
	}
	//insert¿ë
	public CustomerDTO(String id, String pass, String name, String addr) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + "]";
	}
	//Setter&Getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	
}

