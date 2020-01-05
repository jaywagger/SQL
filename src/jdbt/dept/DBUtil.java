package jdbt.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//����̹� �ε��� Ŭ������ �ε��� �� ���� �ε��ǵ��� ó��
	//static {}���� ��ɹ��� Ŭ������ �ε��� �� �� ���� ����Ǵ� �ڵ�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}
	}
	
	//2. Ŀ�ؼ��ϱ� - DBMS�� ���� �Ŀ� ���������� �����ϰ� �ִ� Connection�� ����
	public static Connection getConnect() throws SQLException {
		Connection con = null;
		String url ="jdbc:oracle:thin:@70.12.224.100:1521:xe";
		String user = "scott";
		String password = "tiger";
		con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	//3 �ڿ��ݳ� -ResultSet, Statement, Connection ��ü ����� ����
	//				=> ������ ��ü�� ������ �� �ֵ��� �޼ҵ带 �����ص� ����
	public static void close(ResultSet rs, Statement ptmt, Connection con) {
			try{ //�ڿ��ݳ�
				if (rs!=null) rs.close();
				if (ptmt!=null) ptmt.close();
				if (con!=null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	} 
}
