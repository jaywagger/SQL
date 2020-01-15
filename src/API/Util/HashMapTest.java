package API.Util;

import java.util.HashMap;
import java.util.Set;

//HashMap의 사용법
public class HashMapTest {
	public static void main(String[] args) {
		/*
		1. key와 value를 한 쌍으로 저장
			Generic으로 데이터 타입을 명시할때도 key에 대한 타입,
			value에 대한 타입을 같이 정의 해야 한다.
		*/
		
		HashMap<Integer, String> map1 = new HashMap<Integer,String>();
		map1.put(1, "servelt");
		map1.put(1, "jsp");
		map1.put(1, "spring");
		map1.put(2, "java");
		System.out.println("map에 저장된 요소의 갯수=>"+map1.size());
		System.out.println("key 1번에  저장된 값=>"+map1.get(1));
		System.out.println();
		//map에서는 key 로 요소를 구분하기 떄무에 key가 같으면 덮어쓴다

		//map에 저장된 데이터를 모두 출력하기
		HashMap<String, String> map2 = new HashMap<String,String>();
		map2.put("abc_1", "servelt");
		map2.put("dfg_2", "jsp");
		map2.put("ddd_3", "spring");
		map2.put("afd_4", "titles");
		map2.put("sss_5", "mybatis");
			//1. key목록을 추출한다
			Set<String> keylist = map2.keySet();
			for(String key: keylist) {
				String value = map2.get(key);
				System.out.println(key+":"+value);
			}
	
	}

}
