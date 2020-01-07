package jdbt.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbt.dept.DeptDAO;
import jdbt.dept.DeptDTO;
import jdbt.dept.DBUtil;

public class DeptDAOImpl implements DeptDAO{
	public int insert(DeptDTO dept) {
		System.out.println("DTO 사용 메서드"+dept); //장점: 오류 확인하기 편함. 
		Connection con = null; 
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into dept "); 
		sql.append("values(dept_seq.nextval,?,?,?,sysdate,0)");
		int result = 0;//메소드 실행 결과가 저장될 변수
		//이게 prepared 동적 SQL
		try {
			con = DBUtil.getConnect();//DBMS 연결
			System.out.println("연결성공 "+con);
			//1. preparedStatement 생성
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			//2. ?에 값 전달
			ptmt.setString(1, dept.getId());
			ptmt.setString(2, dept.getTitle());
			ptmt.setString(3, dept.getContent());
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
	
	public int delete(int deptnum) {
		Connection con =null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from dept "); 
		sql.append("where deptnum = ?");	
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("연결성공 "+con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			ptmt.setInt(1, deptnum);
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
		sql.append("insert into dept "); 
		sql.append("values(dept_seq.nextval,?,?,?,sysdate,0)");
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
	
	public int update(int deptnum, String id) {
		Connection con = null;
		PreparedStatement ptmt =null;
		String sql = "update dept set id = ? where deptnum = ? ";		
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("연결성공 "+con);
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			ptmt.setInt(2, deptnum);
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
	public ArrayList<DeptDTO> select() {
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();//전체 게시글을 담을 그릇
		DeptDTO dept = null; //조회한 글을 담을 객체. 타입만 명시
							// 객체를 생성하지 않고 null로 초기화한 이유는 
							//데이터를 조회하는 작업을 하는 곳이 while문 내부이므로
							//while문에서 객체를 생성
		String sql = "select * from dept";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) { //레코드를 조회하기 위해서는
				//1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				dept = new DeptDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4),  rs.getDate(5), 
						rs.getInt(6));
				
				deptlist.add(dept);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return deptlist;
	}

	@Override
	public DeptDTO read(int deptnum) {
		String sql = "select * from dept where deptnum=?";
		DeptDTO dept = null; //조회한 글을 담을 객체. 타입만 명시
							// 객체를 생성하지 않고 null로 초기화한 이유는 
							//데이터를 조회하는 작업을 하는 곳이 while문 내부이므로
							//while문에서 객체를 생성
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, deptnum);
			rs = ptmt.executeQuery();
			if(rs.next()) { //레코드를 조회하기 위해서는
				//1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				dept = new DeptDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4),  rs.getDate(5), 
						rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return dept;
	}

	@Override
	public ArrayList<DeptDTO> findbyTitle(String title) {
		String sql =
				"select * from tb_board where title like ?";
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		DeptDTO dept = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, "%"+title+"%");
			rs = ptmt.executeQuery();
			while(rs.next()) {
				dept = new DeptDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4),  rs.getDate(5), 
						rs.getInt(6));
				//System.out.println(board);
				deptlist.add(dept);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		
		return deptlist;
	}

}
