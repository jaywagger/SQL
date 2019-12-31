package jdbt.board.exam;
import java.util.Scanner;

public class DAOTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("******�Խ���********");
		System.out.println("1. �Խñ۵��");
		System.out.println("2. �Խñ���ü�����ȸ");
		System.out.println("3. �Խñۼ���");
		System.out.println("4. �Խñۻ���");
		System.out.println("5. �������� �Խñ� �˻�");
		System.out.println("6. �Խñ� �󼼺���");
		System.out.print("���ϴ� �۾��� �����ϼ���:");
		int choice  = key.nextInt();
		show(choice);
	}
	public static void show(int choice){
		MenuUI ui = new MenuUI();//�޴� ��ü�� �����ϰ� ���� ui�� �־��� ������
		switch(choice){
			case 1: //1. �Խñ۵��
				ui.insertMenu();	//�̷��� Ŭ������ �޼��带 �θ� �� �ִ�.
				break;
			case 2: //2. �Խñ���ü�����ȸ
				ui.selectMenu();
				break;
			case 3: //3. �Խñۼ���
				ui.updateMenu();
				break;
			case 4: //4. �Խñۻ���
				ui.deleteMenu();
				break;
			case 5: //5. �������� �Խñ� �˻�
				ui.searchMenu();
				break;
			case 6: //6. �Խñ� �󼼺���
				ui.readMenu();
				break;
		}
	}
}













