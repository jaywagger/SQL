package jdbt.dept;

import java.util.ArrayList;
import jdbt.dept.DeptDTO;

public interface DeptDAO {
	//public�� �����Ѵ�. Interface ��ü�� public abstract�̴� 
	int insert(DeptDTO dept); //�Խñ� ��� C
	int insert(String id, String title, String content); //�Խñ� ��� C
	int update(int deptdnum, String id); //�Խñ� ���� U
	int delete(int deptdnum); //�Խñ� ���� D
	ArrayList<DeptDTO> select(); //��ü �Խñ� ��ȸ L
	DeptDTO read(int deptdnum); //�Խñ���ȸ R. 1���� ��ȸ
	//����� 1���� BoardDTO�� ����. 
	ArrayList<DeptDTO> findbyTitle(String title); //�Խñ� �˻� List �ֳĸ� ������ �Խù��� �˻��� �� ����. ArrayList ��������
	
}
