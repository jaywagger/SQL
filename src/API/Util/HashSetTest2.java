package API.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//Set�� �ֿ����� ������ ������ ����� �����غ���
public class HashSetTest2 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); //�ڷᱸ�� ����
		set.add("Java");
		set.add("JDBC");
		set.add("Oracle");
		set.add("Html");
		set.add("Css");
		set.add("Java");
		//System.out.println("������=> "+set.size());//�ߺ��� �ϳ��� ó��. �ߺ�NO
		print(set,"set");
		
		HashSet<String> set2 = new HashSet<String>(set);
		set2.add("servelt");
		set2.add("jsp");
		set2.add("hadoop");
		print(set2,"set2");
		
		//�ΰ�. ������
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("Java");
		set3.add("JDBC");
		set3.add("Oracle");
		set3.add("hive");
		print(set3,"set3");
		//set�� set3�� ������ ���ϱ�
		set.retainAll(set3);
		print(set,"������set");

		

	}

	//set�� ����� �����͸� ������ ���
	public static void print(Set<String> set, String setName) {
		System.out.println("������=>"+set.size());
		for(String data: set) {
			System.out.println("Set�� ����� ���=>"+data);
			
		}
		System.out.println("==================================");
	}
}
