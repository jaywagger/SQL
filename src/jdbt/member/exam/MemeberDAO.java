package jdbt.member.exam;

import java.util.ArrayList;

public interface MemeberDAO {
	//1. 사원등록, 3. 사원수정, 4. 사원퇴사 작동
		int insert(MemberDTO member);//사원등록
		//int insert(String id, String password, String name, String addr, String deptno);
		int update(String id, String addr);//사원수정
		int delete(String id);//사원탈퇴
		ArrayList<MemberDTO> memberList();//전체 사원목록 조회
		
		ArrayList<MemberDTO> findByAddr(String addr);//주소로 검색
		MemberDTO login(String id, String pass); //로그인
}
