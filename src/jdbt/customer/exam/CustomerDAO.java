package jdbt.customer.exam;

public interface CustomerDAO {
	//1. ������, 3. �������, 4. ������ �۵�
		int insert(CustomerDTO customer);
		int update(String id, String addr);
		int delete(String id);

}
