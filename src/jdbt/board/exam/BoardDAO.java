package jdbt.board.exam;

public interface BoardDAO {
	//public�� �����Ѵ�. Interface ��ü�� public abstract�̴� 
	int insert(BoardDTO board);
	int insert(String id, String title, String content);
	int update(int boardnum, String id);
	int delete(int boardnum);
	void select();
}
