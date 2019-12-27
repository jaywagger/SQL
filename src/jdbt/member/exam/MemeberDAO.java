package jdbt.member.exam;

import jdbt.customer.exam.CustomerDTO;

public interface MemeberDAO {
	//1. 사원등록, 3. 사원수정, 4. 사원퇴사 작동
		int insert(MemberDTO member);
		//int insert(String id, String password, String name, String addr, String deptno);
		int update(String id, String addr);
		int delete(String id);

}
