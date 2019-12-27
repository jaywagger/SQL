package jdbt.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//드라이버 로딩은 클래스가 로딩될 떄 같이 로딩되도록 처리
	//static {}안의 명령문은 클래스가 로딩될 떄 한 번만 실행되는 코드
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//2. 커넥션하기 - DBMS와 접속 후에 접속정보를 저장하고 있는 Connection을 리턴
	public static Connection getConnect() throws SQLException {
		Connection con = null;
		String url ="jdbc:oracle:thin:@70.12.115.61:1521:xe";
		String user = "scott";
		String password = "tiger";
		con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	//3 자원반납 -ResultSet, Statement, Connection 객체 사용을 해제
	//				=> 각각의 객체를 해제할 수 있도록 메소드를 정의해도 좋음
	public static void close(Statement ptmt, Connection con) {
			try{ //자원반납
				if (ptmt!=null) ptmt.close();
				if (con!=null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	} 
}

