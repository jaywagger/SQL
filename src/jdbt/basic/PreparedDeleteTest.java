package jdbt.basic;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDeleteTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedDeleteTest obj = new PreparedDeleteTest();
		System.out.println("*********�Խù� ����***********");
		System.out.println("��ȣ: ");
		int boardnum =key.nextInt();
		obj.delete(boardnum);
		
	}

	public void delete(int boardnum) {
		String url ="jdbc:oracle:thin:@70.12.115.61:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con =null;
		PreparedStatement ptmt = null;
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete from tb_board "); 
		sql.append("where boardnum = ?");	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
			con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("���Ἲ�� "+con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			
			ptmt.setInt(1, boardnum);
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
