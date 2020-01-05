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
		System.out.println("DTO ��� �޼���"+dept); //����: ���� Ȯ���ϱ� ����. 
		Connection con = null; 
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into dept "); 
		sql.append("values(dept_seq.nextval,?,?,?,sysdate,0)");
		int result = 0;//�޼ҵ� ���� ����� ����� ����
		//�̰� prepared ���� SQL
		try {
			con = DBUtil.getConnect();//DBMS ����
			System.out.println("���Ἲ�� "+con);
			//1. preparedStatement ����
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			//2. ?�� �� ����
			ptmt.setString(1, dept.getId());
			ptmt.setString(2, dept.getTitle());
			ptmt.setString(3, dept.getContent());
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
	
	public int delete(int deptnum) {
		Connection con =null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from dept "); 
		sql.append("where deptnum = ?");	
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("���Ἲ�� "+con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			ptmt.setInt(1, deptnum);
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
		sql.append("insert into dept "); 
		sql.append("values(dept_seq.nextval,?,?,?,sysdate,0)");
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
	
	public int update(int deptnum, String id) {
		Connection con = null;
		PreparedStatement ptmt =null;
		String sql = "update dept set id = ? where deptnum = ? ";		
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("���Ἲ�� "+con);
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			ptmt.setInt(2, deptnum);
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
	//��ȸ�� ����� ArrayList�� ��ȯ�Ͽ� ����
	public ArrayList<DeptDTO> select() {
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();//��ü �Խñ��� ���� �׸�
		DeptDTO dept = null; //��ȸ�� ���� ���� ��ü. Ÿ�Ը� ���
							// ��ü�� �������� �ʰ� null�� �ʱ�ȭ�� ������ 
							//�����͸� ��ȸ�ϴ� �۾��� �ϴ� ���� while�� �����̹Ƿ�
							//while������ ��ü�� ����
		String sql = "select * from dept";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) { //���ڵ带 ��ȸ�ϱ� ���ؼ���
				//1. ��ȸ�� ���ڵ��� �÷��� �о DTO�� ��ȯ�ϴ� �۾�
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
		DeptDTO dept = null; //��ȸ�� ���� ���� ��ü. Ÿ�Ը� ���
							// ��ü�� �������� �ʰ� null�� �ʱ�ȭ�� ������ 
							//�����͸� ��ȸ�ϴ� �۾��� �ϴ� ���� while�� �����̹Ƿ�
							//while������ ��ü�� ����
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, deptnum);
			rs = ptmt.executeQuery();
			if(rs.next()) { //���ڵ带 ��ȸ�ϱ� ���ؼ���
				//1. ��ȸ�� ���ڵ��� �÷��� �о DTO�� ��ȯ�ϴ� �۾�
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
