package jdbt.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseTest {
	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@70.12.115.61:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "select * from tb_board";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
			stmt = con.createStatement();
			//select문 실행
			rs = stmt.executeQuery(sql);
			//System.out.println("rs: "+rs);
			//ResultSet에 레코드가 존재하는 동안 반복문을 실횅한다.
			while(rs.next()) { //레코드를 조회하기 위해서는
								//레코드가 한 개라도 반드시 커서를 이동 시켜야한다.
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString("content")+"\t"); //인텍스대신 타이틀 기재 가능
				System.out.print(rs.getDate(5)+"\t");
				System.out.println(rs.getInt(6));
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {//exception이 발생하던 하지 않던 무족건 실행할 명령문을 정의한다
			
			//rs try안에 지역변수도 선언되었음 그래서 다시 try밖에서 재선언한다.
			try{ //자원반납
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
				if (con!=null) con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
	}

}
