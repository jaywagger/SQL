package jdbt.member.exam;

import jdbt.customer.exam.CustomerDTO;

public interface MemeberDAO {
	//1. ������, 3. �������, 4. ������ �۵�
		int insert(MemberDTO member);
		//int insert(String id, String password, String name, String addr, String deptno);
		int update(String id, String addr);
		int delete(String id);

}
