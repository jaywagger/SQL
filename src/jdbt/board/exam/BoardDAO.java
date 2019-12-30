package jdbt.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	//public�� �����Ѵ�. Interface ��ü�� public abstract�̴� 
	int insert(BoardDTO board); //�Խñ� ��� C
	int insert(String id, String title, String content); //�Խñ� ��� C
	int update(int boardnum, String id); //�Խñ� ���� U
	int delete(int boardnum); //�Խñ� ���� D
	ArrayList<BoardDTO> select(); //��ü �Խñ� ��ȸ L
	
	BoardDTO read(int boardnum); //�Խñ���ȸ R. 1���� ��ȸ
	//����� 1���� BoardDTO�� ����. 
	ArrayList<BoardDTO> findbyTitle(String title); //�Խñ� �˻� List �ֳĸ� ������ �Խù��� �˻��� �� ����. ArrayList ��������
	
	
}
