package jdbt.board.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//tb_board ���̺��� �������ϴ� ����� ���ǵ� Ŭ����
//DAO: Data Access Object
public class BoardDAOImpl implements BoardDAO{
	public int insert(BoardDTO board) {
		System.out.println("DTO ��� �޼���"+board); //����: ���� Ȯ���ϱ� ����. 
		Connection con = null; 
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into tb_board "); 
		sql.append("values(board_seq.nextval,?,?,?,sysdate,0)");
		int result = 0;//�޼ҵ� ���� ����� ����� ����
		//�̰� prepared ���� SQL
		try {
			con = DBUtil.getConnect();//DBMS ����
			System.out.println("���Ἲ�� "+con);
			//1. preparedStatement ����
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			//2. ?�� �� ����
			ptmt.setString(1, board.getId());
			ptmt.setString(2, board.getTitle());
			ptmt.setString(3, board.getContent());
			//3. �����ϱ�
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ���Լ���");
		}catch(SQLException e) {
			System.out.println("���� ���� "+e.getMessage());
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
			System.out.println("���Ἲ�� "+con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			ptmt.setInt(1, boardnum);
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ��������");
		}catch(SQLException e) {
			System.out.println("���� ���� "+e.getMessage());
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
		int result = 0;//�޼ҵ� ���� ����� ����� ����
		//�̰� prepared ���� SQL
		try {
			con = DBUtil.getConnect();//DBMS ����
			System.out.println("���Ἲ�� "+con);
			//1. preparedStatement ����
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			//2. ?�� �� ����
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			result = ptmt.executeUpdate();
			//3. �����ϱ�
			System.out.println(result+"�� �� ���Լ���");
		}catch(SQLException e) {
			System.out.println("���� ���� "+e.getMessage());
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
			System.out.println("���Ἲ�� "+con);
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			ptmt.setInt(2, boardnum);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
			System.out.println(result+"�� �� ��������");
		}catch(SQLException e) {
			System.out.println("���� ���� "+e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	public void select() {
		String sql = "select * from tb_board";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) { 
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString("content")+"\t"); 
				System.out.print(rs.getDate(5)+"\t");
				System.out.println(rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
	}

}
