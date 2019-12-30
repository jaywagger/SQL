package API.Util;

import java.util.ArrayList;

public class ArrayListTest03 {
	//배열을 ArrayList로 변환해서 리턴하는 메소드
	public static void main(String[] args) {
		String[] arr = {"java","oracle","jdbc","htmls","css","java"};
		ArrayList<String> list = changeData(arr);
		//변환되어 리턴된 ArrayList에 저장된 값을 꺼내서 출력하기
		System.out.println("<예전방식>");
		int size = list.size(); //이러면 웹상에서  리소스를 적게쓰므로 로딩이 빨리됌
		for (int i =0; i < size; i++) {
			System.out.println(list.get(i));
		}
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("<뉴방식>");
		for (String data : list) {
			System.out.println(data);
		}
	}
	
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> list = new ArrayList<String>();
		//매개변수로 전달된 배열에서 데이터를 꺼내서 ArrayList에 저장하는 코드
		for (int i =0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}


}
