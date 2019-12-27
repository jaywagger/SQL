package jdbt.customer.exam;
import java.util.Scanner;

import jdbt.customer.exam.CustomerDAO;
import jdbt.customer.exam.CustomerDAOImpl;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	CustomerDAO dao = new CustomerDAOImpl();
	
	public void insertMenu(){
		//�Ի����� sysdate, point �⺻ 100����
		System.out.println("*******������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
			
		//���⿡�� MemberDAO�� �޼ҵ带 ȣ���ϼ���
		CustomerDTO customer = new CustomerDTO(id, pass, name, addr);
		int result = dao.insert(customer);
		if(result>0) {
			System.out.println("�Խñ� ��� ����");
		}else {
			System.out.println("�Խñ� ��� ����");
		}
	}
	public void updateMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		//���⿡�� MemberDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(id, addr);
		//���ó��
		if(result>0) {
			System.out.println("������Ʈ ��� ����");
		}else {
			System.out.println("������Ʈ ��� ����");
		}
	}
	public void deleteMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		//���⿡�� MemberDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(id);
		//���ó��
		if(result>0) {
			System.out.println("�Խñ� ���� ����");
		}else {
			System.out.println("�Խñ� ���� ����");
		}
	}
	public void findByAddrMenu(){
		System.out.println("*******����˻�********");
		System.out.print("�ּ�:");
		String addr = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
	}
	
	
	public void selectMenu(){
		System.out.println("*******�����ȸ********");
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
	}
}


















