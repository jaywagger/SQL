package jdbt.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
