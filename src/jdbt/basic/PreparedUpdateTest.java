package jdbt.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//���� �ڵ��ؼ� �۾��ϱ�
//2�� boardnum�� id�� kang���� ����
public class PreparedUpdateTest {
public static void main(String[] args) {
	Scanner key = new Scanner(System.in);
	PreparedUpdateTest obj = new PreparedUpdateTest();
	System.out.println("*********�Խù� ����***********");
	System.out.println("��ȣ: ");
	int boardnum =key.nextInt();
	System.out.println("���̵�: ");
	String id =key.next();
	obj.update(boardnum, id);
	}
	
	public void update(int boardnum, String id) {
		String url ="jdbc:oracle:thin:@70.12.115.61:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt =null;
		
		
		String sql = "update tb_board set id = ? where boardnum = ? ";		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
			con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("���Ἲ�� "+con);
			ptmt = con.prepareStatement(sql);
			
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			ptmt.setInt(2, boardnum);
			ptmt.setString(1, id);
			
			int result = ptmt.executeUpdate();
			
			System.out.println(result+"�� �� ��������");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("���� ���� "+e.getMessage());
			e.printStackTrace();
		}finally {//exception�� �߻��ϴ� ���� �ʴ� ������ ������ ��ɹ��� �����Ѵ�
			
			try{ //�ڿ��ݳ�
				if (ptmt!=null) ptmt.close();
				if (con!=null) con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
