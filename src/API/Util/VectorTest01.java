package API.Util;

import java.util.Vector;

//Vector�� ����� ����ϴ� ��� => Vector API
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		//v.add("java");
		v.add(10);
		
		System.out.println("Vector�� �뷮: "+v.capacity());//�ѻ�����
		System.out.println("Vector�� ����� ����� ����: "+v.size());//�ѻ�����
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		for(int i=1; i<=10; i++) {
			v.add(i);
		}
		
		System.out.println("Vector�� �뷮: "+v.capacity());//�ѻ�����
		System.out.println("Vector�� ����� ����� ����: "+v.size());//�ѻ�����
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		for(int i=1; i<=10; i++) {
			v.add(i);
		}
		
		System.out.println("Vector�� �뷮: "+v.capacity());//�ѻ�����
		System.out.println("Vector�� ����� ����� ����: "+v.size());//�ѻ�����
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		for(int i=1; i<=20; i++) {
			v.add(i);
		}
		
		System.out.println("Vector�� �뷮: "+v.capacity());//�ѻ�����
		System.out.println("Vector�� ����� ����� ����: "+v.size());//�ѻ�����
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		for(int i=1; i<=40; i++) {
			v.add(i);
		}
		
		System.out.println("Vector�� �뷮: "+v.capacity());//�ѻ�����
		System.out.println("Vector�� ����� ����� ����: "+v.size());//�ѻ�����
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
	}

}