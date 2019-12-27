package jdbt.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//오라클에 접속하기
public class ConnectionTest {
	//127.0.0.1 = localhost = 현재 작업중인 내 pc
	public static void main(String[] args) {
		//연결문자열: 어떤 DBMS를 사용하느냐에 따라 형식이 달라진자
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //프로토콜명
		String url = "jdbc:oracle:thin:@70.12.115.61:1521:xe"; //1521은 포트번호
		//String url = "jdbc:oracle:thin:@70.12.115.56:1521:xe"; //정윤이형꺼 오라클
		//접속계정
		String user = "scott";
		//접속할 계정의 패스워드
		String password = "tiger";
		//1. 오라클 드라이버 로딩. JVM 메모리에 로딩
		//핵심 클래스 forname 이용
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공");
		//2. DBMS에 연결하기 - 연결 정보를 정의해야 함.
		// ==> 
		Connection con = 
				DriverManager.getConnection(url,user,password);
		
		System.out.println("연결성공 "+con);
		//3. sql 을 싱행하기 위한 객체를 생성 - 연결정보
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("연결 실패 "+e.getMessage());
		}
		
	}

}
