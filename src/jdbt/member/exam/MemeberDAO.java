package jdbt.member.exam;

import java.util.ArrayList;

public interface MemeberDAO {
	//1. ������, 3. �������, 4. ������ �۵�
		int insert(MemberDTO member);//������
		//int insert(String id, String password, String name, String addr, String deptno);
		int update(String id, String addr);//�������
		int delete(String id);//���Ż��
		ArrayList<MemberDTO> memberList();//��ü ������ ��ȸ
		
		ArrayList<MemberDTO> findByAddr(String addr);//�ּҷ� �˻�
		MemberDTO login(String id, String pass); //�α���
}
