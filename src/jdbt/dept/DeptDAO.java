package jdbt.dept;

import java.util.ArrayList;
import jdbt.dept.DeptDTO;

public interface DeptDAO {
	//public은 생략한다. Interface 자체가 public abstract이다 
	int insert(DeptDTO dept); //게시글 등록 C
	int insert(String id, String title, String content); //게시글 등록 C
	int update(int deptdnum, String id); //게시글 수정 U
	int delete(int deptdnum); //게시글 삭제 D
	ArrayList<DeptDTO> select(); //전체 게시글 조회 L
	DeptDTO read(int deptdnum); //게시글조회 R. 1개만 조회
	//결과가 1개라 BoardDTO에 넣음. 
	ArrayList<DeptDTO> findbyTitle(String title); //게시글 검색 List 왜냐면 여러게 게시물이 검색될 수 있음. ArrayList 형식으로
	
}
