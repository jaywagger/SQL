package API.Util;

import java.util.ArrayList;
//Collection�� ������ ����� Ÿ���� generic ���·� �����Ѵ�.
//Collection Ŭ����<������Ÿ��> <<< �̰� generic
//ex. ArrayList <String>
public class ArrayListTest02 {
	public static void main(String[] args) {
		//String[] arr = new String[5]
		ArrayList<String> list = new ArrayList<String>();
		list.add("�ڹ�");			//arr[0] = "�ڹ�"
		list.add("����Ŭ");
		list.add("JDBC");
		list.add("HTMLS");
		list.add("CSS");
		
		System.out.println("=============================");
		for(int i =0; i<list.size();i++) { //arr.length
			System.out.println(list.get(i)); // arr[i]
		}
	}

}
