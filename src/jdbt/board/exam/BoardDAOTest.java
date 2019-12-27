package jdbt.board.exam;

import java.util.Scanner;
public class BoardDAOTest {
	
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("�Ʒ� ��ȣ�� �����ϼ���: ");
		System.out.println("1�� ��ȸ");
		System.out.println("2�� ����");
		System.out.println("3�� ������Ʈ");
		System.out.println("4�� ����");
		int num = key.nextInt();
		BoardDAOImpl dao = new BoardDAOImpl ();
		
		switch (num) 
		{
			case 1: 
				//1.Select
				System.out.println("*********�Խù� ��ȸ***********");
				dao.select();
				break; 
					   
			case 2:
				//2.Insert
				
				System.out.println("*********�Խù� ���***********");
				System.out.println("���̵�: ");
				String id =key.next();
				System.out.println("����: ");
				String title =key.next();
				System.out.println("����: ");
				String content =key.next();
				dao.insert(id, title, content);
				break;
				
			case 3:
				//3. Update
				System.out.println("*********�Խù� ����***********");
				System.out.println("��ȣ: ");
				int boardnum =key.nextInt();
				System.out.println("���̵�: ");
				String id1 =key.next();
				dao.update(boardnum, id1);
				break;
			case 4:
				//4. Delete
				System.out.println("*********�Խù� ����***********");
				System.out.println("��ȣ: ");
				int boardnum1 =key.nextInt();
				dao.delete(boardnum1);
				break;
			default: 
				System.out.println("�߸��Է�");		
		}
		
		
		
		
		
		
		
		
	}

}
