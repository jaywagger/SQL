package jdbt.basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedInsertTest {
	
public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("*********�Խù� ���***********");
		System.out.println("���̵�: ");
		String id =key.next();
		System.out.println("����: ");
		String title =key.next();
		System.out.println("����: ");
		String content =key.next();
		
		obj.insert(id, title, content);
	}
	
	public void insert(String id, String title, String content) {
		String url ="jdbc:oracle:thin:@70.12.115.61:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement ptmt = null;
		/*String sql 
		= "insert into tb_board values(board_seq.nextval,'"+
		id+"','"+title+"','" + content+ "','"+"'sysdate,0)";*/
		//statement ���� SQL
		
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		//�̰� prepared ���� SQL
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
			con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("���Ἲ�� "+con);
			//1. preparedStatement ����
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+ptmt);
			//2. ?�� �� ����
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			int result = ptmt.executeUpdate();
			//3. �����ϱ�
			System.out.println(result+"�� �� ���Լ���");
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
