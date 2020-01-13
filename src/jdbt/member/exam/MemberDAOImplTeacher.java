package jdbt.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbt.member.exam.MemberDTO;
import jdbt.board.exam.BoardDTO;
import jdbt.member.exam.DBUtil;

public class MemberDAOImpl implements MemeberDAO {
	
	public int insert(MemberDTO member) {
		System.out.println("DTO 사용 메서드" + member); // 장점: 오류 확인하기 편함.
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member ");
		sql.append("values(?,?,?,?,?,sysdate,1000)");
		int result = 0;// 메소드 실행 결과가 저장될 변수
		// 이게 prepared 동적 SQL
		try {
			con = DBUtil.getConnect();// DBMS 연결
			System.out.println("연결성공 " + con);
			// 1. preparedStatement 생성
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:" + ptmt);
			// 2. ?에 값 전달
			ptmt.setString(1, member.getId());
			ptmt.setString(2, member.getPassword());
			ptmt.setString(3, member.getName());
			ptmt.setString(4, member.getAddr());
			ptmt.setString(5, member.getDeptno());
			// 3. 실행하기
			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삽입성공");
		} catch (SQLException e) {
			System.out.println("연결 실패 " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(ptmt, con);
		}
		return result;
	}

	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from member ");
		sql.append("where id = ?");
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("연결성공 " + con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:" + ptmt);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공");
		} catch (SQLException e) {
			System.out.println("연결 실패 " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(ptmt, con);
		}
		return result;
	}

	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "update member set addr = ? where id = ? ";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("연결성공 " + con);
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL을 실행하기 위한 객체정보:" + ptmt);
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 수정성공");
		} catch (SQLException e) {
			System.out.println("연결 실패 " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(ptmt, con);
		}
		return result;

	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;//조회한 글을 담을 객체. 타입만 명시
		String sql = "select * from member";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) { //레코드를 조회하기 위해서는
				//1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				member = new MemberDTO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5));
				memberlist.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(ptmt, con);
		}
		return memberlist;
	}

	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		String sql =
				"select * from member where addr like ?";
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, "%"+addr+"%");
			rs = ptmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5));
				memberlist.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(ptmt, con);
		}
		
		return memberlist;
	}

	@Override
	public MemberDTO login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
