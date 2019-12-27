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
		System.out.println("*********게시물 등록***********");
		System.out.println("아이디: ");
		String id =key.next();
		System.out.println("제목: ");
		String title =key.next();
		System.out.println("내용: ");
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
		//statement 동적 SQL
		
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		//이게 prepared 동적 SQL
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("연결성공 "+con);
			//1. preparedStatement 생성
			ptmt = con.prepareStatement(sql);
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			//2. ?에 값 전달
			ptmt.setString(1, id);
			ptmt.setString(2, title);
			ptmt.setString(3, content);
			int result = ptmt.executeUpdate();
			//3. 실행하기
			System.out.println(result+"개 행 삽입성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("연결 실패 "+e.getMessage());
			e.printStackTrace();
		}finally {//exception이 발생하던 하지 않던 무족건 실행할 명령문을 정의한다
			
			try{ //자원반납
				if (ptmt!=null) ptmt.close();
				if (con!=null) con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
