package jdbt.board.exam;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	BoardDAO dao = new BoardDAOImpl();//�� ���� ���÷� ��ü ����? ������ �� ���ÿ� �־?
	
	
	public void insertMenu(){
		System.out.println("*******�Խñ۵��********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("����:");
		String title = key.next();
		System.out.print("����:");
		String content = key.next();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		//int result = dao.insert(id, title, content);
		//���ó��
		BoardDTO board = new BoardDTO(id,title,content);//�̰Թ���?
		int result = dao.insert(board);
		if(result>0) {
			System.out.println("�Խñ� ��� ����");
		}else {
			System.out.println("�Խñ� ��� ����");
		}
	}
	public void updateMenu(){
		System.out.println("*******�Խñۼ���********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�Խñ۹�ȣ:");
		int boardNum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(boardNum, id);
		//���ó��
		if(result>0) {
			System.out.println("������Ʈ ��� ����");
		}else {
			System.out.println("������Ʈ ��� ����");
		}
	}
	public void deleteMenu(){
		System.out.println("*******�Խñۻ���********");
		System.out.print("�Խñ۹�ȣ:");
		int boardNum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(boardNum);
		//���ó��
		if(result>0) {
			System.out.println("�Խñ� ���� ����");
		}else {
			System.out.println("�Խñ� ���� ����");
		}
	}
	public void searchMenu(){
		System.out.println("*******�������� �Խñ۰˻�********");
		System.out.print("����:");
		String title = key.next();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		ArrayList<BoardDTO> boardlist = dao.findbyTitle(title);
		int size = boardlist.size();
		for (int i=0; i<size;i++) {
			BoardDTO board = boardlist.get(i);
			System.out.println(board.getBoardNum()+"\t"+
			board.getTitle()+"\t"+board.getId()+"\t"
			+board.getWriteDate()+"\t"+board.getHit()+"\t"+board.getContent());
		}
 		
		
	}
	
	public void readMenu(){
		System.out.println("*******�Խñۻ���ȸ********");
		System.out.print("�۹�ȣ:");
		int boardnum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		BoardDTO board = dao.read(boardnum);
		if(board==null)
		{
			System.out.println("��ȸ�� �����Ͱ� �����ϴ�.");
		}else {
		System.out.println("�۹�ȣ:"+board.getBoardNum());
		System.out.println("����:"+board.getTitle());
		System.out.println("�ۼ���:"+board.getId());
		System.out.println("����:"+board.getContent());
		System.out.println("�ۼ���¥:"+board.getWriteDate());
		System.out.println("��ȸ��:"+board.getHit());
		}
		
	}
	
	
	public void selectMenu(){
		System.out.println("*******�Խñ���ȸ********");
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
		ArrayList<BoardDTO> boardlist = dao.select();
		int size = boardlist.size();
		for(int i =0; i<size; i++) {
			BoardDTO board = boardlist.get(i);
			System.out.println(board.getBoardNum()+"\t"+board.getTitle()+
					"\t"+board.getId()+board.getHit());
		}
	}
}


















