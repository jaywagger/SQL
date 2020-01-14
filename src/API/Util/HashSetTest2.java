package API.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//Set의 주요기능인 합집한 교집합 기능을 구현해보기
public class HashSetTest2 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); //자료구조 생성
		set.add("Java");
		set.add("JDBC");
		set.add("Oracle");
		set.add("Html");
		set.add("Css");
		set.add("Java");
		//System.out.println("사이즈=> "+set.size());//중복은 하나로 처리. 중복NO
		print(set,"set");
		
		HashSet<String> set2 = new HashSet<String>(set);
		set2.add("servelt");
		set2.add("jsp");
		set2.add("hadoop");
		print(set2,"set2");
		
		//두개. 합집합
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("Java");
		set3.add("JDBC");
		set3.add("Oracle");
		set3.add("hive");
		print(set3,"set3");
		//set과 set3의 교집합 구하기
		set.retainAll(set3);
		print(set,"교집합set");

		

	}

	//set에 저장된 데이터를 꺼내서 출력
	public static void print(Set<String> set, String setName) {
		System.out.println("사이즈=>"+set.size());
		for(String data: set) {
			System.out.println("Set에 저장된 요소=>"+data);
			
		}
		System.out.println("==================================");
	}
}
