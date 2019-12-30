package jdbt.member.exam;
import java.util.ArrayList;
import java.util.Scanner;

import jdbt.member.exam.MemeberDAO;
import jdbt.board.exam.BoardDTO;
import jdbt.member.exam.MemberDAOImpl;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	MemeberDAO dao = new MemberDAOImpl();
	
	public void insertMenu(){
		//입사일은 sysdate, point 기본 1000으로
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String password = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("부서번호:");
		String deptno = key.next();
			
		//여기에서 MemberDAO의 메소드를 호출하세요
		MemberDTO customer = new MemberDTO(id, password, name, addr, deptno);
		int result = dao.insert(customer);
		if(result>0) {
			System.out.println("게시글 등록 성공");
		}else {
			System.out.println("게시글 등록 실패");
		}
	}
	public void updateMenu(){
		System.out.println("*******사원수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 MemberDAO의 메소드를 호출하세요
		int result = dao.update(id, addr);
		//결과처리
		if(result>0) {
			System.out.println("업데이트 등록 성공");
		}else {
			System.out.println("업데이트 등록 실패");
		}
	}
	public void deleteMenu(){
		System.out.println("*******사원삭제********");
		System.out.print("아이디:");
		String id = key.next();
		//여기에서 MemberDAO의 메소드를 호출하세요
		int result = dao.delete(id);
		//결과처리
		if(result>0) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("게시글 삭제 실패");
		}
	}
	public void findByAddrMenu(){
		System.out.println("*******주소로 사원검색********");
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 MemberDAO의 메소드를 호출하세요
		ArrayList<MemberDTO> memberlist = dao.findByAddr(addr);
		int size = memberlist.size();
		
		for (int i=0; i<size;i++) {
			MemberDTO member = memberlist.get(i);
			System.out.println(member.getId()+"\t"+member.getPassword()+
					"\t"+member.getName()+"\t"+member.getAddr()+"\t"+
					member.getDeptno());
		}
		
	}
	
	public void selectMenu(){
		System.out.println("*******게시글조회********");
		//여기에서 MemberDAO의 메소드를 호출하세요 - 전체사원조회
		ArrayList<MemberDTO> memberlist = dao.memberList();
		int size = memberlist.size();
		for(int i =0; i<size; i++) {
			MemberDTO member = memberlist.get(i);
			System.out.println(member.getId()+"\t"+member.getPassword()+
					"\t"+member.getName()+"\t"+member.getAddr()+"\t"+
					member.getDeptno());
		}
	}
}


















