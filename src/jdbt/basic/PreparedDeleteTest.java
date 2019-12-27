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
		System.out.println("*********게시물 삭제***********");
		System.out.println("번호: ");
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
			System.out.println("드라이버 로딩 성공");
			con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("연결성공 "+con);
			ptmt = con.prepareStatement(sql.toString());
			System.out.println("SQL을 실행하기 위한 객체정보:"+ptmt);
			
			ptmt.setInt(1, boardnum);
			int result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제성공");
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
