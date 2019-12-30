package jdbt.board.exam;
import java.util.Scanner;

public class DAOTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("******게시판********");
		System.out.println("1. 게시글등록");
		System.out.println("2. 게시글전체목록조회");
		System.out.println("3. 게시글수정");
		System.out.println("4. 게시글삭제");
		System.out.println("5. 제목으로 게시글 검색");
		System.out.println("6. 게시글 상세보기");
		System.out.print("원하는 작업을 선택하세요:");
		int choice  = key.nextInt();
		show(choice);
	}
	public static void show(int choice){
		MenuUI ui = new MenuUI();//메뉴 객체를 생성하고 변수 ui에 넣었기 때문에
		switch(choice){
			case 1: //1. 게시글등록
				ui.insertMenu();	//이렇게 클래스의 메서드를 부를 수 있다.
				break;
			case 2: //2. 게시글전체목록조회
				ui.selectMenu();
				break;
			case 3: //3. 게시글수정
				ui.updateMenu();
				break;
			case 4: //4. 게시글삭제
				ui.deleteMenu();
				break;
			case 5: //5. 제목으로 게시글 검색
				ui.searchMenu();
				break;
			case 6: //6. 게시글 상세보기
				ui.readMenu();
				break;
		}
	}
}













