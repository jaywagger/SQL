package jdbt.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//���� �ڵ��ؼ� �۾��ϱ�
//2�� boardnum�� id�� kang���� ����
public class UpdateTest {
	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@70.12.115.61:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "update tb_board set id ='Kang' where boardnum ='2'";		
		try {
			//1. ����Ŭ ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
							
			System.out.println("����̹� �ε� ����");
			//2. DBMS�� �����ϱ� - ���������� ����
			Connection con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("���Ἲ�� "+con);
			//3. SQL�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ�
			//							Connection ��ü�� �̿��ؼ� ����
			Statement stmt = con.createStatement();
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+stmt);
			
			//4. SQL�����ϱ�
			int result = stmt.executeUpdate(sql);
			//5. ���ó���ϱ�
			System.out.println(result+"�� �� ��������");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("���� ���� "+e.getMessage());
			e.printStackTrace();
		}
	}

}
