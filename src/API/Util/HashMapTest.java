package API.Util;

import java.util.HashMap;
import java.util.Set;

//HashMap�� ����
public class HashMapTest {
	public static void main(String[] args) {
		/*
		1. key�� value�� �� ������ ����
			Generic���� ������ Ÿ���� ����Ҷ��� key�� ���� Ÿ��,
			value�� ���� Ÿ���� ���� ���� �ؾ� �Ѵ�.
		*/
		
		HashMap<Integer, String> map1 = new HashMap<Integer,String>();
		map1.put(1, "servelt");
		map1.put(1, "jsp");
		map1.put(1, "spring");
		map1.put(2, "java");
		System.out.println("map�� ����� ����� ����=>"+map1.size());
		System.out.println("key 1����  ����� ��=>"+map1.get(1));
		System.out.println();
		//map������ key �� ��Ҹ� �����ϱ� ������ key�� ������ �����

		//map�� ����� �����͸� ��� ����ϱ�
		HashMap<String, String> map2 = new HashMap<String,String>();
		map2.put("abc_1", "servelt");
		map2.put("dfg_2", "jsp");
		map2.put("ddd_3", "spring");
		map2.put("afd_4", "titles");
		map2.put("sss_5", "mybatis");
			//1. key����� �����Ѵ�
			Set<String> keylist = map2.keySet();
			for(String key: keylist) {
				String value = map2.get(key);
				System.out.println(key+":"+value);
			}
	
	}

}
