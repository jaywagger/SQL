package jdbt.board.exam;

import java.util.Scanner;
public class BoardDAOTest {
	
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("아래 번호를 선택하세요: ");
		System.out.println("1번 조회");
		System.out.println("2번 삽입");
		System.out.println("3번 업데이트");
		System.out.println("4번 삭제");
		int num = key.nextInt();
		BoardDAOImpl dao = new BoardDAOImpl ();
		
		switch (num) 
		{
			case 1: 
				//1.Select
				System.out.println("*********게시물 조회***********");
				dao.select();
				break; 
					   
			case 2:
				//2.Insert
				
				System.out.println("*********게시물 등록***********");
				System.out.println("아이디: ");
				String id =key.next();
				System.out.println("제목: ");
				String title =key.next();
				System.out.println("내용: ");
				String content =key.next();
				dao.insert(id, title, content);
				break;
				
			case 3:
				//3. Update
				System.out.println("*********게시물 수정***********");
				System.out.println("번호: ");
				int boardnum =key.nextInt();
				System.out.println("아이디: ");
				String id1 =key.next();
				dao.update(boardnum, id1);
				break;
			case 4:
				//4. Delete
				System.out.println("*********게시물 삭제***********");
				System.out.println("번호: ");
				int boardnum1 =key.nextInt();
				dao.delete(boardnum1);
				break;
			default: 
				System.out.println("잘못입력");		
		}
		
		
		
		
		
		
		
		
	}

}
