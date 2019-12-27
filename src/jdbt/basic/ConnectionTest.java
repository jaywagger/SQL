package jdbt.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//����Ŭ�� �����ϱ�
public class ConnectionTest {
	//127.0.0.1 = localhost = ���� �۾����� �� pc
	public static void main(String[] args) {
		//���Ṯ�ڿ�: � DBMS�� ����ϴ��Ŀ� ���� ������ �޶�����
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //�������ݸ�
		String url = "jdbc:oracle:thin:@70.12.115.61:1521:xe"; //1521�� ��Ʈ��ȣ
		//String url = "jdbc:oracle:thin:@70.12.115.56:1521:xe"; //���������� ����Ŭ
		//���Ӱ���
		String user = "scott";
		//������ ������ �н�����
		String password = "tiger";
		//1. ����Ŭ ����̹� �ε�. JVM �޸𸮿� �ε�
		//�ٽ� Ŭ���� forname �̿�
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����");
		//2. DBMS�� �����ϱ� - ���� ������ �����ؾ� ��.
		// ==> 
		Connection con = 
				DriverManager.getConnection(url,user,password);
		
		System.out.println("���Ἲ�� "+con);
		//3. sql �� �����ϱ� ���� ��ü�� ���� - ��������
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("���� ���� "+e.getMessage());
		}
		
	}

}
