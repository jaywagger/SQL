package API.Util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {
	public static void main(String[] args) {
		//������ ���� ���������� HashSet��ü 2�� �ۼ��ϱ�
		//set1 => 1���� 10������ ����
		HashSet<Integer> set1 = new HashSet<>();
		for(int i =1; i<=10;i++) {
			set1.add(i);
		}		
		print(set1,"set1");

		System.out.println();
		
		//set2 => 5���� 15������ ����
		HashSet<Integer> set2 = new HashSet<>();
		for(int i =5; i<=15;i++) {
			set2.add(i);
		}		
		print(set2,"set2");
		
		//set1��set2�� ������ ���
		HashSet<Integer> setall = new HashSet<>(set1);
		for(int i =5; i<=15;i++) {
			setall.add(i);
		}		
		print(setall,"set2");

		//set1�� set2 ������ ����ϱ�
		set1.retainAll(set2);
		print(set1,"������set");
	
	}
	//set�� ����� �����͸� ������ ���
	public static void print(Set<Integer> set, String setName) {
		for(Integer data: set) {
			System.out.println("Set�� ����� ���=>"+data);
		}	System.out.println("������=>"+set.size());
		System.out.println("==================================");
	}
}
