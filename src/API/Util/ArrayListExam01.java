package API.Util;

import java.util.ArrayList;

public class ArrayListExam01 {
	public static void main(String[] args) {
		//79,55,100,98,99을 ArrayList에 담고 총점과 평균을 출력하세요
		//[출력형태]
		//총점:
		//평균:
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(79);
		list.add(55);
		list.add(100);
		list.add(98);
		list.add(99);
		
		double sum = 0;
		for (int i =0; i<list.size(); i++) {
			sum += list.get(i);   //list.get(i) 하나씩 꺼내본다
		} System.out.println("총점: "+sum);
		
		double avg = sum/list.size();
		System.out.println("평균: "+avg);
		
		
	}

}
