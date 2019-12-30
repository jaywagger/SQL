package API.Util;

import java.util.ArrayList;
//Collection에 저장할 요소의 타입을 generic 형태로 정의한다.
//Collection 클래스<데이터타입> <<< 이게 generic
//ex. ArrayList <String>
public class ArrayListTest02 {
	public static void main(String[] args) {
		//String[] arr = new String[5]
		ArrayList<String> list = new ArrayList<String>();
		list.add("자바");			//arr[0] = "자바"
		list.add("오라클");
		list.add("JDBC");
		list.add("HTMLS");
		list.add("CSS");
		
		System.out.println("=============================");
		for(int i =0; i<list.size();i++) { //arr.length
			System.out.println(list.get(i)); // arr[i]
		}
	}

}
