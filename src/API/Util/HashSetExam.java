package API.Util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {
	public static void main(String[] args) {
		//다음과 같은 변수명으로 HashSet객체 2개 작성하기
		//set1 => 1부터 10까지의 정수
		HashSet<Integer> set1 = new HashSet<>();
		for(int i =1; i<=10;i++) {
			set1.add(i);
		}		
		print(set1,"set1");

		System.out.println();
		
		//set2 => 5부터 15까지의 정수
		HashSet<Integer> set2 = new HashSet<>();
		for(int i =5; i<=15;i++) {
			set2.add(i);
		}		
		print(set2,"set2");
		
		//set1과set2의 합집합 출력
		HashSet<Integer> setall = new HashSet<>(set1);
		for(int i =5; i<=15;i++) {
			setall.add(i);
		}		
		print(setall,"set2");

		//set1과 set2 교집합 출력하기
		set1.retainAll(set2);
		print(set1,"교집합set");
	
	}
	//set에 저장된 데이터를 꺼내서 출력
	public static void print(Set<Integer> set, String setName) {
		for(Integer data: set) {
			System.out.println("Set에 저장된 요소=>"+data);
		}	System.out.println("사이즈=>"+set.size());
		System.out.println("==================================");
	}
}
