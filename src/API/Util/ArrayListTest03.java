package API.Util;

import java.util.ArrayList;

public class ArrayListTest03 {
	//�迭�� ArrayList�� ��ȯ�ؼ� �����ϴ� �޼ҵ�
	public static void main(String[] args) {
		String[] arr = {"java","oracle","jdbc","htmls","css","java"};
		ArrayList<String> list = changeData(arr);
		//��ȯ�Ǿ� ���ϵ� ArrayList�� ����� ���� ������ ����ϱ�
		System.out.println("<�������>");
		int size = list.size(); //�̷��� ���󿡼�  ���ҽ��� ���Ծ��Ƿ� �ε��� ������
		for (int i =0; i < size; i++) {
			System.out.println(list.get(i));
		}
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("<�����>");
		for (String data : list) {
			System.out.println(data);
		}
	}
	
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> list = new ArrayList<String>();
		//�Ű������� ���޵� �迭���� �����͸� ������ ArrayList�� �����ϴ� �ڵ�
		for (int i =0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}


}
