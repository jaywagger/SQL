package jdbt.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//updateTest.java를 rename해서 작업
//sql문만 delete로 변경해서 실행해보기
//      -------
//       3번 boardnum의 게시물 삭제
//출력 형태
//1개 행이 삭제됐습니다.
public class DeleteTest {
	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@70.12.115.61:1521:xe";
		String user = "scott";
		String password = "tiger";
//		String sql = "delete from tb_board where boardnum >20";	
		StringBuffer sql = new StringBuffer();
		sql.append("delete from tb_board "); //맨뒤에 띄어씍 해야 한다.
		sql.append("where boardnum =3");	
		
		try {
			//1. 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
							
			System.out.println("드라이버 로딩 성공");
			//2. DBMS에 연결하기 - 연결정보를 정의
			Connection con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("연결성공 "+con);
			//3. SQL을 실행하기 위한 객체를 생성 - 연결정보의 연결시켜야 하므로
			//							Connection 객체를 이용해서 생성
			Statement stmt = con.createStatement();
			System.out.println("SQL을 실행하기 위한 객체정보:"+stmt);
			
			//4. SQL실행하기
			int result = stmt.executeUpdate(sql.toString());
			//5. 결과처리하기
			System.out.println(result+"개 행 삭제성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("연결 실패 "+e.getMessage());
			e.printStackTrace();
		}
	}

}
