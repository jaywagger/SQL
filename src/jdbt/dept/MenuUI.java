package jdbt.dept;

import java.util.ArrayList;
import java.util.Scanner;

import jdbt.dept.DeptDAO;
import jdbt.dept.DeptDAOImpl;
import jdbt.dept.DeptDTO;

public class MenuUI {
	Scanner key = new Scanner(System.in);

	int number =0;
	
	DeptDAO dao = new DeptDAOImpl();//왜 굳히 임플로 객체 생성? 정보가 다 임플에 있어서?

	
	public void insertMenu(){
		System.out.println("*******게시글등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("제목:");
		String title = key.next();
		System.out.print("내용:");
		String content = key.next();
		//여기에서 BoardDAO의 메소드를 호출하세요
		//int result = dao.insert(id, title, content);
		//결과처리
		DeptDTO dept = new DeptDTO(id,title,content);
		int result = dao.insert(dept);
		if(result>0) {
			System.out.println("게시글 등록 성공");
		}else {
			System.out.println("게시글 등록 실패");
		}
	}
	public void updateMenu(){
		System.out.println("*******게시글수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("게시글번호:");
		int deptNum = key.nextInt();
		//여기에서 BoardDAO의 메소드를 호출하세요
		int result = dao.update(deptNum, id);
		//결과처리
		if(result>0) {
			System.out.println("업데이트 등록 성공");
		}else {
			System.out.println("업데이트 등록 실패");
		}
	}
	public void deleteMenu(){
		System.out.println("*******게시글삭제********");
		System.out.print("게시글번호:");
		int deptNum = key.nextInt();
		//여기에서 BoardDAO의 메소드를 호출하세요
		int result = dao.delete(deptNum);
		//결과처리
		if(result>0) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("게시글 삭제 실패");
		}
	}
	public void searchMenu(){
		System.out.println("*******제목으로 게시글검색********");
		System.out.print("제목:");
		String title = key.next();
		//여기에서 BoardDAO의 메소드를 호출하세요
		ArrayList<DeptDTO> deptlist = dao.findbyTitle(title);
		int size = deptlist.size();
		for (int i=0; i<size;i++) {
			DeptDTO board = deptlist.get(i);
			System.out.println(board.getDeptNum()+"\t"+
			board.getTitle()+"\t"+board.getId()+"\t"
			+board.getWriteDate()+"\t"+board.getHit()+"\t"+board.getContent());
		}
 		
		
	}
	
	public void readMenu(){
		System.out.println("*******게시글상세조회********");
		System.out.print("글번호:");
		int deptnum = key.nextInt();
		//여기에서 BoardDAO의 메소드를 호출하세요
		DeptDTO dept = dao.read(deptnum);
		if(dept==null)
		{
			System.out.println("조회된 데이터가 없습니다.");
		}else {
		System.out.println("글번호:"+dept.getDeptNum());
		System.out.println("제목:"+dept.getTitle());
		System.out.println("작성자:"+dept.getId());
		System.out.println("내용:"+dept.getContent());
		System.out.println("작성날짜:"+dept.getWriteDate());
		System.out.println("조회수:"+dept.getHit());
		}
		
	}
	
	
	public void selectMenu(){
		System.out.println("*******게시글조회********");
		//여기에서 BoardDAO의 메소드를 호출하세요 - 전체사원조회
		ArrayList<DeptDTO> deptlist = dao.select();
		int size = deptlist.size();
		for(int i =0; i<size; i++) {
			DeptDTO dept = deptlist.get(i);
			System.out.println(dept.getDeptNum()+"\t"+dept.getTitle()+
					"\t"+dept.getId()+dept.getHit());
		}
	}
}


















