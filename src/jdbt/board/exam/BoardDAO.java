package jdbt.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	//public은 생략한다. Interface 자체가 public abstract이다 
	int insert(BoardDTO board); //게시글 등록 C
	int insert(String id, String title, String content); //게시글 등록 C
	int update(int boardnum, String id); //게시글 수정 U
	int delete(int boardnum); //게시글 삭제 D
	ArrayList<BoardDTO> select(); //전체 게시글 조회 L
	
	BoardDTO read(int boardnum); //게시글조회 R. 1개만 조회
	//결과가 1개라 BoardDTO에 넣음. 
	ArrayList<BoardDTO> findbyTitle(String title); //게시글 검색 List 왜냐면 여러게 게시물이 검색될 수 있음. ArrayList 형식으로
	
	
}
