package jdbt.customer.exam;

public interface CustomerDAO {
	//1. 사원등록, 3. 사원수정, 4. 사원퇴사 작동
		int insert(CustomerDTO customer);
		int update(String id, String addr);
		int delete(String id);

}
