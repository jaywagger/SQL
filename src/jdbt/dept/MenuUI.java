package jdbt.dept;

import java.util.ArrayList;
import java.util.Scanner;

import jdbt.dept.DeptDAO;
import jdbt.dept.DeptDAOImpl;
import jdbt.dept.DeptDTO;

public class MenuUI {
	Scanner key = new Scanner(System.in);

	int number =0;
	
	DeptDAO dao = new DeptDAOImpl();//�� ���� ���÷� ��ü ����? ������ �� ���ÿ� �־?

	
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
		DeptDTO dept = new DeptDTO(id,title,content);
		int result = dao.insert(dept);
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
		int deptNum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(deptNum, id);
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
		int deptNum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(deptNum);
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
		System.out.println("*******�Խñۻ���ȸ********");
		System.out.print("�۹�ȣ:");
		int deptnum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		DeptDTO dept = dao.read(deptnum);
		if(dept==null)
		{
			System.out.println("��ȸ�� �����Ͱ� �����ϴ�.");
		}else {
		System.out.println("�۹�ȣ:"+dept.getDeptNum());
		System.out.println("����:"+dept.getTitle());
		System.out.println("�ۼ���:"+dept.getId());
		System.out.println("����:"+dept.getContent());
		System.out.println("�ۼ���¥:"+dept.getWriteDate());
		System.out.println("��ȸ��:"+dept.getHit());
		}
		
	}
	
	
	public void selectMenu(){
		System.out.println("*******�Խñ���ȸ********");
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
		ArrayList<DeptDTO> deptlist = dao.select();
		int size = deptlist.size();
		for(int i =0; i<size; i++) {
			DeptDTO dept = deptlist.get(i);
			System.out.println(dept.getDeptNum()+"\t"+dept.getTitle()+
					"\t"+dept.getId()+dept.getHit());
		}
	}
}


















