package API.Util;

import java.util.HashSet;
import java.util.Iterator;
//HashSet사용하기 - 데이터 저장하고 저장된 데이터 꺼내기
//집합: 중복을 허용하지 않는다.
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); //자료구조 생성
		set.add("Java");
		set.add("JDBC");
		set.add("Oracle");
		set.add("Html");
		set.add("Css");
		set.add("Java");
		System.out.println("사이즈=> "+set.size());//중복은 하나로 처리. 중복NO
		
/*		set에 저장된 요소를 추출
		1. Hashset 데이터를 표준 인터페이스 
		 모든 자료구조에 담긴 데이터를 변환해서 담을 수 있도록 제공되는
		추출전용 인터페아스 iterator로 변환*/
		Iterator<String> it = set.iterator();
		System.out.println();
		//2. 변환한 후 추출
		while(it.hasNext()) {
			String data= it.next();
			System.out.println("꺼낸 요소"+data);
		}
		System.out.println();
		for(String data : set) {
			System.out.println("set에 저장된 요소: "+data);
		}

	}

}
