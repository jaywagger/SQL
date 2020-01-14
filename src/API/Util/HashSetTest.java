package API.Util;

import java.util.HashSet;
import java.util.Iterator;
//HashSet����ϱ� - ������ �����ϰ� ����� ������ ������
//����: �ߺ��� ������� �ʴ´�.
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); //�ڷᱸ�� ����
		set.add("Java");
		set.add("JDBC");
		set.add("Oracle");
		set.add("Html");
		set.add("Css");
		set.add("Java");
		System.out.println("������=> "+set.size());//�ߺ��� �ϳ��� ó��. �ߺ�NO
		
/*		set�� ����� ��Ҹ� ����
		1. Hashset �����͸� ǥ�� �������̽� 
		 ��� �ڷᱸ���� ��� �����͸� ��ȯ�ؼ� ���� �� �ֵ��� �����Ǵ�
		�������� ������ƽ� iterator�� ��ȯ*/
		Iterator<String> it = set.iterator();
		System.out.println();
		//2. ��ȯ�� �� ����
		while(it.hasNext()) {
			String data= it.next();
			System.out.println("���� ���"+data);
		}
		System.out.println();
		for(String data : set) {
			System.out.println("set�� ����� ���: "+data);
		}

	}

}
