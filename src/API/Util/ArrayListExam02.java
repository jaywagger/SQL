package API.Util;

import java.util.ArrayList;

public class ArrayListExam02 {
	public static void main(String[]args) {
	/*	번호	성명	자바	웹	android
		1	장동건	97	100	88	=	StudentDTO
		2	이민호	100	92	91
		3 	류준열	88	96	78
		데이터 타입이 int, String 등 다르다
		그러므로 배열이 담을 수 없다. for문 여러개를 사용해야 한다.
		그래서 DTO를 이용한다. Data를 Transfer해서  object에 담겠다.
	*
	*
	*/	
		//ArrayList에 데이터 저장하기
		ArrayList<StudentDTO> stdlist = new ArrayList<StudentDTO>();
		StudentDTO std1 = new StudentDTO(1,"장동건",97,100,88);
		StudentDTO std2 = new StudentDTO(2,"이민호",100,92,91);
		StudentDTO std3 = new StudentDTO(3,"류준열",88,96,78);
		
		stdlist.add(std1);
		stdlist.add(std2);
		stdlist.add(std3);
		
	display(stdlist);
		
	}
	public static void display(ArrayList<StudentDTO> stdlist) {
		int size = stdlist.size();
		for(int i=0; i<size;i++) {
			/*StudentDTO std = stdlist.get(i);
			System.out.println("번호"+std.getNum());
			System.out.println("성명"+std.getName());
			System.out.println("자바"+std.getJava());
			System.out.println("웹"+std.getWeb());
			System.out.println("안드로이드"+std.getAndroid());*/
			
			StudentDTO std = stdlist.get(i);
			System.out.println(std);
		}
	}
}
