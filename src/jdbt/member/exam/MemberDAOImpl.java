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
		System.out.println("DTO ��� �޼���" + member); // ����: ���� Ȯ���ϱ� ����.
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member ");
		sql.append("values(?,?,?,?,?,sysdate,1000)");
		int result = 0;// �޼ҵ� ���� ����� ����� ����
		// �̰� prepared ���� SQL
		try {
			con = DBUtil.getConnect();// DBMS ����
			System.out.println("���Ἲ�� " + con);
			// 1. preparedStatement ����
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:" + ptmt);
			// 2. ?�� �� ����
			ptmt.setString(1, member.getId());
			ptmt.setString(2, member.getPassword());
			ptmt.setString(3, member.getName());
			ptmt.setString(4, member.getAddr());
			ptmt.setString(5, member.getDeptno());
			// 3. �����ϱ�
			result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ���Լ���");
		} catch (SQLException e) {
			System.out.println("���� ���� " + e.getMessage());
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
			System.out.println("���Ἲ�� " + con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:" + ptmt);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
		} catch (SQLException e) {
			System.out.println("���� ���� " + e.getMessage());
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
			System.out.println("���Ἲ�� " + con);
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL�� �����ϱ� ���� ��ü����:" + ptmt);
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			result = ptmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
		} catch (SQLException e) {
			System.out.println("���� ���� " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBUtil.close(ptmt, con);
		}
		return result;

	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;//��ȸ�� ���� ���� ��ü. Ÿ�Ը� ���
		String sql = "select * from member";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) { //���ڵ带 ��ȸ�ϱ� ���ؼ���
				//1. ��ȸ�� ���ڵ��� �÷��� �о DTO�� ��ȯ�ϴ� �۾�
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
