package jdbt.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//tb_board 테이블을 엑세스하는 기능이 정의된 클래스
//DAO: Data Access Object
public class BoardDAOImpl implements BoardDAO{
	public int insert(BoardDTO board) {
		System.out.println("DTO 사용 메서드"+board); //장점: 오류 확인하기 편함. 
		Connection con = null; 
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into tb_board "); 
		sql.append("values(board_seq.nextval,?,?,?,sysdate,0)");
		int result = 0;//메소드 실행 결과가 저장될 변수
		//이게 prepared 동적 SQL
		try {
			con = DBUtil.getConnect();//DBMS 연결
			System.out.println("연결성공 "+con);
			//1. preparedStatement 생성
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			//2. ?에 값 전달
			ptmt.setString(1, board.getId());
			ptmt.setString(2, board.getTitle());
			ptmt.setString(3, board.getContent());
			//3. 실행하기
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공");
		}catch(SQLException e) {
			System.out.println("연결 실패 "+e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int delete(int boardnum) {
		Connection con =null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from tb_board "); 
		sql.append("where boardnum = ?");	
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("연결성공 "+con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			ptmt.setInt(1, boardnum);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제성공");
		}catch(SQLException e) {
			System.out.println("연결 실패 "+e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into tb_board "); 
		sql.append("values(board_seq.nextval,?,?,?,sysdate,0)");
		int result = 0;//메소드 실행 결과가 저장될 변수
		//이게 prepared 동적 SQL
		try {
			con = DBUtil.getConnect();//DBMS 연결
			System.out.println("연결성공 "+con);
			//1. preparedStatement 생성
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			//2. ?에 값 전달
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			result = ptmt.executeUpdate();
			//3. 실행하기
			System.out.println(result+"개 행 삽입성공");
		}catch(SQLException e) {
			System.out.println("연결 실패 "+e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public int update(int boardnum, String id) {
		Connection con = null;
		PreparedStatement ptmt =null;
		String sql = "update tb_board set id = ? where boardnum = ? ";		
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("연결성공 "+con);
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			ptmt.setInt(2, boardnum);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 수정성공");
		}catch(SQLException e) {
			System.out.println("연결 실패 "+e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	//조회한 결과를 ArrayList로 변환하여 리턴
	public ArrayList<BoardDTO> select() {
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();//전체 게시글을 담을 그릇
		BoardDTO board = null; //조회한 글을 담을 객체. 타입만 명시
							// 객체를 생성하지 않고 null로 초기화한 이유는 
							//데이터를 조회하는 작업을 하는 곳이 while문 내부이므로
							//while문에서 객체를 생성
		String sql = "select * from tb_board";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) { //레코드를 조회하기 위해서는
				//1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				board = new BoardDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4),  rs.getDate(5), 
						rs.getInt(6));
				
				boardlist.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return boardlist;
	}

	@Override
	public BoardDTO read(int boardnum) {
		String sql = "select * from tb_board where boardnum=?";
		BoardDTO board = null; //조회한 글을 담을 객체. 타입만 명시
							// 객체를 생성하지 않고 null로 초기화한 이유는 
							//데이터를 조회하는 작업을 하는 곳이 while문 내부이므로
							//while문에서 객체를 생성
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, boardnum);
			rs = ptmt.executeQuery();
			if(rs.next()) { //레코드를 조회하기 위해서는
				//1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				board = new BoardDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4),  rs.getDate(5), 
						rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return board;
	}

	@Override
	public ArrayList<BoardDTO> findbyTitle(String title) {
		String sql =
				"select * from tb_board where title like ?";
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, "%"+title+"%");
			rs = ptmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4),  rs.getDate(5), 
						rs.getInt(6));
				//System.out.println(board);
				boardlist.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		
		return boardlist;
	}

}
