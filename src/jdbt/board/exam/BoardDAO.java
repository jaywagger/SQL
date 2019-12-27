package jdbt.board.exam;

public interface BoardDAO {
	//public은 생략한다. Interface 자체가 public abstract이다 
	int insert(BoardDTO board);
	int insert(String id, String title, String content);
	int update(int boardnum, String id);
	int delete(int boardnum);
	void select();
}
